Feature: Create New Customer in Grue99

Scenario Outline: Validate New Customer Page 

	Given Open the browser and enter the url
	And User loged with "<username>"and "<password>"
	When Click on new Customer link
	Then enter the customer details and click on submit button

|CustomerName|Dateofbirth|Address|City   |State|Pin   |MobileNumber|E-mail       |password|
|Zeeshan     |21-12-1212      |PK     |Kolkata|WB   |700039|9916188310  |zee@gmail.com|123456  S|


Examples: 
		|username|password|
		|mgr123|mgr!23|