package com.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;
import com.framework.actions.UserActions;
import com.framework.actions.WebActions;
import com.framework.reporting.Report;

import java.util.List;

public class OwnerInfoPage {
	UserActions actions;

	public OwnerInfoPage(UserActions actions) {
		this.actions = actions;
		PageFactory.initElements(actions.getDriver(), this);
	}

	@FindBy(xpath = "//h2[contains(text(),'Owner Information')]")
	WebElement headerOwnerInfo;

	@FindBy(xpath = "//th[contains(text(),'Name')]/following-sibling::td/b")
	WebElement fieldOwnerName;

	@FindBy(linkText = "Edit Owner")
	WebElement linkEditOwner;

	@FindBy(linkText = "Add New Pet")
	WebElement linkAddNewPet;

	@FindBy(xpath = "//h2[contains(text(),'Pets and Visits')]/following-sibling::table/tbody/tr/td[1]/dl/dd[1]")
	List<WebElement> fieldPetNames;

	@FindBy(xpath = "//h2[contains(text(),'New')]")
	WebElement headerNewVisit;

	public boolean verifyOwnerDetails(String lastname) {
		boolean bFlag = false;
		try {

			if (actions.waitUntilElementIsVisible(headerOwnerInfo, WebActions.timeout)) {
				if (actions.getText(fieldOwnerName).contains(lastname)) {
					bFlag = true;
					Reporter.addStepLog("The last name was verified on the owner info page");
				} else {
					Report.addStepWithScreenshot("The last name did not match on owner info page");
				}
			} else {
				Report.addStepWithScreenshot("Owner Info page is not displayed");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Report.addStepWithScreenshot("Exception occurred while verifying owner details page");

		}
		return bFlag;

	}

	public void navigateToEditOwner() {

		try {
			actions.click(linkEditOwner);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void navigateToAddNewPet() {

		try {
			actions.click(linkAddNewPet);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public boolean verifyPetListed(String petName) {
		boolean bFlag = false;
		try {

			List<String> petNames = actions.getTextFromWebElementList(fieldPetNames);
			if (petNames.contains(petName)) {
				bFlag = true;
				Reporter.addStepLog("Pet successfully added for the owner");
			} else {
				Report.addStepWithScreenshot("Pet was not added for the owner");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Report.addStepWithScreenshot("Exception occurred while verifying pet for the owner");
		}
		return bFlag;
	}

	public boolean navigateToAddVisitPage(String petName) {
		actions.getDriver().findElement(By.xpath("//dd[contains(text(),'" + petName
				+ "')]/ancestor::td/following-sibling::td//a[contains(text(),'Add')]")).click();
		return actions.waitUntilElementIsVisible(headerNewVisit, WebActions.timeout);
	}

	public boolean verifyVisitAdded(String petName, String visitDesc) {
		boolean bFlag = false;
		try {
			List<String> visitDescs = actions.getTextFromWebElementList(actions.getDriver().findElements(
					By.xpath("//h2[contains(text(),'Pets and Visits')]/following-sibling::table//dd[contains(text(),'"
							+ petName + "')]/parent::dl/parent::td/following-sibling::td/table/tbody/tr/td[2]")));

			if (visitDescs.contains(visitDesc)) {
				bFlag = true;
				Reporter.addStepLog("Visit for the pet " + petName + " was added successfully");
			} else {
				Report.addStepWithScreenshot("Visit was not added successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Report.addStepWithScreenshot("Exception occurred while verifying the visit for pet " + petName);
		}
		return bFlag;
	}
}
