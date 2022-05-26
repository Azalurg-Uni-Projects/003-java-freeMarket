package Market.publisher;

import Market.participants.buyer.Buyer;
import Market.participants.seller.Seller;
import Market.products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketPublisher {
    Map<String, List<Buyer>> listeners = new HashMap<>();


    public MarketPublisher(String... goods) {
        for (String good : goods) {
            this.listeners.put(good, new ArrayList<>());
        }
    }

    public void subscribe(String goodName, Buyer listener) {
        List<Buyer> buyers = listeners.get(goodName);
        if (buyers == null){
            buyers = new ArrayList<Buyer>();
            buyers.add(listener);
            listeners.put(goodName, buyers);

        }else{
            buyers.add(listener);
        }
    }

    public void unsubscribe(String goodName, Buyer listener) {
        List<Buyer> buyers = listeners.get(goodName);
        buyers.remove(listener);
    }

    public void notify(String goodName, Seller seller, Product product) {
        List<Buyer> buyers = listeners.get(goodName);
        for (Buyer listener : buyers) {
           boolean response = listener.updateTransactions(goodName, product.getPrice(), seller);
            if (response){
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "listeners=" + listeners +
                '}';
    }
}
