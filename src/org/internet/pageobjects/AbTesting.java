package org.internet.pageobjects;

import org.internet.core.BasePage;
import org.internet.locators.AbLocators;
import org.internet.locators.CommonLocators;
import org.internet.utils.AssertUtil;
import org.openqa.selenium.WebDriver;
import org.internet.locators.CommonLocators;

public class AbTesting extends BasePage{
	private WebDriver driver;
	private AssertUtil assertUtil = new AssertUtil();
	
	public AbTesting(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private static final String EXPECTED_AB_HEADING = "A/B Test Variation 1";

	public void goToAbTestingAndVerify() {
		goToAbTesting();
		verifyAbTesting();
		
		assertUtil.assertAll();
		
	}

	private void goToAbTesting() {
		System.out.println("Going To AB Testing");
		clickElement(CommonLocators.AB_TESING_LINK);
	}
	
	private void verifyAbTesting() {
		waitForAnElement(AbLocators.AB_TESING_HEADING);
		String actualHeading = getText(AbLocators.AB_TESING_HEADING);
		assertUtil.assertEquals(EXPECTED_AB_HEADING, actualHeading, "AB Testing Heading");
	}
	
	
	
	
	
}
