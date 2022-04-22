package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class utilityClass extends baseClass{
	
	
/***************** Method to clear text field *****************/	
	public void clearfield(String type, String fieldname){

		switch (type.toLowerCase()) {
		
		case "name" : getDriver().findElement(By.name(fieldname)).isDisplayed();
		getDriver().findElement(By.name(fieldname)).clear();
		break;
		
		case "id" : getDriver().findElement(By.id(fieldname)).isDisplayed();
		getDriver().findElement(By.id(fieldname)).clear();
		break;
		
		case "xpath" : getDriver().findElement(By.xpath(fieldname)).isDisplayed();
		getDriver().findElement(By.xpath(fieldname)).clear();
		break;
		
		case "cssSelector" : getDriver().findElement(By.cssSelector(fieldname)).isDisplayed();
		getDriver().findElement(By.cssSelector(fieldname)).clear();
		break;
		
		}
	}
	
	/***************** Method to clear text field with more than one same locator*****************/	
	public void clearfield(String type, String fieldname, int number){

		switch (type.toLowerCase()) {
		
		case "name" : getDriver().findElements(By.name(fieldname)).get(number).isDisplayed();
		getDriver().findElements(By.name(fieldname)).get(number).clear();
		break;
		
		case "id" : getDriver().findElements(By.id(fieldname)).get(number).isDisplayed();
		getDriver().findElements(By.id(fieldname)).get(number).clear();
		break;
		
		case "xpath" : getDriver().findElements(By.xpath(fieldname)).get(number).isDisplayed();
		getDriver().findElements(By.xpath(fieldname)).get(number).clear();
		break;
		
		case "cssselector" : getDriver().findElements(By.cssSelector(fieldname)).get(number).isDisplayed();
		getDriver().findElements(By.cssSelector(fieldname)).get(number).clear();
		break;
		
		}
	}
	
/***********************Method to input a  text box **************************/
	public void inputfield(String type, String fieldname, String input){

		switch (type.toLowerCase()) {
		
		case "name" : getDriver().findElement(By.name(fieldname)).isDisplayed();
		getDriver().findElement(By.name(fieldname)).sendKeys(input);
		break;
		
		case "id" : getDriver().findElement(By.id(fieldname)).isDisplayed();
		getDriver().findElement(By.id(fieldname)).sendKeys(input);
		break;
		
		case "xpath" : getDriver().findElement(By.xpath(fieldname)).isDisplayed();
		getDriver().findElement(By.xpath(fieldname)).sendKeys(input);
		break;
		
		case "cssselector" : getDriver().findElement(By.cssSelector(fieldname)).isDisplayed();
		getDriver().findElement(By.cssSelector(fieldname)).sendKeys(input);
		break;
		
		}
	}
	
	/***********************Method to input a  text box with more than one same locator **************************/
	public void inputfield(String type, String fieldname, String input, int number){

		switch (type.toLowerCase()) {
		
		case "name" : getDriver().findElements(By.name(fieldname)).get(number).isDisplayed();
		getDriver().findElements(By.name(fieldname)).get(number).sendKeys(input);
		break;
		
		case "id" : getDriver().findElements(By.id(fieldname)).get(number).isDisplayed();
		getDriver().findElements(By.id(fieldname)).get(number).sendKeys(input);
		break;
		
		case "xpath" : getDriver().findElements(By.xpath(fieldname)).get(number).isDisplayed();
		getDriver().findElements(By.xpath(fieldname)).get(number).sendKeys(input);
		break;
		
		case "cssselector" : getDriver().findElements(By.cssSelector(fieldname)).get(number).isDisplayed();
		getDriver().findElements(By.cssSelector(fieldname)).get(number).sendKeys(input);
		break;
		
		}
	}

	
	/***********************Method to click a link/button**************************/
	public void clickfield(String type, String fieldname){

		switch (type.toLowerCase()) {
		
		case "name" : getDriver().findElement(By.name(fieldname)).isDisplayed();
		getDriver().findElement(By.name(fieldname)).click();
		break;
		
		case "id" : getDriver().findElement(By.id(fieldname)).isDisplayed();
		getDriver().findElement(By.id(fieldname)).click();
		break;
		
		case "xpath" : getDriver().findElement(By.xpath(fieldname)).isDisplayed();
		getDriver().findElement(By.xpath(fieldname)).click();
		break;
		
		case "cssselector" : getDriver().findElement(By.name(fieldname)).isDisplayed();
		getDriver().findElement(By.cssSelector(fieldname)).click();
		break;
		
		}
	}

	/***********************Method to click a link/button with more than one same locator**************************/
	public void clickfield(String type, String fieldname, int number){

		switch (type.toLowerCase()) {
		
		case "name" : getDriver().findElements(By.name(fieldname)).get(number).isDisplayed();
		getDriver().findElements(By.name(fieldname)).get(number).click();
		break;
		
		case "id" : getDriver().findElements(By.id(fieldname)).get(number).isDisplayed();
		getDriver().findElements(By.id(fieldname)).get(number).click();
		break;
		
		case "xpath" : getDriver().findElements(By.xpath(fieldname)).get(number).isDisplayed();
		getDriver().findElements(By.xpath(fieldname)).get(number).click();
		break;
		
		case "cssselector" : getDriver().findElements(By.cssSelector(fieldname)).get(number).isDisplayed();
		getDriver().findElements(By.cssSelector(fieldname)).get(number).click();
		break;
		
		}
	}
	
	/***********************Method to get text from a link/button**************************/
	public String text(String type, String fieldname){
		
		String gText = null;

		switch (type.toLowerCase()) {
		
		case "name" : getDriver().findElement(By.name(fieldname)).isDisplayed();
		gText = getDriver().findElement(By.name(fieldname)).getText();
		break;
		case "id" : getDriver().findElement(By.id(fieldname)).isDisplayed();
		gText = getDriver().findElement(By.id(fieldname)).getText();
		break;
		case "xpath" : getDriver().findElement(By.xpath(fieldname)).isDisplayed();
		gText = getDriver().findElement(By.xpath(fieldname)).getText();
		break;
		case "cssselector" : getDriver().findElement(By.cssSelector(fieldname)).isDisplayed();
		gText = getDriver().findElement(By.cssSelector(fieldname)).getText();
		break;
		
		}
		return gText;
	}

	/***********************Method to get text from a link/button with more than one same locator**************************/
	public String text(String type, String fieldname, int number){
		
		String mText = null;

		switch (type.toLowerCase()) {
		
		case "name" : getDriver().findElements(By.name(fieldname)).get(number).isDisplayed();
		mText = getDriver().findElements(By.name(fieldname)).get(number).getText();
		break;
		
		case "id" : getDriver().findElements(By.id(fieldname)).get(number).isDisplayed();
		mText = getDriver().findElements(By.id(fieldname)).get(number).getText();
		break;
		
		case "xpath" : getDriver().findElements(By.xpath(fieldname)).get(number).isDisplayed();
		mText = getDriver().findElements(By.xpath(fieldname)).get(number).getText();
		break;
		
		case "cssselector" : getDriver().findElements(By.cssSelector(fieldname)).get(number).isDisplayed();
		mText = getDriver().findElements(By.cssSelector(fieldname)).get(number).getText();
		break;
		
		}
		return mText;
	}
	
	/***********************Method to get Webelement from a link/button**************************/
     public WebElement element(String type, String fieldname, int number){
		
		WebElement mText = null;

		switch (type.toLowerCase()) {
		
		case "name" : getDriver().findElements(By.name(fieldname)).get(number).isDisplayed();
		mText = getDriver().findElements(By.name(fieldname)).get(number);
		break;
		
		case "id" : getDriver().findElements(By.id(fieldname)).get(number).isDisplayed();
		mText = getDriver().findElements(By.id(fieldname)).get(number);
		break;
		
		case "xpath" : getDriver().findElements(By.xpath(fieldname)).get(number).isDisplayed();
		mText = getDriver().findElements(By.xpath(fieldname)).get(number);
		break;
		
		case "cssselector" : getDriver().findElements(By.cssSelector(fieldname)).get(number).isDisplayed();
		mText = getDriver().findElements(By.cssSelector(fieldname)).get(number);
		break;
		
		}
		return mText;
     }

     /***********************Method to get Webelement from a link/button**************************/
 	public WebElement element(String type, String fieldname){
 		
 		WebElement gText= null;

 		switch (type.toLowerCase()) {
 		
 		case "name" : getDriver().findElement(By.name(fieldname)).isDisplayed();
 		gText = getDriver().findElement(By.name(fieldname));
 		break;
 		case "id" : getDriver().findElement(By.id(fieldname)).isDisplayed();
 		gText = getDriver().findElement(By.id(fieldname));
 		break;
 		case "xpath" : getDriver().findElement(By.name(fieldname)).isDisplayed();
 		gText = getDriver().findElement(By.xpath(fieldname));
 		break;
 		case "cssselector" : getDriver().findElement(By.cssSelector(fieldname)).isDisplayed();
 		gText = getDriver().findElement(By.cssSelector(fieldname));
 		break;
 		
 		}
 		return gText;
 	}
 	
 	public WebElement getfield(String a, String name) {
 		
 		String d = "//"+a+"[contains(text(),'" + name +"')]";

 		return(driver.findElement(By.xpath(d)));
 	}
}

