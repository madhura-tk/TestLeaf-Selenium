package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonMethods;
import io.cucumber.java.en.When;

public class LoginPage extends CommonMethods {

	public LoginPage(ChromeDriver driver) {
		this.driver=driver;
	}
	@When("the user enters the username as demosalesmanager")
	public LoginPage enterUsername() {
		System.out.println("Driver value from pages package"+driver);
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		return this;
	}
	@When("the user enters the password as crmsfa")
	public LoginPage enterPassword() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		return this;

	}
	@When("the user clicks the login button")
	public HomePage clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new HomePage(driver);

	}
}
