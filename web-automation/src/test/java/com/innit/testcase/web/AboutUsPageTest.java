package com.innit.testcase.web;

import org.testng.annotations.Test;
import com.innit.testcase.BaseTest;
import com.innit.web.constant.Constant;

/**
 * 
 * @author Harsh Wardhan Gupta
 * 
 *         Class contains all the Innit 'About Us' Page tests for Mobile devices
 */
public class AboutUsPageTest extends BaseTest {

    /************************
     * About Us page > Our Team Test
     ****************************/

    /**
     * 
     */
    @Test(priority = 18)
    private void aboutUsPageTabsPresenceTest() {
	reportInfo("About Us page 'Tabs presence' :: Test Started");
	navigate(Constant.ABOUT_US_PAGE_URL);
	isElementPresent(Constant.OUR_TEAM_TAB);
	isElementPresent(Constant.OUR_ADVISORS_TAB);
	isElementPresent(Constant.OUR_LOCATION_TAB);
	takeScreenShot();
	reportPass("About Us page 'Tabs presence' :: Test Passed");
    }

    @Test(priority = 19)
    private void ourTeamProfileLinksValidationTest() {
	reportInfo("Team Members Profile Redirection :: Test Started");
	navigate(Constant.ABOUT_US_PAGE_URL);
	teamMemberProfileTest();
	reportPass("Team Members Profile Redirection :: Test Passed");
    }

    @Test(priority = 20)
    private void checkTeamMembersName() {
	reportInfo("Check Name of Other team members cards :: Test Started");
	navigate(Constant.ABOUT_US_PAGE_URL);
	hoverOnTeamCards();
	reportPass("Check Name of Other team members cards :: Test Passed");
    }

    @Test(priority = 21)
    private void validateProfilePageNextPreviousButtons() {
	reportInfo(
		"Validating the 'Next' & 'Previous' button functionality on 'Our Team' Profile Page :: Test Started");
	navigate(Constant.ABOUT_US_PAGE_URL);
	nextPreviousButtonFunctionality(Constant.EUGENIO_MINVIELLE_PROFILE_LINK,
		Constant.STATHIS_MYTILINAIO_PROFILE_PAGE_URL, Constant.EUGENIO_MINVIELLE_PROFILE_PAGE_URL);
	reportPass("Validating the 'Next' & 'Previous' button functionality on Profile Page :: Test Passed");
    }

    /*************************
     * About Us page > Our Advisor Tests
     ****************************/

    @Test(priority = 22)
    private void validateOurAdvisorProfileLinks() {
	reportInfo("Validating the 'Our Advisor' tab profile's link visibility and their Redirections :: Test Started");
	navigate(Constant.ABOUT_US_PAGE_URL);
	advisorMemberProfileTest();
	reportPass("Validating the 'Our Advisor' tab profile's link visibility and their Redirections :: Test Passed");
    }

    /************************
     * About Us page > Our Advisor Tests*
     ****************************/

    @Test(priority = 23)
    private void validateGoogleMapsLink() {
	reportInfo("Validating the 'Google Maps' link Redirection :: Test Started");
	checkinnitLocationURL(Constant.GOOGLE_MAPS_LINK_XPATH);
	reportPass("Validating the 'Google Maps' link Redirection :: Test Started");
	closeAllTabs();
    }

    @Test(priority = 24)
    private void validateFlexImageClick() {
	reportInfo("Validating the 'FLEX IMAGE' link Redirection :: Test Started");
	checkinnitLocationURL(Constant.FLEX_LOCATION_LINK_XPATH);
	reportPass("Validating the 'FLEX IMAGE' link Redirection :: Test Started");
	closeAllTabs();
    }

    private void checkinnitLocationURL(String pageLocatorKey) {
	navigate(Constant.ABOUT_US_PAGE_URL);
	click(Constant.OUR_LOCATION_TAB);
	click(pageLocatorKey);
	switchTabByIndex(1);
	validateCurrentUrl(Constant.INNIT_GOOGLE_MAPS_URL);
    }

