package com.sid.mobile.core;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.sid.mobile.utils.DriverProvider;
import com.sid.mobile.utils.PropertyUtils;
import io.appium.java_client.AppiumDriver;

public abstract class BaseTest {

	protected AppiumDriver<WebElement> driver;
	protected PropertyUtils prop = new PropertyUtils("src/test/resources/config.properties");

	public AppiumDriver<WebElement> getDriver(String platform, String type) throws MalformedURLException {

		switch (platform) {
		case "android":
			if (type.contentEquals("browser")) {
				driver = DriverProvider.getAndroidBrowserDriver();
			} else if (type.contentEquals("mobile")) {
				// driver = DriverProvider.getAndroidMobileDriver();
			}

			break;
		case "ios":
			if (type.contentEquals("browser")) {
				driver = DriverProvider.getIOSBrowserDriver();
			} else if (type.contentEquals("mobile")) {
				// driver = DriverProvider.getIOSMobileDriver();
			}

			break;
		default:
			System.out.println("Invalid driver type!");
		}

		return driver;
	}

	@BeforeClass
	public void setup() {

		// Create a Chrome driver. All test classes use this.

		try {
			driver = getDriver(prop.getValue("platform"), prop.getValue("type"));
			// pages = new Pages(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Maximize Window
		// driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
