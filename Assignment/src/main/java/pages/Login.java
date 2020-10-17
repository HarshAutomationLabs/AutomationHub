package pages;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utility.Utils;

public class Login extends TestBase {
	
	@FindBy(id = "login_form")
	WebElement LOGIN_FORM;

	@FindBy(id = "email")
	WebElement LOGIN_EMAIL;

	@FindBy(id = "passwd")
	WebElement LOGIN_PASSWORD;

	@FindBy(id = "SubmitLogin")
	WebElement LOGIN_SUBMIT_BTN;
	
	@FindBy(css = ".alert.alert-danger")
	WebElement ALERT_DANGER;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
	WebElement FIELD_ALERT;
	
	@FindBy(className = "info-account")
	WebElement ACCOUNT_INFO_HEAD;
	
	@FindBy(className = "logout")
	WebElement LOG_OUT_BTN;
	
	public Login() {
		PageFactory.initElements(driver, this);
	}

	public void validateAlreadyRegisteredForm() {
		Assert.assertTrue(LOGIN_FORM.isDisplayed());
		Assert.assertTrue(LOGIN_EMAIL.isDisplayed());
		Assert.assertTrue(LOGIN_PASSWORD.isDisplayed());
		Assert.assertTrue(LOGIN_SUBMIT_BTN.isDisplayed());
	}

	public void enterLoginDetails(String email, String password) throws InterruptedException {
		LOGIN_EMAIL.clear();
		LOGIN_EMAIL.sendKeys(email);
		LOGIN_PASSWORD.clear();
		LOGIN_PASSWORD.sendKeys(password);
		LOGIN_SUBMIT_BTN.click();
		Thread.sleep(2000);
	}
	
	public void validateLoginFields(String email, String password) throws InterruptedException {
		if(email.equals(" ")) {
			Assert.assertTrue(ALERT_DANGER.isDisplayed());
			String actualAlert = FIELD_ALERT.getText();
			Assert.assertEquals(actualAlert, "An email address required.");
			System.out.println("Email Field alert found");
		}else if(password.equals(" ")) {
			Assert.assertTrue(ALERT_DANGER.isDisplayed());
			String actualAlert = FIELD_ALERT.getText();
			Assert.assertEquals(actualAlert, "Password is required.");
			System.out.println("Password Field alert found");
		}else if(!Utils.checkEmailFormat(email)) {
			Assert.assertTrue(ALERT_DANGER.isDisplayed());
			String actualAlert = FIELD_ALERT.getText();
			Assert.assertEquals(actualAlert, "Invalid email address.");
			System.out.println("Invalid Email alert found");
		}else {
			Assert.assertTrue(ALERT_DANGER.isDisplayed());
			String actualAlert = FIELD_ALERT.getText();
			Assert.assertEquals(actualAlert, "Authentication failed.");
			System.out.println("Authentication failed alert found");
		}
		Thread.sleep(2000);
	}
	
	public void validateLogin(String email, String password) throws InterruptedException {
		this.enterLoginDetails(email, password);
		Assert.assertTrue(ACCOUNT_INFO_HEAD.isDisplayed());
		Thread.sleep(2000);
	}
	
	public void logout() throws InterruptedException {
		LOG_OUT_BTN.click();
		this.validateAlreadyRegisteredForm();
		Thread.sleep(2000);
	}
}
