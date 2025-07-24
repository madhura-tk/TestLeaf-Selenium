package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC001_VerifyLogin extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "VerifyLogin";
		testDescription = "Verify Login functionality with positive data";
		authors = "Madhura";
		category = "Sanity";
		excelFileName = "Login";
	}

	@Test(dataProvider = "fetchData")
	public void runLogin(String uname, String pass) {
		LoginPage lp = new LoginPage();
		lp.enterUsername(uname).enterPassword(pass).clickLogin();
	}

}
