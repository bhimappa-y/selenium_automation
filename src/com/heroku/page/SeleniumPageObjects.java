package com.heroku.page;

import com.heroku.utility.ElementUtility;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumPageObjects implements BasicMethodimplementation{
    private static Logger logger= Logger.getLogger(SeleniumPageObjects.class);
    private WebDriver driver;


    public SeleniumPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "image")
    WebElement  imageId;

    @FindBy(how = How.ID, using = "box")
    WebElement  boxId;

    @FindBy(how = How.ID, using = "file-upload-field")
    WebElement fileUpload;

    @FindBy(how = How.ID, using = "input")
    WebElement input;

    @FindBy(how = How.ID, using = "autocomplete")
    WebElement autoComplete ;

    @Override
    public String getElementForAuto(String autocomplete) throws InterruptedException {
        ElementUtility.getElement(this.driver,autocomplete).click();
        Thread.sleep(1000);
        return ElementUtility.getEleText(this.driver);
    }

    public String dropDown() throws InterruptedException {
        WebElement el = new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdownMenuButton")));
        el.click();
        ElementUtility.getElement(this.driver, "Autocomplete");
        return ElementUtility.getEleText(driver);
    }

    public String performDragAndDrop() {
        Actions draganddrop = new Actions(this.driver);
        driver.navigate().refresh();
        draganddrop.dragAndDrop(imageId, boxId).build().perform();
        logger.info("dropped image in box!!!");

        return ElementUtility.getDropedText(driver);
    }

    public boolean disable() {
        WebElement el = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("disabledInput")));
        return  el.isDisplayed();
    }

    public boolean enable() {
        WebElement el = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(input));
        el.sendKeys("this input is enable test");
        return  el.isDisplayed();
    }

    public void fileUpload() throws InterruptedException {

        String filename = "lib\\files\\testfile.txt";
        WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(fileUpload));
        element.sendKeys(filename);
    }

    public boolean clickCheckBoxs(String id) {
        WebElement El = new WebDriverWait(driver, 10 ).
                until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        El.click();

        if(El.isSelected())
            logger.info("check-box is enabled!!!");

        return El.isSelected();
    }

    public void fillForm() throws InterruptedException {
        autoComplete.sendKeys("T Narsipura");
        Thread.sleep(1000);
        WebElement webElement =  new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pac-item")));

        webElement.click();

    }

}
