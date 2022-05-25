package Market.publisher;

import Market.participants.Participant;
import Market.participants.seller.Seller;
import Market.products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Publisher {
    Map<String, List<Participant>> listeners = new HashMap<>();


    public Publisher(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, Participant listener) {
        List<Participant> users = listeners.get(eventType);
        if (users == null){
            users = new ArrayList<Participant>();
            users.add(listener);
            listeners.put(eventType, users);

        }else{
            users.add(listener);
        }
    }

    public void unsubscribe(String eventType, Participant listener) {
        List<Participant> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, Seller s, Product p) {
        List<Participant> users = listeners.get(eventType);
        for (Participant listener : users) {
           boolean response = listener.updateTransactions(eventType, p.getPrice(), s);
            if (response){
                break;
            }
        }
    }

    public void notify(String eventType, double taxes) {
        List<Participant> users = listeners.get(eventType);
        for (Participant listener : users) {
            listener.updateTaxes(taxes);
        }
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "listeners=" + listeners +
                '}';
    }
}
