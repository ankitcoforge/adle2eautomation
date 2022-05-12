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
	
	public void impersonateUser() throws InterruptedException {
		driver.switchTo().activeElement();
		event.clickfield("xpath", "//button[contains(text(),'Reports')]");
		event.clickfield("xpath", "//a[contains(text(),'Impersonate')]");
		Thread.sleep(4000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.findElement(By.id("ctl00_mainContent_DropDownListRoleType")).click();
        driver.findElement(By.id("ctl00_mainContent_DropDownListRoleType")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.id("ctl00_mainContent_DropDownListRoleType")).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        Thread.sleep(4000);
		driver.findElement(By.cssSelector("#cnt table #container table tbody tr input")).click();
		event.inputfield("cssselector","#cnt table #container table tbody tr input","70340");
		event.clickfield("id", "ctl00_mainContent_ButtonGetUsers");
		event.clickfield("id", "ctl00_mainContent_ASPxGridViewUsers_cell0_11_ASPxButtonImpersonate");
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		//String header1 = event.text("xpath", header, 0);
		

	}
}

