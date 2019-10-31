package litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class sortCountry extends baseTest {

    @Before
    public void start() throws Exception {
        this.init();
        driver.get("http://localhost:8080/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void sortCountriesMain() throws Exception{

        List<String> name = new ArrayList<>();
        List<String> sortName = new ArrayList<>();
        List<String> href = new ArrayList<>();

        driver.get("http://localhost:8080/litecart/admin/?app=countries&doc=countries");

        List<WebElement> countries = driver.findElements(By.cssSelector(".row"));

       for(int i=0; i<countries.size(); i++) {
            name.add(countries.get(i).findElement(By.xpath("./td[5]")).getText());
            sortName.add(name.get(i));
       }

            Collections.sort(name);
        assertEquals(name,sortName);

    }

        @Test
        public void sortZones() throws Exception {

            List<String> href = new ArrayList<>();

            driver.get("http://localhost:8080/litecart/admin/?app=countries&doc=countries");

            List<WebElement> countries = driver.findElements(By.cssSelector(".row"));

            for (int i = 0;i<countries.size(); i++) {
                if (!countries.get(i).findElement(By.xpath("./td[6]")).getText().equals("0")) {
                    href.add(countries.get(i).findElement(By.xpath("./td[5]/a")).getAttribute("href"));
                }

                for(int j=0;j<href.size();j++) {
                    driver.get(href.get(j));
                }

            }
        }

    @After
    public void tearDown() throws Exception {
    }

}
