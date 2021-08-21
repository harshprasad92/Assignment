package com.assignment.tests;

import com.web.pageObjects.FindOwnerPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class SearchOwnerDefinition {
	FindOwnerPage findOwnerPage;

	@Then("^User should see error message \"([^\"]*)\"$")
	public void user_should_see_error_message(String message) throws Throwable {
		findOwnerPage = new FindOwnerPage(CommonStepDefinition.actions);
		Assert.assertTrue(findOwnerPage.verifyInvalidSearchMessage(message));

	}

	@Given("^Click on search without any name entered$")
	public void click_on_search_without_any_name_entered() throws Throwable {
		findOwnerPage = new FindOwnerPage(CommonStepDefinition.actions);
		findOwnerPage.searchOwnerWithEmptyName();
	}

	@Then("^User should see all the records of owners$")
	public void user_should_see_all_the_records_of_owners() throws Throwable {
		Assert.assertTrue(findOwnerPage.verifyOwnersList());
	}

}
