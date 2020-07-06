package day6_dropDown;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGSelenium {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        //GOAL is to open new browser for each test.
        //What annotation I should be using for this? BeforeMethod or BeforeClass?

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();

    }

    @Test (priority = 2)
    public void google_test(){
        //WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //driver.get("https:/www.google.com");

        //Verify Title: Google
        String expectedTitle = "Google";
        String actaulTitle = driver.getTitle();

        //where we can add assertion
        Assert.assertTrue(actaulTitle.equals(expectedTitle));
        //if you are using assertEquals
        //you need to pass two arguments of the same type
        Assert.assertEquals(actaulTitle,expectedTitle);

    }

    @Test
    public void google_Search()  {

        //set up the browser
        //WebDriver driver = WebDriverFactory.getDriver("chrome");

        // maximize browser
        driver.manage().window().maximize();

        //go to google
        //driver.get("https:/www.google.com");

        //search apple
        WebElement apple = driver.findElement(By.name("q"));
        apple.sendKeys("apple"+ Keys.ENTER);

       // Verify title contains "apple"

        String expectedTitle = "apple";
        String actaulTitle = driver.getTitle();

        //assertion way
        Assert.assertTrue(actaulTitle.contains(expectedTitle));





    }


}
