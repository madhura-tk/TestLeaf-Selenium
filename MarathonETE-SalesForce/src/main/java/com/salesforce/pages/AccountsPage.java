package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class AccountsPage extends ProjectSpecificMethods {

	public AccountsPage clickAccounts() {

		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='Accounts']"));
		reportStep(" Accounts tab is clicked successfully", "pass");
		return this;
	}

	public AccountsPage verifyAccountsPage() {

		verifyExactText(locateElement(Locators.XPATH, "//h1[text()='Accounts']"), "Accounts");
		reportStep("Accounts page is loaded", "pass");
		return this;
	}

	public CreateAccountPage clickNew() {

		click(locateElement(Locators.XPATH, "//a[@title='New']"));
		reportStep(" New button is clicked successfully", "pass");
		return new CreateAccountPage();
	}

	public AccountsPage enterSearchBox(String accName) {
		typeAndEnter(locateElement(Locators.XPATH, "//input[@placeholder='Search this list...']"), accName);
		reportStep(accName + " Account name is entered in the searchbox successfully", "pass");
		return this;
	}

	public AccountsPage selectFirstRecord() {
		
		moveToElement(locateElement(Locators.XPATH, "//table/tbody/tr[1]/td[6]"));
		pause(1000);
		click(locateElement(Locators.XPATH, "//table/tbody/tr[1]/td[6]"));
		pause(1000);
		reportStep(" First Record is selected successfully ", "pass");
		return this;
	}

	public EditAccountPage clickEditButton() {
		click(locateElement(Locators.XPATH, "//a[@title='Edit']"));
		reportStep(" Edit Option is selected successfully ", "pass");
		return new EditAccountPage();
	}

	public DeleteAccountPage clickDeleteButton() {
		click(locateElement(Locators.XPATH, "//a[@title='Delete']"));
		reportStep(" Action Option is selected successfully ", "pass");
		return new DeleteAccountPage();
	}

	public AccountsPage clickSave() {
		click(locateElement(Locators.XPATH, "//button[@name='SaveEdit']"));
		reportStep(" Save button is clicked successfully ", "pass");
		return this;
	}

	public AccountsPage verifyAccount(String acctName, String action) {

		verifyPartialText(locateElement(Locators.XPATH,
				"//span[@class='toastMessage slds-text-heading--small forceActionsText']"), acctName);
		if (action.equals("Create")) {
			reportStep(acctName + " Account is Created", "pass");
		} else if (action.equals("Edit")) {

			reportStep(acctName + " Account is Edited", "pass");

		}

		else if (action.equals("Delete")) {

			reportStep(acctName + " Account is Deleted", "pass");

		}

		else {
			reportStep(acctName + " No Action", "fail");

		}
		return this;
	}

}