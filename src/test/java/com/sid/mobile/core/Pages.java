package com.sid.mobile.core;

import org.openqa.selenium.WebElement;
import com.sid.mobile.pages.DashBoardPage;
import com.sid.mobile.pages.HomePage;
import com.sid.mobile.pages.LoginPage;
import io.appium.java_client.AppiumDriver;

public class Pages {

	public HomePage homePage;
	public LoginPage loginPage;
	public DashBoardPage dashBoardPage;

	public Pages(AppiumDriver<WebElement> driver) {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);

	}

}
