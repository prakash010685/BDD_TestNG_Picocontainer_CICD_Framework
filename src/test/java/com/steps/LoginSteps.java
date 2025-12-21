package com.steps;

import com.context.ScenarioContext;
import com.context.TestContext;
import com.pages.LoginPage;
import com.pages.PageFactoryManager;
import com.utils.ConfigFileReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class LoginSteps {

	private LoginPage loginPage;
	private ScenarioContext scenarioContext;
	ConfigFileReader configFileReader;
	private TestContext testContext;

	public LoginSteps(TestContext testContext) {
		
	//	super(testContext);
		loginPage = PageFactoryManager.getLoginPage(testContext.getDriver());

		System.out.println("STEP DEF: DI: SCENARIO NAME ::" + testContext.scenarioName);

	}

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
//		System.out.println("Excel Sheet path :: " + excelPath);
//
//	//	scenarioContext.setTestData(ExcelReader.getTestData(sheetName, testCaseId));
//
//		System.out.println("Loaded data for: " + testCaseId);
//	}
//	

	@Given("I want launch Orange HRM Application")
	public void i_want_launch_Orange_HRM_Application() throws Throwable {

		loginPage.launchApp();

	}

	@When("I enter {string} and {string}")
	public void i_enter_and(String username, String password) {
		
		String userID=username;
		String pass= password;
		
// Set into Picocontainer :
		
		testContext.set("USERNAME", userID);
		testContext.set("PASSWORD", pass);
		System.out.println("USERNAME :-" + userID +" " + "PASSWORD:-" + pass);

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);

	}

	@When("I Click on Login buttom")
	public void i_Click_on_Login_buttom() {
		loginPage.clickLogin();

	}

	@When("I enter username and password")
	public void i_enter_username_and_password() {

		String userName = testContext.getString("userID");
		String passWord = testContext.getString("pass");

		System.out.println("Fetch Username from picocontainer ::" + userName + " : " + "Fetch password from picocontainer :: " + passWord);

		loginPage.enterUsername(userName);
		loginPage.enterPassword(passWord);

	}

	@When("I Click on Logout button")
	public void i_Click_on_Logout_button() throws Throwable {
		Thread.sleep(10000);
		loginPage.logout();
	}

}
