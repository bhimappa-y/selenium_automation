package com.heroku.home;

import com.heroku.page.SeleniumPageObjects;
import com.heroku.utility.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Autocomplete extends BaseTest {
    private static Logger logger= Logger.getLogger(Autocomplete.class);
    private WebDriver driver;
    private SeleniumPageObjects autocompletePage;

    @BeforeClass
    public void Before() throws InterruptedException {
        driver = setup();
        autocompletePage = new SeleniumPageObjects(driver);
        String name= autocompletePage.getElementForAuto("Autocomplete");
        Assert.assertEquals(name, "Autocomplete" );
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void fillAutoCompleteForm() throws InterruptedException {
        logger.info("Inside fill Autocomplete form!!!");
        autocompletePage.fillForm();
    }

}
