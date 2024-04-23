package pageActions;

import java.sql.ResultSet;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.impersonatepo;
import utils.Database_Connectivity;
import utils.utilityClass;

public class impersonateAction extends impersonatepo {

	utilityClass event = new utilityClass();
	verticalMenuAction va = new verticalMenuAction();
	Database_Connectivity dc = new Database_Connectivity();
//	   ManageUserPageAction ManageUserPage=new ManageUserPageAction();
//	   NewUserRegistration_Action NewUserRegistrationPage= new NewUserRegistration_Action();

	public WebElement getTitle() {
		WebElement welcomeTitle = driver.findElement(By.xpath(title));
		return welcomeTitle;
	}

	public void impersonateUser(String role, String roleid) throws InterruptedException {
		event.clickfield("xpath", roleDropdown);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();

			if (text.equals(role)) {
				list.get(i).click();
				event.inputfield("xpath", roleId, roleid);
//				List<WebElement> list2 = getDriver().findElements(By.xpath(roleDropdownList));
//				list2.get(0).click();
				break;
			}
		}
		Thread.sleep(1000);
		event.clickfield("xpath", getusersButton);
		Thread.sleep(2000);
		event.clickfield("xpath", tableFirstRow);
		Thread.sleep(6000);
	}
	
	
	public void impersonateUserForSubagentLendrEmp(String role, String roleid) throws InterruptedException {
//		event.clickfield("xpath", roleDropdown);
//		Thread.sleep(10000);
		if(role.equals("SubAgent") | role.equals("LenderEmp")){
			event.clickfield("xpath", roleDropdown);
			List<WebElement> listNew = getDriver().findElements(By.xpath(roleDropdownList));
			listNew.get(9).click();
			event.clickfield("xpath", roleDropdown);
			List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
			for (int i = 0; i < list.size(); i++) {
				String text = list.get(i).getText();
				System.out.println("list-- "+i);

				if (text.equals(role)) {
					list.get(i).click();
					event.inputfield("xpath", roleId, roleid);
					List<WebElement> list2 = getDriver().findElements(By.xpath(roleDropdownListForDealer));
					list2.get(0).click();
					Thread.sleep(5000);
					break;
				}
			}
			event.clickfield("xpath", getusersButton);
			Thread.sleep(10000);
//			event.waitUntilElementisInVisible(getMakeSearchToDisplayRecords());
//		Thread.sleep(2000);
		event.clickfield("xpath", tableFirstRow);
		Thread.sleep(2000);
		}
	}
	
	public void impersonateUserByGivingPermissions(String role, String roleid) throws InterruptedException {
		event.clickfield("xpath", roleDropdown);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();

			if (text.equals(role)) {
				list.get(i).click();
				event.inputfield("xpath", roleId, roleid);
				break;
			}
		}
		Thread.sleep(1000);
		event.clickfield("xpath", getusersButton);
		Thread.sleep(1000);
		 event.element("xpath", registrationStatusArrow).click();
		 event.element("xpath", completedCheckbox).click();
		 event.element("xpath", registrationStatusArrow).click();
			Thread.sleep(2000);
		 HashMap<Integer, HashMap<String, WebElement>> tableDataForEditDelLock = checkGridForEditDelLock();
		 event.waitTillElementIsVisible(tableFirstRow);
				tableDataForEditDelLock.get(1).get("Edit").click();
		
		 WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfAllElements(event.getElementsList("xpath", permissionsArrow)));
		event.element("xpath", permissionsArrow).click();
		event.waituntillPageIsloaded();
		Thread.sleep(2000);
		if(event.element("xpath", selectAllLink).getAttribute("aria-checked").equals("false")) {
			event.element("xpath", selectAllLink).click();
		}
		Thread.sleep(2000);
		event.element("xpath", closeInPermPopup).click();
