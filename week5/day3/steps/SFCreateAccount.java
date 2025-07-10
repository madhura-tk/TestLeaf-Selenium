package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class SFCreateAccount {
ChromeDriver driver;
	@Given("the user establishes the Environment")
	public void the_user_establishes_the_Environment() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// options.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments("--guest");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	

	}

	@Given("the user loads the Url")
	public void the_user_loads_the_Url() {
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@When("the user enters the Username")
	public void the_user_enters_the_Username() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("bhuvanesh.moorthy@testleaf.com");

	}

	@When("the user enters the Password")
	public void the_user_enters_the_Password() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@2025");

	}

	@When("the user clicks the SFlogin button")
	public void the_user_clicks_the_SFlogin_button() {
		driver.findElement(By.xpath("//input[@id='Login']")).click();

	}

	@Then("the user should be navigated to the SalesForce Home page")
	public void the_user_should_be_navigated_to_the_sales_force_home_page() {
		String title=driver.getTitle();
		System.out.println(title);

	}

	@When("the user clicks the App Launcher Icon")
	public void the_user_clicks_the_app_launcher_icon() throws InterruptedException {
		// Click the App Launcher Icon
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement appLauncherIcon = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//one-app-launcher-header/button")));
		actions.moveToElement(appLauncherIcon).pause(Duration.ofSeconds(2)).perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", appLauncherIcon);
		Thread.sleep(1000);

	}

	@When("the user clicks ViewAll")
	public void the_user_clicks_ViewAll() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='View All']")).click();// View All Tab clicked
		Thread.sleep(1000);
	}
	
	@Then("the user scroll down the page")
	public void the_user_scroll_down_the_page() {
		// Scrolling the Window to click the Accounts
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement targetElement=driver.findElement(By.xpath("//p[text()='Accounts']"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", targetElement);
		boolean isDisplayed = targetElement.isDisplayed(); // returns true/false
		System.out.println(isDisplayed);

	}

	@When("the user clicks the Accounts")
	public void the_user_clicks_the_accounts() throws InterruptedException {
		driver.findElement(By.xpath("//p[text()='Accounts']")).click();
		Thread.sleep(1000);

	}
	
	@Then("the user clicks the New Button")
	public void the_user_clicks_the_New_Button() throws InterruptedException {
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(1000);


	}
	
	@When("the user enters the account name")
	public void the_user_enters_the_account_name() {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Madhura");
	}

	@When("the user selects the ownership")
	public void the_user_selects_the_ownership() throws InterruptedException {
		//div[@class='actionBody']
		// Scrolling the Window to Select the Ownership Option
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement targetElement=driver.findElement(By.xpath("//label[text()='Ownership']"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", targetElement);
		boolean isDisplayed = targetElement.isDisplayed(); // returns true/false
		System.out.println(isDisplayed);
		driver.findElement(By.xpath("//div/label[text()='Ownership']/following::div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Public']")).click();

		
	}

	@When("the user clicks the save button")
	public void the_user_clicks_the_save_button() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();

	}

	@Then("the user verifies the account name")
	public void the_user_verifies_the_account_name() {
		String name=driver.findElement(By.xpath("//lightning-formatted-text[text()='Madhura']")).getText();
		if(name.equals("Madhura")) {
			System.out.println("Account Creation is Done.Name is Verified");
		}
		driver.close();
	}

	
	
}
