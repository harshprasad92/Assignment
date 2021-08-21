package com.web.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;
import com.data.pojo.Owner;
import com.framework.actions.UserActions;
import com.framework.reporting.Report;

public class AddOwnerPage {

	UserActions actions;

	public AddOwnerPage(UserActions actions) {
		this.actions = actions;
		PageFactory.initElements(actions.getDriver(), this);
	}

	@FindBy(linkText = "Add Owner")
	WebElement linkAddOwner;

	@FindBy(id = "firstName")
	WebElement textBoxFirstName;

	@FindBy(id = "lastName")
	WebElement textBoxLastName;

	@FindBy(id = "address")
	WebElement textBoxAddress;

	@FindBy(id = "city")
	WebElement textBoxCity;

	@FindBy(id = "telephone")
	WebElement textBoxTelephone;

	@FindBy(xpath = "//button[contains(text(),'Add Owner')]")
	WebElement buttonAddOwner;

	@FindBy(xpath = "//span[contains(text(),'must not be empty')]")
	List<WebElement> labelErrorMessage;

	@FindBy(xpath = "//button[contains(text(),'Update Owner')]")
	WebElement buttonUpdateOwner;

	public void addOwnerDetails(Owner owner) {
		try {

			actions.enterText(textBoxFirstName, owner.getFirstName());
			actions.enterText(textBoxLastName, owner.getLastName());
			actions.enterText(textBoxAddress, owner.getAddress());
			actions.enterText(textBoxCity, owner.getCity());
			actions.enterText(textBoxTelephone, owner.getPhone());
			actions.click(buttonAddOwner);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void submitWithFirstName(Owner owner) {
		try {
			actions.enterText(textBoxFirstName, owner.getFirstName());
			actions.click(buttonAddOwner);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifyErrorMessageAddOwnerPage() {
		boolean bFlag = false;
		try {
			if (labelErrorMessage.size() == 4) {
				bFlag = true;
				Reporter.addStepLog("The error message for all the fields are displayed");
			} else {
				Report.addStepWithScreenshot("The error message is not displayed for all the fields");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Report.addStepWithScreenshot("The error message is not displayed for all the fields");
		}
		return bFlag;
	}

	public String updateOwnerDetails(Owner owner) {
		String lastname = "";
		try {
			lastname = actions.getValueOfAttribute(textBoxLastName, "value");
			actions.enterText(textBoxCity, owner.getCity());
			actions.enterText(textBoxTelephone, owner.getPhone());
			actions.click(buttonUpdateOwner);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastname;
	}

}
