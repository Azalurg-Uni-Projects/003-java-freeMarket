package Market.main;

import Market.participants.seller.Seller;
import Market.products.Product;
import Market.products.ProductsFactory;
import Market.products.examples.Bitcoin;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ProductsFactory productsFactory = new ProductsFactory();
        Seller s = new Seller(0.1);
        Product p = productsFactory.getProduct("Silver");
        s.addProduct(p);
        s.addProduct(productsFactory.getProduct("Gold"));
        s.addProduct(productsFactory.getProduct("Silver"));
        s.sell("Gold");
        s.sell("Silver");
        s.sell("Silver");
        s.printProductsList();


    }
}
