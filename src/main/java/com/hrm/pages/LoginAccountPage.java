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
	@FindBy(xpath = "//p[text()='Invalid credentials']")
	private WebElement errorMsg;
	@FindBy(xpath = "//span[text()='Required']")
	private WebElement requiredmsg;
	@FindBy(xpath = "//div[@class=\"orangehrm-login-forgot\"]")
	private WebElement forgot;
	@FindBy(xpath = "//p[text()='Forgot your password? ']")
	private WebElement forgotText;

	public String getForgotText() {
		WaitFor.elementTobeVisible(forgot);
		return forgotText.getText();
	}

	public void clickOnForgot() {
		WaitFor.elementTobeVisible(forgot);
		forgot.click();
	}

	public LoginAccountPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	public void OpenUrl() {
		Assert.assertTrue(Keyword.driver.getCurrentUrl()
				.contains("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"), "URL NOT LOADING");
	}

	public void enterValidCredentials() throws InterruptedException {
		WaitFor.elementTobeVisible(userNameBox);
		keyword.clickOn(userNameBox);
		userNameBox.sendKeys("Admin");
		passwordInputBox.sendKeys("admin123");
		loginBTN.click();
	}

	public void enterInvalidCredentials(String username, String password) {
		WaitFor.elementTobeVisible(userNameBox);
		keyword.clickOn(userNameBox);
		userNameBox.sendKeys(username);
		passwordInputBox.sendKeys(password);
		loginBTN.click();
		WaitFor.elementTobeVisible(errorMsg);
		errorMsg.isDisplayed();
		Assert.assertTrue(errorMsg.getText().contains("Invalid credentials"));

	}

	public void enterNULLCredentials(String username, String password) {
		WaitFor.elementTobeVisible(userNameBox);
		keyword.clickOn(userNameBox);
		userNameBox.sendKeys("  ");
		passwordInputBox.sendKeys("   ");
		loginBTN.click();
		WaitFor.elementTobeVisible(requiredmsg);
		requiredmsg.isDisplayed();
		Assert.assertTrue(requiredmsg.getText().contains("Required"));

	}

	public void enterInvalidCredentialsuisngDataTable(String username1, String password1) {
		WaitFor.elementTobeVisible(userNameBox);
		keyword.clickOn(userNameBox);
		userNameBox.sendKeys(username1);
		passwordInputBox.sendKeys(password1);
		loginBTN.click();
		WaitFor.elementTobeVisible(errorMsg);
		errorMsg.isDisplayed();
		Assert.assertTrue(errorMsg.getText().contains("Invalid credentials"));
	}

	public void enterInvalidCredentialsUsingExcel(String username, String password) {
		WaitFor.elementTobeVisible(userNameBox);
		keyword.clickOn(userNameBox);
		userNameBox.sendKeys(username);
		passwordInputBox.sendKeys(password);
		loginBTN.click();
		WaitFor.elementTobeVisible(errorMsg);
		errorMsg.isDisplayed();
		Assert.assertTrue(errorMsg.getText().contains("Invalid credentials"));
		
	}
	
	private @FindBy(xpath = "//h5[text()='Login']")
	WebElement loginText;
	
	public String getLoginText() {
		WaitFor.elementTobeVisible(loginText);
		return loginText.getText();
	}
	

}
