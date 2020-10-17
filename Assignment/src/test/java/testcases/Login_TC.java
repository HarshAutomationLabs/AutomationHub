package testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Homepage;
import pages.Login;

public class Login_TC extends TestBase {

	Login login;

	public Login_TC() {
		super();
	}

	@BeforeClass
	public Homepage setUp() throws IOException, InterruptedException {
		initialization();
		login = new Login();
		return new Homepage();
	}

	@AfterClass
	public void setDown() {
		teardown();
	}

	@Test(priority = 0)
	public void authentication() {
		login.validateAlreadyRegisteredForm();
	}

	@Test(priority = 1)
	public void validateEmptyField() throws InterruptedException {
		String email = " ";
		String password = " ";
		login.enterLoginDetails(email, password);
		login.validateLoginFields(email, password);
	}

	@Test(priority = 2)
	public void validateLoginWithIncorrectEmail() throws InterruptedException {
		String email = "testemail";
		String password = "testpassword";
		login.enterLoginDetails(email, password);
		login.validateLoginFields(email, password);
	}

	@Test(priority = 3)
	public void validateLoginWithUnregisteredEmail() throws InterruptedException {
		String email = prop.getProperty("Unregistered_email");
		String password = "testpassword";
		login.enterLoginDetails(email, password);
		login.validateLoginFields(email, password);
	}

	@Test(priority = 4)
	public void validateLoginWithCorrectDetails() throws InterruptedException {
		String email = prop.getProperty("Registered_email");
		String password = prop.getProperty("password");
		login.validateLogin(email, password);
		login.logout();
	}
}
