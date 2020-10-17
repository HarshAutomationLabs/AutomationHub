package com.innit.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.AssertJUnit;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import com.google.common.io.Files;
import com.innit.web.constant.Constant;
import com.innit.web.helper.Platform;
import com.innit.web.util.ExtentManager;
import com.innit.web.util.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author Harsh Wardhan Gupta
 * 
 *         Class contains all the Base Functions of Innit Web and Mobile
 *         Automation.
 */
public abstract class BaseTest {
	private WebDriver driver;
	private Properties prop = Utility.getProperties("config.properties");
	private ExtentReports testReport = ExtentManager.getInstance();
	private ExtentTest test;
	private String browser;
	private FluentWait<WebDriver> wait;

	SoftAssert softAssert;
	protected String userEmail = Utility.generateRandomEmailId();

	protected String getBrowser() {
		return browser;
	}

	private void setBrowser(String browser) {
		this.browser = browser;
	}

	/*********************** TestNg calls ****************************/

	@BeforeSuite
	protected void deleteFiles() {
		Utility.deleteAllFiles(System.getProperty("user.dir") + "//screenshots//");
	}

	@Parameters({ "browser" })
	@BeforeClass
	protected void startBrowser(String browser) {
		initReport("Crossbrowser test Started for :: " + browser);
		openBrowser(Platform.getPlatformByName(browser));
		reportInfo(browser + " :: Opened");
		setBrowser(browser);
	}

	@BeforeMethod
	protected void init() {
		softAssert = new SoftAssert();
		AssertJUnit.assertTrue(true);
		wait = new FluentWait<WebDriver>(driver);
	}

	@AfterClass(alwaysRun = true)
	protected void close() {
		endReport();
		tearDown();
	}

	@AfterMethod
	protected void quit() {
		try {
			softAssert.assertAll();
		} catch (Error e) {
			test.log(LogStatus.FAIL, e.getMessage());
		}
	}

	@AfterSuite
	protected void closeDriver() {
		if (driver != null)
			driver.quit();
	}

	/*********************** Base Functions ****************************/

