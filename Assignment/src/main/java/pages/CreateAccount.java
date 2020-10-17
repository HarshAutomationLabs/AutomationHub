package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.TestBase;
import utility.Utils;

public class CreateAccount extends TestBase {

	@FindBy(id = "create-account_form")
	WebElement CREATE_ACCOUNT_FORM;

	@FindBy(id = "email_create")
	WebElement CREATE_ACCOUNT_EMAIL;

	@FindBy(id = "SubmitCreate")
	WebElement CREATE_ACCOUNT_SUBMIT_BTN;

	@FindBy(id = "account-creation_form")
	WebElement ACCOUNT_CREATION_FORM;

	@FindBy(id = "create_account_error")
	WebElement ALERT_DANGER;

	@FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
	WebElement FIELD_ALERT;

	public CreateAccount() {
		PageFactory.initElements(driver, this);
	}

	public void validateCreateAccountForm() throws InterruptedException {
		Assert.assertTrue(CREATE_ACCOUNT_FORM.isDisplayed());
		Assert.assertTrue(CREATE_ACCOUNT_EMAIL.isDisplayed());
		Assert.assertTrue(CREATE_ACCOUNT_SUBMIT_BTN.isDisplayed());
		Thread.sleep(2000);
	}

	public void validateEmailField(String email) throws InterruptedException {
		CREATE_ACCOUNT_EMAIL.clear();
		CREATE_ACCOUNT_EMAIL.sendKeys(email);
		CREATE_ACCOUNT_SUBMIT_BTN.click();
		if (email.equals(" ") || !Utils.checkEmailFormat(email)) {
			Assert.assertTrue(Utils.validateRedField("email_create").isDisplayed());
			String actualAlert = FIELD_ALERT.getText();
			Assert.assertEquals(actualAlert, "Invalid email address.");
		} else {
			Assert.assertTrue(Utils.validateGreenField("email_create").isDisplayed());
			String actualAlert = FIELD_ALERT.getText();
			Assert.assertEquals(actualAlert,
					"An account using this email address has already been registered. "
					+ "Please enter a valid password or request a new one.");
		}
		Thread.sleep(2000);
	}

	public void createAccountWithValidEmail(String email) throws InterruptedException {
		CREATE_ACCOUNT_EMAIL.clear();
		CREATE_ACCOUNT_EMAIL.sendKeys(email);
		CREATE_ACCOUNT_EMAIL.sendKeys(Keys.TAB);
		Assert.assertTrue(Utils.validateGreenField("email_create").isDisplayed());
		CREATE_ACCOUNT_SUBMIT_BTN.click();
		Thread.sleep(2000);
	}

	public void validateRegisterationPage() throws InterruptedException {
		Assert.assertTrue(ACCOUNT_CREATION_FORM.isDisplayed());
		Thread.sleep(2000);
	}
}
