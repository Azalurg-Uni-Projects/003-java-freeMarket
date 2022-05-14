package Market.game;

import Market.participants.bank.Bank;
import Market.participants.buyer.Buyer;
import Market.participants.seller.Seller;
import Market.publisher.Publisher;

import java.util.ArrayList;

public class Game {
    public Bank bank;
    public ArrayList<Seller> sellers;
    public ArrayList<Buyer> buyers;
    public final int time;
    public double dailyTradingVolume = 0;
    public Publisher publisher;

    public Game(int time) {
        this.bank = new Bank(1000000);
        this.time = time;
        this.publisher = new Publisher("taxes");
        sellers.add()
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
