package com.innit.testcase.common;

import com.innit.testcase.BaseTest;
import com.innit.web.constant.Constant;

public class AboutUsPage extends BaseTest {
    String browser;

    protected void aboutUsPageElementVisibilityCheck() {
	navigate(Constant.ABOUT_US_PAGE_URL);
	browser = getBrowser();
	if (isBrowserDesktop(browser) || isBrowserTablet(browser)) {
	    isElementVisible(Constant.OUR_TEAM_TAB);
	    isElementVisible(Constant.OUR_ADVISORS_TAB);
	    isElementVisible(Constant.OUR_LOCATION_TAB);
	}
	if (isBrowserMobile(browser)) {
	    click(Constant.TABS_MENU_MOBILE_XPATH);
	    isElementVisible(Constant.OUR_ADVISOR_TAB_LIST_MOBILE_XPATH);
	    isElementVisible(Constant.OUR_LOCATION_TAB_LIST_MOBILE_XPATH);
	    isElementVisible(Constant.OUR_TEAM_TAB_LIST_MOBILE_XPATH);
	}
    }

    protected void ourTeamProfileLinksValidationCheck() {
	browser = getBrowser();
	navigate(Constant.ABOUT_US_PAGE_URL);
	teamMemberProfileTest();
    }

    protected void getTeamMembersName() {
	browser = getBrowser();
	navigate(Constant.ABOUT_US_PAGE_URL);
	hoverOnTeamCards();
    }

    protected void profilePageNextPreviousButtonCheck() {
	browser = getBrowser();
	navigate(Constant.ABOUT_US_PAGE_URL);
	nextPreviousButtonFunctionality(Constant.EUGENIO_MINVIELLE_PROFILE_LINK,
		Constant.STATHIS_MYTILINAIO_PROFILE_PAGE_URL, Constant.EUGENIO_MINVIELLE_PROFILE_PAGE_URL);
    }

    protected void advisorsProfileLinkCheck() {
	browser = getBrowser();
	validateAdvisorProfileLink(Constant.JULIA_FRENK_PROFILE_LINK, Constant.JULIA_FRENK_PROFILE_URL);
	validateAdvisorProfileLink(Constant.ARNAUD_DE_PUYFONTAINE_LINK, Constant.ARNAUD_DE_PUYFONTAINE_PROFILE_URL);
	validateAdvisorProfileLink(Constant.TYLER_FLORENCE_PROFILE_LINK, Constant.TYLER_FLORENCE_PROFILE_URL);
	validateAdvisorProfileLink(Constant.MIKE_HARRIS_PROFILE_LINK, Constant.MIKE_HARRIS_PROFILE_URL);
	validateAdvisorProfileLink(Constant.MAURA_ONEILL_PROFILE_LINK, Constant.MAURA_ONEILL_PROFILE_URL);
	validateAdvisorProfileLink(Constant.SAM_KASS_PROFILE_LINK, Constant.SAM_KASS_PROFILE_URL);
	validateAdvisorProfileLink(Constant.PILAR_PEREZ_PROFILE_LINK, Constant.PILAR_PEREZ_PROFILE_URL);
	validateAdvisorProfileLink(Constant.RAYMOND_McCAULEY_PROFILE_LINK, Constant.RAYMOND_MCCAULEY_PROFILE_URL);
	validateAdvisorProfileLink(Constant.GERARD_DUPONT_PROFILE_LINK, Constant.GERARD_DUPONT_PROFILE_URL);
    }

    protected void validateGoogleMapsLink() {
	browser = getBrowser();
	if (isBrowserDesktop(browser) || isBrowserTablet(browser))
	    checkinnitLocationURL(Constant.GOOGLE_MAPS_LINK_XPATH);
	else
	    checkinnitLocationURL(Constant.GOOGLE_MAPS_LINK_IPAD_XPATH);
    }

    protected void validateFlexImageClick() {
	browser = getBrowser();
	if (isBrowserDesktop(browser) || isBrowserTablet(browser))
	    checkinnitLocationURL(Constant.FLEX_LOCATION_LINK_XPATH);
	else
	    checkinnitLocationURL(Constant.FLEX_LOCATION_LINK_IPAD_XPATH);
    }

    private void checkinnitLocationURL(String pageLocatorKey) {
	navigate(Constant.ABOUT_US_PAGE_URL);
	if (isBrowserDesktop(browser) || isBrowserTablet(browser)) {
	    click(Constant.OUR_LOCATION_TAB);
	} else
	    selectDropdownOption(Constant.TABS_MENU_MOBILE_XPATH, Constant.OUR_LOCATION_TAB_LIST_MOBILE_XPATH);
	click(pageLocatorKey);
	switchTabByIndex(1);
	validateCurrentUrl(Constant.INNIT_GOOGLE_MAPS_URL);
    }

    private void validateAdvisorProfileLink(String memberProfileLink, String memberProfileUrl) {
	navigate(Constant.ABOUT_US_PAGE_URL);
	if (isBrowserDesktop(browser) || isBrowserTablet(browser))
	    click(Constant.OUR_ADVISORS_TAB);
	else {
	    selectDropdownOption(Constant.TABS_MENU_MOBILE_XPATH, Constant.OUR_ADVISOR_TAB_LIST_MOBILE_XPATH);
	}
	validateProfileLink(memberProfileLink, memberProfileUrl);
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

    private void hoverOnTeamCards() {
	for (int index = 9; index < 36; index++) {
	    takeScreenShot();
	    reportInfo("Hover over the card of :: " + getTeamMemberName(index));
	}
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
