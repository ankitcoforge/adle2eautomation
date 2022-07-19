package pageActions;


import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pageObjects.impersonatepo;
import utils.utilityClass;

public class impersonateAction extends impersonatepo {

	utilityClass event = new utilityClass();
	verticalMenuAction va = new verticalMenuAction();

	public void impersonateUser(String role, String roleid) throws InterruptedException {
		Thread.sleep(3000);
		if (role == "Dealer") {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(1);
			event.clickfield("id", roleDropdown);
			getDriver().findElement(By.id(roleDropdown)).sendKeys(Keys.ARROW_DOWN);
			getDriver().findElement(By.id(roleDropdown)).sendKeys(Keys.ENTER);
		}
		
		if(role =="Lender") {
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame(1);
			event.clickfield("id", roleDropdown);
			getDriver().findElement(By.id(roleDropdown)).sendKeys(Keys.ARROW_DOWN);
			getDriver().findElement(By.id(roleDropdown)).sendKeys(Keys.ARROW_DOWN);
			getDriver().findElement(By.id(roleDropdown)).sendKeys(Keys.ENTER);
		}
		Thread.sleep(3000);
		event.clickfield("id", role1);
		event.inputfield("id", role1, roleid);
		event.clickfield("id", button);
		event.clickfield("id", tableFirstRow);
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();

	}
	
	public List <String> loginImpersonate() {
		
		List<String> a = new ArrayList();
		for(int i =0; i < driver.findElements(By.cssSelector(".mat-menu-trigger >span")).size(); i++)
		a.add(event.text("cssSelector", ".mat-menu-trigger >span",i));
		return a;
		
	}
	
	public String endImpersonate(String role, String roleId) throws InterruptedException {
		
		driver.get("https://qa.adl.aulcorp.com/portal");
		va.navigatetoLeftMenu("Reports", "Impersonate");
		impersonateUser(role,roleId);
		Thread.sleep(3000);
		return impersonateOptions();
	}
	
	public String navigateImpersonate() throws InterruptedException {
		
		va.navigatetoLeftMenu("Reports", "Impersonate");
		return (driver.getCurrentUrl());
		
	}
	
     public String impersonateOptions() throws InterruptedException {
    	 
    	driver.findElement(By.cssSelector(logoutArrow)).isDisplayed();
 		driver.findElement(By.cssSelector(logoutArrow)).click();

		return (event.text("cssSelector", impersonate));
		
	}

}
