package Market.products.examples;

import Market.products.Product;

public class Bitcoin extends Product {

    public Bitcoin(double margin) {
        super("Bitcoin", 30000, margin);
    }
    public Bitcoin() {super("Bitcoin", 30000, 0);}
}
