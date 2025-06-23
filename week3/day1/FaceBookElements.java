package week3.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FaceBookElements {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.navigate().to("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		List<WebElement> listofanchorelements = driver.findElements(By.tagName("a"));
		int listSize = listofanchorelements.size();
		System.out.println(listSize);
		Thread.sleep(1000);

		for (WebElement element : listofanchorelements) {
			System.out.println(element.getText());

		}

		WebElement e = listofanchorelements.get(1);
		e.click();
	}

}
