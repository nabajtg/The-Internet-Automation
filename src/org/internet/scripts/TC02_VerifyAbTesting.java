package org.internet.scripts;

import org.internet.AutomationSteps;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TC02_VerifyAbTesting {
	
	AutomationSteps steps = new AutomationSteps();
	
	@Test
	public void runTest() {
		steps.initialize()
		.goToHomePageAndVerify()
		.goToAbTestingAndVerify()
		;
		
    }
	
	@AfterTest
	public void cleanUp() {
		steps.cleanUp();
	}
}
