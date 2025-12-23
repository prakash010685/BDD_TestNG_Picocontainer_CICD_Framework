package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Formpage {
	
	protected WebDriver driver;

    public Formpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
    
    @FindBy(xpath = "//input[@id=\"firstName\"]")
	private WebElement txtFirstname;
	
    @FindBy(xpath = "//input[@id=\"lastName\"]")
	private WebElement txtLastname;
    
    @FindBy(xpath = "//input[@id=\"email\"]")
	private WebElement textEmail;
    
    @FindBy(xpath = "//input[@id=\"phonenumber\"]")
	private WebElement txtPhonenumber;

	@FindBy(xpath = "//textarea[@id=\"address\"]")	
	private WebElement txtAddress;
	
	@FindBy(xpath = "//textarea[@id=\"country\"]")	
	private WebElement txtCountry;


	public void enterFirstname(String firstname) {
		txtFirstname.clear();
		txtFirstname.sendKeys(firstname);

	}
	
	public void enterLastname(String lastname) {
		txtLastname.clear();
		txtLastname.sendKeys(lastname);
	}
	
	public void enterPhonenumber(String phonenumber) {
		txtPhonenumber.clear();
		txtPhonenumber.sendKeys(phonenumber);
	}
	
	public void enterAddress(String address) {
		txtAddress.clear();
		txtAddress.sendKeys(address);
	}
	
	public void enterEmail(String email) {
		textEmail.clear();
		textEmail.sendKeys(email);
	}
	

}
