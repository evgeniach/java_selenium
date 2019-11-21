package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CountryAdminPage extends Page {
    public CountryAdminPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CountryAdminPage open() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        return this;
    }
}
