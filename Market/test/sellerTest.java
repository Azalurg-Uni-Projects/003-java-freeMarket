package Market.test;

import Market.participants.seller.Seller;
import Market.products.ProductsFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class sellerTest {
    private Seller s;
    private ProductsFactory pf;

    @Before
    public void setup(){
        s = new Seller(2);
        pf = new ProductsFactory();
    }

    @Test
    public void addProduct(){
        s.addProduct(pf.getProduct("Silver"));
        assertEquals("Add product", 1, s.getProductHashMap().size());
    }

    @Test
    public void setMargin(){
        s.addProduct(pf.getProduct("Silver"));
        assertEquals("Set margin", 2, s.getProductHashMap().get("Silver").getMargin(), 0);
    }

    @Test
    public void sellProduct(){
        s.addProduct(pf.getProduct("Silver"));;
        boolean response = s.sell("Silver");

        assertTrue("Sell goods", response);
    }

    @Test
    public void sellProductNoGoods(){
        boolean response = s.sell("Silver");

        assertFalse("Can't sell goods", response);
    }

    @Test
    public void earningMoney(){
        s.addProduct(pf.getProduct("Gold"));
        int i = 10;
        while (i > 0){
            i--;
            s.sell("Gold");
        }
        assertEquals("Earning money - rising margin", 36648.0, s.getEarnedMoney(), 1);
    }
}
