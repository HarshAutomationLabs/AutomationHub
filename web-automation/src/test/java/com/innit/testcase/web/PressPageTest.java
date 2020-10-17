package com.innit.testcase.web;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.innit.testcase.common.PressPage;
import com.innit.web.constant.Constant;
import com.innit.web.util.Utility;

/**
 * @author Harsh Wardhan Gupta
 * 
 *         Class contains all the Innit Press page tests.
 */
public class PressPageTest extends PressPage {

    /**
     * TO Validate the click of 'Press Coverage' Side Menu and Verifying the View
     * Port visibility
     */

    @Test(priority = 25)
    private void pressCoverageViewPortFunctionlaityTest() {
	reportInfo(
		"TO Validate the click of 'Press Coverage' Side Menu and Verifying the View Port visibility :: Test Started");
	navigate(Constant.PRESS_PAGE_URL);
	click(Constant.PRESS_COVERAGE_LINK);
	assertElementIsInViewPort(Constant.PRESS_COVERAGE_HEADER_TEXT_XPATH);
	reportPass(
		"TO Validate the click of 'Press Coverage' Side Menu and Verifying the View Port visibility :: Test Pass");
    }

    /**
     * TO Validate the Redirection of 'Article Archive' Link redirection
     */

    @Test(priority = 26)
    private void articleArchivesLinkValidationTest() {
	reportInfo("TO Validate the Redirection of 'Article Archive' Link redirection:: Test Started");
	navigate(Constant.PRESS_PAGE_URL);
	validateLink(Constant.ARTICLE_ARCHIVES_BUTTON, Constant.ARTICLE_ARCHIVES_LINK_URL);
	reportPass("TO Validate the Redirection of 'Article Archive' Link redirection:: Test Pass");
    }

    /**
     * TO Validate the click of 'Press Release' Side Menu and Verifying the View
     * Port visibility
     */

    @Test(priority = 27)
    private void pressReleaseViewPorFunctionalityTest() {
	reportInfo(
		"TO Validate the click of 'Press Release' Side Menu and Verifying the View Port visibility :: Test Started");
	navigate(Constant.PRESS_PAGE_URL);
	click(Constant.PRESS_RELEASE_LINK);
	assertElementIsInViewPort(Constant.PRESS_RELEASES_HEADER_TEXT_XPATH);
	reportPass(
		"TO Validate the click of 'Press Coverage' Side Menu and Verifying the View Port visibility :: Test Pass");
    }

    /**
     * To validate the 'More Press Release' link validation.
     */

    @Test(priority = 28)
    private void morePressReleaseLinkValidationTest() {
	reportInfo("TO Validate the Redirection of 'More Press Release' Link redirection:: Test Started");
	navigate(Constant.PRESS_PAGE_URL);
	validateLink(Constant.MORE_PRESS_RELEASES_BUTTON, Constant.MORE_PRESS_RELEASES_LINK_URL);
	reportPass("TO Validate the Redirection of 'More Press Release' Link redirection:: Test Pass");
    }

    /**
     * TO Validate the click of 'Brand Assets' Side Menu and Verifying the View Port
     * visibility
     */

    @Test(priority = 29)
    private void brandAssetsViewportFunctionalityTest() {
	reportInfo(
		"TO Validate the click of 'Brand Assets' Side Menu and Verifying the View Port visibility :: Test Started");
	navigate(Constant.PRESS_PAGE_URL);
	click(Constant.BRAND_ASSETS_LINK);
	assertElementIsInViewPort(Constant.BRAND_ASSETS_HEADER_TEXT_XPATH);
	reportPass(
		"TO Validate the click of 'Brand Assets' Side Menu and Verifying the View Port visibility :: Test Pass");
    }

    /**
     * To Validate the 'Download Button' functionality
     */

    @Test(priority = 30)
    private void downloadButtonFunctionalityTest() {
	reportInfo("To Validate the 'Download Button' functunality:: Test Started");
	navigate(Constant.PRESS_PAGE_URL);
	downloadBrandAssetsFile(readPropery(Constant.SYSTEM_DOWNLOAD_DIRECTORY));
	reportPass("To Validate the the 'Download Button' functunality:: Test Pass");
    }

    /**
     * To Validate the 'Innit' icon click redirection check
     */

    @Test(priority = 31)
    private void pressPageInnitLogoValidationTest() {
	reportInfo("To Validate the 'Innit' icon click redirection check :: Test Started");
	navigate(Constant.PRESS_PAGE_URL);
	click(Constant.INNIT_LOGO_XPATH);
	reportPass("To Validate the 'Innit' icon click redirection check :: Test Pass");
    }

    /**
     * To validate the 'Articles' page links redirection.
     */
    @Parameters({ "browser" })
    @Test(priority = 32)
    private void allArtcilesLinkValidationtest() {
	reportInfo("To Validate the 'Articles' of Press page redirection :: Test Started");
	navigate(Constant.PRESS_PAGE_URL);
	click(Constant.ARTICLE_ARCHIVES_BUTTON);
	articlesLinksubfunction();
	reportPass("To Validate the 'Articles' of Press page redirection :: Test Pass");
    }

    /********** Download 'innit-brand-assets.zip' file function ************/

    /**
     * Sub function to download the brand Assets file.
     * 
     * @param downloadDir:
     *            download directory path defines in config.
     */
    private void downloadBrandAssetsFile(String downloadDir) {
	Utility.deleteAllFiles(System.getenv().get("USERPROFILE") + downloadDir);
	click(Constant.DOWNLOAD_BUTTON_BRAND_ASSETS_XPATH);
	assertFileDownload(System.getenv().get("USERPROFILE") + downloadDir, "innit-brand-assets.zip");
    }
}
