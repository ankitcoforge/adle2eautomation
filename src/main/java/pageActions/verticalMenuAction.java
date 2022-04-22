package pageActions;

import org.openqa.selenium.By;

import pageObjects.verticalMenupo;
import utils.baseClass;
import utils.utilityClass;

public class verticalMenuAction extends verticalMenupo{

	utilityClass event = new utilityClass();
	
	
	
	/***************************Navigate to Contract page
	 * @throws InterruptedException *******************************/
	public void navigatetoContract() throws InterruptedException {

		Thread.sleep(4000);
		driver.switchTo().activeElement();
		event.clickfield("xpath", erate);
		event.clickfield("xpath", contract );

	}
	
	public void navigatetoLeftMenu(String heading, String subheading) throws InterruptedException {
		Thread.sleep(4000);
		driver.switchTo().activeElement();
		event.getfield("button", heading).click();
		event.getfield("a", subheading).click();

	}
	
	public String getTitle() {
		return (event.text("cssSelector", "header > div >h3"));
	}
}

