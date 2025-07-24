package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class CreateAccountPage extends ProjectSpecificMethods {

	public CreateAccountPage enterAccountName(String accName) {
		clearAndType(locateElement(Locators.XPATH, "//label[text()='Account Name']/following::input"), accName);
		reportStep(accName + " Account name is entered successfully", "pass");
		return this;
	}

	public CreateAccountPage clickOwnership(String ownership) {
		click(locateElement(Locators.XPATH, "//button[@aria-label='Ownership']"));
		reportStep(" Ownership list box is selected successfully ", "pass");
		return this;
	}

	public AccountsPage clickOwnershipValue(String ownership) {
		click(locateElement(Locators.XPATH, "//lightning-base-combobox-item[@data-value='" + ownership + "']"));
		reportStep(" Ownership list box value is selected successfully  as " + ownership, "pass");
		return new AccountsPage();
	}

}
