package Market.participants.seller;

import Market.participants.Participant;
import Market.products.Product;

import java.util.ArrayList;
import java.util.Objects;

public class Seller extends Participant {
    private double minMargin;

    public Seller(double minMargin) {
//        this.productsList = new ArrayList<>();
        this.minMargin = minMargin;

    }

    public void addProduct(Product p){
        p.setMargin(minMargin);
        productsList.add(p);
    }

//    public boolean sell(String product_name){
//        Product to_sell = productsList.stream().findFirst(product -> Objects.equals(product.getName(), product_name));
//        if(to_sell.getClass() != Product.class){
//               return false;
//        }
//        to_sell.setMargin(to_sell.getMargin() + 0.05);
//        to_sell.transactionDone = true;
//        return true;
//    }
}
