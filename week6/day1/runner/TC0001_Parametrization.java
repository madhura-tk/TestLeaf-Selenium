package runner;

import base.ProjectSpecificMethods;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features/ParameterizationSalesForce.feature"},
							  glue = {"steps","hooks"}, 
							  	dryRun=false ,
							  	publish = true,
							  	monochrome=true,
							  	plugin = {"pretty", "html:target/cucumber-report.html"}
)

public class TC0001_Parametrization extends ProjectSpecificMethods {

}
