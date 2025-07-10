package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features/SalesForceModule.feature"},glue = {"steps"}, publish = true,monochrome=true)

public class TC001_CreateAccountSF extends AbstractTestNGCucumberTests {

}
