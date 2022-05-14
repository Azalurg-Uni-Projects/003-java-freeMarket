package Market.participants.buyer;

import Market.participants.Participant;
import Market.products.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


public class Buyer extends Participant {
    private final double maxPrice; // in %


    public Buyer(double maxPrice) {
        this.maxPrice = maxPrice;
        this.productsList = new ArrayList<>();
    }

    public void addProduct(Product p){
        p.setMargin(maxPrice);
        productsList.add(p);
    }


}
