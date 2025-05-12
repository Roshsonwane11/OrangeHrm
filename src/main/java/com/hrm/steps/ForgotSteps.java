package com.hrm.steps;

import org.testng.Assert;

import com.hrm.pages.LoginAccountPage;
import com.hrm.pages.ResetPasswordPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotSteps {
	
	LoginAccountPage lap= new LoginAccountPage();
	ResetPasswordPage rpp= new ResetPasswordPage();
	
	
	@Given("user in login page and verify {string} is Displayed")
	public void user_in_login_page_and_verify_is_displayed(String expected) throws InterruptedException {
		Thread.sleep(3000);
		String actual=lap.getForgotText();
		Assert.assertEquals(actual, expected);
	}

	
	@When("User Click on Forgot Button")
	public void user_click_on_forgot_button() {
		lap.clickOnForgot();
	
	}

	@Then("User Should redirect to Reset password page")
	public void user_should_redirect_to_reset_password_page() {
		String actaulText=rpp.getTextResetPassword();
		Assert.assertTrue(actaulText.contains("Reset"));
		
	}
}
