package day10_jsExecuter_Upload;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorPractices {

    @Test
    public void jsExecuter() throws InterruptedException {
        Driver.getDriver().get("http://practice.cybertekschool.com/");

        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        JavascriptExecutor jsExe = (JavascriptExecutor)Driver.getDriver();

        Thread.sleep(3000);
        jsExe.executeScript("arguments[0].scrollIntoView(true);",cybertekSchoolLink);
    }
}
