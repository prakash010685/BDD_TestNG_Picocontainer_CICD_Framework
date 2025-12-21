package com.context;

import java.util.Map;

public class ScenarioContext {

	private Map<String, String> testData;
	


	public void setTestData(Map<String, String> testData) {
		this.testData = testData;
	}

	public String getData(String key) {
		return testData.get(key);
	}

}
