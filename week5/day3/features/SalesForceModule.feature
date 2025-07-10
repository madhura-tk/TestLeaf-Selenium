Feature: Create an Account in the SalesForce Application 

Scenario: Verifying the Successful Account Creation 
	
	Given the user establishes the Environment 
	Given the user loads the Url   
	When the user enters the Username  
	When the user enters the Password  
	When the user clicks the SFlogin button 
	Then the user should be navigated to the SalesForce Home page 
	When the user clicks the App Launcher Icon
	When the user clicks ViewAll
	Then the user scroll down the page
	When the user clicks the Accounts
	Then the user clicks the New Button
	When the user enters the account name
	And the user selects the ownership 
	When the user clicks the save button
	Then the user verifies the account name