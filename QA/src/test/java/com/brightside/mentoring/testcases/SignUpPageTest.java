package com.brightside.mentoring.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.brightside.mentoring.base.TestBase;
import com.brightside.mentoring.pages.FeedsPage;
import com.brightside.mentoring.pages.SignUpPage;
import com.brightside.mentoring.utils.TestUtils;

public class SignUpPageTest extends TestBase {
	
	TestBase testBase;
	SignUpPage signUpPage;
	FeedsPage feedsPage;
	
	public SignUpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		signUpPage = new SignUpPage();
		TestUtils.navigateTo("/project-code-sign-up");
	}
	
	@Test(priority = 0)
	public void signUpPageTitleTest() throws IOException {
		String pageTitle = signUpPage.validateSignUpPageTitle();
		Assert.assertEquals(pageTitle, "Brightside Mentoring", "Page Title doesn't matched");
	}
	
	@Test(priority = 1)
	public void signUpWithProjectCodeTest() throws IOException {
		boolean projectCodeAccess = signUpPage.signUpWithProjectCode(prop.getProperty("projectCode"));
		Assert.assertTrue(projectCodeAccess, "Invalid Project Code");
	}
	
	@Test(priority = 2, dependsOnMethods = {"signUpWithProjectCodeTest"})
	public void signUp() throws IOException {
		feedsPage = signUpPage.signUp(prop.getProperty("firstname"), prop.getProperty("firstname"), 
				prop.getProperty("firstname"), prop.getProperty("firstname"), prop.getProperty("firstname"),
				prop.getProperty("firstname"), prop.getProperty("firstname"), prop.getProperty("firstname"));
		System.out.println("User sucessfully joined in the project");
	}
	
	@AfterMethod
	public void tearDown() throws IOException {
		TestUtils.takeScreenshotAtEndOfTest();
		driver.quit();
	}
}
