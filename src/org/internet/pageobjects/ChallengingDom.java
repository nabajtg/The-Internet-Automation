package org.internet.pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.internet.utils.AssertUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChallengingDom extends BasePage{
	private WebDriver driver;
	private AssertUtil assertUtil = new AssertUtil();
	
	public ChallengingDom(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private static final By CHALLENGING_DOM_LINK = By.linkText("Challenging DOM");
	private static final By HEADING = By.cssSelector("div.example h3");
	private static final By BUTTON_1 = By.cssSelector("div.large-2.columns a.button"); //By.className("button");
	private static final By BUTTON_2 = By.cssSelector("div.large-2.columns a.button.alert");
	private static final By BUTTON_3 = By.cssSelector("div.large-2.columns a.button.success");
	private static final By TABLE_HEADERS = By.xpath("//thead/tr/th");
	private static final By TABLE_ROWS = By.cssSelector("table tbody tr");
	private static final By TABLE_DATA = By.tagName("td");
	private static final By EDIT_LINK = By.cssSelector("a[href='#edit']");
	private static final By DELETE_LINK = By.xpath("//a[@href='#delete']");
	private static final By CANVAS = By.id("canvas");
	
	private static final String EXPECTED_HEADING = "Challenging DOM";
	private static final List<String> EXPECTED_TABLE_HEADERS = Arrays.asList("Lorem", "Ipsum", "Dolor", "Sit", "Amet",
			"Diceret", "Action");
	private static final List<String> EXPECTED_DATA_PREFIXES = Arrays.asList("Iuvaret", "Apeirian", "Adipisci", 
			"Definiebas", "Consequuntur", "Phaedrum");
	private static final int EXPECTED_NO_OF_HEADERS = 7;
	private static final int EXPECTED_NO_OF_ROWS = 10;
	private static final int EXPECTED_NO_OF_DATA = 7;
	
	public void goToChanllengingDomAndVerify() {
		goToChanllengingDom();
		verifyHeading();
		verifyButtonClick();
		verifyTable();
		verifyCanvas();
		
		assertUtil.assertAll("Challenging DOM PAGE");
	}

	private void verifyCanvas() {
		String canvasText = getText(CANVAS);
		assertUtil.assertTrue(canvasText.contains("Answer:"), "Canvas Text");
		
	}

	private void verifyTable() {
		verifyTableHeaders();
		verifyTableData();
	}

	private void verifyTableData() {
		List<WebElement> tableRows = findElements(TABLE_ROWS);
		assertUtil.assertEquals(tableRows.size(), EXPECTED_NO_OF_ROWS, "No of Table Rows");
		
		for(int i=0; i<tableRows.size(); i++) {
			List<WebElement> tableData = tableRows.get(i).findElements(TABLE_DATA);
			assertUtil.assertEquals(tableData.size(), EXPECTED_NO_OF_DATA, "No of Table Data for Row: " + i);
			
			for(int j=0; j<tableData.size()-1; j++) {
				String expectedTableData = EXPECTED_DATA_PREFIXES.get(j) + i;
				String actualTableData = tableData.get(j).getText();
				assertUtil.assertEquals(actualTableData, expectedTableData, "Table Data, Row: " + (i+1) + ", Column: " + (j+1));
				
			}
			
			verifyActionData(tableData.get(tableData.size()-1), i);
			
			
		}
		
	}

	private void verifyActionData(WebElement actionData, int rowNumber) {
		String editLinkText = actionData.findElement(EDIT_LINK).getText();
		assertUtil.assertEquals(editLinkText, "edit", "Action Data Edit Text Row: " + (rowNumber+1));
		
		String deleteLinkText = actionData.findElement(DELETE_LINK).getText();
		assertUtil.assertEquals(deleteLinkText, "delete", "Action Data Delete Text Row: " + (rowNumber+1));
	}

	private void verifyTableHeaders() {
		System.out.println("Verifying table headers");
		
		List<WebElement> headers = findElements(TABLE_HEADERS);
		assertUtil.assertEquals(headers.size(), EXPECTED_NO_OF_HEADERS, "No of Table headers");
		
		List<String> actualHeaders = new ArrayList<String>();
		System.out.println("Table headers:- ");
		headers.forEach(header->{
			System.out.print(header.getText() + ", ");
			actualHeaders.add(header.getText());
		});
		System.out.println();
		assertUtil.assertEquals(actualHeaders, EXPECTED_TABLE_HEADERS, "Table Headers");
		
	}

	private void verifyButtonClick() {
		System.out.println("Clicking Button 1");
		clickElement(BUTTON_1);
		
		System.out.println("Clicking Button 2");
		clickElement(BUTTON_2);
		
		System.out.println("Clicking Button 3");
		clickElement(BUTTON_3);
	}

	private void verifyHeading() {
		waitForAnElement(HEADING);
		String heading = getText(HEADING);
		assertUtil.assertEquals(heading, EXPECTED_HEADING, "Challenging dom page Heading");	
	}

	private void goToChanllengingDom() {
		System.out.println("Going to Chanllenging Dom");
		clickElement(CHALLENGING_DOM_LINK);
		
	}
	
}
