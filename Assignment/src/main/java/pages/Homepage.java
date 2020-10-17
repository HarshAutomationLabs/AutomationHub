package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Homepage extends TestBase {

	@FindBy(xpath = "//a[contains(text(), \"Sign in\")]")
	WebElement SIGN_IN_BTN;

	public Homepage() throws InterruptedException {
		PageFactory.initElements(driver, this);
		SIGN_IN_BTN.click();
	}
}
