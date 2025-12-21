package com.steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.context.ScenarioContext;
import com.utils.ConfigFileReader;


import io.cucumber.java.en.Given;

public class DataLoadSteps {

//	private ScenarioContext context;
//	ConfigFileReader configFileReader;
//
//	public DataLoadSteps(ScenarioContext context) {
//		this.context = context;
//	}
//
//	@Given("load test data from {string} and {string}")
//	public void load_test_data(String sheetName, String testCaseId) throws IOException {
//		
//		String Path = System.getProperty("user.dir") + "/src/test/resource/config.properties";
//		System.out.println(Path);
//		Properties properties = new Properties();
//		FileInputStream inputfile = new FileInputStream(Path);
//		properties.load(inputfile);
//		inputfile.close();
//
//		String excelPath =  properties.getProperty("excelPath");
//
//		context.setTestData(ExcelReader.getTestData(excelPath, sheetName, testCaseId));
//
//		System.out.println("Loaded data for: " + testCaseId);
//	}

}
