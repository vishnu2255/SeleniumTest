package com.pages.loginPage;

import com.pages.basePage.BasePage;
import com.utilities.WaitUtils;
import com.utilities.reader.TestDataReader;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

//LoadableComponent<LoginPage>
@Slf4j
public class LoginPage extends BasePage<LoginPage> {

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement uname;

    @FindBy(xpath = "//*[@id=\"pass\"]")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"loginbutton\"]")
    WebElement loginButton;

    WebDriver driver;
    WaitUtils waitUtils;

    public LoginPage(WebDriver driver)
    {

        super(driver);
        this.driver = driver;
        //PageFactory.initElements(driver,this);
    }

    public void login()
    {
         TestDataReader testDataReader = new TestDataReader();
         String user = testDataReader.getLoginData("USERNAME");
         String pass = testDataReader.getLoginData("PASSWORD");

         log.info("login page "+user);
//         waitUtils.getElementAfterShortWait(uname).sendKeys(user);
//         waitUtils.getElementAfterShortWait(password).sendKeys(pass);
//         waitUtils.getElementAfterShortWait(submit).click();

         uname.sendKeys(user);
         password.sendKeys(pass);

    }

    @Override
    protected void load() {
        driver.get("https://www.facebook.com/login/device-based/regular/login/");
    }

    @Override
    protected void isLoaded() throws Error {
        try{

            if(!driver.getCurrentUrl().contains("https://www.facebook.com/login/device-based/regular/login/"))
            {
                throw new Error();
            }
        }catch (Exception e)
        {
            System.out.println("login page not loaded");
        }
    }


}
