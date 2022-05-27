package Market.products;

public class ProductsFactory {

    public Product getProduct(String name) {
        return switch (name) {
            case "Gold" -> new Product("Gold", 1800);
            case "Silver" -> new Product("Silver", 20);
            case "Copper" -> new Product("Copper", 90);
            case "Platinum" -> new Product("Platinum", 1000);
            case "Oil" -> new Product("Oil", 100);
            case "Gas" -> new Product("Gas", 10);
            default -> new Product("Unknown", 1);
        };
    }

    public Product getProduct(int position) {
        return switch (position) {
            case 1 -> new Product("Gold", 1800);
            case 2 -> new Product("Silver", 20);
            case 3 -> new Product("Copper", 90);
            case 4 -> new Product("Platinum", 1000);
            case 5 -> new Product("Oil", 100);
            case 6 -> new Product("Gas", 10);
            default -> new Product("Unknown", 1);
        };
    }

    public Product makeProduct(String name, Double productionCost) {
        return new Product(name, productionCost);
    }
}
