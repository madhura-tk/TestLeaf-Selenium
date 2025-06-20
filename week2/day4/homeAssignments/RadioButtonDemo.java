import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonDemo {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * ChromeOptions options = new ChromeOptions(); options.addArguments("guest");
		 * ChromeDriver driver = new ChromeDriver(options);
		 */
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.leafground.com/radio.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//label[text()='Chrome']")).click();

		WebElement radioButton = driver.findElement(By.xpath("//label[text()='Hyderabad']"));
		driver.executeScript("arguments[0].click();", radioButton);

		if (driver.findElement(By.id("j_idt87:city2:2")).isSelected()) {
			System.out.println("RadioButton is Selected");
		}

		radioButton.click();
		if (!driver.findElement(By.id("j_idt87:city2:2")).isSelected()) {
			System.out.println("RadioButton is not Selected");
		}

		Thread.sleep(1000);

		List<WebElement> radioButtons = driver.findElements(By.name("j_idt87:console2"));

		for (WebElement radio : radioButtons) {
			if (radio.isSelected()) {
				System.out.println("Selected radio button value: " + radio.getDomAttribute("value"));
				// You can interact with it here if needed
				break;
			}
		}

		if (!driver.findElement(By.id("j_idt87:age:1")).isSelected()) {
			System.out.println("RadioButton is not Selected by default");
			WebElement age=driver.findElement(By.id("j_idt87:age:1"));
			driver.executeScript("arguments[0].click();", age);
		} else {
			System.out.println("Age 21-40 is  Selected by default");

		}

	}

}
