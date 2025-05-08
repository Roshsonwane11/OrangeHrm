package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.base.Keyword;
import com.hrm.base.WaitFor;

public class PersonalInformationManagementPage {
	Keyword keyword = new Keyword();
	
	@FindBy(xpath= "//ul[@class=\"oxd-main-menu\"]/li[2]")
	private WebElement pimModule;
	
	public PersonalInformationManagementPage(){
		PageFactory.initElements(Keyword.driver, this);
	}
	public void clickOnPIM() {
		WaitFor.elementTobeVisible(pimModule);
		keyword.clickOn(pimModule);
		
		
	}

}
