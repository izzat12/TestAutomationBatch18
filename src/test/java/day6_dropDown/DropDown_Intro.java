package day6_dropDown;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDown_Intro {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{

        Thread.sleep(4000);
        driver.close();
    }

    @Test
    public void Test1_default_value(){


        //Verify Simple dropdown -- default selected value is corrected
        //Expected: Please select an option

        Select simpleSelect = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        String actaulSimpleDropDown = simpleSelect.getFirstSelectedOption().getText();
        String expectedText = "Please select an option";

        Assert.assertEquals(actaulSimpleDropDown, expectedText);


        //Verify  "State Selection" default selected value is correct
        //Expected: "Select a State"

        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String actaulStateSelection = stateDropDown.getFirstSelectedOption().getText();
        String expectedStateSelection = "Select a State";

        Assert.assertEquals(actaulStateSelection,expectedStateSelection);

    }

    @Test
    public void Test2_State_dropdown_Verifcaiton() throws InterruptedException {

        //Select state
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));


        //Illinios
        Thread.sleep(2000);
        stateDropdown.selectByValue("IL");

        //Virginia
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("VA");

        //California
        Thread.sleep(2000);
        stateDropdown.selectByIndex(5);





    }

}
