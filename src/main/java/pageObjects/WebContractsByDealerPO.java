package pageObjects;

import utils.baseClass;

public class WebContractsByDealerPO extends baseClass{
	
	public String WebContractstitle = "//h3[text()='Web Contracts by Dealer']";
	public String adminRoleId="//span[text()='coforgeadmin']";
	public String rowsPerPage="p-paginator>div>p-dropdown>div";
	public String rowsPerPageDropdownbtn="//p-dropdown//div[@role='button']";
	public String rowsPerPageDropdownlist="ul> p-dropdownitem";
	public String rowsPerPageSelected="p-paginator>div>p-dropdown>div>div:nth-of-type(2)>span";
	public String reportsDropdownlist="ul>mat-nested-tree-node>li";
	public String contractRecordsGrid="//div[@class='ui-table ui-widget ui-table-responsive ui-table-auto-layout']";
	public String firstGrid="//adl-text-input[@placeholder='+i+']//input[@type='text']";
	public String arrowForwardBtn="//mat-icon[text()='arrow_forward']";
	public String currentPageRecord="//span[@class='ui-paginator-current ng-star-inserted']";
	public String totalPagesDisplayed="//span[@class='ui-paginator-pages']//a";
	public String plsMakeaSearchTxt="//td[contains(text(),'Please make a search to display records')]";
	
	
	//grid
	public String headerLoc = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
	public String rowLoc = "table>tbody>tr";
	public String editButtnGrid = "table>tbody>tr>td:nth-child(11)";
	public String editStatusMsg = "//i[@mattooltip='Edit Status']";
	public String restoreContractMsg = "//i[@mattooltip='Restore Contract']";
	public String gridArrowBttn = "adl-table-header>tr>th>p-sorticon>i";
	public String spinner = "ngx-spinner";
}

