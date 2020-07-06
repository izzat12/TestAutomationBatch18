package day5_TestElement;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG {

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass is running.....");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass is running.........");

    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before method running...");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After method running...");
    }

    @Test
    public void test1(){
        System.out.println("Test1 is running....");

        Assert.assertEquals("String1","String1","String verifications on test1 failed");
    }

    @Ignore
    @Test
    public void test3(){
        System.out.println("Test3 is running...");

        String actaulTitle = "Amazon prime";
        String expectedInTitle = "prime";
        String testString = "asdasdas";

        Assert.assertTrue(false);
        Assert.assertTrue(actaulTitle.contains(expectedInTitle));
       // Assert.assertFalse(actaulTitle.contains(expectedInTitle));

        System.out.println("Just checking if this line is running");
       // Assert.assertFalse(actaulTitle.contains(testString));
    }

    @Test
    public void test2 (){
        System.out.println("Test2 is running");
    }
}
