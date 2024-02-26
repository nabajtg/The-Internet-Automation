package org.internet.pageobjects;

import org.internet.core.BasePage;
import org.internet.utils.AssertUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemove extends BasePage{
	private WebDriver driver;
	private AssertUtil assertUtil = new AssertUtil();
	
	public AddRemove(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public static final By ADD_REMOVE_HEADING = By.cssSelector("div#content h3");
	public static final By ADD_ELEMENT_BUTTON = By.xpath("//button[text()='Add Element']");
	public static final By DELETE_BUTTON = By.cssSelector("button.added-manually");
	public static final By ADD_REMOVE_LINK = By.linkText("Add/Remove Elements");
	
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
		boolean status = isElementVisible(DELETE_BUTTON);
		assertUtil.assertEquals(status, false, "Delete Button is not Visible");
	}

	private void clickDeleteButton() {
		clickElement(DELETE_BUTTON);		
	}

	private boolean verifyDeleteButtonVisible() {
		boolean status = isElementVisible(DELETE_BUTTON);
		assertUtil.assertEquals(status, true, "Delete Button is Visible");
		return status;		
	}

	private void clickOnAddButton() {
		clickElement(ADD_ELEMENT_BUTTON);		
	}

	private void verifyAddRemoveHeading() {
		waitForAnElement(ADD_REMOVE_HEADING);
		String actualHeading = getText(ADD_REMOVE_HEADING);
		assertUtil.assertEquals(actualHeading, EXPECTED_HEADING, "Add Remove Heading");		
	}

	private void goToAddRemove() {
		System.out.println("Going to Add Remove Page");
		clickElement(ADD_REMOVE_LINK);
	}

	
}
