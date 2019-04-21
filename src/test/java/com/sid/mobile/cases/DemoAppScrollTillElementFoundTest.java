package com.sid.mobile.cases;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import io.appium.java_client.touch.offset.PointOption;

public class DemoAppScrollTillElementFoundTest {
	public AppiumDriver<WebElement> driver;
	PropertyUtils prop = new PropertyUtils("src/test/resources/config.properties");
	WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {

		driver = DriverProvider.getAndroidDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
	}

	@Test(enabled = true)
	public void testDemoAppScrollTillElementFound() throws InterruptedException {
		MobileElement loginBtn = (MobileElement) driver.findElement(MobileBy.AccessibilityId("login"));

		loginBtn.click();

		while (getWebViews().size() == 0) {
			scrollDown();
		}

		if (getWebViews().size() > 0) {
			getWebViews().get(0).click();
		}

	}

	public void scrollDown() {

		Dimension dimension = driver.manage().window().getSize();

		Double scrollHeightStart = dimension.getHeight() * 0.5;
		int scrollStart = scrollHeightStart.intValue();

		Double scrollHeightEnd = dimension.getHeight() * 0.2;
		int scrollEnd = scrollHeightEnd.intValue();

		AndroidTouchAction action = new AndroidTouchAction(driver);
		action.press(PointOption.point(0, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(0, scrollEnd)).release().perform();

	}

	public List<WebElement> getWebViews() {
		return driver.findElements(By.xpath("//android.widget.TextView[@text='Web View']"));

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.closeApp();
		driver.quit();
	}

}
