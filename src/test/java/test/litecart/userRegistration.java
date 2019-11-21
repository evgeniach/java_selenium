package test.litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.MainPage;

import java.util.List;

public class userRegistration  extends baseTest{




    @Test
    public void createAccount() throws Exception{

        Thread.sleep(2000L);
        app.registerNewCustomer();

        Thread.sleep(2000L);

        app.logoutUser();

        Thread.sleep(2000L);

        app.loginUser();
        Thread.sleep(2000L);
        app.logoutUser();

    }


    @After
    public void tearDown() throws Exception {
    }


}
