// https://refactoring.guru/pl/design-patterns/builder
// https://refactoring.guru/pl/design-patterns/factory-method


package Market.participants;

import Market.participants.buyer.Buyer;
import Market.participants.seller.Seller;
import Market.products.Product;

public class ParticipantBuilder {
    public Seller seller(double minMargin, Product... products) {
        Seller s = new Seller(minMargin);
        for(Product p: products){
            p.setMargin(minMargin);
            s.addProduct(p);
        }
        return s;
    }

    public Buyer builder(double maxPrice, Product... products){
        Buyer b = new Buyer(maxPrice);
        for(Product p: products){
            p.setMargin(maxPrice);
            b.addProduct(p);
        }
        return b;
    }
}