//		Thread.sleep(2000);
		if(!event.element("xpath", updateBtnStatus).getAttribute("disabled").equals("true")) {
		event.element("xpath", updateBtn).click();
		Thread.sleep(2000);
		event.element("xpath", yesBtn).click();
		event.waituntillPageIsloaded();
		}
		else {
			event.getfield("mat-icon", "close").click();	
		}
		Thread.sleep(2000);
		event.clickfield("xpath", tableFirstRow);
		Thread.sleep(2000);
			}

	public void impersonateUserByRemovingPermissions(String role, String roleid) throws InterruptedException {
		event.clickfield("xpath", roleDropdown);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();

			if (text.equals(role)) {
				list.get(i).click();
				event.inputfield("xpath", roleId, roleid);
				break;
			}
		}
		Thread.sleep(1000);
		event.clickfield("xpath", getusersButton);
		Thread.sleep(1000);
		 event.element("xpath", registrationStatusArrow).click();
		 event.element("xpath", completedCheckbox).click();
		 event.element("xpath", registrationStatusArrow).click();
			Thread.sleep(2000);
		 HashMap<Integer, HashMap<String, WebElement>> tableDataForEditDelLock = checkGridForEditDelLock();
		 event.waitTillElementIsVisible(tableFirstRow);
				tableDataForEditDelLock.get(1).get("Edit").click();
		
		 WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfAllElements(event.getElementsList("xpath", permissionsArrow)));
		event.element("xpath", permissionsArrow).click();
//		event.waituntillPageIsloaded();
		Thread.sleep(2000);
		if(event.element("xpath", selectAllLink).getAttribute("aria-checked").equals("true")) {
			event.element("xpath", selectAllLink).click();
		}
		Thread.sleep(2000);
		event.element("xpath", closeInPermPopup).click();
		event.waitTillElementIsVisible(updateBtn);
		event.element("xpath", updateBtn).click();
		Thread.sleep(1000);
		event.element("xpath", yesBtn).click();
		event.waituntillPageIsloaded();
		Thread.sleep(2000);
		event.clickfield("xpath", tableFirstRow);
		Thread.sleep(2000);
			}


	public List<String> loginImpersonate() {

		List<String> a = new ArrayList();
		System.out.println(driver.findElements(By.cssSelector(".mat-menu-trigger >span")));
		for (int i = 0; i < driver.findElements(By.cssSelector(".mat-menu-trigger >span")).size(); i++)
			a.add(event.text("cssSelector", ".mat-menu-trigger >span", i));
		return a;

	}

	public String roleImpersonate() {

		return event.text("cssSelector", ".mat-menu-trigger > div >span.usertype");
	}

	public String endImpersonate(String role, String roleId) throws InterruptedException {

		driver.get("https://qa.adl.aulcorp.com/portal");
		va.navigatetoLeftMenu("Reports", "Impersonate");
		impersonateUser(role, roleId);
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

	public String getImpersonatedPageRoledID() {
		String txt = event.text("xpath", "(//button[@class='mat-menu-trigger']/div/span)[2]");
		System.out.println("imp id isssss:" + txt.split(" ")[1]);
		return txt.split(" ")[1];
	}

	public String getImpersonatedPageRoledID1() {
		String txt = event.text("xpath", "(//div[@class='ng-star-inserted']/span)[2]");
		System.out.println("imp id isssss:" + txt.split(" ")[1]);
		return txt.split(" ")[1];
	}

	public WebElement getImpersonatedPageDealerRoledID() {
		return driver.findElement(By.xpath(dealerRoleid));
	}

	public void getUsers(String role, String roleid) throws InterruptedException {
		if(role.equals("SubAgent") | role.equals("LenderEmp")){
		event.clickfield("xpath", roleDropdown);
		List<WebElement> listNew = getDriver().findElements(By.xpath(roleDropdownList));
		listNew.get(9).click();
		event.clickfield("xpath", roleDropdown);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			System.out.println("list-- "+i);

			if (text.equals(role)) {
				list.get(i).click();
				event.inputfield("xpath", roleId, roleid);
				List<WebElement> list2 = getDriver().findElements(By.xpath(roleDropdownListForDealer));
				list2.get(0).click();
				Thread.sleep(5000);
				break;
			}
		}
		event.clickfield("xpath", getusersButton);
		Thread.sleep(10000);
//		event.waitUntilElementisInVisible(getMakeSearchToDisplayRecords());
	}
	else {
		event.clickfield("xpath", roleDropdown);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			System.out.println("list-- "+i);

			if (text.equals(role)) {
				list.get(i).click();
				event.inputfield("xpath", roleId, roleid);
				List<WebElement> list2 = getDriver().findElements(By.xpath(roleDropdownListForDealer));
				list2.get(0).click();
				Thread.sleep(10000);
				break;
			}
		}
		event.clickfield("xpath", getusersButton);
		Thread.sleep(10000);
//		event.waitUntilElementisInVisible(getMakeSearchToDisplayRecords());
	}
}
	
	public void getUsersForAgentPackDealerPasstroughLenderPassthrough(String role, String roleid) throws InterruptedException {
		if(role.equals("SubAgent") | role.equals("LenderEmp")){
		event.clickfield("xpath", roleDropdown);
		List<WebElement> listNew = getDriver().findElements(By.xpath(roleDropdownList));
		listNew.get(9).click();
		event.clickfield("xpath", roleDropdown);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			System.out.println("list-- "+i);

			if (text.equals(role)) {
				list.get(i).click();
				event.inputfield("xpath", roleId, roleid);
//				List<WebElement> list2 = getDriver().findElements(By.xpath(roleDropdownListForDealer));
//				list2.get(0).click();
				Thread.sleep(10000);
				break;
			}
		}
		event.clickfield("xpath", getusersButton);
		Thread.sleep(10000);
//		event.waitUntilElementisInVisible(getMakeSearchToDisplayRecords());
	}
	else {
		event.clickfield("xpath", roleDropdown);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			System.out.println("list-- "+i);

			if (text.equals(role)) {
				list.get(i).click();
				event.inputfield("xpath", roleId, roleid);
//				List<WebElement> list2 = getDriver().findElements(By.xpath(roleDropdownListForDealer));
//				list2.get(0).click();
				Thread.sleep(10000);
				break;
			}
		}
		event.clickfield("xpath", getusersButton);
		Thread.sleep(10000);
