package com.steps.ui;

import com.pages.loginPage.LoginPage;
import com.utilities.Dummy2;
import com.utilities.DummyDriver;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PicoSteps2 extends DriverFactory {

    Logger logger = LoggerFactory.getLogger(PicoSteps2.class);
    private LoginPage loginPage;

    private DummyDriver base;
    private Dummy2 dum;

   public PicoSteps2(DummyDriver base,Dummy2 dum)
    {
        this.base = base;
        this.dum  = dum;
        loginPage = new LoginPage(driver);
    }

    @When("^I give valid username and password$")
    public void i_give_valid_username_and_password() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Login giving creds");
      //  loginPage = new LoginPage(driver);
        loginPage.login();
//        System.out.println("picosteps2 "+ base.text +" dummy , "+dum.temp) ;
    }

        @Then("^I should navigate to home page$")
    public void i_should_navigate_to_home_page() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        logger.info("home page navigation");

    }


}
