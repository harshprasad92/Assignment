package com.assignment.tests;

import java.util.Random;

import org.testng.Assert;

import com.web.pageObjects.NewVisitPage;
import com.web.pageObjects.OwnerInfoPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddVisitDeifinition {

	NewVisitPage newVisitPage;
	OwnerInfoPage ownerInfoPage;
	protected static String petName = "";
	private static String visitDesc = "";

	@Given("^User navigate to Add Visit for pet \"([^\"]*)\"$")
	public void user_navigate_to_for_pet(String petName) throws Throwable {
		ownerInfoPage = new OwnerInfoPage(CommonStepDefinition.actions);
		this.petName = petName;
		ownerInfoPage.navigateToAddVisitPage(petName);
	}

	@When("^User add details for visit and save$")
	public void user_add_details_for_visit_and_save() throws Throwable {
		newVisitPage = new NewVisitPage(CommonStepDefinition.actions);
		visitDesc = "test description" + new Random().nextInt(100);
		newVisitPage.addVisit(visitDesc);
	}

	@Then("^Visit details should be saved with description$")
	public void visit_details_should_be_saved_with_description() throws Throwable {
		ownerInfoPage = new OwnerInfoPage(CommonStepDefinition.actions);
		Assert.assertTrue(ownerInfoPage.verifyVisitAdded(petName, visitDesc));
	}

}
