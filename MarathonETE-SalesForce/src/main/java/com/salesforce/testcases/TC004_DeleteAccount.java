package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC004_DeleteAccount extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "DeleteAccount";
		testDescription = "Verify that the Account is deleted";
		authors = "Madhura";
		category = "Regression";
		excelFileName = "DeleteAccount";
	}

	@Test(dataProvider = "fetchData")
	public void runLogin(String uname, String pass, String accountName) {
		LoginPage lp = new LoginPage();
		lp.enterUsername(uname).enterPassword(pass).clickLogin().clickAppLauncher().clickViewAll().clickSales()
				.clickAccounts().enterSearchBox(accountName).selectFirstRecord().clickDeleteButton().clickDelete()
				.verifyAccount(accountName, "Delete");
	}

}
