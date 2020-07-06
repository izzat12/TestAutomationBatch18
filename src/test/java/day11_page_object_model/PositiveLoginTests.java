package day11_page_object_model;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class PositiveLoginTests {

    @Test
    public void positive_test(){


    Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

    Driver.getDriver().manage().window().maximize();

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.getProperty("storemanager_username");
        String password = ConfigurationReader.getProperty("storemanager_password");

        loginPage.login(username,password);

        String expectedTitle = "Dashboard";
        String actaulTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actaulTitle,expectedTitle);


}

}
