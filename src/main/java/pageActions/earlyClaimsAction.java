package pageActions;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.earlyClaimspo;
import utils.utilityClass;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.commons.io.FileUtils;

public class earlyClaimsAction extends earlyClaimspo {
	utilityClass uc = new utilityClass();

	public void checkDropDownValidations() throws InterruptedException {
		Assert.assertEquals(getDropdownTitle(), "Claims on contracts recently sold.");
		Assert.assertEquals(getDropdownDefaultValue(), "30 days");
		uc.clickfield("cssSelector", dropdown);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		List<String> expectedValue = new ArrayList<String>(Arrays.asList("30 days", "60 days", "90 days"));
		Assert.assertEquals(expectedValue.equals(uc.getTextValuesForObject("cssSelector", dropdownOptions)), true);
	}

	public void checkGridHeaderDetails(String username) throws InterruptedException {
		List<String> gridHeaderUI = uc.getTextValuesForObject("cssSelector", headerLoc);
		List<String> gridHeaderExpected = null;
		Thread.sleep(1000);
		if (username.contains("dealer")) {
			gridHeaderExpected = new ArrayList<String>(
					Arrays.asList("", "Last Name", "Contract", "VIN", "Payee", "Claim Amount", "", ""));
			Assert.assertEquals(gridHeaderUI.size(), 8);
			Assert.assertEquals(gridHeaderUI.contains("Dealer Id"), false);
			Assert.assertEquals(gridHeaderUI.contains("Dealer Name"), false);
			
		} else if (username.contains("agent") || username.contains("lender")) {
			gridHeaderExpected = new ArrayList<String>(Arrays.asList("", "Dealer Id", "Dealer Name",
					"Last Name", "Contract", "VIN", "Payee", "Claim Amount", "", ""));
			Assert.assertEquals(gridHeaderUI.size(), 10);
			Assert.assertEquals(gridHeaderUI.contains("Dealer Id"), true);
			Assert.assertEquals(gridHeaderUI.contains("Dealer Name"), true);
		}
		Assert.assertEquals(gridHeaderUI.equals(gridHeaderExpected), true);
		Assert.assertEquals(gridHeaderUI.get(gridHeaderUI.size()-2).equals(""), true);
	}

	public String getDropdownTitle() {
		uc.element("cssSelector", dropdownTitle).isDisplayed();
		return (uc.element("cssSelector", dropdownTitle).getText());
	}

	public String getDropdownDefaultValue() {
		uc.element("cssSelector", dropdownDefaultValue).isDisplayed();
		return (uc.element("cssSelector", dropdownDefaultValue).getText());
	}
	
	public String getRoleTypeIdUI() {
		uc.element("cssSelector", roleTypeId).isDisplayed();
		return (uc.element("cssSelector", roleTypeId).getText());
	}

	public HashMap<Integer, HashMap<String, String>> checkGridBodyDetails() {
		List<String> allHeaderNames = uc.getTextValuesForObject("cssSelector", headerLoc);
		System.out.println("allHeaderNames: " + allHeaderNames);
		HashMap<Integer, HashMap<String, String>> allTableData = new HashMap<Integer, HashMap<String, String>>();
		
		// Get total rows count
		List<WebElement> allRowsEle = uc.getElementsList("cssSelector", rowLoc);
		System.out.println("No of rows in grid: " + allRowsEle.size());
		for (int i = 1; i <= allRowsEle.size(); i++) {
			if (i == 10) 	
			uc.scrollDown();

			// Getting specific row with each iteration
			String specificRowLoc = "table#early-claims>tbody>tr:nth-of-type(" + i + ")";
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			for (int j = 1; j < allHeaderNames.size() - 1; j++) {
				int k = j + 1;
				String specificRowColLoc = "td:nth-of-type(" + k + ")>adl-table-cells>div>span:nth-of-type(2)";
				String specificRowColLocViewDetail = "td:nth-of-type(" + k + ")>adl-table-cells>div>a";
				String cellValue = "";
				if (j == allHeaderNames.size() - 2)
					cellValue = uc.element("cssSelector", specificRowLoc + ">" + specificRowColLocViewDetail).getText();
				else 
					cellValue = uc.element("cssSelector", specificRowLoc + ">" + specificRowColLoc).getText();

				eachRowData.put(allHeaderNames.get(j), cellValue);
			}

			allTableData.put(i, eachRowData);

		}

		System.out.println("Complete Grid data: " + allTableData);
		
		uc.scrollUp();
		
		HashMap<String, String> getFirstRowData = allTableData.get(1);
		Assert.assertEquals(getFirstRowData.get("VIN").length(), 6);
		Assert.assertEquals(getFirstRowData.get("").equals("View Details"), true);
		
		System.out.println(allTableData);
		
		return allTableData;
		}
	
