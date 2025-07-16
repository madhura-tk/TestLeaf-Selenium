package runner;

import org.testng.annotations.Test;

import base.CommonMethods;
import pages.LoginPage;

public class TC002_CreateLead extends CommonMethods {

	
	@Test
	public void runCreateLead() throws InterruptedException {

		LoginPage user = new LoginPage();
		 System.out.println("Driver value  OF TCOO2 "+getDriver());

		user.enterUsername()
		.enterPassword()
		.clickLoginButton()
		.clickCRMSFA()
		.clickLeadsModule()
		.clickCreateLeadShortcutButton()
		.enterCompName()
		.enterFirstName()
		.enterLastName()
		.enterPhoneNo().
		clickSubmit().verifyStatus();
	}
}
