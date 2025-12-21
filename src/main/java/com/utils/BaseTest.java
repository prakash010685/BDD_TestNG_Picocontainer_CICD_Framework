package com.utils;

import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class BaseTest {
	
	public static ExtentReports extentReports;
	public static ExtentTest test;
	public static ExtentSparkReporter spark;
	   public static String reportPath=System.getProperty("user.dir")+"./test-output/HtmlReport/Automation_Report.html";	
	   public static Logger log=org.apache.logging.log4j.LogManager.getLogger(BaseTest.class);
		
		public static void setupExtentReport() {
		
			spark=new ExtentSparkReporter(reportPath);
			extentReports=new ExtentReports();
			extentReports.attachReporter(spark);
			
			log.info("Extent Reprot initialized : ");
			
		
		
		}

}
