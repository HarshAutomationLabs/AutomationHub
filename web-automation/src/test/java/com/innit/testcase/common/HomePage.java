package com.innit.testcase.common;

import com.innit.testcase.BaseTest;
import com.innit.web.constant.Constant;

public class HomePage extends BaseTest {

    protected void verifyHomePageTitle() {
	navigate(Constant.INNIT_HOME_URL);
	verifyTitle(Constant.TITLE_TEXT);
    }

    protected void homepageElementsVisibilitytest() {
	navigate(Constant.INNIT_HOME_URL);
	String browser = getBrowser();
	if (isBrowserTablet(browser) || isBrowserDesktop(browser)) {
	    isElementVisible(Constant.HOMEPAGE_HERO_IMAGE_WEB);
	    isElementVisible(Constant.HOMEPAGE_HERO_TEXT_WEB);
	    isElementVisible(Constant.APP_STORE_BTN_HERO_SECTION_WEB);
	    isElementVisible(Constant.GP_BTN_HERO_SECTION_WEB);
	    isElementVisible(Constant.DOWNLOAD_APP_BTN);
	    if (isBrowserTablet(browser)) {
		isElementPresent(Constant.HAMBURGER_ICON_LINK);
		click(Constant.HAMBURGER_ICON_LINK);
		isElementVisible(Constant.HAMBURGER_DOWNLOAD_APP);
	    }
	} else {
	    isElementVisible(Constant.HOMEPAGE_HERO_IMAGE_MOBILE);
	    isElementVisible(Constant.HERO_TEXT_MOBILE_HOMEPAGE_XPATH);
	    isElementVisible(Constant.APP_STORE_BTN_HERO_SECTION_MOBILE);
	    isElementVisible(Constant.GP_BTN_HERO_SECTION_MOBILE);
	}
    }

    protected void heroSectionGPInnitAppDownloadSteps() {
	String browser = getBrowser();
	navigate(Constant.INNIT_HOME_URL);
	if (isBrowserMobile(browser))
	    downloadMobileAppsActions(Constant.GP_BTN_HERO_SECTION_MOBILE, Constant.GP_INNIT_APP_DOWNLOAD_URL);
	if (isBrowserTablet(browser) || isBrowserDesktop(browser))
	    downloadMobileAppsActions(Constant.GP_BTN_HERO_SECTION_WEB, Constant.GP_INNIT_APP_DOWNLOAD_URL);
    }

    protected void heroSectionAppStoreInnitAppDownloadSteps() {
	String browser = getBrowser();
	navigate(Constant.INNIT_HOME_URL);
	if (isBrowserMobile(browser))
	    downloadMobileAppsActions(Constant.APP_STORE_BTN_HERO_SECTION_MOBILE,
		    Constant.APP_STORE_BTN_HERO_SECTION_MOBILE);
	if (isBrowserTablet(browser) || isBrowserDesktop(browser))
	    downloadMobileAppsActions(Constant.APP_STORE_BTN_HERO_SECTION_WEB,
		    Constant.APP_STORE_INNIT_APP_DOWNLOAD_URL);
    }

    private void downloadMobileAppsActions(String linkLocator, String storeURL) {
	click(linkLocator);
	sleep(3000);
	switchTabByIndex(1);
	validateCurrentUrl(storeURL);
	closeAllTabs();
    }

    protected void headerMenuDownloadPopUpSteps() {
	String browser = getBrowser();
	if (isBrowserDesktop(browser) || isBrowserTablet(browser)) {
	    clickDownloadBtnHeaderMenu();
	    downloadMobileAppsActions(Constant.DOWNLOAD_POPUP_APP_STORE_BTN, Constant.APP_STORE_INNIT_APP_DOWNLOAD_URL);
	    clickDownloadBtnHeaderMenu();
	    downloadMobileAppsActions(Constant.DOWNLOAD_POPUP_GP_BTN, Constant.GP_INNIT_APP_DOWNLOAD_URL);
	}
    }

    private void clickDownloadBtnHeaderMenu() {
	navigate(Constant.INNIT_HOME_URL);
	click(Constant.DOWNLOAD_APP_BTN);
	assertElementIsInViewPort(Constant.DOWNLOAD_MODAL_POPUP);
    }


