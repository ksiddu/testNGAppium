package com.sid.mobile.cases;

import java.net.MalformedURLException;
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
import io.appium.java_client.touch.offset.ElementOption;

public class DemoAppDragAndDropTest {
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
	public void testDemoAppDragAndDrop() throws InterruptedException {

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

		btnDragAndDrop.click();

		// Code to drag & drop with Java-Client:7.0.0

		MobileElement from = driver.findElement(MobileBy.AccessibilityId("dragMe"));
		MobileElement to = driver.findElementByAccessibilityId("dropzone");

		AndroidTouchAction touch = new AndroidTouchAction(driver);

		touch.longPress(ElementOption.element(from)).moveTo(ElementOption.element(to)).release().perform();

		MobileElement msgSuccess = driver.findElementByAccessibilityId("success");

		Assert.assertEquals(msgSuccess.getText(), "Circle dropped");

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.closeApp();
		driver.quit();
	}

}
