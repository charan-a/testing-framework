Feature: Login into account
	exisiting user should be able to login into account using valid credentials
	
@login
Scenario: Login into account with correct credentials 
	Given User in login page
	#When User clicks on "SelectCountry" 
	#And User scroll to "Antarctica" and clicks it
	
	And User enters "Name" with data at "0" "1"
	   | Username | charan | alex |
	And User clicks home back button
	#And User selects the gender
	# | male | female |
	And User clicks on "Lets_Shop"
	Then User should be navigated to "productspage"
	And "addtocart" items "0" 
	And User clicks on "cartbutton"
	And User clicks on "sendmails"
	And User clicks on "procced_to_website"
	Then User should be navigated to "webpage"
	And check whether are we in webview
	And User enters "searchbox" with data at "0" "0"
	   | youtube | wikipedia | amazon|
	And User clicks on "search"
	And User clicks on "firstlink"
	
	