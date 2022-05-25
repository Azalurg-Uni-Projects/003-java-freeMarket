package Market.participants.buyer;

import Market.participants.Participant;
import Market.products.Product;

import java.util.ArrayList;


public class Buyer extends Participant {
    private final double maxPrice; // in %


    public Buyer(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void addProduct(Product p){
        p.setMargin(maxPrice);
        productHashMap.put(p.getName(), p);
    }
    //todo implement reset
}
