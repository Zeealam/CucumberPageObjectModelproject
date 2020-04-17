Feature: Login page of Grue99 bank

Scenario Outline: Grue99 bank login Scenario

Given Open the browser and enter the url
When User landed on Login Page 
And User loged with "<username>"and "<password>"
And User landed on Home page
And Logout from the website
Then Close the Browser

Examples:
	|username|password|
	|mgr123|mgr!23|
	
	
Scenario Outline: Validate the Login Field and Reset button

Given Open the browser and enter the url
And Validate Username label
And Validate Password label
And Validate Reset button "<username>"and "<password>"

Examples:
	|username|password|
	|mgr123|mgr!23|
	
	

Scenario Outline: Validate invalid credential

Given Open the browser and enter the url
And User enter invalid loging credential"<username>"and "<password>"
And Validate Invalid credential message

Examples:
	|username|password|
	|mgr123|mgr!231|

	
	
	