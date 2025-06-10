package pageActions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import pageObjects.RemitAULpo;
import utils.utilityClass;

public class RemitAULAction extends RemitAULpo{
	
	utilityClass utils= new utilityClass();
	singleContractAction contract =new singleContractAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	EditContractAction contractPage =new EditContractAction();
	
	
	public WebElement getTitle() {
		 WebElement welcomeTitle=driver.findElement(By.xpath(ADLwelcometitle));	
		 return welcomeTitle;
	 }
	
	public void createContract() throws InterruptedException {
			verticalMenu.navigatetoContract();
			contract.singleContract();
			Thread.sleep(2000);
			verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to AUL");
			Thread.sleep(2000);
			verticalMenu.navigatetoContract();
			Thread.sleep(1000);
			contract.singleContract("Bank of America");
			Thread.sleep(2000);
//			verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to AUL");
//			Thread.sleep(2000);
//			verticalMenu.navigatetoContract();
//			Thread.sleep(1000);
//			contract.singleContract();
//			Thread.sleep(2000);
		}
	
	public void getRemitContracts() throws InterruptedException {
		getSelectAllCheckBox().click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i <= 3; i++) {
			if (getSelectStatusCheckBoxInGrid(i).isSelected()) {
				js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(i));
			}
		}
		Thread.sleep(1000);
		String remitPage = driver.getWindowHandle();
		utils.clickfield("xpath", remitcontracts);
		utils.clickfield("xpath", yesBtn);
		Thread.sleep(3000);
		driver.switchTo().window(remitPage);
	}
	
	public void selectACheckBox() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", getUnselectedCheckBox());
		js.executeScript("arguments[0].click();", getUnselectedCheckBox());
	}
	
	 public WebElement getNoRecordsInGrid() {
		  WebElement rows = driver.findElement(By.cssSelector(noRecordsInGrid));	
		 return rows; 
	 }
	
	 public WebElement getRemitContractsTitle() {
		 WebElement title=driver.findElement(By.xpath(remitContractsTitle));	
		 return title;
	 }
	 
	 public WebElement getSelectContractsTab() {
		 WebElement selectContracts=driver.findElement(By.xpath(selectContractsTab));	
		 return selectContracts;
	 }
	 
	 public WebElement getSelectContractByDefault() {
		 WebElement selectContracts=driver.findElement(By.xpath(selectContractByDefault));	
		 return selectContracts;
	 }
	 
	 public WebElement getCheckDetailsTab() {
		 WebElement checkDetails=driver.findElement(By.xpath(checkDetailsTab));	
		 return checkDetails;
	 }
	 
	 public WebElement getCheckDetailsTabStatus() {
		 WebElement checkDetailsTab=driver.findElement(By.xpath(checkDetailsTabStatus));	
		 return checkDetailsTab;
	 }
	 
	 public WebElement getPaymentDetailsTab() {
		 WebElement paymentDetails=driver.findElement(By.xpath(paymentDetailsTab));	
		 return paymentDetails;
	 }
	 
	 public WebElement getPaymentDetailsTabStatus() {
		 WebElement paymentDetails=driver.findElement(By.xpath(paymentDetailsTabStatus));	
		 return paymentDetails;
	 }
	 
	 public WebElement getSelectTheContractsTxt() {
		 WebElement selectTheContracts=driver.findElement(By.xpath(selectTheContractsTxt));	
		 return selectTheContracts;
	 }
	 
	 public List<String> getAllHeaderNames() {
		 List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
         return allHeaderNames;
	 }
	 
	 public List<String> getRowLoc() {
		 List<String> rowLoactor = utils.getTextValuesForObject("cssSelector", rowLoc);
         return rowLoactor;
	 }
	 
	 public WebElement getContractsGrid() {
		    WebElement contractRecordsInGrid = driver.findElement(By.xpath(contractsInGrid));
			return contractRecordsInGrid;	
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
				for (int j = 2; j <= allHeaderNames.size(); j++) {
					String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>span:nth-of-type(2)";
					WebElement cellValue = null;
					cellValue = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
					eachRowData.put(allHeaderNames.get(j - 1), cellValue);
				}
				allTableData.put(i, eachRowData);
			}
			System.out.println("Complete Grid data: " + allTableData);
			utils.scrollUp();
			return allTableData;
		}
		
		 public WebElement getGridArrowBtn(String name) {
			 List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
			  List<WebElement> gridArrowBtns = driver.findElements(By.cssSelector(gridArrowBttn));
			  WebElement arrowbtn=null;
			  for (int i = 0; i <= allHeaderNames.size()-1; i++) {
				  if(allHeaderNames.get(i).equals(name))
				  {
						arrowbtn=gridArrowBtns.get(i);
					}
			}
			  return arrowbtn;
			 }
		 
		 public HashMap<String, WebElement> getSearchBoxesInGrid() throws InterruptedException {
				utils.scrollDown();
				HashMap<String, WebElement> map = new HashMap<String, WebElement>();
				List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
				List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(searchBoxesBelowHeadersInGrid));
				for (int j = 0; j <= allHeaderNames.size() - 4 ; j++) {
					map.put(allHeaderNames.get(j + 1), searchBoxesInGrid.get(j));
				}
				return map;
			}
		 
		 public HashMap<String, WebElement> getSearchBoxesForAULandRetailPrice() throws InterruptedException {
				utils.scrollDown();
				HashMap<String, WebElement> map = new HashMap<String, WebElement>();
				List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
				List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(searchBoxesBelowHeadersInGrid));
				for (int j = 1; j <= allHeaderNames.size() - 9 ; j++) {
					System.out.println(allHeaderNames.get(j));
					System.out.println(searchBoxesInGrid.get(j));
					map.put(allHeaderNames.get(j+8), searchBoxesInGrid.get(j+6));
				}
				return map;
			}
		
		 public WebElement getHeaderInTheGrid(String name) {
			 String header = "//thead/adl-table-header/tr[1]/th/span[contains(text(),'" + name + "')]";
			 WebElement headerInGrid = driver.findElement(By.xpath(header));
			 return headerInGrid;
			 }
	 
	 public WebElement getSelectStatusCheckBoxInGrid(int row) throws InterruptedException {
			utils.scrollDown();
			String specificRowLoc = "table>tbody>tr:nth-of-type(" + row + ")";
			String specificRowColLoc = "td:nth-of-type(1)>adl-table-cells>div>mat-checkbox>label>div>input";
			WebElement statusCheckBox = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
			return statusCheckBox;
		}
	 
	 public WebElement getUnselectedCheckBox() {
		    WebElement checkBox = driver.findElement(By.cssSelector(unselectedCheckBox));
			return checkBox;	
	 }
	 
	 public int getCurrentPageRecordCount() {
		 WebElement currentPageRecords = driver.findElement(By.xpath(currentPageRecord));
		 String[] currentPage = currentPageRecords.getText().split(" ");
		 int currentPageRecord = Integer.parseInt(currentPage[1]);
		 return currentPageRecord;			 
		 }
	 
	 public WebElement getCurrentPageRecord() {
		   WebElement currentPageRecords = driver.findElement(By.xpath(currentPageRecord));
		 return currentPageRecords;			 
	 }
	 
	 public WebElement getRowsPerPage() {
		    WebElement rowsPerPageTxt = driver.findElement(By.cssSelector(rowsPerPage));
			return rowsPerPageTxt;	
	 }
	 
	 public WebElement getRowsPerPageDropdownbtn() {
		    WebElement rowsPerPageDropdownBtn = driver.findElement(By.xpath(rowsPerPageDropdownbtn));
			return rowsPerPageDropdownBtn;	
	 }
	 
	 public List<WebElement> getRowsPerPageDropdownlist() {
		     List<WebElement> rowsPerPagelistInDropdown = driver.findElements(By.cssSelector(rowsPerPageDropdownlist));
			return rowsPerPagelistInDropdown;	
	 }
	 
	 public WebElement getRowsPerPageSelected() {
		    WebElement rowsPerPageTotalSelected = driver.findElement(By.cssSelector(rowsPerPageSelected));
			return rowsPerPageTotalSelected;	
	 }
	 
	 public WebElement getCalenderPopup() {
		    WebElement calender = driver.findElement(By.cssSelector(calenderPopup));
			return calender;	
	 }
	 
	 public WebElement getCalenderIcon() {
		    WebElement calender = driver.findElement(By.xpath(calenderIcon));
			return calender;	
	 }
	 
	 
	 
	 public WebElement getSelectAllCheckBox() {
		    WebElement selectAll = driver.findElement(By.cssSelector(selectAllCheckBox));
			return selectAll;	
	 }
	 
	 public  List<WebElement> getCheckBoxes() {
		     List<WebElement> select = driver.findElements(By.cssSelector(selectCheckBoxAttribute));
			return select;	
	 }
	 
	 public  List<WebElement> getSelectCheckBoxes() {
	     List<WebElement> select = driver.findElements(By.cssSelector(selectCheckBox));
		return select;	
	 }
		
		 public WebElement getPaymentDetailCheckBox() {
			    WebElement checkBox = driver.findElement(By.cssSelector(paymentDetailCheckBox));
				return checkBox;	
		 }
		 
		 public WebElement getPaymentDetailCheckBoxAttribute() {
			    WebElement checkBox = driver.findElement(By.cssSelector(paymentDetailCheckBoxAttribute));
				return checkBox;	
		 }
 
		 
		 public WebElement getSearchBoxInSelectContractsTab() {
			    WebElement searchBoxEle = driver.findElement(By.cssSelector(searchBox));
				return searchBoxEle;	
		 }

		 
		 public WebElement getPaymentDetailsChkBxTxt() {
			    WebElement chkBxTxt = driver.findElement(By.cssSelector(paymentDetailsChkBxTxt));
				return chkBxTxt;	
		 }
		 
		 
		 public WebElement getPaymentDetailsCommentsBox() {
			    WebElement comments = driver.findElement(By.cssSelector(paymentDetailsComments));
				return comments;	
		 }
	 
		 
		 public WebElement getCommentsTitleTxt() {
			    WebElement comments = driver.findElement(By.xpath(commentsTitleTxt));
				return comments;	
		 }
		 
		 
		 public WebElement getNoRecordsTxt() {
			    WebElement comments = driver.findElement(By.xpath(noRecordsTxt));
				return comments;	
		 }
		 
		 public WebElement getClearFiltersTxt() {
			    WebElement clearFilters = driver.findElement(By.xpath(clearFiltersTxt));
				return clearFilters;	
		 }
		 
		 public WebElement getTotalDueTxt() {
			    WebElement totalDue = driver.findElement(By.xpath(totalDueTxt));
				return totalDue;	
		 }
		 
		 public String getTotalDueValue() {
			      String totalDue = driver.findElement(By.xpath(totalDueValue)).getText();
				return totalDue;	
		 }
		 
		 public WebElement getCheckAmountTxt() {
			    WebElement checkAmount = driver.findElement(By.xpath(checkAmountTxt));
				return checkAmount;	
		 }
		 
		 public String getCheckAmountValue() {
			      String checkAmount = driver.findElement(By.xpath(checkAmountValue)).getText();
				return checkAmount;	
		 }
		 
		 
		 public WebElement getCheckAmountFieldInCheckdetailsTab() {
			 WebElement checkAmount = driver.findElement(By.cssSelector(checkAmountFieldInCheckdetailsTab));
			return checkAmount;	
	 }
		 public WebElement getCalenderPlaceholder() {
			 WebElement calender = driver.findElement(By.cssSelector(calenderPlaceholder));
			return calender;	
	 }
		 
		 public WebElement getMsgBox() {
			    WebElement checkAmount = driver.findElement(By.xpath(msgBox));
				return checkAmount;	
		 }
		 
}
