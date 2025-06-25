package week3.day3;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertFrameAutomation {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(); // Or ChromeDriver, FirefoxDriver
		driver.manage().window().maximize();

		driver.navigate().to("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		Alert alert =driver.switchTo().alert();
		alert.accept();
		Thread.sleep(1000);
		String text=driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(text);
	
}

	}



