package uiAutomation.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Making POM
public class HelpPage
{

	WebDriver driver;

	@FindBy(id = "Text1")
	WebElement txtUserName;

	@FindBy(id = "Text2")
	WebElement txtPwd;

	@FindBy(id = "Text3")
	WebElement txtCpwd;
	
	@FindBy(id = "Confirm Registration")
	WebElement btnConfirmRegistration;

	@FindBy(id = "lblText")
	WebElement eleValidationMessage;
	
	
	public HelpPage(WebDriver webDriver)
	{
		PageFactory.initElements(webDriver, this);
	}

	public void registerUser(String username, String pwd, String cpwd) throws InterruptedException
	{
		txtUserName.clear();
		txtUserName.sendKeys(username);
		txtPwd.clear();
		txtPwd.sendKeys(pwd);
		txtCpwd.clear();
		txtCpwd.sendKeys(cpwd);
		btnConfirmRegistration.click();
		Thread.sleep(1000);		

	}

	public String getValidationMessageForRegistration()
	{
		return eleValidationMessage.getText();
	}
}
