package com.innit.testcase.web;

import org.testng.annotations.Test;

import com.innit.testcase.common.PartnersPage;

/**
 * 
 * @author Harsh Wardhan Gupta
 * 
 *         Class contains all the Innit 'Partners Page' tests.
 */
public class PartnersPageTest extends PartnersPage {

    /**
     * To validate the partners page innit logo functionality
     */
    @Test(priority = 12)
    private void partnersPageInnitIconValidationTest() {
	reportInfo("To validate the partners page innit logo functionality :: Test Started");
	partnersPageIconValidation();
	reportPass("To validate the partners page innit logo functionality :: Test Passed");
    }

    @Test(priority = 13)
    private void webUiElementsVisibilityTest() {
	reportInfo("To validate the partners page UI elements is present in the page :: Test Started");
	partnersPageElementsVisibilityCheck();
	reportPass("To validate the partners page innit logo functionality :: Test Passed");
    }

    @Test(priority = 14)
    private void webAppliancesPlayButtonFunctionalityTest() {
	reportInfo(
		"To validate the Video iframe is getting display after clicking on appliances Play button :: Test Started");
	appliancesPlayButtonFunctionality();
	reportPass(
		"To validate the Video iframe is getting display after clicking on appliances Play button :: Test Passed");
    }

    @Test(priority = 15)
    private void webAppliancesWatchLinkFunctionalityTest() {
	reportInfo(
		"To validate the Video iframe is getting display after clicking on appliances watch button :: Test Started");
	appliancesWatchLinkFunctionality();
	reportPass(
		"To validate the Video iframe is getting display after clicking on appliances watch button :: Test Passed");
    }

    @Test(priority = 16)
    private void webTechnologyPlayButtonFunctionalityTest() {
	reportInfo(
		"To validate the Video iframe is getting display after clicking on technology Play button :: Test Started");
	technologyPlayButtonFunctionality();
	reportPass(
		"To validate the Video iframe is getting display after clicking on technology Play button :: Test Passed");
    }

    @Test(priority = 17)
    private void webTechnologyWatchLinkFunctionalityTest() {
	reportInfo(
		"To validate the Video iframe is getting display after clicking on technology watch button :: Test Started");
	technologyWatchLinkFunctionality();
	reportPass(
		"To validate the Video iframe is getting display after clicking on technology watch button :: Test Passed");
    }
}
