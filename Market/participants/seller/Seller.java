package Market.participants.seller;

import Market.participants.Participant;
import Market.products.Product;

import java.util.HashMap;
import java.util.Map;

public class Seller implements Participant {
    public Map<Product, Double> productsMap;
    private double taxes;

    public Seller(Product... products){
        productsMap =  new HashMap<>();
        for (Product product: products){
            this.productsMap.put(product, 0.1);
        }
    }

    @Override
    public void update(String eventType, double data) {
        this.taxes = data;
    }
}
