package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.PricingPreferencesPO;
import utils.utilityClass;

public class PricingPreerencesAction extends PricingPreferencesPO{
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();
	singleContractAction contract =new singleContractAction();
	
	 public WebElement getPortalTitle() {
		 WebElement welcomeTitle=driver.findElement(By.xpath(portalTitle));	
		 return welcomeTitle;
	 }
	 
	 public List<String> getAllHeaderNames() {
		 List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
         return allHeaderNames;
	 }
	 
	 public List<WebElement> getDropDwnList() throws InterruptedException {
			 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
			 for(int i=1;i<list.size();i++) {
					String text = list.get(i).getText();
					System.out.println("Progms list is--"+text);
			 }
			 return list;
		}
	 
	 public List<WebElement> getRadioBtns() {
		 List<WebElement> radioBtns = getDriver().findElements(By.xpath(markupRadioBtn));
         return radioBtns;
	 }
	 
	 
	 public WebElement getMarkupAmountDollarSign() {
		 WebElement amountSign=driver.findElement(By.xpath(markupAmountDollarSign));	
		 return amountSign;
	 }
	 
	 public WebElement getMarkupAmountPercentSign() {
		 WebElement amountSign=driver.findElement(By.xpath(markupAmountPercentSign));	
		 return amountSign;
	 }
	 
	 public List<WebElement> getMarkupTxts() {
		 List<WebElement> amountSign=driver.findElements(By.xpath(markupTxts));	
		 return amountSign;
	 }
	 
	 public List<WebElement> getBtnPercnt() {
		 List<WebElement> amountSign=driver.findElements(By.cssSelector(btnPercnt));	
		 return amountSign;
	 }
	 

}
