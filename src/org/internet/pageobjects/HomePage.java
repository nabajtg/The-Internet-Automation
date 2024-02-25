package org.internet.pageobjects;

import org.internet.constants.Constants;
import org.internet.core.BasePage;
import org.internet.locators.CommonLocators;
import org.internet.utils.AssertUtil;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	private WebDriver driver;
	private AssertUtil assertUtil = new AssertUtil();
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public static final String URL = "https://the-internet.herokuapp.com/";
	public static final String EXPECTED_HOME_PAGE_HEADING = "Welcome to the-internet";
	
	public void goToHomePageAndVerify() {
		openTheInternetPage();
		verifyHomePage();
		
		assertUtil.assertAll("Home Page");
	}

	private void verifyHomePage() {
		System.out.println("Verifying HomePage");
		String actualHeading = getText(CommonLocators.HOME_PAGE_HEADING);
		assertUtil.assertEquals(EXPECTED_HOME_PAGE_HEADING, actualHeading, "Home Page Heading");
		
	}

	private void openTheInternetPage() {
		try {
			System.out.println("Going to: " + URL);
			driver.get(URL);
		}catch(Exception e) {
			System.out.println("Unable to Open Homepage");
			System.out.println(e.getMessage());
		}
		
		
	}

}
