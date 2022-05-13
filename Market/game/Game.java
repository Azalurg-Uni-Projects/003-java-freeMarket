package Market.game;

import Market.participants.bank.Bank;
import Market.participants.buyer.Buyer;
import Market.participants.seller.Seller;

import java.util.ArrayList;

public class Game {
    public Bank bank = new Bank(1000000);
    public ArrayList<Seller> sellers;
    public ArrayList<Buyer> buyers;
    public final int time;
    public double dailyTradingVolume = 0;

    public Game(int time, int sellersAmount, int buyersAmount) {
        this.time = time;
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
