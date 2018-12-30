package com.pages.homePage;

import com.pages.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

//LoadableComponent<HomePage>
public class HomePage extends BasePage<HomePage> {

    @FindBy(xpath = "//*[@id=\"u_0_2\"]")
    WebElement submit;
    private WebDriver driver;

   public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
//        PageFactory.initElements(driver,this);
    }


    @Override
    protected void load() {

        driver.get("https://www.facebook.com/");
    }

    @Override
    protected void isLoaded() throws Error {
        try{

            if(driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/"))
            {
                System.out.println("home page loaded");
            }

        }catch (Exception e)
        {
            System.out.println("home page not loaded");
        }
    }
//    https://www.facebook.com/login/device-based/regular/login/

}
