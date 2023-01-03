package pageObjects;

import utils.baseClass;

public class PricingPreferencesPO extends baseClass{
	
	public String portalTitle = "//b[text()='Welcome to your AUL ADL Portal!']";
	public String headerLoc = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
	public String roleDropdownList = "//div[@class='scrollable-content']/div/span";
	public String markupTxts = "//div[@class='mat-radio-label-content']";
	public String markupRadioBtn = "//div[@class='mat-radio-container']/input";
	public String btnPercnt = "mat-radio-button";
	public String markupAmountDollarSign = "//div[@class='text-field__input secure text-field__input--prefix']/span/span/mat-icon";
	public String markupAmountPercentSign = "//span[@class='suffix mat-icon-button suffix--text ng-star-inserted']/span";
	public String markupAmountTxtFld = "//div[@class='text-field__input secure text-field__input--prefix']/input";
}
