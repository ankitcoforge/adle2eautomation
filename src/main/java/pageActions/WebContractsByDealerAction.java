package pageActions;
import java.sql.ResultSet;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import pageObjects.WebContractsByDealerPO;
import utils.Database_Connectivity;
import utils.utilityClass;
@Listeners(utils.listnerlogs.class)


public class WebContractsByDealerAction extends WebContractsByDealerPO{
	
		verticalMenuAction verticalMenu=new verticalMenuAction();
		utilityClass utils= new utilityClass();
		loginAction login = new loginAction();
		Database_Connectivity dc = new Database_Connectivity();
		
		public WebElement webContractsInMenu() throws InterruptedException{
			  WebElement WebContractsMenu = utils.getfield("a", "Web Contracts by Dealer");
			return WebContractsMenu;
		}

		 public String getTitle() {
			 String webContractTitle=driver.findElement(By.xpath(WebContractstitle)).getText();	
			 return webContractTitle;
		 }
		 
		 public String getAdminRoleId() {
			 String roleId=driver.findElement(By.xpath(adminRoleId)).getText();	
			 return roleId;
		 }
		 
		 public void leftMenu(String heading) throws InterruptedException {
				Thread.sleep(4000);
				driver.switchTo().activeElement();
				utils.getfield("button", heading).click();
			}
		 
		 public WebElement getRowsPerPage() {
			    WebElement rowsPerPageTxt = driver.findElement(By.cssSelector(rowsPerPage));
				return rowsPerPageTxt;	
		 }
		 
		 public WebElement getRowsPerPageDropdownbtn() {
			    WebElement rowsPerPageDropdownBtn = driver.findElement(By.xpath(rowsPerPageDropdownbtn));
				return rowsPerPageDropdownBtn;	
		 }
		 
		 public WebElement getContractsGrid() {
			    WebElement contractRecordsInGrid = driver.findElement(By.xpath(contractRecordsGrid));
				return contractRecordsInGrid;	
		 }
		 
		
		 public List<WebElement> getReportsDropdownlist() {
			 List<WebElement> reportsDropdownlistofValues = driver.findElements(By.cssSelector(reportsDropdownlist));
				return reportsDropdownlistofValues;	
		 }
		 
		 public List<WebElement> getRowsPerPageDropdownlist() {
			     List<WebElement> rowsPerPagelistInDropdown = driver.findElements(By.cssSelector(rowsPerPageDropdownlist));
				return rowsPerPagelistInDropdown;	
		 }
		 
		 public WebElement getRowsPerPageSelected() {
			    WebElement rowsPerPageTotalSelected = driver.findElement(By.cssSelector(rowsPerPageSelected));
				return rowsPerPageTotalSelected;	
		 }
		 
		 public WebElement getElementInFirstGrid(String name) {
		 String firstGrid = "//adl-text-input[@placeholder='" + name + "']//input[@type='text']";
		 WebElement elemntInfirstGrid = driver.findElement(By.xpath(firstGrid));
		 return elemntInfirstGrid;
		 }
		 
		 public WebElement getBorderOfElement(String name) {
			 String firstGrid = "//adl-text-input[@placeholder='" + name + "']//div[@class='text-field__input secure']";
			 WebElement elemntInfirstGrid = driver.findElement(By.xpath(firstGrid));
			 return elemntInfirstGrid;
			 }
		 
		 public WebElement getArrowForwardBtn() {
			    WebElement arrowForwardButton = driver.findElement(By.xpath(arrowForwardBtn));
				return arrowForwardButton;	
		 }
		 
		 public WebElement getSpinner() {
			    WebElement spinnerIcon = driver.findElement(By.cssSelector(spinner));
				return spinnerIcon;	
		 }
		 
		 public WebElement getPageNo(String number) {
			 String pageNo="//span[@class='ui-paginator-pages']//a[text()='" + number + "']";
			 WebElement pageNumber = driver.findElement(By.xpath(pageNo));
			 return pageNumber;
			 }
		 
		 
		 
		 public String getCurrentPageRecord() {
			 WebElement currentPageRecords = driver.findElement(By.xpath(currentPageRecord));
			 String[] currentPage = currentPageRecords.getText().split(" ");
			 //int currentPageRecord = Integer.parseInt(currentPage[1]);
			 return currentPage[1];			 
			 }
		 
		
		 public String getTotalPagesDisplayed() {
			  List<WebElement> totalNumOfPagesDisplayed = driver.findElements(By.xpath(totalPagesDisplayed));
			 int totalPagesDisplayed= totalNumOfPagesDisplayed.size();
			 String totalPagesDisplayedString = Integer.toString(totalPagesDisplayed);
			 return totalPagesDisplayedString;
			 }
		 
		 public WebElement getPlsMakeaSearchTxt() {
			    WebElement plsMakeaSearchToDisplayTxt = driver.findElement(By.xpath(plsMakeaSearchTxt));
				return plsMakeaSearchToDisplayTxt;	
		 }
		 
