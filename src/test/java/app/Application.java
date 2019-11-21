package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import pages.CountryAdminPage;
import pages.MainPage;
import pages.ProductDetailPage;
import pages.BasketPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Application {

    protected static WebDriver driver;

    private MainPage mainPage;
    private AdminPage adminPage;
    private CountryAdminPage countryAdminPage;
    private ProductDetailPage productDetailPage;
    private BasketPage basketPage;

    String testEmail = java.util.UUID.randomUUID().toString()+"@gmail.com";
    String password="123456";

    public Application() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        adminPage = new AdminPage(driver);
        countryAdminPage = new CountryAdminPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        basketPage = new BasketPage(driver);

       // driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        //driver = new SafariDriver();
        //driver = new InternetExplorerDriver(caps);
        //driver = new EdgeDriver();
        //FirefoxOptions options = new FirefoxOptions();
        //options.setBinary(new FirefoxBinary(new File("c:\\Program Files\\Firefox Nightly\\firefox.exe")));
        //driver = new FirefoxDriver(options);
    }

    public void quit() {
        driver.quit();
    }

    public String[] getRGBColor(String color) {
        color = color.replaceAll(".*\\(|\\).*", "");
        color = color.replaceAll("\\s+", "");
        String[] RGB = color.split(",");
        return RGB;
    }

    public void registerNewCustomer() throws InterruptedException {
        mainPage.open();
        driver.findElement(By.cssSelector(("[name=login_form] a"))).click();
        Thread.sleep(4000L);
        driver.findElement(By.cssSelector(("[name=firstname]"))).sendKeys("firstname");
        driver.findElement(By.cssSelector(("[name=lastname]"))).sendKeys("lastname");
        driver.findElement(By.cssSelector(("[name=address1]"))).sendKeys("address1");
        driver.findElement(By.cssSelector(("[name=postcode]"))).sendKeys("12345");
        driver.findElement(By.cssSelector(("[name=city]"))).sendKeys("city");
        new Select(driver.findElement(By.cssSelector("[name=country_code]"))).selectByValue("US");
        driver.findElement(By.cssSelector(("[name=email]"))).sendKeys(testEmail);
        driver.findElement(By.cssSelector(("[name=phone]"))).sendKeys("+11234567890");
        driver.findElement(By.cssSelector(("[name=password]"))).sendKeys(password);
        driver.findElement(By.cssSelector(("[name=confirmed_password]"))).sendKeys(password);
        driver.findElement(By.cssSelector(("[name=create_account]"))).click();
        driver.findElement(By.cssSelector(("[name=password]"))).sendKeys(password);
        driver.findElement(By.cssSelector(("[name=confirmed_password]"))).sendKeys(password);
        driver.findElement(By.cssSelector(("[name=create_account]"))).click();
    }

    public void loginUser() {
        driver.findElement(By.cssSelector(("[name=email]"))).sendKeys(testEmail);
        driver.findElement(By.cssSelector(("[name=password]"))).sendKeys(password);
        driver.findElement(By.cssSelector(("[name=login]"))).click();
    }

    public void logoutUser() {
        List<WebElement> accountMenu=driver.findElements(By.cssSelector(("[id=box-account] a")));
        accountMenu.get(3).click();
    }

    public void loginAdminPage() {
        adminPage.open();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    public ArrayList getTextFromEmptyBasket(ArrayList<WebElement> pageElements) {
        List<String> gettText = new ArrayList<>();
        for(int i=0;i<pageElements.size();i++) {
            gettText.add(pageElements.get(i).getText());
        }
        gettText.removeAll(Collections.singleton(""));
        return (ArrayList) gettText;
    }

    public void sortCountriesMain() {
        countryAdminPage.open();
        List<String> nameCounties = new ArrayList<>();
        List<WebElement> countries = new ArrayList<>();
        countries = driver.findElements(By.cssSelector(".row td:nth-child(5) a"));
        nameCounties = getTextFromEmptyBasket((ArrayList<WebElement>) countries);
        isSortByAlfabet((ArrayList) nameCounties);
    }

    public void sortZonesMain() {
        List<WebElement> zones = new ArrayList<>();
        List<String> nameZone = new ArrayList<>();
        List<WebElement> countries;
        List<String> href = new ArrayList<>();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        countries = driver.findElements(By.cssSelector(".row"));
        for (int i = 0;i<countries.size(); i++) {
            if (!countries.get(i).findElement(By.xpath("./td[6]")).getText().equals("0")) {
                href.add(countries.get(i).findElement(By.xpath("./td[5]/a")).getAttribute("href"));
            }
        }
        for(int j=0;j<href.size();j++) {
            driver.get(href.get(j));
            nameZone.clear();
            zones.clear();
            zones = driver.findElements(By.cssSelector("table#table-zones td:nth-child(3)"));
            nameZone = getTextFromEmptyBasket((ArrayList<WebElement>) zones);
            isSortByAlfabet((ArrayList) nameZone);
            }
    }


    public void isSortByAlfabet(ArrayList sequence){
        List<String> sortSequence = new ArrayList<>();
        sortSequence.addAll(sequence);
        Collections.sort(sortSequence);
        assertEquals(sortSequence,sequence);;
    }


    public void addProductToBasket() {
        Integer priceCart = Integer.parseInt(productDetailPage.quantityProductInBasket.getText());
        productDetailPage.productOptionsSet();
        productDetailPage.addCartproductLink.click();
        productDetailPage.waitUntilProductAddInBasket(productDetailPage.quantityProductInBasket,priceCart);
    }

    public void removeProduct() {
        basketPage.listProductInBasketClick();
        basketPage.deteteProductFromBasket();
    }


    public void goToProductDetailPage(int i) {
        mainPage.open();
        mainPage.logoLink.click();
        mainPage.addProductToBasket(i);
    }

    public void goToBasket() {
        mainPage.basketLink.click();
    }

    public String getTextFromEmptyBasket() {
        return driver.findElement(By.cssSelector("em")).getText();
    }



}

