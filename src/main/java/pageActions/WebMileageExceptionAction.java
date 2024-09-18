package pageActions;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.WebMileageExceptionpo;
import pageObjects.impersonatepo;
import utils.CalenderUtils;
import utils.Randomizer;
import utils.utilityClass;

public class WebMileageExceptionAction extends WebMileageExceptionpo{

	utilityClass utils= new utilityClass();
	   Randomizer randomizer=new Randomizer();
	   createContractAction co = new createContractAction();
	   impersonatepo io = new impersonatepo();
	   ManageVSC_GAPpreferencesAction manageVSCGAP = new ManageVSC_GAPpreferencesAction();
	   CalenderUtils calenderUtils= new CalenderUtils();
	
	 public WebElement getPortalTitle() {
		// manageVSCGAP.getBtnClose().click();
		 WebElement welcomeTitle=driver.findElement(By.xpath(portalTitle));	
		 return welcomeTitle;
	 }
	 
	 public  List<WebElement> getroledropdwns() {
		  List<WebElement> dropdwn = driver.findElements(By.xpath(roleDropdown));	
		 return dropdwn;
	 }
	 
	 public List<WebElement> getRoleIdTextBox() {
		 List<WebElement> roleID=driver.findElements(By.xpath(roleIdTextBox));	
		 return roleID;
	 }
	 
	 public  List<WebElement> getRoleId()
	 {
		 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		 return list;
	 }
	 
	 public void enterRoleAndRoleID(String role,String roleid) throws InterruptedException {
		 Thread.sleep(2000);
		    getroledropdwns().get(0).click();
			 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
			 for(int i=0;i<list.size();i++) {
				String text = list.get(i).getText();
				 
				if(text.contains(role))
				{
					list.get(i).click();
					break;
				}
			 }
			 Thread.sleep(2000);
				
			 getRoleIdInputFld().clear();
			 getRoleIdInputFld().sendKeys(roleid);
				 getroledropdwns().get(1).click();
				 List<WebElement> list2 = getDriver().findElements(By.xpath(roleDropdownList));
				 
				 for(int j=0;j<list2.size();j++) {
					String text2 = list2.get(j).getText();
					 
					if(text2.contains(roleid))
					{
						list2.get(j).click();
						break;
					}			 
					}
			 Thread.sleep(2000);
			 utils.clickfield("xpath", arrowbtn);
			Thread.sleep(5000);

		}
	 
	 public WebElement getNoRecordsInGrid() {
		  WebElement rows = driver.findElement(By.cssSelector(noRecordsInGrid));	
		 return rows; 
	 }
	 
	 public  List<WebElement> getRows() {
		   List<WebElement> rows = driver.findElements(By.cssSelector(rowLoc));	
		 return rows; 
	 }
	 
//	 public HashMap<Integer, HashMap<String, WebElement>> getElementsFromGridBody() {
//			List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
//			HashMap<Integer, HashMap<String, WebElement>> allTableData = new HashMap<Integer, HashMap<String, WebElement>>();
//			List<WebElement> allRowsEle = utils.getElementsList("cssSelector", rowLoc);
//			for (int i = 1; i <= allRowsEle.size(); i++) {
//				if (i == 10)
//					utils.scrollDown();
//				String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
//				LinkedHashMap<String, WebElement> eachRowData = new LinkedHashMap<>();
//				for (int j = 2; j <= allHeaderNames.size(); j++) {
//					String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>span:nth-of-type(2)";
//					WebElement cellValue = null;
//					cellValue = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
//					eachRowData.put(allHeaderNames.get(j - 1), cellValue);
//				}
//				allTableData.put(i, eachRowData);
//			}
//			System.out.println("Complete Grid data: " + allTableData);
//			utils.scrollUp();
//			return allTableData;
//		}	 
public HashMap<String, WebElement> getSearchBoxesInGrid() throws InterruptedException {
			utils.scrollDown();
			HashMap<String, WebElement> map = new HashMap<String, WebElement>();
			List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
			List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(searchBoxesBelowHeadersInGrid));
			for (int j = 0; j < 8 ; j++) {
				map.put(allHeaderNames.get(j + 1), searchBoxesInGrid.get(j));
			}
			return map;
		}

