package com.hrm.steps;

import org.testng.Assert;

import com.hrm.base.Keyword;
import com.hrm.pages.LoginAccountPage;
import com.hrm.pages.PersonalInformationManagementPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalInformationManagementSteps {

	@When("The user is on the OrangeHRM login page")
	public void navigatesToLoginPage() throws InterruptedException {
		LoginAccountPage loginAccountPage = new LoginAccountPage();
		loginAccountPage.enterValidCredentials();
	}
	
	@Then("The user clicks on the PIM module in the menu then The Employee PIM pagee should be displayed")
	public void clickOnPIM() {
		PersonalInformationManagementPage personalInformationManagementPage =new PersonalInformationManagementPage();
		personalInformationManagementPage.clickOnPIM();
		Assert.assertTrue(Keyword.driver.getCurrentUrl()
				.contains("pim"));
	}
	

}
