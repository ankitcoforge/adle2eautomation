package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.PermissionsPo;
import utils.utilityClass;

public class PermissionsAction extends PermissionsPo{
	
	utilityClass event = new utilityClass();
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();

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
	 
	 public List<WebElement> getSelectCheckBoxInPopup() {
		  List<WebElement> ele = driver.findElements(By.cssSelector(selectCheckBoxInPopup));	
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
	 
	 public WebElement getSaveBtn() {
		 WebElement ele=driver.findElement(By.xpath(saveBtn));	
		 return ele;
	 }

	 
	 public WebElement getCancelBtn() {
		 WebElement ele=driver.findElement(By.xpath(cancelBtn));	
		 return ele;
	 }
	 
	 public WebElement getCloseBtn() {
		 WebElement ele=driver.findElement(By.xpath(closeBtn));	
		 return ele;
	 }
	 
//	 public List<WebElement> getCheckBoxesForPermission() {
//		  List<WebElement> list = driver.findElements(By.cssSelector(permissionsCheckBox));	
//		 return list;
//	 }
	 
		public void getDefaultpermissionForDealerEmp() throws InterruptedException {
			login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
			Thread.sleep(3000);
			verticalMenu.navigatetoLeftMenu("My Settings", "Issue New User Registration");
			Thread.sleep(2000);
			Assert.assertTrue(event.getTitle("Issue New User Registration").isDisplayed());
			String dealerEmp = prop.getProperty("dealerempAutomation");
			event.inputfield("cssselector", txtFieldNewUserRegistration, dealerEmp);
			Thread.sleep(2000);
			event.clickfield("xpath", editBtn);
			Thread.sleep(1000);
			event.clickfield("xpath", permissionsDropdownInPopup);
			//getPermissionListInPopup().get(12).click();
			if (getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("false")) {
				getSelectAllCheckBoxInPopup().click();
			}
			event.clickfield("xpath", saveBtn);
			Thread.sleep(5000);
			login.logout();
			Thread.sleep(10000);
		}
public void getDefaultpermissionForsubAgent() throws InterruptedException {
	login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
	Thread.sleep(3000);
	verticalMenu.navigatetoLeftMenu("Agency Settings", "Manage Users");
	Thread.sleep(2000);
	String subAgent = prop.getProperty("subagentAutomation");
	event.inputfield("cssselector", txtFieldNewUserRegistration, subAgent);
	Thread.sleep(2000);
	event.clickfield("xpath", editBtn);
	Thread.sleep(1000);
	event.clickfield("xpath", permissionsDropdownInAgentPopup);
	if (getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("false")) {
		getSelectAllCheckBoxInPopup().click();
	}
	Assert.assertTrue((getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("true")));
	event.clickfield("xpath", saveBtn);
	Thread.sleep(5000);
	login.logout();
	Thread.sleep(10000);
	
			
		}
public void getDefaultpermissionForLenderEmp() throws InterruptedException {
	login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
	Thread.sleep(3000);
	verticalMenu.navigatetoLeftMenu("Lender Settings", "Manage Users");
	Thread.sleep(2000);
	String lenderEmp = prop.getProperty("lenderempAutomation");
	event.inputfield("cssselector", txtFieldNewUserRegistration, lenderEmp);
	Thread.sleep(5000);
	event.clickfield("xpath", editBtn);
	Thread.sleep(2000);
	event.clickfield("xpath", permissionsDropdownInAgentPopup);
	getPermissionListInPopup().get(12).click();
	if (getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("false")) {
		getSelectAllCheckBoxInPopup().click();
	}
	Thread.sleep(2000);
	event.clickfield("xpath", updateBtn);
	event.clickfield("xpath", yesBtn);
	Thread.sleep(5000);
	login.logout();
	Thread.sleep(5000);
}
public void getDefaultpermissionForDealerGrpEmp() throws InterruptedException {
	login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
	Thread.sleep(3000);
	verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
	Thread.sleep(2000);
	event.getfield("h5", "Issue New User Registration").click();
	Thread.sleep(2000);
	String dealergrpempAutomation = prop.getProperty("dealergrpempAutomation");
	event.inputfield("cssselector", txtFieldNewUserRegistration, dealergrpempAutomation);
	Thread.sleep(2000);
	event.clickfield("xpath", editBtn);
	Thread.sleep(2000);
	event.clickfield("xpath", permissionsDropdownInAgentPopup);
	getPermissionListInPopup().get(12).click();
	if (getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("false")) {
		getSelectAllCheckBoxInPopup().click();
	}
	event.clickfield("xpath", saveBtn);
	Thread.sleep(5000);
	login.logout();
	Thread.sleep(5000);
}
	
}

