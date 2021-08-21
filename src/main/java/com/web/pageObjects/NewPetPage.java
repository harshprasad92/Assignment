package com.web.pageObjects;

import com.data.pojo.Pet;
import com.framework.actions.UserActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPetPage {

	UserActions actions;

	public NewPetPage(UserActions actions) {
		this.actions = actions;
		PageFactory.initElements(actions.getDriver(), this);
	}

	@FindBy(id = "name")
	WebElement textBoxName;

	@FindBy(id = "birthDate")
	WebElement textBoxBirthDate;

	@FindBy(id = "type")
	WebElement dropDownPet;

	@FindBy(xpath = "//button[contains(text(),'Add Pet')]")
	WebElement buttonAddPet;

	public void enterPetDetails(Pet pet) {
		actions.enterText(textBoxName, pet.getName());
		actions.enterText(textBoxBirthDate, pet.getDateOfBirth());
		actions.selectDropDown(dropDownPet, pet.getPetType());
		actions.click(buttonAddPet);

	}

}
