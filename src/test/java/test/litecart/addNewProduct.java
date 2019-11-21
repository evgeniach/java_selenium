package test.litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class addNewProduct extends baseTest {
/*
    String programName = "productName_"+java.util.UUID.randomUUID().toString();
    File f = new File("test_image.jpg");


    @Before
    public void start() throws Exception {
        this.init();
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void addNewProduct() throws Exception {
        Thread.sleep(2000L);
        driver.findElement(By.cssSelector(("a[href*=catalog]"))).click();
        Thread.sleep(2000L);
        driver.findElement(By.cssSelector(("a[href*=edit_product]"))).click();
        Thread.sleep(2000L);

        String imagePath = f.getAbsolutePath();
        imagePath = imagePath.replaceAll("\\\\", "\\\\\\\\");

        driver.findElement(By.cssSelector(("[name=status]"))).click();
        driver.findElement(By.cssSelector(("input[name^=name]"))).sendKeys(programName);
        driver.findElement(By.cssSelector(("[name=code]"))).sendKeys("code"+programName);
        driver.findElement(By.cssSelector(("[name*=product_groups]"))).click();
        driver.findElement(By.cssSelector(("[name=quantity]"))).sendKeys(Keys.DELETE+"10");
        driver.findElement(By.cssSelector(("[name^=new_images]"))).sendKeys(imagePath);
        driver.findElement(By.cssSelector(("[name=date_valid_from]"))).sendKeys("10012019");
        driver.findElement(By.cssSelector(("[name=date_valid_to]"))).sendKeys("10102020");

        driver.findElement(By.cssSelector(("a[href*=tab-information]"))).click();
        Thread.sleep(2000L);

        new Select(driver.findElement(By.cssSelector("[name=manufacturer_id"))).selectByValue("1");
        driver.findElement(By.cssSelector(("[name=keywords]"))).sendKeys("test  keywords");
        driver.findElement(By.cssSelector(("[name*=short_description]"))).sendKeys("test  short description");
        driver.findElement(By.cssSelector(("[class=trumbowyg-editor]"))).sendKeys("test  description");
        driver.findElement(By.cssSelector(("[name*=head_title]"))).sendKeys("test  head title");
        driver.findElement(By.cssSelector(("[name*=meta_description ]"))).sendKeys("test  meta description ");

        driver.findElement(By.cssSelector(("a[href*=tab-data]"))).click();
        Thread.sleep(2000L);

        driver.findElement(By.cssSelector(("[name=sku]"))).sendKeys("scu"+programName);
        driver.findElement(By.cssSelector(("[name=weight]"))).sendKeys(Keys.DELETE+"1");
        driver.findElement(By.cssSelector(("[name=dim_x]"))).sendKeys(Keys.DELETE+"11");
        driver.findElement(By.cssSelector(("[name=dim_y]"))).sendKeys(Keys.DELETE+"12");
        driver.findElement(By.cssSelector(("[name=dim_z]"))).sendKeys(Keys.DELETE+"13");
        driver.findElement(By.cssSelector(("[name^=attributes]"))).sendKeys("Colors\n" +
                "Body: Red\n" +
                "Eyes: Black\n" +
                "Beak: Orange");

        driver.findElement(By.cssSelector(("a[href*=tab-prices]"))).click();
        Thread.sleep(2000L);

        new Select(driver.findElement(By.cssSelector("[name=purchase_price_currency_code"))).selectByValue("USD");
        driver.findElement(By.cssSelector(("[name^=prices]"))).sendKeys(Keys.DELETE+"209.00");

        driver.findElement(By.cssSelector(("[name=save]"))).click();

        WebElement textDemo = driver.findElement(By.xpath("//*[text()='"+programName+"']"));
        assertTrue(textDemo.isDisplayed());
    }

        @After
    public void tearDown() throws Exception {
    }
 */
}
