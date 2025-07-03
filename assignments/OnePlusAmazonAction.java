package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnePlusAmazonAction {
	public static void main(String[] args) throws InterruptedException, IOException {

		//Browser Settings Initialization
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-blink-features=AutomationControlled");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//Goto Amazon website
		driver.navigate().to("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Search onepluspro in the search Box
		Actions action = new Actions(driver);
		WebElement elementSearch = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		action.moveToElement(elementSearch).click();
		elementSearch.sendKeys("oneplus 9 pro");
		
		//Select the first suggest option
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		// String price="";

		//Get the no of products and print
		List<WebElement> products = driver
				.findElements(By.xpath("//div[contains(@data-component-type, 's-search-result')]"));
		System.out.println("Total products found: " + products.size());

		//First Product selection
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement firstProduct = driver
				.findElement(By.xpath("(//div[contains(@data-component-type, 's-search-result')])[1]"));

		//Get the price of the first product and print
		WebElement priceEl = firstProduct
				.findElement(By.xpath(".//span[@class='a-price']//span[@class='a-offscreen']"));
		String price = (String) js.executeScript("return arguments[0].textContent;", priceEl);
		System.out.println("First Product Price: " + price);

		/// System.out.println("Price of the First Product : "+price);
		//Get the no of ratings and print it
		String ratings = driver.findElement(By.xpath("//div[@class='a-row a-size-small'][1]/a/span")).getText();
		System.out.println("No of Ratings of the First Product : " + ratings);

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-cy='title-recipe']/a/h2")));
		element.click();
		Thread.sleep(1000);

		//get the screenshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./screenshot/oneplussnap1.png");
		FileUtils.copyFile(src, des);
		Thread.sleep(1000);

		//Add to the cart
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addToCartBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-button")));

		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
		if (addToCartBtn.isEnabled()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);
			System.out.println("Add to Cart clicked");
		} else {
			System.out.println("Add to Cart disabled.");

		}

		Thread.sleep(1000);
		
		//Get the SubCart total and check the price
		String subCartTotal = driver
				.findElement(By.xpath("//span[@class='a-price sw-subtotal-amount']//span[@class='a-price-whole']"))
				.getText();

		price = price.replaceAll("[^\\d]", ""); // removes ₹ and commas subCartTotal
		subCartTotal = subCartTotal.replaceAll("[^\\d]", "");
		System.out.println("Price of the First Product : " + price);

		if (Integer.parseInt(price) == Integer.parseInt(subCartTotal)) {
			System.out.println("Prices are Equal");

		}

		else {
			System.out.println("Price Mismatch");
		}

		driver.quit();
	}

}
