package com.hrm.steps;

import org.testng.Assert;

import com.hrm.base.Keyword;
import com.hrm.pages.LoginAccountPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginAccountSteps {
	@When("User navigates to url the login page should be loaded properly")
	public void navigatesToLoginPage() {
		LoginAccountPage loginAccountPage = new LoginAccountPage();
		loginAccountPage.OpenUrl();
	}

	@Then("The user enters Valid username and password then user should be redirected to the dashboard page")
	public void enterValidCredentials() throws InterruptedException {
		LoginAccountPage loginAccountPage = new LoginAccountPage();
		loginAccountPage.enterValidCredentials();
		Assert.assertTrue(Keyword.driver.getCurrentUrl().contains("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));

	}
}
