package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hrm.base.Keyword;
import com.hrm.base.WaitFor;

public class LeavePage {

	Keyword keyword = new Keyword();
	@FindBy(xpath = "//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")
	private WebElement pageName;

	@FindBy(xpath = "//div[@class=\"oxd-sidepanel-body\"]/ul/li[3]")
	private WebElement leaveMenu;

	@FindBy(xpath = "//div[@class=\"oxd-form-row\"][1]/div/div[1]/div/div[2]/div/div/input")
	private WebElement leaveFromDate;

	@FindBy(xpath = "//div[@class=\"oxd-form-row\"]/div/div[2]/div/div[2]/div/div/input")
	private WebElement leaveTodate;

	@FindBy(xpath = "//div[@class=\"orangehrm-header-container\"]/span")
	private WebElement noRecordFoundMessage;

	@FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")
	private WebElement searchButton;
	
	public LeavePage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	public void verifyUserNavigatesToLeavePage(String pageName, String defaultTabSelected) {

		WaitFor.untilUrlLoad("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");
		String url = Keyword.driver.getCurrentUrl();
		Assert.assertTrue(url.contains("viewLeaveList"));

		Assert.assertTrue(pageName.equalsIgnoreCase(pageName));
		System.out.println("user is on Leave page");
	}

	public void clickOnLeaveMenu(String menuName) {

		WaitFor.elementTobeVisible(leaveMenu);
		keyword.clickOn(leaveMenu);
	}

	public void selectLeaveFromDate(String fromDate) throws InterruptedException {
		WaitFor.elementTobeVisible(leaveFromDate);
		leaveFromDate.clear();
		leaveFromDate.sendKeys(fromDate);
		System.out.println("clicked on from date");

	}

	public void selectLeaveToDate(String toDate) {

		leaveTodate.clear();
		leaveTodate.sendKeys(toDate);
		System.out.println("clicked on to date");
	}

	public void verifyDateAcceptedFormat(String dateAcceptedFormat) {
		String dateFormatActual = leaveFromDate.getAttribute("placeholder");
		Assert.assertEquals(dateFormatActual, dateAcceptedFormat);

	}

	public void verifyNoRecordsFoundMessage(String NoRecordsExpectedMessage) {
		WaitFor.elementTobeVisible(noRecordFoundMessage);
		if (noRecordFoundMessage.isDisplayed()) {
			String noRecordFoundActualMessage = noRecordFoundMessage.getText();
			System.out.println(noRecordFoundActualMessage);
			Assert.assertEquals(noRecordFoundActualMessage, NoRecordsExpectedMessage);
		} else {
			Assert.assertFalse(noRecordFoundMessage.isDisplayed(), "Leave Records available");
		}
	}

	public String getFromDate() {
		String fromDate = leaveFromDate.getAttribute("placeholder");
		System.out.println(fromDate);
		return fromDate;
	}

	public String getToDate() {
		String toDate = leaveTodate.getAttribute("placeholder");
		System.out.println(toDate);
		return toDate;
	}

	public void verifyDefaultLeaveDates(String expectedFromdate, String expectedToDate) throws InterruptedException {

		Thread.sleep(3000);
		Assert.assertEquals(getFromDate(), expectedFromdate);
		Assert.assertEquals(getToDate(), expectedToDate);

	}

	public void clickOnSearchBtn(String searchButtonn) {

		WaitFor.elementToBeClick(searchButton);
		searchButton.click();
		
	}
}
