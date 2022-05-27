// https://refactoring.guru/pl/design-patterns/builder
// https://refactoring.guru/pl/design-patterns/factory-method


package Market.participants;

import Market.participants.buyer.Buyer;
import Market.participants.seller.Seller;
import Market.products.Product;
import Market.products.ProductsFactory;
import Market.products.ProductsGenerator;

import java.util.*;

public class ParticipantGenerator {
    private final Random random = new Random();
    private final List<Integer> items = new ArrayList<>();
    private final ProductsGenerator productsGenerator;

    public ParticipantGenerator() {
        this.productsGenerator = new ProductsGenerator();
        for (int i = 0; i < productsGenerator.getProductsAmount(); i++) {
            items.add(i);
        }
    }

    public ParticipantGenerator(ProductsGenerator productsGenerator) {
        this.productsGenerator = productsGenerator;
        for (int i = 0; i < productsGenerator.getProductsAmount(); i++) {
            items.add(i);
        }
    }

    public ArrayList<Seller> generateSellers(int amount) {
        ArrayList<Seller> result = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Collections.shuffle(items);
            Integer amount_of_items = random.nextInt(1, 7);
            Double primeMargin = Math.round(random.nextDouble() * 100.0) / 100.0 + 0.01;
            Seller seller = new Seller(primeMargin);
            for (int j = 0; j < amount_of_items; j++) {
                seller.addProduct(productsGenerator.getProduct(items.get(j)));
            }
            result.add(seller);
        }
        return result;
    }

    public ArrayList<Buyer> generateBuyers(int amount) {
        ArrayList<Buyer> result = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Collections.shuffle(items);
            Integer amount_of_items = random.nextInt(2, 7);
            Double primeMargin = Math.round(random.nextDouble() * 100.0) / 100.0 + 0.1;
            Buyer buyer = new Buyer(primeMargin);
            for (int j = 0; j < amount_of_items; j++) {
                buyer.addProduct(productsGenerator.getProduct(items.get(j)));
            }
            result.add(buyer);
        }
        return result;
    }
}
