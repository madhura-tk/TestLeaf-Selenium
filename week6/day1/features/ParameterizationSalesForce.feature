Feature: Editing a Account in SalesForce Application

Scenario: Verifying the editing a account in SalesForce Application Successfully

	When the user enters the username  as 'vidyar@testleaf.com'
	And the user enters the password as 'Sales@123'
	When the user clicks the login button
	Then the user should be navigated to the SalesForce Home Page
	When the user clicks the App Launcher Icon
	And the User clicks the View All link
	And the user scroll down the window
	And the user clicks the Accounts link
	Then the user navigates to the Accounts page
	When the user types the name in the Search box as 'madhura'
	And the user clicks the dropdown of the first account from the result
	And the user clicks the Edit option
	Then the user navigates to the Edit page
	When the user selects the Type as  'Technology Partner'
	And the user sets the Industry as  'Healthcare'
	And the user enters the Billing address as  'TestLeaf  Address'
	And the user enters the Shipping address as  'TestLeaf  Address'
	And the user sets the CustomerPriority as  'Low'
	And the user sets the SLA as  'Silver'
	And the user sets the Active as  'No'
	And the user enters the phoneno as  1234567890
	And the user sets the UpSellOpp as 'No'
	Then the user clicks the Save button
	And the user verifies the phoneno

Scenario Outline:
When the user enters the username  as 'vidyar@testleaf.com'
	And the user enters the password as 'Sales@123'
	When the user clicks the login button
	Then the user should be navigated to the SalesForce Home Page
	When the user clicks the App Launcher Icon
	And the User clicks the View All link
	And the user scroll down the window
	And the user clicks the Accounts link
	Then the user navigates to the Accounts page
	When the user types the name in the search box as <acctname>
	And the user clicks the dropdown of the first account from the result
	And the user clicks the Edit option
	Then the user navigates to the Edit page
	When the user selects the ownership as <ownership>
	Then the user clicks the Save button
	And the user verifies the account name
	
	
	Examples:
	|acctname|ownership|
	|madhura|Public|
	|madhura|Private|
	