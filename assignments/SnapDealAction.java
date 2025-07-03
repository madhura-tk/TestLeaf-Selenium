package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapDealAction {
	public static void main(String[] args) throws InterruptedException, IOException {

		//Initialaising the Browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-blink-features=AutomationControlled");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//Navigate to the snapdeal url
		driver.navigate().to("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Hover to Men's Fashion 
		WebElement menfashionEle = driver.findElement(By.xpath("//span[text()=concat('Men', \"'\", 's Fashion')]"));
		Actions action = new Actions(driver);
		action.moveToElement(menfashionEle).pause(2).perform();

		Thread.sleep(1000);
		
		//To click the Sports Shoes
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		
		//Print the No of sports shoes
		String strNoOfShoes = driver.findElement(By.xpath("//h1[@class='category-name']/following-sibling::span"))
				.getText();
		strNoOfShoes = strNoOfShoes.replaceAll("[^0-9]", "");
		System.out.println("No of Shoes result : " + strNoOfShoes);
		Thread.sleep(1000);

		//To select the Train Shoes category
		driver.findElement(By.xpath("//div[@class=\"child-cat-name \" and contains(text(),'Training')]")).click();
		
		//Sort the resuls by Price low to high
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		
		//To check the results are sorted by Price Low to High
		String strSortCheck = driver.findElement(By.xpath("//div[@class='sort-selected']")).getText().trim();
		if (strSortCheck.equals("Price Low To High")) {
			System.out.println("Sorted Low to High");
		} else {
			System.out.println("Not Sorted Low to High");

		}
		
		//Select the price Range 500-1700
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("500");

		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1700");
		driver.findElement(By.cssSelector("div.price-go-arrow.btn.btn-line.btn-theme-secondary")).click();
	
		
		//Scrolling the Window
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 3; i++) {
			js.executeScript("window.scrollBy(0, 300);"); // Scroll down by 300px
			Thread.sleep(500); // Small pause to see the scroll
		}

		//Select the first Color Option
		driver.findElement(By.xpath(
				"//div[@class=\"filter-section \" and @data-filtername=\"Color_s\" ]//div[@class=\"sdCheckbox filters-list \"]"))
				.click();
		Thread.sleep(1000);
		
		//Check the All filters Applied
		List<WebElement> filters = driver.findElements(By.xpath("(//div[@class='filters'])[1]/div"));
		System.out.println(filters.size());
		int count = 0;
		for (WebElement filter : filters) {
			if (filter.getText().contains("Price") || filter.getText().contains("Color")) {
				count += 1;
				System.out.println(filter.getText());
			}

		}
		System.out.println(count);

		if (count == filters.size()) {
			System.out.println("All filters are applied");
		}

		//Select the first Product and hover it
		WebElement product = driver.findElement(By.xpath("//section/div[1]/div[1]/div"));
		action.moveToElement(product).pause(2).perform();

		Thread.sleep(1000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// WebElement quickViewBtn =
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section/div[1]/div[1]/div/div")));
		
		//To click the Quick View Button
		WebElement quickViewBtn = driver.findElement(By.xpath("//section/div[1]/div[1]/div/div"));
		System.out.println(quickViewBtn.isDisplayed());
		action.moveToElement(quickViewBtn).pause(2).perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", quickViewBtn);

		Thread.sleep(1000);

		//Print the Cost and Discount percent
		System.out
				.println("Cost : " + driver.findElement(By.xpath("//div[@class=\"lfloat\"]/div[2]/span[1]")).getText());
		System.out.println(
				"Discount% : " + driver.findElement(By.xpath("//div[@class=\"lfloat\"]/div[2]/span[2]")).getText());

		
		Thread.sleep(1000);
		
		//Take screenshot and save in a file
		File sr=driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./screenshot/snapdealsnap.png");
		FileUtils.copyFile(sr, des);
		Thread.sleep(1000);

		//close the  current window
		WebElement closeBtn = driver.findElement(By.xpath("//*[@id=\"sidebar_modal_right\"]/div[2]/div[2]"));
		action.moveToElement(closeBtn).pause(2).perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
		
		//close the parent window
		driver.quit();


	}

}
