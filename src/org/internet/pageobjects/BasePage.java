package org.internet.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement findElement(By locator) {
		
		try {
			WebElement element = driver.findElement(locator);
			System.out.println("Element found: " + locator.toString());
			return element;
		}catch(NoSuchElementException e) {
			System.out.println("Element not found: " + locator.toString());
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
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
	
	public void rightClickElement(By locator) {
		System.out.println("Right Clicking on: " + locator.toString());
		
		WebElement element = findElement(locator);
		try {
			Actions actions = new Actions(driver);
			actions.contextClick(element).build().perform();
		}catch(Exception e) {
			System.out.println("Element could not be right clicked: " + locator.toString());
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(Exception e) {
			System.out.println("Waited for 20 Secs, Could Not found element: " + locator.toString());
			System.out.println(e.getMessage());
		}
	}
	
	public void sleep(int seconds) {
		long miliSec = seconds * 1000;
		try {
			Thread.sleep(miliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
	}
}
