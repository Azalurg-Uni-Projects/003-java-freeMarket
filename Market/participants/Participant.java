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
    private double taxes;

    public void updateTaxes(double data) {
        this.taxes = data;
    }
    public boolean updateTransactions(String product_name, Double price, Seller seller){
        //check if want to buy
        Product product = productHashMap.get(product_name);
        if (product != null){
            if (product.getPrice() > price && !product.isTransactionDone()){
                //buy it
                seller.sell(product_name);
                product.downMargin(0.01);
                product.imSold();
                productHashMap.replace(product_name, product);
                return true;
            }
        }
        // todo Implementacja max-price
        return false;
    }

    abstract public void addProduct(Product p);

    public void printProductsList() {
        System.out.println("productsList=\n" + productHashMap);
    }
}
