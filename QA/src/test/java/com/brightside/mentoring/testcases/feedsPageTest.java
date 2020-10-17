package com.brightside.mentoring.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.brightside.mentoring.base.TestBase;
import com.brightside.mentoring.pages.FeedsPage;
import com.brightside.mentoring.pages.SignInPage;

public class feedsPageTest extends TestBase{
	
	SignInPage signInPage;
	FeedsPage feedsPage;
	
	public feedsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signInPage = new SignInPage();
		feedsPage = new FeedsPage();
	}
	
	@Test(priority = 0)
	public void checkMentoringTour() {
		boolean tourAccess = feedsPage.getTourAccessAfterSignUp();
		if(tourAccess) {
			System.out.println("Tour is displaying");
			boolean completeTourStatus = feedsPage.completeTheTour();
			if(completeTourStatus) {
				System.out.println("Tour is completed");
			}else {
				Assert.assertTrue(completeTourStatus, "Tour cannot be completed");
			}
			
		}else {
			System.out.println("Tour is not displaying");
		}
		
	}
	
	
}
