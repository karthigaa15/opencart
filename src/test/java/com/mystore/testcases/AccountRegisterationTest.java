package com.mystore.testcases;

import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.AccountRegisterationPage;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.mystore.testbase.BaseClass;

public class AccountRegisterationTest extends BaseClass{
	
	@Test
	public void verify_account_registeration() {
		logger.info("****************Starting account registeration testcase*****************");
		try {
			
			HomePage homepage = new HomePage(driver);
			homepage.clickMyAccount();
			logger.info("Clicked my account");
			homepage.clickRegister();
			logger.info("Clicked Register");
			AccountRegisterationPage regpage = new AccountRegisterationPage(driver);
			logger.info("Started filling account registeration details");
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			String generatedEmail = randomString() + "@opencart.com";
			regpage.setEmail(generatedEmail);
			regpage.setTelephone(randomNumber());
			String generatedPassword = randomPassword();
			regpage.setPassword(generatedPassword);
			regpage.setConfirmPassword(generatedPassword);
			regpage.clickSubscribe();
			regpage.clickPrivacyPolicy();
			regpage.clickContinue();
			logger.info("completed filling  account registeration details");
			logger.info("Validating confirmation message");
			String getMsg = regpage.getMsgConfirmation();
			if(getMsg.equals("Success")) {
				Assert.assertTrue(true);
			}
			else {
				logger.error("Test fails");
				logger.debug("Debugging started");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		logger.info("****************completed account registeration testcase*****************");
		
		
	}
	
}
