package com.hrm.steps;

import org.testng.Assert;

import com.hrm.pages.LoginAccountPage;

import io.cucumber.java.en.Given;

public class ForgotSteps {
	
	LoginAccountPage lap= new LoginAccountPage();
	
	
	@Given("user in login page and verify {string} is Displayed")
	public void user_in_login_page_and_verify_is_displayed(String expected) throws InterruptedException {
		Thread.sleep(3000);
		String actual=lap.getForgotText();
		Assert.assertEquals(actual, expected);
	}

}
