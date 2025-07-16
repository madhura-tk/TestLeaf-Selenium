package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonMethods;
import io.cucumber.java.en.When;

public class LoginPage extends CommonMethods {


	@When("the user enters the username as demosalesmanager")
	public LoginPage enterUsername() {
		getDriver().findElement(By.id("username")).sendKeys("Demosalesmanager");
		return this;
	}
	@When("the user enters the password as crmsfa")
	public LoginPage enterPassword() {
		getDriver().findElement(By.id("password")).sendKeys("crmsfa");
		return this;

	}
	@When("the user clicks the login button")
	public HomePage clickLoginButton() {
		getDriver().findElement(By.className("decorativeSubmit")).click();
		return new HomePage();

	}
}
