package com.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenshotUtil {
	
	 public static String captureScreenshot(WebDriver driver, String screenshotName) {
	        try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File src = ts.getScreenshotAs(OutputType.FILE);

	            String path = System.getProperty("user.dir")
	                    + "/screenshots/" + screenshotName + ".png";

	            FileUtils.copyFile(src, new File(path));
	            return path;

	        } catch (Exception e) {
	            return null;
	        }
	    }
	
	 public static void highlightElement(WebDriver driver, WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript(
	            "arguments[0].style.border='3px solid red'", element);
	    }
	

}
