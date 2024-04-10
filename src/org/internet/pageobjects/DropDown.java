package org.internet.pageobjects;

import java.util.List;

import org.internet.utils.AssertUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDown {
	
	@Test
	public void runTest() {
		AssertUtil assertUtil = new AssertUtil();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/dropdown");
		
		WebElement dropDown = driver.findElement(By.id("dropdown"));
		Select select = new Select(dropDown);
		
		select.selectByValue("1");
		
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
		
		List<WebElement> options = select.getOptions();
		options.forEach(op->{
			if(op.isEnabled()) {
					select.selectByVisibleText(op.getText());
			}else {
				System.out.println("Not enabled: " + op.getText());
			}
		});
		
		
	}
	
	
}
