package week4.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SalesForceBase {
	static ChromeDriver driver;

	@BeforeMethod
	public void beforeMethodCall() throws InterruptedException {
		
		//Initialisation of Browser Settings
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--guest");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//Go to the Salesforce url
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Login Credentials
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("bhuvanesh.moorthy@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@2025");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		//Click the App Launcher Icon
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement appLauncherIcon = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//one-app-launcher-header/button")));
		actions.moveToElement(appLauncherIcon).pause(Duration.ofSeconds(2)).perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", appLauncherIcon);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='View All']")).click();//View All Tab clicked
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='All Apps']")).click();//All Apps Tab clicked
		Thread.sleep(1000);

		//Scrolling the List to click the Legal Entitites
		WebElement div = driver.findElement(By.xpath("//one-app-launcher-modal/div/div[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", div);

		driver.findElement(By.xpath("//p[text()='Legal Entities']")).click();
		Thread.sleep(1000);

		//Click the Legal Entities DropDown Icon
		driver.findElement(By.xpath(
				"(//preceding::span[text()='Legal Entities']/following::a[@class=\"slds-button slds-button_reset\"])[1]"))
				.click();
		Thread.sleep(1000);

		//Click the New Entity + icon
		driver.findElement(By.xpath("(//*[name()='svg' and @data-key='add'])[2]")).click();
		Thread.sleep(1000);
	}

	@AfterMethod
	public void afterMethodCall() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		System.out.println("after method");
	}

}
