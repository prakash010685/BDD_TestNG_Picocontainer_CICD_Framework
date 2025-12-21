package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    @FindBy(xpath = "//input[@name=\"username\"]")
	private WebElement txtUsername;

	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement txtPassword;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//span[@class=\"oxd-userdropdown-tab\"]")
	private WebElement profileDropDown;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement btnLogOut;
	
	

	public void launchApp() throws Throwable {

//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		Thread.sleep(10000);
//		System.out.println("Application launched successfully");

	}

	public void enterUsername(String username) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
		
		
	}

	public void enterPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {
		btnLogin.click();
	}
	
	public void logout() throws Throwable {
		
		profileDropDown.click();
		Thread.sleep(3000);
		btnLogOut.click();
		
	}
	
	

}
