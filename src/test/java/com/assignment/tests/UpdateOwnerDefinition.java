package com.assignment.tests;

import com.data.pojo.Owner;
import com.web.pageObjects.AddOwnerPage;
import com.web.pageObjects.OwnerInfoPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class UpdateOwnerDefinition {
	OwnerInfoPage ownerInfoPage;
	AddOwnerPage addOwnerPage;

	@Then("^User should see owner details for \"([^\"]*)\"$")
	public void user_should_see_owner_details_for(String lastName) throws Throwable {
		ownerInfoPage = new OwnerInfoPage(CommonStepDefinition.actions);
		Assert.assertTrue(ownerInfoPage.verifyOwnerDetails(lastName));

	}

	@When("^User navigates to Edit Owner$")
	public void user_click_on() throws Throwable {
		ownerInfoPage = new OwnerInfoPage(CommonStepDefinition.actions);
		ownerInfoPage.navigateToEditOwner();
	}

	@Then("^User should be able to edit detail and save the owner$")
	public void user_should_be_able_to_edit_detail_and_save_the_owner() throws Throwable {
		addOwnerPage = new AddOwnerPage(CommonStepDefinition.actions);
		Owner owner = new Owner();
		String lastname = addOwnerPage.updateOwnerDetails(owner);
		Assert.assertTrue(ownerInfoPage.verifyOwnerDetails(lastname));

	}

}
