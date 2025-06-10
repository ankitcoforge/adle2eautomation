package pageObjects;

import utils.baseClass;

public class EditContractpo extends baseClass{
	
	public String ADLwelcometitle = "//b[text()='Welcome to your Protective ADL Portal!']";
	public String contractSearchPagetitle = "//h3[text()='Contract Search']";
	public String editContractPagetitle = "//h3[text()='Edit Contract']";
	public String rateOrContractPageTitle = "//h3[text()='Rate / Contract']";
	public String contarctInfoTxtFields1 = "//adl-contract-information-edit-card/section/div[1]/div/adl-text-input/div/div[2]/input";
	public String vehiclePurchaseTxtField = "adl-text-input[label ='Vehicle Purchase Price']>div>div:nth-child(2)>input";
	public String contactRetailPriceTxtField = "adl-text-input[label ='Contract Retail Price']>div>div:nth-child(2)>input";
	public String contarctInfoTxtFields2 = "//adl-contract-information-edit-card/section/div[2]/div/adl-text-input/div/div[2]/input";
	public String coustomerInfoTxtFields = "//adl-customer-information-form/section/div[1]/div/adl-text-input/div/div[2]/input";
	public String coustomerInfoHighlighter = "//adl-customer-information-form/section/div[1]/div/adl-text-input/div/div[2]";
	public String lienholderTxtField = "//adl-typeahead/adl-text-input/div/div[2]/input";
	public String lienholderTxtFieldForShowLienholderList = "//input[@placeholder='Enter Lienholder Name']";
	public String lienholderlist = "mat-option>span>span";
	public String lienholderlistwithBackground = "[role=listbox]>mat-option";
	public String btnCancel = "//span[text()='Cancel']";
	public String btnSave = "//span[text()='Save']";
	public String coBuyerChkbox = "//div[@class='customer__hascobuyer']/adl-checkbox/div/mat-checkbox/label/div/input";
	public String coBuyerChkboxField = "//div[@class='customer__hascobuyer']/adl-checkbox/div/mat-checkbox/label/div";
	public String contractSubmittedSuccessTxt = "//span[text()='Your contract has been updated successfully']";
	public String goToContractsPageLink = "//a[text()='Go to Contracts Page']";
	public String rowLoc = "table>tbody>tr";
	public String invalidLienholderTxt = "//span[text()='Invalid Lienholder']";
	public String notOnTheListLink = "//a[text()=' Not on the list ']";
	public String showLienholderListLink = "//a[text()=' Show lienholder list ']";
	public String requiredErrorMsg = "//span[text()='Required']";
	public String invalidFormatErrorMsg = "//span[text()='Invalid format. Please try again.']";
	
	public String successMessage = "div.notification__container__message > span";
	public String btnViewOrPrintContract = "//span[text()='View / Print Contract']";
	public String goToContractsPage = ".notification__container__actions > a:nth-child(2)";
	public String goToQuote = ".notification__container__actions > a:nth-child(3)";
	public String iconCheckMark = "//div[@class='notification__container__image']/img";
	public String iconClose = "//mat-icon[text()='close']";
	public String gapContractFileSuccessMsg = "//span[contains(text(),'Your GAP contract file')]";
	
	
}
