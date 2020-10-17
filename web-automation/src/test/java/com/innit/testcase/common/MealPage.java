package com.innit.testcase.common;

import com.innit.testcase.BaseTest;
import com.innit.web.constant.Constant;

public class MealPage extends BaseTest {

    protected void verifyMealPageTitle() {
	navigate(Constant.MEAL_PAGE_URL);
	verifyTitle(Constant.MEAL_PAGE_TITLE);
    }

    protected void verifySuggestedMealLinks() {
	navigate(Constant.MEAL_PAGE_URL);
	validateMealTestCases(Constant.SNAP_PEA_LINK, Constant.SNAP_PEA_URL);
	validateMealTestCases(Constant.SEASONAL_SWEET_POTATOES_LINK, Constant.SEASONAL_SWEET_POTATOES_URL);
	validateMealTestCases(Constant.TAPENADE_CHICKEN_LINK, Constant.TAPENADE_CHICKEN_URL);
	validateMealTestCases(Constant.PALEAO_APPLE_LINK, Constant.PALEAO_APPLE_URL);
    }

    protected void validateSnapPeaMealLink() {
	navigate(Constant.MEAL_PAGE_URL);
	validateMealTestCases(Constant.SNAP_PEA_LINK, Constant.SNAP_PEA_URL);
    }

    protected void validateSeasonalSweetMealLink() {
	navigate(Constant.MEAL_PAGE_URL);
	validateMealTestCases(Constant.SEASONAL_SWEET_POTATOES_LINK, Constant.SEASONAL_SWEET_POTATOES_URL);
    }

    protected void validateTapendadeChickenMealLink() {
	navigate(Constant.MEAL_PAGE_URL);
	validateMealTestCases(Constant.TAPENADE_CHICKEN_LINK, Constant.TAPENADE_CHICKEN_URL);
    }

    protected void validateMarinadeChickenMealLink() {
	navigate(Constant.MEAL_PAGE_URL);
	validateMealTestCases(Constant.MARINADE_CHICKEN_LINK, Constant.MARINADE_CHICKEN_URL);
    }

    protected void validatePaleaoAppleMealLink() {
	navigate(Constant.MEAL_PAGE_URL);
	validateMealTestCases(Constant.PALEAO_APPLE_LINK, Constant.PALEAO_APPLE_URL);
    }

    private void validateMealTestCases(String locatorKey, String pageUrl) {
	String videoPanelXpath = "(//*[@class='video__image video__image--trigger'])[";
	if (isElementVisible(locatorKey) == true) {
	    click(locatorKey);
	    validateCurrentUrl(pageUrl);
	    boolean preprationSectionCheck = isElementVisible(Constant.PREPRATION_SECTION_XPATH);
	    if (preprationSectionCheck == true) {
		for (int linkIndex = 1; linkIndex <= getLinkCount(Constant.PREPRATION_VIDEO_XPATH); linkIndex++) {
		    scrollToPageElement(videoPanelXpath + linkIndex + "]");

		    click(videoPanelXpath + linkIndex + "]");
		    if (isElementVisible(Constant.STEP_VIDEO_GUIDES_MODAL) == true) {

			reportInfo("The Step By Step Video Guide is Displaying for video section :: " + linkIndex);
			scrollToPageElement(Constant.STEP_VIDEO_GUIDES_MODAL);
			takeScreenShot();
		    }
		}
	    }
	    gotoPriviouspage();
	} else {
	    click(Constant.SLICK_SLIDER_NEXT_BTN);
	    if (isElementVisible(locatorKey) == true)
		sleep(200);
	    validateMealTestCases(locatorKey, pageUrl);
	}
    }
}
