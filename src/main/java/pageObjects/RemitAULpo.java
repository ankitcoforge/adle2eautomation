package pageObjects;

import utils.baseClass;

public class RemitAULpo extends baseClass {

	public String ADLwelcometitle = "//b[text()='Welcome to your Protective ADL Portal!']";
	public String remitContractsTitle = "//h3[text()='Remit Contracts to AUL']";
	public String selectContractsTab = "//h5[text()='Select Contracts']";
	public String selectContractByDefault = "//h5[text()='Select Contracts']/../..";
	public String checkDetailsTab = "//h5[text()='Check Details']";
	public String checkDetailsTabStatus = "//h5[text()='Check Details']/../..";
	public String paymentDetailsTab = "//h5[text()='Payment Details']";
	public String paymentDetailsTabStatus = "//h5[text()='Payment Details']/../..";
	public String selectTheContractsTxt = "//p[contains(text(),'Select the contracts to remit to AUL')]";
	public String currentPageRecord="//span[@class='ui-paginator-current ng-star-inserted']";
	public String rowsPerPage="p-paginator>div>p-dropdown>div";
	public String rowsPerPageDropdownbtn="//p-dropdown//div[@role='button']/span";
	public String rowsPerPageDropdownlist="ul> p-dropdownitem>li>span";
	public String rowsPerPageSelected="p-paginator>div>p-dropdown>div>div:nth-of-type(2)>span";
	public String calenderPopup="mat-datepicker-content>mat-calendar";
	public String calenderIcon="//mat-icon[text()='calendar_today']";
	// grid
	public String headerLoc = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
	public String rowLoc = "table>tbody>tr";
	public String contractsInGrid="//div[@class='ui-table ui-widget ui-table-responsive ui-table-auto-layout']";
	public String gridArrowBttn = "adl-table-header>tr>th>p-sorticon>i";
	public String searchBoxesBelowHeadersInGrid = "thead > adl-table-header > tr:nth-child(2) > td>div>div>input";
	public String selectAllCheckBox = "thead > adl-table-header > tr:nth-child(2) > td>div>div>mat-checkbox>label>div>input";
	public String selectCheckBoxAttribute="td:nth-of-type(1)>adl-table-cells>div>mat-checkbox>label>div>input";
	public String selectCheckBox="td:nth-of-type(1)>adl-table-cells>div>mat-checkbox>label>div";
	public String unselectedCheckBox="td:nth-of-type(1)>adl-table-cells>div>mat-checkbox>label>div>input[aria-checked='false']";
	public String paymentDetailCheckBox="adl-checkbox>div>mat-checkbox>label>div";
	public String paymentDetailCheckBoxAttribute="adl-checkbox>div>mat-checkbox>label>div>input";
	public String searchBox="[placeholder='Search']";
	public String paymentDetailsChkBxTxt="[class='payment-details__checkbox__text']";
	public String paymentDetailsComments="div>textarea";
	public String commentsTitleTxt="//label[text()='Comments']";
	public String noRecordsTxt="//td[text()=' There are no records to display ']";
	public String clearFiltersTxt="//span[text()='Clear Filters']";
	public String totalDueTxt="//span[text()='Total Due: ']";
	public String totalDueValue="//span[text()='Total Due: ']/b";
	public String checkAmountTxt="//span[text()='Check Amount: ']";
	public String checkAmountValue="//span[text()='Check Amount: ']/b";
	public String checkAmountFieldInCheckdetailsTab="[class='text-field__input secure text-field__input--prefix']>input";
	public String calenderPlaceholder="[aria-haspopup='dialog']";
	public String remitcontracts="//span[text()='Remit Contracts']";
	public String yesBtn="//span[text()='Yes']";
	public String noRecordsInGrid = "table>tbody>tr>td";
}
