package week4.day4;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SalesForceTestCase1 extends SalesForceBase {

	@Test
	public void runSalesForceTestCase1() throws InterruptedException {

		
		String name = "SalesForce Automation By Madhura";
		//Enter the Name and Save Button
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
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
