package com.innit.testcase.web;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.innit.testcase.common.HomePage;
import com.innit.web.constant.Constant;

/**
 * @author Harsh Wardhan Gupta
 * 
 *         Class contains all the Innit 'Home Page' tests.
 */
public class HomePageTest extends HomePage {

    /**
     * To Test the Innit.com homepage Title.
     */
    @Test(priority = 0)
    private void verifyHomepageTitleTest() {
	reportInfo("To verify the Home page title :: Test Started");
	verifyHomePageTitle();
	reportPass("To verify the Home page title :: Test Passed");
    }

    @Test(priority = 1)
    private void validateWebHeroElements() {
	reportInfo("Test Started to check the visibility of Home page elements for :: " + getBrowser());
	homepageElementsVisibilitytest();
	reportPass("Test Passed to check the visibility of Home page elements for :: " + getBrowser());
    }

    @Test(priority = 2)
    private void webHeaderDownloadBtnFunctionalityTest() {
	reportInfo("To verify the header 'Google Play' icon functionality :: Test Started");
	headerMenuDownloadPopUpSteps();
	reportPass("To verify the header 'Google Play' icon functionality :: Test Passed");
    }

    @Test(priority = 3)
    private void heroSectionGPDwnBtnTest() {
	reportInfo("To verify the hero section 'Google Play' icon functionality :: Test Started");
	heroSectionGPInnitAppDownloadSteps();
	reportPass("To verify the hero section 'Google Play' icon functionality :: Test Passed");
    }

    @Test(priority = 4)
    private void heroSectionAppStoreDwnBtnTest() {
	reportInfo("To verify the hero section 'Apple App Store' icon functionality :: Test Started");
	heroSectionAppStoreInnitAppDownloadSteps();
	reportPass("To verify the hero section 'Apple App Store' icon functionality :: Test Passed");
    }

    /**
     * To test the Header links redirections.
     */
    @Parameters({ "browser" })
    @Test(priority = 6)
    private void webHeaderLinksValidationTest(String browser) {
	reportInfo("To validate the links of header section :: Test Started");
	headerLinksValidationTest();
	reportPass("To validate the links of header section :: Test Passed");
    }

    /**
     * To test the footer links redirections.
     */
    @Parameters({ "browser" })
    @Test(priority = 7)
    private void webFooterLinksValidationTest(String browser) {
	reportInfo("To validate the links of Footer section :: Test Started");
	FooterLinksValidationTest();
	reportPass("To validate the links of Footer section :: Test Passed");
    }

    @Parameters({ "browser" })
    @Test(priority = 5)
    private void webFlexVideoVisibilityTest(String browser) {
	reportInfo("To validate the flex elements visibility :: Test Started");
	validateAutoPlayVideoSrc(browser);
	reportPass("To validate the flex elements visibility :: Test Passed");
    }

    /**
     * To test the Subscribe to email functionality with new User email.
     */
    @Test(priority = 8)
    private void newUserEmailSubscriptionTest() {
	navigate(Constant.INNIT_HOME_URL);
	reportInfo(
		"To verify the functionality when user clicks on the Submit button with new user email id :: Test Started");
	doUserRegistrationActions(userEmail, Constant.NEW_USER_SUBSCRIPTION_MESSAGE_XPATH);
	reportPass(
		"To verify the functionality when user clicks on the Submit button with new user email id :: Test Passed");
	closeTabByIndex(1);
    }

    /**
     * To test the Subscribe to email functionality with new previously registered
     * email.
     */
    @Test(priority = 9)
    private void registeredUserEmailSubscriptionTest() {
	switchTabByIndex(0);
	navigate(Constant.INNIT_HOME_URL);
	reportInfo(
		"To verify the functionality when user clicks on the Submit button with email id already registered :: Test Started");
	doUserRegistrationActions(Constant.ALREADY_SUBSCRIBED_EMAIL, Constant.SUBSCRIBED_USER_MESSAGE_XPATH);
	reportPass(
		"To verify the functionality when user clicks on the Submit button with email id already registered :: Test Passed");
	closeTabByIndex(1);
    }

    /**
     * To test the Subscribe to email > Submit button test with no email enter.
     */
    @Test(priority = 10)
    private void submitButtonClickFunctioanlityTest() throws InterruptedException {
	switchTabByIndex(0);
	navigate(Constant.INNIT_HOME_URL);
	reportInfo(
		"To verify user is able to click on the Submit button keeping the Email address field blank :: Test Started");
	doUserRegistrationActions("", Constant.NO_EMAIL_ENTER_MESSAGE_XPATH);
	reportPass(
		"To verify user is able to click on the Submit button keeping the Email address field blank :: Test Passed");
	closeTabByIndex(1);
	Thread.sleep(2000);
	switchTabByIndex(0);
	Thread.sleep(2000);
	closeAllTabs();
    }

    /**
     * To test the Learn more link validation test.
     */
    @Test(priority = 11)
    public void learnMoreLinkValidationTest() {
	reportInfo("Learn More Link Validation test for Mobile :: Test Started");
	navigate(Constant.INNIT_HOME_URL);
	validateLink(Constant.LEARN_MORE_HOMEPAGE_LINK, Constant.ELECTROLUX_PARTNER_URL);
	reportPass("Learn More Link Validation test for Mobile :: Test Passed");
    }
}
