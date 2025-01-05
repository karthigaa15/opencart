package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.MyAccountPage;
import com.mystore.testbase.BaseClass;


public class LoginTest extends BaseClass {
	@Test
	public void verify_login() {
		logger.info("****************Login details*****************");
		try {
			HomePage homepage = new HomePage(driver);
			homepage.clickMyAccount();
			logger.info("Clicked my account");
			homepage.clickLogin();
			logger.info("Fill login details");			
			LoginPage loginpage = new LoginPage(driver);						
			loginpage.setEmail(p.getProperty("email"));
			loginpage.setPassword(p.getProperty("password"));
			loginpage.clickLogin();
			logger.info("Clicked login");
			
			MyAccountPage myaccountpage = new MyAccountPage(driver);
			boolean targetPage = myaccountpage.isMyAccountPageExists();
			logger.info("verify login status");
			Assert.assertTrue(targetPage);
			
			myaccountpage.clickLogout();
			
			String accountStatus = myaccountpage.verifyLogoutAccount();
			System.out.println(accountStatus);
			logger.info("Verify logout status");
			if(accountStatus.equals("Account Logout")) {
				logger.info("Loggedout successfully!");
				Assert.assertTrue(true);
			}
			else {
				logger.error("Loggout failed");
				Assert.assertTrue(false);
			}
			
		}
		catch(Exception e) {
			System.out.println("*****");
			Assert.fail();
			logger.info("***********************Login testcase completed!************************");
		}
	}
}
