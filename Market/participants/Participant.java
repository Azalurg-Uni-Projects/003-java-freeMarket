package Market.participants;

import Market.participants.seller.Seller;
import Market.products.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
abstract public class Participant {
    protected HashMap<String, Product> productHashMap = new HashMap<String, Product>();
    protected double taxes;
    protected double margin;
    protected final double primeMargin;

    protected Participant(double primeMargin) {
        this.primeMargin = primeMargin;
        this.margin = primeMargin;
    }


    public void addProduct(Product p){
        p.setMargin(margin);
        productHashMap.put(p.getName(), p);
    }

    public void printProductsList() {
        System.out.println("productsList=\n" + productHashMap);
    }

    public void updateTaxes(double data) {
        this.taxes = data;
        this.calculateMargin();
    }

    abstract public void dayEnd();
    abstract public void monthEnd();
    abstract public void calculateMargin();


}
