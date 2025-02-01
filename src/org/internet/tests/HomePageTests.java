package org.internet.tests;

import org.internet.AutomationSteps;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class HomePageTests{
	
	AutomationSteps steps = new AutomationSteps();
	
	@Test
	public void runTest() {
		steps.initialize().goToHomePageAndVerify();
		
    }
	
	@AfterTest
	public void cleanUp() {
		steps.cleanUp();
	}
	

    


	
	
	
}
