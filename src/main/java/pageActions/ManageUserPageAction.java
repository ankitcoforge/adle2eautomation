package pageActions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import pageObjects.ManageUserPo;
import pageObjects.NewUserRegistrationPo;
import pageObjects.impersonatepo;
import utils.XmlDataReader;
import utils.baseClass;
import utils.utilityClass;

public class ManageUserPageAction extends ManageUserPo{
	
	utilityClass utils = new utilityClass();
//	impersonatepo impersonate = new impersonatepo();
	XmlDataReader UtilsDataReader = new XmlDataReader("UtilsData");
	impersonateAction impersonate = new impersonateAction();
//	NewUserRegistration_Action NewUserRegistrationPage= new NewUserRegistration_Action();
	
	public List<WebElement> getRows() {
		List<WebElement> allRowsEle = utils.getElementsList("cssSelector", impersonate.rowLoc);
		return allRowsEle;
	}
	
	public HashMap<Integer, HashMap<String, String>> manageUsersPageGrid() throws InterruptedException {
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", impersonate.headerLoc);
		System.out.println("allHeaderNames: " + allHeaderNames);
		HashMap<Integer, HashMap<String, String>> allTableData = new HashMap<Integer, HashMap<String, String>>();
		
		// Get total rows count
		List<WebElement> allRowsEle = utils.getElementsList("cssSelector", impersonate.rowLoc);
		System.out.println("No of rows in grid: " + allRowsEle.size());
		
		for (int i = 1; i <= allRowsEle.size(); i++) {
//			if (i == 10) 	
//				utils.scrollDown();

			// Getting specific row with each iteration
			String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			for (int j = 1; j < 8; j++) {
				
				String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>span:nth-of-type(2)";
			
				String cellValue = "";
					cellValue = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc).getText();

				eachRowData.put(allHeaderNames.get(j-1), cellValue);
			}
			allTableData.put(i, eachRowData);
		}
		System.out.println("Complete Grid data: " + allTableData);
		utils.scrollUp();
		Thread.sleep(3000);
		return allTableData;
		}
	
	public HashMap<Integer, HashMap<String, String>> issueNewUserRegistrationPageGrid() {
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", impersonate.headerLoc);
		System.out.println("allHeaderNames: " + allHeaderNames);
		HashMap<Integer, HashMap<String, String>> allTableData = new HashMap<Integer, HashMap<String, String>>();
		
		// Get total rows count
		List<WebElement> allRowsEle = utils.getElementsList("cssSelector", impersonate.rowLoc);
		System.out.println("No of rows in grid: " + allRowsEle.size());
		
		for (int i = 1; i <= allRowsEle.size(); i++) {
			String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			for (int j = 1; j < 4; j++) {
				
				String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>span:nth-of-type(2)";
			
				String cellValue = "";
					cellValue = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc).getText();

				eachRowData.put(allHeaderNames.get(j-1), cellValue);
			}
			allTableData.put(i, eachRowData);
		}
		System.out.println("Complete Grid data: " + allTableData);
		utils.scrollUp();	
		return allTableData;
		}

	public WebElement getEditPermissionsLinkInNewUserRegistrationPage(int i) {
		String str="table>tbody>tr:nth-of-type("+i+")>td:nth-of-type(5)>adl-table-cells>div";
		WebElement EditBtn = utils.element("cssSelector", str);
		return EditBtn;
	}
	
	public void selectDealerInmanageUserPage(String role) throws InterruptedException {
		utils.clickfield("xpath", selectDealerNamearrow);
		WebElement ele = driver.findElement(By.xpath(enterRole));
		ele.sendKeys(role);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownListForDealer));
		list.get(0).click();
		utils.waitTillElementIsVisible(impersonate.getusersButton);
		utils.clickfield("xpath", impersonate.getusersButton);
