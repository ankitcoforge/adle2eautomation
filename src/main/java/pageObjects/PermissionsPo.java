package pageObjects;

import utils.baseClass;

public class PermissionsPo extends baseClass{
	
	public String portalTitle = "//b[text()='Welcome to your AUL ADL Portal!']";
	public String roleDropdown = "//ng-select[@role='listbox']";
	public String roleDropdownList = "//div[@class='scrollable-content']/div";
//	public String permissionList = "adl-table-cells>div>span:nth-of-type(2)";
//	public String permissionsCheckBox = "td>adl-table-cells>div>mat-checkbox";
	public String txtFieldNewUserRegistration = "section>input";
	public String editBtn = "//i[@title='Edit']";
	public String permissionsDropdownInPopup = "(//div/p-multiselect/div)[2]";
	public String permissionsDropdownInAgentPopup = "(//div/p-multiselect/div)[3]";
	public String permissionsListInPopup = "//div[@class='ui-chkbox ui-widget']/../span";
	public String selectAllCheckBoxInPopup = "//div[@role='checkbox']";
	public String selectCheckBoxInPopup = "p-multiselectitem>li>div>div";
	public String arrowInPopup ="//div[@class='ng-tns-c143-134 ui-multiselect-trigger ui-state-default ui-corner-right']";
	public String editPermissionsTxt ="//h3[text()='Edit Permissions']";
	public String saveBtn ="//span[text()='Save']/..";
	public String cancelBtn ="//span[text()='Cancel']/..";
	public String closeBtn ="//button[@aria-label='Close']/span/mat-icon";
	public String updateBtn ="//span[text()=' Update ']/..";
	public String yesBtn ="//span[text()='Yes']";
	public String checkboxesPermissions ="//div[@class='ui-chkbox ui-widget']/div/span";
}
