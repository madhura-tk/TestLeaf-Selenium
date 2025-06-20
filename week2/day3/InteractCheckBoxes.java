package week2.day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InteractCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * ChromeOptions options = new ChromeOptions(); options.addArguments("guest");
		 * ChromeDriver driver = new ChromeDriver(options);
		 */
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://leafground.com/checkbox.xhtml");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement basicCheck=driver.findElement(By.xpath("//span[text()='Basic']/preceding-sibling::div/input"));
		driver.executeScript("arguments[0].click()", basicCheck);
		if (basicCheck.isSelected()) {
				System.out.println("Basic Checkbox is Checked");
			}
			else {				System.out.println("Basic Checkbox is not Checked");
}
		
		Thread.sleep(500);
		//driver.executeScript("arguments[0].click()", basicCheck);
		WebElement notificationCheck=driver.findElement(By.xpath("//span[text()='Ajax']/preceding-sibling::div/input"));
		Thread.sleep(500);
		driver.executeScript("arguments[0].click()", notificationCheck);
		if (notificationCheck.isSelected()) {
			System.out.println("Notification Checkbox is Checked");
		}
		else {				System.out.println("Notification Checkbox is not Checked");
}
		Thread.sleep(1000);
		
		
		//WebElement py=driver.findElement(By.xpath("//label[text()='Python']"));
		WebElement py=driver.findElement(By.xpath("//input[@value='py']/ancestor::div[contains(@class,'ui-chkbox')]//div[contains(@class,'ui-chkbox-box')]"));
		//py.click();
		//System.out.println(py.isEnabled());
		driver.executeScript("arguments[0].click()", py);
		
		WebElement pyspan = driver.findElement(By.id("j_idt87:basic:1"));
		String ispyChecked = pyspan.getDomAttribute("aria-checked");

		if ("true".equals(ispyChecked)) {
		    System.out.println("Checkbox is CHECKED");
		} else {
		    System.out.println("Checkbox is UNCHECKED");
		}

		
		//WebElement java=driver.findElement(By.xpath("//label[text()='Java']"));
		//driver.executeScript("arguments[0].click()", java);
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement java = driver.findElement(By.xpath("//input[@value='java']/ancestor::div[contains(@class,'ui-chkbox')]//div[contains(@class,'ui-chkbox-box')]"));
		driver.executeScript("arguments[0].click();", java);

		WebElement input = driver.findElement(By.id("j_idt87:basic:0"));
		String isChecked = input.getDomAttribute("aria-checked");

		if ("true".equals(isChecked)) {
		    System.out.println("Checkbox is CHECKED");
		} else {
		    System.out.println("Checkbox is UNCHECKED");
		}

	

		WebElement checkboxBox = driver.findElement(By.cssSelector("#j_idt87\\:ajaxTriState .ui-chkbox-box"));
		driver.executeScript("arguments[0].click();", checkboxBox);
		driver.executeScript("arguments[0].click();", checkboxBox);

		WebElement icon = driver.findElement(By.cssSelector("#j_idt87\\:ajaxTriState .ui-chkbox-icon"));
		String iconClass = icon.getDomAttribute("class");

		if (iconClass.contains("ui-icon-check")) {
		    System.out.println("Checkbox is CHECKED");
		} else if (iconClass.contains("ui-icon-closethick")) {
		    System.out.println("Checkbox is INDETERMINATE");
		} else {
		    System.out.println("Checkbox is UNCHECKED");
		}
		
		WebElement toggleBox = driver.findElement(By.xpath("//input[@id='j_idt87:j_idt100_input']"));
		driver.executeScript("arguments[0].click();", toggleBox);
		
		WebElement togChk = driver.findElement(By.id("j_idt87:j_idt100_input"));
		String istogChecked = togChk.getDomAttribute("aria-checked");

		if ("true".equals(istogChecked)) {
		    System.out.println("ToggleBox is CHECKED");
		} else {
		    System.out.println("ToggleBox is UNCHECKED");
		}
		
		WebElement chkBox = driver.findElement(By.id("j_idt87:j_idt102_input"));

		if (chkBox.isEnabled()) {
			System.out.println("Checkbox is Enabled");
		}
		else {				System.out.println("Checkbox is Disabled");
}
		
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Click the dropdown trigger (triangle icon)
        WebElement trigger = driver.findElement(By.cssSelector(".ui-selectcheckboxmenu-trigger"));
        trigger.click();

        
        
        // 2. Wait for overlay to appear and locate options by text
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ui-selectcheckboxmenu-items-wrapper')]")));

        // 3. Click the labels by text (you can adjust the text here)
        List<WebElement> allLabels = driver.findElements(By.xpath("//div[contains(@class,'ui-selectcheckboxmenu-items-wrapper')]//label"));
        for (WebElement label : allLabels) {
            System.out.println("Option: " + label.getText());
          
                String text = label.getText().trim();
                if (text.equals("London") || text.equals("Paris")) {
                    driver.executeScript("arguments[0].click();", label); // reliable click
                }
            }
        
        // 4. (Optional) Close the dropdown
        trigger.click();

        // 5. (Optional) Print selected text
        WebElement display = driver.findElement(By.cssSelector(".ui-selectcheckboxmenu-multiple-container"));
        System.out.println("Selected: " + display.getText());



        }



	}


