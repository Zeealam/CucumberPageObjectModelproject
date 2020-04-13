package com.qa.stepDefinations;

import org.testng.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePageSteps extends TestBase{
	
	public LoginPage loginpage ;
	public HomePage homepage ;
	
	@Given("^user opens browser$")
	public void user_opens_browser()  {
		
		initialization();
	    
	}

	@Then("^user is on login page$")
	public void user_is_on_login_page()  {
		loginpage = new LoginPage();
	    String title=loginpage.validateLoginPageTitle();
	    Assert.assertEquals(title, "Guru99 Bank Home Page");
	}

	@Then("^user log in application$")
	public void log_in_application()  {
		homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
	    
	}

	@Then("^valiate home page title$")
	public void valiate_home_page_title() throws Throwable {
		String homepagetitle=homepage.validateHomePagetitle();
		Assert.assertEquals(homepagetitle, "Guru99 Bank Manager HomePage");  
	}
	
	@Then("^validate logged in username$")
	public void validate_logged_in_username() {
		boolean flag= homepage.verifiedCorrectUserName();
		Assert.assertTrue(flag);
	}
	
//	@Then("^logout from website$")
//	public void logout_from_website() {
//		homepage.logout();
//
//	}
//	@Then("^close browser$")
//	public void close_browser() {
//		loginpage.close_browser();
//		
//	}
	
	
	
//	@Given("^User open browser$")
//	public void user_open_browser()  {
//		initialization();
//	}
//
//	@Then("^user will log in application$")
//	public void user_will_log_in_application() {
//		homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
//	    
//
//	}

	@Then("^user click on New Customer option$")
	public void user_click_on_New_Customer_option()  {
		homepage.clickOnCustomer();
	    
	}
}
