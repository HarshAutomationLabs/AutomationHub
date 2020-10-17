package com.brightside.mentoring.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.brightside.mentoring.base.TestBase;
import com.brightside.mentoring.pages.FeedsPage;
import com.brightside.mentoring.pages.MentoringHomepage;
import com.brightside.mentoring.pages.MyAccountPage;
import com.brightside.mentoring.pages.SignInPage;
import com.brightside.mentoring.utils.TestUtils;

public class MyAccountPageTest extends TestBase{

	SignInPage signInPage;
	FeedsPage feedsPage;
	MentoringHomepage mentoringHomepage;
	MyAccountPage myAccountPage;
	
	public MyAccountPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		signInPage = new SignInPage();
		mentoringHomepage = new MentoringHomepage();
		myAccountPage = new MyAccountPage();
		feedsPage = signInPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		mentoringHomepage.clickOnMyAccountLink();
	}
	
	@Test
	public void accountUpdateTest() {
		//TODO
	}
	
	@AfterMethod
	public void tearDown() throws IOException {
		TestUtils.takeScreenshotAtEndOfTest();
		driver.quit();
	}
}
