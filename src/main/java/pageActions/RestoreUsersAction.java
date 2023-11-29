package pageActions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import pageObjects.RestoreUsersPo;
import utils.utilityClass;

public class RestoreUsersAction extends RestoreUsersPo{
	
	utilityClass utils = new utilityClass();
	impersonateAction impersonate= new impersonateAction();
	ManageUserPageAction manageUserPage = new ManageUserPageAction();
	ManageVSC_GAPpreferencesAction ManageVSCGAPprefrences=new ManageVSC_GAPpreferencesAction();
	
	public HashMap<Integer, HashMap<String, String>> checkGridBodyDetails() {
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", impersonate.headerLoc);
		System.out.println("allHeaderNames: " + allHeaderNames);
		HashMap<Integer, HashMap<String, String>> allTableData = new HashMap<Integer, HashMap<String, String>>();
		
		// Get total rows count
		List<WebElement> allRowsEle = utils.getElementsList("cssSelector", impersonate.rowLoc);
		System.out.println("No of rows in grid: " + allRowsEle.size());
		
		for (int i = 1; i <= allRowsEle.size(); i++) {
			if (i == 10) 	
				utils.scrollDown();

			// Getting specific row with each iteration
			String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			for (int j = 1; j < 7; j++) {
				
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
	
	public WebElement restoreIcon(int i) {
	String str="table>tbody>tr:nth-of-type("+ i +")>td:nth-of-type(7)>adl-table-cells>div>div:nth-of-type(1)>i";
	return utils.element("cssSelector",str);
	}
	
	

	public void selectDealerInmanageUserPage(String role) throws InterruptedException {
		utils.clickfield("xpath", manageUserPage.selectDealerNamearrow);
		WebElement ele = driver.findElement(By.xpath(manageUserPage.enterRole));
		ele.sendKeys(role);
		utils.element("xpath", roleIdArrow).click();
		List<WebElement> list = getDriver().findElements(By.xpath(manageUserPage.roleDropdownListForDealer));
		list.get(0).click();
		utils.waitTillElementIsVisible(impersonate.getusersButton);
		utils.clickfield("xpath", impersonate.getusersButton);
		utils.waituntillPageIsloaded();
	}
	
	public HashMap<String, WebElement> getSearchBoxes() {
		utils.scrollDown();
		HashMap<String, WebElement> map = new HashMap<String, WebElement>();
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", ManageVSCGAPprefrences.headerLoc);
		List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(ManageVSCGAPprefrences.searchBoxesBelowHeadersInGrid));
		for (int j = 0; j < 4; j++) {
			map.put(allHeaderNames.get(j), searchBoxesInGrid.get(j));
		}
		return map;
	}
	
//	public HashMap<String, WebElement> getRoleNameSearchBoxWithArrowSelection() {
//		utils.scrollDown();
//		HashMap<String, WebElement> map = new HashMap<String, WebElement>();
//		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", ManageVSCGAPprefrences.headerLoc);
//		List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(ManageVSCGAPprefrences.searchBoxArrow));
//			map.put(allHeaderNames.get(4), searchBoxesInGrid.get(0));
//		return map;
//	}
	
	public HashMap<String, WebElement> getPINSearchBox() {
		utils.scrollDown();
		HashMap<String, WebElement> map = new HashMap<String, WebElement>();
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", ManageVSCGAPprefrences.headerLoc);
		List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(ManageVSCGAPprefrences.searchBoxesBelowHeadersInGrid));
			map.put(allHeaderNames.get(5), searchBoxesInGrid.get(4));
		return map;
	}
	
	 public List<String> getRowLoc() {
		 List<String> rowLoactor = utils.getTextValuesForObject("cssSelector", impersonate.rowLoc);
         return rowLoactor;
	 }
	
	public WebElement getArrow(String Heading) {
	String txt = "//th[contains(text(),'"+Heading+"')]/p-sorticon/i";
	WebElement ele = driver.findElement(By.xpath(txt));
	return ele;
	}
	
	public void verifysorting(String header) {
		getArrow(header).click();
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String rowTxt = allTableData.get(i).get(header);
			list.add(rowTxt);
		}
		ArrayList<String> listBeforeSort = list;
		Collections.sort(list);
		Assert.assertEquals(listBeforeSort,list);
		
		utils.waitTillElementIsClickableByWebEle(getArrow(header));
		getArrow(header).click();
		HashMap<Integer, HashMap<String, String>> allTableDataOnArrowClick2 = checkGridBodyDetails();
		ArrayList<String> listOnArrowClick2 = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String rowTxt = allTableDataOnArrowClick2.get(i).get(header);
			listOnArrowClick2.add(rowTxt);
		}
		ArrayList<String> ObtainedList = listOnArrowClick2;
		Collections.sort(listOnArrowClick2);
		Collections.reverse(listOnArrowClick2);
		Assert.assertTrue(ObtainedList.equals(listOnArrowClick2));
	}
}
