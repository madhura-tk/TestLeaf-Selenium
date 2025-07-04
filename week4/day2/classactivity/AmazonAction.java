package week4.day2.classactivity;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AmazonAction {
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-blink-features=AutomationControlled");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.navigate().to("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		WebElement conditionLink = driver.findElement(By.xpath("//a[contains(text(),'Conditions')]"));
		//System.out.println(conditionLink.isDisplayed());
		Actions action = new Actions(driver);
		action.sendKeys(Keys.END).perform();
		conditionLink.click();
		System.out.println(driver.findElement(By.xpath("//h1")).getText());
		File src=driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./screenshot/snap.png");
		FileUtils.copyFile(src, des);
		Thread.sleep(1000);
		driver.quit();
	}

}
