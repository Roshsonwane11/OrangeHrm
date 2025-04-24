package com.hrm.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Keyword {
	public static RemoteWebDriver driver;

	public void openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Invald browser name");
		}
		System.out.println("Launched browser: " + browserName);
	}

	public void launchUrl(String url) {
		driver.get(url);
		System.out.println("Launched url: " + url);
		driver.manage().window().maximize();
	}

	public void clickOn(WebElement element) {
		element.click();

	}

	public void sendkeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();

	}
}
