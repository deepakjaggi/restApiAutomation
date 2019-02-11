package com.uiAutomation.testHomePage;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import uiAutomation.testBase.TestBase;
import uiAutomation.uiActions.HomePage;

public class TC003_verfiyResgistration_DataProviderUsingArray extends TestBase 
{
	@DataProvider
	public Object[][] ValidDataProvider() {
		return new Object[][] {
				{ "Y", "deepak7@gmail.com", "test", "testlast", "passsword", "Alnagata 18 Oslo", "Oslo", "12345", "4537892456" },
				{ "Y", "deepak2@gmail.com", "test", "testlast", "passsword", "Alnagata 18 Oslo","Oslo", "12345", "4537892456" },
				{ "Y", "deepak3@gmail.com", "test", "testlast", "passsword", "Alnagata 18 Oslo","Oslo", "12345", "4537892456" },
				{ "Y", "deepak4@gmail.com", "test", "testlast", "passsword", "Alnagata 18 Oslo","Oslo", "12345", "4537892456" },
				{ "Y", "deepak5@gmail.com", "test", "testlast", "passsword", "Alnagata 18 Oslo","Oslo", "12345", "4537892456" },
				{ "Y", "deepak6@gmail.com", "test", "testlast", "passsword", "Alnagata 18 Oslo","Oslo", "12345", "4537892456" } };
	}

	@BeforeMethod
	public void setUP() {
		init("CHROME","C://help.html");
	}

	@Test(dataProvider = "ValidDataProvider")
	public void testLogin(String executionStatus, String email, String firstName, String lastName, String pwd,
			String address, String city, String postalCode, String mobile) {
		if (executionStatus.equalsIgnoreCase("Y")) {
			HomePage homePage = new HomePage(driver);
			email="Deep" + new Random().nextInt() + "@gmail.com";
			homePage.registerUser(email, firstName, lastName, pwd, address, city, postalCode, mobile);
			Assert.assertEquals(homePage.getValidationText(), "My account");
			System.out.println("User registered successfully");
		}

	}

	@AfterMethod
	public void endTest() {
		driver.close();
	}

}
