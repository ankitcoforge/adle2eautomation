package pageActions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
			String value = driver.findElements(By.xpath(xpath2)).get(3).getText();
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
				eachRowData.put(allHeaderNames.get(j - 1), cellValue);
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
		WebElement editLinkElement = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
		return editLinkElement;
	}

	public HashMap<String, WebElement> getSearchBoxesInGrid() {
		utils.scrollDown();
		HashMap<String, WebElement> map = new HashMap<String, WebElement>();
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
		List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(searchBoxesBelowHeadersInGrid));
		for (int j = 1; j <= allHeaderNames.size() - 13; j++) {
			map.put(allHeaderNames.get(j + 4), searchBoxesInGrid.get(j));
		}
		return map;
	}

	public WebElement getSelectStatus() {
		WebElement status = driver.findElement(By.cssSelector(selectStatus));
		return status;
	}

	public WebElement getEnteredStatusChkbox() {
		WebElement chkboxEnteredStatus = driver.findElement(By.xpath(enteredStatusChkbox));
		return chkboxEnteredStatus;
	}

	public String dropDownValue() {

		return utils.text("cssSelector", dropdownValue);
	}

	public String xpathLastrow(String a) {

		return "//*[@id='contract_search']/tbody/tr[" + length() + "]/td[" + a + "]/adl-table-cells/div/span[2]";
	}

	public ArrayList<String> details() {

		int length = driver.findElements(By.cssSelector(details)).size();
		ArrayList<String> a = new ArrayList<String>();
		for (int i = 0; i < length; i++) {

			a.add(driver.findElements(By.cssSelector(details)).get(i).getText());
		}
		return a;
	}

	public void expandRecord() {

		utils.clickfield("cssSelector", "i.pi-chevron-right", 0);
	}

	public WebElement deleteLink() {

		return utils.element("cssSelector", ".toolbar__delete >a");
	}

	public WebElement deleteAttribute() {

		return utils.element("cssSelector", ".toolbar__delete");
	}

	public void expandTwoRecord() {

		utils.clickfield("cssSelector", "i.pi-chevron-right", 1);
		utils.clickfield("cssSelector", "i.pi-chevron-right", 0);
	}

	public void collapseTwoRecord() {

		utils.clickfield("cssSelector", "i.pi-chevron-down", 1);
		utils.clickfield("cssSelector", "i.pi-chevron-down", 0);
	}

	public void collapseRecord() {

		utils.clickfield("cssSelector", "i.pi-chevron-down", 0);
	}

	public void selectCheckbox(int i) {

		utils.clickfield("cssSelector", checkbox, i);
	}

	public String itemsSelected() {

		return utils.text("cssSelector", selectedItems);
	}

	public WebElement modelBoxYes() {

		return utils.element("cssSelector", yesButton);
	}

	public String statefirstRow() {

		return driver
				.findElement(By.xpath("//*[@id=\"contract_search\"]/tbody/tr[1]/td[3]/adl-table-cells/div/span[2]"))
				.getText();
	}

	public String contractfirstRow() {

		return driver
				.findElement(By.xpath("//*[@id=\"contract_search\"]/tbody/tr[1]/td[6]/adl-table-cells/div/span[2]"))
				.getText();
	}

	public String vinfirstRow() {

		return driver
				.findElement(By.xpath("//*[@id=\"contract_search\"]/tbody/tr[1]/td[7]/adl-table-cells/div/span[2]"))
				.getText();
	}
	
	public String programfirstRow() {

		return driver
				.findElement(By.xpath("//*[@id=\"contract_search\"]/tbody/tr[1]/td[8]/adl-table-cells/div/span[2]"))
				.getText();
	}
	
	public String lastnamefirstRow() {

		return driver
				.findElement(By.xpath("//*[@id=\"contract_search\"]/tbody/tr[1]/td[10]/adl-table-cells/div/span[2]"))
				.getText();
	}
	
	public String saledatefirstRow() {

		return driver
				.findElement(By.xpath("//*[@id=\"contract_search\"]/tbody/tr[1]/td[11]/adl-table-cells/div/span[2]"))
				.getText();
	}

	public String make() {

		return utils.text("xpath", makeValue);
	}

	public String model() {

		return utils.text("xpath", modelValue);
	}

	public String retaildatefirstRow() {

		String a = driver
				.findElement(By.xpath("//*[@id=\"contract_search\"]/tbody/tr[1]/td[13]/adl-table-cells/div/span[2]"))
				.getText();
		String b = a.replace("$", "");
		String c = b.replace(".00", "");
		return c;
	}
	
	public void certfirstRow() {

		driver.findElement(By.xpath("//*[@id=\"contract_search\"]/tbody/tr[1]/td[15]/adl-table-cells/div/div")).click();
	}
	
	
	public String  aulcostfirstRow() {

		String a = driver
				.findElement(By.xpath("//*[@id=\"contract_search\"]/tbody/tr[1]/td[14]/adl-table-cells/div/span[2]"))
				.getText();
		String b = a.replace("$", "");
		String c = b.replace(".00", "");
		return c;
	}

	public WebElement modelBoxNo() {

		return utils.element("cssSelector", noButton);

	}

	public WebElement modelBoxText() {

		return utils.element("cssSelector", text);
	}

	public WebElement modelBoxClose() {

		return utils.element("cssSelector", close);
	}

	public void clickDelete() {

		utils.clickfield("cssSelector", delete);
	}

	public String mainHeading() {

		return utils.text("cssSelector", maintext);
	}

	public List<WebElement> calenderLabel() {

		return driver.findElements(By.cssSelector(dateLabel));
	}

	public List<WebElement> datefield() {

		return driver.findElements(By.cssSelector(datefield));
	}

	public List<String> columnlist(int rowno) {

		List<String> program = new ArrayList<String>();
		for (int i = 0; i < driver.findElements(By.xpath(row)).size(); i++) {
			int j = i + 1;
			program.add(driver.findElement(By.xpath(
					"//*[@id='contract_search']/tbody/tr[" + j + "]/td[" + rowno + "]/adl-table-cells/div/span[2]"))
					.getText());

		}
		return program;
	}

	public List<String> price(int rowno) {

		List program = new ArrayList();
		for (int i = 0; i < driver.findElements(By.xpath(row)).size(); i++) {
			int j = i + 1;
			String a = (driver.findElement(By.xpath(
					"//*[@id='contract_search']/tbody/tr[" + j + "]/td[" + rowno + "]/adl-table-cells/div/span[2]"))
					.getText());
			if (a.length() > 0) {
				String b = a.substring(1);
				String c = b.replace(",", "");
				Double price = Double.parseDouble(c);
				program.add(price);
			}

		}
		return program;
	}

	public List<String> sortColumn(int rowno) {

		driver.findElement(By.xpath("//*[@id=\"contract_search\"]/thead/adl-table-header/tr[1]/th[" + rowno + "]"))
				.click();
		return columnlist(rowno);

	}

	public String colorAttribute(int rowno) {

		driver.findElement(By.xpath("//*[@id=\"contract_search\"]/thead/adl-table-header/tr[1]/th[" + rowno + "]"))
				.click();
		return driver
				.findElement(By.xpath("//*[@id=\"contract_search\"]/thead/adl-table-header/tr[1]/th[" + rowno + "]"))
				.getCssValue("color");

	}

	public List<String> reversesortColumn(int rowno) {

		driver.findElement(By.xpath("//*[@id=\"contract_search\"]/thead/adl-table-header/tr[1]/th[" + rowno + "]"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"contract_search\"]/thead/adl-table-header/tr[1]/th[" + rowno + "]"))
				.click();

		return columnlist(rowno);

	}

	public void downloadPDF() {

		utils.clickfield("cssSelector", exportPDF);
	}

	public void downloadXLS() {

		utils.clickfield("cssSelector", exportXLS);
	}

	public List<String> sortpriceColumn(int rowno) {

		driver.findElement(By.xpath("//*[@id=\"contract_search\"]/thead/adl-table-header/tr[1]/th[" + rowno + "]"))
				.click();
		return price(rowno);

	}

	public String filenameFormat(int day, String type) {

		String fileName = new String();
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		System.out.println(localDate.format(formatter));
		LocalDate thirty = localDate.minusDays(day);
		System.out.println(thirty.format(formatter));
		String dealer = utils.text("cssSelector", "button >span.usertype");
		String roleId[] = dealer.split(" ");
		if (type == "pdf") {
			fileName = "[Contracts-" + thirty.format(formatter) + "-" + localDate.format(formatter) + "-" + roleId[1]
					+ ".pdf]";
		} else
			fileName = "[Contracts-" + thirty.format(formatter) + "-" + localDate.format(formatter) + "-" + roleId[1]
					+ ".xlsx]";
		return fileName;
	}

	public WebElement searchbar() {

		return driver.findElement(By.cssSelector(searchBox));

	}

	public void changefilter() {

		utils.clickfield("cssSelector", filterbox);
		utils.clickfield("cssSelctor", ".ng-option[role=\"option\"]", 3);
	}

	public String noResult() {

		return utils.text("cssSelector", empty);
	}

	public WebElement clearFilter() {

		return utils.element("cssSelector", clearFilterButton);
	}

	public int length() {

		return driver.findElements(By.xpath("//*[@id=\"contract_search\"]/tbody/tr")).size();
	}
}
