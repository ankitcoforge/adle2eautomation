package utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
		
		case "cssselector" : getDriver().findElement(By.cssSelector(fieldname)).isDisplayed();
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

     /***********************Method to get Webelement from a link/button
     * @throws InterruptedException **************************/
 	public WebElement element(String type, String fieldname) throws InterruptedException{
 		
 		WebElement gText= null;

 		switch (type.toLowerCase()) {
 		
 		case "name" : getDriver().findElement(By.name(fieldname)).isDisplayed();
 		gText = getDriver().findElement(By.name(fieldname));
 		break;
 		case "id" : getDriver().findElement(By.id(fieldname)).isDisplayed();
 		gText = getDriver().findElement(By.id(fieldname));
 		break;
 		case "xpath" : getDriver().findElement(By.xpath(fieldname)).isDisplayed();
 		gText = getDriver().findElement(By.xpath(fieldname));
 		break;
 		case "cssselector" : getDriver().findElement(By.cssSelector(fieldname)).isDisplayed();
 		gText = getDriver().findElement(By.cssSelector(fieldname));
 		break;
 		}
 		wait(2000);
 		return gText;
 	}
 	
 	public WebElement getfield(String a, String name) {
 		
 		String d = "//"+a+"[contains(text(),'" + name +"')]";

 		return(driver.findElement(By.xpath(d)));
 	}
 	
public List<WebElement> getfields(String a, String name) {
 		
 		String d = "//"+a+"[contains(text(),'" + name +"')]";

 		return(driver.findElements(By.xpath(d)));
 	}
 	
 	public String toastMessage() {
 		
 		return(driver.findElement(By.cssSelector("div[role='alertdialog']")).getText());
 	}
 	
 	 /***********************Method to get all the objects related to same locator**************************/
 		public List<WebElement> getElementsList(String type, String fieldname){
 				
 			List<WebElement> listWebElement= null;

 			switch (type.toLowerCase()) {
 			
 			case "name" : 
 			listWebElement = getDriver().findElements(By.name(fieldname));
 			break;
 			case "id" : 
 			listWebElement = getDriver().findElements(By.id(fieldname));
 			break;
 			case "xpath" : 
 			listWebElement = getDriver().findElements(By.xpath(fieldname));
 			break;
 			case "cssselector" : 
 			listWebElement = getDriver().findElements(By.cssSelector(fieldname));
 			break;
 			case "tagname" : 
 			listWebElement = getDriver().findElements(By.tagName(fieldname));
 			break;
 			
 			}
 			
 			return listWebElement;
 		}
 			
 		/***********************Method to get text for all the objects related to same locator**************************/
 		public List<String> getTextValuesForObject(String type, String fieldname) {
 			List<WebElement> allEle = getElementsList(type, fieldname);
 			List<String> allNames = new ArrayList<String>();
 			for (WebElement header : allEle) {
 				String headerName = header.getText();
 				allNames.add(headerName);
 			}
 			return allNames;
 		}
 			
 		/***********************Method to scroll up the web page**************************/
 		public void scrollUp() {
 			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_UP);
 			
 		}
 		
 		/***********************Method to scroll down the web page
 		 * @throws InterruptedException **************************/
 		public void scrollDown() throws InterruptedException {
 			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
 			Thread.sleep(1000);
 		}
 		
 		public void scrollDownUsingJSE() {
 		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 2500)");
 		}
 		
 		public void scrollLittleDownUsingJSE() throws InterruptedException {
 	 		JavascriptExecutor js=(JavascriptExecutor)driver;
 			js.executeScript("window.scrollTo(0, 100)");
 			wait(500);
 	 		}
 		
 		public void scrollUpUsingJSE() {
 	 		JavascriptExecutor js=(JavascriptExecutor)driver;
 			js.executeScript("window.scrollTo(0, -2500)");
 	 		}
 		
 		public void scrollLittleUpUsingJSE() {
 	 		JavascriptExecutor js=(JavascriptExecutor)driver;
 			js.executeScript("window.scrollTo(0, -300)");
 	 		}
 		
 		public void clickUsingJSE(String ele) {
 			JavascriptExecutor jse = (JavascriptExecutor) driver;
 			jse.executeScript("arguments[0].click()", driver.findElement(By.xpath(ele)));
 	 		}
 		
 		public void scrollDownUsingJSE(int value) throws InterruptedException {
 	 		JavascriptExecutor js=(JavascriptExecutor)driver;
 			js.executeScript("window.scrollTo(0, "+value+")");
 			Thread.sleep(500);
 	 		}
 		
 		 public WebElement getTitle(String heading) {
 			 WebElement welcomeTitle=getfield("h3", heading);
 			 return welcomeTitle;
 		 }
 		 
 		public void waitTillElementIsVisible(String ele) {
 			WebDriverWait wait = new WebDriverWait(driver,60);
 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele)));
 		}
 		
 		public void waitUntilElementisInVisible(WebElement ele) {
 			WebDriverWait wait = new WebDriverWait(driver,5);
 			wait.until(ExpectedConditions.invisibilityOf(ele));
 		}
 		
 		public void waitTillElementIsVisibleCss(String ele) {
 			WebDriverWait wait = new WebDriverWait(driver,60);
 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ele)));
 		}
 		
 		public void waitTillElementIsClickable(String ele) {
 			WebDriverWait wait = new WebDriverWait(driver,60);
 			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ele)));
 		}
 		
 		public void waitTillElementIsClickableByWebEle(WebElement ele) {
 			WebDriverWait wait = new WebDriverWait(driver,60);
 			wait.until(ExpectedConditions.elementToBeClickable(ele));
 		}
 		
 		
 		
 		public void waituntillPageIsloaded() {
 			WebDriverWait wait = new WebDriverWait(driver,5);
 			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner/div")));
 		}

 		public void waituntillPageIsloaded(int time) {
 			WebDriverWait wait = new WebDriverWait(driver,time);
 			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner/div")));
 		}
 		
 		public void wait(int time) throws InterruptedException {
 			Thread.sleep(time);
 		}
 		
 		public void validateColor(WebElement ele,String color,String ExpectedColorInHexaForm ) {
 			String expectedColor = prop.getProperty(ExpectedColorInHexaForm);
 			String colorOfElement =ele.getCssValue(color);
 			String ActualcolorInHexaformat = Color.fromString(colorOfElement).asHex();
 			Assert.assertEquals(ActualcolorInHexaformat, expectedColor);
 		}
 		
}

