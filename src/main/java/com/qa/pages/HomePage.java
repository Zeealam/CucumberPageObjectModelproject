package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Manger Id : mgr123')]")
	WebElement userlabel;

	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	WebElement logout;
	//// a[text()='Log out']

	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement createcustomer;

	@FindBy(xpath = "//ul[@class='menusubnav']/li")
	List<WebElement> menuelistleftside;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePagetitle() {
		return driver.getTitle();
	}

	public boolean verifiedCorrectUserName() {
		return userlabel.isDisplayed();
	}

	public void logout() {
		logout.click();
	}

	public NewCustomer clickOnCustomer() {
		createcustomer.click();
		return new NewCustomer();

	}

	public int menuelist() {
		List<WebElement> elements = menuelistleftside;
		System.out.println("Menue list count: " + elements.size());
		int listcount = elements.size();
		return listcount;

	}

	public void menuelistClick() throws InterruptedException {
		List<WebElement> elements = menuelistleftside;
		System.out.println("Menue list count: " + elements.size());
		for (int i = 0; i < elements.size(); i++) {
			elements.get(i).click();
		}
		driver.navigate().back();
		Thread.sleep(400000);
	}
	
	

}
