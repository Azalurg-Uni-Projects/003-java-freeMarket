package Market.game;

import Market.bank.Bank;
import Market.participants.ParticipantGenerator;
import Market.participants.buyer.Buyer;
import Market.participants.seller.Seller;
import Market.products.Product;
import Market.publisher.MarketPublisher;
import Market.publisher.TaxesPublisher;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private final Bank bank;
    private final int days;
    private final int months;

    private ArrayList<Seller> sellers;
    private ArrayList<Buyer> buyers;
    private MarketPublisher marketPublisher;
    private TaxesPublisher taxesPublisher;

    public Game(int buyers_amount, int sellers_amount, int bank_target, int days, int months) {
        this.days = days;
        this.months = months;
        this.taxesPublisher = new TaxesPublisher();
        this.marketPublisher = new MarketPublisher();
        ParticipantGenerator pg = new ParticipantGenerator();

        this.bank = new Bank(bank_target, this.taxesPublisher);
        this.sellers = pg.generateSellers(sellers_amount);
        this.buyers = pg.generateBuyers(buyers_amount);
        // Preparation
        for(Buyer buyer : buyers){
            for(String product_name: buyer.getProductHashMap().keySet()){
                marketPublisher.subscribe(product_name, buyer);
                taxesPublisher.subscribe(buyer);
            }
        }
        for(Seller seller : sellers){
            taxesPublisher.subscribe(seller);
        }
    }

    public void run(){
        for( int m = 0; m < months; m++){
            // Do at beginning of every month
            bank.propagateTaxes();
            Collections.shuffle(sellers);
            // todo shuffle buyers in publisher
            for(int d = 0; d < days; d++){
                for(Seller seller : sellers){
                    for(Product product : seller.getProductHashMap().values()) {
                        marketPublisher.notify(product.getName(), seller, product);
                    }
                }
               dayEnd();
            }
            monthEnd();
        }
    }

    private void dayEnd(){
        for(Seller seller :sellers){
            seller.dayEnd();
        }
        for(Buyer buyer :buyers){
            buyer.dayEnd();
        }
    }

    private void monthEnd(){
        for(Buyer buyer :buyers){
            buyer.monthEnd();
        }
        for(Seller seller:sellers) {
            bank.collectTaxes(seller);
            seller.monthEnd();
        }
        bank.matchTaxes();
        bank.monthEnd();
    }

    public void addSeller(Seller s){
        sellers.add(s);
    }

    public void addBuyer(Buyer b){
        buyers.add(b);
    }

    public void start(){

    }
}
