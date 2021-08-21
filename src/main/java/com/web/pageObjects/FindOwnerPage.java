package com.web.pageObjects;

import com.cucumber.listener.Reporter;
import com.framework.actions.WebActions;
import com.framework.reporting.Report;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.actions.UserActions;

public class FindOwnerPage {

	UserActions actions;

	public FindOwnerPage(UserActions actions) {
		this.actions = actions;
		PageFactory.initElements(actions.getDriver(), this);
	}

	@FindBy(xpath = "//label[contains(text(),'Last name')]/following-sibling::div/input")
	WebElement textBoxLastname;

	@FindBy(xpath = "//button[contains(text(),'Find')]")
	WebElement buttonFindOwner;

	@FindBy(linkText = "Add Owner")
	WebElement linkAddOwner;

	@FindBy(xpath = "//h2[contains(text(),'Owner')]")
	WebElement headerOwner;

	@FindBy(xpath = "//input[@id='lastName']/following-sibling::span/div/p")
	WebElement labelErrorMessage;

	@FindBy(id = "owners")
	WebElement tableOwners;

	public boolean navigateToAddOwnerPage() {
		boolean bFlag = false;
		try {
			actions.click(linkAddOwner);
			if (actions.waitUntilElementIsVisible(headerOwner, WebActions.timeout)) {
				bFlag = true;
				Reporter.addStepLog("Successfully landed on add owner page");

			} else {
				Report.addStepWithScreenshot("Add owner page was not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Report.addStepWithScreenshot("Exception occurred while navigating to add owner page");
		}
		return bFlag;
	}

	public void searchOwner(String lastName)

	{

		try {
			actions.enterText(textBoxLastname, lastName);
			actions.click(buttonFindOwner);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean verifyInvalidSearchMessage(String message) {
		boolean bFlag = false;
		try {
			if (actions.getText(labelErrorMessage).equalsIgnoreCase(message)) {
				bFlag = true;
				Reporter.addStepLog("Error message verified for invalid name search");
			} else {
				Report.addStepWithScreenshot("Error message not verified for invalid name search");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Report.addStepWithScreenshot("Exception occurred while verifying invalid name search");
		}
		return bFlag;
	}

	public void searchOwnerWithEmptyName() {
		actions.click(buttonFindOwner);
	}

	public boolean verifyOwnersList() {
		boolean bFlag = false;
		try {
			if (actions.waitUntilElementIsVisible(tableOwners, WebActions.timeout)) {
				bFlag = true;
				Reporter.addStepLog("The list of owners is displayed");
			} else {
				Report.addStepWithScreenshot("The list of owners is not displayed");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Report.addStepWithScreenshot("Exception occurred while verifying list of owners");
		}
		return bFlag;
	}

}