		 public List<WebElement> getEditBtns() {
			  List<WebElement> editButtons = driver.findElements(By.cssSelector(editButtnGrid));
			  return editButtons;
			 }
		 
		 public List<WebElement> getRestoreBtns() {
			  List<WebElement> restoreButtons = driver.findElements(By.cssSelector(editButtnGrid));
			  return restoreButtons;
			 }
		
		 public List<WebElement> getEditStatusTxt() {
			  List<WebElement> editButtons = driver.findElements(By.xpath(editStatusTxt));
			  return editButtons;
			 }
		 
		 public List<WebElement> getRestoreContractTxt() {
			  List<WebElement> restoreButtns = driver.findElements(By.xpath(restoreContractTxt));
			  return restoreButtns;
			 }
		 
		 public WebElement getEditConfirmationMsg() {
			  WebElement editConfirmationtxt = driver.findElement(By.cssSelector(editConfirmationMsg));
			  return editConfirmationtxt;
			 }
		 
		 public WebElement getConfirmationYesBtn() {
			  WebElement confirmationYesBtn = driver.findElement(By.cssSelector(editConfirmationYesBtn));
			  return confirmationYesBtn;
			 }
		 
		 public WebElement getConfirmationNoBtn() {
			  WebElement confirmationNoBtn = driver.findElement(By.cssSelector(editConfirmationNoBtn));
			  return confirmationNoBtn;
			 }
		 
		 
		 public WebElement getIconClose() {
			  WebElement iconCloseBtn = driver.findElement(By.xpath(iconClose));
			  return iconCloseBtn;
			 }
		 
		 
		 public WebElement getRestoreContractMsg() {
			  WebElement restoreContractMessage = driver.findElement(By.xpath(restoreContractMsg));
			  return restoreContractMessage;
			 }
		 
		 public WebElement getEditContractPopup() {
			  WebElement editContractsPopup = driver.findElement(By.cssSelector(editContractPopup));
			  return editContractsPopup;
			 }
		 
		 public WebElement getRestoreContractPopup() {
			  WebElement restoreContractsPopup = driver.findElement(By.cssSelector(restoreContractPopup));
			  return restoreContractsPopup;
			 }
		 
		 
		 
