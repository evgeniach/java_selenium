package test.litecart;

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

    @Test
    public void sortCountriesMain() throws Exception{

        app.loginAdminPage();
        app.sortCountriesMain();

    }

        @Test
        public void sortZones() throws Exception {
            app.loginAdminPage();
            app.sortZonesMain();
        }

   /* @Test
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

*/

    @After
    public void tearDown() throws Exception {
    }







}

