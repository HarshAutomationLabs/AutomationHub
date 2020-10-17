package com.brightside.mentoring.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.brightside.mentoring.base.TestBase;
import com.brightside.mentoring.pages.FeedsPage;
import com.brightside.mentoring.pages.MentoringHomepage;
import com.brightside.mentoring.pages.MessagingPage;
import com.brightside.mentoring.pages.SignInPage;
import com.brightside.mentoring.utils.TestUtils;

public class MessagingPageTest extends TestBase {

	SignInPage signInPage;
	FeedsPage feedsPage;
	MentoringHomepage mentoringHomepage;
	MessagingPage messagingPage;

	public MessagingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signInPage = new SignInPage();
		mentoringHomepage = new MentoringHomepage();
		messagingPage = new MessagingPage();
		feedsPage = signInPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		mentoringHomepage.clickOnMessagingLink();
	}

	// When simple message sent in messaging channel
	@Test(priority = 0)
	public void messagingScenario() {
		messagingPage.validateGetLastMessage();
		messagingPage.MessageScenario("TestMessage");
		messagingPage.ClickSendMessage();
		boolean sentFlag = messagingPage.validateMessage("TestMessage");
		Assert.assertTrue(sentFlag, "Message is not validated");
	}

	@AfterMethod
	public void tearDown() throws IOException {
		TestUtils.takeScreenshotAtEndOfTest();
		driver.quit();
	}
}
