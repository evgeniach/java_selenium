package litecart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(driver, 10);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    driver.quit();
                    driver = null;
                }));
    }

    public String[] getRGBColor(String color) {
        color = color.replaceAll(".*\\(|\\).*", "");
        color = color.replaceAll("\\s+", "");
        String[] RGB = color.split(",");
        return RGB;
    }

}
