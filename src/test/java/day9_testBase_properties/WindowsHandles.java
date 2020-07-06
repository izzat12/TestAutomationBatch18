package day9_testBase_properties;

import Utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsHandles {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.close();

    }

    @Test
    public void Multi_Windows(){

        driver.get("https://www.amazon.com");

        //we are downcasting our driver to JavaScripExecutor to be able to use its method
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //5.Create a logic to switch to the tab where Etsy.com is open
        Set<String> WindowsHandle = driver.getWindowHandles();

        for (String each : WindowsHandle){
            driver.switchTo().window(each);
            System.out.println("Current Title: "+driver.getTitle());

            if (driver.getCurrentUrl().contains("etsy")){
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }

        // 6.Assert: Title contains “Etsy”

    }
}
