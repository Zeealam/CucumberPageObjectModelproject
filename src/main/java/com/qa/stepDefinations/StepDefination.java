package com.qa.stepDefinations;


import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.NewCustomer;
import com.qa.util.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefination extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	SoftAssert soft = new SoftAssert();
	NewCustomer newcustomer=null;

	@Given("^Open the browser and enter the url$")
	public void Open_the_browser_and_enter_the_url() {
		initialization();
		System.out.println("First");
	}

	@When("^User landed on Login Page$")
	public void User_landed_on_Login_Page() {
		loginpage = new LoginPage();
		String validatetitle = loginpage.validateLoginPageTitle();
		Assert.assertEquals(validatetitle, "Guru99 Bank Home Page");
		System.out.println("second");

	}

	@And("^User loged with \"([^\"]*)\"and \"([^\"]*)\"$")
	public void User_enter_and(String username, String password) {
		loginpage = new LoginPage();
		loginpage.login(username, password);
		System.out.println("third");

	}

	@And("^User landed on Home page$")
	public void User_landed_on_Home_page() {
		homepage = new HomePage();
		String title = homepage.validateHomePagetitle();
		Assert.assertEquals(title, "Guru99 Bank Manager HomePage");
		System.out.println("fourth");
	}

	@And("^Logout from the website$")
	public void Logout_from_the_website() {
		homepage = new HomePage();
		homepage.logout();
		System.out.println("five");

	}

	@Then("^Close the Browser$")
	public void Close_the_Browser() {
		loginpage = new LoginPage();
		loginpage.close_browser();
		System.out.println("six");
		soft.assertAll();

	}

	@Given("^Validate Username label$")
	public void validate_Username_label() {
		loginpage = new LoginPage();
		Boolean flag = loginpage.vaidateUserIDLabel();
		Assert.assertTrue(flag, "Username field is empth");

	}

	@Given("^Validate Password label$")
	public void validate_Password_label() {
		loginpage = new LoginPage();
		Boolean flag = loginpage.vaidatePasswordLabel();
		Assert.assertTrue(flag, "Password field is empth");

	}

	@Given("^Validate Reset button \"([^\"]*)\"and \"([^\"]*)\"$")
	public void validate_Reset_button_and(String username, String password) {

		loginpage = new LoginPage();
		loginpage.validateResetButton(username, password);

	}

	@Given("^User enter invalid loging credential\"([^\"]*)\"and \"([^\"]*)\"$")
	public void user_enter_invalid_loging_credential_and(String username, String password) {
		loginpage = new LoginPage();
		loginpage.login(username, password);

	}

	@Given("^Validate Invalid credential message$")
	public void validate_Invalid_credential_message() {
		loginpage = new LoginPage();
		loginpage.validateloginerrormessage();

	}

	@And("^validate logged in username$")
	public void validate_logged_in_username() {
		homepage = new HomePage();
		boolean flag = homepage.verifiedCorrectUserName();
		Assert.assertTrue(flag, "Username:mgr123");
	}

	@And("^logout from website$")
	public void logout_from_website() {
		homepage = new HomePage();
		homepage.logout();

	}

	@Then("^user click on New Customer option$")
	public void user_click_on_New_Customer_option() {
		newcustomer= new NewCustomer();
		newcustomer.clickOnCustomer();

	}

	@And("^Validate Menue List in Left Side$")
	public void Validate_Menue_List_in_Left_Side() {
		homepage = new HomePage();
		int listnumber = homepage.menuelist();

		soft.assertEquals(listnumber, 16);
		// soft.assertAll();
	}

	@And("^Click on each menue list in left side$")
	public void Click_on_each_menue_list_in_left_side() throws InterruptedException {
		homepage = new HomePage();
		homepage.menuelistClick();
	}
	
	@Given("^user is in new customer page$")
	public void user_is_in_new_customer_page() {
		String customerpagetitle = newcustomer.validateCustomerPageTitle();
		Assert.assertEquals(customerpagetitle, "Guru99 Bank New Customer Entry Page");

	}

	@Then("^enter the customer details and click on submit button$")
	public void enter_the_customer_details_and_click_on_submit_button(DataTable details) {

		List<List<String>> data = details.raw();
		newcustomer= new NewCustomer();
		newcustomer.addCustomerDetaild(data.get(0).get(0), data.get(0).get(1), data.get(0).get(2), data.get(0).get(3),
				data.get(0).get(4), data.get(0).get(5), data.get(0).get(6), data.get(0).get(7), data.get(0).get(8));

	}
	@When("^Click on new Customer link$")
	public void Click_on_new_Customer_link() {
		newcustomer= new NewCustomer();
		newcustomer.clickOnCustomer();
	}

}
