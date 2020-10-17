package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class Login extends TestBase {

	// Page Factories - Object Repository
	@FindBy(id = "admin_user_email")
	WebElement USER_EMAIL;

	@FindBy(id = "admin_user_password")
	WebElement PASSWORD_FIELD;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement LOGIN_BTN;

	@FindBy(xpath = "//div[@class='flash flash_notice']")
	WebElement LOGIN_SUCCESS_NOTICE;

	// Initializing the page objects
	public Login() {
		PageFactory.initElements(driver, this);
	}

	// Login
	public void doLoginMethod() throws InterruptedException {
		String email = prop.getProperty("Email");
		String password = prop.getProperty("Password");
		
		USER_EMAIL.sendKeys(email);
		PASSWORD_FIELD.sendKeys(password);
		LOGIN_BTN.click();
		Assert.assertTrue(LOGIN_SUCCESS_NOTICE.isDisplayed());
	}

}
