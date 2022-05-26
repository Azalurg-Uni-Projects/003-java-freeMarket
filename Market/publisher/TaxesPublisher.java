package Market.publisher;

import Market.participants.Participant;

import java.util.*;

public class TaxesPublisher {
    Set<Participant> listeners = new HashSet<Participant>();

    public void subscribe(Participant listener) {
        listeners.add(listener);
    }

    public void unsubscribe(Participant listener) {
        listeners.remove(listener);
    }

    public void notify(double taxes) {
        for (Participant listener : listeners) {
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
