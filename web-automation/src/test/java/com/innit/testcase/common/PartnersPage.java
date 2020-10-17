package com.innit.testcase.common;

import org.testng.Assert;

import com.innit.testcase.BaseTest;
import com.innit.web.constant.Constant;

public class PartnersPage extends BaseTest {

    protected void partnersPageIconValidation() {
	navigate(Constant.PARTNERS_PAGE_URL);
	validateLink(Constant.INNIT_LOGO_XPATH, Constant.INNIT_HOME_URL);
    }

    protected void partnersPageElementsVisibilityCheck() {
	navigate(Constant.PARTNERS_PAGE_URL);
	String browser = getBrowser();
	if (isBrowserDesktop(browser) || isBrowserTablet(browser)) {
	    Assert.assertTrue(isElementVisible(Constant.PARTNERS_HERO_IMAGE_WEB),
		    "Hero Image with text overlay and partner branding is present for " + browser);
	    Assert.assertTrue(isElementVisible(Constant.REQUEST_A_DEMO_BUTTON),
		    "Request a demo button is repesent in the Partners page for " + browser);
	}
	if (isBrowserMobile(browser)) {
	    Assert.assertTrue(isElementVisible(Constant.PARTNERS_HERO_IMAGE_MOBILE),
		    "Hero Image with text overlay and partner branding is present for " + browser);
	    Assert.assertTrue(isElementVisible(Constant.REQUEST_A_DEMO_BUTTON_MOBILE),
		    "Request a demo button is repesent in the Partners page for " + browser);
	    Assert.assertTrue(isElementVisible(Constant.WATCH_LINK_APPLIANCES_MOBILE),
		    "Watch link for appliances is present in the Partners page for " + browser);
	    Assert.assertTrue(isElementVisible(Constant.WATCH_LINK_TECHNOLOGY_MOBILE),
		    "Watch link for technology is present in the Partners page for " + browser);
	}
	Assert.assertTrue(isElementVisible(Constant.PARTNER_WITH_US_FIELD),
		"Partner with us contact form fied is present in the Partners page for " + browser);
	Assert.assertTrue(isElementVisible(Constant.APPLIANCES_PLAY_BUTTON),
		"Play Button link for appliances is present in the Partners page for " + browser);
	Assert.assertTrue(isElementVisible(Constant.TECHNOLOGY_PLAY_BUTTON),
		"Play button link for technology is present in the page for " + browser);
    }

    protected void appliancesPlayButtonFunctionality() {
	navigate(Constant.PARTNERS_PAGE_URL);
	click(Constant.APPLIANCES_PLAY_BUTTON);
	appliancesYoutubeVideoPresence();
    }

    protected void technologyPlayButtonFunctionality() {
	navigate(Constant.PARTNERS_PAGE_URL);
	sleep(2000);
	click(Constant.TECHNOLOGY_PLAY_BUTTON);
	technologyYoutubeVideoPresence();
    }

    private void appliancesYoutubeVideoPresence() {
	sleep(2000);
	Assert.assertTrue(isElementVisible(Constant.YOUTUBE_VIDEO_IFRAME_APPLIANCES),
		"Appliances Video is not displaying ");
	Assert.assertTrue(isElementVisible(Constant.YOUTUBE_VIDEO_CLOSE_BTN_APPLIANCES),
		"Appliaances Video CLose button is not displaying");
    }

    private void technologyYoutubeVideoPresence() {
	sleep(3000);
	Assert.assertTrue(isElementVisible(Constant.YOUTUBE_VIDEO_IFRAME_TECHNOLOGY),
		"Technology Video is not displaying ");
	Assert.assertTrue(isElementVisible(Constant.YOUTUBE_VIDEO_CLOSE_BTN_TECHNOLOGY),
		"Technology Video CLose button is not displaying");
    }

    protected void appliancesWatchLinkFunctionality() {
	navigate(Constant.PARTNERS_PAGE_URL);
	String browser = getBrowser();
	if (isBrowserDesktop(browser) || isBrowserTablet(browser))
	    click(Constant.WATCH_LINK_APPLIANCES_WEB);
	else
	    click(Constant.WATCH_LINK_APPLIANCES_MOBILE);
	appliancesYoutubeVideoPresence();
    }

    protected void technologyWatchLinkFunctionality() {
	navigate(Constant.PARTNERS_PAGE_URL);
	String browser = getBrowser();
	if (isBrowserDesktop(browser) || isBrowserTablet(browser))
	    click(Constant.WATCH_LINK_TECHNOLOGY_WEB);
	else
	    click(Constant.WATCH_LINK_TECHNOLOGY_MOBILE);
	technologyYoutubeVideoPresence();
    }
}
