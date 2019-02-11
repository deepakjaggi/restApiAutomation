package com.ServicesAutomation.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ServicesAutomation.common.CommonResponseObjects;
import com.ServicesAutomation.login.LoginWorkFlow;
import com.ServicesAutomation.makePayment.MakePaymentWorkFlow;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import reports.ExtentManager;
import servicesAutomation.models.LoginModel;
import servicesAutomation.models.MakePaymentModel;
import uiAutomation.testBase.TestBase;

public class TC002_MakePaymentTestCases extends TestBase {
	ExtentReports extentReports;
	ExtentTest test;
	LoginWorkFlow loginWorkFlow;
	MakePaymentWorkFlow makePaymentWorkFlow;

	@DataProvider
	public Object[][] ValidDataProvider() {
		return new Object[][] 
				{ 
					{ "Y", "Success Payment", "92511830", "1234", "92511831", "100", "9000", "Success" },
					{ "N", "Blank sender Mobile Number", "", "1234", "92511831", "100", "9001","sender Number can not be null" },
					{ "N", "Blank rxer Mobile Number", "92511830", "1234", "", "100", "9002","rxer Number can not be null" },
					{ "N", "Blank amount", "92511830", "92511831", "1234", "", "9004", "amount can not be null" },
					{ "N", "Blank token", "92511830", "92511831", "1234", "100", "9003", "token can not be null" } 
				};
	}

	@BeforeTest
	public void setUP() throws IOException {
		// Load Property File connection
		loginWorkFlow = new LoginWorkFlow();
		makePaymentWorkFlow=new MakePaymentWorkFlow();
		extentReports = ExtentManager.getInstance(System.getProperty("user.dir") + "\\Results\\" + "RES_MakePayment.html");
	}

	@Test(dataProvider = "ValidDataProvider")
	public void testLogin(String executionStatus, String useCase, String senderMobileNumber, String pin, String rxerMobileNumber,
			String amount, String errorCode, String errorMessage) throws IOException {
		if (executionStatus.equalsIgnoreCase("Y")) {
			test = extentReports.startTest("TCID -- " + useCase);
			LoginModel loginModelTestData = new LoginModel();
			loginModelTestData.setMobileNumber(senderMobileNumber);
			loginModelTestData.setPin(pin);
			loginModelTestData.setUseCase("SUCCESS_LOGIN");
			if (loginWorkFlow.verifyLogin(loginModelTestData, test)) {
				test.log(LogStatus.INFO, "Success for use case : " + useCase);
				//Populate Make Payment Data
				MakePaymentModel makePaymentModelTestData= new MakePaymentModel();
				makePaymentModelTestData.setSenderMobileNumber(senderMobileNumber);
				makePaymentModelTestData.setRxerMobileNumber(rxerMobileNumber);
				makePaymentModelTestData.setAmount(amount);
				makePaymentModelTestData.setErrorCode(errorCode);
				makePaymentModelTestData.setErrorMessage(errorMessage);
				makePaymentModelTestData.setToken(CommonResponseObjects.loginResponse.getToken());
				if (makePaymentWorkFlow.verifyMakePayment(makePaymentModelTestData, test))
				{
					test.log(LogStatus.PASS, "Passed for use case : " + useCase);
				}
				else
				{
					test.log(LogStatus.FAIL, "Failed for use case : " + useCase);
				}
				
			} else {
				test.log(LogStatus.INFO, "Failed for use case : " + useCase);
			}
			extentReports.endTest(test);
			extentReports.flush();
		}
	}

	@AfterTest
	public void endTest() {
	}
}
