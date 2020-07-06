package day9_testBase_properties;

import org.testng.annotations.Test;

public class LearningPractice {

    @Test
    public void javaProperties(){

        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
    }
}
