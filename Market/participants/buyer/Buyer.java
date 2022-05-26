package Market.participants.buyer;

import Market.participants.Participant;
import Market.products.Product;

import java.util.ArrayList;


public class Buyer extends Participant {

    public Buyer(double primeMargin) {
        super(primeMargin);
    }

    @Override
    public void dayEnd() {
        productHashMap.forEach((key, value) -> {
            if (!value.isTransactionDone() && value.getMargin() < margin){
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
