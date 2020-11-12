package com.heroku.home;

import com.heroku.page.HomePageSeleniumObjects;
import com.heroku.utility.BaseTest;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"Autocomplete","Autocomplete"},
                {"Buttons","Primary"},
                {"Checkbox","Checkboxes"},
                {"Datepicker","Datepicker"},
                {"Drag and Drop","Drag the image into the box"},
                {"Dropdown","Dropdown"},
                {"Enabled and disabled elements","Enabled and Disabled elements"},
                {"File Upload","File upload"},
                {"Key and Mouse Press","Keyboard and Mouse Input"},
                {"Modal","Modal"},
                {"Radio Button","Radio buttons"},
                {"Page Scroll","Large page content"},
                {"Switch Window","Switch Window"},
                {"Complete Web Form","Complete Web Form"}
        };
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test (dataProvider = "data-provider")
    public void myTest (String val, String val2) throws InterruptedException {
        if(!val.equals("Autocomplete")) {
            Thread.sleep(1000);
            driver.navigate().back();
        }
        String name= homePageObject.getElementForAuto(val);
        logger.info("Name of h1 : " + name);
        Assert.assertEquals(val2, name);
    }

}