//		utils.waituntillPageIsloaded();
		Thread.sleep(10000);
	}
	
	 public void selectStatusAsCompleted() throws InterruptedException {
		 utils.element("xpath", registrationStatusArrow).click();
		 utils.element("xpath", completedCheckbox).click();
		 utils.element("xpath", registrationStatusArrow).click();
		 Thread.sleep(2000);
		 utils.waitTillElementIsVisible(impersonate.tableFirstRow);
	 }

	 
	 public ArrayList<String> getHeaderList() {
			List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", impersonate.headerLoc);
			ArrayList<String> headersList = new ArrayList<String>();
			for (int i = 0; i < allHeaderNames.size(); i++) {
				headersList.add(allHeaderNames.get(i));
			}
			return headersList;
		}
	 
	 public void selectDealerInmanageUserPageWithOutgetUsers(String role) throws InterruptedException {
			utils.clickfield("xpath", selectDealerNamearrow);
			WebElement ele = driver.findElement(By.xpath(enterRole));
			ele.sendKeys(role);
			List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownListForDealer));
			list.get(0).click();
		}
	 
	 public void selectRoleTypeInGenericImpersonatePopup(String role) throws InterruptedException {
		 utils.waitTillElementIsClickableByWebEle( utils.element("xpath", impersonate.roleDropdownArrowInPopup));
			 utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
			 Thread.sleep(2000);
			 List<WebElement> list = getDriver().findElements(By.xpath(impersonate.roleDropdownList));
			 for(int i=0;i<list.size();i++) {
				String text = list.get(i).getText();
				if(text.equals(role))
				{
					list.get(i).click();
					break;
				}
			 }
		}
	 public List<WebElement> getDropDownlistForRoleType() throws InterruptedException {
		 List<WebElement> list = getDriver().findElements(By.xpath(impersonate.roleDropdownList));
		 return list;
	 }
	 

public void verifyAllTheHeaders() {
	Assert.assertTrue(getHeaderList().contains("First Name"));
	Assert.assertTrue(getHeaderList().contains("Last Name"));
	Assert.assertTrue(getHeaderList().contains("Username"));
	Assert.assertTrue(getHeaderList().contains("Email"));
	Assert.assertTrue(getHeaderList().contains("Role Type"));
	Assert.assertTrue(getHeaderList().contains("PIN"));
	Assert.assertTrue(getHeaderList().contains("Registration Status"));
	Assert.assertTrue(getHeaderList().contains("Locked Out"));
	Assert.assertTrue(getHeaderList().contains("Edit"));
	Assert.assertTrue(getHeaderList().contains("Delete"));
	Assert.assertTrue(getHeaderList().contains("Resend Invitation"));
	Assert.assertTrue(getHeaderList().contains("Impersonate"));
}

public void selectRoleTypeInGrid(String roleType) throws InterruptedException {
	Thread.sleep(2000);
	 utils.element("xpath", roleTypeStatusArrow).click();
	 String ele= "//li[@aria-label='"+roleType +"']/div/div";
	 utils.element("xpath", ele).click();
	 utils.element("xpath", roleTypeStatusArrow).click();
	 Thread.sleep(2000);
//	 utils.waitTillElementIsVisible(io.tableFirstRow);
}

public HashMap<Integer, HashMap<String, WebElement>> checkGridForLockImpersonateResendInvitationManageuser() {
	List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", impersonate.headerLoc);
	System.out.println("allHeaderNames: " + allHeaderNames);
	HashMap<Integer, HashMap<String, WebElement>> allTableData = new HashMap<Integer, HashMap<String, WebElement>>();
	// Get total rows count
	List<WebElement> allRows = utils.getElementsList("cssSelector", impersonate.rowLoc);
	System.out.println("No of rows in grid: " + allRows.size());
	utils.scrollDown();
		// Getting specific row with each iteration
		String specificRowLoc = "table>tbody>tr:nth-of-type(1)";
		LinkedHashMap<String, WebElement> eachRowData = new LinkedHashMap<>();
		for (int j = 8; j <= 12; j++) {
			String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>div:nth-of-type(1)>i:nth-of-type(1)";
			WebElement cellValue = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
			eachRowData.put(allHeaderNames.get(j-1), cellValue);
		}
		allTableData.put(1, eachRowData);
//	}
	System.out.println("Complete Grid data: " + allTableData);
	utils.scrollUp();
	return allTableData;
}

public WebElement editLinkInGrid(int row) {
	String del = "tr:nth-of-type("+row+")>td:nth-of-type(9)>adl-table-cells>div>div:nth-of-type(1)>i:nth-of-type(1)";
	 return utils.element("cssselector", del);
	 }

public WebElement deleteLinkInGrid(int row) {
	String del = "table>tbody>tr:nth-of-type("+row+")>td:nth-of-type(10)>adl-table-cells>div>div:nth-of-type(1)>i:nth-of-type(2)";
	 return utils.element("cssselector", del);
	 }

