package Market.publisher;

import Market.participants.Participant;

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
        users.add(listener);
    }

    public void unsubscribe(String eventType, Participant listener) {
        List<Participant> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, double data) {
        List<Participant> users = listeners.get(eventType);
        for (Participant listener : users) {
            listener.update(eventType, data);
        }
    }
}
