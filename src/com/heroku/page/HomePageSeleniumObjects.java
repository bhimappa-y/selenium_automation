package com.heroku.page;

import com.heroku.utility.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageSeleniumObjects extends BaseTest {
    private static Logger logger= Logger.getLogger(HomePageSeleniumObjects.class);
    WebDriver driver;

    public HomePageSeleniumObjects(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String getElementForAuto(String autocomplete) throws InterruptedException {
        getElement(autocomplete).click();
        Thread.sleep(1000);
        return getEleText();
    }

    private String getEleText() {
       return driver.findElement(By.cssSelector("h1")).getText();
    }

    private WebElement getElement(String parameterElement) {
        String ele = "//a[contains(text(), '"+parameterElement+"')]";
        List<WebElement> elements = driver.findElements(By.xpath(ele));
        return elements.get(1);
    }

}
