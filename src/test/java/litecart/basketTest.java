package litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class basketTest extends baseTest {
    Integer N=3;

    @Before
    public void start() throws Exception {
        this.init();
        driver.get("http://localhost:8080/litecart/en/");
    }

    @Test
    public void basketTest() throws Exception {

        for(int i=0;i<N;i++) {
            driver.findElement(By.cssSelector("[id=logotype-wrapper] a")).click();
            goToProductDetailPage(driver,i+1);
            addProductToBasket(driver);
        }

        driver.findElement(By.xpath("//*[text()='Checkout »']")).click();

        for(int i=0;i<N;i++) {
            removeProduct(driver);
        }

        assertEquals(driver.findElement(By.cssSelector("em")).getText(),"There are no items in your cart.");

    }

    private void assertTrue() {
    }

    @After
    public void tearDown() throws Exception {
    }


    void addProductToBasket(WebDriver driver) {
        WebElement cart = driver.findElement(By.cssSelector(("span[class=quantity]")));
        Integer priceCart = Integer.parseInt(cart.getText());
        if(isElementPresent(driver,By.cssSelector("[name*=options]"))) {
            new Select(driver.findElement(By.cssSelector("[name*=options]"))).selectByValue("Small");
        }
        driver.findElement(By.cssSelector(("[name=add_cart_product]"))).click();
        wait.until(ExpectedConditions.textToBePresentInElement(cart,Integer.toString(priceCart+1)));
    }

    void removeProduct(WebDriver driver) {
        if(isElementPresent(driver,By.cssSelector("[class=shortcut] a"))) {
            driver.findElement(By.cssSelector(("[class=shortcut] a"))).click();
        }
        WebElement tableProduct = driver.findElement(By.cssSelector(("[class*=dataTable]")));
        driver.findElement(By.cssSelector(("[name=remove_cart_item]"))).click();
        wait.until(ExpectedConditions.stalenessOf(tableProduct));
    }


    void goToProductDetailPage(WebDriver driver, int i) {
        //wait.until(presenceOfElementLocated(By.cssSelector(("li[class*=product] a.link"))));
        List<WebElement> product = new ArrayList<>();
        product=driver.findElements(By.cssSelector(("li[class*=product] a.link")));
        product.get(i).click();
        wait.until(ExpectedConditions.stalenessOf(product.get(0)));
    }

}
