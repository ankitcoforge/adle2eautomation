package pageObjects;

import utils.baseClass;

public class earlyClaimspo extends baseClass{

	public String dropdownTitle = "adl-claims > div > div.claims__dropdown > p";
	public String dropdownDefaultValue = "adl-select > ng-select > div > div > div.ng-value.ng-star-inserted > span.ng-value-label.ng-star-inserted";
	public String dropdown = "div.claims__dropdown > adl-select > ng-select";
	public String dropdownOptions = "span[class='ng-option-label ng-star-inserted']";
	public String headerLoc = "#early-claims > thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
	public String rowLoc = "table#early-claims>tbody>tr";
	public String rowsPerPage = "p-paginator>div>p-dropdown>div>div:nth-of-type(2)>span";
	public String pageCount = "span.ui-paginator-pages > a";
	public String rangeMessage = "p-paginator > div > span.ui-paginator-current.ng-star-inserted";
	public String expandContractDetails = "tbody > tr:nth-child(1) > td:nth-child(1) > adl-table-cells > div > a > i";
	public String contractDetailsKey = " div.tr-expansible__col-group__title";
	public String contractDetailsValue = "div.tr-expansible__col-group__value";
	public String viewDetailFirstRow = "//a[contains(text(),'View Details')]";
	public String modal = ".cdk-overlay-pane.showDetailsModal";
	public String roleDetailsModal = "adl-modal-container > header > h3";
	public String firstRowModal = "adl-modal-container > header > h4:nth-child(1)";
	public String secondRowModal = "adl-modal-container > header > h4:nth-child(2)";
	public String thirdRowModal = "adl-modal-container > header > h4:nth-child(3)";
	public String detailsHeadingModal = "#early-Claims-Details > thead > adl-table-header > tr:nth-child(1) > th:nth-child(1)";
	public String repairHeadingModal = "#early-Claims-Details > thead > adl-table-header > tr:nth-child(1) > th:nth-child(2)";
	public String detailsTextModal = "#early-Claims-Details > tbody > tr > td:nth-child(1) > adl-table-cells > div > span:nth-child(2)";
	public String repairTextModal = "#early-Claims-Details > tbody > tr > td:nth-child(2) > adl-table-cells > div > span.currency.ng-star-inserted";
	public String descriptionContent = "//*[@id='early-Claims-Details']/tbody/tr/td/adl-table-cells/div/span[2]";
	public String closeIconModal = "button > span > mat-icon";
	public String closeButtonModal = "footer > div > button";
	public String contractFilter = "tr.ng-star-inserted > td:nth-child(3) > div > div > input";
	public String exportPDFPage = "//button[text()='Export pdf' and @class ='btn__exp']";
	public String roleTypeId = "button > span.usertype";
	public String filterTextBox = "input[placeholder='Search']";
	public String clearFilterButton = "//span[text()='Clear Filters']";
}


