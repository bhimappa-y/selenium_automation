package com.heroku.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementUtility {

    public static String getEleText(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        return  driver.findElement(By.cssSelector("h1")).getText();

    }

    public static WebElement getElement(WebDriver driver, String parameterElement) {
        String ele = "//a[contains(text(), '"+parameterElement+"')]";
        List<WebElement> webElements = new WebDriverWait(driver, 10).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ele)));
        return webElements.get(1);
    }
}
