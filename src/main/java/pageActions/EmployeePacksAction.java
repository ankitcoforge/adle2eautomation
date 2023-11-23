package pageActions;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.EmployeePackspo;
import pageObjects.impersonatepo;
import utils.CalenderUtils;
import utils.Randomizer;
import utils.utilityClass;

public class EmployeePacksAction extends EmployeePackspo{
	
	utilityClass utils= new utilityClass();
	   Randomizer randomizer=new Randomizer();
	   createContractAction co = new createContractAction();
	   impersonatepo io = new impersonatepo();
	   CalenderUtils calenderUtils= new CalenderUtils();
	
	 public WebElement getPortalTitle() {
		 WebElement welcomeTitle=driver.findElement(By.xpath(portalTitle));	
		 return welcomeTitle;
	 }

	 public WebElement getDealerPacksPageTitle() {
		 WebElement welcomeTitle=driver.findElement(By.xpath(dealerPackstitle));	
		 return welcomeTitle;
	 }
	 
	 public WebElement getBtnClose() {
			WebElement ele = driver.findElement(By.xpath(close));
			return ele;
		}

	 public WebElement getBtnNewPack() {
		 WebElement newPack=driver.findElement(By.xpath(btnNewPack));	
		 return newPack;
	 }
	 
	 public WebElement getnewPackPopup() {
		 WebElement newPack=driver.findElement(By.id(newPackPopup));	
		 return newPack;
	 }
	 
	 public WebElement getBtnCloseForPopup() {
		 WebElement close=driver.findElement(By.xpath(btnCloseForPopup));	
		 return close;
	 }
	 
	 public WebElement getPackAmount() {
		 WebElement packAmountTxtfld=driver.findElement(By.xpath(packAmount));	
		 return packAmountTxtfld;
	 }
	 
	 public void selectProgram() throws InterruptedException {
		 Thread.sleep(10000);
			 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
			 list.get(0).click();
		}
	 
	 public void selectDealerName(String dealer) throws InterruptedException {
		 Thread.sleep(10000);
		 utils.clickfield("xpath", selectDealerNamearrow);
		 List<WebElement> list = getDriver().findElements(By.xpath(selectDealerNameDropdownList));
		 
	    for(int i=0;i<list.size();i++) {
		String text = list.get(i).getText();
		System.out.println("Progms list is--"+text);
		if(text.equals(dealer))
		{
			list.get(i).click();
			break;
		}
	 }
	    Thread.sleep(2000);

}
	 
	 public void selectProgramNew(String program) throws InterruptedException {
		 Thread.sleep(10000);
		 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		 
	    for(int i=0;i<list.size();i++) {
		String text = list.get(i).getText();
		System.out.println("Progms list is--"+text);
		if(text.contains(program))
		{
			list.get(i).click();
			break;
		}
	 }
	 }

	 
	 
	 public WebElement getBtnSave() {
		 WebElement save=driver.findElement(By.xpath(btnSave));	
		 return save;
	 }
	 
	 public WebElement getSuccessMsg() {
		 WebElement msg=driver.findElement(By.xpath(ConfirmationMsg));	
		 return msg;
	 }
	 
	 public List<WebElement> getRows() {
		  List<WebElement> rows = driver.findElements(By.cssSelector(rowLoc));	
		 return rows; 
	 }
	 
	 public WebElement getNoRecordsInGrid() {
		  WebElement rows = driver.findElement(By.cssSelector(noRecordsInGrid));	
		 return rows; 
	 }
	 
