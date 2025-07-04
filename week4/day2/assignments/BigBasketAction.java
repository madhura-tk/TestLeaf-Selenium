package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

public class BigBasketAction {
	public static void main(String[] args) throws InterruptedException, IOException {

		//Initializing the Browser Settings
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-blink-features=AutomationControlled");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions actions = new Actions(driver);

		//Navigate to the BigBasket URL
		driver.navigate().to("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//To click the Categories
		driver.findElement(By.xpath("//header[2]/div[2]/div[1]/div/div/button/div")).click();
		Thread.sleep(1000);

		//Hover to Food Grains
		WebElement foodgrains = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Foodgrains, Oil & Masala'])[2]")));
		actions.moveToElement(foodgrains).pause(Duration.ofSeconds(2)).perform();

		//Hover to Rice and Rice Products
		WebElement riceproduct = driver.findElement(By.xpath(("//a[normalize-space()='Rice & Rice Products']")));
		actions.moveToElement(riceproduct).pause(Duration.ofSeconds(2)).perform();

		//Hover and click the Boiled and Steam rice option
		WebElement riceproductType = driver.findElement(By.xpath(("//a[normalize-space()='Boiled & Steam Rice']")));
		actions.moveToElement(riceproductType).pause(Duration.ofSeconds(2)).perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", riceproductType);

		//To click the Tamilnadu Ponni Rice option
		driver.findElement(By.xpath(("//h3[contains(text(),'Tamil Ponni Boiled Rice')]"))).click();
		System.out.println(driver.getTitle());
		
		//Get the list of windows opened
		Set<String> windowsSet = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(windowsSet);
		
		String strChildWindow = windowsList.get(1);// switch to the first child window
		driver.switchTo().window(strChildWindow);
		System.out.println(driver.getTitle());

		// packSizeCard.click();
		// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		// packSizeCard);
		
		//Selecting the 5kg packsize
		WebElement packSizeCard = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[normalize-space()='5 kg']/parent::div")));
		actions.moveToElement(packSizeCard).pause(Duration.ofSeconds(2)).perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", packSizeCard);

		//To click the Add to Basket Button
		String price = driver.findElement(By.xpath("(//div[@class='flex flex-row items-start'])[6]/div[1]/span/span"))
				.getText();
		System.out.println(price);
		driver.findElement(By.xpath("//button[text()='Add to basket'][1]")).click();
		Thread.sleep(1000);

	    String alertMsg=driver.findElement(By.xpath("//p[contains(text(),'basket successfully')]")).getText();
		if (!alertMsg.contains("Message")) {
			System.out.println(alertMsg);
	    }
	    else {
	    	System.out.println("Alert Message is Not found");
	    }
		Thread.sleep(500);
		// Taking the Screenshot of the window and save the output in a file
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./screenshot/bigbasketsnap.png");
		FileUtils.copyFile(src, des);
		
		//close the current window
		//driver.quit();
		Thread.sleep(1000);
		
		//switch and close the parent window
		driver.switchTo().window(windowsList.get(0));
		driver.close();

	}

}
