package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectBaseClass {
 static RemoteWebDriver driver;
 @Parameters({"user","pass","url","browser"})
  @BeforeMethod
  public void beforeMethodCall(String username,String password,String url,String browser) throws InterruptedException {
	 System.out.println(username+"-"+password+"-"+url+"-"+browser);
	 switch(browser.toLowerCase()) {
	 case "edge":
		 driver=new EdgeDriver();
		 break;
	 case "firefox":
		 driver=new FirefoxDriver();
		 break;
	 default:
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			//options.addArguments("--disable-blink-features=AutomationControlled");
			options.addArguments("--guest");

			driver = new ChromeDriver(options);
			 break;

		 }
	 	driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();

  }
  
  @AfterMethod
  public void afterMethodCall() {
		driver.close();  }

}
