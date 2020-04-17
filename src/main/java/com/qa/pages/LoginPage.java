package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class LoginPage extends TestBase {

	// Initializing the Page Object, driver, this initializing all the webelement.
	// automatically it will convated into all the webelement,driver.findelemet.
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='uid']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement loginbutton;

	@FindBy(xpath = "//td[text()='UserID']")
	WebElement UserIDlabel;

	@FindBy(xpath = "//td[text()='Password']")
	WebElement PasswordLabel;

	@FindBy(xpath = "//input[@name='btnReset']")
	WebElement Resetbutton;

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd) {

		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		return new HomePage();
	}

	public boolean vaidateUserIDLabel() {
		return UserIDlabel.isDisplayed();

	}

	public boolean vaidatePasswordLabel() {
		return PasswordLabel.isDisplayed();

	}

	public void validateResetButton(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Resetbutton.click();
		checkempthfield();
	}

	public void checkempthfield() {
		String uservalue = username.getAttribute("value");
		String passwordvalue = password.getAttribute("value");
		if (uservalue.isEmpty() && passwordvalue.isEmpty()) {
			System.out.println("Input field is empty");

		} else {
			String u = username.getAttribute("value");
			String p = password.getAttribute("value");
			System.out.println("Username value:" + u);
			System.out.println("Password value:" + p);

		}

	}

	public void validateloginerrormessage() {
		String text=driver.switchTo().alert().getText();
		System.out.println("Login Error Message: "+text);
		driver.switchTo().alert().accept();
	}
	
	public void close_browser() {
		driver.quit();
	}
}
