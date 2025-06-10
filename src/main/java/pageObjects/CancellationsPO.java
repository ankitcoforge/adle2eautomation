package pageObjects;

import utils.baseClass;

public class CancellationsPO extends baseClass{
	
	//Cancellation HistoryPage
	 public String headerLoc = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
	 public String rowLoc = "table>tbody>tr";
	 public String searchBox = "//input[@placeholder='Search']";
	 public String totalRows = "//table/tbody/tr[@class='ng-star-inserted']";
	 public String headersTxt = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader'] > span";
	 public String clearFiltersLink = "//span[text()='Clear Filters']";
	 public String exportPDF = "//button[text()='Export PDF']";
	 public String exportXLS = "//button[text()='Export XLS']";
	 public String pdfXlsDownloadConfirmation = "//div[@aria-label='Please note - Your file will be shown at the bottom of the browser and will be automatically saved into your Downloads folder.']";
	 public String statusArrow = "(//span[contains(@class,'pi pi-chevron-down')])[1]";
}
