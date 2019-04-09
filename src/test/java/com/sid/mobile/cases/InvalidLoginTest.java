package com.sid.mobile.cases;

import org.testng.annotations.Test;
import com.sid.mobile.core.BaseTest;

public class InvalidLoginTest extends BaseTest {

	@Test
	public void inValidLogin() {
		String loginUrl = prop.getValue("login_url");
		pages.homePage.goToUrl(loginUrl);

		pages.homePage.verifyTitle(prop.getValue("homepage_title"));

		pages.homePage.clickSignInLink();
		pages.loginPage.verifyTitle(prop.getValue("loginpage_title"));

		pages.loginPage.login(prop.getValue("username"), "Invalid Password");

		pages.loginPage.verifyErrorMsg("There is 1 error\n" + "Authentication failed.");

	}

}
