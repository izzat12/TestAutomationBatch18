package day12_synchronization;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;

public class ForgotPassweordTest {

    /*
1. Go to https://qa3.vytrack.com
            2. Click to "Forgot your password?" link
3. Verify title changed to expected
    Expected: "Forgot Password"
            4. Verify url is as expected:
    Expected: "https://qa3.vytrack.com/user/reset-request"
    Note: Follow Page Object Model design pattern
 */

    @Test
    public void forgot_Password_Test(){

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        LoginPage loginPage = new LoginPage();

        loginPage.forgotPassword.click();

        String expectedTitle = "Forgot Password";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        //verify URL is as expected
        String expectedURL = "https://qa3.vytrack.com/user/reset-request";
        String actaulURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actaulURL,expectedURL);

    }


    @Test
    public void error_Message_Verification(){

        Driver.getDriver().get(ConfigurationReader.getProperty("forgotPassword"));

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

        String randomString = "Izzatdasdaslafskl;dfskl;dsdkl;fgdsfkl;gdfkl;gjdf;klgdfl;gkdfl;gkdfl;gkdfl;kgdfl;gkdfl;k";
        forgotPasswordPage.inputBox.sendKeys(randomString);

        //click request
        forgotPasswordPage.requestButton.click();


        //verify error message is displayed
        Assert.assertTrue(forgotPasswordPage.errorMessage.isDisplayed());

        //error message is expected

        String expectedMessage = "There is no active user with username or email address \""+randomString+"\".";
        String actaulMessage = forgotPasswordPage.errorMessage.getText();

        Assert.assertEquals(actaulMessage,expectedMessage);

    }
}
