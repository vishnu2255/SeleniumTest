package com.steps.ui;


import com.utilities.webDriver.SelectDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TestJun {


    public void test() throws Exception
    {

//        System.setProperty("webdriver.gecko.driver","/Users/vishnupatlolla/IdeaProjects/geckodriver");
//        WebDriver driver = new FirefoxDriver();

        WebDriver driver = SelectDriver.getFirefoxDriver();
        driver.get("https://www.facebook.com/");

        //*[@id="__w2_w5QTvWfU18_email"]

        Thread.sleep(5000);

//        driver.findElement(By.xpath("//*[@id=\"__w2_w5QTvWfU18_email\"]")).clear();
//        driver.findElement(By.xpath("//*[@id=\"__w2_w5QTvWfU18_email\"]")).sendKeys("Test");
//
//        driver.findElement(By.xpath("//*[@id=\"__w2_w5QTvWfU18_password\"]")).clear();
//        driver.findElement(By.xpath("//*[@id=\"__w2_w5QTvWfU18_password\"]")).sendKeys("test");
//
//
//        driver.findElement(By.xpath("//*[@id=\"__w2_w5QTvWfU18_submit_button\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("test");

    }


    @Test
    public void getCurrentDate()
    {
        DateFormat format = new SimpleDateFormat("MM-dd HH:mm:ss");
        Date date = new Date();

        System.out.println(format.format(date));

        //return format.format(date);
        System.out.println(RandomStringUtils.random(10,true,true));

        Random rd = new Random();
//        rd.nextInt(100);

        System.out.println(rd.nextInt(100));
    }



}
