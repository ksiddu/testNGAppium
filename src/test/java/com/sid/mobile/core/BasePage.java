package com.sid.mobile.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public abstract class BasePage {
	private static final int TIMEOUT = 5;
	private static final int POLLING = 100;

	protected AppiumDriver<WebElement> driver;
	protected WebDriverWait wait;

	public BasePage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(driver, this);
	}

	public void goToUrl(String url) {
		driver.get(url);
	}

	public void verifyTitle(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}

	public void verifyText(WebElement ele, String text) {
		Assert.assertEquals(ele.getText(), text);
	}

	public void scrollToAndClick(String text) {
		// String text = "Web View";

		MobileElement ele = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ text + "\").instance(0))"));

		ele.click();
	}

}
