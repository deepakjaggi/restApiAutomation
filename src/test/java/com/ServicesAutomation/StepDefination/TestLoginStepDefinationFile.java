package com.ServicesAutomation.StepDefination;

import java.util.List;

import com.ServicesAutomation.common.CommonDataObjects;
import com.ServicesAutomation.login.LoginWorkFlow;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import servicesAutomation.models.LoginModel;

public class TestLoginStepDefinationFile {

	@Given("^LoginData$")
	public void logindata(List<LoginModel> loginData) throws Throwable {
		CommonDataObjects.loginData = loginData.get(0);		
	}

	@When("^user will hit the login service$")
	public void user_will_hit_the_login_service() throws Throwable {		
		if (new LoginWorkFlow().verifyLogin(CommonDataObjects.loginData, null)) {
			System.out.println(CommonDataObjects.loginData.useCase +  "  -- Pased");
			// assertEquals(true, true);
		} else {
			System.out.println(CommonDataObjects.loginData.useCase +  "  -- Failed");
			// assertEquals(true, false);
		}		
	}

	@Then("^verify test result$")
	public void verify_test_result() throws Throwable {
	}

}
