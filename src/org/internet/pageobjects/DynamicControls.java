package org.internet.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DynamicControls {
	@Test
	public void test() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		
//		By checkBox = By.cssSelector("input[type='checkbox']");
//		By checkBoxText = By.id("checkbox");
//		
//		driver.findElement(checkBox).click();
//		System.out.println(driver.findElement(checkBoxText).getText());
//		
//		By removeButton = By.xpath("//button[text()='Remove']");
//		By addButton = By.xpath("//button[text()='Add']");
//		
//		driver.findElement(removeButton).click();
//		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(checkBox));
//		
//		driver.findElement(addButton).click();
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(checkBox));
//		
//		driver.findElement(checkBox).click();
		
		By enableButton = By.xpath("//button[text()='Enable']");
		By textBox = By.cssSelector("input[type='text']");
		
		driver.findElement(enableButton).click();
		
		WebElement box = driver.findElement(textBox);
		wait.until(d -> box.isEnabled());
		
		box.sendKeys("Hello");
		
	}
}
