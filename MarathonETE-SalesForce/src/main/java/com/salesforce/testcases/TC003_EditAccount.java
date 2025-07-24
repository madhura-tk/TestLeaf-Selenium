package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC003_EditAccount extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "EditAccount";
		testDescription = "Verify that the Account is edited";
		authors = "Madhura";
		category = "Regression";
		excelFileName = "EditAccount";
	}

	@Test(dataProvider = "fetchData")
	public void runLogin(String uname, String pass, String accountName, String type, String industry, String billingSt,
			String shippingSt, String custPriority, String SLA, String active, String phno, String upsellOpp) {
		LoginPage lp = new LoginPage();
		lp.enterUsername(uname).enterPassword(pass).clickLogin().clickAppLauncher().clickViewAll().clickSales()
				.clickAccounts().enterSearchBox(accountName).selectFirstRecord().clickEditButton().selectType(type)
				.enterPhoneNo(phno).selectIndustry(industry).enterBillingAddress(billingSt)
				.enterShippingAddress(shippingSt).scrolldownWindow().selectCustPriority(custPriority).selectSLA(SLA)
				.selectActive(active).selectUpSellOpp(upsellOpp).clickSave().verifyAccount(accountName, "Edit");
	}

}
