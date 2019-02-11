package com.ServicesAutomation.makePayment;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import servicesAutomation.models.MakePaymentModel;

public class MakePaymentWorkFlow {
	
	public boolean verifyMakePayment(MakePaymentModel makePaymentModelTestData, ExtentTest test)
	{
		int errCnt=0;
		MakePaymentModel makePaymentModelResponse=new MakePayment().executemakePaymentService(makePaymentModelTestData, "http://localhost:8085/demo/business/makePayment");
		test.log(LogStatus.INFO,makePaymentModelResponse.toString());
		if (!makePaymentModelResponse.getErrorCode().equals(makePaymentModelTestData.getErrorCode()))
		{
			errCnt=errCnt+1;
			test.log(LogStatus.INFO, "Expected Error Code : " + makePaymentModelTestData.getErrorCode());
			test.log(LogStatus.INFO, "Actual Error Code : " + makePaymentModelResponse.getErrorCode());
		}
		if (!makePaymentModelResponse.getErrorMessage().equals(makePaymentModelTestData.getErrorMessage()))
		{
			errCnt=errCnt+1;
			test.log(LogStatus.INFO, "Expected Error message : " + makePaymentModelTestData.getErrorMessage());
			test.log(LogStatus.INFO, "Actual Error message : " + makePaymentModelResponse.getErrorMessage());
		}
		if (errCnt!=0)
		{
			return false;			
		}
		else
		{
			return true;
		}		
	}
}
