package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hrm.base.Keyword;
import com.hrm.base.WaitFor;

public class LoginAccountPage {
Keyword keyword = new Keyword();	
	
	@FindBy(xpath = "//input[@name=\"username\"]")
	private WebElement userNameBox;
	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement passwordInputBox;
	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement loginBTN;

	public LoginAccountPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	public void OpenUrl() {
		keyword.launchUrl("https://opensource-demo.orangehrmlive.com/");
		Assert.assertTrue(Keyword.driver.getCurrentUrl().contains("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
	}

	public void enterValidCredentials() throws InterruptedException {
		WaitFor.elementTobeVisible(userNameBox);
		keyword.clickOn(userNameBox);
		userNameBox.sendKeys("Admin");
		passwordInputBox.sendKeys("admin123");
		loginBTN.click();
	}
}
