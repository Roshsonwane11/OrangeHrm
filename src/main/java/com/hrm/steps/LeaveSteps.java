package com.hrm.steps;


import com.hrm.pages.LeavePage;
import com.hrm.pages.LoginAccountPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeaveSteps {
	

	@When("User Logged in successfully")
	public void userLoggedIn() throws InterruptedException {
		LoginAccountPage loginAccountPage = new LoginAccountPage();
		loginAccountPage.enterValidCredentials();
	}
	
	@And("User click on {string} menu")
	public void clickOnYourMenu(String menuName) throws InterruptedException {
		LeavePage leavePage=new LeavePage();
		leavePage.clickOnLeaveMenu(menuName);
	}
	@Then("User should navigate to {string} page with default tab selected as {string}")
	public void verifyUserNavigateToLeavePage(String pageName, String defaultTabSelected) {
		LeavePage leavePage=new LeavePage();
		leavePage.verifyUserNavigatesToLeavePage(pageName,defaultTabSelected);
	}
	
	@And("User select {string} as From Date from the calendar")
	public void selectFromDate(String fromDate) throws InterruptedException {
		LeavePage leavePage=new LeavePage();
		leavePage.selectLeaveFromDate(fromDate);
	}
	@And("User select {string} as To Date from the calendar")
	public void selectToDate(String toDate) {
		LeavePage leavePage=new LeavePage();
		leavePage.selectLeaveToDate(toDate);
	}
	
	@Then("{string} format should be shown on both places.")
	public void dateFormat(String dateAcceptedFormat) {
		LeavePage leavePage=new LeavePage();
		leavePage.verifyDateAcceptedFormat(dateAcceptedFormat);
	}
	
	@Then("if not having any leave records then should show toast message as {string} else should not show any message.")
	public void NoRecordsFoundMessageIfNoLeave(String NoRecordsExpectedMessage) {
		LeavePage leavePage=new LeavePage();
		leavePage.verifyNoRecordsFoundMessage(NoRecordsExpectedMessage);
		
	}
}
