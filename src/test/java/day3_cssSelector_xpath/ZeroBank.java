package day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBank {

    public static void main(String[] args) {

        //Setup chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //go to zero bank
        driver.get("http://zero.webappsecurity.com/login.html");


        WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot"));

        String actualHrefValue = forgotPasswordLink.getAttribute("href");
        String expectedHrefValue = "/forgot-password.html";

        System.out.println("actaul Href Value = "+actualHrefValue);

        if (actualHrefValue.contains(expectedHrefValue)){
            System.out.println("HREF PASSED");
        }else{
            System.out.println("Href FAILED");
        }

    }
}
