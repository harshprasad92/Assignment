package com.assignment.tests;

import com.data.pojo.Owner;
import com.web.pageObjects.AddOwnerPage;
import com.web.pageObjects.FindOwnerPage;
import com.web.pageObjects.OwnerInfoPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class AddOwnerDefinition {

	FindOwnerPage findOwnerPage;
	AddOwnerPage addOwnerPage;
	OwnerInfoPage ownerInfoPage;
public static String ownerLastName ="";
	@When("^User click on 'Add Owner'$")
	public void user_click_on_Add_Owner() throws Throwable {
		findOwnerPage = new FindOwnerPage(CommonStepDefinition.actions);
		Assert.assertTrue(findOwnerPage.navigateToAddOwnerPage());
	}

	Owner owner;

	@When("^Add owner details$")
	public void add_owner_details() throws Throwable {
		addOwnerPage = new AddOwnerPage(CommonStepDefinition.actions);
		owner = new Owner();
		addOwnerPage.addOwnerDetails(owner);
		ownerLastName = owner.getLastName();
	}

	@Then("^Owner details should be displayed$")
	public void owner_details_should_be_displayed() throws Throwable {
		ownerInfoPage = new OwnerInfoPage(CommonStepDefinition.actions);
		Assert.assertTrue(ownerInfoPage.verifyOwnerDetails(ownerLastName));
	}

	@When("^Add owner first name and submit$")
	public void add_owner_first_name_and_submit() throws Throwable {
		addOwnerPage = new AddOwnerPage(CommonStepDefinition.actions);
		 owner = new Owner();
		addOwnerPage.submitWithFirstName(owner);
	}

	@Then("^User should get error message for each field$")
	public void user_should_get_error_message_for_each_field() throws Throwable {

		Assert.assertTrue(addOwnerPage.verifyErrorMessageAddOwnerPage());
	}

}
