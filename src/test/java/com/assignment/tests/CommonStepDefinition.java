package com.assignment.tests;

import com.framework.actions.UserActions;
import com.framework.actions.WebActions;
import com.framework.driver.RunnerTest;
import com.framework.driver.web.WebBrowserDriver;
import com.framework.utilities.PropertyFileHandler;
import com.web.pageObjects.HomePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class CommonStepDefinition extends RunnerTest {

	public static UserActions actions = null;
	PropertyFileHandler propertyFileHandler = new PropertyFileHandler();
	HomePage homePage;

	@Before
	public void setupWebControls() {

		if (actions == null || actions.getDriver().toString().contains("null")) {
			actions = new WebActions(new WebBrowserDriver().getDriver(browser));
		}
	}

	@After
	public void killWebController() {
		actions.quitDriver();
	}

	@Given("^User is on pet-clinic home page \"([^\"]*)\"$")
	public void user_is_on_pet_clinic_home_page(String url) throws Throwable {
		homePage = new HomePage(actions);
		Assert.assertTrue(homePage.launchApplication(url, propertyFileHandler.readProperty("data", "pageTitle")));

	}

	@When("^User navigates to \"([^\"]*)\" page$")
	public void user_navigates_to_page(String page) throws Throwable {
		Assert.assertTrue(homePage.navigateToPage(page));
	}
}
