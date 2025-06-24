package week3.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class AjioMenBags {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(); // Or ChromeDriver, FirefoxDriver
		driver.manage().window().maximize();

		driver.navigate().to("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.className("desktop-searchBar")).sendKeys("bags");

		driver.findElement(By.xpath("//a[@class='desktop-submit']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//label[contains(text(),'Men')]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//label[contains(text(),'Rucksacks')]")).click();
		Thread.sleep(1000);
		String count = driver.findElement(By.className("title-count")).getText();
		//System.out.println("No of Rucksacks Bags :" + count);
		//WebElement brandMore = driver.findElement(By.xpath("//div[@class='brand-more']"));
		/*
		 * List<WebElement> brandList;
		 * 
		 * if (brandMore.isDisplayed()) { brandMore.click(); System.out.println("more");
		 * brandList =
		 * driver.findElements(By.xpath("//ul[@class='FilterDirectory-list']//input"));
		 * 
		 * } else { brandList =
		 * driver.findElements(By.xpath("//ul[@class='brand-list']//input")); }
		 * System.out.println("Brand Count : " + brandList.size());
		 * System.out.println("List of Brands under Rucksacks Bags :"); for (WebElement
		 * brand : brandList) { String brandText = brand.getDomAttribute("value");
		 * System.out.println(brandText); } //
		 * div[@class="product-productMetaInfo"]/h4[text()='Cliff 45L Solid Rucksack']
		 * List<WebElement> productNames =
		 * driver.findElements(By.xpath("//div[@class='product-productMetaInfo']/h3"));
		 * for (WebElement name : productNames) { String strBrand = name.getText();
		 * System.out.println(strBrand); }
		 */
	}

}