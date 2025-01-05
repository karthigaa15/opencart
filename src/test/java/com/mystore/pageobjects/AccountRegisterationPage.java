package com.mystore.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountRegisterationPage extends BasePage{
	
	public AccountRegisterationPage(WebDriver driver) {
		super(driver);
	}
	By input_firstname_loc = By.id("input-firstname");
	By input_lastname_loc = By.id("input-lastname");
	By input_email_loc = By.id("input-email");
	By input_telephone_loc = By.id("input-telephone");
	By input_password_loc = By.id("input-password");
	By input_confirmpassword_loc = By.id("input-confirm");
	By radio_subscribe_loc = By.cssSelector("input[type='radio'][name='newsletter'][value='1']");
	By toggle_policy_loc = By.xpath("//input[@type='checkbox'][@name='agree']");
	By input_continue_loc = By.cssSelector("input[type='submit']");
	By a_msgconfirmation_loc = By.xpath("//a[text()='Success']");
	
	public void setFirstName(String firstName) {
		driver.findElement(input_firstname_loc).sendKeys(firstName);;
	}
	public void setLastName(String lastName) {
		driver.findElement(input_lastname_loc).sendKeys(lastName);
	}
	public void setEmail(String email) {
		driver.findElement(input_email_loc).sendKeys(email);
	}
	public void setTelephone(String telephone) {
		driver.findElement(input_telephone_loc).sendKeys(String.valueOf(telephone));
	}
	public void setPassword(String password) {
		driver.findElement(input_password_loc).clear();
		driver.findElement(input_password_loc).sendKeys(password);
	}
	public void setConfirmPassword(String confirmpassword) {
		driver.findElement(input_confirmpassword_loc).clear();
		driver.findElement(input_confirmpassword_loc).sendKeys(confirmpassword);
	}
	public void clickSubscribe() {
		driver.findElement(radio_subscribe_loc).click();
	}
	public void clickPrivacyPolicy() {
		driver.findElement(toggle_policy_loc).click();
	}
	public void clickContinue() {
		driver.findElement(input_continue_loc).click();
	}
	
	public String getMsgConfirmation() {
		try {
			String msgText = driver.findElement(a_msgconfirmation_loc).getText();
			return msgText;
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
}