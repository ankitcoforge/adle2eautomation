package pageObjects;

import utils.baseClass;

public class impersonatepo extends baseClass{
	
	public String title = "//b[text()='Welcome to your Protective ADL Portal!']";
	public String roleDropdown = "//ng-select[@role='listbox']";
	public String roleDropdownArrow = "//span[@class='ng-arrow-wrapper']";
	public String roleDropdownInAccountManagementPage = "(//ng-select[@role='listbox'])[1]";
	public String roleDropdownForAccountName = "//input[@placeholder='Account Name']/..";
	public String roleIdInAccountManagementPage = "//div[text()='Please enter the Role ID / Account Name']/../div[2]/input";
	public String roleDropdownList = "//div[@class='scrollable-content']/div";
	public String roleDropdownListForAccountName = "//span[@class='mat-option-text']";
	public String roleDropdownListForDealer = "//mat-option[@role='option']/span/span";
    public String roleId = "//input[@placeholder='Please enter the Role ID / Account Name']";
    public String roleIdInPopup = "(//input[@placeholder='Please enter the Role ID / Account Name'])[2]";
    public String getusersButton = "//span[contains(text(),'Get Users')]";
    public String impersonateAsGenericUserButton = "//span[contains(text(),'Impersonate as Generic Role')]";
    public String getUsersAndImpersonateAsGenericBtnsList = "form>button";
    public String getArrowBtn = "//mat-icon[text()='arrow_forward']";
    public String tableFirstRow = "(//i[@title='Impersonate'])[1]";
    public String tableSecondRow = "(//i[@title='Impersonate'])[2]";
    public String impersonateList = "//i[@title='Impersonate']";
    public String logoutArrow  = "adl-header > header > div > div > button > mat-icon";
    public String impersonate = "div [role='menu'] > div > ul >li >button";
    public String logout = "//button[text()='Logout']";
    public String endImpersonate = "//button[text()='End Impersonating']";
    
    public String headerLoc = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
    public String gridArrowBttn = "adl-table-header>tr>th>p-sorticon>i";
    public String show="thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']>p:nth-of-type(1)";
    public String pack="thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']>p:nth-of-type(2)";
    public String passthrough="thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']>p:nth-of-type()";
	public String searchBoxesBelowHeadersInGrid = "thead > adl-table-header > tr:nth-child(2) > td>div>div>input";
	public String rowLoc = "table>tbody>tr";
	public String btnYes = "(//button[@color='primary']/span)[2]";
	public String roleType = "//strong[text()='Role Type: ']";
	public String accountName = "//strong[text()='Account Name: ']";
	public String userName = "//strong[text()='Username: ']";
	public String firstname = "//adl-text-input[@label='First Name']/div/div/input";
	public String lastname = "//adl-text-input[@label='Last Name']/div/div/input";
	public String email = "//adl-text-input[@label='Email']/div/div/input";
	public String btnUpdate = "//span[text()='Update']";
	public String iconClose = "//mat-icon[text()='close']";
	public String btnSubmit = "//span[text()='Submit']";
	public String resendInvitationConfirmMsg = "//div[contains(text(),'Invitation has been sent')]";
	public String selectDealerTogenerateContract = "//input[@placeholder='Type or Select Dealer Name']";
	public String btnSignIn = "//span[text()='Sign In']/..";
	public String dealerRoleid = "//span[contains(text(),'Dealer:')]";
	public String TypeOrSelectDealerNameTxt = "//input[@placeholder='Type or Select Dealer Name']";
	public String dealerOptionsWhileCreatigQuote = "span.mat-option-text>span";
	public String impersonatingDataList="//span[text()='AULadmin']/../div/span";
	public String aulAdmin = "//span[text()='AULadmin']";
	public String packPassthroughBtn = "adl-toggle>div>div";
	public String registrationStatusArrowForSort = "//span[text()='Registration Status']/../p-sorticon/i";
	public String impersonateInGenericRoleBtn = "//span[text()='Impersonate as Generic Role']/..";
	
	//imp as generic role
	public String impersonateInGenericImpPopup = "(//span[text()='Impersonate']/..)[2]";
	public String impersonateInGenericImpPopupInImpPage = "//div[@class='buttons-container']/button/span[text()='Impersonate']";
	public String getUsersAndImpersonateBtn = "form>button";
	public String roleDropdownArrowInPopup="//div[text()='Select Role']/../../span[@class='ng-arrow-wrapper']";

//permission
	public String permissionsArrow = "//label[text()='Permissions']/../p-multiselect/div/div[3]/span";
	public String selectAllLink = "//div[@role='checkbox']";
	public String updateBtn = "//span[text()=' Update ']";
	public String updateBtnStatus = "//span[text()=' Update ']/..";
	public String yesBtn = "//span[text()='Yes']";
	public String closeInPermPopup = "//a[@class='ui-multiselect-close ui-corner-all ng-tns-c161-10']/span";
//	public String closeInPermPopup = "//button[@aria-label='Close']/span/mat-icon";
	
	public String registrationStatusArrow = "(//span[contains(@class,'pi pi-chevron-down')])[2]";
	public String roleTypeStatusArrow = "(//span[contains(@class,'pi pi-chevron-down')])[1]";
	public String completedCheckbox = "//li[@aria-label='Completed']/div/div";
	public String roleType1 = "(//span[contains(@class,'ui-multiselect-trigger-icon ui-clickable')])[1]";
	
	//mailosaur
	public String emailMailosaur = "//input[@id='email']";
}
