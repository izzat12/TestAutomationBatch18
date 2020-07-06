package day11_page_object_model;

import Utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPraxtice {

    @Test
    public void scrolling_with_actions() throws InterruptedException {

        Driver.getDriver().get("http://practice.cybertekschool.com/");


        Actions actions = new Actions(Driver.getDriver());

        WebElement cybertekSchoollink = Driver.getDriver().findElement(By.linkText("Cyberktek School"));
        WebElement inputs = Driver.getDriver().findElement(By.linkText("Inputs"));

        Thread.sleep(3000);

        //using actions instance we use moveToElement method
        actions.moveToElement(cybertekSchoollink).perform();

        Thread.sleep(3000);
        actions.moveToElement(inputs).click().perform();





    }


    @Test
    public void  double_click(){

        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //switch to iframe
        //2. Switch to iframe.
        // 1- index 2- id-name value 3-locate it as a webELement and pass it into

        Driver.getDriver().switchTo().frame("iframeResult");



        //3. Double click on the text “Double-click me to change my text color.”

        WebElement textToDoubleClick = Driver.getDriver().findElement(By.id("demo"));


        Actions actions = new Actions(Driver.getDriver());



        actions.doubleClick(textToDoubleClick).perform();

        

        //4. Assert: Text’s “style” attribute value contains “red”.
        String actual = textToDoubleClick.getAttribute("style");
        String expected = "color: red;";
        
        Assert.assertTrue(actual.equals(expected));




    }


    @Test
    public void drag_and_drop_test() throws InterruptedException {

        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");



        //2. Drag and drop the small circle to bigger circle.



        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));



        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));



        //using actions instance to do drag and drop

        Actions actions = new Actions(Driver.getDriver());



        actions.clickAndHold(smallCircle).moveToElement(bigCircle).perform();



        String expectedWhileHover = "Now drop...";

        String actualWhileHover = bigCircle.getText();



        Assert.assertEquals(actualWhileHover, expectedWhileHover);



        Thread.sleep(2000);



        actions.release().perform();



        //actions.dragAndDrop(smallCircle, bigCircle).perform();


        //3. Assert:

        //-Text in big circle changed to: “You did great!”
        String actual = bigCircle.getText();
        String expected = "You did great!";
        Assert.assertEquals(actual, expected);

    }


    @Test
    public void right_Click_test(){

        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));

        Actions actions = new Actions(Driver.getDriver());

        actions.contextClick(box).perform();

        Alert alert = Driver.getDriver().switchTo().alert();

        alert.accept();

    }
}
