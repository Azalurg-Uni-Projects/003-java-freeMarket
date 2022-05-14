package Market.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    public final String name;
    private final double productionCost;
    public double price;
    public double margin; // in %


    public Product(String name, double productionCost, double margin) {
        this.name = name;
        this.productionCost = productionCost;
        this.price = productionCost;
        this.margin = margin;
        this.calculatePrice();
    }

    public void setMargin(double margin) {
        this.margin = margin;
        this.calculatePrice();
    }

    public void calculatePrice(){
        this.price = productionCost * (1+margin);

    }
}

