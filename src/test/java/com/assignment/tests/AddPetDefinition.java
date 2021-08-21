package com.assignment.tests;

import com.data.pojo.Pet;
import com.web.pageObjects.FindOwnerPage;
import com.web.pageObjects.NewPetPage;
import com.web.pageObjects.OwnerInfoPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddPetDefinition {

	FindOwnerPage findOwnerPage;
	OwnerInfoPage ownerInfoPage;
	NewPetPage newPetPage;

	@Given("^Search owner details with last name \"([^\"]*)\"$")
	public void search_owner_details_with_last_name(String lastName) throws Throwable {
		findOwnerPage = new FindOwnerPage(CommonStepDefinition.actions);
		findOwnerPage.searchOwner(lastName);
		AddOwnerDefinition.ownerLastName = lastName;
	}

	@When("^User click on 'Add New Pet'$")
	public void user_click_on_Add_New_Pet() throws Throwable {
		ownerInfoPage = new OwnerInfoPage(CommonStepDefinition.actions);
		ownerInfoPage.navigateToAddNewPet();
	}

	Pet pet;

	@When("^Add details for the pet and save$")
	public void add_details_for_the_pet_and_save() throws Throwable {
		newPetPage = new NewPetPage(CommonStepDefinition.actions);
		pet = new Pet();
		newPetPage.enterPetDetails(pet);
	}

	@Then("^User should the pet listed for the owner$")
	public void user_should_the_pet_listed_for_the_owner() throws Throwable {
		ownerInfoPage = new OwnerInfoPage(CommonStepDefinition.actions);
		ownerInfoPage.verifyPetListed(pet.getName());
	}

}
