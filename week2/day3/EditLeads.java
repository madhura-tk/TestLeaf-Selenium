package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLeads {

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

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("DemoUser321");
		Thread.sleep(1000);

		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Name321");
		Thread.sleep(1000);
		
		
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("LocalName321");
		Thread.sleep(1000);
		
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		Thread.sleep(1000);
		
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Testing Description");
		Thread.sleep(1000);

		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("testing@testleaf.com");
		Thread.sleep(1000);

		 WebElement state=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		 Select options2 = new Select(state);
		 options2.selectByContainsVisibleText("Florida"); Thread.sleep(1000);
		 
		 driver.findElement(By.name("submitButton")).click();
		 driver.findElement(By.xpath("//a[@class='subMenuButton'][3]")).click();
		 driver.findElement(By.id("updateLeadForm_description")).clear();
		 Thread.sleep(1000);
		 driver.findElement(By.name("importantNote")).sendKeys("Important Note");
		 driver.findElement(By.className("smallSubmit")).click();

		 System.out.println("Title of the page : "+driver.getTitle());

		 Thread.sleep(1000);
		 driver.quit();
		 
	
	}

	}


