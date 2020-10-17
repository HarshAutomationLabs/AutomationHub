package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import base.TestBase;

public class Products extends TestBase {

	@FindBy(xpath = "//span[@class='action_item']/a")
	WebElement CREATE_PRODUCT;

	@FindBy(id = "page_title")
	WebElement CREATE_PRODUCT_TITLE;

	@FindBy(id = "product_title")
	WebElement TITLE_FIELD;

	@FindBy(id = "product_sku")
	WebElement SKU_FIELD;

	@FindBy(id = "product_description")
	WebElement DESCRIPTION_FIELD;

	@FindBy(css = "#page_title")
	WebElement PRODUCT_PAGE_TITLE;

	@FindBy(xpath = "//tr[@class='row row-title']/td")
	WebElement PRODUCT_NAME;

	@FindBy(xpath = "//tr[@class='row row-sku']/td")
	WebElement SKU_NAME;

	@FindBy(xpath = "//tr[@class='row row-description']/td")
	WebElement DESCRIPTION_NAME;

	@FindBy(css = "td.col.col-title")
	WebElement PRODUCT_TITLE;

	@FindBy(css = ".edit_link.member_link")
	WebElement EDIT_LINK;

	@FindBy(css = ".view_link.member_link")
	WebElement VIEW_LINK;

	@FindBy(css = ".flash.flash_notice")
	WebElement SUCCESS_FLASH_NOTICE;

	public Products() throws InterruptedException {
		PageFactory.initElements(driver, this);
	}

	public void navigateToCreateProducts() throws InterruptedException {
		CREATE_PRODUCT.click();
		Assert.assertTrue(CREATE_PRODUCT_TITLE.getText().contains("New Product"));
	}

	public void enterProductDetails(String title, String sku, String desciption) {
		TITLE_FIELD.clear();
		TITLE_FIELD.sendKeys(title);
		SKU_FIELD.clear();
		SKU_FIELD.sendKeys(sku);
		DESCRIPTION_FIELD.clear();
		DESCRIPTION_FIELD.sendKeys(desciption);
		DESCRIPTION_FIELD.submit();
	}

	public void verifyProductDetails(String title, String sku, String description) {
		Assert.assertTrue(PRODUCT_PAGE_TITLE.getText().equals(title));
		Assert.assertTrue(PRODUCT_NAME.getText().equals(title));
		Assert.assertTrue(SKU_NAME.getText().equals(sku));
		Assert.assertTrue(DESCRIPTION_NAME.getText().equals(description));
	}

	public void validateFieldValidation(String errorMessage) throws InterruptedException {

		if (driver.findElements(By.xpath("//li[@id='product_title_input']/p")).size() != 0) {
			List<WebElement> list = driver.findElements(By.xpath("//li[@id='product_title_input']/p"));
			Assert.assertTrue(list.get(0).getText().equals(errorMessage));
		}
		if (driver.findElements(By.xpath("//li[@id='product_sku_input']/p")).size() != 0) {
			List<WebElement> list = driver.findElements(By.xpath("//li[@id='product_sku_input']/p"));
			Assert.assertTrue(list.get(0).getText().equals(errorMessage));
		}
		if (driver.findElements(By.xpath("//li[@id='product_description_input']/p")).size() != 0) {
			List<WebElement> list = driver.findElements(By.xpath("//li[@id='product_description_input']/p"));
			Assert.assertTrue(list.get(0).getText().equals(errorMessage));
		}
	}

	public void checkMaximumLength() throws InterruptedException {
		Assert.assertTrue(TITLE_FIELD.getAttribute("maxlength").equals("40"));
		Assert.assertTrue(SKU_FIELD.getAttribute("maxlength").equals("10"));
		Assert.assertTrue(DESCRIPTION_FIELD.getAttribute("maxlength").equals("255"));
	}

	public void verifyDesiredLength(int desiredProductLength, int desiredSkuLength, int desiredDescriptionLength) {
		int actualProductLength = PRODUCT_NAME.getText().length();
		int actualSkuLength = SKU_NAME.getText().length();
		int actualDescriptionLength = DESCRIPTION_NAME.getText().length();
		Assert.assertEquals(actualProductLength, desiredProductLength);
		Assert.assertEquals(actualSkuLength, desiredSkuLength);
		Assert.assertEquals(actualDescriptionLength, desiredDescriptionLength);
	}

