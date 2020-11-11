package com.heroku.home;

import com.heroku.page.HomePageSeleniumObjects;
import com.heroku.utility.BaseTest;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePge extends BaseTest {
    private static Logger logger= Logger.getLogger(HomePge.class);
    private WebDriver driver;
    private HomePageSeleniumObjects homePageObject;

    @BeforeClass
    public void Before(){
        driver = setup();
        homePageObject = new HomePageSeleniumObjects(driver);
    }
    @AfterClass
    public void tearDown(){
        logger.info("------tear down-----");
        driver.quit();
    }

   @Test
    public void test01_home_Page_Load() throws InterruptedException {
        logger.info("Title of the Page : "+driver.getTitle());
        Assert.assertEquals("Formy", driver.getTitle());
    }

    @Test
    public void test02_handle_Autocomplete() throws InterruptedException {
        String name= homePageObject.getElementForAuto("Autocomplete");
        logger.info("Name of h1 : " + name);
        Assert.assertEquals("Autocomplete", name);
    }

    @Test
    public void test03_button_click() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        String name= homePageObject.getElementForAuto("Buttons");
        logger.info("Name of h1 : " + name);
        Assert.assertEquals("Primary", name);
    }


    @Test
    public void test05_Datepicker() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        String name= homePageObject.getElementForAuto("Checkbox");
        logger.info("Name of h1 : " + name);
        Assert.assertEquals("Checkboxes", name);
    }

    @Test
    public void test06_checkBoxes() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        String name= homePageObject.getElementForAuto("Datepicker");
        logger.info("Name of h1 : " + name);
        Assert.assertEquals("Datepicker", name);
    }


    @Test
    public void test07_click_Data_Picker() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        String name= homePageObject.getElementForAuto("Drag and Drop");
        logger.info("Name of h1 : " + name);
        Assert.assertEquals("Drag the image into the box", name);
    }

    @Test
    public void test08_click_Drag_and_Drop() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        String name= homePageObject.getElementForAuto("Dropdown");
        logger.info("Name of h1 : " + name);
        Assert.assertEquals("Dropdown", name);
    }

    @Test
    public void test09_Enabled_and_disabled_elements() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        String name= homePageObject.getElementForAuto("Enabled and disabled elements");
        logger.info("Name of h1 : " + name);
        Assert.assertEquals("Enabled and Disabled elements", name);
    }

    @Test
    public void test10_File_Upload() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        String name= homePageObject.getElementForAuto("File Upload");
        logger.info("Name of h1 : " + name);
        Assert.assertEquals("File upload", name);
    }

    @Test
    public void test11_Key_and_Mouse_Press() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        String name= homePageObject.getElementForAuto("Key and Mouse Press");
        logger.info("Name of h1 : " + name);
        Assert.assertEquals("Keyboard and Mouse Input", name);
    }

    @Test
    public void test12_Modal() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        String name= homePageObject.getElementForAuto("Modal");
        logger.info("Name of h1 : " + name);
        Assert.assertEquals("Modal", name);
    }

    @Test
    public void test13_Page_Scroll() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        String name= homePageObject.getElementForAuto("Page Scroll");
        logger.info("Name of h1 : " + name);
        Assert.assertEquals("Large page content", name);
    }

    @Test
    public void test14_Radio_Button() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        String name= homePageObject.getElementForAuto("Radio Button");
        logger.info("Name of h1 : " + name);
        Assert.assertEquals("Radio buttons", name);
    }

    @Test
    public void test15_Switch_Window() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        String name= homePageObject.getElementForAuto("Switch Window");
        logger.info("Name of h1 : " + name);
        Assert.assertEquals("Switch Window", name);
    }

    @Test
    public void test16_Complete_Web_Form() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        String name= homePageObject.getElementForAuto("Complete Web Form");
        logger.info("Name of h1 : " + name);
        Assert.assertEquals("Complete Web Form", name);
    }

}
