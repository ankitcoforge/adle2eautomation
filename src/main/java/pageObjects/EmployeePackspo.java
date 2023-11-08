package pageObjects;

import utils.baseClass;

public class EmployeePackspo extends baseClass {

	public String portalTitle = "//b[text()='Welcome to your AUL ADL Portal!']";
	public String dealerPackstitle = "//h3[text()='Manage My Dealer Packs']";
	public String lenderPackstitle = "//h3[text()='Manage My Lender Packs']";
	public String btnNewPack = "//span[text()=' + New Pack ']";
	public String newPackPopup = "//h3[text()='Dealer Pack - New']";
	public String btnCloseForPopup = "//mat-icon[text()='close']";
	public String roleDropdown = "//ng-select[@role='listbox']";
	public String roleDropdownList = "//div[@class='scrollable-content']/div/span";
	public String packAmount = "//div[@class='text-field__input secure text-field__input--prefix']/input";
	public String btnSave = "//span[text()=' Save ' ]";
	public String ConfirmationMsg = "//div[contains(text(),'saved successfully')]";
	public String headerLoc = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
	public String rowLoc = "table>tbody>tr";
	public String noRecordsInGrid = "table>tbody>tr>td";
	public String currentPageRecord = "//span[@class='ui-paginator-current ng-star-inserted']";
	public String searchBoxesBelowHeadersInGrid = "thead > adl-table-header > tr:nth-child(2) > td>div>div>input";
	public String selectCheckBox = "td:nth-of-type(1)>adl-table-cells>div>mat-checkbox>label>div";
	public String deleteLink = "//a[text()='Delete']";
	public String btnYes = "//span[text()='Yes']";
	public String deleteConfirmationMsg = "//div[contains(text(),'successfully deleted')]";
	public String textbox = "adl-text-input > div > div.text-field__input.secure > input";
	public String getProducts = "//span[contains(text(),'Get Products')]";
	public String table = "adl-rates-table > table >tbody > tr:nth-child(1) > td:nth-child(2)";
	public String popup = "adl-employee-pack-modal>adl-modal-container";
	public String packArrow = "//span[@class='ng-arrow-wrapper']";
	public String selectDealerNamearrow = "//mat-icon[text()='arrow_drop_down']";
	public String selectDealerNameDropdownList = "//mat-option[@role='option']/span/span";
	public String close = "//mat-icon[text()='close']";
//	public String enterRole = "//input[contains(@placeholder,'Please enter the Role')]";
//	public String roleDropdownListForDealer = "//mat-option[@role='option']/span/span";
}
