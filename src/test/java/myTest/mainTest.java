package myTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class mainTest {
    private WebDriver driver;
    private WebDriver wait;

    @Before
    public void start() {
       // driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //WebDriver driver = new InternetExplorerDriver(caps);
       // WebDriver driver = new EdgeDriver();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        driver = new InternetExplorerDriver(caps);
    }

    @Test
    public void myFirstTest() {

        driver.get("http://www.google.com");
    }

    @After
    public void stop() {
        driver.quit();
        driver=null;
    }
}
