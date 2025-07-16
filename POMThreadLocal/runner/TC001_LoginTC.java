package runner;

import org.testng.annotations.Test;

import base.CommonMethods;
import pages.LoginPage;

public class TC001_LoginTC extends CommonMethods {

	
	@Test
	public void runLogin() {

		LoginPage user = new LoginPage();
		 System.out.println("Driver value  OF TCOO1 "+getDriver());
		user.enterUsername().enterPassword().clickLoginButton().clickCRMSFA();
	}
}
