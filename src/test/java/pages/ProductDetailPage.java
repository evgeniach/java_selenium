package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailPage extends Page {

        public ProductDetailPage(WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver, this);
        }

        @FindBy(css = "[name*=options]")
        public WebElement productOptions;

        @FindBy(css = "span[class=quantity]")
        public WebElement quantityProductInBasket;

        @FindBy(css = "[name=add_cart_product]")
        public WebElement addCartproductLink;

        public void productOptionsSet(){
            if(isElementPresent(driver, By.cssSelector("[name*=options]"))) {
                productOptions.click();
            }
        }

        boolean isElementPresent(WebDriver driver, By locator) {
            return driver.findElements(locator).size()>0;
        }

        public void waitUntilProductAddInBasket(WebElement cart, int priceCart) {
            wait.until(ExpectedConditions.textToBePresentInElement(cart,Integer.toString(priceCart+1)));
        }
}
