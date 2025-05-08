package com.hrm.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrm.base.Keyword;
import com.hrm.base.WaitFor;
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
		Thread.sleep(3000);
		Keyword keyword=new Keyword();
		WebElement leaveMenu=Keyword.driver.findElement(By.xpath("//div[@class=\"oxd-sidepanel-body\"]/ul/li[3]"));
		keyword.clickOn(leaveMenu);
	}
	@Then("User should navigate to {string} page with default tab selected as {string}")
	public void verifyUserNavigateToLeavePage(String pageName, String defaultTabSelected) {
		LeavePage leavePage=new LeavePage();
		leavePage.verifyUserNavigatesToLeavePage(pageName,defaultTabSelected);
	}
}
