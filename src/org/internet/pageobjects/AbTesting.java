package org.internet.pageobjects;

import org.internet.core.BasePage;
import org.internet.utils.AssertUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbTesting extends BasePage{
	private WebDriver driver;
	private AssertUtil assertUtil = new AssertUtil();
	
	public AbTesting(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public static final By AB_TESING_LINK = By.xpath("//a[@href='/abtest']");
	public static final By AB_TESING_HEADING = By.cssSelector("div.example h3");
	
	private static final String EXPECTED_AB_HEADING = "A/B Test Variation 1";

	public void goToAbTestingAndVerify() {
		goToAbTesting();
		verifyAbTesting();
		
		assertUtil.assertAll();
		
	}

	private void goToAbTesting() {
		System.out.println("Going To AB Testing");
		clickElement(AB_TESING_LINK);
	}
	
	private void verifyAbTesting() {
		waitForAnElement(AB_TESING_HEADING);
		String actualHeading = getText(AB_TESING_HEADING);
		assertUtil.assertEquals(EXPECTED_AB_HEADING, actualHeading, "AB Testing Heading");
	}
	
	
	
	
	
}
