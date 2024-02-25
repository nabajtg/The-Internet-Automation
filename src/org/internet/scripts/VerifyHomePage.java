package org.internet.scripts;

import org.internet.AutomationSteps;
import org.testng.annotations.Test;

public class VerifyHomePage{
	
	@Test
	public void runTest() {
		new AutomationSteps()
		.initialize()
		.goToHomePageAndVerify();
		
    }
	

    


	
	
	
}
