package com.brightside.mentoring.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.brightside.mentoring.base.TestBase;

public class SignUpPage extends TestBase {

	// Page Factory - Object Repository:
	@FindBy(xpath = "//input[@formcontrolname='projectCode']")
	WebElement project_code;
	
	@FindBy(xpath = "////div[@class='join-project']/input")
	WebElement join_project_btn;
	
	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	WebElement first_name_field;
	
	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	WebElement last_name_field;
	
	@FindBy(xpath = "//input[@formcontrolname='emailId']")
	WebElement email_field;
	
	@FindBy(xpath = "//input[@formcontrolname='password']")
	WebElement password_field;
	
	@FindBy(xpath = "//input[@formcontrolname='postcode']")
	WebElement postCode_field;
	
	@FindBy(xpath = "//input[@formcontrolname='day']")
	WebElement date_field;
	
	@FindBy(xpath = "//input[@formcontrolname='month']")
	WebElement month_field;
	
	@FindBy(xpath = "//input[@formcontrolname='year']")
	WebElement year_field;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit_btn;
	
	// Initializing the page objects:
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateSignUpPageTitle() {
		return driver.getTitle();
	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean signUpWithProjectCode(String code) {
		project_code.sendKeys(code);
		if(join_project_btn.getClass().equals("join-project-btn")){
			join_project_btn.click();
			return true;
		}else {
			return false;
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public FeedsPage signUp(String firstname, String lastname, String email, String password, String postcode,
						  String date, String month, String year) {
		first_name_field.sendKeys(firstname);
		last_name_field.sendKeys(lastname);
		email_field.sendKeys(email);
		password_field.sendKeys(password);
		postCode_field.sendKeys(postcode);
		new Select(date_field).selectByVisibleText(date);
		new Select(month_field).selectByVisibleText(month);
		new Select(year_field).selectByVisibleText(year);
		if(submit_btn.getClass().equals("signup-btn disabled")){
			return null;
		}else {
			submit_btn.click();
			return new FeedsPage();
		}
	}	
	
}
