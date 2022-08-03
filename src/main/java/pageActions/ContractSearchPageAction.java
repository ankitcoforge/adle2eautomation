package pageActions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import pageObjects.ContractSearchPagepo;
import utils.utilityClass;

public class ContractSearchPageAction extends ContractSearchPagepo {
	
	verticalMenuAction verticalMenu=new verticalMenuAction();
	utilityClass utils= new utilityClass();
	loginAction login = new loginAction(); 
	
	public HashMap<Integer, HashMap<String, String>> checkGridBodyDetails() {
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
		System.out.println("allHeaderNames: " + allHeaderNames);
		HashMap<Integer, HashMap<String, String>> allTableData = new HashMap<Integer, HashMap<String, String>>();
		// Get total rows count
		List<WebElement> allRows = utils.getElementsList("cssSelector", rowLoc);
		System.out.println("No of rows in grid: " + allRows.size());
		for (int i = 1; i <= allRows.size(); i++) {
			if (i == 10) 	
			utils.scrollDown();
			// Getting specific row with each iteration
			String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			for (int j = 3; j < allHeaderNames.size() - 4; j++) {
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


}