    /*************************
     * About Us Page Generic function Declarations
     * 
     * @throws InterruptedException
     *********************/

    private void hoverOnTeamCards() {
	for (int index = 9; index < 35; index++) {
	    takeScreenShot();
	    reportInfo("Hover over the card of :: " + getTeamMemberName(index));
	}
    }

    private void nextPreviousButtonFunctionality(String firstMemberProfileLink, String secondMemberProfileUrl,
	    String firstMemberProfileUrl) {
	takeScreenShot();
	click(firstMemberProfileLink);
	takeScreenShot();
	click(Constant.NEXT_BUTTON_PROFILE_XPATH);
	validateCurrentUrl(secondMemberProfileUrl);
	click(Constant.PREVIOUS_BUTTON_PROFILE_XPATH);
	validateCurrentUrl(firstMemberProfileUrl);
    }

    private void advisorMemberProfileTest() {
	click(Constant.OUR_ADVISORS_TAB);
	validateProfileLink(Constant.JULIA_FRENK_PROFILE_LINK, Constant.JULIA_FRENK_PROFILE_URL);
	click(Constant.OUR_ADVISORS_TAB);
	validateProfileLink(Constant.ARNAUD_DE_PUYFONTAINE_LINK, Constant.ARNAUD_DE_PUYFONTAINE_PROFILE_URL);
	click(Constant.OUR_ADVISORS_TAB);
	validateProfileLink(Constant.TYLER_FLORENCE_PROFILE_LINK, Constant.TYLER_FLORENCE_PROFILE_URL);
	click(Constant.OUR_ADVISORS_TAB);
	validateProfileLink(Constant.MIKE_HARRIS_PROFILE_LINK, Constant.MIKE_HARRIS_PROFILE_URL);
	click(Constant.OUR_ADVISORS_TAB);
	validateProfileLink(Constant.SAM_KASS_PROFILE_LINK, Constant.SAM_KASS_PROFILE_URL);
	click(Constant.OUR_ADVISORS_TAB);
	validateProfileLink(Constant.PILAR_PEREZ_PROFILE_LINK, Constant.PILAR_PEREZ_PROFILE_URL);
	click(Constant.OUR_ADVISORS_TAB);
	validateProfileLink(Constant.RAYMOND_McCAULEY_PROFILE_LINK, Constant.RAYMOND_MCCAULEY_PROFILE_URL);
	click(Constant.OUR_ADVISORS_TAB);
	validateProfileLink(Constant.GERARD_DUPONT_PROFILE_LINK, Constant.GERARD_DUPONT_PROFILE_URL);
    }

    private void teamMemberProfileTest() {
	validateProfileLink(Constant.EUGENIO_MINVIELLE_PROFILE_LINK, Constant.EUGENIO_MINVIELLE_PROFILE_PAGE_URL);
	validateProfileLink(Constant.KEVIN_BROWN_PROFILE_LINK, Constant.KEVIN_BROWN_PROFILE_PAGE_URL);
	validateProfileLink(Constant.EUGENIO_GARCIA_PROFILE_LINK, Constant.EUGENIO_GRACIA_PROFILE_PAGE_URL);
	validateProfileLink(Constant.HRISTO_BOJINOV_PROFILE_LINK, Constant.HRISTO_BOJINOVKEVIN_PROFILE_PAGE_URL);
	validateProfileLink(Constant.ANKIT_BRAHMBHATT_PROFILE_LINK, Constant.ANKIT_BRAHMBHATT_PROFILE_PAGE_URL);
	validateProfileLink(Constant.JONATHAN_KLEMENS_PROILE_LINK, Constant.JONATHAN_KLEMENS_PROILE_PAGE_URL);
	validateProfileLink(Constant.STATHIS_MYTILINAIO_PROFILE_LINK, Constant.STATHIS_MYTILINAIO_PROFILE_PAGE_URL);
    }

    private void validateProfileLink(String profileLink, String profileUrl) {
	validateLink(profileLink, profileUrl);
	click(Constant.RETURN_TO_TEAM_PAGE_XPATH);
    }

}
