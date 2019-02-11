package com.ServicesAutomation.login;

import java.io.IOException;

import com.ServicesAutomation.common.CommonResponseObjects;
import com.jayway.restassured.response.Response;

import servicesAutomation.handleResponse.CustomJsonParsor;
import servicesAutomation.handleResponse.ExecuteService;
import servicesAutomation.models.LoginModel;

public class Login{		
	public LoginModel executeLoginService(LoginModel loginModelTest, String url) throws IOException {		
		try {
			ExecuteService executeService = new ExecuteService();
			Response response = executeService.executePostService(new CustomJsonParsor().makJSONFromData(loginModelTest),
					url);
			LoginModel responseModel = new LoginModel();
			responseModel = (LoginModel) executeService.handleResponse(response, LoginModel.class);
			CommonResponseObjects.loginResponse=responseModel;
			return responseModel;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
