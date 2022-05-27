package Market.participants.seller;

import Market.participants.Participant;
import Market.products.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seller extends Participant {
    private double earnedMoney;

    public Seller(double primeMargin) {
        super(primeMargin);
        this.earnedMoney = 0;
    }

    public boolean sell(String product_name) {
        Product to_sell = productHashMap.get(product_name);
        if (to_sell == null) {
            return false;
        }
        this.earnedMoney = this.earnedMoney + (to_sell.getPrice() - to_sell.getProductionCost());
        to_sell.upMargin(0.008);
        to_sell.setTransactionDone(true);
        return true;
    }

    @Override
    public void dayEnd() {
        productHashMap.forEach((key, value) -> {
            if (!value.isTransactionDone() && value.getMargin() > margin) {
                value.downMargin(0.002);
            }
            value.setTransactionDone(false);
        });
    }

    @Override
    public void monthEnd() {
        this.earnedMoney = 0;
    }

    @Override
    public void calculateMargin() {
        margin = primeMargin + taxes;
    }
}
