//package com.steps.ui;
//
//import com.pages.loginPage.LoginPage;
//import com.utilities.reader.TestDataReader;
//import com.utilities.webDriver.DriverFactory;
//import com.utilities.webDriver.SelectDriver;
//import cucumber.api.DataTable;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class LoginSteps extends  DriverFactory{
//
//    private LoginPage loginPage;
////    private WebDriver driver = SelectDriver.getFirefoxDriver();
//
//    public LoginSteps()
//    {
//        loginPage = new LoginPage(driver);
//    }
//
//    Logger logger = LoggerFactory.getLogger(LoginSteps.class);
//
//    @Given("^I am on login page$")
//    public void i_am_on_login_page() throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//
//        logger.info("Initializing URI");
//        driver.get("https://www.facebook.com/");
//
//
//    }
//
//    @When("^I give valid username and password$")
//    public void i_give_valid_username_and_password() throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//        logger.info("Login");
//      //  loginPage = new LoginPage(driver);
//        loginPage.login();
//
//
//    }
//
//    @Then("^I should navigate to home page$")
//    public void i_should_navigate_to_home_page() throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//        logger.info("home page navigation");
//
//    }
//
//
//    @Given("^I give multiple sets of data$")
//    public void iGiveMultipleSetsOfData(DataTable table) {
//
//         List<User> lis =   new ArrayList<User>();
//         lis = table.asList(User.class);
//
//         for(User user : lis)
//         {
//            System.out.println("Username is "+user.name+" id is "+user.id + " num is "+user.num);
//         }
//
//
////           System.out.println(lis.get(1).get(0) + " , "+ lis.get(1).get(1));
//    }
//
//    @Then("^print names$")
//    public void printNames() {
//
//        System.out.println("Print NamES");
//    }
//
//    @Given("^I give (.*) and (.*) records$")
//    public void iGiveNameAndIdRecords(String name, String id) {
//
//        System.out.println("name is "+name+ " id "+id);
//    }
//
//
//    class User
//    {
//        String name;
//        String id;
//        String num;
//
//        public User(String name,String id,String num)
//        {
//            this.name = name;
//            this.id = id;
//            this.num = num;
//        }
//
//    }
//}
