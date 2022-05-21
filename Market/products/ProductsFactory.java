package Market.products;

public class ProductsFactory {
    public Product getProduct(String name) {
        return switch (name) {
            case "Gold" -> new Product("Gold", 1800, 0);
            case "Silver" -> new Product("Silver", 120, 0);
            default -> new Product("Unknown", 1, 0);
        };
    }

    public Product makeProduct(String name, Double productionCost){
        return new Product(name, productionCost);
    }
}
