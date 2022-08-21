package pageActions;

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
		event.clickfield("xpath", reports);
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
	
	
}

