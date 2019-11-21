package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.get("http://litecart.stqa.ru/ru/");
        //driver.get("http://localhost/litecart/");
        return this;
    }

    @FindBy(css = "[id=logotype-wrapper] a")
    public WebElement logoLink;

    @FindBy(xpath = "//*[text()='Checkout »']")
    public WebElement basketLink;

    public void addProductToBasket(int i) {
        List<WebElement> product = new ArrayList<>();
        product = driver.findElements(By.cssSelector("li[class*=product] a.link"));
        product.get(i).click();
        wait.until(ExpectedConditions.stalenessOf(product.get(0)));
    }







}
