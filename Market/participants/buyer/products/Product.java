package Market.participants.buyer.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    public final String name;
    public final String type;
    public double price;

    public Product(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
}

public class Rocket extends Product{

    public Rocket() {
        super("Rocket", "Space", 100);
    }
}

public class SpaceStation extends Product{

    public SpaceStation() {
        super("SpaceStation", "Space", 1000);
    }
}
