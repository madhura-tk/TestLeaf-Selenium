package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class CommonMethods extends AbstractTestNGCucumberTests {
	
private static	final ThreadLocal <RemoteWebDriver> rd = new ThreadLocal<RemoteWebDriver>();

	public  RemoteWebDriver getDriver() {
		return rd.get();
	}

	public void setDriver(RemoteWebDriver driver) {
		rd.set(driver);  
	}



	@BeforeMethod
	public void preCondition() {
		String url ="http://leaftaps.com/opentaps/control/main";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
	    setDriver(new ChromeDriver(options));// Chrome Driver Initialization is done here
	    System.out.println("Driver value"+getDriver());
	    getDriver().manage().window().maximize();
		getDriver().get(url);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@AfterMethod
	public void postCondition() {

		getDriver().quit();
	}
	
}
