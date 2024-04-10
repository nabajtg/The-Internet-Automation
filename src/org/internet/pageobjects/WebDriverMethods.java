package org.internet.pageobjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {
	private WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {
		WebDriverMethods webDriverMethods = new WebDriverMethods();
		
		webDriverMethods.windowHandles();
		webDriverMethods.manage();
		webDriverMethods.navigate();
		webDriverMethods.switchTo();
		
		
	}

	private void windowHandles() {
		//WindowHandle
		String handle = driver.getWindowHandle();
		driver.switchTo().window(handle);
		
		//WindowHandles
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
	}
	private void manage() {
		//time outs
		driver.manage().timeouts().getImplicitWaitTimeout();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().timeouts().getPageLoadTimeout();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.manage().timeouts().getScriptTimeout();
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
		
		//window
		driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.manage().window().minimize();	
	}
	private void navigate() {
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().to(String.valueOf("url"));
		
	}
	private void switchTo() {
		driver.switchTo().activeElement();
		driver.switchTo().alert();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().window("nameOrHandle");
		
	}
}
















