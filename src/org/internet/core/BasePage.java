package org.internet.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement findElement(By locator) {
		
		try {
			WebElement element = driver.findElement(locator);
			System.out.println("Element found: " + locator.toString());
			return element;
		}catch(Exception e) {
			System.out.println("Element not found: " + locator.toString());
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public void clickElement(By locator) {
		try {
			driver.findElement(locator).click();
			System.out.println("Element clicked: " + locator.toString());
		}catch(Exception e) {
			System.out.println("Element could not be clicked: " + locator.toString());
			System.out.println(e.getMessage());
		}
		
	}
	
	public String getText(By locator) {
		try {
			System.out.println("Getting Text for: " + locator.toString());
			String text = driver.findElement(locator).getText();
			System.out.println("Text: " + text);
			return text;
		} catch (Exception e) {
			System.out.println("Unable to get Text: " + locator);
			System.out.println(e.getMessage());
			return null;
		}
	}
}
