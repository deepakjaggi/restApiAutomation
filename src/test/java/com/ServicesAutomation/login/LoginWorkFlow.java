package com.ServicesAutomation.login;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import com.ServicesAutomation.common.CommonResponseObjects;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import servicesAutomation.models.LoginModel;
import utility.MockingUtil;
import utility.UtilityClass;

public class LoginWorkFlow {
	private Login login;
	private LoginModel loginResponse;
	private String mock;
	private String loginURL;
	private String jsonFilePath;

	public LoginWorkFlow() throws IOException {
		this.login = new Login();
		this.loginResponse = new LoginModel();
		mock = new UtilityClass().getPropertyValue("mock");
		loginURL = new UtilityClass().getPropertyValue("loginURL");
		
	}

	public boolean verifyLogin(LoginModel loginModelTestData, ExtentTest test) throws IOException {
		boolean flag = false;
		int errorCnt = 0;
		String useCase = loginModelTestData.getUseCase();
		 CheckMockingStatusAndReturnMockingFile(loginModelTestData, useCase);
		switch (useCase) {
		case "SUCCESS_LOGIN":
			loginResponse = login.executeLoginService(loginModelTestData, loginURL);
			CommonResponseObjects.loginResponse=loginResponse;
			if (loginResponse.getErrorCode().equals("9000")) {
				flag = true;
			} else {
				flag = false;
			}
			break;
		case "BLANK_MOBILE_NUMBER":
			loginResponse = login.executeLoginService(loginModelTestData, loginURL);
			String expectedErrorCode = loginModelTestData.getErrorCode();
			String actualErrorCode = loginResponse.getErrorCode();
			String expectedErrorMessage = loginModelTestData.getErrorMessage().trim().toUpperCase();
			String actualErrorMessage = loginResponse.getErrorMessage().trim().toUpperCase();
			try
			{
			test.log(LogStatus.INFO, "Expected Error Code : " + expectedErrorCode);
			test.log(LogStatus.INFO, "Actual Error Code : " + actualErrorCode);
			test.log(LogStatus.INFO, "Expected Error message: " + expectedErrorMessage);
			test.log(LogStatus.INFO, "Actual Error message: " + actualErrorMessage);
			}
			catch (Exception e)
			{			
			}			
			if (!expectedErrorCode.equals(actualErrorCode)) {
				errorCnt = errorCnt + 1;
				if (test!=null)	test.log(LogStatus.INFO, "Error Code is not matching");
				

			}
			if (!expectedErrorMessage.equals(actualErrorMessage)) {
				errorCnt = errorCnt + 1;
				if (test!=null)test.log(LogStatus.INFO, "Error message is not matching");
			}

			if (errorCnt != 0) {
				flag = false;

			} else {
				flag = true;
			}
		default:
		}
		return flag;
	}

	private void CheckMockingStatusAndReturnMockingFile(LoginModel loginModelTestData, String useCase)
			throws IOException {
		if (mock.equalsIgnoreCase("YES")) {
			login = mock(Login.class);
			switch (useCase) {
			case "SUCCESS_LOGIN":
				jsonFilePath=System.getProperty("user.dir") + "\\MockFiles\\loginResponseModelCorrectPin.txt";
				when(login.executeLoginService(loginModelTestData, loginURL))
						.thenReturn((LoginModel) new MockingUtil().readMockFilesAndReturnModelGeneric(useCase, LoginModel.class,jsonFilePath));
				break;
			case "BLANK_MOBILE_NUMBER":
				break;
			case "BLANK_PIN_NUMBER":
				break;
			default:
				break;
			}
		}
	}
}