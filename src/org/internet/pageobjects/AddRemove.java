package org.internet.pageobjects;

import org.internet.core.BasePage;
import org.internet.locators.AddRemoveLocators;
import org.internet.locators.CommonLocators;
import org.internet.utils.AssertUtil;
import org.openqa.selenium.WebDriver;

public class AddRemove extends BasePage{
	private WebDriver driver;
	private AssertUtil assertUtil = new AssertUtil();
	
	public AddRemove(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private static final String EXPECTED_HEADING = "Add/Remove Elements";
	
	public void goToAddRemoveAndValidate() {
		goToAddRemove();
		verifyAddRemoveHeading();
		clickOnAddButton();
		if(verifyDeleteButtonVisible()) {
			clickDeleteButton();
			verifyDeleteButtonNotVisible();
		}
		
		assertUtil.assertAll("Add Remove Page");
		
	}

	private void verifyDeleteButtonNotVisible() {
		boolean status = isElementVisible(AddRemoveLocators.DELETE_BUTTON);
		assertUtil.assertEquals(status, false, "Delete Button is not Visible");
	}

	private void clickDeleteButton() {
		clickElement(AddRemoveLocators.DELETE_BUTTON);		
	}

	private boolean verifyDeleteButtonVisible() {
		boolean status = isElementVisible(AddRemoveLocators.DELETE_BUTTON);
		assertUtil.assertEquals(status, true, "Delete Button is Visible");
		return status;		
	}

	private void clickOnAddButton() {
		clickElement(AddRemoveLocators.ADD_ELEMENT_BUTTON);		
	}

	private void verifyAddRemoveHeading() {
		waitForAnElement(AddRemoveLocators.ADD_REMOVE_HEADING);
		String actualHeading = getText(AddRemoveLocators.ADD_REMOVE_HEADING);
		assertUtil.assertEquals(actualHeading, EXPECTED_HEADING, "Add Remove Heading");		
	}

	private void goToAddRemove() {
		System.out.println("Going to Add Remove Page");
		clickElement(CommonLocators.ADD_REMOVE_LINK);
	}

	
}
