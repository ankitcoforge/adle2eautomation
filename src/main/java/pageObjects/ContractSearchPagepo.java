package pageObjects;

import utils.baseClass;

public class ContractSearchPagepo extends baseClass{

	public String headerLoc = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
	public String rowLoc = "table>tbody>tr";
	public String row = "//*[@id=\"contract_search\"]/tbody/tr";
	
}
