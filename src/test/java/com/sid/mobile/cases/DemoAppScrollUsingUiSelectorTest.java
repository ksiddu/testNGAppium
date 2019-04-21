package com.sid.mobile.cases;

import static org.testng.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sid.mobile.utils.DriverProvider;
import com.sid.mobile.utils.PropertyUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class DemoAppScrollUsingUiSelectorTest {
	public AppiumDriver<WebElement> driver;
	PropertyUtils prop = new PropertyUtils("src/test/resources/config.properties");
	WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {

		driver = DriverProvider.getAndroidDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
	}

	@Test(enabled = true)
	public void testDemoAppScrollUsingUiSelector() throws InterruptedException {
		MobileElement loginBtn = (MobileElement) driver.findElement(MobileBy.AccessibilityId("login"));

		loginBtn.click();

		MobileElement list = (MobileElement) driver.findElement(MobileBy.AccessibilityId("scrollView"));

		MobileElement listGroup = list.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"Web View\"));"));
		assertNotNull(listGroup.getLocation());

		listGroup.click();

		/*
		 * String text = "Web View";
		 * 
		 * MobileElement ele = (MobileElement)
		 * driver.findElement(MobileBy.AndroidUIAutomator(
		 * "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
		 * + text + "\").instance(0))"));
		 * 
		 * ele.click();
		 */

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.closeApp();
		driver.quit();
	}

}
