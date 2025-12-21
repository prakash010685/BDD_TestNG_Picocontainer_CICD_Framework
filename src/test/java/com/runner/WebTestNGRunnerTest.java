package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"junit:target/cucumber-reports/Cucumber.xml", "pretty", "json:target/cucumber-reports/Cucumber.json",
		"rerun:target/rerun.txt" }, features = { "./src/test/resource/com/features" }, glue = { "/com/steps" },
		// glue= {"steps"},
		monochrome = true, strict = true,

		dryRun = false
// tags = "@Form"
)

public class WebTestNGRunnerTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
