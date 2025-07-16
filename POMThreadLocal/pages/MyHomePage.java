package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonMethods;
import io.cucumber.java.en.When;

public class MyHomePage extends CommonMethods {
	public MyHomePage(ChromeDriver driver) {
		this.driver=driver;
	}
	@When("the user clicks the leads module")
	public MyLeadsPage clickLeadsModule() {
		driver.findElement(By.linkText("Leads")).click();
		return new MyLeadsPage(driver);
	}

}
