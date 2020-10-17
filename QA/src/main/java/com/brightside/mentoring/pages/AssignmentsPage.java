package com.brightside.mentoring.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.brightside.mentoring.base.TestBase;
import com.brightside.mentoring.utils.TestUtils;

public class AssignmentsPage extends TestBase {

	// Page Factory or Object Repository
	@FindBy(xpath = "//span[@class='title']")
	WebElement assignmentTitle;

	@FindBy(xpath = "//input[@class='hide-file-input']")
	WebElement uploadBtn;

	@FindBy(xpath = "//div[@class='attachment-details']")
	WebElement attachmentDetails;

	@FindBy(xpath = "//div[@class='submit-assignment']")
	WebElement submitAssignmentBtn;
	
	@FindBy(xpath = ".//*[@id=\"toast-container\"]/div/div/div/span[@class=\"toast-message\"]")
	WebElement toasterMessageLocator;

	// Initializing the page objects
	public AssignmentsPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateAssignmentURL() {
		return driver.getCurrentUrl();
	}

	public String validateAssignmentsTitle() {
		return assignmentTitle.getText();
	}
	
	public boolean AssignmentUpload(String path) throws InterruptedException {
		uploadBtn.sendKeys(path);
		Thread.sleep(2000);
		if(attachmentDetails.isDisplayed()) {
			return true;
		}else{
			Assert.assertTrue(toasterMessageLocator.isDisplayed());
			return false;
		}
	}
	
	public String GetToasterText() {
		return toasterMessageLocator.getText();
	}
	
	public void clickSubmitButton() {
		submitAssignmentBtn.click();
		TestUtils.WaitUntilInvisiblityOfElement(PRELOADER);
	}

	public boolean validateAssignment(String fileName) {
		return TestUtils.validateText(fileName);
	}

}
