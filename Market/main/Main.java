package Market.main;

import Market.participants.buyer.Buyer;
import Market.participants.seller.Seller;
import Market.products.Product;
import Market.products.ProductsFactory;
import Market.products.examples.Bitcoin;
import Market.publisher.Publisher;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ProductsFactory productsFactory = new ProductsFactory();
        Seller s = new Seller(0.1);;
        s.addProduct(productsFactory.getProduct("Silver"));
        s.printProductsList();
        // ===========================
        Publisher publisher = new Publisher();
        Buyer b1 = new Buyer(1);
        b1.addProduct(productsFactory.getProduct("Silver"));
        publisher.subscribe("Silver", b1);

        Buyer b2 = new Buyer(1);
        b2.addProduct(productsFactory.getProduct("Silver"));
        publisher.subscribe("Silver", b2);

        System.out.println(publisher);
        publisher.notify("Silver", s, s.getProductHashMap().get("Silver"));
        s.printProductsList();
        publisher.notify("Silver", s, s.getProductHashMap().get("Silver"));
        s.printProductsList();
        publisher.notify("Silver", s, s.getProductHashMap().get("Silver"));
        s.printProductsList();
        publisher.notify("Silver", s, s.getProductHashMap().get("Silver"));
        s.printProductsList();


    }
}