//		event.waitUntilElementisInVisible(getMakeSearchToDisplayRecords());
	}
}


	public WebElement getMakeSearchToDisplayRecords() {
		WebElement ele = event.getfield("td", "Please make a search to display records");
		return ele;
	}
	
	public WebElement getRoleType1() {
		  WebElement ele = driver.findElement(By.xpath(roleType1));	
		 return ele;
		}
	
	public void selectRoleType(String roleType) throws InterruptedException {
	    Actions action=new Actions(driver);
	    action.moveToElement(getRoleType1()).click().build().perform();
	    Thread.sleep(2000);
		 WebElement ele =driver.findElement(By.xpath("//li[@aria-label='"+roleType+"']/div/div/span"));
		 ele.click();
		 Thread.sleep(1000);
		 action.moveToElement(getRoleType1()).click().build().perform();
		 Thread.sleep(1000);
	}

	public void getUsersThroughArrowBtn(String role, String roleid) throws InterruptedException {
		event.clickfield("xpath", roleDropdownInAccountManagementPage);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();

			if (text.equals(role)) {
				list.get(i).click();
				break;
			}
		}
		event.inputfield("xpath", roleIdInAccountManagementPage, roleid);
		List<WebElement> list2 = getDriver().findElements(By.xpath(roleDropdownList));
		list2.get(0).click();
		event.clickfield("xpath", getArrowBtn);
		Thread.sleep(10000);
	}
	
	public List<String> getAllHeaders() {
		List<String> allHeaderNames = event.getTextValuesForObject("cssSelector", headerLoc);
		return allHeaderNames;
	}
	
	public String getHeaderShowPackPasstrough() {
		String showPackPasstrough=event.text("cssSelector", show)+event.text("cssSelector", pack)+event.text("cssSelector", passthrough);
		System.out.println("header is: "+showPackPasstrough);
		return showPackPasstrough;
	}
	

	public HashMap<Integer, HashMap<String, WebElement>> checkGridForEditDelLock() {
		List<String> allHeaderNames = event.getTextValuesForObject("cssSelector", headerLoc);
		System.out.println("allHeaderNames: " + allHeaderNames);
		HashMap<Integer, HashMap<String, WebElement>> allTableData = new HashMap<Integer, HashMap<String, WebElement>>();
		// Get total rows count
		List<WebElement> allRows = event.getElementsList("cssSelector", rowLoc);
		System.out.println("No of rows in grid: " + allRows.size());
		for (int i = 1; i <= allRows.size(); i++) {
			if (i == 10)
				event.scrollDown();
			// Getting specific row with each iteration
			String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
			LinkedHashMap<String, WebElement> eachRowData = new LinkedHashMap<>();
			for (int j = 3; j < allHeaderNames.size(); j++) {
				String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div";
				WebElement cellValue = event.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
				eachRowData.put(allHeaderNames.get(j - 1), cellValue);
			}
			allTableData.put(i, eachRowData);
		}
		System.out.println("Complete Grid data: " + allTableData);
		event.scrollUp();
		return allTableData;
	}

	public HashMap<Integer, HashMap<String, String>> checkGridBodyDetails() {
		List<String> allHeaderNames = event.getTextValuesForObject("cssSelector", headerLoc);
		System.out.println("allHeaderNames: " + allHeaderNames);
		HashMap<Integer, HashMap<String, String>> allTableData = new HashMap<Integer, HashMap<String, String>>();

		// Get total rows count
		List<WebElement> allRowsEle = event.getElementsList("cssSelector", rowLoc);
		System.out.println("No of rows in grid: " + allRowsEle.size());

		for (int i = 1; i <= allRowsEle.size(); i++) {
			if (i == 10)
				event.scrollDown();

			// Getting specific row with each iteration
			String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			for (int j = 1; j < 6; j++) {

				String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>span:nth-of-type(2)";

				String cellValue = "";
				cellValue = event.element("cssSelector", specificRowLoc + ">" + specificRowColLoc).getText();

				eachRowData.put(allHeaderNames.get(j - 1), cellValue);
			}
			allTableData.put(i, eachRowData);
		}
		System.out.println("Complete Grid data: " + allTableData);
		event.scrollUp();
		return allTableData;
	}

	public WebElement getBtnYes() {
		WebElement rows = driver.findElement(By.xpath(btnYes));
		return rows;
	}

	public List<WebElement> getRows() {
		List<WebElement> rows = driver.findElements(By.cssSelector(rowLoc));
		return rows;
	}

	public HashMap<Integer, HashMap<String, String>> getDataFromDB() throws Exception {
		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		try {
			dc.aulDBConnect();
			dc.stmt.executeQuery("Select Count(*) from web_contracts;");
			ResultSet rs = dc.stmt.executeQuery(
					"EXEC [adl].[SP_IMPERSONATE_GET_USERS] @ROLE_IDENTIFIER = '110', @ROLE_TYPE = 'Agent', @IS_ADMIN = 1, @USERNAME = 'coforgeadmin', @DEBUG = 0;");
			dbMap = dc.returnAllData(rs);
			System.out.println(dbMap);
			return dbMap;
		} catch (Exception e) {
			throw e;
		} finally {
			dc.closeConnection();
		}
	}

	public WebElement getRoletype() {
		WebElement ele = driver.findElement(By.xpath(roleType));
		return ele;
	}

	public WebElement getAccountName() {
		WebElement ele = driver.findElement(By.xpath(accountName));
		return ele;
	}

	public WebElement getUserName() {
		WebElement ele = driver.findElement(By.xpath(userName));
		return ele;
	}

	public WebElement getFirstname() {
		WebElement ele = driver.findElement(By.xpath(firstname));
		return ele;
	}

	public WebElement getLastname() {
		WebElement ele = driver.findElement(By.xpath(lastname));
		return ele;
	}

	public WebElement getEmail() {
		WebElement ele = driver.findElement(By.xpath(email));
		return ele;
	}

	public WebElement getBtnUpdate() {
		WebElement ele = driver.findElement(By.xpath(btnUpdate));
		return ele;
	}

	public WebElement getIconClose() {
		WebElement ele = driver.findElement(By.xpath(iconClose));
		return ele;
	}

	public WebElement getBtnSubmit() {
		WebElement ele = driver.findElement(By.xpath(btnSubmit));
		return ele;
	}

	public WebElement getResendInvitationConfirmMsg() {
		WebElement ele = driver.findElement(By.xpath(resendInvitationConfirmMsg));
		return ele;
	}

	public void getSelectDealerTogenerateContract() {
		WebElement ele = driver.findElement(By.xpath(selectDealerTogenerateContract));
		ele.click();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		System.out.println("dealer name------------" + ele.getText());
	}

	public WebElement getBtnSignIn() {
		WebElement ele = driver.findElement(By.xpath(btnSignIn));
		return ele;
	}

