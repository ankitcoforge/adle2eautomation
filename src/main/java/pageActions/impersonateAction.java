package pageActions;


import java.sql.ResultSet;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import pageObjects.impersonatepo;
import utils.Database_Connectivity;
import utils.utilityClass;

public class impersonateAction extends impersonatepo {

	utilityClass event = new utilityClass();
	verticalMenuAction va = new verticalMenuAction();
	Database_Connectivity dc = new Database_Connectivity();
	
	 public WebElement getTitle() {
		 WebElement welcomeTitle=driver.findElement(By.xpath(title));	
		 return welcomeTitle;
	 }

	public void impersonateUser(String role,String roleid) throws InterruptedException {
		event.clickfield("xpath", roleDropdown);
		 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		 for(int i=0;i<list.size();i++) {
			String text = list.get(i).getText();
			 
			if(text.equals(role))
			{
				list.get(i).click();
				event.inputfield("xpath", roleId, roleid);
				break;
			}
		 }
		event.clickfield("xpath", getusersButton);
		Thread.sleep(2000);
		event.clickfield("xpath", tableFirstRow);
		Thread.sleep(2000);

	}
	
	public List <String> loginImpersonate() {
		
		List<String> a = new ArrayList();
		System.out.println(driver.findElements(By.cssSelector(".mat-menu-trigger >span")));
		for(int i =0; i < driver.findElements(By.cssSelector(".mat-menu-trigger >span")).size(); i++)
		a.add(event.text("cssSelector", ".mat-menu-trigger >span",i));
		return a;
		
	}
	

	public String roleImpersonate() {
		
		return event.text("cssSelector", ".mat-menu-trigger > div >span.usertype");	 		
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

 	
 	public String getImpersonatedPageRoledID() {
 		String txt = event.text("xpath", "(//div[@class='ng-star-inserted']/span)[2]");
 		System.out.println("imp id isssss:"+txt.split(" ")[1]);
 		 return txt.split(" ")[1];
 		 
 	 }
 	public WebElement getImpersonatedPageDealerRoledID() {
 		return driver.findElement(By.xpath(dealerRoleid));
 	 }
 	
	public void getUsers(String role,String roleid) throws InterruptedException {
		event.clickfield("xpath", roleDropdown);
		 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		 for(int i=0;i<list.size();i++) {
			String text = list.get(i).getText();
			 
			if(text.equals(role))
			{
				list.get(i).click();
				event.inputfield("xpath", roleId, roleid);
				break;
			}
		 }
		event.clickfield("xpath", getusersButton);
		Thread.sleep(2000);
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
			for (int j = 1; j < 8; j++) {
				
				String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>span:nth-of-type(2)";
			
				String cellValue = "";
					cellValue = event.element("cssSelector", specificRowLoc + ">" + specificRowColLoc).getText();

				eachRowData.put(allHeaderNames.get(j-1), cellValue);
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
	
	public HashMap<Integer, HashMap<String, String>> getDataFromDB() throws Exception  {
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
		System.out.println("dealer name------------"+ele.getText());
	 }
	public WebElement getBtnSignIn() {
		WebElement ele = driver.findElement(By.xpath(btnSignIn));	
		 return ele; 
	 }
	
	
}
