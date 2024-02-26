package org.internet.pageobjects;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import org.internet.core.BasePage;
import org.internet.utils.AssertUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenImages extends BasePage{
	private WebDriver driver;
	private AssertUtil assertUtil = new AssertUtil();
	
	public BrokenImages(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private static final By BROKEN_IMAGES_LINK = By.linkText("Broken Images");
	private static final By HEADING = By.cssSelector("div.example h3");
	private static final By IMAGES = By.cssSelector("div.example img");
	
	private static final String EXPECTED_HEADING = "Broken Images";
	private static final int EXPECTED_NO_OF_IMAGES = 3;
	
	public void goToBrokenImagesAndVerify() {
		goToBrokenImages();
		verifyHeading();
		verifyImages();
		
		assertUtil.assertAll("BROKEN IMAGES PAGE");
	}

	private void verifyImages() {
		HttpClient client = HttpClient.newHttpClient();
		
		List<WebElement> images = findElements(IMAGES);
		assertUtil.assertEquals(images.size(), EXPECTED_NO_OF_IMAGES, "No of Images Found");
		
		if(!images.isEmpty()) {
			images.forEach(image->{
				String imageUri = image.getAttribute("src");
				HttpRequest request = HttpRequest.newBuilder()
						.uri(URI.create(imageUri))
						.build();
				try {
					HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
					assertUtil.assertEquals(response.statusCode(), 200, "Image GET status code");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});
			
		}
		
	}

	private void verifyHeading() {
		waitForAnElement(HEADING);
		String actualHeading = getText(HEADING);
		assertUtil.assertEquals(actualHeading, EXPECTED_HEADING, "BROKEN IMAGES HEADING");
		
	}

	private void goToBrokenImages() {
		System.out.println("Going to Broken Images");
		clickElement(BROKEN_IMAGES_LINK);
		
	}

}