	public void verifyProductsInProductListing(String title, String sku, String description) {
		HashMap<String, String> nameMap = new HashMap<String, String>();
		List<WebElement> PRODUCT_IDs = driver.findElements(By.cssSelector(".resource_id_link"));
		List<WebElement> PRODUCT_TITLEs = driver.findElements(By.cssSelector("td.col.col-title"));
		for (int i = 0; i < PRODUCT_IDs.size(); i++) {
			String idKey = PRODUCT_IDs.get(i).getText();
			String idValue = PRODUCT_TITLEs.get(i).getText();
			nameMap.put(idKey, idValue);
		}
		Assert.assertTrue(nameMap.containsValue(title));

		HashMap<String, String> skuMap = new HashMap<String, String>();
		List<WebElement> PRODUCT_Skus = driver.findElements(By.cssSelector("td.col.col-sku"));
		for (int i = 0; i < PRODUCT_IDs.size(); i++) {
			String skuKey = PRODUCT_IDs.get(i).getText();
			String skuValue = PRODUCT_Skus.get(i).getText();
			skuMap.put(skuKey, skuValue);
		}
		Assert.assertTrue(skuMap.containsValue(sku));

		HashMap<String, String> descMap = new HashMap<String, String>();
		List<WebElement> PRODUCT_Desc = driver.findElements(By.cssSelector("td.col.col-description"));
		for (int i = 0; i < PRODUCT_IDs.size(); i++) {
			String skuKey = PRODUCT_IDs.get(i).getText();
			String skuValue = PRODUCT_Desc.get(i).getText();
			descMap.put(skuKey, skuValue);
		}
		Assert.assertTrue(descMap.containsValue(description));
	}

	public void navigateToEditProduct(String title) {
		String productId = accessActionsOfProduct(title);
		String element = "product_" + productId;
		WebElement productElement = driver.findElement(By.id(element));
		WebElement productEditLink = productElement.findElement(By.cssSelector(".edit_link.member_link"));
		productEditLink.click();
		Assert.assertTrue(PRODUCT_PAGE_TITLE.getText().contains("Edit Product"));
	}

	public String accessActionsOfProduct(String product) {
		HashMap<String, String> map = new HashMap<String, String>();
		List<WebElement> PRODUCT_IDs = driver.findElements(By.cssSelector(".resource_id_link"));
		List<WebElement> PRODUCT_TITLEs = driver.findElements(By.cssSelector("td.col.col-title"));
		for (int i = 0; i < PRODUCT_IDs.size(); i++) {
			String idKey = PRODUCT_IDs.get(i).getText();
			String idValue = PRODUCT_TITLEs.get(i).getText();
			map.put(idKey, idValue);
		}
		return getProductId(map, product);
	}

	public static String getProductId(HashMap<String, String> map, String str) {
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			if (entry.getValue().equals(str)) {
				return entry.getKey();
			}
		}
		return null;
	}

	public void deleteProductFromList() {
		List<WebElement> PRODUCTS = driver.findElements(By.cssSelector(".resource_id_link"));
		int productListSize = PRODUCTS.size();
		for (int i = 0; i < productListSize - 1; i++) {
			String productId = PRODUCTS.get(i).getText();
			WebElement productRow = driver.findElement(By.xpath("//a[@class=\"resource_id_link\"]/../.."));
			WebElement productDeleteBtn = productRow.findElement(By.cssSelector(".delete_link.member_link"));
			productDeleteBtn.click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Assert.assertFalse(PRODUCTS.contains(productId));
		}
	}

	public void deleteProductsFromProduct() {
		String productTitle = PRODUCT_TITLE.getText();
		VIEW_LINK.click();
		Assert.assertTrue(PRODUCT_PAGE_TITLE.getText().equals(productTitle));
		driver.findElement(By.xpath("//a[@data-method='delete']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void verifySuccessMessage(String message) {
		Assert.assertFalse(SUCCESS_FLASH_NOTICE.equals(message));
	}
}