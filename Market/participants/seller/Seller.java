package Market.participants.seller;

import Market.participants.Participant;
import Market.products.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter
@Setter
public class Seller extends Participant {
    private final double minMargin;
    private double earnedMoney;

    public Seller(double minMargin) {
        this.minMargin = minMargin;
        this.earnedMoney = 0;
    }

    public void addProduct(Product p){
        p.setMargin(minMargin);
        productHashMap.put(p.getName(), p);
    }

    public boolean sell(String product_name){
        Product to_sell = productHashMap.get(product_name);
        if(to_sell == null){
               return false;
        }
        this.earnedMoney = this.earnedMoney + (to_sell.getPrice() - to_sell.getProductionCost());
        to_sell.upMargin(0.008);
        to_sell.setTransactionDone(true);
        return true;
    }
    //todo implement reset
}
