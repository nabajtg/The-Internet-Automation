package org.internet.scripts;

import org.internet.AutomationSteps;
import org.testng.annotations.Test;

public class TC03_VerifyAddRemovePage{
	
	@Test
	public void runTest() {
		new AutomationSteps()
		.initialize()
		.goToHomePageAndVerify()
		.goToAddRemoveAndVerify()
		.cleanUp();
		
    }
	

    


	
	
	
}
