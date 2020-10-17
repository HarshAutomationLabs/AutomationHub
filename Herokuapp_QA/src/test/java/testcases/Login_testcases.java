package testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

import base.TestBase;
import pages.Login;

public class Login_testcases extends TestBase {

	Login loginPage;

	public Login_testcases() {
		super();
	}

	@BeforeClass
	public void setUp() throws IOException {
		initialization();
		loginPage = new Login();
	}
	
	@AfterClass
	public void setDown() {
		teardown();
	}

	@Test
	public void loginTestCase() throws InterruptedException, IOException {
		loginPage.doLoginMethod();
	}
}