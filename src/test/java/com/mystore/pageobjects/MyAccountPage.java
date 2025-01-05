package com.mystore.pageobjects;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	By tag_accountlogin_loc = By.xpath("//h2[text()='My Account']");
	By a_logout_loc = By.xpath("//a[text()='Logout'][@class='list-group-item']");
	By tag_accountlogout_loc = By.xpath("//h1[text()='Account Logout']");
	
	WebElement loginAccount = driver.findElement(tag_accountlogin_loc);

	public boolean isMyAccountPageExists()
	{
		try
		{
		return (loginAccount.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void clickLogout() {
		wait.until(ExpectedConditions.presenceOfElementLocated(a_logout_loc));
		driver.findElement(a_logout_loc).click();
	}
	
	public String verifyLogoutAccount() {
		try {
		    wait.until(ExpectedConditions.presenceOfElementLocated(tag_accountlogin_loc));
		    String logoutAccount = driver.findElement(tag_accountlogin_loc).getText();
			return logoutAccount;
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
}
