package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class DeleteAccountPage extends ProjectSpecificMethods {

	public AccountsPage clickDelete() {
		reportStep(" Delete Alert Window is appeared successfully ", "pass");
		click(locateElement(Locators.XPATH, "//button[@title='Delete']"));
		reportStep(" Delete Button is clicked successfully ", "pass");
		return new AccountsPage();
	}

}
