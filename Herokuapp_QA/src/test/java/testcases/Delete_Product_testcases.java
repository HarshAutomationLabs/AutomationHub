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

public class Delete_Product_testcases extends TestBase {

	Login loginPage;
	Products products;

	String title = prop.getProperty("product_title");
	String sku = prop.getProperty("product_sku");
	String description = prop.getProperty("product_description");
	
	String deleteSucessMessage = prop.getProperty("delete_success");
	
	public Delete_Product_testcases() {
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
	
	@Test
	public void deleteProduct() {
		products.deleteProductFromList();
		products.verifySuccessMessage(deleteSucessMessage);
		products.deleteProductsFromProduct();
		products.verifySuccessMessage(deleteSucessMessage);
	}
	
}
