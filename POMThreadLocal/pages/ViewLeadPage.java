
package pages;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.CommonMethods;
import io.cucumber.java.en.Then;

	public class ViewLeadPage extends CommonMethods {
		
		public ViewLeadPage(ChromeDriver driver) {
			this.driver=driver;
		}

		@Then ("the user verify th e status of lead creation" )
		public void verifyStatus() {
			String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
			if (text.contains("Testleaf")) {
				System.out.println("Lead created successfully");
			} else {
				System.out.println("Lead is not created");

			}

		}

	/*	public EditLeadPage clickEditButton() {
			driver.findElement(By.linkText("Edit")).click();
			return new EditLeadPage();
		}
*/
		public void verifyUpdateStatus() {
			String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
			if (text.contains("Google")) {
				System.out.println("Lead is editted successfully");
			} else {
				System.out.println("Lead is not editted");
			}

		}

	}


	
