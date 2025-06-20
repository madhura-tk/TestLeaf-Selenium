package week2.day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteLeads {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("http://leaftaps.com/opentaps");
		
		
		//Login Page
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		Thread.sleep(1000);

		driver.findElement(By.id("password")).sendKeys("crmsfa");
		Thread.sleep(1000);

		driver.findElement(By.className("decorativeSubmit")).click();
		
		//CRM Home Page
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		WebElement element = driver.findElement(By.xpath("//a[text()='Leads']"));
		if (element != null && element.isDisplayed() && element.isEnabled()) {

		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", element);
		}
		
		WebElement element1 = driver.findElement(By.xpath("//a[text()='Find Leads']"));
		if (element1 != null && element1.isDisplayed() && element1.isEnabled()) {

		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", element1);
		}
		WebElement phone = driver.findElement(By.xpath("//span[text()='Phone']"));
		phone.click();
		
		WebElement country=driver.findElement(By.name("phoneCountryCode"));
		country.clear();
		country.sendKeys("52");
		
		driver.findElement(By.name("phoneAreaCode")).sendKeys("52");
		driver.findElement(By.name("phoneNumber")).sendKeys("1234567890");
		WebElement findlead=driver.findElement(By.className("x-btn-text"));
		findlead.click();
		
		// Wait for the floating results panel (based on class or visible content)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'x-window') and contains(., 'Accounts')]")));

		// Example: Get Account IDs from the popup
		List<WebElement> accountIds = driver.findElements(By.xpath("//div[contains(@class,'x-window')]//table//td[contains(@class,'x-grid3-cell-first')]"));

		for (WebElement id : accountIds) {
		    System.out.println("Account ID: " + id.getText());
		}

		// (Optional) Close the floating panel by clicking 'X' button
		WebElement closeBtn = driver.findElement(By.xpath("//div[contains(@class,'x-window')]//div[contains(@class,'x-tool-close')]"));
		closeBtn.click();
	    Thread.sleep(1000);

		WebElement optionSelect=driver.findElement(By.xpath("//div[@class='x-grid3-body']//a"));
		String id=optionSelect.getText();
	    System.out.println(id);

		optionSelect.click();
	    Thread.sleep(1000);

	    WebElement deleteSelect=driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']"));
		deleteSelect.click();
	    Thread.sleep(1000);

		WebElement findleads = driver.findElement(By.xpath("//a[text()='Find Leads']"));
	    driver.executeScript("arguments[0].click();", findleads);
	    Thread.sleep(1000);

	   	driver.findElement(By.name("id")).sendKeys(id);
		
		WebElement findleadsbutton = driver.findElement(By.xpath("//button[text()='Find Leads']"));
	    driver.executeScript("arguments[0].click();", findleadsbutton);

	    Thread.sleep(1000);
	    List<WebElement> rows = driver.findElements(By.xpath("//div[@class='x-grid3-body']//table//tr"));
	    if (rows.isEmpty()) {
	        System.out.println("✅ No leads found in search results.");
	    } else {
	        System.out.println("❌ Leads found: " + rows.size());
	    }
	    
	    driver.close();


	}

}
