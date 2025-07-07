package week5.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class SalesForceBase {
	static RemoteWebDriver driver;

	@Parameters({ "user", "pass", "url", "browser" })
	@BeforeMethod
	public void beforeMethodCall(String username, String password, String url, String browser)
			throws InterruptedException {

		// Initialisation of Browser Settings
		System.out.println(username + "-" + password + "-" + url + "-" + browser);
		switch (browser.toLowerCase()) {
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			// options.addArguments("--disable-blink-features=AutomationControlled");
			options.addArguments("--guest");

			driver = new ChromeDriver(options);
			break;

		}

		driver.manage().window().maximize();

		// Go to the Salesforce url
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Login Credentials
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='Login']")).click();

		// Click the App Launcher Icon
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement appLauncherIcon = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//one-app-launcher-header/button")));
		actions.moveToElement(appLauncherIcon).pause(Duration.ofSeconds(2)).perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", appLauncherIcon);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='View All']")).click();// View All Tab clicked
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='All Apps']")).click();// All Apps Tab clicked
		Thread.sleep(1000);

		// Scrolling the List to click the Legal Entitites
		WebElement div = driver.findElement(By.xpath("//one-app-launcher-modal/div/div[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", div);

		driver.findElement(By.xpath("//p[text()='Legal Entities']")).click();
		Thread.sleep(1000);

		// Click the Legal Entities DropDown Icon
		driver.findElement(By.xpath(
				"(//preceding::span[text()='Legal Entities']/following::a[@class=\"slds-button slds-button_reset\"])[1]"))
				.click();
		Thread.sleep(1000);

		// Click the New Entity + icon
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
