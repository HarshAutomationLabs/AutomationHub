package com.brightside.mentoring.testcases;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.brightside.mentoring.base.TestBase;
import com.brightside.mentoring.pages.FeedsPage;
import com.brightside.mentoring.pages.SignInPage;
//import com.brightside.mentoring.utils.ExcelTestUtils;
import com.brightside.mentoring.utils.TestUtils;

public class SignInPageTest extends TestBase {
	
	TestBase testBase;
	SignInPage signInPage;
	FeedsPage feedsPage;

	public SignInPageTest() {
		super();
	}

//	@DataProvider
//	public Iterator<Object[]> getTestData(){
//		ArrayList<Object[]> testData = ExcelTestUtils.getDataFromExcel();
//		return testData.iterator();
//	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		signInPage = new SignInPage();
		TestUtils.navigateTo("/sign-in");
	}

	//Validate Sign Page Title Test
	@Test(priority = 0)
	public void signInPageTitleTest() throws IOException {
		String pageTitle = signInPage.validateLoginPageTitle();
		Assert.assertEquals(pageTitle, "Brightside Mentoring", "Page Title doesn't matched");
	}

	//Validate Brightside Logo Test
	@Test(priority = 1)
	public void brightsideLogoTest() throws IOException {
		boolean flag = signInPage.validateBrightsideLogo();
		Assert.assertTrue(flag, "Brightside Logo is not present");
	}

	//Validate Sign-in with valid credentials
	//@Test(dataProvider="getTestData", priority = 2)
	@Test(priority = 2)
	public void signInTest() throws IOException {
		feedsPage = signInPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("User sucessfully logged in");
	}

	@AfterMethod
	public void tearDown() throws IOException {
		TestUtils.takeScreenshotAtEndOfTest();
		driver.quit();
	}
}
