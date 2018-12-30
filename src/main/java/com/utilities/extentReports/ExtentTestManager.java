package com.utilities.extentReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    static Map<Integer,ExtentTest> extentMap = new HashMap<Integer,ExtentTest>();
    static ExtentReports extent = ExtentManager.getReporter();

    public static ExtentTest getTest()
    {
    return (ExtentTest)extentMap.get((int)(long)(Thread.currentThread()).getId());
    }

    public static ExtentTest startTest(String test,String desc)
    {
        ExtentTest tes = extent.startTest(test,desc);
        extentMap.put((int)(long)(Thread.currentThread()).getId(),tes);
        return tes;
    }

    public static void endTest()
    {
        extent.endTest((ExtentTest)extentMap.get((int)(long)(Thread.currentThread()).getId()));
    }
}
