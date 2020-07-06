package day4_FindElement_Checkbox;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Apple_FindElements {

    public static void main(String[] args) {

        //TC #02: FINDELEMENTS_APPLE
// 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

// 2.Go to https://www.apple.com
        driver.get("https://www.apple.com");

// 3.Click to iPhone

        WebElement iphoneclick = driver.findElement(By.xpath("//span[.='iPhone']/.."));
        iphoneclick.click();

// 4.Print out the texts of all links
       List <WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

       for (WebElement link : allLinks){
           String textOfLinks = link.getText();

       }

// 5.Print out how many link is missing text
// 6.Print out how many link has text
// 7.Print out how many total lin


    }
}
