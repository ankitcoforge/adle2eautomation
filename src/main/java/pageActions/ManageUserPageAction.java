package pageActions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.ManageUserPo;
import utils.XmlDataReader;
import utils.baseClass;
import utils.utilityClass;

public class ManageUserPageAction extends ManageUserPo{
	
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction();
	XmlDataReader UtilsDataReader = new XmlDataReader("UtilsData");
	impersonateAction io = new impersonateAction();
	
	public HashMap<Integer, HashMap<String, String>> manageUsersPageGrid() {
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
		utils.waituntillPageIsloaded();
	}
	
	 public void selectStatusAsCompleted() throws InterruptedException {
		 utils.element("xpath", registrationStatusArrow).click();
		 utils.element("xpath", completedCheckbox).click();
		 utils.element("xpath", registrationStatusArrow).click();
		 Thread.sleep(2000);
		 utils.waitTillElementIsVisible(io.tableFirstRow);
	 }

}
