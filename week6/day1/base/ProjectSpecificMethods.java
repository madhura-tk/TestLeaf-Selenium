package base;


import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;


public class ProjectSpecificMethods extends AbstractTestNGCucumberTests{
	public static ChromeDriver driver;

	@BeforeMethod
	public void preConditions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://login.salesforce.com/");
	}
	
	@AfterMethod
	public void postConditions() {
		driver.close();

	}


	
	

}