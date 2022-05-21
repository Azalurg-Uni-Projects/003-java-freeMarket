package Market.participants;

import Market.products.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
abstract public class Participant {
    public HashMap<String, Product> productHashMap = new HashMap<String, Product>();
    private double taxes;

    public void update(String eventType, double data) {
        this.taxes = data;
    }

    abstract public void addProduct(Product p);

    public void printProductsList() {
        System.out.println("productsList=\n" + productHashMap);
    }
}
