package org.internet.pageobjects;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.internet.utils.AssertUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.model.Headers;
import org.openqa.selenium.devtools.v119.network.Network;
//import org.openqa.selenium.devtools.network.Network;

public class BasicAuth extends BasePage{
	private WebDriver driver;
	private ChromeDriver chromeDriver;// = new ChromeDriver();
	private AssertUtil assertUtil = new AssertUtil();
	
	public BasicAuth(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin";
	
	private static final By BASIC_AUTH_HEADING = By.cssSelector("div.example h3");
	private static final By AUTH_MESSAGE = By.cssSelector("div.example p");
	
	private static final String EXPECTED_HEADING = "Basic Auth";
	private static final String EXPECTED_MESSAGE = "Congratulations! You must have the proper credentials.";
	
	public void goToBasicAuthAndVerify() {
//		setUpAuthData();
//		authenticate();
//		verifyAuthSuccess();
//		
//		assertUtil.assertAll("BASIC AUTH PAGE");
	}

	private void verifyAuthSuccess() {
		String actualHeading = getText(BASIC_AUTH_HEADING);
		assertUtil.assertEquals(actualHeading, EXPECTED_HEADING, "Basic Auth Heading");
		
		String actualMessage = getText(AUTH_MESSAGE);
		assertUtil.assertEquals(actualMessage, EXPECTED_MESSAGE, "Basic Auth Message");
	}

	private void authenticate() {
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
	}

	private void setUpAuthData() {
		DevTools devTools = chromeDriver.getDevTools();
        devTools.createSession();

        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.of(100000), Optional.of(100000), Optional.of(100000)));
        String auth = USERNAME + ":" + PASSWORD;

        // Encoding the username and password using Base64 (java.util)
        String encodeToString = Base64.getEncoder().encodeToString(auth.getBytes());

        // Pass the network header -> Authorization : Basic <encoded String>
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Basic " + encodeToString);
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        
		
	}

}
