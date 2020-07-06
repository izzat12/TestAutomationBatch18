package day1_Selenium_FirstDay;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test   {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        //3- we get google.com
        //String googleUrl = "https://www.google.com";

        driver.get("https://www.google.com");

        System.out.println("driver.getTitle: " +driver.getTitle());
        System.out.println("driver.currentURL: " +driver.getCurrentUrl());

        //BROWSER NAVIGATIONS
        //this line will take user to the previous page
        //Thread.sleep(2000); //this line adds 2000milliseconds of wait = 2seconds
        //driver.navigate().back();

        //Thread.sleep is being added just to be able to see selenium movements
        Thread.sleep(2000);
        driver.navigate().forward(); //This line will go to next page


        Thread.sleep(2000);
        driver.navigate().refresh(); //This line will refresh the page

        driver.navigate().to("https://www.facebook.com");

        System.out.println("driver.getTitle: " +driver.getTitle());
        System.out.println("driver.currentURL: " +driver.getCurrentUrl());

        System.out.println(driver.getPageSource());
        driver.close();
    }
}
