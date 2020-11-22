package com.heroku.home;

import com.heroku.page.SeleniumPageObjects;
import com.heroku.utility.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class KeyAndMouse extends BaseTest {


    private static Logger logger= Logger.getLogger(KeyAndMouse.class);
    private WebDriver driver;
    private SeleniumPageObjects checkBoxPage;

    @BeforeClass
    public void Before() throws InterruptedException {
        driver = setup();
        checkBoxPage = new SeleniumPageObjects(driver);
        String header = checkBoxPage.getElementForAuto("Key and Mouse Press");
        Assert.assertEquals("Keyboard and Mouse Input",header);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }


    @Test
    public void clickCheckBox() throws InterruptedException {
        logger.info("Executing CheckBox test case02!!!!!");
        WebElement txtUsername = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .moveToElement(txtUsername)
                .click()
                .keyDown(txtUsername, Keys.SHIFT)
                .sendKeys(txtUsername, "hello")
                .keyUp(txtUsername, Keys.SHIFT)
                .doubleClick(txtUsername)
                .contextClick()
                .build();

        seriesOfActions.perform() ;
    }





}
