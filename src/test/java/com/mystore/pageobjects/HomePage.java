package com.mystore.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	By span_myaccount_loc = By.xpath("//span[text()='My Account']");
	WebElement myaccount = driver.findElement(span_myaccount_loc);
	By a_register_loc = By.xpath("//a[text()='Register']");
	WebElement register = driver.findElement(a_register_loc);
	By a_login_loc = By.xpath("//a[text()='Login']");
	WebElement login = driver.findElement(a_login_loc);
	
	public void clickMyAccount() {
		myaccount.click();
	}
	public void clickRegister() {
		register.click();
	}
	public void clickLogin() {
		login.click();
	}
}
