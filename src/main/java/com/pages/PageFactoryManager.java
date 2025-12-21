package com.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
	
	private static LoginPage loginPage;
	private static Formpage formpage;
	
	public static LoginPage getLoginPage(WebDriver driver) {
		return loginPage == null? new LoginPage(driver): loginPage;
	}
	
	public static Formpage getFormpage(WebDriver driver) {
		return formpage == null ? new Formpage(driver): formpage;
	}

	
	
	
	
	

}
