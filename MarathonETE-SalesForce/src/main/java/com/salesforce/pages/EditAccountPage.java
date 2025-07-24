package com.salesforce.pages;

import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class EditAccountPage extends ProjectSpecificMethods {

	public EditAccountPage selectType(String type) {
		// click(locateElement(Locators.XPATH, "//table/tbody/tr[1]/td[2]"));
		click(locateElement(Locators.XPATH, "//button[@aria-label='Type']"));
		reportStep(" Type menu is clicked successfully ", "pass");
		click(locateElement(Locators.XPATH, "//lightning-base-combobox-item[@data-value='" + type + "']"));
		reportStep(" Type Option is selected successfully as " + type, "pass");
		return this;
	}

	public EditAccountPage selectIndustry(String industry) {
		click(locateElement(Locators.XPATH, "//button[@aria-label='Industry']"));
		reportStep(" Industry menu is clicked successfully ", "pass");
		click(locateElement(Locators.XPATH, "//lightning-base-combobox-item[@data-value='" + industry + "']"));
		reportStep(" Industry Option is selected successfully as " + industry, "pass");
		return this;
	}

	public EditAccountPage selectCustPriority(String custPriority) {
		click(locateElement(Locators.XPATH, "//button[@aria-label='Customer Priority']"));
		reportStep(" CustomerPriority menu is clicked successfully ", "pass");
		click(locateElement(Locators.XPATH, "//lightning-base-combobox-item[@data-value='" + custPriority + "']"));
		reportStep(" CustomerPriority Option is selected successfully as " + custPriority, "pass");
		return this;
	}

	public EditAccountPage selectSLA(String SLA) {
		click(locateElement(Locators.XPATH, "//button[@aria-label='SLA']"));
		reportStep(" SLA menu is clicked successfully ", "pass");
		click(locateElement(Locators.XPATH, "//lightning-base-combobox-item[@data-value='" + SLA + "']"));
		reportStep(" SLA Option is selected successfully as " + SLA, "pass");
		return this;
	}

	public EditAccountPage selectActive(String active) {
		click(locateElement(Locators.XPATH, "//button[@aria-label='Active']"));
		reportStep(" active menu is clicked successfully ", "pass");
		click(locateElement(Locators.XPATH, "//lightning-base-combobox-item[@data-value='" + active + "']"));
		reportStep(" active Option is selected successfully as " + active, "pass");
		return this;
	}

	public EditAccountPage enterBillingAddress(String billadd) {
		clearAndType(locateElement(Locators.XPATH, "//label[text()='Billing Street']/following::textarea"), billadd);
		reportStep(billadd + " Billing Address is entered successfully", "pass");
		return this;
	}

	public EditAccountPage enterShippingAddress(String shipadd) {
		clearAndType(locateElement(Locators.XPATH, "(//label[text()='Shipping Street']/following::textarea)[1]"),
				shipadd);
		reportStep(shipadd + " Shipping Address is entered successfully", "pass");
		return this;
	}

	public EditAccountPage scrolldownWindow() {
		WebElement scrollableDiv = locateElement(Locators.CLASS_NAME, "actionBody");
		String args = "arguments[0].scrollTop = arguments[0].scrollTop + 500;";
		executeTheScript(args, scrollableDiv);
		reportStep(" Scrolling Down the window is done successfully", "pass");

		return this;
	}

	public EditAccountPage enterPhoneNo(String phno) {
		clearAndType(locateElement(Locators.XPATH, "//input[@name='Phone']"), phno);
		reportStep(phno + " Phone Number is entered successfully", "pass");
		return this;
	}

	public EditAccountPage selectUpSellOpp(String upsellopp) {
		click(locateElement(Locators.XPATH, "//button[@aria-label='Upsell Opportunity']"));
		reportStep(" active menu is clicked successfully ", "pass");
		click(locateElement(Locators.XPATH, "//lightning-base-combobox-item[@data-value='" + upsellopp + "']"));
		reportStep(" active Option is selected successfully as " + upsellopp, "pass");
		return this;
	}

	public AccountsPage clickSave() {
		click(locateElement(Locators.XPATH, "//button[@name='SaveEdit']"));
		reportStep(" Save Button is clicked successfully ", "pass");
		return new AccountsPage();
	}

}
