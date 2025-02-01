package org.internet.pageobjects;

import org.internet.utils.AssertUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContextMenu extends BasePage{
	private WebDriver driver;
	private AssertUtil assertUtil = new AssertUtil();
	
	public ContextMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private static final By CONTEXT_MENU_LINK = By.linkText("Context Menu"); 
	private static final By HEADING = By.xpath("//div[@class='example']/h3");
	private static final By CONTEXT_MENU = By.id("hot-spot");
	
	private static final String EXPECTED_HEADING = "Context Menu";
	private static final String EXPECTED_ALLERT_TEXT = "You selected a context menu";
	
	public void goToContextMenuAndVerify() {
		goToContextMenu();
		verifyHeading();
		verifyContextMenu();
		
		assertUtil.assertAll("Context Menu Page");
	}

	private void verifyContextMenu() {
		System.out.println("Right clicking on the Context Menu");
		rightClickElement(CONTEXT_MENU);
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		assertUtil.assertEquals(alertText, EXPECTED_ALLERT_TEXT, "Successfull Context Click");
		alert.accept();
		
	}

	private void verifyHeading() {
		String heading = getText(HEADING);
		assertUtil.assertEquals(heading, EXPECTED_HEADING, "Context Menu Heading");
		
	}

	private void goToContextMenu() {
		System.out.println("Goiing to context menu");
		clickElement(CONTEXT_MENU_LINK);
		
	}

}