	 public int getCurrentPageRecord() throws InterruptedException {
		 //driver.navigate().refresh();
		 Thread.sleep(5000);
		 WebElement currentPageRecords = driver.findElement(By.xpath(currentPageRecord));
		 String[] currentPage = currentPageRecords.getText().split(" ");
		 int currentPageRecord = Integer.parseInt(currentPage[1]);
		 return currentPageRecord;			 
		 }
	 
	 
	 public HashMap<Integer, HashMap<String, WebElement>> checkGridBodyDetails() {
			List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
			System.out.println("allHeaderNames: " + allHeaderNames);
			HashMap<Integer, HashMap<String, WebElement>> allTableData = new HashMap<Integer, HashMap<String, WebElement>>();
			// Get total rows count
			List<WebElement> allRows = utils.getElementsList("cssSelector", rowLoc);
			System.out.println("No of rows in grid: " + allRows.size());
			for (int i = 1; i <= allRows.size(); i++) {
				// Getting specific row with each iteration
				String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
				LinkedHashMap<String, WebElement> eachRowData = new LinkedHashMap<>();
				for (int j = 1; j <= allHeaderNames.size(); j++) {
					String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div";
					WebElement cellValue = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
					eachRowData.put(allHeaderNames.get(j-1), cellValue);
				}
				allTableData.put(i, eachRowData);
			}
			System.out.println("Complete Grid data: " + allTableData);
			utils.scrollUp();
			return allTableData;
			}
		
	 
	 public HashMap<Integer, HashMap<String,String >> checkGridBodyDetailsTxt() {
			List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
			System.out.println("allHeaderNames: " + allHeaderNames);
			HashMap<Integer, HashMap<String, String>> allTableData = new HashMap<Integer, HashMap<String, String>>();
			// Get total rows count
			List<WebElement> allRows = utils.getElementsList("cssSelector", rowLoc);
			System.out.println("No of rows in grid: " + allRows.size());
			for (int i = 1; i <= allRows.size(); i++) {
				// Getting specific row with each iteration
				String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
				LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
				for (int j = 2; j <= 8; j++) {
					String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>span:nth-of-type(2)";
					 String cellValue = utils.text("cssSelector", specificRowLoc + ">" + specificRowColLoc);
					eachRowData.put(allHeaderNames.get(j-1), cellValue);
				}
				allTableData.put(i, eachRowData);
			}
			System.out.println("Complete Grid data: " + allTableData);
			utils.scrollUp();
		    return allTableData;
		}
	 
	 public HashMap<Integer, HashMap<String,String >> checkGridBodyDetailsTxt2() {
			List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
			System.out.println("allHeaderNames: " + allHeaderNames);
			HashMap<Integer, HashMap<String, String>> allTableData = new HashMap<Integer, HashMap<String, String>>();
			// Get total rows count
			List<WebElement> allRows = utils.getElementsList("cssSelector", rowLoc);
			System.out.println("No of rows in grid: " + allRows.size());
			for (int i = 1; i <= allRows.size(); i++) {
				// Getting specific row with each iteration
				String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
				LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
				for (int j = 2; j <= 7; j++) {
					String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>span:nth-of-type(2)";
					 String cellValue = utils.text("cssSelector", specificRowLoc + ">" + specificRowColLoc);
					eachRowData.put(allHeaderNames.get(j-1), cellValue);
				}
				allTableData.put(i, eachRowData);
			}
			System.out.println("Complete Grid data: " + allTableData);
			utils.scrollUp();
		    return allTableData;
		}
	 
	 
	 public HashMap<String, WebElement> getSearchBoxesInGrid() {
			utils.scrollDown();
			HashMap<String, WebElement> map = new HashMap<String, WebElement>();
			List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
			List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(searchBoxesBelowHeadersInGrid));
			for (int j = 0; j < 5 ; j++) {
				map.put(allHeaderNames.get(j + 1), searchBoxesInGrid.get(j));
			}
			return map;
		}
	 
	 public HashMap<String, WebElement> getSearchBoxesFromPackAmount() {
			utils.scrollDown();
			HashMap<String, WebElement> map = new HashMap<String, WebElement>();
			List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
			List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(searchBoxesBelowHeadersInGrid));
			for (int j = 0; j < 3 ; j++) {
				System.out.println(allHeaderNames.get(j));
				System.out.println(searchBoxesInGrid.get(j));
				map.put(allHeaderNames.get(j+4), searchBoxesInGrid.get(j+2));
			}
			return map;
		}
	 
	 public  List<WebElement> getSelectCheckBoxes() {
	     List<WebElement> select = driver.findElements(By.cssSelector(selectCheckBox));
		return select;	
	 }
	 
	 
	 public WebElement getDeleteLink() {
		 WebElement delete=driver.findElement(By.xpath(deleteLink));	
		 return delete;
	 }
	 
	 public WebElement getBtnYes() {
			WebElement rows = driver.findElement(By.xpath(btnYes));	
			 return rows; 
		 }
	 
	 public WebElement getDeletedConfirmationMsg() {
		 WebElement delete=driver.findElement(By.xpath(deleteConfirmationMsg));	
		 return delete;
	 }
	 
	 public WebElement getPopup() {
		 WebElement popupp=driver.findElement(By.cssSelector(popup));	
		 return popupp;
	 }
	 
	 public WebElement getArrow() {
		 WebElement arrow1=driver.findElement(By.xpath(packArrow));	
		 return arrow1;
	 }
	 
