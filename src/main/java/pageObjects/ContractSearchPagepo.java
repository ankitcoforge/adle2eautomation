package pageObjects;

import utils.baseClass;

public class ContractSearchPagepo extends baseClass{

	public String headerLoc = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
	public String rowLoc = "table>tbody>tr";
	public String row = "//*[@id=\"contract_search\"]/tbody/tr";
	public String selectCheckBoxInGrid = "td:nth-of-type(+ j +)>adl-table-cells>div>mat-checkbox>label>div";
	public String searchBoxesBelowHeadersInGrid = "thead > adl-table-header > tr:nth-child(2) > td>div>div>input";
	public String selectStatus = "thead > adl-table-header > tr:nth-child(2) > td>div>div>p-multiselect";
	public String enteredStatusChkbox = "//li[@aria-label='Entered']/div/div/span";
}
