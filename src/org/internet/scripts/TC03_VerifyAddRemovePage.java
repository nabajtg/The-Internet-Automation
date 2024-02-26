package org.internet.scripts;

import org.internet.AutomationSteps;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TC03_VerifyAddRemovePage{
	
	AutomationSteps steps = new AutomationSteps();
	
	@Test
	public void runTest() {
		steps.initialize()
		.goToHomePageAndVerify()
		.goToAddRemoveAndVerify()
		;
		
    }
	
	@AfterTest
	public void cleanUp() {
		steps.cleanUp();
	}

}
