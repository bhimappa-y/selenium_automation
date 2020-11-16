package com.heroku.home;

import com.heroku.page.AutocompletePageSeleniumObjects;
import com.heroku.utility.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Autocomplete extends BaseTest {
    private static Logger logger= Logger.getLogger(Autocomplete.class);
    private WebDriver driver;
    private AutocompletePageSeleniumObjects autocompletePage;

    @BeforeClass
    public void Before() throws InterruptedException {
        driver = setup();
        autocompletePage = new AutocompletePageSeleniumObjects(driver);
        String name= autocompletePage.getElementForAuto("Autocomplete");
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
