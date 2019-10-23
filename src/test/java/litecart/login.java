package litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;

public class login {
    private WebDriver driver;

    @Before
    public void start() {

       driver = new ChromeDriver();
       // driver = new FirefoxDriver();
        //driver = new SafariDriver();
       // FirefoxOptions options = new FirefoxOptions();
       // options.setBinary(new FirefoxBinary(new File("/Users/Evgenia/Applications/Firefox_Nightly.app/Contents/MacOS/firefox")));
       // WebDriver driver = new FirefoxDriver(options);
    }

    @Test
    public void login() {
        driver.get("http://localhost:8080/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver=null;
    }
}
