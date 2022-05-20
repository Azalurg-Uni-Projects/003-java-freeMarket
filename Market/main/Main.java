package Market.main;

import Market.participants.seller.Seller;
import Market.products.Product;
import Market.products.examples.Bitcoin;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Seller s = new Seller(0.1);
        Product p = new Bitcoin();
        s.addProduct(p);
        ArrayList<Product> lista = s.productsList;
        Product product_from_list = lista.get(0);
        System.out.println(product_from_list.getClass());
        System.out.println(product_from_list);

    }
}
