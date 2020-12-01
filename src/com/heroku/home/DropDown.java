package com.heroku.home;

import com.heroku.page.SeleniumPageObjects;
import com.heroku.utility.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DropDown extends BaseTest {

    private static Logger logger= Logger.getLogger(DropDown.class);
    private WebDriver driver;
    private SeleniumPageObjects checkBoxPage;

    @BeforeClass
    public void Before() throws InterruptedException {
        driver = setup();
        checkBoxPage = new SeleniumPageObjects(driver);
        String header = checkBoxPage.getElementForAuto("Dropdown");
        Assert.assertEquals("Dropdown",header);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"Autocomplete","Autocomplete"},
                {"Checkbox","Checkboxes"},
                {"Datepicker","Datepicker"},
                {"Drag and Drop","Drag the image into the box"},
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

    @Test ( dataProvider = "data-provider")
    public void clickCheckBoxe02(String val, String val2) throws InterruptedException {
        logger.info("Executing CheckBox test case02!!!!!");
        if(!val.equals("Autocomplete")) {
            Thread.sleep(1000);
            driver.navigate().back();
        }
        String str = checkBoxPage.dropDown();
        String name= checkBoxPage.getElementForAuto(val);
        logger.info("Name of h1 : " + name);
        Assert.assertEquals(val2, name);
    }



}
