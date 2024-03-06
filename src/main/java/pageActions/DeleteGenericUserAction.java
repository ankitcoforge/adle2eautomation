package pageActions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.DeleteGenericUserPo;
import utils.utilityClass;

public class DeleteGenericUserAction extends DeleteGenericUserPo{
	
	utilityClass event = new utilityClass();
	
	
	 public WebElement getTitle() {
		 WebElement welcomeTitle=driver.findElement(By.xpath(title));	
		 return welcomeTitle;
	 }
	 
	 public HashMap<Integer, HashMap<String, String>> checkGridBodyDetailsInImpersonatePage() {
			List<String> allHeaderNames = event.getTextValuesForObject("cssSelector", headerLoc);
			System.out.println("allHeaderNames: " + allHeaderNames);
			HashMap<Integer, HashMap<String, String>> allTableData = new HashMap<Integer, HashMap<String, String>>();
			
			// Get total rows count
			List<WebElement> allRowsEle = event.getElementsList("cssSelector", rowLoc);
			System.out.println("No of rows in grid: " + allRowsEle.size());
			
			for (int i = 1; i <= allRowsEle.size(); i++) {
//				if (i == 10) 	
					event.scrollDown();

				// Getting specific row with each iteration
				String specificRowLoc = "table>tbody>tr:nth-of-type(1)";
				LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
				for (int j = 3; j < 8; j++) {
					
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
	 
	 public HashMap<Integer, HashMap<String, WebElement>> checkGridForEditLockResendInvitationImpersonate() {
			List<String> allHeaderNames = event.getTextValuesForObject("cssSelector", headerLoc);
			System.out.println("allHeaderNames: " + allHeaderNames);
			HashMap<Integer, HashMap<String, WebElement>> allTableData = new HashMap<Integer, HashMap<String, WebElement>>();
			// Get total rows count
			List<WebElement> allRows = event.getElementsList("cssSelector", rowLoc);
			System.out.println("No of rows in grid: " + allRows.size());
//			for (int i = 1; i <= allRows.size(); i++) {
//				if (i == 10)
					event.scrollDown();
				// Getting specific row with each iteration
				String specificRowLoc = "table>tbody>tr:nth-of-type(1)";
				LinkedHashMap<String, WebElement> eachRowData = new LinkedHashMap<>();
				for (int j = 8; j <= 12; j++) {
					String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>div:nth-of-type(1)>i:nth-of-type(1)";
					WebElement cellValue = event.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
					eachRowData.put(allHeaderNames.get(j-1), cellValue);
				}
				allTableData.put(1, eachRowData);
//			}
			System.out.println("Complete Grid data: " + allTableData);
			event.scrollUp();
			return allTableData;
		}
	 
	 public WebElement deleteLinkInGrid(int row) {
	String del = "table>tbody>tr:nth-of-type("+row+")>td:nth-of-type(10)>adl-table-cells>div>div:nth-of-type(1)>i";
	 return event.element("cssselector", del);
	 }

	 
}
