package day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cybertek_URL_Veriifying {

    public static void main(String[] args) throws InterruptedException {

        //Open Chrome
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email into input box

        WebElement emailinput = driver.findElement(By.name("email"));

        //type
        emailinput.sendKeys("anyemail@email.com");

        //click
       WebElement ClickButton = driver.findElement(By.id("form_submit"));
        ClickButton.click();

        //Expected "email_sent";
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "email_sent";

        System.out.println("The current URL "+actualURL);

        if (actualURL.contains(expectedURL)){
            System.out.println("Verification PASSED");
        }else {
            System.out.println("Verification FAILED");
        }

        //Confirmation Email
        WebElement confirmMessage = driver.findElement(By.name("confirmation_message"));
        //String actaulMessage = driver.findElement(By.name("confirmation_message")).getText();

        String actaulMessageText = confirmMessage.getText();
        String expectedMessage = "Your e-mail's been sent!";

        if (actaulMessageText.equals(expectedMessage)){
            System.out.println("Confirmation message PASSED");
        }else{
            System.out.println("Confirmation message FAILED");
        }

        if (confirmMessage.isDisplayed()){
            System.out.println("Message is displayed, PASSED");
        }else{
            System.out.println("Message is displayed, FAILED");

        }

        Thread.sleep(4000);
        driver.close();



    }
}
