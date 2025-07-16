package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadPage extends CommonMethods{
	
	@When ("the user enters the company name" )
	public CreateLeadPage enterCompName() {
		getDriver().findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		return this;
	}
	
	@When ("the user enters the firstname" )
	public CreateLeadPage enterFirstName() {
		getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys("bhuvanesh");
		return this;
	}
	
	@When ("the user enters the lastname" )
	public CreateLeadPage enterLastName() {
		getDriver().findElement(By.id("createLeadForm_lastName")).sendKeys("moorthy");
		return this;
	}
	
	@When ("the user enters the phoneno" )
	public CreateLeadPage enterPhoneNo() {
		getDriver().findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("98127");
		return this;
	}
	
	@Then ("the user clicks the submit button" )
	public ViewLeadPage clickSubmit() {
		getDriver().findElement(By.name("submitButton")).click();
		return new ViewLeadPage();
	}



}
