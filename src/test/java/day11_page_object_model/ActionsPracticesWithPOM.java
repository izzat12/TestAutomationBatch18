package day11_page_object_model;

import Utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HoversPage;

public class ActionsPracticesWithPOM {





    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        Driver.getDriver().close();
    }

 @Test
    public void hover_Test() throws InterruptedException {

     Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

     HoversPage hoversPage = new HoversPage();

     Actions actions = new Actions(Driver.getDriver());


     //hover 1
     Thread.sleep(3000);
     actions.moveToElement(hoversPage.img1).perform();
     Assert.assertTrue(hoversPage.user1.isDisplayed());

     //hover 2
     Thread.sleep(3000);
     actions.moveToElement(hoversPage.img2).perform();
     Assert.assertTrue(hoversPage.user2.isDisplayed());

     //hover 3
     Thread.sleep(3000);
     actions.moveToElement(hoversPage.img3).perform();
     Assert.assertTrue(hoversPage.user3.isDisplayed());
 }

}
