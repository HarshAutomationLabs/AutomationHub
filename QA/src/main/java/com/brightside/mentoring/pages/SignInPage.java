package com.brightside.mentoring.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.brightside.mentoring.base.TestBase;

public class SignInPage extends TestBase {

	// Page Factory - Object Repository:
	@FindBy(xpath = "//input[@type='email']")
	WebElement email_or_phoneNumber;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")	
	WebElement signInBtn;

	@FindBy(xpath = "//img[contains(@class, 'attachment partner logo partnership-logo__image')]")
	WebElement brightsideLogo;

	// Initializing the page objects:
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions:	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateBrightsideLogo() {
		return brightsideLogo.isDisplayed();
	}

	public FeedsPage signIn(String userEmail, String userPassword) {
		email_or_phoneNumber.sendKeys(userEmail);
		password.sendKeys(userPassword);
		signInBtn.click();
		return new FeedsPage();	
	}
}
