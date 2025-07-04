package week4.day2.assignments;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YahooFinance {
	public static void main(String[] args) throws InterruptedException, IOException {
		//Initialising Browser Settings
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-blink-features=AutomationControlled");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//Navigate to Yahoo Finance
		driver.navigate().to("https://finance.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click More Options to select Crypto
		driver.findElement(By.xpath("//span[text()='More']")).click();
		driver.findElement(By.xpath("//a/span[text()='Finance']/following::li/a[contains(text(),'Crypto')]")).click();

		//Get the all the Crypto Currency Names and Print it.
		List<WebElement> rowsSet = driver.findElements(By.xpath("//div/table/tbody/tr/td[2]/div"));
		System.out.println(rowsSet.size());
		for (WebElement row : rowsSet) {
			String cryptoName = row.getText();
			System.out.println(cryptoName);
		}
		
		driver.quit();

	}

}
