package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    //password
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    //submit click the button
    @FindBy (id = "_submit")
    public WebElement loginButton;

    @FindBy (xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

    //locating forgot password
    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPassword;

    public  void login(String username, String password){

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
