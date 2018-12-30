package com.utilities.webDriver;

import com.utilities.webDriver.SelectDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@Slf4j
public class DriverFactory {


    protected static WebDriver driver;

    public DriverFactory()
    {
        initializeDriver();
    }

    public void initializeDriver()
    {
        log.info("Driver factory");
        if(driver == null)
        {
            driver  =  SelectDriver.getDriver();
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public void destroyDriver()
    {
        if(driver != null)
        {
            driver.quit();
            driver = null;
        }
    }

}
