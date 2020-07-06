package day4_FindElement_Checkbox;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Meriam_Webster_FindElement {

    public static void main(String[] args) {


        //set up web driver
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //maximize page
        driver.manage().window().maximize();

        //if page is loaded before it will continue
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //go to website
        driver.get("https://www.merriam-webster.com/");

        //print out the text of all links
       List<WebElement> linkOfLinks =  driver.findElements(By.xpath("//body//a"));


       int linkWithoutText = 0;
       int linkWithText = 0;

       for (WebElement eachLink : linkOfLinks){
           String textOfEachLinks = eachLink.getText();
           if (textOfEachLinks.isEmpty()){
               linkWithoutText++;
           }else{
               System.out.println(textOfEachLinks);
               linkWithText++;
           }
       }

       //print out how many link is missing text
        System.out.println("the number of link that does NOT  have text: "+linkWithoutText);

       //print out how many link has text
        System.out.println("the number of links that has text: "+linkWithText);

        //Total link
        System.out.println("Total links on this page: "+linkOfLinks.size());


    }
}