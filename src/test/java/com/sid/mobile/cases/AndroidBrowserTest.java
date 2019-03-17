package com.sid.mobile.cases;

import org.testng.annotations.Test;

import com.sid.mobile.utils.DriverProvider;
import com.sid.mobile.utils.PropertyUtils;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AndroidBrowserTest {
	AppiumDriver<WebElement> driver;
	PropertyUtils prop = new PropertyUtils();
	WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {

		driver = DriverProvider.getAndroidBrowserDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
	}

	@Test
	public void testLoginWithValidCredentials() throws InterruptedException {

		String loginUrl = prop.getValue("login_url");
		driver.get(loginUrl);

		WebElement signInLink = driver.findElement(By.linkText("Sign in"));

		System.out.println("HOME PAGE TITLE: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), prop.getValue("homepage_title"));

		signInLink.click();
		System.out.println("LOGIN PAGE TITLE: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), prop.getValue("loginpage_title"));

		WebElement userName = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("passwd"));
		WebElement button = driver.findElement(By.id("SubmitLogin"));

		userName.sendKeys(prop.getValue("username"));
		password.sendKeys(prop.getValue("password"));

		wait.until(ExpectedConditions.elementToBeClickable(button));
		button.click();

		System.out.println("Login details entered - testLoginWithValidCredentials()");
		System.out.println("============================================");

		System.out.println("DASHBOARD PAGE TITLE: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), prop.getValue("dashboardpage_title"));

		WebElement signOutBtn = driver.findElement(By.cssSelector(".logout"));
		signOutBtn.click();

		Assert.assertEquals(driver.getTitle(), prop.getValue("loginpage_title"));

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
