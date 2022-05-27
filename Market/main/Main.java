package Market.main;

import Market.game.Game;
import Market.game.GameBuilder;
import Market.participants.buyer.Buyer;
import Market.participants.seller.Seller;
import Market.products.ProductsFactory;
import Market.publisher.MarketPublisher;

public class Main {
    public static void main(String[] args) {
//        ProductsFactory productsFactory = new ProductsFactory();
//        Seller s = new Seller(0.1);;
//        s.addProduct(productsFactory.getProduct("Silver"));
//        s.printProductsList();
//        // ===========================
//        MarketPublisher publisher = new MarketPublisher();
//        Buyer b1 = new Buyer(1);
//        b1.addProduct(productsFactory.getProduct("Silver"));
//        publisher.subscribe("Silver", b1);
//
//        Buyer b2 = new Buyer(1);
//        b2.addProduct(productsFactory.getProduct("Silver"));
//        publisher.subscribe("Silver", b2);
//
//        System.out.println(publisher);
//        publisher.notify("Silver", s, s.getProductHashMap().get("Silver"));
//        s.printProductsList();
//        publisher.notify("Silver", s, s.getProductHashMap().get("Silver"));
//        s.printProductsList();
//        publisher.notify("Silver", s, s.getProductHashMap().get("Silver"));
//        s.printProductsList();
//        publisher.notify("Silver", s, s.getProductHashMap().get("Silver"));
//        s.printProductsList();

        GameBuilder gameBuilder = new GameBuilder();
        gameBuilder.setMonths(5 * 12);
        gameBuilder.setBuyers_amount(1000);
        gameBuilder.setSellers_amount(100);
        Game game = gameBuilder.createGame();
        game.run();


    }
}
