package day7_Javafaker;

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

import java.util.List;
import java.util.concurrent.TimeUnit;


public class SmartBearTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //3. Enter username: “Tester”
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUsername.sendKeys("Tester");


        //4. Enter password: “test”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");

        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
    }


    @Test
    public void p1_smartbear_login_test(){

        //6. Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        //System.out.println("Number of the links: " + allLinks.size());

        int expectedNumberOfLinks = 6;
        int actualNumberOfLinks = allLinks.size();
        Assert.assertEquals(actualNumberOfLinks, 6);

        //7. Print out each link text on this page
        for (WebElement link : allLinks){

            System.out.println(link.getText());
        }
    }



    @Test
    public void p2_smartbear_order_placing() {

        //TC#2: Smartbear software order placing
        //6. Click on Order
        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();

        //7. Select familyAlbum from product, set quantity to 2
        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));

        //quantityInput.clear(); //just deletes if there is any existing input in the input box.

       // Thread.sleep(1000);
        //Imitating as if the user is pressing the BACKSPACE key on keyboard to delete something.
        quantityInput.sendKeys(Keys.BACK_SPACE);
       // Thread.sleep(1000);
        quantityInput.sendKeys("2");

        //8. Click to “Calculate” button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        //9. Fill address Info with JavaFaker
        WebElement inputCustomer = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement inputStreet = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement inputCity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement inputState = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement inputZip = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        //• Generate: name, street, city, state, zip code
       Faker faker = new Faker();

       inputCustomer.sendKeys(faker.name().fullName());
       inputStreet.sendKeys(faker.address().streetName());
       inputCity.sendKeys(faker.address().city());
       inputState.sendKeys(faker.address().state());
       String zipcode = faker.address().zipCode().replaceAll("_","");
       inputZip.sendKeys(zipcode);

        //10. Click on “visa” radio button
        WebElement visaCheck = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaCheck.click();


        //11. Generate card number using JavaFaker
        WebElement inputCardNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        inputCardNumber.sendKeys(faker.finance().creditCard().replaceAll("_",""));

        WebElement intputDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        intputDate.sendKeys("12/25");

        //12. Click on “Process”
        WebElement clikProcess = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        calculateButton.click();


        //13.Verify success message “New order has been successfully added.”

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        Assert.assertTrue(successMessage.isDisplayed());



    }


    @Test
    public void smartBear_Verifcation(){

        //verify susan mclaren has order on date "01/05/2010
        WebElement susanDateOrder = driver.findElement(By.xpath("//td.='Susan McLaren']/following-sibling::td[3]"));

        String expectedDate = "01/05/2010";
        String actaulDate = susanDateOrder.getText();

        Assert.assertEquals(actaulDate,expectedDate);
    }



}