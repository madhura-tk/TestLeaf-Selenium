package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchFaceBookLogin {
	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		//driver.get("http://leaftaps.com/opentaps/control/main");
		driver.get("https://www.facebook.com/login");
		driver.manage().window().maximize();
		//driver.close();
	}

}
