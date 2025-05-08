package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hrm.base.Keyword;
import com.hrm.base.WaitFor;

public class LeavePage {

	@FindBy(xpath = "//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")
	WebElement pageName;

	public void verifyUserNavigatesToLeavePage(String pageName, String defaultTabSelected) {

		WaitFor.untilUrlLoad("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");
		String url = Keyword.driver.getCurrentUrl();
		Assert.assertTrue(url.contains("viewLeaveList"));

		Assert.assertTrue(pageName.equalsIgnoreCase(pageName));
		System.out.println("user is on Leave page");
	}

}
