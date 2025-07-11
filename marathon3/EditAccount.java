package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class EditAccount extends ProjectSpecificMethods{
	@BeforeTest
	public void setFilePath() {
	     filePath="EditAccount";
	     sheetName="formdata";
		}
		
	@Test(dataProvider = "fetchData")
        public void runEditAccount(String accName,String type,String industry,String billingSt,String shippingSt,
        		String custPriority,String SLA,String active,String phno,String upsellOpp) throws InterruptedException {
	
		Thread.sleep(1000);
    	driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(accName + Keys.ENTER);
    	Thread.sleep(1000);

        //driver.findElement(By.xpath("//table/tbody/tr[1]/th[6]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chkbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr[1]/td[2]")));
        chkbutton.click();
        
        //driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).click();
    	Thread.sleep(1000);

        driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).click();
    	Thread.sleep(1000);

        driver.findElement(By.xpath("//a[@title='Edit']")).click();
    	Thread.sleep(1000);

        WebElement typeDD = driver.findElement(By.xpath("//button[@aria-label='Type']"));
    	Thread.sleep(1000);

        driver.executeScript("arguments[0].click()",typeDD);
    	Thread.sleep(1000);

        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+type+"']")).click();
    	Thread.sleep(1000);

        WebElement industryDD = driver.findElement(By.xpath("//button[@aria-label='Industry']"));
    	Thread.sleep(1000);

        driver.executeScript("arguments[0].click()",industryDD);
    	Thread.sleep(1000);

        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+industry+"']")).click();
    	Thread.sleep(1000);

        WebElement biilingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
        biilingStreet.clear();
        biilingStreet.sendKeys(billingSt);
    	Thread.sleep(1000);

        WebElement shippingStreet = driver.findElement(By.xpath("(//label[text()='Shipping Street']/following::textarea)[1]"));
        shippingStreet.clear();
        shippingStreet.sendKeys(shippingSt);
    	Thread.sleep(1000);

        WebElement priorityDD = driver.findElement(By.xpath("//button[@aria-label='Customer Priority']"));
        driver.executeScript("arguments[0].click()",priorityDD);
    	Thread.sleep(1000);

        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+custPriority+"']")).click();
        driver.findElement(By.xpath("//button[@aria-label='SLA']")).click();
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+SLA+"']")).click();
    	Thread.sleep(1000);

        WebElement activeDD = driver.findElement(By.xpath("//button[@aria-label='Active']"));
        driver.executeScript("arguments[0].click()",activeDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+active+"']")).click();
    	Thread.sleep(1000);

		/*
		 * int randomNum1 = (int)(Math.random()*999999); int randomNum2 =
		 * (int)(Math.random()*999999); String phno = ""+randomNum1+randomNum2; phno =
		 * phno.substring(0,10); System.out.println(phno);
		 */
        WebElement phnoField = driver.findElement(By.xpath("//input[@name='Phone']"));
        phnoField.clear();
        phnoField.sendKeys(phno);
    	Thread.sleep(1000);

        WebElement upsellOpportunityDD = driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity']"));
        driver.executeScript("arguments[0].click()",upsellOpportunityDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+upsellOpp+"']")).click();
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
    	Thread.sleep(1000);

        String phnoStr = driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]//a")).getText();
        
        System.out.println(phnoStr);
        
        Assert.assertTrue(phnoStr.contains(phno),"verify the mobileNumber");



    }

}
