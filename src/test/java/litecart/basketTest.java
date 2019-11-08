package litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.ArrayList;
import java.util.List;

public class basketTest extends baseTest {


    @Before
    public void start() throws Exception {
        this.init();
        driver.get("http://litecart.stqa.ru/ru/");
    }

    @Test
    public void basketTest() throws Exception {

        goToProductDetailPage(driver,1);
        addProductToBasket(driver);

        driver.findElement(By.cssSelector("[id=logotype-wrapper] a")).click();
        goToProductDetailPage(driver,2);
        addProductToBasket(driver);

        driver.findElement(By.cssSelector("[id=logotype-wrapper] a")).click();
        goToProductDetailPage(driver,3);
        addProductToBasket(driver);

        //Thread.sleep(6000L);
        driver.findElement(By.xpath("//*[text()='Checkout »']")).click();
       // Thread.sleep(2000L);

        removeProduct(driver);
        removeProduct(driver);
        removeProduct(driver);

        driver.findElement(By.cssSelector("[id=logotype-wrapper] a")).click();


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
