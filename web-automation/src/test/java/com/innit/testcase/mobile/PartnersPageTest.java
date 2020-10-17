package com.innit.testcase.mobile;

import org.testng.annotations.Test;

import com.innit.testcase.common.PartnersPage;

public class PartnersPageTest extends PartnersPage {

    @Test(priority = 12)
    private void partnersPageInnitMobileIconValidationTest() throws InterruptedException {
	reportInfo("Partners page logo click validation Test Started for :: " + getBrowser());
	partnersPageIconValidation();
	reportPass("Partners page logo click validation Test Passed for :: " + getBrowser());
    }

    @Test(priority = 13)
    private void mobileUiElementsVisibilityTest() {
	reportInfo(
		"To validate the partners page UI elements is present in the page Test Started for :: " + getBrowser());
	partnersPageElementsVisibilityCheck();
	reportPass(
		"To validate the partners page UI elemeny is present in teh page Test Passed for :: " + getBrowser());
    }

    @Test(priority = 16)
    private void mobileAppliancesPlayButtonFunctionalityTest() {
	reportInfo(
		"To validate the Video iframe is getting display after clicking on appliances Play button Test Started for :: "
			+ getBrowser());
	appliancesPlayButtonFunctionality();
	reportPass(
		"To validate the Video iframe is getting display after clicking on appliances Play button Test Passed for :: "
			+ getBrowser());
    }

    @Test(priority = 17)
    private void mobileAppliancesWatchLinkFunctionalityTest() {
	reportInfo(
		"To validate the Video iframe is getting display after clicking on appliances watch button Test Started for :: "
			+ getBrowser());
	appliancesWatchLinkFunctionality();
	reportPass(
		"To validate the Video iframe is getting display after clicking on appliances watch button Test Passed"
			+ getBrowser());
    }

    @Test(priority = 14)
    private void mobileTechnologyPlayButtonFunctionalityTest() {
	reportInfo(
		"To validate the Video iframe is getting display after clicking on technology Play button Test Started for :: "
			+ getBrowser());
	technologyPlayButtonFunctionality();
	reportPass(
		"To validate the Video iframe is getting display after clicking on technology Play button Test Passed for :: "
			+ getBrowser());
    }

    @Test(priority = 15)
    private void mobileTechnologyWatchLinkFunctionalityTest() {
	reportInfo(
		"To validate the Video iframe is getting display after clicking on technology watch button Test Started for :: "
			+ getBrowser());
	technologyWatchLinkFunctionality();
	reportPass(
		"To validate the Video iframe is getting display after clicking on technology watch button Test Passed for :: "
			+ getBrowser());
    }

}
