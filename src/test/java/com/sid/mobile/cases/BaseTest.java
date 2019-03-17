package com.sid.mobile.cases;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import com.sid.mobile.utils.DriverProvider;

import io.appium.java_client.AppiumDriver;

public class BaseTest {

	private AppiumDriver<WebElement> driver;

	public AppiumDriver<WebElement> getDriver(String platform, String type) throws MalformedURLException {

		switch (platform) {
		case "android":
			if (type.contentEquals("browser")) {
				driver = DriverProvider.getAndroidBrowserDriver();
			} // else if (type.contentEquals("mobile")) {
				// driver = DriverProvider.getAndroidMobileDriver();
				// }

			break;
		case "ios":
			if (type.contentEquals("browser")) {
				driver = DriverProvider.getIOSBrowserDriver();
			} // else if (type.contentEquals("mobile")) {
				// driver = DriverProvider.getIOSMobileDriver();
				// }

			break;
		default:
			System.out.println("Invalid driver type!");
		}

		return driver;
	}

}
