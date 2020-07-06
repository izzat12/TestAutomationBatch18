package day10_jsExecuter_Upload;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTest {

    @Test
    public void hover_test(){

        Driver.getDriver().get("https://www.amazon.com");

        //actions instances
        Actions actons = new Actions(Driver.getDriver());

        //locate web element
        WebElement languageOptions = Driver.getDriver().findElement(By.id("icp-nav-flyout"));

        //perform the action
        actons.moveToElement(languageOptions).perform();

    }

    @Test
    public void Hover_Test2() throws InterruptedException {

        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        //lcoate the images and text
        WebElement img1 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));


        //create instance actions
        Actions actons = new Actions(Driver.getDriver());
        actons.moveToElement(img1).perform();

        Assert.assertTrue(user1.isDisplayed());
        Thread.sleep(4000);

        actons.moveToElement(img2).perform();
        Assert.assertTrue(user2.isDisplayed());
        Thread.sleep(4000);

        actons.moveToElement(img3).perform();
        Assert.assertTrue(user3.isDisplayed());



    }
}
