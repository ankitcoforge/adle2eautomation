package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pageObjects.verticalMenupo;
import utils.baseClass;
import utils.utilityClass;

public class verticalMenuAction extends verticalMenupo{

	utilityClass event = new utilityClass();
	
	
	
	/***************************Navigate to Contract page
	 * @throws InterruptedException *******************************/
	public void navigatetoContract() throws InterruptedException {

		Thread.sleep(5000);
		driver.switchTo().activeElement();
		event.clickfield("xpath", erate);
		event.clickfield("xpath", contract);

	}
	
	/***************************Navigate to Contract page
	 * @throws InterruptedException *******************************/
	public void navigatetoimpersonate() throws InterruptedException {

		Thread.sleep(4000);
		driver.switchTo().activeElement();
		event.clickfield("xpath", accountManagement);
		event.clickfield("xpath", impersonate);

	}
	
	
	public void navigatetoLeftMenu(String heading, String subheading) throws InterruptedException {
		Thread.sleep(6000);
		driver.switchTo().activeElement();
		event.getfield("button", heading).click();
		event.getfield("a", subheading).click();

	}
	
	public void navigatetoLeftMenu(String subheading) throws InterruptedException {
		Thread.sleep(6000);
		driver.switchTo().activeElement();
		event.getfield("a", subheading).click();

	}

	public void navigatetoLeftMainMenu(String heading) throws InterruptedException {
		Thread.sleep(6000);
		driver.switchTo().activeElement();
		event.getfield("button", heading).click();
	}
	
	public String getTitle() {
		return (event.text("cssSelector", "header > div >h3"));
	}
	
	public void navigateToMileageAndAgeException() throws InterruptedException {
		Thread.sleep(4000);
		driver.switchTo().activeElement();
		event.clickfield("xpath", accountManagement);
		event.clickfield("xpath", milaegeAndAgeExceptions);
	}
	
//	public void navigatetoimpersonateFromRightTop() throws InterruptedException {
//		event.clickfield("xpath", arrowbtnAtRightTop);
//		Thread.sleep(2000);
//		driver.switchTo().activeElement();
//		System.out.println("list is"+getArrowOptionsList().get(1).getText());
//		
//		Thread.sleep(4000);
//		//event.clickfield("xpath", impersonateAtRightTop);
//	}
//	
//	 public List<WebElement> getArrowOptionsList() {
//		  List<WebElement> list = driver.findElements(By.xpath(arrowOptionsList));	
//		 return list; 
//	 }
	
}

