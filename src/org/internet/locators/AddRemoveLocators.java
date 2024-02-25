package org.internet.locators;

import org.openqa.selenium.By;

public class AddRemoveLocators {
	public static final By ADD_REMOVE_HEADING = By.cssSelector("div#content h3");
	public static final By ADD_ELEMENT_BUTTON = By.xpath("//button[text()='Add Element']");
	public static final By DELETE_BUTTON = By.cssSelector("button.added-manually");
}
