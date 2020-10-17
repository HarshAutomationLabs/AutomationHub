package com.innit.testcase.common;

import com.innit.testcase.BaseTest;
import com.innit.web.constant.Constant;
import com.innit.web.util.Utility;

public class PressPage extends BaseTest {
    
    protected void downloadButtonSteps(String downloadDir) {
	Utility.deleteAllFiles(System.getenv().get("USERPROFILE") + downloadDir);
	String browser = getBrowser();
	if (isBrowserDesktop(browser) || isBrowserTablet(browser))
	    click(Constant.DOWNLOAD_BUTTON_BRAND_ASSETS_XPATH);
	else
	    click(Constant.DOWLOAD_BUTTON_BRAND_ASSET_MOBILE_XPATH);
	assertFileDownload(System.getenv().get("USERPROFILE") + downloadDir, Constant.INNIT_DONWLOAD_ZIP_FILE_NAME);
    }
	
    protected void articlesLinksubfunction() {
	validateArticleGoToPresspage(Constant.BARRONS_RETAIL_ROUND_UP_XPATH, Constant.BARRONS_RETAIL_ROUND_UP_URL);
	validateArticleGoToPresspage(Constant.TODAY_AMERICAS_FAVORITE_FOOD_XPATH,
		Constant.TODAY_AMERICAS_FAVORITE_FOOD_URL);
	validateArticleGoToPresspage(Constant.DETROITNEWS_HOME_GARDEN_XPATH, Constant.DETROITNEWS_HOME_GARDEN_URL);
	validateArticleGoToPresspage(Constant.WRGZ_DAYBREAK_AMERICAS_FAVORITE_CHEESE_XPATH,
		Constant.WRGZ_DAYBREAK_AMERICAS_FAVORITE_CHEESE_URL);
	validateArticleGoToPresspage(Constant.THESPOON_TECH_XPATH, Constant.THE_SPOON_TECH_URL);
	validateArticleGoToPresspage(Constant.CBS_CHINCINNATI_XPATH, Constant.CBS_CHINCINNATI_URL);
	validateArticleGoToPresspage(Constant.MNS_LIFESTYLE_XPATH, Constant.MNS_LIFESTYLE_URL);
	validateArticleGoToPresspage(Constant.TO5_MAC_XPATH, Constant.TO5_MAC_URL);
	validateArticleGoToPresspage(Constant.DT_ELECTROLUX_XPATH, Constant.DT_ELECTROLUX_URL);
	validateArticleGoToPresspage(Constant.DT_CHEFD_MERGE_XPATH, Constant.DT_CHEFD_MERGE_URL);
	validateArticleGoToPresspage(Constant.FOOD_DIVE_XPATH, Constant.FOOD_DIVE_URL);
	validateArticleGoToPresspage(Constant.PROGRESSIVE_GROCER_XPATH, Constant.PROGRESSIVE_GROCER_URL);
	validateArticleGoToPresspage(Constant.JUST_A_TASTE_XPATH, Constant.JUST_A_TASTE_URL);
	validateArticleGoToPresspage(Constant.LUXURY_TOOL_XPATH, Constant.LUXURY_TOOL_URL);
	validateArticleGoToPresspage(Constant.ORGANIC_AUTORITY_XPATH, Constant.ORGANIC_AUTORITY_URL);
	validateArticleGoToPresspage(Constant.PHOENIX_BITES_XPATH, Constant.PHOENIX_BITES_URL);
	validateArticleGoToPresspage(Constant.ANDROID_HEADLINES_XPATH, Constant.ANDROID_HEADLINES_URL);
	validateArticleGoToPresspage(Constant.TOMS_GUIDE_XPATH, Constant.TOMS_GUIDE_URL);
	validateArticleGoToPresspage(Constant.CNET_XPATH, Constant.CNET_URL);
	validateArticleGoToPresspage(Constant.CHEDDAR_TY_XPATH, Constant.CHEDDAR_TY_URL);
	validateArticleGoToPresspage(Constant.ABC_BAY_AREA_XPATH, Constant.ABC_BAY_AREA_URL);
	validateArticleGoToPresspage(Constant.CBS_BINGHMTON_XPATH, Constant.CBS_BINGHMTON_URL);
	validateArticleGoToPresspage(Constant.TASTING_TABLE_XPATH, Constant.TASTING_TABLE_URL);
	validateArticleGoToPresspage(Constant.WASHINGTON_POST_XPATH, Constant.WASHINGTON_POST_URL);
	validateArticleGoToPresspage(Constant.WGN_CHICAGO_XPATH, Constant.WGN_CHICAGO_URL);
	validateArticleGoToPresspage(Constant.THE_SPOON_XPATH, Constant.THE_SPOON_URL);
	validateArticleGoToPresspage(Constant.DT_APPS_COCINA_XPATH, Constant.DT_APPS_COCINA_URL);
	validateArticleGoToPresspage(Constant.DT_INNIT_PAIRS_TF_XPATH, Constant.DT_INNIT_PAIRS_TF_URL);
	validateArticleGoToPresspage(Constant.NY_TIMES_XPATH, Constant.NY_TIMES_URL);
	validateArticleGoToPresspage(Constant.SPECIALTYFOOD_XPATH, Constant.SPECIALTYFOOD_URL);
	validateArticleGoToPresspage(Constant.THE_KITCHEN_XPATH, Constant.THE_KITCHEN_URL);
	validateArticleGoToPresspage(Constant.FOODANDWINE_XPATH, Constant.FOODANDWINE_URL);
	validateArticleGoToPresspage(Constant.FORBES_XPATH, Constant.FORBES_URL);
	validateArticleGoToPresspage(Constant.FOODBUSINESSNEWS_XPATH, Constant.FOODBUSINESSNEWS_URL);
	validateArticleGoToPresspage(Constant.WIRED_XPATH, Constant.WIRED_URL);
    }

    protected void validateArticleGoToPresspage(String locator, String url) {
	validateLink(locator, url);
	navigate(Constant.ARTICLE_ARCHIVES_LINK_URL);
    }
}
