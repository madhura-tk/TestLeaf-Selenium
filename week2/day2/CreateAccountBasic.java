package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountBasic {
	//Method to EXecute JavascriptExecutor for Assigning a value for every locator
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
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//CRM Home Page
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		//WebElement link = driver.findElement(By.xpath("//a[text()='Create Account']"));
		/*WebElement link=driver.findElement(By.xpath("//a[contains(@href, 'accountsMain')]"));
		String href = link.getDomAttribute("href");
		System.out.print(href);
		link.click();*/
		
		//Accounts Tab
		WebElement accountsLink = driver.findElement(By.xpath("//a[text()='Accounts']"));
		if (accountsLink != null && accountsLink.isDisplayed() && accountsLink.isEnabled()) {

		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", accountsLink);
		}
		
		//Create Account Tab Left
		WebElement createAccountsLink = driver.findElement(By.xpath("//a[text()='Create Account']"));
		//createAccountsLink.click();
		if (createAccountsLink != null && createAccountsLink.isDisplayed() && createAccountsLink.isEnabled()) {

		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", createAccountsLink);
		}
	
		//Create Account Form
		
		//WebElement inputBox = driver.findElement(By.id("accountName"));
		setInputValue(driver, By.id("accountName"), "Tester2");
		Thread.sleep(1000);
		setInputValue(driver, By.id("groupNameLocal"), "Selenium Weekday");
		Thread.sleep(1000);
		setInputValue(driver, By.id("annualRevenue"), "1200000");
		Thread.sleep(1000);

		
	    WebElement  industry=driver.findElement(By.name("industryEnumId"));
		Select options1 = new Select(industry);
		options1.selectByIndex(3);
		Thread.sleep(1000);
		
		WebElement  ownership=driver.findElement(By.name("ownershipEnumId"));
		Select options2 = new Select(ownership);
		options2.selectByIndex(1);
		Thread.sleep(1000);
		
		
		setInputValue(driver, By.name("description"), "Selenium Automation Tester");
		setInputValue(driver, By.name("numberEmployees"), "150");
		setInputValue(driver, By.id("officeSiteName"), "LeafTabs");
		Thread.sleep(1000);
		
		//driver.findElement(By.className("smallSubmit")).click();
		WebElement createAccountButton = driver.findElement(By.className("smallSubmit"));
		//createAccountButton.click();
		if (createAccountButton != null && createAccountButton.isDisplayed() && createAccountButton.isEnabled()) {

		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", createAccountButton);
		}
		
		String pageTitle= driver.getTitle();
		System.out.println("Page Title :"+pageTitle);
		
		if(pageTitle.contains("Account Details")) {
			System.out.println("Title is verified");
		}
		else {
			System.out.println("Title is not verified");

		}
		
		Thread.sleep(3000);

		driver.close();



		
		
		//driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");

		/*WebElement inputBox = driver.findElement(By.xpath("//a[text()='Account']"));
		//driver.findElement(By.id("accountName")).sendKeys("DemoTester 1");
		inputBox.sendKeys("DemoTester 1");*/
		
	}
	
}
