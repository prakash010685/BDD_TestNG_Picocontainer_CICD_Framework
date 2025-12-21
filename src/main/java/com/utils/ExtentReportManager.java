package com.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReportManager {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void startReport() {
		
		String reportPath=System.getProperty("user.dir")+"./test-output/Report.html";
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(reportPath);
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Automation Team QA: ", "PRAKASH");		
		
	}
	
	public static String captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
		
		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String destination=System.getProperty("user.dir")+"./Screenshots"+ screenshotName+dateName+".png";
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desct=new File(destination);
		
		try {
			org.openqa.selenium.io.FileHandler.copy(src, desct);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return screenshotName;
	}
	
private static SimpleDateFormat getCurrentTimestamp(String string) {
	return new SimpleDateFormat(getCurrentTimestamp("yyyy-MM-dd_HH-mm-ss").format(new Date()));
	
}	
	

}
