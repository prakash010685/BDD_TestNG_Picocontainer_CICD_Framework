package com.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.context.ScenarioContext;
import com.context.TestContext;
import com.driver.DriverFactory;
import com.google.common.io.Files;
import com.utils.BaseTest;
import com.utils.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

	private TestContext testContext;

	public Scenario scenario;
	public static ExtentReports extentReports;
	public static ExtentTest test;
	public static ExtentSparkReporter spark;
	public static com.utils.ExtentReportManager extentReportManager;
	public static String workDir = System.getProperty("user.dir");
	public static String Path = "./src/test/resource/Inputs/TestData.xlsx";
	public static String excelPath = workDir + Path;
	public String testcasename;
	public com.utils.ConfigFileReader configFileReader;
	public static String url;
	
	ScenarioContext scenarioContext;

	// PicoContainer injects this automatically
	public Hooks(TestContext testContext, ScenarioContext scenarioContext) {
		this.testContext = testContext;
		this.scenarioContext = scenarioContext;
	}

	@Before
	public void beforeScenario(Scenario scenario) throws Throwable {

		System.out.println("**********Starting the Scenario**********");
		
		testContext.scenarioName=scenario.getName();
		System.out.println(" BEFORE Thread ID: " + Thread.currentThread().getId() + " - Scenario: " + scenario.getName());
		testContext.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(10000);
	
	}

	@After
	public void afterScenario(Scenario scenario) {
		
//		if (scenario.isFailed()) {
//	
//			TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
//			final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//			scenario.embed(src, "image/png", scenario.getName());
//		//	scenario.attach(src, "image/png", "Fail screenshot");
//			log.info("***********************Scenario steps FAILED :: ****************************");
//
//		} else {
//			log.info("***********************Scenario steps PASSED :: ****************************");
//		}
		
		
		
		if (scenario.isFailed()) {

            try {
                // Get failed element from ThreadLocal or context
                WebElement failedElement = TestContext.getFailedElement();

                if (failedElement != null) {
                    ScreenshotUtil.highlightElement(DriverFactory.getDriver(), failedElement);
                }

                String path = ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(), scenario.getName());
                
                TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
    			final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
    			scenario.embed(src, "image/png", scenario.getName());
    	

//                byte[] screenshot = Files.readAllBytes(Paths.get(path));
//                scenario.attach(screenshot, "image/png", "Failed Step");

            } catch (Exception e) {
                e.printStackTrace();
            }
		
		
		System.out.println(" AFTER Thread ID: " + Thread.currentThread().getId() + " - Scenario: " + scenario.getName());
		System.out.println("|********************Ending the Scenario*******************|");
	//	DriverFactory.quitDriver();
	}

	}
}
