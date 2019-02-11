package servicesAutomation.handleResponse;

import static com.jayway.restassured.RestAssured.given;
import org.apache.log4j.Logger;

import com.jayway.restassured.response.Response;

public class ExecuteService {
	final static Logger logger = Logger.getLogger(ExecuteService.class);
	private Response response = null;

	public Response getResponse() {
		return response;
	}

	public Response executeGetService(String URL) {
		try {
			response = given().header("Content-Type", "application/json").when().get(URL);
			logger.info(response.asString());
		} catch (Exception exception) {
			logger.error(exception.getMessage());
		}
		return response;
	}

	public Response executePostService(String jsonReqData, String URL) {
		try {
			response = given().header("Content-Type", "application/json").header("Accept-Language", "en-US")
					.body(jsonReqData).when().post(URL);
			if (response.statusCode() != 200 || response.statusCode() != 202) {
				logger.info(response.asString());
			} else {
				logger.error("Request failed: HTTP( status Code = {} -- " + response.statusCode());
			}
		} catch (Exception exception) {
			logger.error(exception.getMessage());
			System.out.println(exception.getMessage());
		}
		return response;
	}

	public <T extends Object> Object handleResponse(Response respData, Class<T> beanClass) {
		if (respData.asString() == null || respData.asString().equals("")) {
			return null;
		} else {
			logger.info("ResponseData = " + respData.asString());
			return respData.as(beanClass);
		}
	}

}
