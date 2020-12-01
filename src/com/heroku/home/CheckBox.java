package com.heroku.home;

import com.heroku.page.SeleniumPageObjects;
import com.heroku.utility.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBox extends BaseTest {

    private static Logger logger= Logger.getLogger(CheckBox.class);
    private WebDriver driver;
    private SeleniumPageObjects checkBoxPage;

    @BeforeClass
    public void Before() throws InterruptedException {
        driver = setup();
        checkBoxPage = new SeleniumPageObjects(driver);
        checkBoxPage.getElementForAuto("Checkbox");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void clickCheckBoxe01() throws InterruptedException {
        logger.info("Executing CheckBox test case01!!!!!");
        Assert.assertTrue(checkBoxPage.clickCheckBoxs("checkbox-1"));

    }

    @Test
    public void clickCheckBoxe02() throws InterruptedException {
        logger.info("Executing CheckBox test case02!!!!!");
        Assert.assertTrue(checkBoxPage.clickCheckBoxs("checkbox-2"));
    }

    @Test
    public void clickCheckBoxe03() throws InterruptedException {
        logger.info("Executing CheckBox test case03!!!!!");
        Assert.assertTrue(checkBoxPage.clickCheckBoxs("checkbox-3"));

    }
}
