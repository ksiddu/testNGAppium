package com.sid.mobile.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;

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

}
