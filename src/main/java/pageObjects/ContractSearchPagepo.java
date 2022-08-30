package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import utils.baseClass;

public class ContractSearchPagepo extends baseClass{

	public String headerLoc = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
	public String rowLoc = "table>tbody>tr";
	public String row = "//*[@id=\"contract_search\"]/tbody/tr";
	public String selectCheckBoxInGrid = "td:nth-of-type(+ j +)>adl-table-cells>div>mat-checkbox>label>div";
	public String searchBoxesBelowHeadersInGrid = "thead > adl-table-header > tr:nth-child(2) > td>div>div>input";
	public String selectStatus = "thead > adl-table-header > tr:nth-child(2) > td>div>div>p-multiselect";
	public String enteredStatusChkbox = "//li[@aria-label='Entered']/div/div/span";
	public String dropdownValue = "span.ng-value-label";
	public String details = ".tr-expansible__col-group__title > b";
	public String showRecord = "p-paginator > div >span";
	public String defaultNumber = "p-dropdown >div >div:nth-child(2) >span";
	public String dropdownButton = "[role='button']";
	public String dropdownOptions = "p-dropdownitem > li";
	public String checkbox = ".mat-checkbox-layout >div";
	public String selectedItems = ".toolbar__items > span";
	public String yesButton = "adl-modal-container >section > div > button[color =\"primary\"]";
	public String noButton = "adl-modal-container >section > div > button[color=\"white-primary\"]";
	public String text = "adl-modal-container >header >h3";
	public String close = "button[aria-label =\"Close\"]";
	public String delete = ".toolbar__delete > a";
	public String maintext = "p.description";
	public String fromDate = "adl-text-input[type='datepicker'][controltype='fromDate']";
	public String toDate = "adl-text-input[type='datepicker'][controltype='toDate']";
	public String dateLabel = ".dates-selector__datepicker>label";
	public String datefield = "adl-text-input > div > div >input";
	public String exportPDF = "#reportsTable > div > div > div > div > button:nth-child(1)";
	public String exportXLS = "#reportsTable > div > div > div > div > button:nth-child(2)";
	public String filterbox = "ng-select[role='listbox']";
	public String searchBox = "input.global-search__input";
	public String empty = "tr >td.empty";
	public String clearFilterButton = "span.clear-filters";
	
}
