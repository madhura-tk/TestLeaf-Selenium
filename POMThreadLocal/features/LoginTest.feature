Feature: Verifying the login funtionality of the CRM application 

Scenario: The user tries to login with the valid credentials 

	When the user enters the username as demosalesmanager 
	And the user enters the password as crmsfa 
	And the user clicks the login button 
	
Scenario: The user tries to create a new lead using the valid credentials 
	When the user enters the username as demosalesmanager 
	And the user enters the password as crmsfa 
	And the user clicks the login button 
	And the user clicks the crmsfa link 
	And the user clicks the leads module 
	And the user clicks the create lead from the shortcuts menu 
	When the user enters the company name 
	And the user enters the firstname 
	And the user enters the lastname 
	And the user enters the phoneno 
	Then the user clicks the submit button 
	Then the user verify th e status of lead creation
	
	
	
