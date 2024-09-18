package pageActions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import pageObjects.RestoreUsersPo;
import utils.Database_Connectivity;
import utils.utilityClass;

public class RestoreUsersAction extends RestoreUsersPo{
	
	utilityClass utils = new utilityClass();
	impersonateAction impersonate= new impersonateAction();
	ManageUserPageAction manageUserPage = new ManageUserPageAction();
	ManageVSC_GAPpreferencesAction ManageVSCGAPprefrences=new ManageVSC_GAPpreferencesAction();
	Database_Connectivity dc = new Database_Connectivity();
	
	public HashMap<Integer, HashMap<String, String>> checkGridBodyDetails() throws InterruptedException {
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
	
	public WebElement restoreIcon(int i) throws InterruptedException {
	String str="table>tbody>tr:nth-of-type("+ i +")>td:nth-of-type(7)>adl-table-cells>div>div:nth-of-type(1)>i";
	return utils.element("cssSelector",str);
	}
	
	public ArrayList<String> getHeaderList() {
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", impersonate.headerLoc);
		ArrayList<String> headersList = new ArrayList<String>();
		for (int i = 0; i < allHeaderNames.size(); i++) {
			headersList.add(allHeaderNames.get(i));
		}
		return headersList;
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
		Thread.sleep(5000);
//		utils.waitUntilElementisInVisible(getMakeSearchToDisplayRecords());
	}
	
	public HashMap<String, WebElement> getSearchBoxes() throws InterruptedException {
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
	
	public HashMap<String, WebElement> getPINSearchBox() throws InterruptedException {
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
	
		public WebElement getMakeSearchToDisplayRecords() {
			WebElement ele = utils.getfield("td", "Please make a search to display records");
			return ele;
			}
	 
	public WebElement getArrow(String Heading) {
	String txt = "//span[contains(text(),'"+Heading+"')]/../p-sorticon/i";
	WebElement ele = driver.findElement(By.xpath(txt));
	return ele;
	}
	
	public WebElement getUserAccountHasBeenDeletedSuccessfully() {
	WebElement ele = utils.getfield("div", "The user account has been deleted successfully");
	return ele;
	}
	
	public void selectDealerWithOutWaitTime(String role) throws InterruptedException {
		utils.clickfield("xpath", manageUserPage.selectDealerNamearrow);
		WebElement ele = driver.findElement(By.xpath(manageUserPage.enterRole));
		ele.sendKeys(role);
		utils.element("xpath", roleIdArrow).click();
		List<WebElement> list = getDriver().findElements(By.xpath(manageUserPage.roleDropdownListForDealer));
		list.get(0).click();
		utils.waitTillElementIsVisible(impersonate.getusersButton);
		utils.clickfield("xpath", impersonate.getusersButton);
	}
	
	public void verifysorting(String header) throws InterruptedException {
		getArrow(header).click();
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String rowTxt = allTableData.get(i).get(header);
			list.add(rowTxt);
		}
		ArrayList<String> listBeforeSort = list;
		System.out.println("before sort-"+listBeforeSort);
		Collections.sort(list);
		System.out.println("after sort-"+list);
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
		System.out.println("After 2nd click-");
		System.out.println("before sort-"+ObtainedList);
		Collections.sort(listOnArrowClick2);
		Collections.reverse(listOnArrowClick2);
		System.out.println("after sort-"+listOnArrowClick2);
		Assert.assertTrue(ObtainedList.equals(listOnArrowClick2));
	}
	
	public HashMap<Integer, HashMap<String, String>> getDeletedUsersDateFromDB() throws Exception {
		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery(
		"SELECT   TOP 1\r\n"
		+ "		[AC].[NAME],\r\n"
		+ "		r.Name as 'roleName'\r\n"
		+ "	FROM\r\n"
		+ "		adl.AspNetUsers a\r\n"
		+ "		LEFT JOIN adl.AspNetAccountRelations cr ON a.id = cr.UserId\r\n"
		+ "		LEFT JOIN adl.AspNetAccountRelationsHistory crh ON a.id = crh.UserId --Posible cambiar por vista filtrada por el ultimo borrado\r\n"
		+ "		LEFT JOIN adl.AspNetUserPropertiesHistory uph ON a.id = uph.UserId\r\n"
		+ "		AND crh.X_END_TIME = uph.X_END_TIME\r\n"
		+ "		LEFT JOIN adl.AspNetUserRoles_History urh ON a.id = urh.UserId\r\n"
		+ "		LEFT JOIN adl.AspNetRoles r ON r.Id = urh.RoleId\r\n"
		+ "		LEFT JOIN [dbo].[ACCOUNT] AS [AC] WITH (NOLOCK) ON [AC].[ID] = crh.[AccountId]\r\n"
		+ "		LEFT JOIN [dbo].[ACCOUNT_ROLE_TYPE] AS [ART] WITH (NOLOCK) ON [ART].[ID] = [AC].[ROLE_TYPE_ID]\r\n"
		+ "		JOIN [dbo].[ACCOUNT_STATUS] AS [S] WITH (NOLOCK) ON [S].[ID] = [AC].[ACCOUNT_STATUS_ID]\r\n"
		+ "	WHERE\r\n"
		+ "		--crh.AccountId = 21648\r\n"
		+ "		crh.X_END_TIME >= GETDATE() -30\r\n"
		+ "		AND AC.NAME like 'a%'\r\n"
		+ "		AND cr.UserId IS NULL\r\n"
		+ "		AND uph.UserId IS NOT NULL\r\n"
		+ "		AND S.STATUS NOT IN ('OOB','Terminated')\r\n"
		+ "		GROUP BY a.id, crh.UserId,[AC].[NAME],r.Name\r\n"
		+ "     ORDER BY AC.NAME");
	dbMap = dc.returnAllData(rs);
		return dbMap;
	} catch (Exception e) {
		throw e;
	} finally {
		dc.closeConnection();
	}
	}
	
	public void getSelectStatusAsCompleted() throws InterruptedException {
		 manageUserPage.selectStatusAsCompleted();
	 }
	
	public HashMap<Integer, HashMap<String, String>> getAllDeletedUsersFromDB() throws Exception {
		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery("SELECT Top 5 AC.NAME Account,\r\n"
					+ "\r\n"
					+ "		a.id UserId,\r\n"
					+ "		MAX(FirstName) FirstName,\r\n"
					+ "		MAX(LastName) LastName,\r\n"
					+ "		MAX(UserName) UserName,\r\n"
					+ "		REPLACE(MAX(Email), '_DELETED', '') Email,\r\n"
					+ "		MAX(PIN) PIN,\r\n"
					+ "		MAX(r.Name) RoleName,\r\n"
					+ "		MAX(crh.X_END_TIME) DeletedDate,\r\n"
					+ "		cast(cast(MAX(crh.X_END_TIME) AS datetime ) - GETDATE() AS int) days\r\n"
					+ "	FROM\r\n"
					+ "		adl.AspNetUsers a\r\n"
					+ "		LEFT JOIN adl.AspNetAccountRelations cr ON a.id = cr.UserId\r\n"
					+ "		LEFT JOIN adl.AspNetAccountRelationsHistory crh ON a.id = crh.UserId \r\n"
					+ "		LEFT JOIN adl.AspNetUserPropertiesHistory uph ON a.id = uph.UserId\r\n"
					+ "		AND crh.X_END_TIME = uph.X_END_TIME\r\n"
					+ "		LEFT JOIN adl.AspNetUserRoles_History urh ON a.id = urh.UserId\r\n"
					+ "		LEFT JOIN adl.AspNetRoles r ON r.Id = urh.RoleId\r\n"
					+ "		LEFT JOIN [dbo].[ACCOUNT] AS [AC] WITH (NOLOCK) ON [AC].[ID] = crh.[AccountId]\r\n"
					+ "		LEFT JOIN [dbo].[ACCOUNT_ROLE_TYPE] AS [ART] WITH (NOLOCK) ON [ART].[ID] = [AC].[ROLE_TYPE_ID]\r\n"
					+ "		JOIN [dbo].[ACCOUNT_STATUS] AS [S] WITH (NOLOCK) ON [S].[ID] = [AC].[ACCOUNT_STATUS_ID]\r\n"
					+ "	WHERE\r\n"
					+ "		cr.UserId IS NULL\r\n"
					+ "		AND uph.UserId IS NOT NULL\r\n"
					+ "		AND S.ID = 1\r\n"
					+ "		group by a.id , crh.UserId, AC.NAME\r\n"
					+ "		ORDER BY	days desc");
		
				
		dbMap = dc.returnAllData(rs);
		return dbMap;
	} catch (Exception e) {
		throw e;
	} finally {
		dc.closeConnection();
	}
	}
	
}
