package pageActions;

import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.ManageVSC_GAPpreferencesPO;
import utils.CalenderUtils;
import utils.utilityClass;

public class ManageVSC_GAPpreferencesAction extends ManageVSC_GAPpreferencesPO {

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction();
	singleContractAction contractNew = new singleContractAction();
	generateContractAction gc = new generateContractAction();
	CalenderUtils calenderUtils= new CalenderUtils();

	public WebElement getPortalTitle() {
		WebElement welcomeTitle = driver.findElement(By.xpath(portalTitle));
		return welcomeTitle;
		
	}

	public HashMap<String, WebElement> getSearchBoxesInGrid() {
		utils.scrollDown();
		HashMap<String, WebElement> map = new HashMap<String, WebElement>();
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
		List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(searchBoxesBelowHeadersInGrid));
		for (int j = 0; j < 3; j++) {
			map.put(allHeaderNames.get(j + 1), searchBoxesInGrid.get(j));
		}
		return map;
	}

	public HashMap<String, WebElement> getSearchBoxesWithArrowSelection() {
		utils.scrollDown();
		HashMap<String, WebElement> map = new HashMap<String, WebElement>();
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
		List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(searchBoxArrow));
		for (int j = 3; j < 6; j++) {
			map.put(allHeaderNames.get(j + 1), searchBoxesInGrid.get(j - 3));
		}
		return map;
	}

	public HashMap<String, WebElement> getSearchBoxModifiedBy() {
		utils.scrollDown();
		HashMap<String, WebElement> map = new HashMap<String, WebElement>();
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
		List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(searchBoxesBelowHeadersInGrid));
		map.put(allHeaderNames.get(8), searchBoxesInGrid.get(3));
		return map;
	}

	public WebElement getStatus(String status) {
		WebElement ele = driver.findElement(By.xpath("//span[text()='" + status + "']/preceding-sibling::div"));
		return ele;
	}

	public WebElement getGapCheckbox() {
		WebElement ele = driver.findElement(By.cssSelector(gapCheckBox));
		return ele;
	}

	public WebElement getGapCheckboxStatus() {
		WebElement ele = driver.findElement(By.cssSelector(gapCheckBoxStatus));
		return ele;
	}

	public WebElement getProgramTxt() {
		WebElement ele = driver.findElement(By.xpath(programTxt));
		return ele;
	}

	public WebElement getNewPrfrncesBtn() {
		WebElement ele = driver.findElement(By.xpath(newPrfrncesBtn));
		return ele;
	}

	public List<WebElement> getRowLoc() {
		List<WebElement> rowLoactor = utils.getElementsList("cssSelector", rowLoc);
		return rowLoactor;
	}
	
	public List<WebElement> getDropDown() {
		List<WebElement> rowLoactor = utils.getElementsList("xpath", roleDropdownList);
		return rowLoactor;
	}
	
	public WebElement getDeductibleArrow() {
		WebElement ele = driver.findElement(By.cssSelector(deductibleArrow));
		return ele;
	}
	

	public WebElement getLiftkitInContractCreationPage() {
		WebElement ele = driver.findElement(By.xpath(liftkitInContractpage));
		return ele;
	}

	public WebElement getClassInContractCreationPage() {
		WebElement ele = driver.findElement(By.xpath(classes));
		return ele;
	}

	public WebElement getReserve() {
		WebElement ele = driver.findElement(By.xpath(reserve));
		return ele;
	}

	public List<WebElement> getChckboxesInPrfrncepage() {
		List<WebElement> ele = driver.findElements(By.cssSelector(chckboxesInPrfrncepage));
		return ele;
	}

	public List<WebElement> getChckboxesInPrfrncepageStatus() {
		List<WebElement> ele = driver.findElements(By.cssSelector(chckboxesInPrfrncepageStatus));
		return ele;
	}

	public WebElement getBtnSave() {
		WebElement ele = driver.findElement(By.xpath(btnSave));
		return ele;
	}

	public WebElement getBtnCancel() {
		WebElement ele = driver.findElement(By.xpath(btnCancel));
		return ele;
	}

	public WebElement getBtnYes() {
		WebElement ele = driver.findElement(By.xpath(btnYes));
		return ele;
	}

	public WebElement getBtnNo() {
		WebElement ele = driver.findElement(By.xpath(btnNo));
		return ele;
	}

	public List<WebElement> getDefaultDeductablesRadioBtns() {
		List<WebElement> ele = driver.findElements(By.cssSelector(ddRadioBtns));
		return ele;
	}

	public void getPrograms(String program) throws ParseException, InterruptedException {
		List<WebElement> list = getDriver().findElements(By.xpath(programInContractPage));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains(program)) {
				list.get(i).click();
				break;
			}
		}
		utils.clickfield("cssSelector", table, 0);
		Thread.sleep(2000);
	}

	public WebElement getBtnClose() {
		WebElement ele = driver.findElement(By.xpath(close));
		return ele;
	}

	public WebElement getDeductibleTxtInContractPage() {
		WebElement ele = driver.findElement(By.xpath(deductibleTxtInContractPage));
		return ele;
	}

	public WebElement getDeductibleInContractPage() {
		WebElement ele = driver.findElement(By.xpath(deductibleInContractPage));
		return ele;
	}

	public List<WebElement> getTermMileageMonthsInContractPage() {
		List<WebElement> ele = driver.findElements(By.cssSelector(termMileageMonthsInContractPage));
		return ele;
	}

	public WebElement getSuccessMsg() {
		WebElement ele = driver.findElement(By.xpath(SaveSuccessMsg));
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
	
	 public WebElement getArrow() {
		 WebElement arrow1=driver.findElement(By.xpath(arrow));	
		 return arrow1;
	 }
	
	public void createNewProgram(String program) throws InterruptedException {
		Thread.sleep(3000);
		getNewPrfrncesBtn().click();
		Thread.sleep(2000);
		getArrow().click();
		selectProgramNew(program);
//		utils.scrollDownUsingJSE();
//		utils.clickUsingJSE(btnSave);
		getBtnSave().click();
		getBtnYes().click();
		Thread.sleep(2000);
	}
	
	 public void selectProgram() throws InterruptedException {
		 Thread.sleep(5000);
			 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
			 list.get(0).click();
			 Thread.sleep(10000);
		}
	 
	 public void createNewProgram() throws InterruptedException {
			Thread.sleep(3000);
			getNewPrfrncesBtn().click();
			Thread.sleep(2000);
			getArrow().click();
			selectProgram();
			getBtnSave().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
	
	public String createNewProgramWithDate(String program,int days) throws Exception {
		Thread.sleep(10000);
		getNewPrfrncesBtn().click();
		Thread.sleep(2000);
		getArrow().click();
		selectProgramNew(program);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 7000)");
		Thread.sleep(2000);
		getChckboxesInPrfrncepage().get(11).click();
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollTo(0, 2000)");
		Thread.sleep(2000);
		utils.clickfield("xpath", calenderInPopup);
		String selectedDate = calenderUtils.getCurrentDate(days,"MMM/dd/yyyy");
		System.out.println("Selected Date-"+selectedDate);
		calenderUtils.selectDate(selectedDate,"MMM/dd/yyyy");
		getBtnSave().click();
		getBtnYes().click();
		Thread.sleep(2000);
		return selectedDate;
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
				for (int j = 2; j <= 9; j++) {
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
	

}
