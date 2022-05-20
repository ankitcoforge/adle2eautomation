package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import pageObjects.impersonateMenu;
import utils.utilityClass;

public class impersonateAction extends impersonateMenu {
	
	utilityClass event = new utilityClass();
	
	public void impersonateUser(String roleid) throws InterruptedException {
		Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        event.clickfield("id", roleDropdown);
        getDriver().findElement(By.id(roleDropdown)).sendKeys(Keys.ARROW_DOWN);
        getDriver().findElement(By.id(roleDropdown)).sendKeys(Keys.ENTER);
        //event.inputfield("id", roleDropdown , Keys.ARROW_DOWN);
        //event.inputfield("id", roleDropdown , "Keys.ENTER");
        ///driver.switchTo().defaultContent();
        //driver.switchTo().frame(1);
        Thread.sleep(3000);
        event.clickfield("id", "ctl00_mainContent_TextBoxRoleIdentifier");
        System.out.println(roleid);
        event.inputfield("id", "ctl00_mainContent_TextBoxRoleIdentifier", roleid);
		event.clickfield("id", button);
		event.clickfield("id", tableFirstRow);
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		

	}

}
