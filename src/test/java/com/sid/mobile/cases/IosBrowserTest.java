package com.sid.mobile.cases;

import org.testng.annotations.Test;

import com.sid.mobile.utils.DriverProvider;
import com.sid.mobile.utils.PropertyUtils;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class IosBrowserTest {
	AppiumDriver<WebElement> driver;
	PropertyUtils prop = new PropertyUtils();

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {

		driver = DriverProvider.getIOSBrowserDriver();
	}

	@Test
	public void testLoginWithValidCredentials() {
		String loginUrl = prop.getValue("login_url");
		driver.get(loginUrl);

		// Web elements for login scenario
		WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		WebElement userName = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("passwd"));
		WebElement button = driver.findElement(By.className("SubmitLogin"));
		WebElement signOutBtn = driver.findElement(By.cssSelector(".logout"));

		System.out.println("MAIN PAGE TITLE: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "My Store");
		// My Store

		signInLink.click();

		System.out.println("LOGIN PAGE TITLE: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Login - My Store");
		// Login - My Store

		userName.sendKeys(prop.getValue("username"));
		password.sendKeys(prop.getValue("password"));
		button.click();

		System.out.println("Login details entered - testLoginWithValidCredentials()");
		System.out.println("============================================");
		// My account - My Store

		String expectedText = prop.getValue("homepage_title");
		String actualText = driver.getTitle();
		Assert.assertEquals(actualText, expectedText);

		signOutBtn.click();

		Assert.assertEquals(driver.getTitle(), "Login - My Store");

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