	@SuppressWarnings("deprecation")
	private void openBrowser(Platform bType) {
		switch (bType) {
		case CHROME:
			try {
				driver = new ChromeDriver(setChromeCapabilities());
				setBrowserSize(null);
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Chrome Driver not found at Drivers directory!"
						+ "\n Download the driver file from :: " + Constant.DRIVER_DOWNLOAD_URL
						+ "\n Note: Please check the Chrome version and OS details before download");
			}
			break;

		case MOZILLA:
			try {
				String mozillaPath = prop.getProperty(Constant.FIREFOX_WEB_DRIVER_PATH);
				System.setProperty(Constant.FIREFOX_WEB_DRIVER, mozillaPath);
				DesiredCapabilities caps = DesiredCapabilities.firefox();
				FirefoxProfile firefoxProfile = new FirefoxProfile();
				firefoxProfile.setPreference("browser.download.folderList", 2);
				firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
				firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");
				caps.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
				driver = new FirefoxDriver(caps);
				setBrowserSize(null);
			} catch (Exception e) {
				System.out.println("Chrome Driver not found at Drivers directory!"
						+ "\n Download the driver file from :: " + Constant.DRIVER_DOWNLOAD_URL
						+ "\n Note: Please check the Mozilla Firefox version and OS details before download");
			}
			break;

		case EDGE:
			try {
				String edgePath = prop.getProperty(Constant.EDGE_WEB_DRIVER_PATH);
				System.setProperty(Constant.EDGE_WEB_DRIVER, edgePath);
				driver = new EdgeDriver();
				setBrowserSize(null);
			} catch (Exception e) {
				System.out.println("Microsoft Driver not found at Drivers directory!"
						+ "\n Download the driver file from :: " + Constant.DRIVER_DOWNLOAD_URL
						+ "\n Note: Please check the Mozilla Firefox version and OS details before download");
			}
			break;

		case IPAD:
			try {

				driver = new ChromeDriver(setChromeCapabilities());
				Dimension d = new Dimension(1024, 1366);
				setBrowserSize(d);
			} catch (Exception e) {
				System.out.println("Chrome Driver not found at Drivers directory!"
						+ "\n Download the driver file from :: " + Constant.DRIVER_DOWNLOAD_URL
						+ "\n Note: Please check the Chrome version and OS details before download");
			}
			break;

		case IPHONE5:
			try {

				driver = new ChromeDriver(setChromeCapabilities());
				Dimension d = new Dimension(320, 568);
				setBrowserSize(d);
			} catch (Exception e) {
				System.out.println("Chrome Driver not found at Drivers directory!"
						+ "\n Download the driver file from :: " + Constant.DRIVER_DOWNLOAD_URL
						+ "\n Note: Please check the Chrome version and OS details before download");
			}
			break;

		case IPHONE6:
			try {
				driver = new ChromeDriver(setChromeCapabilities());
				Dimension d = new Dimension(375, 667);
				setBrowserSize(d);
			} catch (Exception e) {
				System.out.println("Chrome Driver not found at Drivers directory!"
						+ "\n Download the driver file from :: " + Constant.DRIVER_DOWNLOAD_URL
						+ "\n Note: Please check the Chrome version and OS details before download");
			}
			break;

		case IPHONE6PLUS:
			try {
				driver = new ChromeDriver(setChromeCapabilities());
				Dimension d = new Dimension(414, 736);
				setBrowserSize(d);
			} catch (Exception e) {
				System.out.println("Chrome Driver not found at Drivers directory!"
						+ "\n Download the driver file from :: " + Constant.DRIVER_DOWNLOAD_URL
						+ "\n Note: Please check the Chrome version and OS details before download");
			}
			break;

		case IPHONE7:
			try {
				driver = new ChromeDriver(setChromeCapabilities());
				Dimension d = new Dimension(375, 667);
				setBrowserSize(d);
			} catch (Exception e) {
				System.out.println("Chrome Driver not found at Drivers directory!"
						+ "\n Download the driver file from :: " + Constant.DRIVER_DOWNLOAD_URL
						+ "\n Note: Please check the Chrome version and OS details before download");
			}
			break;

		case GALAXYNOTE3:
			try {
				String chromePath = prop.getProperty(Constant.CHROME_WEB_DRIVER_PATH);
				System.setProperty(Constant.CHROME_WEB_DRIVER, chromePath);
				driver = new ChromeDriver();
				Dimension d = new Dimension(411, 823);
				setBrowserSize(d);
			} catch (Exception e) {
				System.out.println("Chrome Driver not found at Drivers directory!"
						+ "\n Download the driver file from :: " + Constant.DRIVER_DOWNLOAD_URL
						+ "\n Note: Please check the Chrome version and OS details before download");
			}
			break;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	private DesiredCapabilities setChromeCapabilities() {
		String chromePath = prop.getProperty(Constant.CHROME_WEB_DRIVER_PATH);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("disable-infobars");
		options.addArguments("--no-sandbox");
		options.addArguments("start-maximized");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-browser-side-navigation");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		System.setProperty("webdriver.chrome.driver", chromePath);
		return capabilities;

	}

	@SuppressWarnings("unused")
	private void mobileEmulation(String deviceName) {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", deviceName);
		String chromePath = prop.getProperty(Constant.CHROME_WEB_DRIVER_PATH);
		System.setProperty(Constant.CHROME_WEB_DRIVER, chromePath);

		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("mobileEmulation", mobileEmulation);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
	}

	private void setBrowserSize(Dimension d) {
		if (d == null) {
			driver.manage().window().maximize();
		} else
			driver.manage().window().setSize(d);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='40%';");
	}

	protected boolean isBrowserMobile(String browserName) {

		ArrayList<String> mobile = new ArrayList<String>();
		mobile.add(Platform.IPHONE5.toString().toUpperCase());
		mobile.add(Platform.IPHONE6.toString().toUpperCase());
		mobile.add(Platform.IPHONE6PLUS.toString().toUpperCase());
		mobile.add(Platform.IPHONE7.toString().toUpperCase());

		if (mobile.contains(browserName.toUpperCase())) {
			return true;
		} else
			return false;
	}

	protected boolean isBrowserTablet(String browserName) {
		ArrayList<String> tablet = new ArrayList<String>();
		tablet.add(Platform.IPAD.toString().toUpperCase());
		if (tablet.contains(browserName.toUpperCase())) {
			return true;
		} else
			return false;
	}

	protected boolean isBrowserDesktop(String browserName) {
		ArrayList<String> desktop = new ArrayList<String>();
		desktop.add(Platform.CHROME.toString().toUpperCase());
		desktop.add(Platform.EDGE.toString().toUpperCase());
		desktop.add(Platform.MOZILLA.toString().toUpperCase());
		if (desktop.contains(browserName.toUpperCase())) {
			return true;
		} else
			return false;
	}

	protected void navigate(String url) {
		driver.navigate().to(readPropery(url));
		driver.manage().deleteAllCookies();
		waitForPageToLoad();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
		test.log(LogStatus.INFO, url);
	}

	@AfterMethod
	private void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}

