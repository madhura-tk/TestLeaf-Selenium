package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookTitle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
		Thread.sleep(1000);

		driver.findElement(By.id("pass")).sendKeys("Tuna@321");
		Thread.sleep(1000);

		driver.findElement(By.name("login")).click();
		driver.findElement(By.partialLinkText("Find your account and log in.")).click();
		String pageTitle= driver.getTitle();
		System.out.println("Page Title :"+pageTitle);
		
		if(pageTitle.contains("Forgotten Password | Can't Log In | Facebook")) {
			System.out.println("Title is verified");
		}
		else {
			System.out.println("Title is not verified");

		}
		driver.close();
	}
}
