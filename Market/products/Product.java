package Market.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private final double productionCost;
    private final String name;
    private double price;
    private double margin; // in %
    private boolean transactionDone;


    public Product(String name, double productionCost, double margin) {
        this.name = name;
        this.productionCost = productionCost;
        this.price = productionCost;
        this.margin = margin;
        this.calculatePrice();
        this.transactionDone = false;
    }

    public Product(String name, double productionCost) {
        this.name = name;
        this.productionCost = productionCost;
        this.price = productionCost;
        this.margin = 0;
        this.calculatePrice();
        this.transactionDone = false;
    }

    @Override
    public String toString() {
        return "{" +
                "productionCost=" + productionCost +
                ", price=" + price +
                ", margin=" + margin +
                ", transactionDone=" + transactionDone +
                "}\n";
    }

    public void setMargin(double margin) {
        this.margin = margin;
        this.calculatePrice();
    }

    public void calculatePrice(){
        this.price = productionCost * (1+margin);

    }
}

