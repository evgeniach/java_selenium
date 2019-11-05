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
        driver.get("http://localhost/litecart/en/");
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
    public void productRegularPrice() throws Exception{
        String price = driver.findElement(By.cssSelector("[class=regular-price]")).getText();
        driver.findElement(By.cssSelector(("div[id=box-campaigns] [class=link]"))).click();
        String priceDetail = driver.findElement(By.cssSelector("[class=regular-price]")).getText();
        assertEquals(price,priceDetail);
    }

    @Test
    public void productCampaignPrice() throws Exception{
        String price = driver.findElement(By.cssSelector("[class=campaign-price]")).getText();
        driver.findElement(By.cssSelector(("div[id=box-campaigns] [class=link]"))).click();
        String priceDetail = driver.findElement(By.cssSelector("[class=campaign-price]")).getText();
        assertEquals(price,priceDetail);
    }

    @Test
    public void productRegularPriceColor() throws Exception{
        String priceColor = driver.findElement(By.cssSelector("[class=regular-price]")).getCssValue("color");
        String[] RGB = getRGBColor(priceColor);
        assertEquals(RGB[0],RGB[1]);
        assertEquals(RGB[1],RGB[2]);
    }

    @Test
    public void productRegularPriceColorDetail() throws Exception{
        driver.findElement(By.cssSelector(("div[id=box-campaigns] [class=link]"))).click();
        String priceColor = driver.findElement(By.cssSelector("[class=regular-price]")).getCssValue("color");
        String[] RGB = getRGBColor(priceColor);
        assertEquals(RGB[0],RGB[1]);
        assertEquals(RGB[1],RGB[2]);
    }

    @Test
    public void productRegularPriceStyle() throws Exception{
        String priceDecoration = driver.findElement(By.cssSelector("[class=regular-price]")).getCssValue("text-decoration-line");
        assertEquals(priceDecoration,"line-through");
    }

    @Test
    public void productCampaignPriceColor() throws Exception{
        String priceColor = driver.findElement(By.cssSelector("[class=campaign-price]")).getCssValue("color");
        String[] RGB = getRGBColor(priceColor);
        assertEquals(RGB[1],"0");
        assertEquals(RGB[2],"0");
    }

    @Test
    public void productCampaignPriceColorDetail() throws Exception{
        driver.findElement(By.cssSelector(("div[id=box-campaigns] [class=link]"))).click();
        String priceColor = driver.findElement(By.cssSelector("[class=campaign-price]")).getCssValue("color");
        String[] RGB = getRGBColor(priceColor);
        assertEquals(RGB[1],"0");
        assertEquals(RGB[2],"0");
    }

    @Test
    public void productCampaignPriceStyle() throws Exception{
        String priceDecoration = driver.findElement(By.cssSelector("[class=campaign-price]")).getCssValue("font-weight");
        assertEquals(priceDecoration,"700");
    }

    @Test
    public void productPriceСompare() throws Exception{
        String priceCampaign = driver.findElement(By.cssSelector("[class=campaign-price]")).getCssValue("font-size");
        String priceRegular = driver.findElement(By.cssSelector("[class=regular-price]")).getCssValue("font-size");
        assertTrue(getFontSize(priceCampaign)>getFontSize(priceRegular));
    }

    @Test
    public void productPriceСompareDetail() throws Exception{
        driver.findElement(By.cssSelector(("div[id=box-campaigns] [class=link]"))).click();
        String priceCampaign = driver.findElement(By.cssSelector("[class=campaign-price]")).getCssValue("font-size");
        String priceRegular = driver.findElement(By.cssSelector("[class=regular-price]")).getCssValue("font-size");
        assertTrue(getFontSize(priceCampaign)>getFontSize(priceRegular));
    }

    @After
    public void tearDown() throws Exception {
    }

    public String[] getRGBColor(String color) {
        color = color.replaceAll(".*\\(|\\).*", "");
        color = color.replaceAll("\\s+","");
        String[] RGB = color.split(",");
        return RGB;
    }

    public double getFontSize(String size) {
        size = size.replaceAll("px", "");
        double  priceSize =  Double.parseDouble(size);
        return priceSize;
    }

}
