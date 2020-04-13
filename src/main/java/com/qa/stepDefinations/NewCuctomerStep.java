package com.qa.stepDefinations;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.qa.pages.NewCustomer;
import com.qa.util.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class NewCuctomerStep extends TestBase{
	
	NewCustomer newcustomer;

	@Given("^user is in new customer page$")
	public void user_is_in_new_customer_page()  {
		String customerpagetitle=newcustomer.validateCustomerPageTitle();
		Assert.assertEquals(customerpagetitle, "Guru99 Bank New Customer Entry Page");
	    
	}

	@Then("^enter the customer details$")
	public void enter_the_customer_details(DataTable details)  {
		for (Map<String, String> data : details.asMaps(String.class, String.class))
			 {
			//newcustomer.addCustomerDetaild(Customername, dob, Address, City, State, Pin, mobileno, Email, Password);
				data.get("CustomerName");
				data.get("Dateofbirth");
				data.get("Address");
				data.get("City");
				data.get("State");
				data.get("Pin");
				data.get("MobileNumber");
				data.get("E-mail");
				data.get("password");
			
			 }
	    
	}

	@Then("^Click on submit button$")
	public void click_on_submit_button()  {
	    
	}

}
