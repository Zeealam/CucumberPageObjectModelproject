package com.qa.stepDefinations;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.qa.pages.NewCustomer;
import com.qa.util.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class NewCuctomerStep extends TestBase {

	NewCustomer newcustomer=null;

	@Given("^user is in new customer page$")
	public void user_is_in_new_customer_page() {
		String customerpagetitle = newcustomer.validateCustomerPageTitle();
		Assert.assertEquals(customerpagetitle, "Guru99 Bank New Customer Entry Page");

	}

	@Then("^enter the customer details$")
	public void enter_the_customer_details(DataTable details) {

		List<List<String>> data = details.raw();
		newcustomer= new NewCustomer();
		newcustomer.addCustomerDetaild(data.get(0).get(0), data.get(0).get(1), data.get(0).get(2), data.get(0).get(3),
				data.get(0).get(4), data.get(0).get(5), data.get(0).get(6), data.get(0).get(7), data.get(0).get(8));

	}

	@Then("^Click on submit button$")
	public void click_on_submit_button() {

	}

}
