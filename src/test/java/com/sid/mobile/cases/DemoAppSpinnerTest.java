package com.sid.mobile.cases;

import static org.testng.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.sid.mobile.utils.DriverProvider;
import com.sid.mobile.utils.PropertyUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class DemoAppSpinnerTest {
	public AppiumDriver<WebElement> driver;
	PropertyUtils prop = new PropertyUtils("src/test/resources/config.properties");
	WebDriverWait wait;
	private static final Logger log = Logger.getLogger(DemoAppSpinnerTest.class);

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
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"Wheel Picker\"));"));
		assertNotNull(listGroup.getLocation());

		listGroup.click();

		MobileElement spinner = (MobileElement) driver.findElement(MobileBy.className("android.widget.Spinner"));

		spinner.click();

		List<WebElement> listOfOptions = (List<WebElement>) driver.findElements(MobileBy.id("android:id/text1"));

		listOfOptions.get(2).click();

		WebElement selectedColor = driver.findElement(MobileBy.id("android:id/text1"));

		List<WebElement> listOfTextViews = (List<WebElement>) driver
				.findElements(MobileBy.className("android.widget.TextView"));

		Assert.assertEquals(listOfTextViews.get(0).getText(), " Current Color: blue ");

		log.debug("CURRENT COLOR: " + listOfTextViews.get(0).getText());
		log.debug("SELECTED COLOR: " + selectedColor.getText());

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.closeApp();
		driver.quit();
	}

}
