package pageActions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.ContractSearchPagepo;
import utils.utilityClass;

public class ContractSearchPageAction extends ContractSearchPagepo {

	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
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
				eachRowData.put(allHeaderNames.get(j - 1), cellValue);
			}
			allTableData.put(i, eachRowData);
		}
		System.out.println("Complete Grid data: " + allTableData);
		utils.scrollUp();
		return allTableData;
	}

	public HashMap<Integer, HashMap<String, String>> uiTableData() {

		HashMap<Integer, HashMap<String, String>> uiData = new HashMap<Integer, HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		int length = driver.findElements(By.xpath(row)).size();
		for (int i = 0; i < length; i++) {
			int x = i + 1;
			String xpath1 = "//*[@id=\"contract_search\"]/tbody/tr[" + x + "]/td//span[2]//../span[1]";
			String xpath2 = "//*[@id=\"contract_search\"]/tbody/tr[" + x + "]/td//span[2]";
			for (int j = 0; j < 12; j++) {

				String header = driver.findElements(By.xpath(xpath1)).get(j).getAttribute("textContent");
				String value = driver.findElements(By.xpath(xpath2)).get(j).getText();
				map.put(header, value);
			}
			uiData.put(i, map);
		}
		return (uiData);

	}

	public List<String> tableHeader() {
		List header = new ArrayList();
		int length = driver.findElements(By.cssSelector(".ui-table-thead >adl-table-header >tr >th")).size();
		for (int i = 0; i < length; i++) {
			header.add(
					driver.findElements(By.cssSelector(".ui-table-thead >adl-table-header >tr >th")).get(i).getText());
		}

		return (header);
	}

	public HashMap<Integer, String> editReContractlink() {

		HashMap<Integer, String> uilink = new HashMap<Integer, String>();
		int length = driver.findElements(By.xpath(row)).size();
		for (int i = 0; i < length; i++) {
			int x = i + 1;

			String xpath2 = "//*[@id='contract_search']/tbody/tr[" + x + "]/td//a";
			String value = driver.findElements(By.xpath(xpath2)).get(1).getText();
			uilink.put(i, value);

		}
		return (uilink);

	}

	public HashMap<Integer, String> reContractlink() {

		HashMap<Integer, String> relink = new HashMap<Integer, String>();
		int length = driver.findElements(By.xpath(row)).size();
		for (int i = 0; i < length; i++) {
			int x = i + 1;

			String xpath2 = "//*[@id='contract_search']/tbody/tr[" + x + "]/td//a";
			String value = driver.findElements(By.xpath(xpath2)).get(2).getText();
			relink.put(i, value);

		}
		return (relink);

	}

	public String editContracturl() {

		driver.findElements(By.xpath("//*[@id='contract_search']/tbody/tr[1]/td//a")).get(1).click();
		return driver.getCurrentUrl();
	}

	public String reContracturl() {

		driver.findElements(By.xpath("//*[@id='contract_search']/tbody/tr[1]/td//a")).get(2).click();
		return driver.getCurrentUrl();
	}

	public void filterStatus(String status) {

		utils.clickfield("cssSelector", "div.ui-multiselect-trigger");
		String a = "p-multiselectitem>[aria-label='" + status + "'] >div";
		utils.clickfield("cssSelector", a);
		utils.clickfield("cssSelector", "thead.ui-table-thead");
	}

	public HashMap<Integer, HashMap<String, WebElement>> checkGridBodyDetailsForElement() {
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
			for (int j = 3; j < allHeaderNames.size() - 4; j++) {
				String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>span:nth-of-type(2)";
				 WebElement cellValue = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
				eachRowData.put(allHeaderNames.get(j-1), cellValue);
			}
			allTableData.put(i, eachRowData);
		}
		System.out.println("Complete Grid data: " + allTableData);
		utils.scrollUp();	
		return allTableData;
		}
	
	
	public WebElement selectStatusCheckBoxInGrid(int row) {
			    utils.scrollDown();
			    String specificRowLoc = "table>tbody>tr:nth-of-type(" + row + ")";
				String specificRowColLoc = "td:nth-of-type(2)>adl-table-cells>div>mat-checkbox>label>div";
				WebElement statusCheckBox = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
				return statusCheckBox;
		}
	
	
	 public WebElement getEditLink(int row) {
		String specificRowLoc = "table>tbody>tr:nth-of-type(" + row + ")";
		String specificRowColLoc = "td:nth-of-type(17)>adl-table-cells>div>a";
		WebElement  editLinkElement = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
        return editLinkElement;
    }
	 
	 
	 public HashMap<String, WebElement> getSearchBoxesInGrid() {
		 utils.scrollDown();
		 HashMap<String, WebElement>  map = new HashMap<String, WebElement> ();
		 List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
		 List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(searchBoxesBelowHeadersInGrid));
		  for (int j = 1; j <= allHeaderNames.size() - 13; j++) {
			  map.put(allHeaderNames.get(j+4), searchBoxesInGrid.get(j));
		  }
         return map;
	 }
	 
	 
	 public WebElement getSelectStatus() {
		 WebElement status=driver.findElement(By.cssSelector(selectStatus));	
		 return status;
	 }
	 

	 public WebElement getEnteredStatusChkbox() {
		 WebElement chkboxEnteredStatus=driver.findElement(By.xpath(enteredStatusChkbox));	
		 return chkboxEnteredStatus;
	 }
}
