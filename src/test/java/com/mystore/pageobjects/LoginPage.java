package com.mystore.pageobjects;
import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	By input_email_loc = By.xpath("//input[@name='email'][@type='text']");
	By input_password_loc = By.xpath("//input[@name='password'][@type='password']");
	By input_login_loc = By.xpath("//input[@type='submit'][@value='Login']");
	
	public void setEmail(String email) {
		System.out.println("Email field displayed: " + driver.findElement(input_email_loc).isDisplayed());
		
		driver.findElement(input_email_loc).sendKeys(email);
		
	}
	public void setPassword(String password) {
		driver.findElement(input_password_loc).sendKeys(password);
	}
	public void clickLogin() {
		driver.findElement(input_login_loc).click();
	}
}
