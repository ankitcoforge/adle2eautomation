package pageObjects;

import utils.baseClass;

public class ManageMyDealerGrpEmployeePO extends baseClass{
	
	public String checkbox = "//td/adl-table-cells/div/mat-checkbox/label/div/input";
	public String permissions = "//td[2]/adl-table-cells/div";
	public String selectUserDropdown = "//adl-select/ng-select";
	public String selectAllCheckBox = "//adl-table-header/tr/td/div/div/mat-checkbox//input/..";
	public String selectAllCheckBoxstatus = "//adl-table-header/tr/td/div/div/mat-checkbox//input";
	public String permissionsTxtField = "//adl-table-header/tr/td/div/div/input";
	public String permissionSortIcon = "//span[text()='Permission']/../p-sorticon/i";
	public String permissionTxt = "//span[text()='Permission']";
	public String defaultMailIdForSelectedUser = "//div[@class='ng-select-container ng-has-value']/div/div/span[2]";
	
	public String currentPageRecord="//span[@class='ui-paginator-current ng-star-inserted']";
	public String rowsPerPage="p-paginator>div>p-dropdown>div";
	public String rowsPerPageSelected="p-paginator>div>p-dropdown>div>div:nth-of-type(2)>span";
	public String roleDropdownList = "//div[@class='scrollable-content']/div/span";
	
}
