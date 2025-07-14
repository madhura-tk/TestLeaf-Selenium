package runner;

import base.ProjectSpecificMethods;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features/ParameterizationSalesForce.feature"},
							  glue = {"steps","hooks"}, 
							  	dryRun=false ,
							  	publish = true,
							  	monochrome=true,
							  	tags="@staticparameters or @dynamicparameters")

public class TC0001_Parametrization extends ProjectSpecificMethods {

}
 
