package com.innit.testcase.mobile;

import org.testng.annotations.Test;

import com.innit.testcase.common.AboutUsPage;

/**
 * 
 * @author Harsh Wardhan Gupta Class contains all the Innit 'About Us' Page tests for
 *         Mobile devices
 */
public class AboutUsPageTest extends AboutUsPage {

    /**************** About Us page > Our Team Test ********************/

    @Test(priority = 18)
    private void checkAboutUsPageElements() {
	reportInfo("About Us page 'Tabs Presence' for Mobile :: Test Started");
	aboutUsPageElementVisibilityCheck();
	reportPass("About Us page 'Tabs Presence' for Mobile :: Test Passed");
    }

    @Test(priority = 19)
    private void validateOurTeamProfileLinks() {
	reportInfo("Team Members Profile Redirection for Mobile :: Test Started");
	ourTeamProfileLinksValidationCheck();
	reportPass("Team Members Profile Redirection for Mobile :: Test Passed");
    }

    @Test(priority = 20)
    private void checkTeamMembersName() {
	reportInfo("Check Name of Other team members cards for Mobile :: Test Started");
	getTeamMembersName();
	reportPass("Check Name of Other team members cards for Mobile :: Test Passed");
    }

    @Test(priority = 21)
    private void validateProfilePageNextPreviousButtons() {
	reportInfo(
		"Validating the 'Next' & 'Previous' button functionality on 'Our Team' Profile Page for Mobile :: Test Started");
	profilePageNextPreviousButtonCheck();
	reportPass("Validating the 'Next' & 'Previous' button functionality on Profile Page for Mobile :: Test Passed");
    }

    /******************* About Us page > Our Advisor Tests *****************/
    @Test(priority = 22)
    private void validateOurAdvisorProfileLinks() {
	reportInfo(
		"Validating the 'Our Advisor' tab profile's link visibility and their Redirections for Mobile :: Test Started");
	advisorsProfileLinkCheck();
	reportPass(
		"Validating the 'Our Advisor' tab profile's link visibility and their Redirections  for Mobile :: Test Passed");
    }

    /***************** About Us page > Our Advisor Tests *******************/

    @Test(priority = 23)
    private void mobileGoogleMapsLinkValidationTest() {
	reportInfo("Validating the 'Google Maps' link Redirection  for Mobile :: Test Started");
	validateGoogleMapsLink();
	reportPass("Validating the 'Google Maps' link Redirection for Mobile :: Test Started");
	closeAllTabs();
    }

    @Test(priority = 24)
    private void mobileFlexImageClickValidationTest() {
	reportInfo("Validating the 'FLEX IMAGE' link Redirection  for Mobile :: Test Started");
	validateFlexImageClick();
	reportPass("Validating the 'FLEX IMAGE' link Redirection  for Mobile :: Test Started");
	closeAllTabs();
    }
}
