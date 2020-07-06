package day8_Alerts_iframes_windows;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPractice {

    WebDriver driver;

    @BeforeClass
    public void setUp() {


        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void month_dropdown_default(){
   //    locating the dropdown of month
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));

        // we need to create our actaul and expected value
        String actaulDropdown = month.getFirstSelectedOption().getText();

        System.out.println("actaulDropdown + "+ actaulDropdown);

        String expectedDropdown = LocalDateTime.now().getMonth().name();

        System.out.println("expectedDropdwon = "+expectedDropdown);

        Assert.assertEquals(actaulDropdown.toLowerCase(),expectedDropdown.toLowerCase());

        Assert.assertTrue(actaulDropdown.equalsIgnoreCase(expectedDropdown));

        List<WebElement> actaulDropdownOptions = month.getOptions();

        List<String> expectedMonths = Arrays.asList("January","February","March","April","May","June","July",
                "August","September","October","November","December");

        List<String> actaulMonths = new ArrayList<>();
        for (WebElement each : actaulDropdownOptions){
            actaulMonths.add(each.getText());
        }

        Assert.assertEquals(actaulMonths,expectedMonths);
    }


    }
