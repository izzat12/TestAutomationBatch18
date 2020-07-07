package day12_synchronization;

import Utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoadingPage;

public class ExplaicitWait {

    @Test
    public void dynamic_title_test(){

        String url = "http://practice.cybertekschool.com/dynamic_loading/7";
        Driver.getDriver().get(url);

        LoadingPage loadingPage = new LoadingPage();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        Assert.assertTrue(loadingPage.doneMessage.isDisplayed());

        Assert.assertTrue(loadingPage.spongeBobImage.isDisplayed());
    }
}
