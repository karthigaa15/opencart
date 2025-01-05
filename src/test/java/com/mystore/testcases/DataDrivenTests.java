package com.mystore.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.MyAccountPage;
import com.mystore.testbase.BaseClass;
import com.mystore.utilities.DataProviders;

public class DataDrivenTests extends BaseClass{
	/*
	  Data is valid  - login success - test pass  - logout
	  login failed - test fail
      Data is invalid - login success - test fail  - logout
	  login failed - test pass
    */
	
@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
public void verify_loginDDT(String email, String pwd, String result) throws InterruptedException {
	logger.info("****************DataDrivenTests started******************");
	
	try {

		HomePage homepage=new HomePage(driver);
		logger.info("Clicking My Account...");
		homepage.clickMyAccount();

		logger.info("Clicking Login...");
		homepage.clickLogin();
		
		LoginPage loginpage=new LoginPage(driver);
		logger.info("Entering email: " + email);
		loginpage.setEmail(email);

		logger.info("Entering password: " + pwd);
		loginpage.setPassword(pwd);

		logger.info("Clicking Login button...");
		loginpage.clickLogin();

		MyAccountPage myaccountpage=new MyAccountPage(driver);
		boolean targetPage=myaccountpage.isMyAccountPageExists();
		if(result.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{	
			    myaccountpage.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(result.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				myaccountpage.clickLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());

		}	 
			logger.info("****************** DataDrivenTests completed!******************");
		}
	}