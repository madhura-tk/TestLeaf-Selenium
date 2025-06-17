package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateLeadsPageBasic {
	
	public static void setInputValue(ChromeDriver driver, By locator, String value) {
	    WebElement element = driver.findElement(locator);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].value = arguments[1];", element, value);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
		
		WebElement element1 = driver.findElement(By.xpath("//a[text()='Create Lead']"));
		if (element1 != null && element1.isDisplayed() && element1.isEnabled()) {

		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", element1);
		}

		//setInputValue(driver, By.name("companyName"), "TestLeaf");

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		Thread.sleep(1000);

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Name1");
		Thread.sleep(1000);

		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Name2");
		Thread.sleep(1000);

		
		//Select dropdown Source as Employee
		WebElement source=driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select options1 = new Select(source);
		options1.selectByIndex(4);
		Thread.sleep(1000);

		
		//Select dropdown Marketing  Campaign as Automobile
				WebElement market=driver.findElement(By.id("createLeadForm_marketingCampaignId"));
				Select options2 = new Select(market);
				options2.selectByContainsVisibleText("Automobile");
				Thread.sleep(1000);

				//Select dropdown Ownership as Corporation
				WebElement owner=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
				Select options3 = new Select(owner);
				options3.selectByValue("OWN_CCORP");
				Thread.sleep(1000);

				driver.findElement(By.name("submitButton")).click();
		
		String pageTitle =driver.getTitle();
		System.out.println(pageTitle);
		if(pageTitle.contains("View Lead | opentaps CRM")) {
			System.out.print("Title is Verified");
			
		}
		else {
			System.out.print("Title is not Verified");

		}
		Thread.sleep(3000);
		driver.close();


	}

}
