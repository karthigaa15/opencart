package com.mystore.testcases;
import org.testng.annotations.Test;

import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.testbase.BaseClass;

public class Login extends BaseClass {
	@Test
	public void verify_login() {
		logger.info("****************Login details*****************");
		{
			HomePage homepage = new HomePage(driver);
			homepage.clickMyAccount();
			homepage.clickLogin();
			LoginPage loginpage = new LoginPage(driver);
			loginpage.setEmail(p.getProperty("email"));
			loginpage.setPassword(p.getProperty("password"));
			loginpage.clickLogin();
		}
	}
}
