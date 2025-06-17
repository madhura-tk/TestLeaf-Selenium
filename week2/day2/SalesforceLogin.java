package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesforceLogin {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@geagle.com");
		Thread.sleep(1000);

		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		Thread.sleep(1000);

		driver.findElement(By.name("Login")).click();
		String pageTitle= driver.getTitle();
		System.out.println("Page Title :"+pageTitle);
		if(pageTitle.contains("Login | Salesforce")) {
			System.out.println("Title is verified");
		}
		else {
			System.out.println("Title is not verified");

		}
		driver.close();
	}
}
