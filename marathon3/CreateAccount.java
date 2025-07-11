package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccount extends ProjectSpecificMethods {
	@BeforeTest
	public void setFilePath() {
		filePath = "CreateAccount";
		sheetName = "formdata";
	}

	@Test(dataProvider = "fetchData")
	public void runCreateAccount(String accountName, String ownership) throws InterruptedException {
		System.out.println(accountName);
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--disable-notifications"); ChromeDriver driver = new
		 * ChromeDriver(options); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 * driver.get("https://login.salesforce.com/");
		 * driver.findElement(By.id("username")).sendKeys("vidyar@testleaf.com");
		 * driver.findElement(By.id("password")).sendKeys("Sales@123");
		 * driver.findElement(By.id("Login")).click();
		 * 
		 * Thread.sleep(1000); WebElement appLaunch
		 * =driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		 * appLaunch.click(); Thread.sleep(1000);
		 * driver.findElement(By.xpath("//button[text()='View All']")).click();
		 */
		/*
		 * driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
		 * Thread.sleep(1000);
		 * 
		 * //Javascript Error WebElement
		 * accounts=driver.findElement(By.xpath("//a[@title='Accounts']"));
		 * driver.executeScript("arguments[0].click();", accounts);
		 */

		driver.findElement(By.xpath("//a[@title='New']")).click();
		// String accountName = "Gokul";
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(accountName);
		Thread.sleep(500);

		WebElement ownershipDD = driver.findElement(By.xpath("//button[@aria-label='Ownership']"));
		driver.executeScript("arguments[0].click()", ownershipDD);
		Thread.sleep(500);

		// driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='public']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + ownership + "']")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		Thread.sleep(500);
		String toastMessage = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
				.getText();
		Thread.sleep(500);

		System.out.println(toastMessage);

		Assert.assertTrue(toastMessage.contains(accountName), "Verify your account name");
	}

}
