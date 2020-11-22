package com.heroku.home;

import com.heroku.page.SeleniumPageObjects;
import com.heroku.utility.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUpload extends BaseTest {
    private static Logger logger= Logger.getLogger(DragAndDrop.class);
    private WebDriver driver;
    private SeleniumPageObjects checkBoxPage;


    @BeforeClass
    public void Before() throws InterruptedException {
        driver = setup();
        checkBoxPage = new SeleniumPageObjects(driver);
        String header = checkBoxPage.getElementForAuto("File Upload");
        Assert.assertEquals("File upload" ,header);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }


    @Test
    public void testFileUpload() throws InterruptedException {
        logger.info("this is drag and drop test!!!");
        checkBoxPage.fileUpload();
    }


}
