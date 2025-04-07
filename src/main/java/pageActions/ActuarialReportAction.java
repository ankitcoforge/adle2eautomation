package pageActions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.ActuarialReportPO;
import utils.utilityClass;

public class ActuarialReportAction extends ActuarialReportPO{
	
	utilityClass utils = new utilityClass();
	WebContractsByDealerAction webContractsByDealerAction=new WebContractsByDealerAction();
	
	 public WebElement getTimeframePlaceholder() {
		 WebElement timeframe=driver.findElement(By.xpath(timeframePlaceholder));	
		 return timeframe;
	 }

	 public WebElement getFromAndToField() {
		 WebElement fromAndTo=driver.findElement(By.cssSelector(fromAndToField));	
		 return fromAndTo;
	 }
	 
	 public WebElement getFromAndToFieldPositionedAfterTimeFrame() {
		 WebElement fromAndTo=driver.findElement(By.xpath(fromAndToFieldPositionedAfterTimeFrame));	
		 return fromAndTo;
	 }
	 
	 public List<String> getHeaders() {
			List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", webContractsByDealerAction.headerLoc);
			System.out.println("allHeaderNames: " + allHeaderNames);
			return allHeaderNames;
	 }
	 
	 public HashMap<Integer, HashMap<String, WebElement>> getElementsFromGridBody() throws InterruptedException {
			List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector",webContractsByDealerAction.headerLoc);
			HashMap<Integer, HashMap<String, WebElement>> allTableData = new HashMap<Integer, HashMap<String, WebElement>>();
			List<WebElement> allRowsEle = utils.getElementsList("cssSelector", webContractsByDealerAction.rowLoc);
			for (int i = 1; i <= allRowsEle.size()-1; i++) {
				if (i == 10) 	
					utils.scrollDown();
				String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
				LinkedHashMap<String, WebElement> eachRowData = new LinkedHashMap<>();
				for (int j = 1; j <= allHeaderNames.size(); j++) {
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
	 
	
	 public List<WebElement> getSingleCategoryNameForMultiplePrograms(String txt) {
		 String ele = "//adl-table-cells/div/span[text()='"+ txt +"']";
		  List<WebElement> fromAndTo = driver.findElements(By.xpath(ele));	
		 return fromAndTo;
	 }
	 
	 public int getSize() {
		 List<WebElement> allRowsEle = utils.getElementsList("cssSelector", webContractsByDealerAction.rowLoc);	
		 return allRowsEle.size();
	 }
	 
	 public WebElement getColumnNames(String txt) {
	String ele="//tr/th[text()='"+txt+"']";
	 WebElement coloumnName = driver.findElement(By.xpath(ele));	
	return coloumnName;
	 }
	 
	 public WebElement getSearchPlaceholder() {
		 WebElement ele=driver.findElement(By.xpath(searchPlaceholder));	
		 return ele;
	 }
	 
	 public WebElement getSearchBarBelowTheDescriptionTxt() {
		 WebElement ele=driver.findElement(By.xpath(searchBarBelowTheDescriptionTxt));	
		 return ele;
	 }
	 
	 public WebElement getNoRecords() {
		 WebElement ele=driver.findElement(By.xpath(noRecords));	
		 return ele;
	 }
}
