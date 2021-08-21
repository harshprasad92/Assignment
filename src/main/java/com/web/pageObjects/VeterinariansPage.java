package com.web.pageObjects;

import java.util.List;

import com.cucumber.listener.Reporter;
import com.framework.reporting.Report;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.actions.UserActions;

public class VeterinariansPage {
	UserActions actions;

	public VeterinariansPage(UserActions actions) {
		this.actions = actions;
		PageFactory.initElements(actions.getDriver(), this);
	}

	@FindBy(xpath = "//table[@id='vets']/tbody/tr/td[1]")
	List<WebElement> vetNames;

	public boolean verifyListOfVeterinarians(List<String> expectedVetList) {
		boolean bFlag = false;
		try {

			List<String> actualVetNames = actions.getTextFromWebElementList(vetNames);
			if (actualVetNames.containsAll(expectedVetList)) {
				bFlag = true;
				Reporter.addStepLog("The list of vets is verified");
			} else {
				Report.addStepWithScreenshot("The list of vets does not match");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Report.addStepWithScreenshot("Exception occurred while verifying vets list");
		}
		return bFlag;
	}
}
