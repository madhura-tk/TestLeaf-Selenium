package marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethods {

	public static ChromeDriver driver;
	public String filePath, sheetName;

	@Parameters({ "user", "password", "url" })
	
	@BeforeMethod
	public void beforeMethodCall(String username, String password, String url)
			throws InterruptedException {

		// Initialisation of Browser Settings
		System.out.println(username + "-" + password + "-" + url );
				ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			// options.addArguments("--disable-blink-features=AutomationControlled");
			options.addArguments("--guest");

			driver = new ChromeDriver(options);

		

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
	
        driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
        WebElement accountsTab = driver.findElement(By.xpath("//a[@title='Accounts']"));
        driver.executeScript("arguments[0].click()",accountsTab);
}
	
	  @AfterMethod
	  public void afterMethodCall() {
			driver.close();  }
	  
	  @DataProvider(name = "fetchData")
		public String[][] sendData() throws IOException {
			return TestDataLibrary.readData(filePath, sheetName);
		}

}