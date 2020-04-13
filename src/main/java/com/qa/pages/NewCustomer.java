package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class NewCustomer extends TestBase {

	@FindBy(xpath = "//input[@name='name']")
	WebElement cname;

	@FindBy(name = "rad1")
	List<WebElement> gender;

	@FindBy(xpath = "//input[@name='dob']")
	WebElement DBO;

	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement address;

	@FindBy(xpath = "//input[@name='city']")
	WebElement city;

	@FindBy(xpath = "//input[@name='state']")
	WebElement state;

	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pin;

	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement mobilenumber;

	@FindBy(xpath = "//input[@name='emailid']")
	WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//input[@type='reset']")
	WebElement reset;

	public NewCustomer() {
		PageFactory.initElements(driver, this);
	}

	public void addCustomerDetaild(String Customername, String dob, String Address, String City, String State,
			String Pin, String mobileno, String Email, String Password) {
		cname.sendKeys(Customername);
		selectGender();
		DBO.sendKeys(dob);
		address.sendKeys(Address);
		city.sendKeys(City);
		state.sendKeys(State);
		pin.sendKeys(mobileno);
		email.sendKeys(Email);
		password.sendKeys(Password);
		submit.click();

	}

	public void selectGender() {
		// Create a boolean variable which will hold the value (True/False)
		boolean bValue = false;
		// This statement will return True, in case of first Radio button is selected
		bValue = gender.get(0).isSelected();
		// This will check that if the bValue is True means if the first radio button is
		// selected
		if (bValue == true) {
			// This will select Second radio button, if the first radio button is selected
			// by default
			gender.get(1).click();
		} else
			// If the first radio button is not selected by default, the first will be
			// selected
			gender.get(0).click();
	}

	public String validateCustomerPageTitle() {
		return driver.getTitle();
	}

}
