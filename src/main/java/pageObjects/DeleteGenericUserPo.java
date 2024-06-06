package pageObjects;

import utils.baseClass;

public class DeleteGenericUserPo extends baseClass{
	
	public String title = "//b[text()='Welcome to your Protective ADL Portal!']";
	public String headerLoc = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
   	public String noRecordsInGrid = "table>tbody>tr>td";
   	public String rowLoc = "table>tbody>tr";
   	public String searchBoxesBelowHeadersInGrid = "thead > adl-table-header > tr:nth-child(2) > td>div>div>input";

}
