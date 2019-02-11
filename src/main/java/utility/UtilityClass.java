package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class UtilityClass {
	String crhomeDriverPath = "";

	public UtilityClass() {
		this.crhomeDriverPath = "/Users/usha/Desktop/chromedriver";
	}

	public int sum(int a, int b) {
		return a + b;
	}

	public int multiply(int m, int n) {

		return m * n;
	}

	public WebDriver launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", crhomeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

	public String getPropertyValue(String propertyNameVariabe) throws IOException {
		String propertyFilePath = System.getProperty("user.dir") + "/src/test/resources/test.properties";
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream(propertyFilePath);
		// load a properties file
		prop.load(input);
		// get the property value and print it out
		return prop.getProperty(propertyNameVariabe);

	}

}
