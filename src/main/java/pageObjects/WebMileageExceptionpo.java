package pageObjects;

import utils.baseClass;

public class WebMileageExceptionpo extends baseClass {
	
	public String portalTitle = "//b[text()='Welcome to your AUL ADL Portal!']";
	public String roleDropdown = "//ng-select[@role='listbox']";
	public String roleDropdownList = "//div[@class='scrollable-content']/div";
    public String roleId = "//input[@placeholder='Please enter the Role ID / Account Name']";
    public String arrowbtn = "//mat-icon[text()='arrow_forward']";
    public String roleIdTextBox = "//input[@role='combobox']";
    
    //grid
    public String headerLoc = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
   	public String noRecordsInGrid = "table>tbody>tr>td";
   	public String rowLoc = "table>tbody>tr";
   	public String searchBoxesBelowHeadersInGrid = "thead > adl-table-header > tr:nth-child(2) > td>div>div>input";
   	public String gridArrowBttn = "adl-table-header>tr>th>p-sorticon>i";
   	public String mileageAndAge = "//div[@class='text-field__input secure']/input";
   	public String saveBtn = "//span[text()=' Save ' ]";
   	public String cancelBtn ="//span[text()='Cancel']";
   	public String iconClose = "//mat-icon[text()='close']";
   	
   	public String newExceptionBtn = "//span[text()=' + New exception ']";
	public String roleType = "//div/strong[contains(text(),'Role Type: ')]";
	public String roleIdInEdidPopup = "//div/strong[contains(text(),'Role ID: ')]";
	public String programCode = "//div/strong[contains(text(),'Program Code')]";
	public String rowsPerPageDropdownbtn="//p-dropdown//div[@role='button']";
	public String rowsPerPageDropdownlist="ul> p-dropdownitem>li>span";
	public String rowsPerPageSelected="p-paginator>div>p-dropdown>div>div:nth-of-type(2)>span";
	public String packArrow = "(//span[@class='ng-arrow-wrapper'])[3]";
	public String roleIdInputFld = "(//div[@class='ng-input']/input)[2]";
	public String textbox = "adl-text-input > div > div.text-field__input.secure > input";
	public String getProducts = "//span[contains(text(),'Get Products')]";
	public String table = "adl-rates-table > table >tbody > tr:nth-child(1) > td:nth-child(2)";
	public String programInContractPage ="//div[@class='programs__checkboxes col-12 grid ng-star-inserted']/adl-checkbox/div/mat-checkbox/label/span";
}