//	 public void impersonateFromAgentLogin() {
//		 HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
//		 HashMap<Integer, HashMap<String, WebElement>> allTableData = checkGridBodyDetails();
//		 HashMap<Integer, HashMap<String, WebElement>> tableDataForEditDelLock = checkGridForEditDelLock();
//		 for(int i=1;i<getRows().size();i++) {
//		 if(allTableDataTxt.get(i).get("Role Type").equalsIgnoreCase("Dealer")) {
//			 tableDataForEditDelLock.get(i).get("Impersonate").click();
//			 break;
//		 //utils.clickfield("xpath", io.tableFirstRow);
//		 }
//		 }
//		 
//	 }
	 
	 public Integer getVehiclePriceForLender(String vehicleProgram) throws ParseException {
	 utils.inputfield("cssSelector", textbox, "Single", 0);
	 utils.inputfield("cssSelector", textbox, "Test", 1);
	 utils.inputfield("cssSelector", textbox, "100", 4);
	 utils.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 5);
	 utils.clickfield("xpath", getProducts);
	 co.programSelect(vehicleProgram);
	 String txt = utils.text("cssSelector", table, 0);
	 NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(txt);
		String packAmount = number.toString();
	 Integer txtInInteger= Integer.parseInt(packAmount);
	 return txtInInteger;
	 }
	 
	 public Integer getVehiclePrice(String vehicleProgram) throws ParseException {
		 utils.inputfield("cssSelector", textbox, "Single", 0);
		 //utils.getfield("cssSelector", "textbox").clear();
		 utils.inputfield("cssSelector", textbox, "Test", 1);
		 utils.inputfield("cssSelector", textbox, randomizer.getMilage(), 5);
		 utils.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
		 utils.clickfield("xpath", getProducts);
		 co.programSelect(vehicleProgram);
		 String txt = utils.text("cssSelector", table, 0);
		 NumberFormat format = NumberFormat.getCurrencyInstance();
			Number number = format.parse(txt);
			String packAmount = number.toString();
		 Integer txtInInteger= Integer.parseInt(packAmount);
		 return txtInInteger;
		 }
	 
	 public void createNewPack(String program,String packAmount) throws InterruptedException {
	 getBtnNewPack().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(getPopup()));
	    getArrow().click();
		selectProgramNew(program);
		utils.scrollDown();
		getPackAmount().sendKeys(packAmount);
		getBtnSave().click();
		Thread.sleep(5000);
	 }
	 
	 public void createNewPackFutureDate(String program,String packAmount,int days) throws Exception {
		 getBtnNewPack().click();
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(getPopup()));
		    getArrow().click();
			selectProgramNew(program);
			utils.scrollDown();
			getPackAmount().sendKeys(packAmount);
			utils.clickfield("xpath", calenderUtils.calenderInPopup);
			String selectedDate = calenderUtils.getCurrentDate(days,"MMM/dd/yyyy");
			System.out.println("Selected Date-"+selectedDate);
			calenderUtils.selectDate(selectedDate,"MMM/dd/yyyy");
			getBtnSave().click();
			Thread.sleep(5000);
		 }
	 
	 public void editPack(String program,String packAmount) throws InterruptedException {
     Thread.sleep(2000);
     getPackAmount().clear();
		getPackAmount().sendKeys(packAmount);
		getBtnSave().click();
		Thread.sleep(3000);
	 }
	 public HashMap<Integer, HashMap<String, WebElement>> checkGridForEditDelLock() {
			List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
			System.out.println("allHeaderNames: " + allHeaderNames);
			HashMap<Integer, HashMap<String, WebElement>> allTableData = new HashMap<Integer, HashMap<String, WebElement>>();
			// Get total rows count
			List<WebElement> allRows = utils.getElementsList("cssSelector", rowLoc);
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
	
	 
	 public WebElement getTitle(String heading) {
		 WebElement welcomeTitle=utils.getfield("h3", heading);
		 return welcomeTitle;
	 }
}
