package Market.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    public final String name;
    private final double productionCost;
    public double price;

    public Product(String name, double productionCost) {
        this.name = name;
        this.productionCost = productionCost;
        this.price = productionCost;
    }

    public void calculatePrice(double margin){
        this.price = productionCost * (1+margin);

    }
}

