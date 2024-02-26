package org.internet;

import org.internet.pageobjects.AbTesting;
import org.internet.pageobjects.AddRemove;
import org.internet.pageobjects.BasicAuth;
import org.internet.pageobjects.BrokenImages;
import org.internet.pageobjects.ChallengingDom;
import org.internet.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;

public class PageController {
	public HomePage homePage;
	public AbTesting abTesting;
	public AddRemove addRemove;
	public BasicAuth basicAuth;
	public BrokenImages brokenImages;
	public ChallengingDom challengingDom;
	
	public PageController initializePageObjects(WebDriver driver) {
		abTesting = new AbTesting(driver);
		homePage = new HomePage(driver);
		addRemove = new AddRemove(driver);
		basicAuth = new BasicAuth(driver);
		brokenImages = new BrokenImages(driver);
		challengingDom = new ChallengingDom(driver);
		return this;
	}
}
