package Market.products;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductsGenerator {
    private final ArrayList<String> productsNames = new ArrayList<>();
    private final ArrayList<Double> prductsCost = new ArrayList<>();

    public ProductsGenerator() {
        String[] names = new String[]{"Gold", "Silver", "Copper", "Platinum", "Oil", "Gas"};
        Double[] costs = new Double[]{1800.0, 20.0, 90.0, 1000.0, 100.0, 10.0, 1.0};
        productsNames.addAll(Arrays.asList(names));
        prductsCost.addAll(Arrays.asList(costs));
    }

    public void addProduct(String name, Double cost) {
        this.productsNames.add(name);
        this.prductsCost.add(cost);
    }

    public void addProducts(Product p) {
        this.productsNames.add(p.getName());
        this.prductsCost.add(p.getProductionCost());
    }

    public int getProductsAmount() {
        return productsNames.size();
    }

    public Product getProduct(int place) {
        if (place >= productsNames.size()) {
            return new Product("Unknown", 1);
        }
        return new Product(productsNames.get(place), prductsCost.get(place));
    }

}
