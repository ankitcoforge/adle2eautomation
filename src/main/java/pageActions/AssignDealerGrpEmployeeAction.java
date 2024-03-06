package pageActions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import pageObjects.AssignDealerGrpEmployeePO;
import utils.utilityClass;

public class AssignDealerGrpEmployeeAction extends AssignDealerGrpEmployeePO{

	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction();
	
	public void selectdealerGrpEmpInDropDown(String dealerGrpEmp) {
		utils.waitTillElementIsVisible(selectDealerGrpEmployeeArrow);
		utils.element("xpath",selectDealerGrpEmployeeArrow).click();
		List<WebElement> dealerGrpEmpOptionsList = utils.getElementsList("xpath", dealerGrpEmpOptions);
		for(int i=0;i<dealerGrpEmpOptionsList.size();i++) {
			if(dealerGrpEmpOptionsList.get(i).getText().equalsIgnoreCase(dealerGrpEmp)) {
				dealerGrpEmpOptionsList.get(i).click();
			}
		}
	}
	
	public List<WebElement> getRows() {
		List<WebElement> rows = utils.getElementsList("cssselector", rowLoc);
		return rows;
	}
	
	public int getNumOfPages() {
		List<WebElement> pages = utils.getElementsList("cssselector", numOfPages);
		 int totalPages = pages.size();
		return totalPages;
	}
	
	public HashMap<Integer, HashMap<String, String>> assignDealerToDealerGrpEmpPageGrid() {
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", impersonate.headerLoc);
		System.out.println("allHeaderNames: " + allHeaderNames);
		HashMap<Integer, HashMap<String, String>> allTableData = new HashMap<Integer, HashMap<String, String>>();
		List<WebElement> allRowsEle = utils.getElementsList("cssSelector", impersonate.rowLoc);
		System.out.println("No of rows in grid: " + allRowsEle.size());
		
		for (int i = 1; i <= allRowsEle.size(); i++) {
			String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			for (int j = 2; j < 9; j++) {
				
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
	
	public WebElement selectCheckBoxForRow(int row) {
		 String selectCheckBox = "td:nth-of-type("+row+")>adl-table-cells>div>mat-checkbox";
		 WebElement ele = utils.element("cssselector", selectCheckBox);
		 return ele;
	}
	
	public WebElement getSelectAllChckbox() {
		  List<WebElement> ele = driver.findElements(By.xpath(selectAllChckbox));
		 WebElement selectAllChkBox = ele.get(1);
		 return selectAllChkBox;
	}
	
	public void selectAllAndDelete() {
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("arguments[0].click()", getSelectAllChckbox());
	getSelectAllChckbox().click();
	utils.getfield("a", "Delete").click();
	utils.getfield("span", "Yes").click();
	utils.waitTillElementIsClickableByWebEle(utils.getfield("div","Dealer Assign/Unassign successfully."));
	}


}
