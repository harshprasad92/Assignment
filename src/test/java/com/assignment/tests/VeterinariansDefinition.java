package com.assignment.tests;

import java.util.List;

import com.web.pageObjects.HomePage;
import com.web.pageObjects.VeterinariansPage;

import cucumber.api.java.en.Then;
import org.testng.Assert;

public class VeterinariansDefinition {
	HomePage homePage;
	VeterinariansPage veterinariansPage;

	@Then("^User should see list of veterinarians$")
	public void user_should_see_list_of_veterinarians(List<String> list) throws Throwable {

		veterinariansPage = new VeterinariansPage(CommonStepDefinition.actions);
		Assert.assertTrue(veterinariansPage.verifyListOfVeterinarians(list));

	}

	@Then("^User should see pet clinic logo$")
	public void user_should_see_pet_clinic_logo() throws Throwable {
		homePage = new HomePage(CommonStepDefinition.actions);
		Assert.assertTrue(homePage.verifyHomePageLogo());
	}
}
