package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasketPage extends Page  {
    public BasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class=shortcut] a")
    public WebElement listProductInBasket;

    @FindBy(css = "[name=remove_cart_item]")
    public WebElement removeCartItemButton;

    public void waitUntilProductDeleteFromBasket(WebElement tableProduct) {

    }

    public void deteteProductFromBasket(){
        WebElement tableProduct = driver.findElement(By.cssSelector(("[class*=dataTable]")));
        removeCartItemButton.click();
        wait.until(ExpectedConditions.stalenessOf(tableProduct));
    }

    public void listProductInBasketClick(){
        if(isElementPresent(driver, By.cssSelector("[class=shortcut] a"))) {
            listProductInBasket.click();
        }
    }

    boolean isElementPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size()>0;
    }




}
