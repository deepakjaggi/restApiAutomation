package uiAutomation.testBase;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{
	public WebDriver driver;
	String chromeDriverPath;
	
	public void init(String browser, String url)
	{
		selectBrowser(browser.toUpperCase());
		getURL(url);
		driver.manage().window().maximize();
	}
	
	public void selectBrowser(String browser)
	{
		if (browser.equalsIgnoreCase("CHROME"))
		{
			if (SystemUtils.IS_OS_WINDOWS)
			{
				chromeDriverPath=System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
			}
			else if (SystemUtils.IS_OS_MAC)
			{
				chromeDriverPath="/Users/usha/Desktop/chromedriver";
			}
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver=new ChromeDriver();
		}
	}
	public void getURL(String url)
	{
		driver.get(url);
	}
	public void closeBrowser()
	{
		driver.close();
	}
	
	
}
