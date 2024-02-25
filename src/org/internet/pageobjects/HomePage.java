package org.internet.pageobjects;

import org.internet.constants.Constants;
import org.internet.core.BasePage;
import org.internet.locators.Locators;
import org.internet.utils.AssertUtil;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	private WebDriver driver;
	private AssertUtil assertUtil = new AssertUtil();
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void goToHomePageAndVerify() {
		openTheInternetPage();
		verifyHomePage();
		
		assertUtil.assertAll("Home Page");
	}

	private void verifyHomePage() {
		System.out.println("Verifying HomePage");
		String actualHeading = getText(Locators.HOME_PAGE_HEADING);
		assertUtil.assertEquals(Constants.EXPECTED_HOME_PAGE_HEADING, actualHeading, "Home Page Heading");
		
	}

	private void openTheInternetPage() {
		try {
			System.out.println("Going to: " + Constants.URL);
			driver.get(Constants.URL);
		}catch(Exception e) {
			System.out.println("Unable to Open Homepage");
			System.out.println(e.getMessage());
		}
		
		
	}

}
