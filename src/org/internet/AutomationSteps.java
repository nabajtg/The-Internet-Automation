package org.internet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationSteps {
	private WebDriver driver;
	private PageController pages;
	
	public AutomationSteps initialize() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		pages = new PageController().initializePageObjects(driver);
		return this;
	}
	
	public AutomationSteps goToHomePageAndVerify() {
		pages.homePage.goToHomePageAndVerify();
		return this;
	}
	
	public AutomationSteps goToAbTestingAndVerify() {
		pages.abTesting.goToAbTestingAndVerify();
		return this;
	}
	
}
