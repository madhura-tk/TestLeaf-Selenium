package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FlightIRCTCBooking {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options); // Or ChromeDriver, FirefoxDriver

		driver.manage().window().maximize();
		// Navigating to the specified URL
		driver.navigate().to("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String strParentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();

		Set<String> windows = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(windows);
		String strChildWindow=windowsList.get(1);
		driver.switchTo().window(strChildWindow);
		System.out.println("Chid Window Title : " + driver.getTitle());
		driver.switchTo().window(strParentWindow).close();
		driver.switchTo().window(strChildWindow);
	
	}
}
