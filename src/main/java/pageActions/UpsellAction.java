package pageActions;

import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.UpsellPo;
import utils.utilityClass;

public class UpsellAction extends UpsellPo{
	utilityClass utils = new utilityClass();
	EmployeePacksAction EmplPacks = new EmployeePacksAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();

	 public WebElement getPortalTitle() {
			 WebElement welcomeTitle=driver.findElement(By.xpath(portalTitle));	
			 return welcomeTitle;
		 }
	 
	 public WebElement getWarningLabel() {
		 WebElement errorMsg=driver.findElement(By.xpath(warningLabel));	
		 return errorMsg;
	 }
	 
	 public WebElement getProgramTable() {
		 WebElement ele=driver.findElement(By.cssSelector(programTable));	
		 return ele;
	 }
	 
	 public WebElement getProgramTableNew() {
		 WebElement ele=driver.findElement(By.xpath(programTableNew));	
		 return ele;
	 }
	 
	 public WebElement getUpsellProgramTable() {
		 WebElement ele=driver.findElement(By.xpath(upsellProgramTable));	
		 return ele;
	 }
	 
	 public void createContract() throws ParseException, InterruptedException {
//		 utils.inputfield("cssSelector", textbox, "Single", 0);
//		 utils.inputfield("cssSelector", textbox, "Test", 1);
		 verticalMenu.navigatetoContract();
		 Thread.sleep(2000);
		 utils.inputfield("cssSelector", textbox, "1000", 5);
		 utils.inputfield("cssSelector", textbox, "KNDRMDLH1N5063803", 6);
		 utils.clickfield("xpath", getProducts);
		 Thread.sleep(2000);
	 }
	 
		public HashMap<Integer, HashMap<String, WebElement>> getElementsFromGridBody() {
			List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
			HashMap<Integer, HashMap<String, WebElement>> allTableData = new HashMap<Integer, HashMap<String, WebElement>>();
			List<WebElement> allRowsEle = utils.getElementsList("cssSelector", rowLoc);
			for (int i = 1; i <= allRowsEle.size(); i++) {
				if (i == 10)
					utils.scrollDown();
				String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
				LinkedHashMap<String, WebElement> eachRowData = new LinkedHashMap<>();
				for (int j = 2; j <= allHeaderNames.size()-2; j++) {
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
		
		public HashMap<Integer, HashMap<String, WebElement>> getDataCreatedBy() {
			List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
			HashMap<Integer, HashMap<String, WebElement>> allTableData = new HashMap<Integer, HashMap<String, WebElement>>();
			List<WebElement> allRowsEle = utils.getElementsList("cssSelector", rowLoc);
			for (int i = 1; i <= allRowsEle.size(); i++) {
				if (i == 10)
					utils.scrollDown();
				String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
				LinkedHashMap<String, WebElement> eachRowData = new LinkedHashMap<>();
					String specificRowColLoc = "td:nth-of-type(5)>adl-table-cells>div>span:nth-of-type(2)";
					WebElement cellValue = null;
					cellValue = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
					eachRowData.put(allHeaderNames.get(4), cellValue);
				allTableData.put(i, eachRowData);
			}
			utils.scrollUp();
			return allTableData;
		}
		
		 
		 public HashMap<String, WebElement> getSearchBoxesInGrid() {
				utils.scrollDown();
				HashMap<String, WebElement> map = new HashMap<String, WebElement>();
				List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
				List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(searchBoxesBelowHeadersInGrid));
				for (int j = 0; j <= searchBoxesInGrid.size()-1 ; j++) {
					map.put(allHeaderNames.get(j + 1), searchBoxesInGrid.get(j));
				}
				return map;
			}

		 
		 public void createProgram(String program,String upsellProgram) throws InterruptedException {
		 utils.getfield("span", "+ New program").click();
			Thread.sleep(3000);
			utils.clickfield("xpath", programArrow);
			EmplPacks.selectProgramNew(program);
			Thread.sleep(2000);
			utils.clickfield("xpath", upsellProgramArrow);
			EmplPacks.selectProgramNew(upsellProgram);
			utils.getfield("span", " Save ").click();
			Thread.sleep(2000);
			Assert.assertTrue(utils.getTitle("Upsell Exceptions").isDisplayed());
		 }
		 
		 public void validatePDF() throws InterruptedException {
		 HashSet<String> b = new HashSet<>();
			b = isFileDownloaded( System.getProperty("user.dir") + "\\PDF", ".pdf");
			utils.getfield("button", "Export pdf").click();
			Thread.sleep(3000);
			HashSet<String> a1 = new HashSet<>();
			a1 = isFileDownloaded( System.getProperty("user.dir") + "\\PDF", ".pdf");
			a1.removeAll(b);
			String pdfUrl = "file:///" +  System.getProperty("user.dir") + "\\PDF\\" + a1.toString().replaceAll("\\,|\\[|\\]|\\s", "");
			String pdfUrl1 = pdfUrl.replace("\\", "/");
			System.out.println("URL ISSS----"+pdfUrl1);
			verifyContentInPDf(pdfUrl1, "Upsell Program");
			Assert.assertTrue(pdfUrl1.contains("PDF"));
			b.addAll(a1);
		 }
		 
		 public void validateXlsx() throws InterruptedException {
			 HashSet<String> b = new HashSet<>();
				b = isFileDownloaded( System.getProperty("user.dir") + "\\PDF", ".pdf");
				utils.getfield("button", "Export xls").click();
				Thread.sleep(3000);
				HashSet<String> a1 = new HashSet<>();
				a1 = isFileDownloaded( System.getProperty("user.dir") + "\\PDF", ".pdf");
				a1.removeAll(b);
				String xlsxUrl = "file:///" +  System.getProperty("user.dir") + "\\PDF\\" + a1.toString().replaceAll("\\,|\\[|\\]|\\s", "");
				String xlsxUrl1 = xlsxUrl.replace("\\", "/");
				System.out.println("URL ISSS----"+xlsxUrl1);
				verifyContentInPDf(xlsxUrl1, "Upsell Program");
				Assert.assertTrue(xlsxUrl1.contains("xlsx"));
				b.addAll(a1);
			 }
		 
		 
		 public WebElement getEditBtn(int row) {
       					String specificRowLoc = "table>tbody>tr:nth-of-type(" + row + ")";
							String specificRowColLoc = "td:nth-of-type(6)>adl-table-cells>div";
							WebElement  element = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
				return element;
				}
	 
}
