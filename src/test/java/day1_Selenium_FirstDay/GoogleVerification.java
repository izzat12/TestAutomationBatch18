package day1_Selenium_FirstDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleVerification {

    public static void main(String[] args) {

        //setup the webdriver
        WebDriverManager.chromedriver().setup();

        //create an instance firefox driver
        WebDriver driver = new ChromeDriver();

        //make full browser full screen
        driver.manage().window().maximize();

        //go to URL
        driver.get("https://practice.cybertekschool.com");

        //Title
        String Title = driver.getTitle();
        String expectedTitle = "Cybertek";

        if (Title.equals(expectedTitle)){
            System.out.println("Practice title verification PASSED");
        }else{
            System.out.println("Google title verification FAILED");
        }
    }
}