    protected void hamburgerMenuDownloadBtnValidation() {
	String browser = getBrowser();
	if (isBrowserTablet(browser)) {
	    clickDownloadBtnHamburgerMenu();
	    assertElementIsInViewPort(Constant.DOWNLOAD_MODAL_POPUP);
	    downloadMobileAppsActions(Constant.DOWNLOAD_POPUP_APP_STORE_BTN, Constant.APP_STORE_INNIT_APP_DOWNLOAD_URL);
	    clickDownloadBtnHamburgerMenu();
	    downloadMobileAppsActions(Constant.DOWNLOAD_POPUP_GP_BTN, Constant.GP_INNIT_APP_DOWNLOAD_URL);
	} else {
	    clickDownloadBtnHamburgerMenu();
	    validateCurrentUrl(Constant.MOBILE_GET_THE_APP_PAGE_URL);
	}
	closeAllTabs();
    }

    private void clickDownloadBtnHamburgerMenu() {
	navigate(Constant.INNIT_HOME_URL);
	click(Constant.HAMBURGER_ICON_LINK);
	click(Constant.HAMBURGER_DOWNLOAD_APP);
    }

    protected void closeDownloadAppPopup() {
	String browser = getBrowser();
	if (isBrowserTablet(browser)) {
	    clickDownloadBtnHamburgerMenu();
	    click(Constant.GET_COOKING_POPUP_CLOSE_BUTTON);
	}
    }

    protected void FooterLinksValidationTest() {
	navigate(Constant.INNIT_HOME_URL);
	String browser = getBrowser();
	sleep(2000);
	if (isBrowserMobile(browser)) {
	    scrollToPageElement(Constant.FACEBOOK_ICON_LINK);
	    hoverOnElement(Constant.FACEBOOK_ICON_LINK);
	    doFooterLinkValidation(Constant.FACEBOOK_MOBILE_FOOTER_LINK, Constant.MOBILE_FACEBOOK_PAGE_URL);
	    doFooterLinkValidation(Constant.INSTAGRAM_MOBILE_FOOTER_LINK, Constant.INSTAGRAM_PAGE_URL);
	    navigate(Constant.INNIT_HOME_URL);
	    doFooterLinkValidation(Constant.LINKEDIN_MOBILE_FOOTER_LINK, Constant.LINKEDIN_PAGE_URL);
	    doFooterLinkValidation(Constant.TWITTER_MOBILE_FOOTER_LINK, Constant.MOBILE_TWITTER_PAGE_URL);
	}
	if (isBrowserTablet(browser) || isBrowserDesktop(browser)) {
	    scrollToPageElement(Constant.FACEBOOK_ICON_LINK);
	    scrollToPageElement(Constant.FACEBOOK_ICON_LINK);
	    doFooterLinkValidation(Constant.FACEBOOK_ICON_LINK, Constant.FACEBOOK_PAGE_URL);
	    doFooterLinkValidation(Constant.INSTAGRAM_ICON_LINK, Constant.INSTAGRAM_PAGE_URL);
	    doFooterLinkValidation(Constant.LINKEDIN_ICON_LINK, Constant.LINKEDIN_PAGE_URL);
	    if (isBrowserTablet(browser))
		doFooterLinkValidation(Constant.TWITTER_ICON_LINK, Constant.MOBILE_TWITTER_PAGE_URL);
	    else
		doFooterLinkValidation(Constant.TWITTER_ICON_LINK, Constant.TWITTER_PAGE_URL);
	}
	doFooterLinkValidation(Constant.PARTNERS_FOOTER_LINK, Constant.PARTNERS_PAGE_URL);
	doFooterLinkValidation(Constant.ABOUT_US_FOOTER_LINK, Constant.ABOUT_US_PAGE_URL);
	doFooterLinkValidation(Constant.PRESS_FOOTER_LINK, Constant.PRESS_PAGE_URL);
	doFooterLinkValidation(Constant.CAREERS_FOOTER_LINK, Constant.CAREERS_PAGE_URL);
	doFooterLinkValidation(Constant.SUPPORT_FOOTER_LINK, Constant.SUPPORT_PAGE_URL);
	doFooterLinkValidation(Constant.PRIVACY_FOOTER_LINK, Constant.PRIVACY_PAGE_URL);
	doFooterLinkValidation(Constant.TERM_OF_SERVICE_FOOTER_LINK, Constant.TERMS_OF_SERVICE_PAGE_URL);
    }

