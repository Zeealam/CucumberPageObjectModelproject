package com.qa.stepDefinations;

import org.testng.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageStep extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	@Given("^Open the browser$")
	public void open_the_browser() {
		initialization();
	}

	@When("^title of the login page is$")
	public void title_of_the_login_page_is() {
		loginpage = new LoginPage();
		String validatetitle = loginpage.validateLoginPageTitle();
		Assert.assertEquals(validatetitle, "Guru99 Bank Home Page");

	}

	@Then("^user enter \"([^\"]*)\"and \"([^\"]*)\"$")
	public void user_enter_and(String username, String password) {
		loginpage.login(username, password);

	}

	@Then("^user is on home page$")
	public void user_is_not_home_page() {
		homepage= new HomePage();
		String title = homepage.validateHomePagetitle();
		Assert.assertEquals(title, "Guru99 Bank Manager HomePage");
	}

	@Then("^logout from the website$")
	public void logout_from_the_website() {
		homepage.logout();

	}
	@Then("^close the browser$")
	public void close_the_browser() {
		loginpage.close_browser();
		
	}

}
