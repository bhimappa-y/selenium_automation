package com.heroku.page;

import com.heroku.utility.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePageSeleniumObjects implements BasicMethodimplementation{
    private static Logger logger= Logger.getLogger(HomePageSeleniumObjects.class);
    WebDriver driver;

    public HomePageSeleniumObjects(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getElementForAuto(String autocomplete) throws InterruptedException {
        if(autocomplete.equals("Buttons")){
            getElement(autocomplete).click();
            Thread.sleep(2000);
            return driver.findElement(By.xpath("//button[contains(text(),'Primary')]")).getText();
        }
        getElement(autocomplete).click();

        return getEleText();
    }

    private String getEleText() throws InterruptedException {
       //return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1"))).getText();
        Thread.sleep(1000);
        return  driver.findElement(By.cssSelector("h1")).getText();

    }

    private WebElement getElement(String parameterElement) {
        String ele = "//a[contains(text(), '"+parameterElement+"')]";
        List<WebElement> webElements = new WebDriverWait(driver, 10).
                                        until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ele)));
        return webElements.get(1);
    }

}
