package com.sid.mobile.cases;

import static org.testng.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sid.mobile.utils.DriverProvider;
import com.sid.mobile.utils.PropertyUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class DemoAppVerticalSwipeTest {
	AppiumDriver<MobileElement> driver;
	PropertyUtils prop = new PropertyUtils("src/test/resources/config.properties");
	WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {

		driver = DriverProvider.getAndroidMobileDriverTemp();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
	}

	@Test(enabled = true)
	public void testDemoAppVerticalSwipe() throws InterruptedException {

		MobileElement loginBtn = driver.findElement(MobileBy.AccessibilityId("login"));

		loginBtn.click();

		MobileElement header = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView");

		System.out.println("Header TEXT :" + header.getText());

		Thread.sleep(2000);

		MobileElement btnNativeView = driver.findElement(MobileBy.AccessibilityId("chainedView"));
		MobileElement btnSlider = driver.findElement(MobileBy.AccessibilityId("slider1"));
		MobileElement btnVerticalSwipe = driver.findElement(MobileBy.AccessibilityId("verticalSwipe"));
		MobileElement btnDragAndDrop = driver.findElement(MobileBy.AccessibilityId("dragAndDrop"));
		MobileElement btnDoubleTap = driver.findElement(MobileBy.AccessibilityId("doubleTap"));
		MobileElement btnLongPress = driver.findElement(MobileBy.AccessibilityId("longPress"));
		MobileElement btnPhotoView = driver.findElement(MobileBy.AccessibilityId("photoView"));

		btnVerticalSwipe.click();

		// Code to scroll to specific element

		/*
		 * Dimension size = driver.manage().window().getSize();
		 * 
		 * int startX = size.width / 2; int startY = (int) (size.height * 0.60); int
		 * endY = (int) (size.height * 0.30);
		 * 
		 * 
		 * AndroidTouchAction action = new AndroidTouchAction(driver);
		 * 
		 * action.moveTo(PointOption.point(startX,
		 * endY)).press(PointOption.point(startX, startY))
		 * .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(
		 * PointOption.point(startX, endY)) .release().perform();
		 */

		MobileElement list = driver.findElement(MobileBy.AccessibilityId("listview"));

		MobileElement listGroup = list.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\" Jasmine\"));"));
		assertNotNull(listGroup.getLocation());

		listGroup.click();

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.closeApp();
		driver.quit();
	}

}