public List<WebElement> getUsersAndImpersonateAsGenericBtnsList() {
	List<WebElement> ele = utils.getElementsList("cssselector", impersonate.getUsersAndImpersonateAsGenericBtnsList);
return ele;	
}
	

public HashMap<Integer, HashMap<String, WebElement>> checkGridForEditDelLock() {
	List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", impersonate.headerLoc);
	System.out.println("allHeaderNames: " + allHeaderNames);
	HashMap<Integer, HashMap<String, WebElement>> allTableData = new HashMap<Integer, HashMap<String, WebElement>>();
	// Get total rows count
	List<WebElement> allRows = utils.getElementsList("cssSelector", impersonate.rowLoc);
	System.out.println("No of rows in grid: " + allRows.size());
	for (int i = 1; i <= allRows.size(); i++) {
		if (i == 10)
			utils.scrollDown();
		// Getting specific row with each iteration
		String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
		LinkedHashMap<String, WebElement> eachRowData = new LinkedHashMap<>();
		for (int j = 3; j < allHeaderNames.size(); j++) {
			String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div";
			WebElement cellValue = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
			eachRowData.put(allHeaderNames.get(j - 1), cellValue);
		}
		allTableData.put(i, eachRowData);
	}
	System.out.println("Complete Grid data: " + allTableData);
	utils.scrollUp();
	return allTableData;
}

public void getEditPermissionsInManageUsersPage(String roleType,String status) throws InterruptedException {
	 HashMap<Integer, HashMap<String, String>> allTableData = manageUsersPageGrid();
	 HashMap<Integer, HashMap<String, WebElement>> tableDataForEditDelLock = checkGridForEditDelLock();
//		for(int i=1;i<=io.getRows().size();i++){
		if(allTableData.get(1).get("Role Type").equals(roleType) && allTableData.get(1).get("Registration Status").equals(status) )
		{
			tableDataForEditDelLock.get(1).get("Edit").click();
	
	 WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfAllElements(utils.getElementsList("xpath", permissionsArrow)));
		utils.element("xpath", permissionsArrow).click();
		utils.waituntillPageIsloaded();
		if(utils.element("xpath", selectAllLink).getAttribute("aria-checked").equals("false")) {
		utils.element("xpath", selectAllLink).click();
		}
		utils.element("xpath", closeInPermPopup).click();
		utils.waitTillElementIsVisible(saveBtn);
		utils.element("xpath", saveBtn).click();
		utils.waituntillPageIsloaded();
//		}
		}
}

public void getNewUserPageWithAccountNameSelection(String roleType,String newemail) throws InterruptedException {
	utils.getfield("span", "+ New user").isEnabled();
	utils.getfield("span", "+ New user").click();
	utils.waitTillElementIsVisible(impersonate.roleDropdown);
	utils.clickfield("xpath", impersonate.roleDropdown);
	List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
	for (int i = 0; i < list.size(); i++) {
		String text = list.get(i).getText();

		if (text.equals(roleType)) {
			list.get(i).click();
			break;
		}
	}
	utils.waitTillElementIsClickable(roleDropdownForAccountName);
	utils.clickfield("xpath", roleDropdownForAccountName);
	List<WebElement> list2 = getDriver().findElements(By.xpath(roleDropdownListForAccountName));
	list2.get(0).click();
	utils.waitTillElementIsVisible(email);
	utils.element("xpath", email).sendKeys(newemail);
	utils.waitTillElementIsVisible(submit);
	utils.element("xpath", submit).click();
	utils.waituntillPageIsloaded();
}

public void getNewUserPageWithoutAccountNameSelection(String roleType,String newemail) throws InterruptedException {
	utils.getfield("span", "+ New user").isEnabled();
	utils.getfield("span", "+ New user").click();
	utils.wait(1000);
//	utils.waitTillElementIsVisible(impersonate.roleDropdown);
	utils.clickfield("xpath", impersonate.roleDropdown);
	List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
	for (int i = 0; i < list.size(); i++) {
		String text = list.get(i).getText();

		if (text.equals(roleType)) {
			list.get(i).click();
			break;
		}
	}
	utils.waitTillElementIsVisible(email);
	utils.element("xpath", email).sendKeys(newemail);
	utils.wait(1000);
//	utils.waitTillElementIsVisible(submit);
	utils.element("xpath", submit).click();
	utils.wait(2000);
//	utils.waituntillPageIsloaded();
}

}
