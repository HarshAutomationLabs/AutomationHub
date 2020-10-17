package com.brightside.mentoring.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.brightside.mentoring.base.TestBase;
import com.brightside.mentoring.utils.TestUtils;

public class FeedsPage extends TestBase {
	
	// Page Factory - Object Repository
	@FindBy(xpath = "//div[@class='joyride-step__container']")
	WebElement tourContainer;
	
	@FindBy(xpath = "//div[@class='joyride-step__title']']")
	WebElement tourBoxTitle;
	
	@FindBy(xpath = "//div[@class='joyride-step__body']']")
	WebElement tourBoxBody;	
	
	@FindBy(xpath = "//joyride-button[@class='joyride-step__next-button']/button")
	WebElement tourNextBtn;	
	
	@FindBy(xpath = "//joyride-button[@class='joyride-step__prev-button']/button")
	WebElement tourPreviousBtn;	
	
	// Initializing the page objects:
	public FeedsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean getTourAccessAfterSignUp() {
		if (tourContainer.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}

	public boolean completeTheTour() {
		
		boolean tourTitle1 = (tourBoxTitle.getText().startsWith("Welcome"));
		boolean tourBody1 = (tourBoxBody.getText().contains("Take a quick tour so you can see what you can do on Brightside."));
		boolean tourTitle2 = (tourBoxTitle.getText().contains("Channels"));
		boolean tourBody2 = (tourBoxBody.getText().contains("These are your channels. Channels are conversations on the platform."));
		boolean tourTitle3 = (tourBoxTitle.getText().contains("Channels"));
		boolean tourBody3 = (tourBoxBody.getText().contains("These are your channels. Channels are conversations on the platform."));
		boolean tourTitle4 = (tourBoxTitle.getText().contains("Channels"));
		boolean tourBody4 = (tourBoxBody.getText().contains("These are your channels. Channels are conversations on the platform."));
		boolean tourTitle5 = (tourBoxTitle.getText().contains("Channels"));
		boolean tourBody5 = (tourBoxBody.getText().contains("These are your channels. Channels are conversations on the platform."));
		boolean tourTitle6 = (tourBoxTitle.getText().contains("Channels"));
		boolean tourBody6 = (tourBoxBody.getText().contains("These are your channels. Channels are conversations on the platform."));
		
		TestUtils.waitUntilElementPresent(tourContainer);
		if(tourTitle1 && tourBody1) {
			tourNextBtn.click();
			TestUtils.waitUntilElementPresent(tourContainer);
			if(tourTitle2 && tourBody2) {
				tourNextBtn.click();
				TestUtils.waitUntilElementPresent(tourContainer);
				if(tourTitle3 && tourBody3) {
					tourNextBtn.click();
					TestUtils.waitUntilElementPresent(tourContainer);
					if(tourTitle4 && tourBody4) {
						tourNextBtn.click();
						TestUtils.waitUntilElementPresent(tourContainer);
						if(tourTitle5 && tourBody5) {
							tourNextBtn.click();
							TestUtils.waitUntilElementPresent(tourContainer);
							if(tourTitle6 && tourBody6) {
								tourNextBtn.click();
								TestUtils.waitUntilElementPresent(tourContainer);
								return true;
							}
							return false;
						}
						return false;
					}
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}
	
	// Actions:
    
	
}