	/*********************** Java Generic Functions ****************************/

	protected String readPropery(String key) {
		String value = prop.getProperty(key);
		return value;
	}

	/*********************** Selenium Functions ****************************/

	/**
	 * To Perform click action on an web element.
	 * 
	 * @param locatorKey
	 * @throws InterruptedException
	 */
	protected void click(String locatorKey) {
		waitUntilElementPresent(locatorKey);
		isElementPresent(locatorKey);
		boolean b = isClickable(locatorKey);
		if (b) {
			WebElement e = getElement(locatorKey);
			e.click();
			reportInfo("Clicked on :: " + locatorKey);
		}
	}

	/**
	 * To verify the current page url.
	 * 
	 * @param url: matching url.
	 * @return
	 * 
	 */
	protected void validateCurrentUrl(String url) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			reportInfo(e.getMessage());
		}
		String pageUrl = driver.getCurrentUrl();
		if (pageUrl.equals("about:blank")) {
			reportFailure("Current URL returned blank page");
			return;
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			reportInfo(e.getMessage());
		}
		try {
			takeScreenShot();
			if (pageUrl.equalsIgnoreCase(prop.getProperty(url)))
				AssertJUnit.assertEquals(pageUrl, prop.getProperty(url));
			else
				AssertJUnit.assertTrue(pageUrl.contains(prop.getProperty(url)));
		} catch (Throwable t) {
			reportFailure("Url Check For :: " + pageUrl + " Failed !" + '\n' + t);
		}
	}

	/**
	 * To Validate the Content in the Innit Google Maps page
	 * 
	 * @param urlString: Initial string of Innit Google maps address.
	 * 
	 */
	protected void validateGoogleMapsURLContent(String urlString) {
		String pageUrl = driver.getCurrentUrl();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			reportInfo(e.getMessage());
		}
		if (pageUrl.contains(prop.getProperty(urlString))) {
			AssertJUnit.assertEquals(driver.getTitle(), "Innit - Google Maps");
			reportInfo("Innit 'Google Maps' Page title verified");
		} else
			reportFailure("Google Maps link validation failed");
	}

	/**
	 * To Perform Hover action an element in a webpage
	 * 
	 * @param locatorKey: Locator of the web element
	 */
	protected void hoverOnElement(String elementXpath) {
		WebElement e = driver.findElement(By.xpath(elementXpath));
		Actions action = new Actions(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
		action.moveToElement(e).build().perform();
	}

	protected void scrollToPageElement(String locatorKey) {
		WebElement e = getElement(locatorKey);
		waitUntilElementPresent(locatorKey);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
	}

	protected String getTeamMemberName(int index) {
		String team_cards_xpath = "//*[@id='executive']/div[3]/div[";
		String team_overlay_text_xpath = "(//*[@class='headshotname'])[";
		hoverOnElement(team_cards_xpath + (index - 1) + "]");
		WebElement e = driver.findElement(By.xpath(team_overlay_text_xpath + index + "]"));
		String memberName = e.getText();
		return memberName;
	}

	/**
	 * To Type a string in the input field
	 * 
	 * @param locatorKey: Locator of the text field.
	 * @param data:       String data to input.
	 */
	protected void type(String locatorKey, String data) {
		WebElement we = getElement(locatorKey);
		we.clear();
		if (prop.getProperty(data) == null)
			we.sendKeys(data);
		else
			we.sendKeys(prop.getProperty(data));
	}

	/**
	 * Function matches the web element String locator and returns the selenium web
	 * element object.
	 * 
	 * @param locatorKey: Locator name in string of the web element.
	 * @return: Returns the Selenium web element type object.
	 */
	private WebElement getElement(String locatorKey) {
		WebElement e = null;
		try {
			if (locatorKey.endsWith("_id"))
				e = driver.findElement(By.id(prop.getProperty(locatorKey)));
			else if (locatorKey.endsWith("_name"))
				e = driver.findElement(By.name(prop.getProperty(locatorKey)));
			else if (locatorKey.contains("_xpath"))
				e = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
			else {
				reportFailure("Locator not correct - " + locatorKey);
				AssertJUnit.fail("Locator not correct - " + locatorKey);
			}
		} catch (Exception ex) {
			reportFailure(ex.getMessage());
			ex.printStackTrace();
			AssertJUnit.fail("Failed the test - " + ex.getMessage());
		} finally {
			System.out.println("Return value :: " + e);
		}
		return e;
	}

	/**
	 * Function handle the drop down list options.
	 * 
	 * @param drpdwnlocatorkey:    locator key of the Dropdown.
	 * @param listValueLocatorkey: locator key of the list option to be selected.
	 */
	protected void selectDropdownOption(String drpdwnlocatorkey, String listValueLocatorkey) {
		click(drpdwnlocatorkey);
		isElementVisible(listValueLocatorkey);
		click(listValueLocatorkey);
	}

	/*********************** Validations ****************************/

	/**
	 * To validate the URL of the link on a Webpage.
	 * 
	 * @param locatorKey: Locator key of the link element.
	 * @param pageUrl:    URL of the page where link should get redirected.
	 */
	protected void validateLink(String locatorKey, String pageUrl) {
		driver.manage().deleteAllCookies();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Boolean b = isElementPresent(locatorKey);
		if (b) {
			click(locatorKey);
			test.log(LogStatus.PASS, locatorKey);
			waitForPageToLoad();
		} else {
			reportFailure(locatorKey + " Is not present in the Url");
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			reportInfo(e.getMessage());
		}
		validateCurrentUrl(pageUrl);
	}

	protected void validateMobileTestLink(String locatorKey, String siteURL) {
		navigate(Constant.INNIT_HOME_URL);
		waitUntilElementPresent(Constant.HAMBURGER_ICON_LINK);
		click(Constant.HAMBURGER_ICON_LINK);
		validateLink(locatorKey, siteURL);
	}

	protected void validateCarouselTestLink(String locatorKey, String pageUrl) {
		waitUntilElementPresent(locatorKey);
		Boolean b = isElementPresent(locatorKey);
		if (b) {
			click(locatorKey);
			waitForPageToLoad();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("scroll(0, 250);");
			waitUntilElementPresent(Constant.PRESS_RELEASE_LINK);
			click(Constant.PRESS_RELEASE_LINK);
			waitUntilElementPresent(Constant.BRAND_ASSETS_LINK);
			click(Constant.BRAND_ASSETS_LINK);
			waitUntilElementPresent(Constant.PRESS_COVERAGE_LINK);
			click(Constant.PRESS_COVERAGE_LINK);
		} else {
			reportFailure(locatorKey + " Is not present in the Url :: ");
		}
		String currentUrl = driver.getCurrentUrl();
		try {
			takeScreenShot();
			AssertJUnit.assertEquals(currentUrl, prop.getProperty(pageUrl));
		} catch (Throwable t) {
			reportFailure("Url Check For :: " + pageUrl + " Failed !" + '\n' + t);
		}
	}

	@SuppressWarnings("unused")
	private void validateTeamProfileTestLink(String locatorKey, String pageUrl) {
		Boolean b = isElementPresent(locatorKey);
		if (b) {
			click(locatorKey);
			test.log(LogStatus.PASS, locatorKey);
		} else {
			reportFailure(locatorKey + " Is not present in the Url :: " + Constant.ABOUT_US_PAGE_URL);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			reportInfo(e.getMessage());
		}
		String currentUrl = driver.getCurrentUrl();
		try {
			takeScreenShot();
			AssertJUnit.assertEquals(currentUrl, prop.getProperty(pageUrl));
		} catch (Throwable t) {
			reportFailure("Url Check For :: " + pageUrl + " Failed !" + '\n' + t);
		}
		navigate(Constant.ABOUT_US_PAGE_URL);
	}

	protected void verifyTitle(String titleText, String pageUrl) {
		driver.get(prop.getProperty(pageUrl));
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(prop.getProperty(titleText))) {
			reportPass("Page Title Verified on :: " + pageUrl);
		} else {
			reportFailure("Expected page Title :: " + titleText + " found Incorrect on :: " + pageUrl);
		}
	}

	protected boolean isElementPresent(String locatorKey) {
		waitForPageToLoad();
		List<WebElement> elementList = null;
		if (locatorKey.endsWith("_id"))
			elementList = this.driver.findElements(By.id(prop.getProperty(locatorKey)));
		else if (locatorKey.endsWith("_name"))
			elementList = this.driver.findElements(By.name(prop.getProperty(locatorKey)));
		else if (locatorKey.endsWith("_xpath"))
			elementList = this.driver.findElements(By.xpath(prop.getProperty(locatorKey)));
		else {
			reportFailure("Locator not correct - " + locatorKey);
			AssertJUnit.fail("Locator not correct - " + locatorKey);
		}
		if (elementList.size() == 0) {
			AssertJUnit.fail("Element " + locatorKey + " not visible in the page");
			return false;
		} else
			test.log(LogStatus.PASS, locatorKey + " is present in the page");
		takeScreenShot();
		return true;
	}

	protected boolean isElementVisible(String locatorKey) {
		boolean element = false;
		if (locatorKey.endsWith("_id"))
			element = driver.findElement(By.id(prop.getProperty(locatorKey))).isDisplayed();
		else if (locatorKey.endsWith("_name"))
			element = driver.findElement(By.name(prop.getProperty(locatorKey))).isDisplayed();
		else if (locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(prop.getProperty(locatorKey))).isDisplayed();
		} else {
			reportFailure("Locator not correct - " + locatorKey);
			AssertJUnit.fail("Locator not correct - " + locatorKey);
		}
		return element;
	}

	private boolean verifyText(String locatorKey, String expectedTextKey) {
		String actualText = getElementText(locatorKey).trim();
		String expectedText = (expectedTextKey);
		if (actualText.equals(expectedText))
			return true;
		else
			return false;
	}

	protected String getElementText(String locatorKey) {
		return getElement(locatorKey).getText();
	}

	protected void assertElementIsInViewPort(String locatorKey) {
		takeScreenShot();
		AssertJUnit.assertTrue(isVisibleInViewport(locatorKey),
				"Failed to get the Expected Element in Current view Port of Browser");
		test.log(LogStatus.PASS, locatorKey + " is visible in browser viewport !");
	}

	protected void assertElementIsNotInViewPort(String locatorKey) {
		takeScreenShot();
		AssertJUnit.assertFalse(isVisibleInViewport(locatorKey),
				"Expected Element is present in the Current view Port of Browser");
		test.log(LogStatus.PASS, locatorKey + " is not visible in browser viewport !");
	}

	private boolean isVisibleInViewport(String locatorKey) {
		WebElement element = getElement(locatorKey);
		driver = ((RemoteWebElement) element).getWrappedDriver();

		return (Boolean) ((JavascriptExecutor) driver).executeScript(
				"var elem = arguments[0],                 " + "  box = elem.getBoundingClientRect(),    "
						+ "  cx = box.left + box.width / 2,         " + "  cy = box.top + box.height / 2,         "
						+ "  e = document.elementFromPoint(cx, cy); " + "for (; e; e = e.parentElement) {         "
						+ "  if (e === elem)                        " + "    return true;                         "
						+ "}                                        " + "return false;                            ",
				element);
	}

	protected void isElementEnabled(String locatorKey) {
		AssertJUnit.assertTrue(assertElementState(locatorKey), " :: Element is Enabled in the page! ");
	}

	private boolean assertElementState(String locatorKey) {
		WebElement element = getElement(locatorKey);
		return element.isEnabled();
	}

	protected void isElementDisabled(String locatorKey) {
		AssertJUnit.assertFalse(assertElementState(locatorKey), " :: Element is Disabled in the page! ");
	}

	private boolean isClickable(String locatorKey) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 6);
			WebElement el = getElement(locatorKey);
			wait.until(ExpectedConditions.elementToBeClickable(el));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/******************** Download file functions ********************/

	protected void performSaveFileAction() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			System.out.println("Enter key press has not performed");
		}
	}

	protected void assertFileDownload(String dirName, String fileName) {
		String fileName1 = null;
		while (true) {
			File getLatestFile = getLatestFilefromDir(dirName);
			fileName1 = getLatestFile.getName();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (fileName1.equals(fileName))
				break;
		}
		AssertJUnit.assertTrue(fileName1.equals(fileName),
				"Downloaded file name is not matching with expected file name");
	}

	private File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}
		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	/*********************** Switch tab & window ****************************/

	protected void switchTabByIndex(int tabIndex) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			reportInfo(e.getMessage());
		}
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabIndex));
		reportInfo("Switch to tab number :: " + tabIndex);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			reportInfo(e.getMessage());
		}
	}

	protected void closeTabByIndex(int index) {
		waitForPageToLoad();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(index));
		driver.close();
	}

	protected void closeAllTabs() {
		String originalHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		driver.switchTo().window(originalHandle);
	}

	protected void gotoPriviouspage() {
		driver.navigate().back();
	}

	/*********************** Test functions ****************************/

	protected void validateSubscribedEmail(String email, String locatorKey) {
		String registeredUserMessage = prop.getProperty(email) + " "
				+ prop.getProperty(Constant.NEWS_SUBSCRIPTION_ERROR_MESSAGE);
		String sucessMessage = prop.getProperty(Constant.NEWS_SUBSCRIPTION_SUCCESS_MESSAGE);
		String continuousMessage = prop.getProperty(Constant.CONTINUOUS_SUBSCRIPTION_RECIPIENT_MESSAGE) + " "
				+ prop.getProperty(Constant.QUOTES_STRING) + prop.getProperty(email)
				+ prop.getProperty(Constant.QUOTES_STRING) + " "
				+ prop.getProperty(Constant.CONTINUOUS_SUBSCRIPTION_MESSAGE);
		String defaultMessage = prop.getProperty(Constant.NO_EMAIL_ENTER_MESSAGE);
		if (verifyText(locatorKey, registeredUserMessage)) {
			reportPass("Already Subscribed error message is getting displayed on the page.");
			takeScreenShot();
		} else if (verifyText(locatorKey, sucessMessage)) {
			reportPass("New user subscription sucess message is getting displayed on the page.");
			takeScreenShot();
		} else if (verifyText(locatorKey, continuousMessage)) {
			reportPass("Too many recent signup requests message is getting displayed on the page.");
			takeScreenShot();
		} else if (verifyText(locatorKey, defaultMessage)) {
			reportPass("Default message is getting displaued on the page.");
			takeScreenShot();
		} else {
			reportFailure("Error Message not found.");
		}
	}

	/*********************** Conditional waits ****************************/

	protected void waitUntilElementPresent(String locatorKey) {

		if (locatorKey.endsWith("_css"))
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(prop.getProperty(locatorKey))));
		else if (locatorKey.endsWith("_name"))
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(prop.getProperty(locatorKey))));

		else if (locatorKey.endsWith("_xpath"))
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty(locatorKey))));
		else {
			reportFailure("Locator not correct - " + locatorKey);
			AssertJUnit.fail("Locator not correct - " + locatorKey);
		}
	}

	private void waitForPageToLoad() {
		new WebDriverWait(driver, 10000).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
	}

	/***************************** Static waits ********************************/

	protected void sleep(int waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***************************** Reporting ********************************/

	protected void reportPass(String msg) {
		takeScreenShot();
		test.log(LogStatus.PASS, msg);
	}

	private void initReport(String msg) {
		test = testReport.startTest(msg);
	}

	private void endReport() {
		testReport.flush();
	}

	private void reportFailure(String msg) {
		test.log(LogStatus.FAIL, msg);
		closeAllTabs();
		takeScreenShot();
		AssertJUnit.fail("Failed Message :: " + msg);
	}

	protected void reportInfo(String msg) {
		test.log(LogStatus.INFO, msg);
	}

	protected void takeScreenShot() {
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(scrFile, new File(System.getProperty("user.dir") + "//screenshots//" + screenshotFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Screenshot-> "
				+ test.addScreenCapture(System.getProperty("user.dir") + "//screenshots//" + screenshotFile));
	}
}
