package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandlingLeafTab {

	// Method to wait for the  windows to be loaded  and switch to the first child
	// window
	public static void switchToChildWindow(WebDriver driver) {
		//Explicit wait call for all the required windows to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until((ExpectedCondition<Boolean>) drv -> drv.getWindowHandles().size() == 2);
		
		Set<String> windowsSet = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(windowsSet);
		//System.out.println(windowsList);
		
		String strChildWindow = windowsList.get(1);//switch to the first child window
		driver.switchTo().window(strChildWindow);
		
		System.out.println(driver.getTitle());
	}

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();

		// Optional UI cleanups
		// options.addArguments("--disable-extensions");
		options.addArguments("--disable-notifications");
		// options.addArguments("--disable-popup-blocking");
		options.addArguments("guest");

		ChromeDriver driver = new ChromeDriver(options);//Initialising the chrome driver
		driver.manage().window().maximize();
		
		// Navigating to the specified URL
		driver.navigate().to("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		String strParentWindow = driver.getWindowHandle();//storing value of parentwindow element
		// Login Page
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		// CRM Home Page
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		Thread.sleep(30);

		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();//To click the Contacts Tab
		driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();//To choose the Merge Contacts Tab
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
		
		switchToChildWindow(driver);//Calling the function to switch to the first child window
		
		//To get the list of contacts
		List<WebElement> rowElement = driver.findElements(By.xpath("//table[@class='x-grid3-row-table']"));
		
		//Checking the no of contacts.If more than one contact can be mergded else alert message and return to the parent window.
		if (!(rowElement.size() > 1)) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("alert('Only Single Contact found.Cant Merge');");

			// Optionally handle the alert
			Thread.sleep(1000);
			driver.switchTo().alert().accept();

			driver.switchTo().window(strParentWindow);
			System.out.println("Single record.can't merge");

		} else { //more than one contact exist.Selecting first two contacts and merge.
			
			
			driver.findElement(By.xpath("//div[1]/table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]/div/a")).click();
			Thread.sleep(100);
			driver.switchTo().window(strParentWindow);

			driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
			switchToChildWindow(driver);
			driver.findElement(By.xpath("//div[2]/table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]/div/a")).click();

			Thread.sleep(100);
			driver.switchTo().window(strParentWindow);
			driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
			Thread.sleep(100);
			
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		//Printing the last page of the task.
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
