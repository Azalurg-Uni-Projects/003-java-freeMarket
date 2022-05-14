package Market.participants.seller;

import Market.participants.Participant;
import Market.products.Product;

import java.util.HashMap;
import java.util.Map;

public class Seller implements Participant {
    public Map<String, Product> productsMap;
    private double taxes;
    private double minMargin;

    public Seller(double minMargin){
        this.productsMap =  new HashMap<>();
        this.minMargin = minMargin;

    }

    @Override
    public void update(String eventType, double data) {
        this.taxes = data;
    }
}
