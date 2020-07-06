package day11_page_object_model;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class NegativeLoginTest {

    @Test
    public void negative_login(){

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));



        WebElement usernameInput = Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement passwordInput = Driver.getDriver().findElement(By.id("prependedInput2"));

        WebElement loginButton = Driver.getDriver().findElement(By.id("_submit"));

        String username = ConfigurationReader.getProperty("storemanager_username");
        usernameInput.sendKeys(username);

        String password = ConfigurationReader.getProperty("storemanager_password");
        passwordInput.sendKeys(password);
        loginButton.click();

        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Assert message is NOT displayed");
    }


    @Test
    public void negative_login_with_page_object(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        LoginPage loginPage = new LoginPage();

        //senduing username
        String username = ConfigurationReader.getProperty("storemanager_username");
        loginPage.usernameInput.sendKeys(username);

        String password = ConfigurationReader.getProperty("storemanager_password");
        loginPage.passwordInput.sendKeys(password);

        loginPage.loginButton.click();

        //assert error message
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        //assert the text value of the error message
        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";

        Assert.assertEquals(actualText,expectedText);


    }


    @Test
    public void wrong_username_test(){

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.getProperty("storemanager_username");
        String password = ConfigurationReader.getProperty("storemanager_password");

        loginPage.login(username,password);


        //assert error message
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        //assert the text value of the error message
        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";

        Assert.assertEquals(actualText,expectedText);




    }
}
