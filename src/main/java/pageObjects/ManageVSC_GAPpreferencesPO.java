package pageObjects;

import utils.baseClass;

public class ManageVSC_GAPpreferencesPO extends baseClass {

	public String portalTitle = "//b[text()='Welcome to your AUL ADL Portal!']";
	public String headerLoc = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
	public String searchBoxesBelowHeadersInGrid = "thead > adl-table-header > tr:nth-child(2) > td>div>div>input";
	public String searchBoxArrow = "p-multiselect>div>div:nth-child(3)";
	public String gapCheckBox = "[class='mat-checkbox-inner-container']";
	public String gapCheckBoxStatus = "[class='mat-checkbox-inner-container']>input";
	public String programTxt = "//strong[contains(text(),'Program')]";
	public String newPrfrncesBtn = "//span[text()=' + New Preferences ']/..";
	public String liftkitInContractpage = "//p[contains(text(),'Lift Kit')]";
	public String termMileageMonthsInContractPage = "[class='cell']>span";
	public String classes = "//span[contains(text(),'Class')]/..";
	public String reserve = "//p[text()='Reserve']";
	public String ddRadioBtns = "label.mat-radio-label>div.mat-radio-container";
	public String chckboxesInPrfrncepage = "div.mat-checkbox-inner-container";
	public String chckboxesInPrfrncepageStatus = "div.mat-checkbox-inner-container>input";
	public String btnSave = "//span[contains(text(),'Save')]";
	public String btnCancel = "//span[contains(text(),'Cancel')]";
	public String btnYes = "//span[contains(text(),'Yes')]";
	public String btnNo = "//span[contains(text(),'No')]";
	public String SaveSuccessMsg = "//div[contains(text(),'The preferences were saved successfully')]";
	public String rowLoc = "table>tbody>tr";
	public String table = "adl-rates-table > table >tbody > tr:nth-child(1) > td:nth-child(2)";
	public String close = "//mat-icon[text()='close']";

	public String programInContractPage = "//div[@class='programs__checkboxes col-12 grid ng-star-inserted']/adl-checkbox/div/mat-checkbox/label/span";
	public String deductibleTxtInContractPage = "//span[contains(text(),'Deductible')]";
	public String deductibleInContractPage = "//span[contains(text(),'Deductible')]//parent::div";
	public String deductibleArrow = "div.rate-option__deductibles>adl-select >ng-select > div.ng-select-container.ng-has-value";
	public String arrow = "//span[@class='ng-arrow-wrapper']";
	public String roleDropdownList = "//div[@class='scrollable-content']/div/span";
}
