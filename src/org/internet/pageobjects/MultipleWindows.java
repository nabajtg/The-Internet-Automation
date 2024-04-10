package org.internet.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleWindows {
	@Test
	public void test() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/windows");
		
		By newWin = By.xpath("//a[@href='/windows/new']");
		driver.findElement(newWin).click();
		
		String mainWindow = driver.getWindowHandle(); 
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String newWindow = null;
		while(it.hasNext()) {
			newWindow = it.next();
		}
		driver.switchTo().window(newWindow);
		System.out.println("New window:- " + driver.findElement(By.tagName("h3")).getText());
		driver.close();
		
		driver.switchTo().window(mainWindow);
	}
	
}
