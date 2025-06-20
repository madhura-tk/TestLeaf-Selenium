package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LeafTabsXpath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
				ChromeOptions options = new ChromeOptions();
				options.addArguments("guest");
				ChromeDriver driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.navigate().to("http://leaftaps.com/opentaps");
				
			
				//Login Page
				driver.findElement(By.id("username")).sendKeys("demosalesmanager");
				Thread.sleep(1000);

				driver.findElement(By.id("password")).sendKeys("crmsfa");
				Thread.sleep(1000);

				driver.findElement(By.className("decorativeSubmit")).click();
				
				//CRM Home Page
				driver.findElement(By.partialLinkText("CRM/SFA")).click();
				
				//Find Leads
				driver.findElement(By.xpath("//a[text()='Leads']")).click();
				
				driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
				
				//driver.close();


			}

		



}
