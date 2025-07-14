package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.*;

public class ParamStepDefinition extends ProjectSpecificMethods{
	String strAcctName;
	String phoneNo;
	@When("the user enters the username  as {string}")
	public void the_user_enters_the_username_as(String uname) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);


	}

	@When("the user enters the password as {string}")
	public void the_user_enters_the_password_as(String pwd) {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);


	}

	@When("the user clicks the login button")
	public void the_user_clicks_the_login_button() {

		driver.findElement(By.xpath("//input[@id='Login']")).click();

	}

	@Then("the user should be navigated to the SalesForce Home Page")
	public void the_user_should_be_navigated_to_the_sales_force_home_page() {
		String title=driver.getTitle();
		System.out.println(title);


	}

	@When("the user clicks the App Launcher Icon")
	public void the_user_clicks_the_app_launcher_icon() {

		// Click the App Launcher Icon
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement appLauncherIcon = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//one-app-launcher-header/button")));
		actions.moveToElement(appLauncherIcon).pause(Duration.ofSeconds(2)).perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", appLauncherIcon);
	
	}

	@When("the User clicks the View All link")
	public void the_user_clicks_the_view_all_link() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();// View All Tab clicked


	}

	@When("the user scroll down the window")
	public void the_user_scroll_down_the_window() {
		// Scrolling the Window to click the Accounts
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement targetElement=driver.findElement(By.xpath("//p[text()='Accounts']"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", targetElement);
		boolean isDisplayed = targetElement.isDisplayed(); // returns true/false
		System.out.println(isDisplayed);


	}

	@When("the user clicks the Accounts link")
	public void the_user_clicks_the_accounts_link() {

		driver.findElement(By.xpath("//p[text()='Accounts']")).click();

	}

	@Then("the user navigates to the Accounts page")
	public void the_user_navigates_to_the_accounts_page() {

		String title=driver.getTitle();
		System.out.println(title);

	}

	@When("the user types the name in the Search box as {string}")
	public void the_user_types_the_name_in_the_Search_box_as(String searchAcct) {

		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(searchAcct+Keys.ENTER);
	}

	@When("the user clicks the dropdown of the first account from the result")
	public void the_user_clicks_the_dropdown_of_the_first_account_from_the_result() {
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).click();

		
	}

	@When("the user clicks the Edit option")
	public void the_user_clicks_the_edit_option() {

        driver.findElement(By.xpath("//a[@title='Edit']")).click();

	}

	@Then("the user navigates to the Edit page")
	public void the_user_navigates_to_the_edit_page() {
		System.out.println(driver.getTitle());

	}

	@When("the user selects the Type as  {string}")
	public void the_user_selects_the_type_as(String type) {
        WebElement typeDD = driver.findElement(By.xpath("//button[@aria-label='Type']"));
        driver.executeScript("arguments[0].click()",typeDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+type+"']")).click();


	}

	@When("the user sets the Industry as  {string}")
	public void the_user_sets_the_industry_as(String industry) {
        WebElement industryDD = driver.findElement(By.xpath("//button[@aria-label='Industry']"));
        driver.executeScript("arguments[0].click()",industryDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+industry+"']")).click();


	}

	@When("the user enters the Billing address as  {string}")
	public void the_user_enters_the_billing_address_as(String billAdd) {

        WebElement biilingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
        biilingStreet.clear();
        biilingStreet.sendKeys(billAdd);

	}

	@When("the user enters the Shipping address as  {string}")
	public void the_user_enters_the_shipping_address_as(String shipAdd) {
		WebElement shippingStreet = driver.findElement(By.xpath("(//label[text()='Shipping Street']/following::textarea)[1]"));
        shippingStreet.clear();
        shippingStreet.sendKeys(shipAdd);

	}

	@When("the user sets the CustomerPriority as  {string}")
	public void the_user_sets_the_customer_priority_as(String custprior) {
        WebElement priorityDD = driver.findElement(By.xpath("//button[@aria-label='Customer Priority']"));
        driver.executeScript("arguments[0].click()",priorityDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Low']")).click();

	}

	@When("the user sets the SLA as  {string}")
	public void the_user_sets_the_sla_as(String SLA) {
        driver.findElement(By.xpath("//button[@aria-label='SLA']")).click();
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+SLA+"']")).click();


	}

	@When("the user sets the Active as  {string}")
	public void the_user_sets_the_active_as(String active) {

        WebElement activeDD = driver.findElement(By.xpath("//button[@aria-label='Active']"));
        driver.executeScript("arguments[0].click()",activeDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+active+"']")).click();

	}

	@When("the user enters the phoneno as  {int}")
	public void the_user_enters_the_phoneno_as(int phno) {
        WebElement phnoField = driver.findElement(By.xpath("//input[@name='Phone']"));
        phnoField.clear();
        phnoField.sendKeys(Integer.toString(phno));
        phoneNo=Integer.toString(phno);

	}

	@When("the user sets the UpSellOpp as {string}")
	public void the_user_sets_the_up_sell_opp_as(String upsellOpp) {
        WebElement upsellOpportunityDD = driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity']"));
        driver.executeScript("arguments[0].click()",upsellOpportunityDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+upsellOpp+"']")).click();


	}

	@Then("the user clicks the Save button")
	public void the_user_clicks_the_save_button() {

        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

	}

	@Then("the user verifies the phoneno")
	public void the_user_verifies_the_phoneno() {

        String phnoStr = driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]//a")).getText();
        
        System.out.println(phnoStr);
        
        Assert.assertTrue(phnoStr.contains(phoneNo),"verify the mobileNumber");

	}

	@When("the user types the name in the search box as (.*)$")
	public void the_user_types_the_name_in_the_search_box_as_madhura(String acctname) {
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(acctname+Keys.ENTER);
		strAcctName=acctname;

	}

	@When("the user selects the ownership as (.*)$")
	public void the_user_selects_the_ownership_as_public(String ownership) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement targetElement=driver.findElement(By.xpath("//label[text()='Ownership']"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", targetElement);
		boolean isDisplayed = targetElement.isDisplayed(); // returns true/false
		System.out.println(isDisplayed);
		driver.findElement(By.xpath("//div/label[text()='Ownership']/following::div[1]")).click();
		driver.findElement(By.xpath("//span[text()='"+ownership+"']")).click();

	}

	@Then("the user verifies the account name")
	public void the_user_verifies_the_account_name() {
		    WebElement toast=driver.findElement(By.xpath("//span[contains(@class,'toast')]"));

		String name = toast.getText();
		System.out.println("Toast: " + name);
        Assert.assertTrue(name.contains(strAcctName),"verify the AccountName");


	}


}
