package reports;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;


public class ExtentManager
{	
	public static ExtentReports extentReports;
	
	public static ExtentReports getInstance(String fileName)
	{
		extentReports=new ExtentReports(fileName);
		extentReports.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		return extentReports;
		
	}
}