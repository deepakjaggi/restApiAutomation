package uiAutomation.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//Making POM
public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signInButton;

	@FindBy(xpath = "//*[@id='email']")
	WebElement email;

	@FindBy(xpath = "//*[@id='passwd']")
	WebElement pwd;

	@FindBy(xpath = "//*[@id='SubmitLogin']")
	WebElement submitButton;

	@FindBy(xpath = "//*[@id='center_column']/div[1]/ol/li")
	WebElement invalidEmailAddressError;

	// Register user

	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signInButton2;

	@FindBy(xpath = "//*[@id='email_create']")
	WebElement email1;

	@FindBy(xpath = "//*[@id='SubmitCreate']")
	WebElement createAccount;

	@FindBy(id = "id_gender2")
	WebElement gender2;

	@FindBy(id = "id_gender1")
	WebElement gender1;

	// FN
	@FindBy(xpath = "//*[@id='customer_firstname']")
	WebElement customer_firstname;

	// LN
	@FindBy(xpath = "//*[@id='customer_lastname']")
	WebElement customer_lastname;

	// Email
	@FindBy(xpath = "//*[@id='email']")
	WebElement email2;

	// Pwd
	@FindBy(xpath = "//*[@id='passwd']")
	WebElement passwd;

	// First Name
	@FindBy(xpath = "//*[@id='firstname']")
	WebElement firstname;

	// lastName
	@FindBy(xpath = "//*[@id='lastname']")
	WebElement lastname;

	// Address
	@FindBy(xpath = "//*[@id='address1']")
	WebElement address1;

	// City
	@FindBy(xpath = "//*[@id='city']")
	WebElement city1;

	// State
	@FindBy(xpath = "//*[@id='id_state']")
	WebElement state1;

	// postcode
	@FindBy(xpath = "//*[@id='postcode']")
	WebElement postcode1;

	// country
	@FindBy(xpath = "//*[@id='id_country']")
	WebElement country;

	// Phone
	@FindBy(xpath = "//*[@id='phone_mobile']")
	WebElement phone_mobile;

	// submitAccount
	@FindBy(xpath = "//*[@id='submitAccount']")
	WebElement submitAccount;

	// Verify my account
	@FindBy(xpath = "//*[@id='columns']/div[1]/span[2]")
	WebElement myAccount;

	
	public HomePage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}

	public void Login(String emailAddress, String password) {
		signInButton.click();
		email.sendKeys(emailAddress);
		pwd.sendKeys(password);
		submitButton.click();
	}

	public String getErrorInvalidEmailAddress() {
		return invalidEmailAddressError.getText();
	}

	public void registerUser(String email,String firstName,String lastName,String pwd,String address, String city,String postCode,String mobile) {
		signInButton.click();
		email1.sendKeys(email);

		createAccount.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gender2.click();
		customer_firstname.sendKeys(firstName);
		customer_lastname.sendKeys(lastName);
		passwd.sendKeys(pwd);
		address1.sendKeys(address);
		city1.sendKeys(city);
		Select dropdown_state = new Select(state1);
		dropdown_state.selectByIndex(1);
		Select dropdown_country = new Select(country);
		dropdown_country.selectByIndex(1);
		postcode1.sendKeys(postCode);
		phone_mobile.sendKeys(mobile);
		submitAccount.click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getValidationText() {

		return myAccount.getText();
	}

}
