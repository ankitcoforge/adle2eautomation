package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pageObjects.impersonateMenu;
import utils.utilityClass;

public class impersonateAction extends impersonateMenu {

	utilityClass event = new utilityClass();

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
		event.clickfield("id", "ctl00_mainContent_TextBoxRoleIdentifier");
		event.inputfield("id", "ctl00_mainContent_TextBoxRoleIdentifier", roleid);
		event.clickfield("id", button);
		event.clickfield("id", tableFirstRow);
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();

	}

}
