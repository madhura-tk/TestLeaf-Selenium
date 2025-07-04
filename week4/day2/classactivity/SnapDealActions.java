package week4.day2.classactivity;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapDealActions {
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//options.addArguments("--disable-blink-features=AutomationControlled");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.navigate().to("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Men's Fashion\")]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.perform();
		
		driver.findElement(By.xpath("//div[@id='category1Data']//span[text()='Shirts']")).click();
		WebElement picElement=driver.findElement(By.xpath("//section[1]/div[1]/div[1]/a/picture/img"));Thread.sleep(1000);
		action.moveToElement(picElement);
		action.perform();
		driver.findElement(By.xpath("//section[1]/div[1]/div[1]/div/div")).click();
		Thread.sleep(5000);
		File src=driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./screenshot/snap1.png");
		FileUtils.copyFile(src, des);
		Thread.sleep(1000);
		driver.quit();


		
	}   //moveToElement(WebElement target) - to assist in mouse hovering the element and get into the 


}
