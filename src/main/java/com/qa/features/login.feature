Feature: Login page of Grue99 bank

Scenario Outline: Grue99 bank login Scenario

Given Open the browser
When title of the login page is 
Then user enter "<username>"and "<password>"
Then user is on home page
Then logout from the website
Then close the browser

Examples:
	|username|password|
	|mgr123|mgr!23|
	