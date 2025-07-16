package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonMethods;
import io.cucumber.java.en.When;

public class HomePage  extends CommonMethods{
	
	@When("the user clicks the crmsfa link")
	public MyHomePage clickCRMSFA() {
		getDriver().findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage();
	}

}