		 public WebElement getGridArrowBtn(String name) {
			 List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
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
		 
		 public WebElement getInvalidLastNametxt() {
			    WebElement lastNameInvalidTxt = driver.findElement(By.xpath(invalidLastNametxt));
				return lastNameInvalidTxt;	
		 }
		 
		 public WebElement getInvalidVINtxt() {
			    WebElement txtInvalidVIN = driver.findElement(By.xpath(invalidVINtxt));
				return txtInvalidVIN;	
		 }
		 
		 public WebElement getNoRecordstxt() {
			    WebElement txtNoRecord = driver.findElement(By.xpath(noRecordstxt));
				return txtNoRecord;	
		 }
		 
		 public WebElement getAtleastOneRecordtxt() {
			    WebElement atleastOneRecordtxt = driver.findElement(By.xpath(enterAtleastOneRecordtxt));
				return atleastOneRecordtxt;	
		 }
		 
		 public List<String> getRowLoc() {
			 List<String> rowLoactor = utils.getTextValuesForObject("cssSelector", rowLoc);
             return rowLoactor;
		 }
		 
		 public List<String> getAllHeaderNames() {
			 List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
             return allHeaderNames;
		 }
		 
			public HashMap<Integer, HashMap<String, String>> checkGridBodyDetails() throws InterruptedException {
				List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
				System.out.println("allHeaderNames: " + allHeaderNames);
				HashMap<Integer, HashMap<String, String>> allTableData = new HashMap<Integer, HashMap<String, String>>();
				
				// Get total rows count
				List<WebElement> allRowsEle = utils.getElementsList("cssSelector", rowLoc);
				System.out.println("No of rows in grid: " + allRowsEle.size());
				
				for (int i = 1; i <= allRowsEle.size(); i++) {
					if (i == 10) 	
						utils.scrollDown();

					// Getting specific row with each iteration
					String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
					LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
					for (int j = 1; j < allHeaderNames.size() - 1; j++) {
						
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
			
			public HashMap<Integer, HashMap<String, WebElement>> getElementsFromGridBody() throws InterruptedException {
				List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
				HashMap<Integer, HashMap<String, WebElement>> allTableData = new HashMap<Integer, HashMap<String, WebElement>>();
				List<WebElement> allRowsEle = utils.getElementsList("cssSelector", rowLoc);
				for (int i = 1; i <= allRowsEle.size(); i++) {
					if (i == 10) 	
						utils.scrollDown();
					String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
					LinkedHashMap<String, WebElement> eachRowData = new LinkedHashMap<>();
					for (int j = 1; j < allHeaderNames.size() - 1; j++) {
						String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>span:nth-of-type(2)";
						WebElement cellValue = null;
							cellValue = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
						eachRowData.put(allHeaderNames.get(j-1), cellValue);
					}
					allTableData.put(i, eachRowData);
				}
				System.out.println("Complete Grid data: " + allTableData);
				utils.scrollUp();	
				return allTableData;
				}
			
			
			
			 public void verifyRestoreMsgFromRestoreIcon() throws InterruptedException {
				 HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
				 Actions action = new Actions(driver);
				 if(allTableData.size() > 0) {
					for (int i = 1; i <= allTableData.size(); i++) {
							HashMap<String, String> getRowData = allTableData.get(i);
							String value = getRowData.get("Status");
					if(value.contains("DELETED"))
							{
								action.moveToElement(getEditRestorBtns(i)).perform();
								Assert.assertTrue(getRestoreBtns().get(1).isDisplayed());
							}
							break;
						}
			 }
			 }
			 
			 public String getValueFromStatus(String STATUS,String HeaderName) throws InterruptedException {
				HashMap<Integer, HashMap<String, String>> allTableData2 = checkGridBodyDetails();
				String value = null;
				for (int i = 1; i < getRowLoc().size(); i++) {
					  if(allTableData2.get(i).get("Status").equals(STATUS))
					  {
						  value = allTableData2.get(i).get(HeaderName);
						break;
					  }
				     }
				return value;
			 }
			 
			 public WebElement getEditRestorBtns(int row) throws InterruptedException {
	       					String specificRowLoc = "table>tbody>tr:nth-of-type(" + row + ")";
  							String specificRowColLoc = "td:nth-of-type(11)>adl-table-cells>div";
  							WebElement  element = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
					return element;
					}
			 
			 public List<WebElement> getEditRestoreElementsVisibility(int row) {
					String specificRowLoc = "table>tbody>tr:nth-of-type(" + row + ")";
					String specificRowColLoc = "td:nth-of-type(11)>adl-table-cells>div>div:nth-of-type(1)>i";
					List<WebElement>  elements = utils.getElementsList("cssSelector", specificRowLoc + ">" + specificRowColLoc);
			return elements;
			}
			 
				public HashMap<Integer, HashMap<String, String>> getDataFromDB(String Status) throws Exception  {
					HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
					try {
						dc.aulDBConnect();
						ResultSet rs = dc.stmt.executeQuery(
						"Select TOP 1 VIN, CERT, LAST_NAME, STATUS FROM [DBO].[WEB_CONTRACTS] where STATUS =  '" + Status + " '");
						dbMap = dc.returnAllData(rs);
						return dbMap;
					} catch (Exception e) {
						throw e;
					} finally {
						dc.closeConnection();
					}
					
				}
				
				public HashMap<Integer, HashMap<String, String>> getWebContractsAllTableDataFromDB() throws Exception  {
					HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
					try {
						dc.aulDBConnect();
						ResultSet rs = dc.stmt.executeQuery(
						"Select DEALER_ID, VIN, CERT, LAST_NAME FROM [DBO].[WEB_CONTRACTS];");
						dbMap = dc.returnAllData(rs);
						return dbMap;
					} catch (Exception e) {
						throw e;
					} finally {
						dc.closeConnection();
					}
					
				}
				
				
				public HashMap<Integer, HashMap<String, String>> getDealerFromDB() throws Exception  {
					HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
					try {
						dc.aulDBConnect();
						ResultSet rs = dc.stmt.executeQuery(
						"select TOP 1 DEALER_ID FROM WEB_CONTRACTS GROUP BY DEALER_ID having COUNT (DEALER_ID) =10;");
						dbMap = dc.returnAllData(rs);
						return dbMap;
					} catch (Exception e) {
						throw e;
					} finally {
						dc.closeConnection();
					}
					
				}
				
				public HashMap<Integer, HashMap<String, String>> getDataFromDBForAllTypesStatus() throws Exception  {
					HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
					try {
						dc.aulDBConnect();
						ResultSet rs = dc.stmt.executeQuery(
								"SELECT STATUS FROM WEB_CONTRACTS "
								+ "WHERE cert = (SELECT top 1 cert FROM [DBO].[WEB_CONTRACTS] where status = 'entered' order by date_created desc) or "
								+ "cert = (SELECT top 1 cert FROM [DBO].[WEB_CONTRACTS] where status = 'deleted' order by date_created desc) or "
								+ "cert = (SELECT top 1 cert FROM [DBO].[WEB_CONTRACTS] where status = 'Quote' order by date_created desc) or "
								+ "cert = (SELECT top 1 cert FROM [DBO].[WEB_CONTRACTS] where status = 'Remitted' order by date_created desc) or "
								+ "cert = (SELECT top 1 cert FROM [DBO].[WEB_CONTRACTS] where status = 'Processed' order by date_created desc)");
						dbMap = dc.returnAllData(rs);
						return dbMap;
					} catch (Exception e) {
						throw e;
					} finally {
						dc.closeConnection();
					}
					
				}
}


