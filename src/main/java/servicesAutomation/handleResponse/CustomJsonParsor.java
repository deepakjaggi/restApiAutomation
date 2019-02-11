package servicesAutomation.handleResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CustomJsonParsor {
	final static Logger logger = Logger.getLogger(CustomJsonParsor.class);
	private static String ERROR_TAG = "JsonParsar: Data Parsing Error = ";

	public <T extends Object> Object parseFromJson(Class<T> beanClass, String response) {
		Object responseObject = null;
		try {

			Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy HH:mm:ss:SSS").create();
			responseObject = gson.fromJson(response, beanClass);

		} catch (Exception e) {
			logger.error(ERROR_TAG + e.getMessage().toString());
		}

		return responseObject;
	}

	public String makJSONFromData(Object beanClass) {
		String jsonStr = null;
		try {
			Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy HH:mm:ss:SSS").create();
			jsonStr = gson.toJson(beanClass);
			System.out.println(jsonStr);

		} catch (Exception e) {
			logger.error(ERROR_TAG + e.getMessage().toString());
		}
		return jsonStr;
	}

}