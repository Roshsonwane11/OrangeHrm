package com.hrm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.base.Keyword;
import com.hrm.base.WaitFor;

public class PersonalInformationManagementPage {
	Keyword keyword = new Keyword();

	@FindBy(xpath = "//ul[@class=\"oxd-main-menu\"]/li[2]")
	private WebElement pimModule;
	@FindBy(xpath = "//li[@class=\"oxd-topbar-body-nav-tab\"]/a[text()='Add Employee']")
	private WebElement addEmployee;
	@FindBy(xpath = "//input[@name=\"firstName\"]")
	private WebElement firstName;
	@FindBy(xpath = "//input[@name=\"middleName\"]")
	private WebElement middleName;
	@FindBy(xpath = "//input[@name=\"lastName\"]")
	private WebElement lastName;
	@FindBy(xpath = "//label[text()='Employee Id']/../following-sibling::div//input")
	private WebElement employeeId;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement saveBTN;
	@FindBy(xpath = "//div[@class=\"oxd-file-div oxd-file-div--active\"]/button[@type=\"button\"]")
	// @FindBy(xpath = "//input[@type=\"file\" and @class=\"oxd-file-input\"]")
	private WebElement uploadImg;

	public PersonalInformationManagementPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	public void clickOnPIM() {
		WaitFor.elementTobeVisible(pimModule);
		keyword.clickOn(pimModule);

	}

	public void clickOnAddEmployee() {
		WaitFor.elementTobeVisible(addEmployee);
		keyword.clickOn(addEmployee);
		WaitFor.elementTobeVisible(firstName);
	}

	public void enterfullname() {
		WaitFor.elementTobeVisible(firstName);
		firstName.click();
		firstName.sendKeys("Roshani");
		WaitFor.elementTobeVisible(middleName);
		middleName.click();
		middleName.sendKeys("Rajendra");
		WaitFor.elementTobeVisible(lastName);
		lastName.click();
		lastName.sendKeys("Sonawane");
	}

	public void setEmployeeID() throws InterruptedException {
		employeeId.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		employeeId.click();
		// employeeId.sendKeys("9272");
		String uniqueId = String.valueOf((int) (Math.random() * 9000) + 1000); // Range: 1000-9999
		employeeId.sendKeys(uniqueId);
		System.out.println("Generated Employee ID: " + uniqueId);

	}

	public void setprofilePicture() throws InterruptedException {

		WaitFor.elementTobeVisible(uploadImg);
		uploadImg.click();
		String filePath = System.getProperty("user.dir") + "/src/test/resources/Features/datafiles/photo.png";
		WaitFor.elementTobeVisible(uploadImg);
		uploadImg.sendKeys(filePath);

	}

	public void clickOnSavebtn() {
		WaitFor.elementTobeVisible(saveBTN);
		saveBTN.click();

	}

}
