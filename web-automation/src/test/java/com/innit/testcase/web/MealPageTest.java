package com.innit.testcase.web;

import org.testng.annotations.Test;

import com.innit.testcase.common.MealPage;

public class MealPageTest extends MealPage {

    @Test(priority = 33)
    public void verifyMealPageTitleTest() {
	reportInfo("Innit Meal Page  :: " + getBrowser());
	verifyMealPageTitle();
	reportPass("Innit Home Page Title verified for :: " + getBrowser());
    }

    @Test(priority = 34)
    public void sanpPeaMealTest() {
	reportInfo("Test Started to Validate the 'Snap Pea & Radish Salad Meal' link inside SUGGESTED MEALS in :: "
		+ getBrowser());
	validateSnapPeaMealLink();
	reportPass("Test Passed to Validate the 'Snap Pea & Radish Salad Meal' link inside SUGGESTED MEALS in :: "
		+ getBrowser());
    }

    @Test(priority = 35)
    public void seasonalSweetMealTest() {
	reportInfo(
		"Test Started to Validate the 'Seasonal Sweet Meal' link inside SUGGESTED MEALS in :: " + getBrowser());
	validateSeasonalSweetMealLink();
	reportPass(
		"Test Passed to Validate the 'Seasonal Sweet Meal' link inside SUGGESTED MEALS in :: " + getBrowser());
    }

    @Test(priority = 36)
    public void tapanadeTofuMealTest() {
	reportInfo(
		"Test Started to Validate the 'Tapanade Tofu Meal' link inside SUGGESTED MEALS in :: " + getBrowser());
	validateTapendadeChickenMealLink();
	reportPass(
		"Test APssed to Validate the 'Tapanade Tofu Meal' link inside SUGGESTED MEALS in :: " + getBrowser());
    }

    @Test(enabled = false)
    public void turmericYogurtMealTest() {
	reportInfo("Test Started to Validate the 'Turmeric Yougart Meal' link inside SUGGESTED MEALS in :: "
		+ getBrowser());
	validateMarinadeChickenMealLink();
	reportPass("Test APssed to Validate the 'Turmeric Yougart Meal'  link inside SUGGESTED MEALS in :: "
		+ getBrowser());
    }

    @Test(priority = 37)
    public void paleoAppleMealTest() {
	reportInfo("Test Started to Validate the 'Paleo Apple Meal' link inside SUGGESTED MEALS in :: " + getBrowser());
	validatePaleaoAppleMealLink();
	reportPass("Test APssed to Validate the 'Paleo Apple Meal'  link inside SUGGESTED MEALS in :: " + getBrowser());
    }
}