    protected void headerLinksValidationTest() {
	navigate(Constant.INNIT_HOME_URL);
	String browser = getBrowser();
	if (isBrowserTablet(browser) || isBrowserMobile(browser)) {
	    doHeaderLinkValidation(browser, Constant.HOMEPAGE_MOBILE_LINK, Constant.INNIT_HOME_URL);
	    doHeaderLinkValidation(browser, Constant.PARTNERS_MOBILE_LINK, Constant.PARTNERS_PAGE_URL);
	    doHeaderLinkValidation(browser, Constant.ABOUT_US_MOBILE_LINK, Constant.ABOUT_US_PAGE_URL);
	    doHeaderLinkValidation(browser, Constant.PRESS_MOBILE_LINK, Constant.PRESS_PAGE_URL);
	    doHeaderLinkValidation(browser, Constant.CAREERS_MOBILE_LINK, Constant.CAREERS_PAGE_URL);
	    if (isBrowserTablet(browser))
		doHeaderLinkValidation(browser, Constant.HAMBURGER_FACEBOOK_ICON_LINK, Constant.FACEBOOK_PAGE_URL);
	    if (isBrowserMobile(browser))
		doHeaderLinkValidation(browser, Constant.HAMBURGER_FACEBOOK_ICON_LINK,
			Constant.MOBILE_FACEBOOK_PAGE_URL);
	    doHeaderLinkValidation(browser, Constant.HAMBURGER_INSTAGRAM_ICON_LINK, Constant.INSTAGRAM_PAGE_URL);
	    navigate(Constant.INNIT_HOME_URL);
	    doHeaderLinkValidation(browser, Constant.HAMBURGER_LINKEDIN_ICON_LINK, Constant.LINKEDIN_PAGE_URL);
	    doHeaderLinkValidation(browser, Constant.HAMBURGER_TWITTER_ICON_LINK, Constant.MOBILE_TWITTER_PAGE_URL);
	    hamburgerMenuDownloadBtnValidation();
	}
	if (isBrowserDesktop(browser)) {
	    doHeaderLinkValidation(browser, Constant.PARTNERS_HEARDER_LINK, Constant.PARTNERS_PAGE_URL);
	    doHeaderLinkValidation(browser, Constant.ABOUT_US_HEADER_LINK, Constant.ABOUT_US_PAGE_URL);
	    doHeaderLinkValidation(browser, Constant.PRESS_HEADER_LINK, Constant.PRESS_PAGE_URL);
	}
    }

    private void doHeaderLinkValidation(String browser, String linkLocator, String linkUrl) {
	if (isBrowserTablet(browser) || isBrowserMobile(browser)) {
	    validateMobileTestLink(linkLocator, linkUrl);
	}
	if (isBrowserDesktop(browser)) {
	    validateLink(linkLocator, linkUrl);
	}
	gotoPriviouspage();
    }

    private void doFooterLinkValidation(String linkLocator, String linkUrl) {
	validateLink(linkLocator, linkUrl);
	navigate(Constant.INNIT_HOME_URL);
    }

    protected void validateAutoPlayVideoSrc(String browser) {
	navigate(Constant.INNIT_HOME_URL);
	if (isBrowserDesktop(browser) || isBrowserTablet(browser)) {
	    isElementVisible(Constant.MEALS_JUST_FOR_YOU_FLEX_VIDEO);
	    isElementVisible(Constant.ENDLESS_POSSIBILITIES_FLEX_VIDEO);
	    isElementVisible(Constant.CULINARY_GPS_FLEX_VIDEO);
	    isElementVisible(Constant.CONNECT_SMARTPHONE_VIDEO);
	} else {
	    isElementVisible(Constant.MEALS_JUST_FOR_YOU_FLEX_IMAGE);
	    isElementVisible(Constant.ENDLESS_POSSIBILITIES_FLEX_IMAGE);
	    isElementVisible(Constant.CULINARY_GPS_FLEX_IMAGE);
	    isElementVisible(Constant.CONNECT_SMARTPHONE_IMAGE);
	}
    }

    protected void doUserRegistrationActions(String userEmail, String validationMessgeText) {
	isElementPresent(Constant.EMAIL_FIELD);
	type(Constant.EMAIL_FIELD, userEmail);
	click(Constant.EMAIL_SUBSCRIBE_BUTTON);
	switchTabByIndex(1);
	takeScreenShot();
	validateSubscribedEmail(userEmail, validationMessgeText);
	sleep(2000);
    }
}
