package Market.products;

public class ProductsBuilder {
    public Product bitcoin(){
        return new Product("Bitcoin", 30000);
    }

    public Product ethereum(){
        return new Product("Ethereum", 2000);
    }

    public Product gold(){
        return new Product("Gold", 1800);
    }
}
