package Market.participants.buyer;

import Market.participants.Participant;
import Market.products.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Buyer implements Participant {
    private final double maxTarget;
    private double target;
    private ArrayList<Product> wantToBuy;
    private double taxes;


    public Buyer(double minTarget) {
        this.maxTarget = minTarget;
        this.target = minTarget;
        this.taxes = 0;
    }

    public void addProduct(Product p){
        wantToBuy.add(p);
    }

    @Override
    public void update(String eventType, double data) {
        this.taxes = data;
    }
}
