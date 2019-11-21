package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends Page {
    public AdminPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AdminPage open() {
        driver.get("http://localhost/litecart/admin/login.php");
        return this;
    }
}
