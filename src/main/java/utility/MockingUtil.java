package utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MockingUtil {
//	
//	public <T extends Object> Object readMockFilesAndReturnModelGeneric(String useCase, Class<T> beanClass, String filePath)
//			throws IOException {
//		// read JSON from a text File and parse it to Model
//		Scanner in = new Scanner(new FileReader(filePath));
//		StringBuilder sb = new StringBuilder();
//		while (in.hasNext()) {
//			sb.append(in.next());
//		}
//		in.close();
//		Object responseObject = null;
//		Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy HH:mm:ss:SSS").create();
//		responseObject = gson.fromJson(sb.toString(), beanClass);
//		return responseObject;
//	}
	
	 public <T> Object readMockFilesAndReturnModelGeneric(String useCase, Class<T> beanClass, String filePath)
			throws IOException {
		// read JSON from a text File and parse it to Model
		Scanner in = new Scanner(new FileReader(filePath));
		StringBuilder sb = new StringBuilder();
		while (in.hasNext()) {
			sb.append(in.next());
		}
		in.close();
		Object responseObject = null;
		Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy HH:mm:ss:SSS").create();
		responseObject = gson.fromJson(sb.toString(), beanClass);
		return responseObject;
	}

}
