package testcases;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Dashboard;
import pages.Login;
import pages.Products;
//import utils.Utility;
import utils.Utility;

public class Create_Product_testcases extends TestBase {

	Login loginPage;
	Products products;

	String title = prop.getProperty("product_title");
	String sku = prop.getProperty("product_sku");
	String description = prop.getProperty("product_description");
	String emptyErrorText = prop.getProperty("emptyErrorText");
	String uniqueErrorText = prop.getProperty("uniqueErrorText");

	public Create_Product_testcases() {
		super();
	}

	@BeforeClass
	public void setUp() throws IOException, InterruptedException {
		initialization();
		loginPage = new Login();
		products = new Products();
		loginPage.doLoginMethod();
	}

	@BeforeMethod
	public Dashboard navigateToProducts() throws InterruptedException {
		return new Dashboard();
	}

	@AfterClass
	public void setDown() {
		teardown();
	}

	@Test(priority = 0)
	public void createProductsWithValidData() throws InterruptedException {
		products.navigateToCreateProducts();
		products.enterProductDetails(title, sku, description);
		products.verifyProductDetails(title, sku, description);
	}

	// Verify functionality for create product with empty fields
	@Test(priority = 1)
	public void createProductWithEmptyFiels() throws InterruptedException {
		String emptyTitle = "";
		String emptySku = "";
		String emptyDescription = "";

		products.navigateToCreateProducts();
		products.enterProductDetails(emptyTitle, emptySku, emptyDescription);
		products.validateFieldValidation(emptyErrorText);
	}

	// Verify functionality for Uniqueness of product name and sku field
	@Test(priority = 2)
	public void verifyUniqueField() throws InterruptedException {
		products.navigateToCreateProducts();
		products.enterProductDetails(title, sku, description);
		products.validateFieldValidation(uniqueErrorText);
	}

	// Verify functionality for maximum character limitation of product name, sku
	// and description field
	@Test(priority = 3)
	public void verifyFieldLimits() throws InterruptedException {
		String randomtitle = Utility.randomAlphaNumeric(41);
		String randomsku = Utility.randomAlphaNumeric(11);
		String randomdescription = Utility.randomAlphaNumeric(256);

		products.navigateToCreateProducts();
		products.checkMaximumLength();
		products.enterProductDetails(randomtitle, randomsku, randomdescription);
		products.verifyDesiredLength(40, 10, 255);
	}

}