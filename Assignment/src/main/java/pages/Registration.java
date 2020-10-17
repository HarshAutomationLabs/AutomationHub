package pages;

import java.awt.List;

import javax.swing.event.ListDataEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.TestBase;
import utility.Utils;

public class Registration extends TestBase {

	@FindBy(id = "email")
	WebElement EMAIL_FIELD;
	
	@FindBy(id = "id_gender1")
	WebElement MR_RADIO;

	@FindBy(id = "id_gender2")
	WebElement MRs_RADIO;
	
	@FindBy(id = "customer_firstname")
	WebElement CUSTOMER_FIRST_NAME_FIELD;

	@FindBy(id = "customer_lastname")
	WebElement CUSTOMER_LAST_NAME_FIELD;

	@FindBy(id = "passwd")
	WebElement CUSTOMER_PASSWORD_FIELD;

	@FindBy(id = "days")
	WebElement DAYS_FIELD;

	@FindBy(xpath = "//select[@id=\"months\"]")
	WebElement MONTHS_FIELD;

	@FindBy(id = "years")
	WebElement YEARS_FIELD;

	@FindBy(id = "firstname")
	WebElement FIRST_NAME_FIELD;

	@FindBy(id = "lastname")
	WebElement LAST_NAME_FIELD;

	@FindBy(id = "company")
	WebElement COMPANY_FIELD;

	@FindBy(id = "address1")
	WebElement ADDRESS_FIELD;

	@FindBy(id = "city")
	WebElement CITY_FIELD;

	@FindBy(id = "id_state")
	WebElement STATE_FIELD;

	@FindBy(id = "postcode")
	WebElement POSTCODE_FIELD;

	@FindBy(id = "id_country")
	WebElement COUNTRY_FIELD;

	@FindBy(id = "phone")
	WebElement HOME_PHONE_FIELD;

	@FindBy(id = "phone_mobile")
	WebElement MOBILE_PHONE_FIELD;

	@FindBy(id = "alias")
	WebElement ALIAS_FIELD;
	
	@FindBy(id = "submitAccount")
	WebElement REGISTER_BTN;
	
	@FindBy(className = "alert alert-danger")
	WebElement ALERT_DANGER;
	
	@FindBy(className = "info-account")
	WebElement ACCOUNT_INFO_HEAD;
	
	@FindBy(className = "logout")
	WebElement LOG_OUT_BTN;
	
	public Registration() {
		PageFactory.initElements(driver, this);
	}

	public void matchEmailInInformation(String email) throws InterruptedException {
		String actualValue = EMAIL_FIELD.getAttribute("value");
		Assert.assertEquals(actualValue, email);
		Thread.sleep(2000);
	}

	public void checkEmptyProfileFields(String gender, String firstName, String lastName, String password) throws InterruptedException {
		this.enterPersonalInformation(gender, firstName, lastName, password);
		Assert.assertTrue(Utils.validateGreenField("customer_firstname").isDisplayed());
		Assert.assertTrue(Utils.validateGreenField("customer_lastname").isDisplayed());
		Assert.assertTrue(Utils.validateRedField("passwd").isDisplayed());
		Thread.sleep(2000);
	}

	public void enterPersonalInformation(String gender, String firstName, String lastName, String password) throws InterruptedException {
		if(gender.equals("Male")) {
			MR_RADIO.click();
			Assert.assertTrue(MR_RADIO.isSelected());
		}else {
			MRs_RADIO.click();
			Assert.assertTrue(MRs_RADIO.isSelected());
		}
		CUSTOMER_FIRST_NAME_FIELD.clear();
		CUSTOMER_FIRST_NAME_FIELD.sendKeys(firstName);
		CUSTOMER_LAST_NAME_FIELD.clear();
		CUSTOMER_LAST_NAME_FIELD.sendKeys(lastName);
		CUSTOMER_PASSWORD_FIELD.clear();
		CUSTOMER_PASSWORD_FIELD.sendKeys(password);
		CUSTOMER_PASSWORD_FIELD.sendKeys(Keys.TAB);
		Thread.sleep(2000);
	}

	public void enterDateOfBirth(String date, int month, String year) throws InterruptedException {
		
		Select days = new Select(DAYS_FIELD);
		days.selectByValue(date);
		Select months = new Select(MONTHS_FIELD);
		months.selectByIndex(month);
		Select years = new Select(YEARS_FIELD);
		years.selectByValue(year);
		Thread.sleep(2000);
	}

	public void matchPersonalInfo(String firstName, String lastName) throws InterruptedException {
		String actualFirstNameValue = FIRST_NAME_FIELD.getAttribute("value");
		String actualLastNameValue = LAST_NAME_FIELD.getAttribute("value");
		Assert.assertEquals(actualFirstNameValue, firstName);
		Assert.assertEquals(actualLastNameValue, lastName);
		Thread.sleep(2000);
	}

	public void enterAddressInformation(String company, String address, String city, String state, String postalCode,
			String country, String homePhone, String mobilePhone, String alias) throws InterruptedException {
		COMPANY_FIELD.sendKeys(company);
		ADDRESS_FIELD.sendKeys(address);
		CITY_FIELD.sendKeys(city);
		Select countryField = new Select(COUNTRY_FIELD);
		countryField.selectByVisibleText(country);
		Select stateField = new Select(STATE_FIELD);
		stateField.selectByVisibleText(state);
		POSTCODE_FIELD.sendKeys(postalCode);	
		HOME_PHONE_FIELD.sendKeys(homePhone);
		MOBILE_PHONE_FIELD.sendKeys(mobilePhone);
		ALIAS_FIELD.sendKeys(alias);
		REGISTER_BTN.click();
		Thread.sleep(2000);
	}

	public void verifyRegistration() throws InterruptedException {
		Assert.assertTrue(ACCOUNT_INFO_HEAD.isDisplayed());
		LOG_OUT_BTN.click();
		Thread.sleep(2000);
	}
}
