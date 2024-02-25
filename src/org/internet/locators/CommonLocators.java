package org.internet.locators;

import org.openqa.selenium.By;

public class CommonLocators {
	public static final By HOME_PAGE_HEADING = By.cssSelector("div#content h1.heading");
	public static final By AB_TESING_LINK = By.xpath("//a[@href='/abtest']");
	public static final By ADD_REMOVE_LINK = By.linkText("Add/Remove Elements");
}
