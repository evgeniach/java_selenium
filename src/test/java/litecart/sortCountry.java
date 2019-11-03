package litecart;

import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class sortCountry extends baseTest {


    @Before
    public void start() throws Exception {
        this.init();
        driver.get("http://localhost:8080/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void sortCountriesMain() throws Exception{

        List<String> nameCounties = new ArrayList<>();
        List<WebElement> countries = new ArrayList<>();

        driver.get("http://localhost:8080/litecart/admin/?app=countries&doc=countries");

        countries = driver.findElements(By.cssSelector(".row td:nth-child(5) a"));

        nameCounties=getText((ArrayList<WebElement>) countries);

        isSortByAlfabet((ArrayList) nameCounties);
    }

        @Test
        public void sortZones() throws Exception {
            List<WebElement> zones = new ArrayList<>();
            List<String> nameZone = new ArrayList<>();
            List<WebElement> countries;
            List<String> href = new ArrayList<>();

            driver.get("http://localhost:8080/litecart/admin/?app=countries&doc=countries");

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
                nameZone=getText((ArrayList<WebElement>) zones);

                isSortByAlfabet((ArrayList) nameZone);

            }
        }

    @Test
    public void sortGeoZones() throws Exception {
        List<String> href = new ArrayList<>();
        List<String> nameZone = new ArrayList<>();
        List<WebElement> zones =  new ArrayList<>();

        driver.get("http://localhost:8080/litecart/admin/?app=geo_zones&doc=geo_zones");

        List<WebElement> geoZones = driver.findElements(By.cssSelector(".row td:nth-child(3) a"));

        for(int i=0;i<geoZones.size();i++) {
            href.add(geoZones.get(i).getAttribute("href"));
        }

        for(int j=0;j<href.size();j++) {

            nameZone.clear();
            zones.clear();

            driver.get(href.get(j));
            zones = driver.findElements(By.cssSelector("select[name *=zone_code] > option[selected]"));

            nameZone=getText((ArrayList<WebElement>) zones);

            isSortByAlfabet((ArrayList) nameZone);

        }
    }



    @After
    public void tearDown() throws Exception {
    }

    public void isSortByAlfabet(ArrayList sequence){
        List<String> sortSequence = new ArrayList<>();
        sortSequence.addAll(sequence);
        Collections.sort(sortSequence);
        assertEquals(sortSequence,sequence);;
    }


    public ArrayList getText(ArrayList<WebElement> pageElements) {
        List<String> gettText = new ArrayList<>();

        for(int i=0;i<pageElements.size();i++) {
            gettText.add(pageElements.get(i).getText());
        }
        //list.removeAll(Arrays.asList("", null));
        gettText.removeAll(Collections.singleton(""));
        return (ArrayList) gettText;
    }



}

