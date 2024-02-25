package org.internet;

import org.internet.pageobjects.AbTesting;
import org.internet.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;

public class PageController {
	public AbTesting abTesting;
	public HomePage homePage;
	
	public PageController initializePageObjects(WebDriver driver) {
		abTesting = new AbTesting(driver);
		homePage = new HomePage(driver);
		return this;
	}
}
