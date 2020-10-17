package com.brightside.mentoring.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.brightside.mentoring.base.TestBase;
import com.brightside.mentoring.utils.TestUtils;

public class MessagingPage extends TestBase{

	// Page Factory or Object Repository
	@FindBy(xpath="//*[@class='msg__message-content msg--pending__message-content'])[last()]")
	WebElement lastMessageElement;
	
	@FindBy(id="chat__input")
	WebElement chatMessageField;
	
	@FindBy(xpath="//*[@id='chat__send-message']")
	WebElement sendMessageBtn;
	
	// Initializing the page objects
	public MessagingPage() {
		PageFactory.initElements(driver, this);
	}

	public void validateGetLastMessage() {
		TestUtils.waitUntilElementPresent(lastMessageElement);
	}

	public void MessageScenario(String messageText) {
		chatMessageField.sendKeys(messageText);
		TestUtils.waitUntilElementClickable(sendMessageBtn);
	}
	
	public void ClickSendMessage() {
		sendMessageBtn.click();
	}

	public boolean validateMessage(String messageText) {
		boolean flag = TestUtils.validateText(messageText);
		return flag;
	}
}
