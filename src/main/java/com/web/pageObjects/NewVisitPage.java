package com.web.pageObjects;

import com.framework.actions.UserActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewVisitPage

{

	UserActions actions;

	public NewVisitPage(UserActions actions) {
		this.actions = actions;
		PageFactory.initElements(actions.getDriver(), this);
	}

	@FindBy(id = "description")
	WebElement textBoxDesc;

	@FindBy(xpath = "//button[contains(text(),'Add Visit')]")
	WebElement buttonAddVisit;

	public void addVisit(String desc) {
		actions.enterText(textBoxDesc, desc);
		actions.click(buttonAddVisit);
	}
}
