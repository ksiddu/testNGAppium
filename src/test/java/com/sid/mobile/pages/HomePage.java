package com.sid.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.sid.mobile.core.BasePage;
import io.appium.java_client.AppiumDriver;

public class HomePage extends BasePage {

	public HomePage(AppiumDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Sign in")
	private WebElement linkSignIn;

	public void clickSignInLink() {
		linkSignIn.click();
	}

}
