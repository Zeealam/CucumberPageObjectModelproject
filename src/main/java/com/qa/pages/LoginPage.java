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
	WebElement login;

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd) {
		
			username.sendKeys(un);
			password.sendKeys(pwd);
			login.click();
			return new HomePage();
	}
	
	public void close_browser() {
		driver.quit();
	}
}
