package pageActions;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageObjects.WebContractsByDealerPO;
import utils.utilityClass;


public class WebContractsByDealerAction extends WebContractsByDealerPO{
	
		verticalMenuAction verticalMenu=new verticalMenuAction();
		utilityClass utils= new utilityClass();
		loginAction login = new loginAction();
		
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
		 
		 
		 
		 public int getCurrentPageRecord() {
			 WebElement currentPageRecords = driver.findElement(By.xpath(currentPageRecord));
			 String[] currentPage = currentPageRecords.getText().split(" ");
			 int currentPageRecord = Integer.parseInt(currentPage[1]);
			 return currentPageRecord;			 
			 }
		 
		
		 public int getTotalPagesDisplayed() {
			  List<WebElement> totalNumOfPagesDisplayed = driver.findElements(By.xpath(totalPagesDisplayed));
			 int totalPagesDisplayed= totalNumOfPagesDisplayed.size();
			 return totalPagesDisplayed;
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
		
		 public List<WebElement> getEditStatusMsg() {
			  List<WebElement> editButtons = driver.findElements(By.xpath(editStatusMsg));
			  return editButtons;
			 }
		 public List<WebElement> getRestoreContractMsg() {
			  List<WebElement> restoreContractMessage = driver.findElements(By.xpath(restoreContractMsg));
			  return restoreContractMessage;
			 }
		 
		 
		 
		 public void getGridArrowBtn(String name) {
			 List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
			  List<WebElement> gridArrowBtns = driver.findElements(By.cssSelector(gridArrowBttn));
			  for (int i = 0; i <= allHeaderNames.size()-1; i++) {
				  if(allHeaderNames.get(i).equals(name))
				  {
						gridArrowBtns.get(i+1).click();
					}
			}
			 }
		 
			public HashMap<Integer, HashMap<String, String>> checkGridBodyDetails() {
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
			
			
			
			 public void verifyRestoreMsgFromRestoreIcon() {
				 HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
				 Actions action = new Actions(driver);
				 if(allTableData.size() > 0) {
					for (int i = 1; i <= allTableData.size(); i++) {
							HashMap<String, String> getRowData = allTableData.get(i);
							String value = getRowData.get("Status");
					if(value.contains("DELETED"))
							{
								action.moveToElement(getRestoreBtns().get(i)).perform();
								Assert.assertTrue(getRestoreContractMsg().get(1).isDisplayed());
							}
							break;
						}
			 }
			 }
}


