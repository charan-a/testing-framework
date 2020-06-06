Feature: Login into account
	exisiting user should be able to login into account using valid credentials
	
@login
Scenario: Login into account with correct credentials 
	Given User in login page
	#When User clicks on "SelectCountry" 
	#And User scroll to "Antarctica" and clicks it
	And User enters "Name"
	 | Username | charan | alex |
	And User clicks home back button
	#And User selects the gender
	 | male | female |
	And User clicks on "Lets_Shop"
	Then "products" page should be displayed
	And "addtocart" items "0" 
	And User clicks on "cartbutton"
	