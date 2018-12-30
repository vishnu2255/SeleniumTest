package com.steps.ui;

import com.pages.homePage.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.extentReports.ExtentManager;
import com.utilities.extentReports.ExtentTestManager;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePageSteps extends DriverFactory {

    private HomePage homepage;
    Logger logger = LoggerFactory.getLogger(HomePageSteps.class);

    public HomePageSteps()
    {
        homepage = new HomePage(driver);
    }

    @Given("^I am on home page$")
        public void homePage()
        {
            ExtentTestManager.startTest("homepage","initializing home page");
//            logger.info("Loading Home Page");
            homepage.get();
            ExtentTestManager.getTest().log(LogStatus.PASS,"home page step passed");
            ExtentTestManager.endTest();
        }

}
