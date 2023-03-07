package pageObjects;

import utils.baseClass;

public class PricingPreferencesPO extends baseClass{
	
	public String portalTitle = "//b[text()='Welcome to your AUL ADL Portal!']";
	public String headerLoc = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
	public String roleDropdownList = "//div[@class='scrollable-content']/div/span";
	public String markupTxts = "//div[@class='mat-radio-label-content']";
	//public String markupRadioBtn = "//div[@class='mat-radio-container']/input";
	public String btnsmarkup = "mat-radio-group>mat-radio-button";
	public String markupAmountDollarSign = "//div[@class='text-field__input secure text-field__input--prefix']/span/span/mat-icon";
	public String markupAmountPercentSign = "//span[@class='suffix mat-icon-button suffix--text ng-star-inserted']/span";
	public String markupAmountTxtFld = "//div[@class='text-field__input secure text-field__input--prefix']/input";
	public String selectAllCheckBox="td:nth-of-type(1)>div>div>mat-checkbox>label>div";
	public String table = "adl-rates-table > table >tbody > tr:nth-child(1) > td:nth-child(2)";
	public String textbox = "adl-text-input > div > div.text-field__input.secure > input";
	public String contract = "div.text-field__input.secure.text-field__input--prefix > input";
	public String contractNo = "div input[disabled][maxlength='16']";
	public String noSurchargesChkbx = "//label[@for='mat-checkbox-111-input']/div";
	public String businessUse = "//p[contains(text(),'Business Use')]/../..";
	public String liftkit = "//p[contains(text(),'Lift Kit')]";
	public String liftkitSelectionStatus = "//p[contains(text(),'Lift Kit')]/../..";
	public String address = "adl-text-input[label='Address'] > div > div.text-field__input.secure > input";
	public String pincode = "adl-text-input[label='Zip Code'] > div > div.text-field__input.secure > input";
	public String lastname = "adl-text-input[label='Last Name'] > div > div.text-field__input.secure > input";
	public String email = "adl-text-input[label='Email'] > div > div.text-field__input.secure > input";
	public String noRecordsInGrid = "table>tbody>tr>td";
	public String calenderInPopup = "(//mat-icon[text()='calendar_today'])[2]";

}
