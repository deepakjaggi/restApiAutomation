package com.ServicesAutomation.makePayment;

import com.ServicesAutomation.common.CommonResponseObjects;
import com.jayway.restassured.response.Response;

import servicesAutomation.handleResponse.CustomJsonParsor;
import servicesAutomation.handleResponse.ExecuteService;
import servicesAutomation.models.MakePaymentModel;

public class MakePayment {
	public MakePaymentModel executemakePaymentService( MakePaymentModel makePaymentModelTestData, String url) {
		try {
			ExecuteService executeService = new ExecuteService();
			Response response = executeService.executePostService(new CustomJsonParsor().makJSONFromData(makePaymentModelTestData),
					url);
			MakePaymentModel responseModel = new MakePaymentModel();
			responseModel = (MakePaymentModel) executeService.handleResponse(response, MakePaymentModel.class);
			CommonResponseObjects.makePaymentModelResponse=responseModel;
			return responseModel;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
