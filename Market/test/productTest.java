package Market.test;

import Market.products.Product;
import Market.products.ProductsFactory;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class productTest {
    private ProductsFactory pf;

    @Before
    public void setup(){
        pf = new ProductsFactory();
    }

    @Test
    public void createProduct1(){
        Product p = new Product("Car", 100);
        assertEquals("Create Product without margin", 0, p.getMargin(), 1);
    }

    @Test
    public void createProduct2(){
        Product p = new Product("Car", 100, 0.12);
        assertEquals("Create Product with margin", 0.12, p.getMargin(), 2);
    }

    @Test
    public void marginUpdate1(){
        Product p = new Product("Car", 100);
        p.setMargin(1);
        assertEquals("Set margin simple test", 1, p.getMargin(), 1);
    }

    @Test
    public void marginUpdate2(){
        Product p = new Product("Car", 100);
        p.setMargin(1);
        assertEquals("Set margin - price check", 200, p.getPrice(), 1);
    }

    @Test
    public void productFactory1(){
        Product p = pf.getProduct("Gold");
        assertEquals("Products factory simple test", 1800, p.getProductionCost(), 1);
    }

    @Test
    public void productFactory2(){
        Product p = pf.makeProduct("Car", 100.0);
        assertEquals("Make custom product", 100, p.getProductionCost(), 1);
    }

    @Test
    public void productFactory3(){
        Product p = pf.getProduct("silver");
        assertEquals("Wrong input", 1, p.getProductionCost(), 1);
    }

}
