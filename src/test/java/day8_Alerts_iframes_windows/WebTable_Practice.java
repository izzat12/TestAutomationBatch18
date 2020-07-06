package day8_Alerts_iframes_windows;

import Utilities.SmartBearUtilities;
import Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTable_Practice {

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

}

@Test
    public void verifyOrder_test() throws InterruptedException {
    SmartBearUtilities.login(driver);

    Thread.sleep(2000);

    //call my method to verifu if given name is in the list
    SmartBearUtilities.verifyOrder(driver,"Paul Brown");
}


@Test
    public void print_names_cities_test(){
        SmartBearUtilities.login(driver);

}

}
