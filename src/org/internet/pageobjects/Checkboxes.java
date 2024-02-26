package org.internet.pageobjects;

import java.util.List;

import org.internet.core.BasePage;
import org.internet.utils.AssertUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkboxes extends BasePage{
	private WebDriver driver;
	private AssertUtil assertUtil = new AssertUtil();
	
	public Checkboxes(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private static final By CHECK_BOXES_LINK = By.linkText("Checkboxes");
	private static final By HEADING = By.xpath("//div[@class='example']/h3");
	private static final By CHECK_BOXES = By.cssSelector("input[type='checkbox']");
	////*[@id="checkboxes"]/text()[1]
	private static final By CHECK_BOX_TEXT = By.xpath("//*[@id='checkboxes']/text()[1]");
	
	private static final String EXPECTED_HEADING = "Checkboxes";
	private static final int EXPECTED_NO_OF_CHECKBOX = 2;
	
	public void goToCheckboxesAndVrify() {
		goToCheckboxesPage();
		verifyHeading();
		verifyCheckBoxes();
		
		assertUtil.assertAll("Check Boxes Page");
	}

	private void verifyCheckBoxes() {
		List<WebElement> checkBoxes = findElements(CHECK_BOXES);
		assertUtil.assertEquals(checkBoxes.size(), EXPECTED_NO_OF_CHECKBOX, "No of Checkboxes");
		
		if(!checkBoxes.isEmpty()) {// && !checkBoxesTexts.isEmpty()) {
			assertUtil.assertFalse(checkBoxes.get(0).isSelected(), "Check box 1 is not selected");
			assertUtil.assertTrue(checkBoxes.get(1).isSelected(), "Check box 2 is selected");
		}
		
		
		
	}

	private void verifyHeading() {
		waitForAnElement(HEADING);
		String heading = getText(HEADING);
		assertUtil.assertEquals(heading, EXPECTED_HEADING, "Checkbox Heading");
	}

	private void goToCheckboxesPage() {
		System.out.println("Going to Check Boxes Link");
		clickElement(CHECK_BOXES_LINK);
	}

}
