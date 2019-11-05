package litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

public class userRegistration  extends baseTest{

    String testEmail = java.util.UUID.randomUUID().toString()+"@gmail.com";
    String password="123456";

    @Before
    public void start() throws Exception {
        this.init();
    }

    @Test
    public void createAccount() throws Exception{
        driver.get("http://localhost/litecart/");
        driver.findElement(By.cssSelector(("[name=login_form] a"))).click();

        Thread.sleep(2000L);
        driver.findElement(By.cssSelector(("[name=firstname]"))).sendKeys("firstname");
        driver.findElement(By.cssSelector(("[name=lastname]"))).sendKeys("lastname");
        driver.findElement(By.cssSelector(("[name=address1]"))).sendKeys("address1");
        driver.findElement(By.cssSelector(("[name=postcode]"))).sendKeys("12345");
        driver.findElement(By.cssSelector(("[name=city]"))).sendKeys("city");
        new Select(driver.findElement(By.cssSelector("[name=country_code]"))).selectByValue("US");
        driver.findElement(By.cssSelector(("[name=email]"))).sendKeys(testEmail);
        driver.findElement(By.cssSelector(("[name=phone]"))).sendKeys("+11234567890");
        driver.findElement(By.cssSelector(("[name=password]"))).sendKeys(password);
        driver.findElement(By.cssSelector(("[name=confirmed_password]"))).sendKeys(password);
        driver.findElement(By.cssSelector(("[name=create_account]"))).click();
        driver.findElement(By.cssSelector(("[name=password]"))).sendKeys(password);
        driver.findElement(By.cssSelector(("[name=confirmed_password]"))).sendKeys(password);
        driver.findElement(By.cssSelector(("[name=create_account]"))).click();

        Thread.sleep(2000L);
        List<WebElement> accountMenu=driver.findElements(By.cssSelector(("[id=box-account] a")));
        accountMenu.get(3).click();

        Thread.sleep(2000L);
        driver.findElement(By.cssSelector(("[name=email]"))).sendKeys(testEmail);
        driver.findElement(By.cssSelector(("[name=password]"))).sendKeys(password);
        driver.findElement(By.cssSelector(("[name=login]"))).click();

        Thread.sleep(2000L);
        accountMenu.clear();
        accountMenu=driver.findElements(By.cssSelector(("[id=box-account] a")));
        accountMenu.get(3).click();

    }


    @After
    public void tearDown() throws Exception {
    }


}
