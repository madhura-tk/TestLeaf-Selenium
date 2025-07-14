package hooks;

import base.ProjectSpecificMethods;
import io.cucumber.java.BeforeStep;

public class HooksImplementations extends ProjectSpecificMethods {

	
	@BeforeStep
	public void slowMo() throws InterruptedException {
		Thread.sleep(1000);
	}
	
}