package com.hrm.steps;

import org.testng.Assert;

import com.hrm.base.Keyword;
import com.hrm.base.WaitFor;
import com.hrm.pages.LoginAccountPage;
import com.hrm.pages.PersonalInformationManagementPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalInformationManagementSteps {

	@When("The user is on the OrangeHRM login page")
	public void navigatesToLoginPage() throws InterruptedException {
		LoginAccountPage loginAccountPage = new LoginAccountPage();
		loginAccountPage.enterValidCredentials();
	}

	@And("The user clicks on the {string} module in the menu")
	public void clickOnPIM(String string) {
		PersonalInformationManagementPage page = new PersonalInformationManagementPage();
		page.clickOnPIM();
		Assert.assertTrue(Keyword.driver.getCurrentUrl().contains("pim"));
	}

	@Then("The Employee Information page should be displayed")
	public void PIMpageDisaplay() {
		Assert.assertTrue(Keyword.driver.getCurrentUrl().contains("pim"));
	}

	@And("the user clicks on {string}")
	public void clickOnAddEmployee(String string) {
		PersonalInformationManagementPage page = new PersonalInformationManagementPage();
		page.clickOnAddEmployee();
		// WaitFor.untilUrlLoad("addEmployee");
	}

	@And("the user enters first name {string} middle name {string} & last name {string}")
	public void enterfullname(String firstName, String middleName, String lastName) {
		PersonalInformationManagementPage page = new PersonalInformationManagementPage();
		page.enterfullname(firstName, middleName, lastName);

	}

	@And("the user sets employee ID")
	public void setEmployeeID() throws InterruptedException {
		PersonalInformationManagementPage page = new PersonalInformationManagementPage();
		page.setEmployeeID();

	}

	@And("the user uploads a valid profile picture {string}")
	public void setprofilePicture(String fileName) throws InterruptedException {
		PersonalInformationManagementPage page = new PersonalInformationManagementPage();
		page.setprofilePicture();

	}

	@And("the user clicks the {string} button")
	public void clickOnSavebtn(String btn) {
		PersonalInformationManagementPage page = new PersonalInformationManagementPage();
		page.clickOnSavebtn();

	}

	@And("the system should display the new employee in the Employee List")
	public void userredirectedOnEmployeeList() {
		WaitFor.untilUrlLoad("empNumber");
		System.out.println(Keyword.driver.getCurrentUrl());
		Assert.assertTrue(Keyword.driver.getCurrentUrl().contains("empNumber"));

	}
	@And("the user leaves first name and last name fields blank")
	public void leaveFirstAndLastNameBlank() {
	    PersonalInformationManagementPage page = new PersonalInformationManagementPage();
	    page.leaveFirstAndLastNameBlank();
	}

	@Then("the system should display validation error messages for required fields")
	public void verifyRequiredFieldValidationMessages() {
	    PersonalInformationManagementPage page = new PersonalInformationManagementPage();
	    page.isFirstNameRequiredErrorDisplayed();
	}

}
