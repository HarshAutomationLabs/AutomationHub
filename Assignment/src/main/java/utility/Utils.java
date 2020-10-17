package utility;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class Utils extends TestBase {

	public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval))
				.until(ExpectedConditions.presenceOfElementLocated(selector));
		return element;
	}

	public static WebElement validateGreenField(String element) {
		String first = "//div[contains(@class, 'form-ok')]//input[@id='";
		String second = "']";
		String xpath = first + element + second;
		return Utils.waitForElementPresence(driver, By.xpath(xpath), 30);
	}

	public static WebElement validateRedField(String element) {
		String first = "//div[contains(@class, 'form-error')]//input[@id='";
		String second = "']";
		String xpath = first + element + second;
		return Utils.waitForElementPresence(driver, By.xpath(xpath), 30);
	}

	public static boolean checkEmailFormat(String email) {
		String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
		Pattern pattern = Pattern.compile(regex);
		java.util.regex.Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}
}
