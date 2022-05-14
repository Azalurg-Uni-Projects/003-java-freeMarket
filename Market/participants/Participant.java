package Market.participants;

import Market.products.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
abstract public class Participant {
    public ArrayList<Product> productsList;
    private double taxes;

    public void update(String eventType, double data) {
        this.taxes = data;
    }

    abstract public void addProduct(Product p);

}
