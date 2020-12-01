package com.heroku.home;

import com.heroku.page.SeleniumPageObjects;
import com.heroku.utility.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EnableAndDisable extends BaseTest {
    private static Logger logger= Logger.getLogger(EnableAndDisable.class);
    private WebDriver driver;
    private SeleniumPageObjects checkBoxPage;

    @BeforeClass
    public void Before() throws InterruptedException {
        driver = setup();
        checkBoxPage = new SeleniumPageObjects(driver);
        checkBoxPage.getElementForAuto("Enabled and disabled elements");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void testEnableAndDisable(){
        logger.info("this is disable test!!!");
        Assert.assertTrue(checkBoxPage.disable());
        logger.info("this is enable test!!!");
        Assert.assertTrue(checkBoxPage.enable());
    }

}
