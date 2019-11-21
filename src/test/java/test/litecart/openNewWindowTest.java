package test.litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class openNewWindowTest extends baseTest {

    /*
    @Before
    public void start() throws Exception {
        this.init();
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void openNewWindowTest() throws Exception {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("[class=dataTable] td a")).click();
        List<WebElement> links = driver.findElements(By.xpath("//i[@class='fa fa-external-link']/.."));
        List<String> href = new ArrayList<>();

        for(int i=0; i<links.size(); i++) {
            String mainWindow = driver.getWindowHandle();
            Set<String> oldWindows = driver.getWindowHandles();
            links.get(i).click();
            String newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }

    private ExpectedCondition<String> thereIsWindowOtherThan(Set<String> oldWindows) {
        return driver -> {
            Set<String> handles = driver.getWindowHandles();
            handles.removeAll(oldWindows);
            return handles.size() > 0 ? handles.iterator().next() : null;
        };
    }

    @After
    public void tearDown() throws Exception {
    }
*/

    }
