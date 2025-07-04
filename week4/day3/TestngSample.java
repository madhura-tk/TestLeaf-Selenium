package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestngSample {
	public  ChromeDriver	driver;
	@Test
	 public void loginPage() {
		 
		 	 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.get("http://leaftaps.com/opentaps/control/main");
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  
	       }  
}


