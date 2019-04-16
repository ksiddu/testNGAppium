package com.sid.mobile.cases;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DemoAppDoubleTapTest {
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
	public void testDemoAppDoubleTap() throws InterruptedException {

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

		btnDoubleTap.click();

		AndroidTouchAction touch = new AndroidTouchAction(driver);
		MobileElement btnTap = driver.findElement(MobileBy.AccessibilityId("doubleTapMe"));

		/*
		 * TouchActions action = new TouchActions(driver); action.doubleTap(btnTap);
		 * action.perform();
		 */

		touch.press(ElementOption.element(btnTap)).release().perform()
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1))).press(ElementOption.element(btnTap))
				.release().perform();

		/*
		 * 
		 * TouchAction actionOne = new TouchAction(driver);
		 * actionOne.press(ElementOption.element(btnTap));
		 * actionOne.moveTo(ElementOption.element(btnTap)); actionOne.release();
		 * TouchAction actionTwo = new TouchAction(driver);
		 * actionTwo.press(ElementOption.element(btnTap));
		 * actionTwo.moveTo(ElementOption.element(btnTap)); actionTwo.release();
		 * MultiTouchAction action = new MultiTouchAction(driver);
		 * action.add(actionOne); action.add(actionTwo); action.perform();
		 */

		MobileElement title = driver.findElementById("android:id/alertTitle");
		MobileElement msgSuccess = driver.findElementById("android:id/message");
		MobileElement btnOK = driver.findElementById("android:id/button1");

		Assert.assertEquals(title.getText(), "Double Tap");
		Assert.assertEquals(msgSuccess.getText(), "Double tap successful!");
		Assert.assertEquals(btnOK.getText(), "OK");

		btnOK.click();

		Assert.assertTrue(btnTap.isDisplayed() && btnTap.isEnabled());

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.closeApp();
		driver.quit();
	}

}
