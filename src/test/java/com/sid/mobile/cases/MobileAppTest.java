package com.sid.mobile.cases;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sid.mobile.utils.DriverProvider;
import com.sid.mobile.utils.PropertyUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class MobileAppTest {
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
	public void testLoginWithValidCredentials() throws InterruptedException {

		// MobileElement loginBtn =
		// driver.findElementByXPath("//android.view.ViewGroup[@content-desc='login']");

		MobileElement loginBtn = driver.findElement(MobileBy.AccessibilityId("login"));

		loginBtn.click();

		MobileElement header = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView");

		System.out.println("Header TEXT :" + header.getText());

		Thread.sleep(2000);

		/*
		MobileElement btnNativeView = driver.findElementByAccessibilityId("chainedView");
		MobileElement btnSlider = driver.findElementByAccessibilityId("slider1");
		MobileElement btnVerticalSwipe = driver.findElementByAccessibilityId("verticalSwipe");
		MobileElement btnDragAndDrop = driver.findElementByAccessibilityId("dragAndDrop");
		MobileElement btnDoubleTap = driver.findElementByAccessibilityId("doubleTap");
		MobileElement btnLongPress = driver.findElementByAccessibilityId("longPress");
		MobileElement btnPhotoView = driver.findElementByAccessibilityId("photoView");
		*/
		
		MobileElement btnNativeView = driver.findElement(MobileBy.AccessibilityId("chainedView"));
		MobileElement btnSlider = driver.findElement(MobileBy.AccessibilityId("slider1"));
		MobileElement btnVerticalSwipe = driver.findElement(MobileBy.AccessibilityId("verticalSwipe"));
		MobileElement btnDragAndDrop = driver.findElement(MobileBy.AccessibilityId("dragAndDrop"));
		MobileElement btnDoubleTap = driver.findElement(MobileBy.AccessibilityId("doubleTap"));
		MobileElement btnLongPress = driver.findElement(MobileBy.AccessibilityId("longPress"));
		MobileElement btnPhotoView = driver.findElement(MobileBy.AccessibilityId("photoView"));

		System.out.println("=======================================");

		System.out.println("Label 1 :" + btnNativeView.getAttribute("text"));

		System.out.println("Label 2 :" + btnSlider.getAttribute("text"));

		System.out.println("Label 3 :" + btnVerticalSwipe.getAttribute("text"));

		System.out.println("Label 4 :" + btnDragAndDrop.getAttribute("text"));

		System.out.println("Label 5 :" + btnDoubleTap.getAttribute("text"));

		System.out.println("Label 6 :" + btnLongPress.getAttribute("text"));

		System.out.println("Label 7 :" + btnPhotoView.getAttribute("text"));

		System.out.println("=======================================");

		//List<MobileElement> list1 = driver.findElementsByClassName("android.view.ViewGroup");

		//list1.get(4).click();
		
		btnNativeView.click();

		List<MobileElement> list2 = driver.findElementsByClassName("android.widget.TextView");

		System.out.println("LIST SIZE  On Clicking : " + list2.size());

		System.out.println("Label On Clicking : " + list2.get(4).getText());

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
