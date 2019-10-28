package litecart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseTest {

    protected static WebDriver driver;
    protected WebDriverWait wait;

    public void init() throws Exception {

        if (driver != null) {
            return;
        }

        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        //driver = new SafariDriver();
        //driver = new InternetExplorerDriver(caps);
        //driver = new EdgeDriver();
        //FirefoxOptions options = new FirefoxOptions();
        //options.setBinary(new FirefoxBinary(new File("c:\\Program Files\\Firefox Nightly\\firefox.exe")));
        //driver = new FirefoxDriver(options);

        this.wait = new WebDriverWait(driver, 10L);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    driver.quit();
                    driver = null;
                }));
    }


    }
