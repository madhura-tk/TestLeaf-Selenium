package week4.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SalesForceTestCase2 extends SalesForceBase {

	@Test
	public void runSalesForceTestCase2() throws InterruptedException {

		String compName = "TestLeaf";
		String description = "Salesforces";

		//Enter the company name,description,Status fields and save button
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(compName);
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys(description);
		driver.findElement(By.xpath("//button[contains(@data-value,'None')]")).click();
		driver.findElement(By.xpath("(//span[text()='Active'])[1]")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		//Check for the Error alert to enter legal  entity name
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement error=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//lightning-icon[@icon-name=\"utility:error\"])[2]")));
		if(error.isDisplayed()){
		//driver.findElement(By.xpath("//button[@title='Close error dialog']")).click();
		
			//Input the Name and save
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("SalesForce Automation By Madhura");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		}
		Thread.sleep(1000);
		
		//Verify the Name with the displayed alert message
		String verifyName = driver.findElement(By.xpath("//div[contains(text(),'Madhura')]")).getText();
		System.out.println(verifyName);
		if (verifyName.contains("Madhura")) {
			System.out.println("Name is displayed in Alert");
		} else {
			System.out.println("Name is not displayed in Alert");
		}

	}
}
