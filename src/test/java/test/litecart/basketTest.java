package test.litecart;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class basketTest extends baseTest {
    Integer N=3;

    @Test
    public void basketTest() throws Exception {
        for(int i=0;i<N;i++) {
            app.goToProductDetailPage(i+1);
            app.addProductToBasket();
        }
        app.goToBasket();
        for(int i=0;i<N;i++) {
            app.removeProduct();
        }
        assertEquals(app.getTextFromEmptyBasket(),"There are no items in your cart.");
    }

    @After
    public void tearDown() throws Exception {
    }




}
