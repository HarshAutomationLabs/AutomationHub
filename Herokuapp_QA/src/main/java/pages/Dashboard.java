package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class Dashboard extends TestBase {

	@FindBy(xpath = "//li[@id='products']/a")
	WebElement PRODUCTS_TAB;

	@FindBy(id = "page_title")
	WebElement PRODUCT_TITLE;

	public Dashboard() throws InterruptedException {
		PageFactory.initElements(driver, this);
		navigateToProducts();
	}

	public void navigateToProducts() throws InterruptedException {
		PRODUCTS_TAB.click();
		Assert.assertTrue(PRODUCT_TITLE.getText().contains("Products"));
	}
}
