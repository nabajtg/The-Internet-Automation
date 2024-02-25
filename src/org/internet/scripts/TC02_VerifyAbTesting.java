package org.internet.scripts;

import org.internet.AutomationSteps;
import org.testng.annotations.Test;

public class TC02_VerifyAbTesting {
	@Test
	public void runTest() {
		new AutomationSteps()
		.initialize()
		.goToHomePageAndVerify()
		.goToAbTestingAndVerify()
		.cleanUp();
		
    }
}