public HashMap<String, WebElement> getSearchBoxesForModifiedBy() throws InterruptedException {
	utils.scrollDown();
	HashMap<String, WebElement> map = new HashMap<String, WebElement>();
	List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
	List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(searchBoxesBelowHeadersInGrid));
		map.put(allHeaderNames.get(10), searchBoxesInGrid.get(8));
	return map;
}
//		
		 public List<String> getRowLoc() {
			 List<String> rowLoactor = utils.getTextValuesForObject("cssSelector", rowLoc);
	         return rowLoactor;
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
				for (int j = 2; j <= 11; j++) {
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
		
	 public HashMap<String, WebElement> getSearchBoxesFromPackAmount() throws InterruptedException {
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
	 
	 public WebElement getEditBtn(int row) throws InterruptedException {
			String specificRowLoc = "table>tbody>tr:nth-of-type(" + row + ")";
			String specificRowColLoc = "td:nth-of-type(12)>adl-table-cells>div";
			WebElement  element = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
	return element;
	}
	 
	 public WebElement getRoleAndProgramCode(String role) throws InterruptedException {
		 String loc = "//div[contains(text(),'" + role + "')]";
		 WebElement  element = utils.element("xpath", loc);
			return element;
	 }
	 
	 public List<WebElement> getMileageAndAgeFeilds() {
		  List<WebElement> elemnts = driver.findElements(By.xpath(mileageAndAge));	
		 return elemnts; 
	 }
	 
	 public WebElement getBtnSave() {
		 WebElement btn=driver.findElement(By.xpath(saveBtn));	
		 return btn;
	 }
	 
	 public WebElement getRoleIdInEditPopup() {
		 WebElement ele=driver.findElement(By.xpath(roleIdInEdidPopup));	
		 return ele;
	 }
	 
	 public WebElement getRoleTypeInPopup() {
		 WebElement ele=driver.findElement(By.xpath(roleType));	
		 return ele;
	 }
	 
	 public WebElement getProgramcodeInPopup() {
		 WebElement ele=driver.findElement(By.xpath(programCode));	
		 return ele;
	 }
	 
	 public WebElement getBtnCancel() {
		 WebElement btn=driver.findElement(By.xpath(cancelBtn));	
		 return btn;
	 }
	 
	 public WebElement getIconClose() {
		  WebElement iconCloseBtn = driver.findElement(By.xpath(iconClose));
		  return iconCloseBtn;
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
	 
	 public WebElement getNewExceptionBtn() {
		    WebElement btn = driver.findElement(By.xpath(newExceptionBtn));
			return btn;	
	 }
	 
	 public WebElement getArrow() {
		 WebElement arrow1=driver.findElement(By.xpath(packArrow));	
		 return arrow1;
	 }
	 
	 public WebElement getRoleIdInputFld() {
		 WebElement ele=driver.findElement(By.xpath(roleIdInputFld));	
		 return ele;
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
	 
	 public void createNewException(String program) throws InterruptedException {
		 getNewExceptionBtn().click();
			Thread.sleep(5000);
		    getArrow().click();
		    Thread.sleep(5000);
			selectProgramNew(program);
			utils.scrollDown();
			getMileageAndAgeFeilds().get(0).clear();
			getMileageAndAgeFeilds().get(0).sendKeys("100");
			getMileageAndAgeFeilds().get(1).clear();
			getMileageAndAgeFeilds().get(1).sendKeys("1000");
			getMileageAndAgeFeilds().get(2).clear();
			getMileageAndAgeFeilds().get(2).sendKeys("1");
			getMileageAndAgeFeilds().get(3).clear();
			getMileageAndAgeFeilds().get(3).sendKeys("12");
			getBtnSave().click();
			Thread.sleep(2000);
		 }
	 
	 public String createNewExceptionWithDate(String program,int days) throws Exception {
		 getNewExceptionBtn().click();
			Thread.sleep(5000);
		    getArrow().click();
			selectProgramNew(program);
			utils.scrollDown();
			getMileageAndAgeFeilds().get(0).clear();
			getMileageAndAgeFeilds().get(0).sendKeys("100");
			getMileageAndAgeFeilds().get(1).clear();
			getMileageAndAgeFeilds().get(1).sendKeys("1000");
			getMileageAndAgeFeilds().get(2).clear();
			getMileageAndAgeFeilds().get(2).sendKeys("1");
			getMileageAndAgeFeilds().get(3).clear();
			getMileageAndAgeFeilds().get(3).sendKeys("12");
			utils.clickfield("xpath", calenderUtils.calenderInPopup);
			String selectedDate = calenderUtils.getCurrentDate(days,"MMM/dd/yyyy");
			System.out.println("Selected Date-"+selectedDate);
			calenderUtils.selectDate(selectedDate,"MMM/dd/yyyy");
			getBtnSave().click();
			Thread.sleep(2000);
			return selectedDate;
		 }
	 
	 
	 
	 public void selectProgramAndentertMileage(String program,String From,String To) throws InterruptedException {
			Thread.sleep(5000);
		    getArrow().click();
			selectProgramNew(program);
			utils.scrollDown();
			getMileageAndAgeFeilds().get(0).clear();
			getMileageAndAgeFeilds().get(0).sendKeys(From);
			getMileageAndAgeFeilds().get(1).clear();
			getMileageAndAgeFeilds().get(1).sendKeys(To);
	 }
	 
	 public void entertAge(String From,String To) throws InterruptedException {
			getMileageAndAgeFeilds().get(2).clear();
			getMileageAndAgeFeilds().get(2).sendKeys(From);
			getMileageAndAgeFeilds().get(3).clear();
			getMileageAndAgeFeilds().get(3).sendKeys(To);
	 }
		 
		 public void editException(String program) throws InterruptedException {
	     Thread.sleep(2000);
	        getMileageAndAgeFeilds().get(0).clear();
			getMileageAndAgeFeilds().get(0).sendKeys("100");
			getMileageAndAgeFeilds().get(1).clear();
			getMileageAndAgeFeilds().get(1).sendKeys("1000");
			getMileageAndAgeFeilds().get(2).clear();
			getMileageAndAgeFeilds().get(2).sendKeys("1");
			getMileageAndAgeFeilds().get(3).clear();
			getMileageAndAgeFeilds().get(3).sendKeys("12");
			getBtnSave().click();
			Thread.sleep(2000);
		 }
		
		 public void getProducts(String VIN, String Mileage) throws ParseException, InterruptedException {
			 utils.inputfield("cssSelector", textbox, "Single", 0);
			 utils.inputfield("cssSelector", textbox, "Test", 1);
			 utils.inputfield("cssSelector", textbox, Mileage, 5);
			 utils.inputfield("cssSelector", textbox, VIN, 6);
			 utils.clickfield("xpath", getProducts);
			 Thread.sleep(10000);
			 }
		 
		 public void getProductsForLender(String VIN, String Mileage) throws ParseException {
			 utils.inputfield("cssSelector", textbox, "Single", 0);
			 utils.inputfield("cssSelector", textbox, "Test", 1);
			 utils.inputfield("cssSelector", textbox, Mileage, 4);
			 utils.inputfield("cssSelector", textbox, VIN, 5);
			 utils.clickfield("xpath", getProducts);
			 }
		 
		 
		 public void getPrograms(String program) throws ParseException {
			 List<WebElement> list = getDriver().findElements(By.xpath(programInContractPage));
			 for(int i=0;i<list.size();i++) {
				 System.out.println("list is--"+list.get(i).getText());
					 Assert.assertTrue(list.get(i).getText().contains(program));
					 break;
				 }
		 }
	 
		 public WebElement getGridArrowBtn(String name) {
			 List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
			  List<WebElement> gridArrowBtns = driver.findElements(By.cssSelector(gridArrowBttn));
			  WebElement arrowbtn=null;
			  System.out.println("headers size-"+allHeaderNames.size());
			  for (int i = 1; i <= allHeaderNames.size()-1; i++) {
				  if(allHeaderNames.get(i).contains(name))
				  {
						arrowbtn=gridArrowBtns.get(i-1);
					}
			}
			  return arrowbtn;
			 }

	
}
