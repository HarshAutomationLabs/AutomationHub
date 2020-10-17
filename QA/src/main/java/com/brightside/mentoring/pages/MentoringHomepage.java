package com.brightside.mentoring.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.brightside.mentoring.base.TestBase;
import com.brightside.mentoring.utils.TestUtils;

public class MentoringHomepage extends TestBase {

	// Page Factory or Object Repository
	@FindBy(xpath = "//a[contains(text(), 'Mentoring')]")
	WebElement messaging_channel_link;

	@FindBy(xpath = "//a[contains(text(), 'My Account')]")
	WebElement my_account_link;

	@FindBy(xpath = "//a[contains(text(), 'Ask the Graduate')]")
	WebElement ask_the_graduate_link;

	@FindBy(xpath = "//a[contains(text(), 'Assignments')]")
	WebElement assignments_link;

	@FindBy(xpath = "//a[contains(text(), 'Project Resources')]")
	WebElement project_resources_link;

	@FindBy(xpath = "//a[contains(text(), 'Communities')]")
	WebElement communities_link;

	@FindBy(xpath = "//a[contains(text(), 'Activities')]")
	WebElement activities_link;

	public static final By PRELOADER = By.id("preloader");

	// Initializing the page objects
	public MentoringHomepage() {
		PageFactory.initElements(driver, this);
	}

	public MessagingPage clickOnMessagingLink() {
		messaging_channel_link.click();
		TestUtils.WaitUntilInvisiblityOfElement(PRELOADER);
		return new MessagingPage();
	}

	public MyAccountPage clickOnMyAccountLink() {
		my_account_link.click();
		TestUtils.WaitUntilInvisiblityOfElement(PRELOADER);
		return new MyAccountPage();
	}

	public AskTheGraduatePage clickOnAskTheGraduateLink() {
		ask_the_graduate_link.click();
		TestUtils.WaitUntilInvisiblityOfElement(PRELOADER);
		return new AskTheGraduatePage();
	}

	public AssignmentsPage clickOnAssignmentsLink() {
		assignments_link.click();
		TestUtils.WaitUntilInvisiblityOfElement(PRELOADER);
		return new AssignmentsPage();
	}

	public ProjectResourcesPage clickOnProjectResourcesLink() {
		project_resources_link.click();
		TestUtils.WaitUntilInvisiblityOfElement(PRELOADER);
		return new ProjectResourcesPage();
	}

	public CommunitiesPage clickOnCommunitiesLink() {
		communities_link.click();
		TestUtils.WaitUntilInvisiblityOfElement(PRELOADER);
		return new CommunitiesPage();
	}

	public ActivitiesPage clickOnActivitiesLink() {
		activities_link.click();
		TestUtils.WaitUntilInvisiblityOfElement(PRELOADER);
		return new ActivitiesPage();
	}
}
