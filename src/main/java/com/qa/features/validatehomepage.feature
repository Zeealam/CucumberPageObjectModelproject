Feature: Home Page of Grue99 bank 

Scenario Outline: Validate Username in Home Page 

	Given Open the browser and enter the url 
	And User loged with "<username>"and "<password>" 
	And validate logged in username 
	And logout from website 
	Then Close the Browser 
	
	Examples: 
		|username|password|
		|mgr123|mgr!23|
		
		
Scenario Outline: Validate the list of Menue in Left side 

	Given Open the browser and enter the url 
	And User loged with "<username>"and "<password>" 
	And Validate Menue List in Left Side 
	And logout from website 
	Then Close the Browser
	
	Examples: 
		|username|password|
		|mgr123|mgr!23|
		
	
	
Scenario Outline: Validate New Customer Page 

	Given Open the browser and enter the url
	And User loged with "<username>"and "<password>" 
	And Click on each menue list in left side
	And logout from website 
	Then Close the Browser
	
	Examples: 
		|username|password|
		|mgr123|mgr!23|
	
	