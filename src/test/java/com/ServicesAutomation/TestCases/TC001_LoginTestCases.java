package com.ServicesAutomation.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ServicesAutomation.login.Login;
import com.ServicesAutomation.login.LoginWorkFlow;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import reports.ExtentManager;
import servicesAutomation.models.LoginModel;
import uiAutomation.testBase.TestBase;
import utility.UtilityClass;

public class TC001_LoginTestCases extends TestBase {
	ExtentReports extentReports;
	ExtentTest test;
	LoginWorkFlow loginWorkFlow;
	LoginModel loginModelTestData;
	Login login;
	String mock;
	UtilityClass util;

	@DataProvider
	public Object[][] ValidDataProvider() {
		return new Object[][] { { "Y", "SUCCESS_LOGIN", "92511830", "1234", "SUCCESS", "9000" },
				{ "Y", "BLANK_MOBILE_NUMBER", "", "1234", "mobile Number not valid1", "9002" },
				{ "N", "BLANK_PIN_NUMBER", "92511830", "", "pin Number not valid1", "9002" } };
	}

	@BeforeTest
	public void setUP() throws IOException {
		// Load Property File connection
		extentReports = ExtentManager.getInstance(System.getProperty("user.dir") + "\\Results\\" + "RES_LOGIN.html");
		mock = new UtilityClass().getPropertyValue("mock");
		util = new UtilityClass();
		loginWorkFlow = new LoginWorkFlow();
		loginModelTestData=new LoginModel();

	}

	@Test(dataProvider = "ValidDataProvider", alwaysRun=true)
	public void testLogin(String executionStatus, String useCase, String mobileNumber, String pin, String errorMessage,
			String errorCode) throws IOException {

		setTestData(executionStatus, useCase, mobileNumber, pin, errorMessage, errorCode);

		if (executionStatus.equalsIgnoreCase("Y")) {
			test = extentReports.startTest("TCID -- " + useCase);			

			if (loginWorkFlow.verifyLogin(loginModelTestData, test)) {
				test.log(LogStatus.PASS, "Success for use case : " + useCase);				
				//assertEquals(true, true);
			} else {
				test.log(LogStatus.FAIL, "Failed for use case : " + useCase);				
				//assertEquals(true, false);
			}			
			extentReports.endTest(test);
			extentReports.flush();
		}	
	}

	@AfterTest
	public void endTest() {
	}	
	
	public void setTestData(String executionStatus, String useCase, String mobileNumber, String pin,
			String errorMessage, String errorCode) throws IOException {
		loginModelTestData.setMobileNumber(util.getPropertyValue("senderMobileNumber"));
		loginModelTestData.setPin(pin);
		loginModelTestData.setUseCase(useCase.toUpperCase());
		loginModelTestData.setErrorCode(errorCode);
		loginModelTestData.setErrorMessage(errorMessage.toUpperCase());
	}
}
