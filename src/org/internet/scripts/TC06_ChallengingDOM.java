package org.internet.scripts;

import org.internet.AutomationSteps;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TC06_ChallengingDOM {
	AutomationSteps steps = new AutomationSteps();
	
	@Test
	public void runTest() {
		steps.initialize()
		.goToHomePageAndVerify()
		.goToChanllengingDomAndVerify()
		;
		
    }
	
	@AfterTest
	public void cleanUp() {
		steps.cleanUp();
	}
	
}
