package com.hrm.pages;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	// @FindBy(xpath = "*//input[@type=\"file\"]/following-sibling::div")
	@FindBy(xpath = "//input[@type='file']")
	private WebElement uploadImg;
	@FindBy(xpath = "//div/span[text()='Required']")
	private List<WebElement> RequiredError;
	@FindBy(xpath = "//span[text()='Should not exceed 30 characters']")
	private WebElement firstNameLengthError;
	@FindBy(xpath = "//div[@class=\"orangehrm-employee-image\"]/div/span")
	private WebElement imagewithErrorMsg;
	@FindBy(xpath = "//span[text()='Should not exceed 30 characters']")
	private List<WebElement> erromsg30plusChar;

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

	public void enterfullname(String fName, String mName, String lName) {
		WaitFor.elementTobeVisible(firstName);
		firstName.click();
		firstName.sendKeys(fName);

		WaitFor.elementTobeVisible(middleName);
		middleName.click();
		middleName.sendKeys(mName);

		WaitFor.elementTobeVisible(lastName);
		lastName.click();
		lastName.sendKeys(lName);
	}

	public void setEmployeeID() throws InterruptedException {
		employeeId.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		employeeId.click();
		String uniqueId = String.valueOf((int) (Math.random() * 9000) + 1000); // Range: 1000-9999
		employeeId.sendKeys(uniqueId);
		System.out.println("Generated Employee ID: " + uniqueId);

	}

	public void setprofilePicture() throws InterruptedException {
         //for uploading file we need File file = new File(filePath);
		String filePath = System.getProperty("user.dir") + "/src/test/resources/Features/datafiles/photo.png";
		System.out.println("Resolved file path: " + filePath);
		File file = new File(filePath);
		System.out.println("File exists: " + file.exists()); // Add this for debugging

		uploadImg.sendKeys(file.getAbsolutePath());
	}

	public void clickOnSavebtn() {
		WaitFor.elementTobeVisible(saveBTN);
		saveBTN.click();

	}

	public void leaveFirstAndLastNameBlank() {
		WaitFor.elementTobeVisible(firstName);
		firstName.clear();
		lastName.clear();

	}

	public void isFirstNameRequiredErrorDisplayed() {
		boolean errorFound = false;
		for (WebElement error : RequiredError) {

			if (error.getText().contains("Required")) {
				System.out.println("Required error displayed: " + error.getText());
				errorFound = true;
				break;
			} else {
				throw new RuntimeException("Required error message was not displayed for First Name field.");
			}
		}

	}

	public void enterLongFirstName(String fName) {
		WaitFor.elementTobeVisible(firstName);
		firstName.click();
		firstName.sendKeys(fName);	
	}

	public void verifyFirstNameLengthErrorDisplayed() {
	    WaitFor.elementTobeVisible(firstNameLengthError);
	    String actualError = firstNameLengthError.getText();
	    if (!actualError.equalsIgnoreCase("Should not exceed 30 characters")) {
	        throw new AssertionError("Expected error not displayed. Found: " + actualError);
	    }
	}

	public void uploadImagewithLargerFile() {
		String filepath = System.getProperty("user.dir")+ "/src/test/resources/Features/datafiles/Image.jpg";
	    File file = new File(filepath);
	    uploadImg.sendKeys(file.getAbsolutePath());
	}

	public void validationErrorMessage() {
		WaitFor.elementTobeVisible(imagewithErrorMsg);
		if(imagewithErrorMsg.getText() == "Attachment Size Exceeded") {
			Assert.assertTrue(imagewithErrorMsg.getText().contains("Attachment Size Exceeded"));
		}else if (imagewithErrorMsg.getText() == "File type not allowed") {
			Assert.assertTrue(imagewithErrorMsg.getText().contains("File type not allowed"));
		}
	}

	public void uploadImagewithpdf() {
		String filepath = System.getProperty("user.dir")+"/src/test/resources/Features/datafiles/imagepdf.pdf";
		File file = new File(filepath);
		uploadImg.sendKeys(file.getAbsolutePath());
	}

	public void entermorethan30char(String name){
		WaitFor.elementTobeVisible(firstName);
        firstName.sendKeys(name);
        lastName.sendKeys(name);	
	}

	public void erromsg30plusChar(String s) {
		for(WebElement erromsg30plusChar1: erromsg30plusChar) {
			String result= erromsg30plusChar1.getText();
			System.out.println(result);
			assertTrue(result.contains("Should not exceed 30 characters"));
		}
		
	}


}
