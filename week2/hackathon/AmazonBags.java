package week2.hackathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonBags {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.navigate().to("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


		//driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();

		
		driver.findElement(By.xpath("//div[@class='nav-search-field ']/input")).sendKeys("Bags for boys");
		Thread.sleep(1500);
		driver.findElement(By.id("nav-search-submit-button")).click();

		String results=driver.findElement(By.xpath("//h2/span[1]")).getText();
		System.out.println("Results Displayed: "+results);
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[4]")).click();
		
		driver.findElement(By.xpath("//span[text()='Featured']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();

		String brand=driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base']")).getText();

		String name=driver.findElement(By.xpath("//span[contains(text(),'Falcon')]")).getText();
		System.out.println("Name of the first Bag : "+brand+" : "+name);
		
		String price=driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("Price of the first Bag :"+price);
		
		System.out.println("Title of the Page : "+driver.getTitle());
		
		driver.quit();

		
		
		

	}

}
