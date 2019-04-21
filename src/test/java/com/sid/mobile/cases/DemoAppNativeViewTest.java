package com.sid.mobile.cases;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.sid.mobile.utils.DriverProvider;
import com.sid.mobile.utils.PropertyUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class DemoAppNativeViewTest {
	AppiumDriver<MobileElement> driver;
	PropertyUtils prop = new PropertyUtils("src/test/resources/config.properties");
	WebDriverWait wait;

	private static final Logger log = Logger.getLogger(DemoAppNativeViewTest.class);

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

		Thread.sleep(2000);

		MobileElement btnNativeView = driver.findElement(MobileBy.AccessibilityId("chainedView"));
		MobileElement btnSlider = driver.findElement(MobileBy.AccessibilityId("slider1"));
		MobileElement btnVerticalSwipe = driver.findElement(MobileBy.AccessibilityId("verticalSwipe"));
		MobileElement btnDragAndDrop = driver.findElement(MobileBy.AccessibilityId("dragAndDrop"));
		MobileElement btnDoubleTap = driver.findElement(MobileBy.AccessibilityId("doubleTap"));
		MobileElement btnLongPress = driver.findElement(MobileBy.AccessibilityId("longPress"));
		MobileElement btnPhotoView = driver.findElement(MobileBy.AccessibilityId("photoView"));

		// go to Native View Page
		btnNativeView.click();

		List<MobileElement> listOfView = driver.findElementsByClassName("android.widget.TextView");

		log.debug("No. of Views: " + listOfView.size());

		log.debug("Header TEXT :" + listOfView.get(4).getText());

		log.debug(" for each loop elements ");
		log.debug("================================");
		for (MobileElement m : listOfView) {
			log.debug("Element Text " + m.getText());
		}
		log.debug("================================");

		log.debug(" for loop elements ");
		log.debug("================================");
		for (int i = 0; i < listOfView.size(); i++) {
			log.debug("Element " + i + " Text: " + listOfView.get(i).getText());
		}
		log.debug("================================");

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.closeApp();
		driver.quit();
	}

}
