package com.runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"junit:target/cucumber-reports/Cucumber.xml", "pretty",
		"json:target/cucumber-reports/Cucumber.json","json:target/cucumber-reports/Cucumber.html" ,"rerun:target/rerun.txt"}, 
features = {"./src/test/resource/com/features" },
		glue = { "/com/steps"},
		monochrome = true,
		strict = true,
		dryRun = false,
		tags = "@AITest1"
		)

//public class ParallelRunner extends AbstractTestNGCucumberTests{
//
//	@Override
//    @DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}
//	
//}


public class ParallelRunnerTest{

	
	

}
