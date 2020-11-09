package com.heroku.utility;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    private static Logger logger= Logger.getLogger(BaseTest.class);
    private static Properties pros;

    private static WebDriver driver;
    static {
        Properties props = System.getProperties();
        System.out.println("Current working directory is " + props.getProperty("user.dir"));
        PropertyConfigurator.configure("log4j.properties");
    }

    public static WebDriver setup(){
        try {
            System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
            driver = new ChromeDriver();
            pros = new Properties();
            InputStream ip= new FileInputStream("config.properties");
            pros.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info(pros.getProperty("url"));
        driver.get(pros.getProperty("url"));
        driver.manage().window().maximize();
        return driver;
    }

}
