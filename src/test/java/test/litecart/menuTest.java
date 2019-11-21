package test.litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class menuTest extends baseTest{

    /*
    @Before
    public void start() throws Exception {
        this.init();
    }

    @Test
    public void login() throws Exception{
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<WebElement> links = driver.findElements(By.xpath(".//li[@id='app-']/a"));
        List<String> href = new ArrayList<>();

        for(int i=0; i<links.size(); i++) {
            href.add(links.get(i).getAttribute("href"));
        }
        int countOtherLinks = 0;
        for(int i=0;i<href.size();i++) {
            driver.get(href.get(i));
            driver.findElement(By.xpath(".//h1"));
            countOtherLinks = driver.findElements(By.xpath(".//ul[@class='docs']/li")).size();
            for(int j=1;j<countOtherLinks;j++) {
                driver.findElements(By.xpath(".//ul[@class='docs']/li")).get(j).click();
                driver.findElement(By.xpath(".//h1"));
            }
        }
    }

    @After
    public void tearDown() throws Exception {
    }
    */

}
