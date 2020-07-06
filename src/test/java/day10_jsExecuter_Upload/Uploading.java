package day10_jsExecuter_Upload;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Uploading {

    @Test
    public void Uploading_Test() throws InterruptedException {

        Driver.getDriver().get("http://practice.cybertekschool.com/upload");



        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));



        Thread.sleep(3000);
        chooseFile.sendKeys("C:\\Users\\Administrator\\Desktop/Test");

        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-submit"));
        fileUpload.click();

        WebElement uploadedMessage = Driver.getDriver().findElement(By.xpath("//div[@class='example']/h3"));
        Assert.assertTrue(uploadedMessage.isDisplayed());





    }


}
