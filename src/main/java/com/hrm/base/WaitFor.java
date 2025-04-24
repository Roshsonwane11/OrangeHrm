package com.hrm.base;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {
	public static WebDriverWait wait;
	static {
		wait = new WebDriverWait(Keyword.driver, Duration.ofSeconds(20));
	}

	public static void elementTobeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	 public static void untilUrlLoad(String url) {
			WebDriverWait wait1 = new WebDriverWait(Keyword.driver, Duration.ofSeconds(10));
			wait1.until(ExpectedConditions.urlContains(url));

		}
}
