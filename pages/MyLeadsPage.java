package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonMethods;
import io.cucumber.java.en.When;

public class MyLeadsPage extends CommonMethods {
	
	
	@When("the user clicks the create lead from the shortcuts menu")
	public CreateLeadPage clickCreateLeadShortcutButton() {

		getDriver().findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage();

	}

}
