package bddRunner;

import org.testng.annotations.DataProvider;

import base.CommonMethods;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = {"src/test/java/features/LoginTest.feature"},
glue = {"pages"},dryRun = false, publish = true , monochrome = true)


public class Login_TC001 extends CommonMethods{
	
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios(); // Enables Cucumber scenarios to run in parallel
    }

}
