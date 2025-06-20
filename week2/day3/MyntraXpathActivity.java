package week2.day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyntraXpathActivity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.myntra.com/men-jeans");
		WebElement checkbox = driver.findElement(By.xpath("//input[@value='Flying Machine']"));
		driver.executeScript("arguments[0].click()", checkbox);
		
		}
	}


