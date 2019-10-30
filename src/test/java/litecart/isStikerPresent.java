package litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class isStikerPresent extends baseTest{

    @Before
    public void start() throws Exception {
        this.init();
    }

    @Test
    public void login() throws Exception{
        driver.get("http://localhost/litecart/en/");

        List<WebElement> products = driver.findElements(By.cssSelector(".product"));
        for(int i=0; i<products.size(); i++) {
            assertEquals(1, products.get(i).findElements(By.cssSelector(".sticker")).size());
        }

    }

    @After
    public void tearDown() throws Exception {
    }
}
