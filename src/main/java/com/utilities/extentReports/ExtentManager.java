package com.utilities.extentReports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

   private static ExtentReports extent;
   String path(){ return this.getClass().getClassLoader().getResource("reports/").getPath();};

   public static ExtentReports getReporter() {
       if (extent == null) {

           extent = new ExtentReports("/Users/vishnupatlolla/IdeaProjects/SeleniumTest/src/Test.html");
       }
       return extent;
   }



}
