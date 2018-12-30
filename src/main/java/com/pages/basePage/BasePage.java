package com.pages.basePage;

import com.utilities.WaitUtils;
import com.utilities.reader.TestDataReader;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

@Slf4j
public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    protected WaitUtils waitUtils;
    protected WebDriver driver;
    protected TestDataReader testDataReader;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        testDataReader = new TestDataReader();
        PageFactory.initElements(driver,this);
        log.info("base page");
    }

}
