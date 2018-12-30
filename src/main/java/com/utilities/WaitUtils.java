package com.utilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class WaitUtils {

    WebDriver driver;

   public WaitUtils(WebDriver driver)
    {
        this.driver = driver;
    }

    private static final long SHORT_TIMEOUT = 5;
    private static final long LONG_TIMEOUT = 25;
    private static final long MEDIUM_TIMEOUT = 10;

    public WebElement getElementAfterShortWait(WebElement ele)
    {
        return getElementAfterWait(ele,SHORT_TIMEOUT);
    }

    public WebElement getElementAfterLongWait(WebElement ele)
    {
        return getElementAfterWait(ele,LONG_TIMEOUT);
    }

    public WebElement getElementAfterMediumWait(WebElement ele)
    {
        return getElementAfterWait(ele,MEDIUM_TIMEOUT);
    }

    private WebElement getElementAfterWait(WebElement ele , long timeout)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return  wait.until(ExpectedConditions.visibilityOf(ele));
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public WebElement waitForElementToEnabled(WebElement ele)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, MEDIUM_TIMEOUT);
            return wait.until(ExpectedConditions.elementToBeClickable(ele));
        }catch(TimeoutException e)
        {
            e.printStackTrace();
            return  null;
        }

    }

    public void waitForElementToDisappear(WebElement ele)
    {

            WebDriverWait wait = new WebDriverWait(driver, MEDIUM_TIMEOUT);
            wait.until(ExpectedConditions.invisibilityOf(ele));
//            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }



}