//	 public String singleContract() throws InterruptedException {
//		 Thread.sleep(2000);
//		 
//			utils.clickfield("cssSelector", table, 0);
//			Thread.sleep(5000);
//			utils.scrollDown();
//			utils.inputfield("cssSelector", textbox, "22723", 7);
//			utils.inputfield("cssSelector", contract, "10000", 0);
//			Thread.sleep(1000);
//			//utils.clickfield("xpath", noSurchargesChkbx);
//			JavascriptExecutor js=(JavascriptExecutor)driver;
//			if(!getLiftKitStatus().isSelected()) {
//			js.executeScript("arguments[0].scrollIntoView();", getLiftKit());
//			js.executeScript("arguments[0].click();", getLiftKit());
//			}
//			//utils.clickfield("xpath", liftkit);
//			//utils.clickfield("xpath", businessUse);
//			String contractNumber = driver.findElement(By.cssSelector(contractNo)).getDomProperty("value");
//			System.out.println("Contract Number is:"+contractNumber);
//			
//			List <WebElement> a = driver.findElements(By.cssSelector(contractNew.inServiceDate));
//			if(a.size() == 1) {
//				String a1  = driver.findElement(By.cssSelector(contractNew.inServicefield)).getAttribute("class");
//				if(!(a1.contains("disabled"))) {
//					driver.findElement(By.cssSelector(contractNew.inServiceDateTextBox)).click();
//					driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
//				}
//				
//			}
//			//Assert.assertEquals(contractNew.addGapLabel(), "Add GAP");
//
//			driver.findElements(By.cssSelector(pincode)).get(0).clear();
//			utils.inputfield("cssSelector", pincode, "20130", 0);
//			driver.findElements(By.cssSelector(address)).get(0).clear();
//			utils.inputfield("cssSelector", address, "Address", 0);
//			driver.findElements(By.cssSelector(email)).get(0).clear();
//			utils.inputfield("cssSelector", email, "test@gmail.com", 0);
//			Thread.sleep(2000);
//			utils.clearfield("cssSelector", contractNew.phone);
//			utils.inputfield("cssSelector", contractNew.phone, "1234567890");
//			utils.clickfield("xpath", contractNew.generateContract);
//			getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
//			Thread.sleep(2000);
//			utils.clickfield("cssSelector", gc.checkbox, 0);
//			utils.clickfield("cssSelector", gc.checkbox, 1);
//			utils.clickfield("xpath", gc.genrateContractButton);
//			Thread.sleep(10000);
//			String text1 = utils.text("cssSelector", contractNew.successMessage);
//			Assert.assertEquals(text1, "You have successfully generated a contract!");
//			utils.clickfield("xpath", contractNew.newQuotelink);
//			return contractNumber;
//			}
//
//	 
//	 public String singleContractForLender() throws InterruptedException {
//		 Thread.sleep(2000);
//		 
//			utils.clickfield("cssSelector", table, 0);
//			Thread.sleep(5000);
//			utils.scrollDown();
//			utils.inputfield("cssSelector", textbox, "22723", 7);
//			utils.inputfield("cssSelector", contract, "10000", 0);
//			Thread.sleep(1000);
//			//utils.clickfield("xpath", liftkit);
//			utils.clickfield("xpath", businessUse);
//			String contractNumber = driver.findElement(By.cssSelector(contractNo)).getDomProperty("value");
//			System.out.println("Contract Number is:"+contractNumber);
//			
//			List <WebElement> a = driver.findElements(By.cssSelector(contractNew.inServiceDate));
//			if(a.size() == 1) {
//				String a1  = driver.findElement(By.cssSelector(contractNew.inServicefield)).getAttribute("class");
//				if(!(a1.contains("disabled"))) {
//					driver.findElement(By.cssSelector(contractNew.inServiceDateTextBox)).click();
//					driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
//				}
//				
//			}
//			//Assert.assertEquals(contractNew.addGapLabel(), "Add GAP");
//
//			driver.findElements(By.cssSelector(pincode)).get(0).clear();
//			utils.inputfield("cssSelector", pincode, "20130", 0);
//			driver.findElements(By.cssSelector(address)).get(0).clear();
//			utils.inputfield("cssSelector", address, "Address", 0);
//			driver.findElements(By.cssSelector(email)).get(0).clear();
//			utils.inputfield("cssSelector", email, "test@gmail.com", 0);
//			Thread.sleep(2000);
//			utils.clearfield("cssSelector", contractNew.phone);
//			utils.inputfield("cssSelector", contractNew.phone, "1234567890");
//			utils.clickfield("xpath", contractNew.generateContract);
//			getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
//			Thread.sleep(2000);
//			utils.clickfield("cssSelector", gc.checkbox, 0);
//			utils.clickfield("cssSelector", gc.checkbox, 1);
//			utils.clickfield("xpath", gc.genrateContractButton);
//			Thread.sleep(10000);
//			String text1 = utils.text("cssSelector", contractNew.successMessage);
//			Assert.assertEquals(text1, "You have successfully generated a contract!");
//			utils.clickfield("xpath", contractNew.newQuotelink);
//			return contractNumber;
//			}

	public HashMap<String, WebElement> getSearchBoxes() {
		event.scrollDown();
		HashMap<String, WebElement> map = new HashMap<String, WebElement>();
		List<String> allHeaderNames = event.getTextValuesForObject("cssSelector", headerLoc);
		List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(searchBoxesBelowHeadersInGrid));
		for (int j = 0; j < 4; j++) {
			map.put(allHeaderNames.get(j), searchBoxesInGrid.get(j));
		}
		return map;
	}

	public void getEndImpersonate() throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector(logoutArrow)).isDisplayed();
		driver.findElement(By.cssSelector(logoutArrow)).click();
		event.clickfield("xpath", endImpersonate);
		event.wait(20000);
	}

	public List<WebElement> getDropDownlistForRoleType() throws InterruptedException {
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		return list;
	}

	public void impersonateAsGenericUser(String role, String roleid) throws InterruptedException {
		event.clickfield("xpath", roleDropdown);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();

			if (text.equals(role)) {
				list.get(i).click();
				break;
			}
		}
		event.inputfield("xpath", roleId, roleid);
		List<WebElement> list2 = getDriver().findElements(By.xpath(roleDropdownListForAccountName));
		list2.get(0).click();
		event.waitTillElementIsClickableByWebEle(event.getfield("span", "Impersonate as Generic Role"));
		event.getfield("span", "Impersonate as Generic Role").click();
		Thread.sleep(5000);
	}

	public List<WebElement> getImpersonatingDataList() throws InterruptedException {
		List<WebElement> list = getDriver().findElements(By.xpath(impersonatingDataList));
		return list;
	}

	public void selectRoleTypeInGenericImpersonatePopup(String role) throws InterruptedException {
//		event.waitTillElementIsClickableByWebEle(event.element("xpath", roleDropdownArrowInPopup));
		Thread.sleep(3000);
		event.clickfield("xpath", roleDropdownArrowInPopup);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			if (text.equals(role)) {
				list.get(i).click();
				break;
			}
		}
	}

	public void impersonateAsGenericUserWith(String roleType, String roleId, String roleType2)
			throws InterruptedException {
		impersonateAsGenericUser(roleType, roleId);
		Thread.sleep(3000);
//		event.waitTillElementIsClickableByWebEle(event.element("xpath", roleDropdownArrowInPopup));
		event.clickfield("xpath", roleDropdownArrowInPopup);
		Thread.sleep(3000);
//		event.waitTillElementIsClickableByWebEle(getDropDownlistForRoleType().get(0));
		selectRoleTypeInGenericImpersonatePopup(roleType2);
		event.element("xpath", impersonateInGenericImpPopup).click();
		Thread.sleep(10000);
	}
	
	 public WebElement getGridArrowBtn(String name) {
		 List<String> allHeaderNames = event.getTextValuesForObject("cssSelector", headerLoc);
		  List<WebElement> gridArrowBtns = driver.findElements(By.cssSelector(gridArrowBttn));
		  WebElement arrowbtn=null;
		  for (int i = 0; i <= allHeaderNames.size()-1; i++) {
			  if(allHeaderNames.get(i).contains(name))
			  {
					arrowbtn=gridArrowBtns.get(i);
				}
		}
		  return arrowbtn;
		 }
	 
	 public List<WebElement> getPackPassthroughBtn() {
			 List<WebElement> btnsList = driver.findElements(By.cssSelector(packPassthroughBtn));
			return btnsList;
		}
	 
	 public List<WebElement> getImpersonateList() {
		 List<WebElement> list = driver.findElements(By.xpath(impersonateList));
		return list;
	}

}
