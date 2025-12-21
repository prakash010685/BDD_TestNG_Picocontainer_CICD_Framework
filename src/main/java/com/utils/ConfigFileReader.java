package com.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	//String path = System.getProperty("user.dir");
	private final String propertyFilePath = "/Users/prakashmohanraopatil/eclipse-workspace/BDD_Parallel_CICD_Framework/src/test/resource/com/configs/config.properties";
	
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Config.properties not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Config.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Config.properties file.");
	}
	
	public String getBrowser() {
		String Browser=properties.getProperty("Browser");
		return Browser;
	}
	
	public String getexecutionMode() {
		
		String execution=properties.getProperty("ExecutionMode");
		return execution;
		
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Config.properties file.");
	}

	public String getReportConfigPath() {
		// TODO Auto-generated method stub
		String reportConfigPath = properties.getProperty("/Users/prakashmohanraopatil/eclipse-workspace/BDD_Parallel_CICD_Framework/src/test/resource/com/configs/Extent-config.xml");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException("reportConfigPath not specified in the Config.properties file.");
	}

}
