package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountSelect {

	// Method to EXecute JavascriptExecutor for Assigning a value for every locator
	public static void setInputValue(ChromeDriver driver, By locator, String value) {
		WebElement element = driver.findElement(locator);

		driver.executeScript("arguments[0].value = arguments[1];", element, value);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("http://leaftaps.com/opentaps");

		// Login Page
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		Thread.sleep(1000);

		driver.findElement(By.id("password")).sendKeys("crmsfa");
		Thread.sleep(1000);

		driver.findElement(By.className("decorativeSubmit")).click();

		// CRM Home Page
		driver.findElement(By.xpath("//div[@id='label']/a[@href]")).click();

		// Accounts Tab
		WebElement accountsLink = driver.findElement(By.xpath("//a[text()='Accounts']"));
		// if (accountsLink != null && accountsLink.isDisplayed() &&
		// accountsLink.isEnabled()) {

		driver.executeScript("arguments[0].click();", accountsLink);
		// }

		// Create Account Tab Left
		WebElement createAccountsLink = driver.findElement(By.xpath("//a[text()='Create Account']"));
		driver.executeScript("arguments[0].click();", createAccountsLink);

		// Create Account Form

		// WebElement inputBox = driver.findElement(By.id("accountName"));
		setInputValue(driver, By.id("accountName"), "Tester701");
		Thread.sleep(1000);

		WebElement industry = driver.findElement(By.name("industryEnumId"));
		Select options1 = new Select(industry);
		options1.selectByIndex(3);
		Thread.sleep(1000);

		WebElement ownership = driver.findElement(By.name("ownershipEnumId"));
		Select options2 = new Select(ownership);
		options2.selectByContainsVisibleText("S-Corporation");
		Thread.sleep(1000);

		WebElement source = driver.findElement(By.id("dataSourceId"));
		Select options3 = new Select(source);
		options3.selectByValue("LEAD_EMPLOYEE");
		Thread.sleep(1000);

		WebElement market = driver.findElement(By.id("marketingCampaignId"));
		Select options4 = new Select(market);
		options4.selectByIndex(6);
		Thread.sleep(1000);

		WebElement state = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select options5 = new Select(state);
		options5.selectByValue("TX");
		Thread.sleep(1000);

		setInputValue(driver, By.name("description"), "Selenium Automation Tester");
		setInputValue(driver, By.name("numberEmployees"), "150");
		setInputValue(driver, By.id("officeSiteName"), "LeafTabs");

		driver.findElement(By.className("smallSubmit")).click();
		WebElement createAccountButton = driver.findElement(By.className("smallSubmit"));

		// createAccountButton.click();
		driver.executeScript("arguments[0].click();", createAccountButton);

		// Find the <span> with text 'Account Name', go to its parent <td>, then the
		// following <td>, then the span

		String spanText = driver.findElement(By.xpath("//span[contains(text(),'Test')]")).getText();
		System.out.println("Text after span: " + spanText);

		String[] split = ((String) spanText).split(" "); if(split[0].equals("Tester701")) {
		 
		  System.out.println("The created account name is same");
		  
		  }else { System.out.println("The created account name is not same"); }
		 
		Thread.sleep(1000);
		driver.close();

	}

}