	public void checkFooterPagination(int totalRowsPerPage) throws InterruptedException {
		uc.scrollDown();
		String defaultRowsPerPage = "25";
		uc.element("cssSelector", rowsPerPage).isDisplayed();
		String rowsPerPageUI = uc.element("cssSelector", rowsPerPage).getText();
		String rowCountGrid = Integer.toString(totalRowsPerPage);
		Assert.assertEquals(rowCountGrid.equals(rowsPerPageUI), true);
		Assert.assertEquals(rowCountGrid.equals(defaultRowsPerPage), rowsPerPageUI.equals(defaultRowsPerPage));
		List<String> pagesUI = uc.getTextValuesForObject("cssSelector", pageCount);
		
		List<String> pagesExpected = new ArrayList<String>(
				Arrays.asList("1", "2", "3", "4", "5"));
		Assert.assertEquals(pagesUI.equals(pagesExpected), true);
		
		String rangeMessageUI = uc.element("cssSelector", rangeMessage).getText();
		
		Pattern pattern = Pattern.compile("(?=.*Showing)(?=.*to)(?=.*of)(?=.*records)");
		Assert.assertEquals(pattern.matcher(rangeMessageUI).find(), true);
		Assert.assertEquals(rangeMessageUI.indexOf("Showing")<rangeMessageUI.indexOf("to"), true);
		Assert.assertEquals(rangeMessageUI.indexOf("to")<rangeMessageUI.indexOf("of"), true);
		Assert.assertEquals(rangeMessageUI.indexOf("of")<rangeMessageUI.indexOf("records"), true);
		
		int lb = Integer. parseInt(rangeMessageUI.substring(rangeMessageUI.indexOf("g")+2,rangeMessageUI.indexOf("to")-1));
		int ub = Integer. parseInt(rangeMessageUI.substring(rangeMessageUI.indexOf("to")+3,rangeMessageUI.indexOf("of")-1));
		int totalRows = Integer. parseInt(rangeMessageUI.substring(rangeMessageUI.indexOf("of")+3,rangeMessageUI.indexOf("records")-1));
		int totalpages = totalRows/totalRowsPerPage;
		int rem = totalRows%totalRowsPerPage;
		if(rem>0)
			totalpages++;
		System.out.println("rangeMessageUI: " + rangeMessageUI);
		System.out.println("lb: " + lb);
		System.out.println("ub: " + ub);
		System.out.println("totalRows: " + totalRows);
		System.out.println("totalpages:" + totalpages);
		
		Assert.assertEquals(lb == (25*1)-(totalRowsPerPage-1), true);
		Assert.assertEquals(ub == (25*1), true);
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void checkGridExpandFirstRow() throws InterruptedException {
		uc.clickfield("cssSelector", expandContractDetails);
		Thread.sleep(1000);
		List<String> headerdetailsUI = uc.getTextValuesForObject("cssSelector", contractDetailsKey);
		System.out.print("headerdetailsUI: " + headerdetailsUI);
		
		List<String> headerdetailsExp = new ArrayList<String>(
				Arrays.asList("Auto Details:", "Sale Date:", "Year:", "Mileage:", "Days to R.O.:", "Days to Pay:", "Claim Date:", "Sale to Claim Days:", "Sale to Claim Miles:"));
		System.out.println("array list--"+headerdetailsExp);
		List<String> valuedetailsUI = uc.getTextValuesForObject("cssSelector", contractDetailsValue);
		System.out.println("valuedetailsUI: " + valuedetailsUI);
		//System.out.println("headerdetailsUI: " + headerdetailsUI);
		Assert.assertTrue(headerdetailsUI.equals(headerdetailsExp));
		//Assert.assertEquals(valuedetailsUI.contains("") || valuedetailsUI.contains(null), false);
		Thread.sleep(1000);
		uc.clickfield("cssSelector", expandContractDetails);
	}
	
	public void clickOnViewDetailsFirstRow() {
		uc.clickfield("xpath", viewDetailFirstRow, 0);
		WebElement element = uc.element("cssSelector", modal);
		System.out.println("element: " + element);
		Assert.assertEquals(element!=null, true);
		
	}

	public void verifyModalDetails(HashMap<String, String> getFirstRowDataGrid, String roleType) {
	
		String lastNameDetailsModalUI = "";
		String vinDetailsModalUI = "";
		String detailsHeadingModalUI = "";
		String repairHeadingModalUI = "";
		String detailsTextModalUI = "";
		String repairTextModalUI = "";
		
		if (roleType.contains("agent") || roleType.contains("lender")) {
			String roleDetailsModalUI = uc.text("cssSelector", roleDetailsModal);
			lastNameDetailsModalUI = uc.text("cssSelector", secondRowModal);
			vinDetailsModalUI = uc.text("cssSelector", thirdRowModal);
			Assert.assertEquals(roleDetailsModalUI.equals(getFirstRowDataGrid.get("Dealer Name") + " - ID: " + getFirstRowDataGrid.get("Dealer Id")), true);
			Assert.assertEquals(roleDetailsModalUI.contains(getFirstRowDataGrid.get("Dealer Name")), true);
		} if (roleType.contains("dealer")) {
			lastNameDetailsModalUI = uc.text("cssSelector", firstRowModal);
			vinDetailsModalUI = uc.text("cssSelector", secondRowModal);
		}
		
		Assert.assertEquals(lastNameDetailsModalUI.equals("Last Name: " + getFirstRowDataGrid.get("Last Name")), true);	
		Assert.assertEquals(vinDetailsModalUI.contains("VIN:"), true);
		Assert.assertEquals(vinDetailsModalUI.contains(getFirstRowDataGrid.get("VIN")), true);
		detailsHeadingModalUI = uc.text("cssSelector", detailsHeadingModal);
		Assert.assertEquals(detailsHeadingModalUI.equals("Description"), true);
		repairHeadingModalUI = uc.text("cssSelector", repairHeadingModal);
		Assert.assertEquals(repairHeadingModalUI.equals("$ Repair"), true);
		detailsTextModalUI = uc.text("cssSelector", detailsTextModal);
		repairTextModalUI = uc.text("cssSelector", repairTextModal);
		System.out.println(detailsTextModalUI + "  " + repairTextModalUI);
		Assert.assertEquals(detailsTextModalUI.length() > 0, true);
		Assert.assertEquals(detailsTextModalUI.matches("[0-9]+"), false);
		Assert.assertEquals(repairTextModalUI.length() >= 5, true);
		Assert.assertEquals(repairTextModalUI.contains("$") && repairTextModalUI.contains("."), true);
		repairTextModalUI =repairTextModalUI.replace("$", "");
		repairTextModalUI =repairTextModalUI.replace(".", "");
		System.out.println(repairTextModalUI);
		Assert.assertEquals(repairTextModalUI.matches("[0-9]+"), true);
	}
	
	public void ChangeDropDownOtion(String option) throws InterruptedException {
		uc.clickfield("cssSelector", dropdown);
		Thread.sleep(1000);
		uc.clickfield("xpath", "//span[@class='ng-option-label ng-star-inserted' and text()='" + option + "']");
	}
	
	public void ApplyFiltersOnGrid(String filterColumn, String filterData) throws InterruptedException {
		
		switch (filterColumn.toLowerCase()) {
		
		case " last name" : 
			
		break;
		
		case "contract" : 
			
		uc.inputfield("cssSelector", contractFilter,filterData.trim());
		
		break;
		
		case "vin" :  
			
		break;
		
		case "payee" :  
			
		break;
		
		case "claim amount" :  
			
		break;
		
		}
	}
	
	public void clickCloseButton(String closeModalType) throws InterruptedException {
		switch (closeModalType.toLowerCase()) {
		
		case "closebutton" : 	
		uc.clickfield("cssSelector", closeButtonModal);	
		break;
		
		case "xicon" : 	
		uc.clickfield("cssSelector", closeIconModal);
		break;
		
		}
	}
	
	public String verifyPDF(HashMap<Integer, HashMap<String, String>> allTableData) throws InterruptedException, IOException {
		int totalRowsPerPage = allTableData.size();
		
		HashSet<String> a1 = cleanCurrentDirectoryAndGetPdfFile("mainPage");
		String pdfUrl =  "file:///" +  System.getProperty("user.dir") + "\\PDF\\" + a1.toString().replaceAll("\\,|\\[|\\]|\\s", "");
		System.out.println(pdfUrl);
		uc.scrollDown();
		
		String rangeMessageUI = uc.element("cssSelector", rangeMessage).getText();
		
		int lb = Integer. parseInt(rangeMessageUI.substring(rangeMessageUI.indexOf("g")+2,rangeMessageUI.indexOf("to")-1));
		int ub = Integer. parseInt(rangeMessageUI.substring(rangeMessageUI.indexOf("to")+3,rangeMessageUI.indexOf("of")-1));
		int totalRows = Integer. parseInt(rangeMessageUI.substring(rangeMessageUI.indexOf("of")+3,rangeMessageUI.indexOf("records")-1));
		int totalpages = totalRows/totalRowsPerPage;
		int rem = totalRows%totalRowsPerPage;
		if(rem>0)
			totalpages++;
		System.out.println("rangeMessageUI: " + rangeMessageUI);
		System.out.println("lb: " + lb);
		System.out.println("ub: " + ub);
		System.out.println("totalRows: " + totalRows);
		System.out.println("totalpages:" + totalpages);
		System.out.println("totalRowsPerPage:" + totalRowsPerPage);
		uc.scrollUp();
		String pdfContent=verifyContentInPDf(pdfUrl,totalpages,totalRows,totalRowsPerPage);
		String firstRowPDF = pdfContent.substring(pdfContent.indexOf("Amount")+8, pdfContent.indexOf('.')+3);
		System.out.println("firstRowPDF: " + firstRowPDF);
		HashMap<String, String> getFirstRowData = allTableData.get(1);
		String firstRowUI = "";
		for (Map.Entry<String, String> set :
			getFirstRowData.entrySet()) {
			if(!set.getValue().equals("View Details"))
			firstRowUI = firstRowUI + set.getValue() + " ";
       }
		firstRowUI = firstRowUI.trim();
		System.out.println("firstRowUI: " + firstRowUI);
		Assert.assertEquals(firstRowPDF,firstRowUI);
		String pdfFileName = "";
		for (String ele : a1) {
			pdfFileName = ele;
        }
		return pdfFileName;
		
	}
	
	public HashSet<String> isFileDownloaded(String downloadPath, String fileName) {
//		boolean flag = false;
	String pathnames[] = null;
	File dir = new File(downloadPath);
	// Populates the array with names of files and directories
	pathnames = dir.list();
	// For each pathname in the pathnames array
	HashSet<String> a = new HashSet<>();

	for (String pathname : pathnames) {
		// Print the names of files and directories
		a.add(pathname);
	}
	return a;
}
	
	public String verifyContentInPDf(String url, int expectedTotalpages, int totalRows,int totalRowsPerPage) {
		// specify the url of the pdf file
		String pdfContent = "";
		try {
			pdfContent = readPdfContent(url, expectedTotalpages,totalRows,totalRowsPerPage);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pdfContent;
	}
	
	public String readPdfContent(String url,int expectedTotalpages,int totalRows,int totalRowsPerPage) throws IOException {

		URL pdfUrl = new URL(url);
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);
		PDDocument doc = PDDocument.load(bf);
		int numberOfPagesPDF = getPageCount(doc);
		System.out.println("The total number of pages in PDF " + numberOfPagesPDF);
		int totalpagesPDFFormatted = totalRows/28;
		int rem = totalRows%28;
		if(rem>0)
			totalpagesPDFFormatted++;
		System.out.println("totalpagesPDFFormatted " + totalpagesPDFFormatted);
		Assert.assertEquals(numberOfPagesPDF,totalpagesPDFFormatted);
		// Number of rows in PDF document can be changed. For now it is 28
		if(totalRows > 28)
			Assert.assertEquals(totalpagesPDFFormatted > 1,true);
		if(totalRowsPerPage<25)
			Assert.assertEquals(expectedTotalpages==totalpagesPDFFormatted,true);
		else if(totalRowsPerPage>=25 && totalRowsPerPage<=28)
			Assert.assertEquals(expectedTotalpages>totalpagesPDFFormatted,true); 
		else
			Assert.assertEquals(expectedTotalpages<totalpagesPDFFormatted,true);
		String content = new PDFTextStripper().getText(doc);
		doc.close();

		return content;
	}
	
	public int getPageCount(PDDocument doc) {
		// get the total number of pages in the pdf document
		int pageCount = doc.getNumberOfPages();
		return pageCount;

	}
	
	public String getCurrentMonth() {
		String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};

        Calendar cal = Calendar.getInstance();
        String month = monthName[cal.get(Calendar.MONTH)];
		return month;

	}
	
public void applyFilter(String filterData) throws InterruptedException {
		
		uc.inputfield("cssSelector", filterTextBox, filterData);
		
	}

public void clearFilter() throws InterruptedException {
	
	uc.clickfield("xpath",clearFilterButton );
	
}

public String getToastMessageText() {
	
	return uc.toastMessage();
	
}
public String getModalPDFName() throws InterruptedException, IOException {
	
	String detailsTextModalUI = uc.text("cssSelector", detailsTextModal);
	String repairTextModalUI = uc.text("cssSelector", repairTextModal);
	String combinedModaltext = detailsTextModalUI + " " + repairTextModalUI;
	
	HashSet<String> a1 = cleanCurrentDirectoryAndGetPdfFile("modal");
	String pdfUrl =  "file:///" +  System.getProperty("user.dir") + "\\PDF\\" + a1.toString().replaceAll("\\,|\\[|\\]|\\s", "");
	System.out.println(pdfUrl);
	String pdfContent=verifyContentInPDf(pdfUrl,1,1,1);
	String firstRowPDF = pdfContent.substring(pdfContent.indexOf("$ Repair")+10, pdfContent.indexOf('.')+3);
	System.out.println("firstRowPDF: " + firstRowPDF);
	System.out.println("modal Details: " + combinedModaltext);
	Assert.assertEquals(firstRowPDF,combinedModaltext);
	String pdfFileName = "";
	for (String ele : a1) {
		pdfFileName = ele;
    }
	return pdfFileName;
	
}

public HashSet<String> cleanCurrentDirectoryAndGetPdfFile(String exportButtonType) throws InterruptedException, IOException {
	
	FileUtils.cleanDirectory(new File(System.getProperty("user.dir") + "\\PDF")); 
	
	clickExportPDFButton(exportButtonType);
	Thread.sleep(3000);
	HashSet<String> a1 = new HashSet<>();
	a1 = isFileDownloaded(System.getProperty("user.dir") + "\\PDF", ".pdf");
	System.out.println(a1);
	return a1;
	
}

public void clickExportPDFButton(String exportButtonType) throws InterruptedException {
	switch (exportButtonType.toLowerCase()) {
	
	case "mainpage" : 	
		uc.clickfield("xpath", exportPDFPage,0);
	break;
	
	case "modal" : 	
		uc.clickfield("xpath", exportPDFPage,1);
	break;
	
	case "mainpagexls" : 	
		uc.clickfield("xpath", exportXlsPage,0);
	break;
	
	case "modalxls" : 	
		uc.clickfield("xpath", exportXlsPage,1);
	break;
	
	}
}


//public void clickExportPDFButtonInViewDetails(String exportButtonType) throws InterruptedException {
//	switch (exportButtonType.toLowerCase()) {
//	
//	case "mainpage" : 	
//		uc.clickfield("xpath", exportPDFPage,1);
//	break;
//	
//	case "modal" : 	
//		uc.clickfield("xpath", exportPDFPage,1);
//	break;
//	
//	case "mainpagexls" : 	
//		uc.clickfield("xpath", exportXlsPage);
//	break;
//	
//	case "modalxls" : 	
//		uc.clickfield("xpath", exportXlsPage);
//	break;
//	
//	}
//}

public boolean toastMessageDisplay() {
	try {
		driver.findElement(By.cssSelector("div[role='alertdialog']"));
		return true;
    } catch (org.openqa.selenium.NoSuchElementException e) {
        return false;
    }
}
	
}
