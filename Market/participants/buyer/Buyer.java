package Market.participants.buyer;

import Market.products.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Buyer {
    private final double maxTarget;
    private double target;
    private ArrayList<Product> wantToBuy;


    public Buyer(double minTarget) {
        this.maxTarget = minTarget;
        this.target = minTarget;
    }

    public void addProduct(Product p){
        wantToBuy.add(p);
    }
}
