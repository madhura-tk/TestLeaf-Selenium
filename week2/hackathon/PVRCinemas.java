package week2.hackathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PVRCinemas {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		
		driver.navigate().to("https://www.pvrcinemas.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//driver.findElement(By.xpath("//div[@class='cities-names']/img[contains(@src,'Kolkata')]")).click();
		driver.findElement(By.xpath("//span[text()='Cinema']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Select Cinema')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Velachery')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Tomorrow')]")).click();
		driver.findElement(By.xpath("//li/span[text()='DNA']")).click();
		driver.findElement(By.xpath("//span[text()='11:00 PM']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'quick-lefts')]//button")).click();
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		driver.findElement(By.xpath("//td/span[text()='G']/following::span[text()='1']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		//*[@id="EL.ELITE|D:18"]
		String seat = driver.findElement(By.xpath("//div[@class='seat-number']/p")).getText();
		System.out.println("Selected Seat No : "+seat);
	
		String grandtotal = driver.findElement(By.xpath("//h6[2]/span")).getText();
		System.out.println("Grand Total "+ grandtotal);
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		WebElement cross= driver.findElement(By.xpath("//div[@class='cross-icon mx-2']/span/i"));
		driver.executeScript("arguments[0].click();", cross);
		System.out.print("Title :"+driver.getTitle());
	}

}

