package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.base.Keyword;
import com.hrm.base.WaitFor;

public class ResetPasswordPage {
	
	
	public ResetPasswordPage() {
		PageFactory.initElements(Keyword.driver, this);
	}
	
	@FindBy(xpath = "//h6[text()='Reset Password']")
	private WebElement resetPasswordText;
	
	public String getTextResetPassword() {
		WaitFor.elementTobeVisible(resetPasswordText);
		return resetPasswordText.getText();
	}

}
