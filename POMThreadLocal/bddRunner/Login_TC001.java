package bddRunner;

import base.CommonMethods;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = {"src/test/java/features/LoginTest.feature"},
glue = {"pages"},dryRun = false, publish = true , monochrome = true)

public class Login_TC001 extends CommonMethods{
	

}
