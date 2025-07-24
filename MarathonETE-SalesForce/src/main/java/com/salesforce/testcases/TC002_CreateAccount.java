package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC002_CreateAccount extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "CreateAccount";
		testDescription = "Verify that the Account is created";
		authors = "Madhura";
		category = "Regression";
		excelFileName = "CreateAccount";
	}

	@Test(dataProvider = "fetchData")
	public void runLogin(String uname, String pass, String accountName, String ownership) {
		LoginPage lp = new LoginPage();
		lp.enterUsername(uname).enterPassword(pass).clickLogin().clickAppLauncher().clickViewAll().clickSales()
				.clickAccounts().verifyAccountsPage().clickNew().enterAccountName(accountName).clickOwnership(ownership)
				.clickOwnershipValue(ownership).clickSave().verifyAccount(accountName, "Create");
	}

}
