package day2_FIndElement_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTitleVerification {

    public static void main(String[] args) {

        //to open google chrome
        WebDriverManager.chromedriver().setup();

        //set up
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //go to google.com
        driver.get("https://www.google.com");

        //to find search element
        driver.findElement(By.name("q")).sendKeys("Apple"+ Keys.ENTER);

        String actaulyTitle = driver.getTitle();
        String expectedTitle = "Apple";

        if (actaulyTitle.startsWith(expectedTitle)){
            System.out.println("Google search title verification: PASSED");
        }else{
            System.out.println("Google search title verification: FAILED");
        }



    }
}
