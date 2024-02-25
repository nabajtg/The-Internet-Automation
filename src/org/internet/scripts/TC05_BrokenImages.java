package org.internet.scripts;

import org.internet.AutomationSteps;
import org.testng.annotations.Test;

public class TC05_BrokenImages {
	
	@Test
	public void runTest() {
		new AutomationSteps()
		.initialize()
		.goToHomePageAndVerify()
		.goToBrokenImagesAndVerify()
		.cleanUp();
		
    }
	
}
