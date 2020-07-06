package day9_testBase_properties;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DriverUtilPractice {

    @Test
    public void driver_pratice(){

        Driver.getDriver().get("https://www.google.com/");

        WebElement googleSearch = Driver.getDriver().findElement(By.name("q"));
        googleSearch.sendKeys(ConfigurationReader.getProperty("testdata"));

    }

}
