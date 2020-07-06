package day9_testBase_properties;

import Utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingFromProperties {

    @Test
    public void reading_Properties_file() throws IOException {

        Properties prop = new Properties();

        String path = "configuration.properties";

        //we need to open this configuration file in java memory
        FileInputStream file = new FileInputStream(path);

        prop.load(file);

        System.out.println("Properties.getProperty(\"browser\") = "+prop.getProperty("browser"));
        System.out.println("Properties.getProperty(\"username\") = "+prop.getProperty("username"));


    }


    @Test
    public void using_Confirguration_reader_utility(){

       String browser =  ConfigurationReader.getProperty("browser");
        System.out.println("Browser: = "+browser);

        String username =  ConfigurationReader.getProperty("username");
        System.out.println("Username: = "+username);

        String password =  ConfigurationReader.getProperty("password");
        System.out.println("Password: = "+password);


    }

}

