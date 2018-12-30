package com.steps.ui;

import com.pages.loginPage.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.Dummy2;
import com.utilities.DummyDriver;
import com.utilities.extentReports.ExtentTestManager;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PicoSteps extends DriverFactory {

    Logger logger = LoggerFactory.getLogger(PicoSteps.class);

    private DummyDriver base;
    private Dummy2 dum;
    private LoginPage loginPage;


    public PicoSteps(DummyDriver base,Dummy2 dum) {

        this.base = base;
        this.dum  = dum;
        loginPage = new LoginPage(driver);

    }

    @Given("^I am on login page$")
    public void i_am_on_login_page() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        ExtentTestManager.startTest("login page","initializing login page");
//        logger.info("Initializing login page URI");
//        driver.get("https://www.facebook.com/");
        loginPage.get();

        ExtentTestManager.getTest().log(LogStatus.PASS,"login passed");

        ExtentTestManager.endTest();
        //System.out.println("picosteps "+ base.text + " dummy "+ dum.temp);

    }
}
