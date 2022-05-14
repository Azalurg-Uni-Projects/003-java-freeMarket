package Market.participants.seller;

import Market.participants.Participant;
import Market.products.Product;

import java.util.ArrayList;

public class Seller extends Participant {
    private double minMargin;

    public Seller(double minMargin) {
        this.productsList = new ArrayList<>();
        this.minMargin = minMargin;

    }

    public void addProduct(Product p){
        p.setMargin(minMargin);
        productsList.add(p);
    }
}
