package Market.participants.buyer;

import Market.participants.Participant;
import Market.participants.seller.Seller;
import Market.products.Product;

import java.util.ArrayList;


public class Buyer extends Participant {

    public Buyer(double primeMargin) {
        super(primeMargin);
    }

    public boolean updateTransactions(String product_name, Double price, Seller seller) {
        //check if want to buy
        Product product = productHashMap.get(product_name);
        if (product != null) {
            if (product.getPrice() > price && !product.isTransactionDone()) {
                //buy it
                seller.sell(product_name);
                product.downMargin(0.01);
                product.imSold();
                productHashMap.replace(product_name, product);
                return true;
            }
        }
        // todo Move it to buyer
        return false;
    }

    @Override
    public void dayEnd() {
        productHashMap.forEach((key, value) -> {
            if (!value.isTransactionDone() && value.getMargin() < margin) {
                value.upMargin(0.01);
            }
            value.setTransactionDone(false);
        });
    }

    @Override
    public void monthEnd() {

    }

    @Override
    public void calculateMargin() {
        margin = primeMargin - taxes;
    }
}
