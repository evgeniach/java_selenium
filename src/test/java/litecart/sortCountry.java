package litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class sortCountry extends baseTest {

    @Before
    public void start() throws Exception {
        this.init();
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void login() throws Exception{

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");


        List<WebElement> countries = driver.findElements(By.cssSelector(".row"));
        List<String> name = new ArrayList<>();
        List<String> href = new ArrayList<>();
       for(int i=0; i<countries.size(); i++) {
            name.add(countries.get(i).findElement(By.xpath("./td[5]")).getText());

          //  zones.add(countries.get(i).findElement(By.xpath("./td[6]")).getText());
        //    if (countries.get(i).findElement(By.xpath("./td[6]")).getText().equals("0")) {
           //     href.add(countries.get(i).findElement(By.xpath("./td[5]")).getAttribute("href"));
            }
      //    assertEquals(1, products.get(i).findElements(By.cssSelector(".sticker")).size());
        }

    }

    @After
    public void tearDown() throws Exception {
    }




}
