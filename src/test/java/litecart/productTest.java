package litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class productTest extends baseTest {

    @Before
    public void start() throws Exception {
        this.init();
        driver.get("http://localhost:8080/litecart/en/");
    }

    @Test
    public void nameProduct() throws Exception{

        String nameProduct = null;
        WebElement product = driver.findElement(By.cssSelector("div[id=box-campaigns]"));

        nameProduct=product.findElement(By.cssSelector("[class=name]")).getText();

        product.findElement(By.cssSelector(("[class=link]"))).click();

        String productDetailName = driver.findElement(By.cssSelector("h1")).getText();

        assertEquals(nameProduct,productDetailName);

    }


    @Test
    public void productPrice() throws Exception{

        String regularPrice = driver.findElement(By.cssSelector("[class=regular-price]")).getText();
        String campaignPrice = driver.findElement(By.cssSelector("[class=campaign-price]")).getText();

        driver.findElement(By.cssSelector(("div[id=box-campaigns] [class=link]"))).click();

        String regularPriceDetail = driver.findElement(By.cssSelector("[class=regular-price]")).getText();
        String campaignPriceDetail = driver.findElement(By.cssSelector("[class=campaign-price]")).getText();

        //разделить на 2 теста
        assertEquals(regularPrice,regularPriceDetail);
        assertEquals(campaignPrice,campaignPriceDetail);


    }

    @Test
    public void productRegularPriceStyle() throws Exception{
        String priceColor = driver.findElement(By.cssSelector("[class=regular-price]")).getCssValue("color");
        String priceDecoration = driver.findElement(By.cssSelector("[class=regular-price]")).getCssValue("text-decoration-line");

        String[] RGB = getRGBColor(priceColor);

        assertEquals(priceDecoration,"line-through");

        assertEquals(RGB[0],RGB[1]);
        assertEquals(RGB[1],RGB[2]);


        //добавить тест на проверку цвета на второй странице


    }

    @Test
    public void productCampaignPriceStyle() throws Exception{

        String priceColor = driver.findElement(By.cssSelector("[class=campaign-price]")).getCssValue("color");
        String priceDecoration = driver.findElement(By.cssSelector("[class=campaign-price]")).getCssValue("font-weight");

        String[] RGB = getRGBColor(priceColor);

        //разделить на 2 теста
        assertEquals(priceDecoration,"700");
        assertEquals(RGB[1],"0");
        assertEquals(RGB[2],"0");

        //добавить тест на проверку цвета на второй странице

    }

//тест: акционная цена крупнее, чем обычная (это тоже надо проверить на каждой странице независимо)

    @After
    public void tearDown() throws Exception {
    }

    public String[] getRGBColor(String color) {

        color = color.replaceAll(".*\\(|\\).*", "");
        color = color.replaceAll("\\s+","");
        String[] RGB = color.split(",");
        return RGB;
    }

}
