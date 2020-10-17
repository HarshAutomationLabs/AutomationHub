package com.brightside.mentoring.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.brightside.mentoring.base.TestBase;
import com.brightside.mentoring.utils.TestUtils;

public class MyAccountPage extends TestBase{

	//Page Factory or Object Repositoriess
	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	WebElement firstNameField;
	
	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	WebElement lastNameField;
	
	@FindBy(xpath = "//input[@formcontrolname='emailId']")
	WebElement emailField;
	
	@FindBy(xpath = "//input[@formcontrolname='phoneNumber']")
	WebElement phoneNumberField;

	@FindBy(xpath = "//input[@formcontrolname='postCode']")
	WebElement postCodeField;
	
	@FindBy(xpath = "//input[@formcontrolname='day']")
	WebElement dayField;
	
	@FindBy(xpath = "//select[@formcontrolname='month']")
	WebElement monthField;
	
	@FindBy(xpath = "//select[@formcontrolname='year']")
	WebElement yearField;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement updateAccountBtn;
	
	// Initializing the page objects
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
		
	public void accountUpdateDetails(String firstName, String lastName, String email, String phoneNumber, String postCode) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		phoneNumberField.sendKeys(phoneNumber);
		postCodeField.sendKeys(postCode);
	}
	
	public void selectDateOfBirth(String day, String month, String year) {
		new Select(dayField).selectByVisibleText(day);
		new Select(monthField).selectByVisibleText(month);
		new Select(yearField).selectByVisibleText(year);
	}
	
	public void clickUpdateBtn() {
		updateAccountBtn.click();
		TestUtils.WaitUntilInvisiblityOfElement(PRELOADER);
	}
	
	private boolean validateAccountDetails(String firstName, String lastName, String email, String phoneNumber, String postCode, String day, String month, String year) {
		firstNameField.getText().equals(firstName);
		lastNameField.getText().equals(lastName);
		emailField.getText().equals(email);
		phoneNumberField.getText().equals(phoneNumber);
		postCodeField.getText().equals(postCode);
		((Select) dayField).getFirstSelectedOption().equals(day);
		((Select) monthField).getFirstSelectedOption().equals(month);
		((Select) yearField).getFirstSelectedOption().equals(year);
		return true;
	}
	
	
}
