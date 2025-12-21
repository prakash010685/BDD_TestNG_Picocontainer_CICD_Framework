package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadPropertyFile {
	
private Properties properties;
	
	public void readfile() throws IOException {
		
		
		 String  Path = System.getProperty("user.dir")+"./src/test/resource/com/qa/configs/configuration.properties";
			
		 System.out.println(Path);
		 
		 FileInputStream inputfile=new FileInputStream(Path);
			properties=new Properties();
			properties.load(inputfile);
			inputfile.close();
		//	String browser=properties.getProperty("Browser");
		//	String executionType=properties.getProperty("ExecutionMode");
			System.out.println("Browser mode :: "+ properties.getProperty("Browser"));
			System.out.println("Execution mode :: "+ properties.getProperty("ExecutionMode"));	
	}
	
	
	
	public static void main(String[] arg) throws IOException {
		
		ReadPropertyFile fi=new ReadPropertyFile();
		fi.readfile();
		
		
	}

}
