package VyTrack_Project;

import Utilities.ConfigurationReader;
import Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//Izzatulloh Patidinov

 /*
 User story:
           - as a user, i should able to login as a authorized user
           and able to create new car maintaince
  */


public class VyTrackFrameWork {
    WebDriver driver;

    @BeforeMethod
    public void BeforeMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);    }

        // @AfterMethod
    public void afterMethod() throws Exception{

        Thread.sleep(1000);
        driver.close();
    }

    // Authorized users
    @Test
    public  void test() throws Exception {
        WebElement userNameBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userNameBox.sendKeys(ConfigurationReader.getProperty("storemanager_username"));

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("storemanager_password")+ Keys.ENTER);

        Faker faker = new Faker();

        // Driver should be able to access vehicle fuel log under Fleet Module
        Thread.sleep(4000);
        WebElement fleetModule = driver.findElement(By.xpath("(//a[@href='#'])[3]"));
        fleetModule.click();        Thread.sleep(2000);

        WebElement fuelLogModule = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[5]"));
        fuelLogModule.click();
        //Drive should be able to create fuel log

        Thread.sleep(2000);
        WebElement createFuelLogBtn = driver.findElement(By.xpath("//a[@title='Create Vehicle Fuel Logs']"));
        createFuelLogBtn.click();

        //Driver should be able to cancel fuel log
        Thread.sleep(2000);
        WebElement cancelBtn = driver.findElement(By.xpath("//a[@title='Cancel']"));
        cancelBtn.click();

        //////////////////////////////////        //Create log again
        Thread.sleep(2000);
        WebElement createFuelLogBtn2 = driver.findElement(By.xpath("//a[@title='Create Vehicle Fuel Logs']"));
        createFuelLogBtn2.click();

        //We confirm title here
        System.out.println("Title here is: "+driver.getTitle());

        Thread.sleep(2000);
        WebElement odometer1 = driver.findElement(By.xpath("//input[@name='custom_entity_type[OdometerValue]']"));
        odometer1.sendKeys(faker.number().digit());

        Thread.sleep(2000);
        WebElement liter1 = driver.findElement(By.xpath("//input[@name='custom_entity_type[Liter]']"));
        liter1.sendKeys(faker.number().digit());

        Thread.sleep(2000);
        WebElement perLiter = driver.findElement(By.xpath("//input[@name='custom_entity_type[PricePerLiter]']"));
        perLiter.sendKeys(faker.number().digit());

        Thread.sleep(2000);
        WebElement price1 = driver.findElement(By.xpath("//input[@name='custom_entity_type[TotalPrice]']"));
        price1.sendKeys(faker.number().digit());

        Thread.sleep(3000);
        WebElement date1 = driver.findElement(By.xpath("//input[@placeholder='Choose a date']"));
        date1.click();

        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        select.selectByValue("3");

        Thread.sleep(2000);
        Select select1 = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        select1.selectByValue("2021");

        Thread.sleep(1000);
        WebElement day = driver.findElement(By.xpath("(//a[@class='ui-state-default'])[25]"));
        day.click();

        Thread.sleep(1000);
        WebElement purchaser1 = driver.findElement(By.xpath("//input[@name='custom_entity_type[Purchaser]']"));
        purchaser1.sendKeys(faker.name().fullName());

        Thread.sleep(1000);
        WebElement invoiceRef = driver.findElement(By.xpath("//input[@name='custom_entity_type[InvoiceReference]']"));
        invoiceRef.sendKeys(faker.name().name());

        Thread.sleep(1000);
        WebElement vendor1 = driver.findElement(By.xpath("//input[@name='custom_entity_type[Vendor]']"));
        vendor1.sendKeys(faker.name().name());

        Thread.sleep(1000);
        WebElement info = driver.findElement(By.xpath("//textarea[@name='custom_entity_type[Info]']"));
        info.sendKeys("Please get back to me if you have any concern");

        Thread.sleep(1000);
        WebElement saveDropDown = driver.findElement(By.xpath("//a[@class='btn-success btn dropdown-toggle']"));
        saveDropDown.click();

        // Driver should be able to save the fuel log info
        Thread.sleep(1000);
        WebElement saveBtn = driver.findElement(By.xpath("//button[@class='action-button dropdown-item']"));
        saveBtn.click();

        // *****************************************
        //Driver should be able to edit fuel log
        Thread.sleep(1000);
        WebElement editFuelLog = driver.findElement(By.xpath("//a[@title='Edit Vehicle Fuel Logs']"));
        editFuelLog.click();

        Thread.sleep(1000);
        WebElement saveDropDown2 = driver.findElement(By.xpath("//a[@class='btn-success btn dropdown-toggle']"));
        saveDropDown2.click();

        // Save after editing
        Thread.sleep(1000);
        WebElement saveBtn2 = driver.findElement(By.xpath("//button[@class='action-button dropdown-item']"));
        saveBtn2.click();

        // *****************************************
        // Driver should be able to delete fuel log

        Thread.sleep(1000);
        WebElement deleteFuelLog = driver.findElement(By.xpath("//a[@title='Delete Vehicle Fuel Logs']"));
        deleteFuelLog.click();

        Thread.sleep(1000);
        WebElement confirmDelete = driver.findElement(By.xpath("//a[.='Yes, Delete']"));
        confirmDelete.click();

        //Here We confirm that we are in the create log page again. Therefore we make sure we see "Vehicle Fuel Logs"
        WebElement vehicleFuelLogsMsg = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        String text = vehicleFuelLogsMsg.getText();

        Assert.assertTrue(text.equals("Vehicle Fuel Logs"),"We're back in the Vehicle Fuel Logs page");        Thread.sleep(2000);
        WebElement checkAllBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[9]"));
        checkAllBox.click();    }

        /// Unauthorized users
    @Test
    public void unauthorizedUserTest() throws Exception{

        Thread.sleep(1000);
        WebElement userNameBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userNameBox.sendKeys("storemanager205");

        Thread.sleep(1000);
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password")+ Keys.ENTER);

        Thread.sleep(2000);
        WebElement fleetModule = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        fleetModule.click();

        Thread.sleep(2000);
        WebElement fuelLogModule = driver.findElement(By.xpath("//span[.='Vehicles Fuel Logs']"));
        fuelLogModule.click();

        WebElement rejectionText = driver.findElement(By.xpath("(//div[@class='message'])[2]"));
        Assert.assertTrue(rejectionText.isDisplayed());
    }

}
