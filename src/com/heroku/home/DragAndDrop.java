package com.heroku.home;

import com.heroku.page.SeleniumPageObjects;
import com.heroku.utility.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DragAndDrop extends BaseTest {
    private static Logger logger= Logger.getLogger(DragAndDrop.class);
    private WebDriver driver;
    private SeleniumPageObjects checkBoxPage;


    @BeforeClass
    public void Before() throws InterruptedException {
        driver = setup();
        checkBoxPage = new SeleniumPageObjects(driver);
        String header = checkBoxPage.getElementForAuto("Drag and Drop");
        Assert.assertEquals("Drag the image into the box",header);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void testDragAndDrop(){
        logger.info("this is drag and drop test!!!");
        Assert.assertEquals("Dropped!", checkBoxPage.performDragAndDrop() );
    }

}
