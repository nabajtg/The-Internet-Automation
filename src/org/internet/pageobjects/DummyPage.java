package org.internet.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class DummyPage extends LoadableComponent<DummyPage>{

    private WebDriver driver;

    @FindBy(id = "APjFqb")
    private WebElement textBox; 

    @FindBy(name = "btnK")
    private WebElement searchButton; 

    public DummyPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get("https://www.google.com");
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        System.out.println("Loaded: " + url);
    }

    public void enterTextInSearchBox(String term){
        textBox.clear();
        textBox.sendKeys(term, Keys.ENTER);
        // textBox.sendKeys(Keys.ENTER);
    }

    public void pressEnter(){
        
    }

    public void clickSearchButton(){
        searchButton.click();
    }


    public static void main(String[] args) {
        DummyPage page = new DummyPage(new ChromeDriver());
        page.get();
        // page.load();
        // page.isLoaded();

        page.enterTextInSearchBox("Is Sudharsana Gogoi an Elephant?");
        
        // page.clickSearchButton();


        // page.wait();

    }

}
