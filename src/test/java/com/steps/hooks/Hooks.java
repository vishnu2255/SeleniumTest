//package com.steps.hooks;
//
//import com.utilities.webDriver.DriverFactory;
//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import lombok.extern.slf4j.Slf4j;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Slf4j
//public class Hooks {
//
//    //Logger logger = LoggerFactory.getLogger(Hooks.class);
//
//    @Before
//    public void before(Scenario scenario)
//    {
//        log.info("Starting Test "+scenario.getName());
//    }
//
//    @After
//    public void after(Scenario scenario)
//    {
//        DriverFactory driverFactory = new DriverFactory();
//
//        if(scenario.isFailed())
//        {
//            log.info("Taking Screenshot");
//            final byte[] screenshot =  ((TakesScreenshot)driverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshot,"image/png");
//        }
//
//        driverFactory.destroyDriver();
//        log.info("Finishing Test "+scenario.getName());
//    }
//
//}
