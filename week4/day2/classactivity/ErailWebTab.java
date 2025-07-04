package week4.day2.classactivity;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ErailWebTab {
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-blink-features=AutomationControlled");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.navigate().to("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS");
		driver.findElement(By.xpath("//strong[text()='MAS']")).click();

		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("CBE");
		driver.findElement(By.xpath("//strong[text()='CBE']")).click();

		driver.findElement(By.xpath("//label[contains(text(),'Sort on Date')]")).click();

		Thread.sleep(1000);
		List<WebElement> noofTrainsList = new ArrayList<WebElement>(
				driver.findElements(By.xpath("//div[@id='divTrainsListHeader']//following::table[1]/tbody/tr")));
		System.out.println(noofTrainsList.size());

		List<String> trainNamesList = new ArrayList<String>();
		for (int i = 2; i <= noofTrainsList.size(); i++) {
			String strTrainName = driver
					.findElement(By
							.xpath("//div[@id='divTrainsListHeader']//following::table[1]/tbody/tr[" + i + "]/td[2]/a"))
					.getText();
			trainNamesList.add(strTrainName);
		}

		System.out.println(trainNamesList);
		Set<String> trainsSet = new HashSet<>(trainNamesList);
		System.out.println(trainsSet.size());
		System.out.println(trainNamesList.size());

		int duplicate = trainNamesList.size() - trainsSet.size();
		System.out.println(duplicate);
		if (duplicate > 0) {
			System.out.println("Yes,There are " + duplicate + " trains are duplicate.");
		} else {
			System.out.println("No duplicate Trains.");
		}
		driver.quit();

	}
}
