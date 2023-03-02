package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import pageObjects.PermissionsPo;
import utils.utilityClass;

public class PermissionsAction extends PermissionsPo{
	
	utilityClass event = new utilityClass();

	 public WebElement getPortalTitle() {
			 WebElement welcomeTitle=driver.findElement(By.xpath(portalTitle));	
			 return welcomeTitle;
		 }
	 
	 public void selectUser(String user) throws InterruptedException {
		 event.clickfield("xpath", roleDropdown);
		 Thread.sleep(1000);
		 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		 list.get(9).click();
		 event.clickfield("xpath", roleDropdown);
		 List<WebElement> list2 = getDriver().findElements(By.xpath(roleDropdownList));
	    for(int i=0;i<list2.size();i++) {
		String text = list2.get(i).getText();
		System.out.println("Progm list is--"+text);
		if(text.contains(user))
		{
			list2.get(i).click();
			break;
		}
	 }
	 }
	 
	 public List<WebElement> getPermissionListInPopup() {
		  List<WebElement> list = driver.findElements(By.xpath(permissionsListInPopup));	
		 return list;
	 }
	 
	 public WebElement getSelectAllCheckBoxInPopup() {
		 WebElement ele=driver.findElement(By.xpath(selectAllCheckBoxInPopup));	
		 return ele;
	 }
	 
	 public WebElement getEditPermissions() {
		 WebElement ele=driver.findElement(By.xpath(editPermissionsTxt));	
		 return ele;
	 }
	 
	 public List<WebElement> getCheckboxesPermissions() {
		 List<WebElement> list =driver.findElements(By.xpath(checkboxesPermissions));	
		 return list;
	 }
	 
//	 public List<WebElement> getCheckBoxesForPermission() {
//		  List<WebElement> list = driver.findElements(By.cssSelector(permissionsCheckBox));	
//		 return list;
//	 }
}
