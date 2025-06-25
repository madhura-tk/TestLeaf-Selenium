package week3.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LeafgroundButtonInteraction {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(); // Or ChromeDriver, FirefoxDriver
		driver.manage().window().maximize();

		//Navigating to the specified URL
		driver.navigate().to("https://leafground.com/button.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//to get the title of the page
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		System.out.println(driver.getTitle());
		String strTitle = driver.getTitle();
		if(strTitle.equalsIgnoreCase("dashboard")) {//check title is dashboard
			System.out.println("Title -Dashboard is verified");
		}
		else {
			System.out.println("Title -Dashboard is not verified");

		}
		Thread.sleep(1000);
		driver.navigate().back();//navigate to the previous page
		
		//To check the Disabled Button
		WebElement disableButton=driver.findElement(By.xpath("//span[text()='Disabled']"));
		if(disableButton.isEnabled()) {
			System.out.println("Confirm if the button is disable Button is disabled");

		}
		else {
			System.out.println("Confirm if the button is disable Button is not disabled");
		}
		
		//To get the Location of the Button 
		WebElement submitButton=driver.findElement(By.xpath("//h5[contains(text(),'position')]/following-sibling::button"));
		Point location=submitButton.getLocation();
		System.out.println("Submit Button Position :"+location);

		//To get the background colour of the Button
		WebElement saveButton=driver.findElement(By.xpath("//h5[contains(text(),'Save')]/following-sibling::button"));
		String stSubmitButtonrBackColor=saveButton.getCssValue("background-color");
		System.out.println("Save Background Colour  :"+stSubmitButtonrBackColor);
		
		//To get the size of the Button
		WebElement sizeButton=driver.findElement(By.xpath("//h5[contains(text(),'height')]/following-sibling::button"));
		Dimension strSubmitButtonSize=sizeButton.getSize();
		System.out.println("Size of the Button  :"+strSubmitButtonSize);
		
		driver.quit();
	}


}