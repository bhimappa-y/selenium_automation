package com.heroku.page;

import com.heroku.utility.BaseTest;
import com.heroku.utility.ElementUtility;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AutocompletePageSeleniumObjects implements BasicMethodimplementation{
    private static Logger logger= Logger.getLogger(HomePageSeleniumObjects.class);
    WebDriver driver;

    public AutocompletePageSeleniumObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.ID, using = "autocomplete")
    WebElement autoComplete ;

    @Override
    public String getElementForAuto(String autocomplete) throws InterruptedException {
        ElementUtility.getElement(this.driver,autocomplete).click();
        return ElementUtility.getEleText(this.driver);
    }



    public void fillForm() {
        autoComplete.sendKeys("T Narsipura");
        WebElement webElement =  new WebDriverWait(driver, 10).
                                    until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pac-item")));
        webElement.click();

    }

}
