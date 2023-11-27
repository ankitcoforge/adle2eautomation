package pageObjects;


import utils.baseClass;

public class LateralMenupo extends baseClass{
	
	public String title = "//b[text()='Welcome to your AUL ADL Portal!']";
	public String lateralMenu = "mat-tree.mat-tree";
	public String lateralMenuItems1 = "mat-tree>mat-nested-tree-node>li>button";
	public String lateralMenuItems2 = "mat-tree>mat-nested-tree-node>li>a";
	public String laterMenuSubItems = "mat-nested-tree-node[aria-expanded='true']>li>ul>mat-nested-tree-node>li>a";
	public String thirdSubMenuItems = "mat-nested-tree-node[aria-expanded='true']>li>ul>mat-nested-tree-node>li>button";
	public String rateContractTitle = "//h3[text()='Rate/Contract']";
	public String quoteHistoryTitle = "//h3[text()='Quote History']";
	public String aulLogo = "//img[@alt='AUL Logo']";
	public String cancellationQuoteTitle = "//h3[text()='Cancellation Quote']";
	public String cancellationHistoryTitle = "//h3[text()='Cancellation History']";
	public String contractSearchTitle = "//h3[text()='Contract Search']";
	public String dashboardTitle = "//h3[text()='Dashboard']";
	public String generateQuoteTxt = "//h3[text()='To Generate a Quote Sign In as a Dealer']";
	
	public String newuserPopupHeader = "//h3[text()='New User Registration']";
	public String newuserBtnClose = "//button[@aria-label='Close']/span";
	public String newExceptionBtn = "//span[text()=' + New exception ']";
	public String newuserBtn = "//span[text()=' + New user ']";
	public String editUserPopup = "//h3[text()='Edit user']";
	public String delConfirmationMsg = "//h4[contains(text(),'Are you sure you want to delete')]";
	public String roleType = "thead > adl-table-header > tr:nth-child(2) > td>div>div>p-multiselect";
	public String roleType1 = "(//span[contains(@class,'ui-multiselect-trigger-icon ui-clickable')])[1]";
	public String selectDealerRoleType = "//li[@aria-label='Dealer']/div/div/span";
	public String selectDealerEmpRoleType = "//li[@aria-label='DealerEmp']/div/div/span";
	public String roleId = "//input[@placeholder='Please enter the Role ID / Account Name']";
	public String roleDropdownList = "//mat-option";
	public String EditStatusDisabled = "//i[@title='Edit']/../i[contains(@class,'pi pi-pencil disabled')]";
	public String EditStatusEnabled = "//i[@title='Edit']/../i[contains(@class,'pi pi-pencil')]";
	public String deleteStatus = "//i[@title='Delete']";
	}
