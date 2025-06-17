package week2.day2;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnSelectDropdown {
	public static void main(String[] args) throws InterruptedException {
		
	
		ChromeDriver myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		myDriver.navigate().to("https://leafground.com/select.xhtml");
		WebElement  element=myDriver.findElement(By.className("ui-selectonemenu"));
		Select options = new Select(element);
		options.selectByIndex(2);
		Thread.sleep(1000);		
		options.selectByContainsVisibleText("Selenium");
		Thread.sleep(1000);		
		myDriver.close();


	}

}
