package day3_cssSelector_xpath;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExampleForWebDriverFactory {

    public static void main(String[] args) throws InterruptedException {

      WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.google.com");
        driver.manage().window().maximize();


        WebElement search = driver.findElement(By.name("q"));
search.sendKeys("Facebook" + Keys.ENTER);



        Thread.sleep(4000);
        driver.close();


    }
}
