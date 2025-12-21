package com.context;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.driver.DriverFactory;

public class TestContext extends ScenarioContext{
	
	private WebDriver driver;
    private DriverFactory driverFactory;
    private static ThreadLocal<Map<String,Object>> context=ThreadLocal.withInitial(HashMap::new);
    private Scenario scenario;
    public String scenarioName;
    
    
    public void set(String key, Object value) {
    	
    	context.get().put(key, value);
    	
    }
    
    public Object get(String key) {
    	
    	return context.get().get(key);
    }
    
    public String getString(String key) {
    	
    	return (String) context.get().get(key);
    }

    public void clear() {
    	
    	context.get().clear();
    	
    }
    public TestContext() {
        driverFactory = new DriverFactory();
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = driverFactory.initDriver();
        }
        return driver;
    }
    
	public Scenario getScenario() {
		
		String scenarioname = scenario.getGherkinName();
        System.out.println("|------------------------scenarioname"+scenarioname +"------------------------------|");
		return (Scenario) scenario;
	}

	public static WebElement getFailedElement() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	
	
	

}
