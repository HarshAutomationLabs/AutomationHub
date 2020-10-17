package com.innit.testcase.mobile;

import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.innit.testcase.common.HomePage;
import com.innit.web.constant.Constant;

/**
 * 
 * @author Harsh Wardhan Gupta
 * 
 *         Class contains all the Innit 'Home Page' tests for Mobile devices.
 */

public class HomePageTest extends HomePage {

    @Test(priority = 0)
    public void verifyHomePageTitleTest() {
	reportInfo("Innit Home Page Title verification test started for :: " + getBrowser());
	verifyHomePageTitle();
	reportPass("Innit Home Page Title verified for :: " + getBrowser());
    }

    @Parameters({ "browser" })
    @Test(priority = 1)
    private void mobileFlexVideoVisibilityTest(String browser) {
	reportInfo("To validate the flex elements visibility :: Test Started");
	validateAutoPlayVideoSrc(browser);
	reportPass("To validate the flex elements visibility :: Test Passed");
    }

    @Test(priority = 2)
    public void validateMobileHeroElements() throws InterruptedException {
	reportInfo("Innit Home page 'Hero Element' visibility test started for :: " + getBrowser());
	homepageElementsVisibilitytest();
	reportPass("Innit 'Home page 'Hero Element' visibility test Passed for :: " + getBrowser());
    }

    @Test(priority = 4)
    public void tabletHeaderDownloadBtnFunctionalityTest() {
	reportInfo("Innit 'Mobile Hamburger icon Link' Validation test started for :: " + getBrowser());
	if (isBrowserTablet(getBrowser())) {
	    headerMenuDownloadPopUpSteps();
	} else {
	    throw new SkipException("Skipping - This test is not for Mobile browser");
	}
	reportPass("Innit 'Mobile Hamburger icon Link' Validation test Passed for :: " + getBrowser());
    }

    @Test(priority = 5)
    private void mobileHamburgerMenuValidationTest() {
	reportInfo("Innit 'Mobile Hamburger icon Link' Validation test started for :: " + getBrowser());
	headerLinksValidationTest();
	reportPass("Innit 'Mobile Hamburger icon Link' Validation test Passed for :: " + getBrowser());
    }

    @Test(priority = 3)
    private void mobileFooterLinksValidationtest() {
	reportInfo("Innit 'Mobile Footer Link' Validation test started");
	FooterLinksValidationTest();
	reportPass("Innit 'Mobile Footer Link' Validation test Passed");
    }

    @Test(priority = 6) // New User News Subscription Test
    public void newUserEmailSubscriptioTest() {
	reportInfo("Innit 'New User Subscription' test started for Mobile");
	navigate(Constant.INNIT_HOME_URL);
	reportInfo("New user news subscription test started");
	doUserRegistrationActions(userEmail, Constant.NEW_USER_SUBSCRIPTION_MESSAGE_XPATH);
	reportPass("Innit 'New User Subscription' test Passed for Mobile");
	closeAllTabs();
    }

    @Test(priority = 7)
    private void mobileHeroSectionGPDwnBtnTest() {
	reportInfo("To verify the hero section 'Google Play Store' button functionality test started for :: "
		+ getBrowser());
	heroSectionGPInnitAppDownloadSteps();
	reportPass("To verify the hero section 'Google Play Store' button functionality test Passed for :: "
		+ getBrowser());
    }

    @Test(priority = 8)
    private void mobileHeroSectionAppStoreBtnTest() {
	reportInfo("To verify the hero section 'App Store' button functionality test started for :: " + getBrowser());
	heroSectionAppStoreInnitAppDownloadSteps();
	reportPass("To verify the hero section 'App Store' button functionality test Passed for :: " + getBrowser());
    }

    @Test(priority = 9) // Existing User News Subscription Test
    public void registeredEmailSubscriptionTest() throws InterruptedException {
	reportInfo("Innit 'Registered Email Subscription' test started For Mobile");
	switchTabByIndex(0);
	navigate(Constant.INNIT_HOME_URL);
	reportInfo("Registered user news subscription test started");
	doUserRegistrationActions(Constant.ALREADY_SUBSCRIBED_EMAIL, Constant.SUBSCRIBED_USER_MESSAGE_XPATH);
	reportInfo("Innit 'Registered Email Subscription' test passed For Mobile");
	closeAllTabs();
    }

    @Test(priority = 10)
    protected void downloadFreeAppModalCloseButtonFunctionalityTest() {
	String browser = getBrowser();
	if (isBrowserTablet(browser)) {
	    reportInfo(
		    "To verify the Home page Download Free App Modal window Close Button functionality :: Test Started");
	    closeDownloadAppPopup();
	    reportPass(
		    "To verify the Home page Download Free App Modal window Close Button functionality :: Test Passed");
	}
    }

    @Test(priority = 11)
    public void learnMoreLinkTest() {
	reportInfo("Learn More Link Validation test for Mobile :: Test Started");
	navigate(Constant.INNIT_HOME_URL);
	validateLink(Constant.LEARN_MORE_HOMEPAGE_LINK, Constant.ELECTROLUX_PARTNER_URL);
	reportPass("Learn More Link Validation test for Mobile :: Test Passed");
	gotoPriviouspage();
    }
}
