package com.brightside.mentoring.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.brightside.mentoring.base.TestBase;
import com.brightside.mentoring.pages.AssignmentsPage;
import com.brightside.mentoring.pages.FeedsPage;
import com.brightside.mentoring.pages.MentoringHomepage;
import com.brightside.mentoring.pages.SignInPage;
import com.brightside.mentoring.utils.TestUtils;

public class AssignmentPageTest extends TestBase {

	SignInPage signInPage;
	FeedsPage feedsPage;
	MentoringHomepage mentoringHomepage;
	AssignmentsPage assignmentPage;

	public AssignmentPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signInPage = new SignInPage();
		feedsPage = new FeedsPage();
		assignmentPage = new AssignmentsPage();
		feedsPage = signInPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		mentoringHomepage.clickOnAssignmentsLink();
	}

	// Validate Assignment URL Test
	@Test(priority = 0)
	public void assignmentURLTest() {
		String currentAssignmentURL = assignmentPage.validateAssignmentURL();
		Assert.assertEquals(currentAssignmentURL, prop.getProperty("MenteeAssignmentURL"),
				"Mentee Assignment URL doesn't matched");
	}

	// Validate Assignment Title Test
	@Test(priority = 1)
	public void assignmentTitleTest() {
		String assignmentTitle = assignmentPage.validateAssignmentsTitle();
		Assert.assertEquals(assignmentTitle, "My Assignment", "Assignment Title doesn't matched");
	}

	// Validate Assignment Uploading Test
	@Test(priority = 2)
	public void AssignmentUploadTest() throws InterruptedException {
		boolean assignmentFlag = assignmentPage
				.AssignmentUpload(prop.getProperty("assignmentFilePath") + prop.getProperty("fileName"));
		if (assignmentFlag) {
			assignmentPage.clickSubmitButton();
			boolean flag = assignmentPage.validateAssignment(prop.getProperty("fileName"));
			Assert.assertTrue(flag, "Assignment file doesn't validated");
		} else {
			String toasterMessage = assignmentPage.GetToasterText();
			Assert.assertEquals(toasterMessage, "Please attach valid files only");
		}
	}

	@AfterMethod
	public void tearDown() throws IOException {
		TestUtils.takeScreenshotAtEndOfTest();
		driver.quit();
	}
}
