package com.steps;

import com.context.TestContext;
import com.pages.Formpage;
import com.pages.LoginPage;

import io.cucumber.java.en.When;

public class FormSteps {

	private Formpage formPage;

	public FormSteps(TestContext testContext) {
		formPage = new Formpage(testContext.getDriver());
	}

	@When("I enter firstname and lastname")
	public void i_enter_firstname_and_lastname() {

		formPage.enterFirstname("John");
		formPage.enterLastname("Doe");
	}

}
