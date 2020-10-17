package com.innit.testcase.mobile;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.innit.web.constant.Constant;
import com.innit.web.helper.Platform;
import com.innit.web.util.Utility;

public class PressPageTest extends com.innit.testcase.common.PressPage {

    @Parameters({ "browser" })
    @Test(priority = 25)
    private void checkArticleArchivesLink(String browser) {
	reportInfo("TO Validate the Redirection of 'Article Archive' Link redirection:: Test Started");
	navigate(Constant.PRESS_PAGE_URL);
	if (((browser.toUpperCase()).equalsIgnoreCase(Platform.IPAD.toString().toUpperCase()))) {
	    validateLink(Constant.ARTICLE_ARCHIVES_BUTTON, Constant.ARTICLE_ARCHIVES_LINK_URL);
	} else {
	    validateLink(Constant.ARTICLE_ARCHIVES_BUTTON_MOBILE, Constant.ARTICLE_ARCHIVES_LINK_URL);
	}
	reportPass("TO Validate the Redirection of 'Article Archive' Link redirection:: Test Pass");
    }

    @Parameters({ "browser" })
    @Test(priority = 26)
    private void checkMorePressReleaseLink(String browser) {
	reportInfo("TO Validate the Redirection of 'More Press Release' Link redirection:: Test Started");
	navigate(Constant.PRESS_PAGE_URL);
	if (((browser.toUpperCase()).equalsIgnoreCase(Platform.IPAD.toString().toUpperCase()))) {
	    validateLink(Constant.MORE_PRESS_RELEASES_BUTTON, Constant.MORE_PRESS_RELEASES_LINK_URL);
	} else {
	    validateLink(Constant.MORE_PRESS_RELEASES_BUTTON_MOBILE, Constant.MORE_PRESS_RELEASES_LINK_URL);
	}
	reportPass("TO Validate the Redirection of 'More Press Release' Link redirection:: Test Pass");
    }

    @Parameters({ "browser" })
    @Test(priority = 27)
    private void checkDownloadButtonFunctionality(String browser) throws IOException {
	reportInfo("To Validate the 'Download Button'functunality:: Test Started");
	navigate(Constant.PRESS_PAGE_URL);
	downloadBrandAssetsFile(browser, readPropery(Constant.SYSTEM_DOWNLOAD_DIRECTORY));
	reportPass("To Validate the the 'Download Button'functunality:: Test Pass");
    }

    @Test(priority = 28)
    private void checkInnitIconClick() {
	reportInfo("To Validate the 'Innit' icon click redirection check :: Test Started");
	navigate(Constant.PRESS_PAGE_URL);
	click(Constant.INNIT_LOGO_XPATH);
	reportPass("To Validate the 'Innit' icon click redirection check :: Test Pass");
    }

    @Parameters({ "browser" })
    @Test(priority = 29)
    private void validateArticlesLinks(String browser) {
	reportInfo("To Validate the 'Articles' of Press page redirection :: Test Started for " + browser);
	navigate(Constant.PRESS_PAGE_URL);
	if (((browser.toUpperCase()).equalsIgnoreCase(Platform.IPAD.toString().toUpperCase()))) {
	    click(Constant.ARTICLE_ARCHIVES_BUTTON);
	} else {
	    click(Constant.ARTICLE_ARCHIVES_BUTTON_MOBILE);
	}
	articlesLinksubfunction();
	reportPass("To Validate the 'Articles' of Press page redirection :: Test Pass for " + browser);
    }

    /*********** Download 'innit-brand-assets.zip' file function ************/

    private void downloadBrandAssetsFile(String browser, String downloadDir) {
	Utility.deleteAllFiles(System.getenv().get("USERPROFILE") + downloadDir);
	if (((browser.toUpperCase()).equalsIgnoreCase(Platform.IPAD.toString().toUpperCase()))) {
	    click(Constant.DOWNLOAD_BUTTON_BRAND_ASSETS_XPATH);
	} else {
	    click(Constant.DOWLOAD_BUTTON_BRAND_ASSET_MOBILE_XPATH);
	}
	assertFileDownload(System.getenv().get("USERPROFILE") + downloadDir, "innit-brand-assets.zip");
    }
}
