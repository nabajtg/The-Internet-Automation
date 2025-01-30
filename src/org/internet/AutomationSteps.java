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
	
	public AutomationSteps goToAddRemoveAndVerify() {
		pages.addRemove.goToAddRemoveAndValidate();
		return this;
	}
	
	public AutomationSteps goToBasicAuthAndVerify() {
		pages.basicAuth.goToBasicAuthAndVerify();
		return this;
	}
	
	public AutomationSteps goToBrokenImagesAndVerify() {
		pages.brokenImages.goToBrokenImagesAndVerify();
		return this;
	}
	
	public AutomationSteps goToChanllengingDomAndVerify() {
		pages.challengingDom.goToChanllengingDomAndVerify();
		return this;
	}
	
	public AutomationSteps goToCheckboxesAndVrify() {
		pages.checkboxes.goToCheckboxesAndVrify();
		return this;
	}
	
	public AutomationSteps goToContextMenuAndVerify() {
		pages.contextMenu.goToContextMenuAndVerify();
		return this;
	}
	
	public AutomationSteps cleanUp() {
		driver.quit();
		return this;
	}
	
}
