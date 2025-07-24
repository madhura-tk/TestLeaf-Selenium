package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {

	/*
	 * public HomePage verifyHomePage() {
	 * 
	 * verifyTitle("Home | Salesforce"); reportStep("Homepage is loaded", "pass");
	 * return this; }
	 */

	public HomePage clickAppLauncher() {
		click(locateElement(Locators.XPATH, "//div[@class='slds-icon-waffle']"));
		reportStep("App Launcher Icon is clicked", "pass");
		return this;
	}

	public HomePage clickViewAll() {
		click(locateElement(Locators.XPATH, "//button[text()='View All']"));
		reportStep("View All link is clicked", "pass");
		return this;
	}

	public AccountsPage clickSales() {
		click(locateElement(Locators.XPATH, "//p[text()='Sales']/ancestor::a"));
		reportStep("Sales link is clicked", "pass");
		return new AccountsPage();
	}

}
