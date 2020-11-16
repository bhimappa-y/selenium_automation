package com.heroku.page;

import com.heroku.utility.BaseTest;
import com.heroku.utility.ElementUtility;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxPageSeleniumObjects implements BasicMethodimplementation {
    private static Logger logger= Logger.getLogger(CheckBoxPageSeleniumObjects.class);

    private final WebDriver driver;


    public CheckBoxPageSeleniumObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Override
    public String getElementForAuto(String autocomplete) throws InterruptedException {
        ElementUtility.getElement(this.driver,autocomplete).click();
        return ElementUtility.getEleText(this.driver);
    }

    public boolean clickCheckBoxs(String id) {
        WebElement El = new WebDriverWait(driver, 10 ).
                until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        El.click();

        if(El.isSelected())
            logger.info("check-box is enabled!!!");

        return El.isSelected();

    }
}
