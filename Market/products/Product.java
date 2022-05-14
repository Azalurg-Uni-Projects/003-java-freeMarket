package Market.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    public final double productionCost;
    public final String name;
    public double price;
    public double margin; // in %
    public boolean transactionDone;


    public Product(String name, double productionCost, double margin) {
        this.name = name;
        this.productionCost = productionCost;
        this.price = productionCost;
        this.margin = margin;
        this.calculatePrice();
        this.transactionDone = false;
    }

    public void setMargin(double margin) {
        this.margin = margin;
        this.calculatePrice();
    }

    public void calculatePrice(){
        this.price = productionCost * (1+margin);

    }
}

