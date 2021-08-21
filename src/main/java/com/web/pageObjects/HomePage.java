package com.web.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;
import com.framework.actions.UserActions;
import com.framework.actions.WebActions;
import com.framework.reporting.Report;

public class HomePage {

	UserActions actions;

	public HomePage(UserActions actions) {
		this.actions = actions;
		PageFactory.initElements(actions.getDriver(), this);
	}

	@FindBy(xpath = "//span[contains(text(),'Find owners')]/parent::a")
	WebElement linkFindOwner;

	@FindBy(xpath = "//span[contains(text(),'Veterinarians')]/parent::a")
	WebElement linkVeterinarians;

	@FindBy(xpath = "//span[contains(text(),'Home')]/parent::a")
	WebElement linkHome;

	@FindBy(xpath = "//h2[contains(text(),'Find Owners')]")
	WebElement headerFindOwner;

	@FindBy(xpath = "//h2[contains(text(),'Veterinarians')]")
	WebElement headerVeterinarians;

	@FindBy(xpath = "//h2[contains(text(),'Welcome')]")
	WebElement headerWelcome;

	@FindBy(xpath = "//h2[contains(text(),'Welcome')]/following-sibling::div/div/img")
	WebElement logoHomePage;

	public boolean launchApplication(String url, String title) {
		boolean bFlag = false;
		try {
			actions.launchUrl(url);
			if (actions.getPageTitle().equalsIgnoreCase(title)) {
				Reporter.addStepLog("Successfully landed on pet clinic application");
				bFlag = true;
			} else {
				Report.addStepWithScreenshot("Failed to launch the pet clinic application");
			}

		} catch (Exception e) {
			Report.addStepWithScreenshot("Exception while launching the pet clinic application");
			e.printStackTrace();
		}
		return bFlag;
	}

	public boolean navigateToPage(String pageName) {
		boolean bFlag = false;
		try {
			if (clickHeaderLink(pageName)) {
				bFlag = true;
				Reporter.addStepLog("Successfully landed on " + pageName + " page");
			} else {
				Report.addStepWithScreenshot(pageName + " page not found");
			}

		} catch (Exception e) {
			Report.addStepWithScreenshot("Exception while navigating to " + pageName + " page.");
			e.printStackTrace();
		}
		return bFlag;
	}

	private boolean clickHeaderLink(String link) {

		switch (link.toLowerCase()) {
		case "find owners":
			actions.click(linkFindOwner);
			if (actions.waitUntilElementIsVisible(headerFindOwner, WebActions.timeout)) {
				return true;
			}

		case "veterinarians":
			actions.click(linkVeterinarians);
			if (actions.waitUntilElementIsVisible(headerVeterinarians, WebActions.timeout)) {
				return true;
			}

		case "home":
			actions.click(linkHome);
			if (actions.waitUntilElementIsVisible(headerWelcome, WebActions.timeout)) {
				return true;
			}

		default:
			return false;

		}

	}

	public boolean verifyHomePageLogo() {
		boolean bFlag = false;
		try {
			if (actions.waitUntilElementIsVisible(logoHomePage, WebActions.timeout)) {
				bFlag = true;
				Reporter.addStepLog("The logo is verified on Home Page");
			} else {
				Report.addStepWithScreenshot("The logo is not verified on Home Page");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Report.addStepWithScreenshot("Exception occurred while verifying home page logo");
		}
		return bFlag;
	}

}
