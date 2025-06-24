package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonLowestPriceMobile {
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.navigate().to("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//div[@class='nav-search-field ']/input")).sendKeys("phones");
		Thread.sleep(1500);
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		List<Integer> priceList=new ArrayList<Integer>();
		List <WebElement> mobileElement = driver.findElements(By.className("a-price-whole"));
		for(WebElement list:mobileElement) {
			//System.out.println(list.getText());
			Integer price=Integer.parseInt(list.getText().replace(",", ""));
			priceList.add(price);
				
		}
		System.out.println(priceList);

		Collections.sort(priceList);
		//Object[] sortPrice =  priceList.toArray();
		//System.out.println("Lowest Price Mobile is "+ sortPrice[0]);
		System.out.println("Lowest Price Mobile is "+ priceList.get(0));

		//driver.close();
		
	}

}
