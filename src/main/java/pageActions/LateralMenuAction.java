package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.LateralMenupo;

public class LateralMenuAction extends LateralMenupo{
	
	 public WebElement getTitle() {
		 WebElement webContractTitle=driver.findElement(By.xpath(title));	
		 return webContractTitle;
	 }
	 
	 public WebElement getLateralMenu() {
		 WebElement latMenu=driver.findElement(By.cssSelector(lateralMenu));	
		 return latMenu;
	 }
	 public List<WebElement> getLateralMenuItems1 () {
		  List<WebElement> menuItems = driver.findElements(By.cssSelector(lateralMenuItems1));	
		 return menuItems;
	 }
	 
	 public List<WebElement> getLateralMenuItems2 () {
		  List<WebElement> menuItems = driver.findElements(By.cssSelector(lateralMenuItems2));	
		 return menuItems;
	 }
	 
	 public List<WebElement> getLaterMenuSubItems () {
		  List<WebElement> subItems = driver.findElements(By.cssSelector(laterMenuSubItems));	
		 return subItems;
	 }
	 
	 public List<WebElement> getThirdSubMenuItems () {
		  List<WebElement> superSubItems = driver.findElements(By.cssSelector(thirdSubMenuItems));	
		 return superSubItems;
	 }
	 
		public WebElement getRateContractTitle() {
			 WebElement rateContract=driver.findElement(By.xpath(rateContractTitle));	
			 return rateContract;
		 }
		
		public WebElement getQuoteHistoryTitle() {
			 WebElement quoteHistory=driver.findElement(By.xpath(quoteHistoryTitle));	
			 return quoteHistory;
		 }
		
		public WebElement getCancellationQuoteTitle() {
			 WebElement quote=driver.findElement(By.xpath(cancellationQuoteTitle));	
			 return quote;
		 }
		
		public WebElement getCancellationHistoryTitle() {
			 WebElement history=driver.findElement(By.xpath(cancellationHistoryTitle));	
			 return history;
		 }
		
		public WebElement getMenu(String a, String name) {
	 		
	 		String d = "//"+a+"[contains(text(),'" + name +"')]";

	 		return(driver.findElement(By.xpath(d)));
	 	}
		
		public WebElement getAULlogo() {
			 WebElement logo=driver.findElement(By.xpath(aulLogo));	
			 return logo;
		 }
}