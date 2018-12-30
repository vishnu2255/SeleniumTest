package com.utilities.webDriver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

@Slf4j
public class SelectDriver {

    static  String browser;

    static{
        browser = getBrowser();

    }

    public static String getBrowser()
    {
        String browser = null;

        if(browser == null)
        {
            browser = "firefox";
        }
        return browser;
    }

    public static WebDriver getDriver()
    {
        WebDriver driver = null;

        switch (browser.toLowerCase())
        {
            case "chrome":
               return null;
            case "safari":
               return null;
           default:
             return getFirefoxDriver();
        }
    }

    public static WebDriver getFirefoxDriver()
    {
        System.setProperty("webdriver.gecko.driver","/Users/vishnupatlolla/IdeaProjects/geckodriver");
        WebDriver driver = new FirefoxDriver();

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.dir", "/Users/vishnupatlolla/IdeaProjects/SeleniumTest/src/test/resources/downloads/");
        profile.setPreference("browser.helperapps.neverAsk.saveToDisk", "pdf");
        profile.setPreference("browser.download.folderList", 2);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        return new FirefoxDriver(options);
    }

}
