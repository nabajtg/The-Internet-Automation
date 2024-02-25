package org.internet.core;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public boolean isElementVisible(By locator) {
		try {
			driver.findElement(locator);
			System.out.println("Element visible: " + locator.toString());
			return true;
		}catch(Exception e) {
			System.out.println("Element not visible: " + locator.toString());
			return false;
		}
	}
	
	public void waitForAnElement(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(driver -> ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(Exception e) {
			System.out.println("Waited for 20 Secs, Could Not found element: " + locator.toString());
			System.out.println(e.getMessage());
		}
	}
}
