package com.hrm.steps;

import com.hrm.base.Keyword;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	Keyword keyword=new Keyword();
	@Before
	public void setUp() {
		keyword.openBrowser("chrome");
		keyword.launchUrl("https://opensource-demo.orangehrmlive.com/");
	}
	
	@After
	public void tearDown() {
		keyword.quitBrowser();
	}
}
