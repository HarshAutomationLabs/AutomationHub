package testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.TestBase;
import pages.CreateAccount;
import pages.Homepage;
import pages.Registration;

public class CreateAccount_TC extends TestBase {

	CreateAccount createAccount;
	Registration register;

	public CreateAccount_TC() {
		super();
	}

	@BeforeClass
	public Homepage setUp() throws IOException, InterruptedException {
		initialization();
		createAccount = new CreateAccount();
		register = new Registration();
		return new Homepage();
	}

	@AfterClass
	public void setDown() {
		teardown();
	}

	@Test(priority = 1)
	public void authentication() throws InterruptedException {
		createAccount.validateCreateAccountForm();
	}

	@Test(priority = 2)
	public void validate_With_Empty_Email_Field() throws InterruptedException {
		String email = " ";
		createAccount.validateEmailField(email);
	}

	@Test(priority = 3)
	public void validate_With_Incorrect_Email() throws InterruptedException {
		String email = "testemail";
		createAccount.validateEmailField(email);
	}

	@Test(priority = 4)
	public void validate_With_Registered_Email() throws InterruptedException {
		String email = prop.getProperty("Registered_email");
		createAccount.validateEmailField(email);
	}

	@Test(priority = 5)
	public void validate_With_UnRegistered_Email() throws InterruptedException {
		String email = prop.getProperty("Unregistered_email");
		createAccount.createAccountWithValidEmail(email);
		createAccount.validateRegisterationPage();
	}

	@Test(priority = 6)
	public void validate_Email_In_PersonalFields() throws InterruptedException {
		String email = prop.getProperty("Unregistered_email");
		register.matchEmailInInformation(email);
	}

	@Test(priority = 7)
	public void validate_Empty_Personal_Info_Fields() throws InterruptedException {
		String gender = prop.getProperty("Gender");
		String firstName = " ";
		String lastName = " ";
		String password = " ";
		register.checkEmptyProfileFields(gender, firstName, lastName, password);
	}

	@Test(priority = 8)
	public void add_Personal_Information() throws InterruptedException {
		String gender = prop.getProperty("Gender");
		String firstName = prop.getProperty("first_name");
		String lastName = prop.getProperty("last_name");
		String password = prop.getProperty("password");
		String date = prop.getProperty("date");
		String month = prop.getProperty("month");
		int monthValue = Integer.parseInt(month);
		String year = prop.getProperty("year");
		register.enterPersonalInformation(gender, firstName, lastName, password);
		register.enterDateOfBirth(date, monthValue, year);
	}

	@Test(priority = 9)
	public void validate_Personal_Info_In_Address_Info() throws InterruptedException {
		String firstName = prop.getProperty("first_name");
		String lastName = prop.getProperty("last_name");
		register.matchPersonalInfo(firstName, lastName);
	}

	@Test(priority = 10)
	public void add_Address_Information() throws InterruptedException {
		String company = prop.getProperty("company");
		String address = prop.getProperty("address");
		String city = prop.getProperty("city");
		String state = prop.getProperty("state");
		String postalCode = prop.getProperty("postcode");
		String country = prop.getProperty("country");
		String homePhone = prop.getProperty("homePhone");
		String mobilePhone = prop.getProperty("mobilePhone");
		String alias = prop.getProperty("alias");
		register.enterAddressInformation(company, address, city, state, postalCode, country, homePhone, mobilePhone,
				alias);
		register.verifyRegistration();
	}
}
