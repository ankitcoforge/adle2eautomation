package pageObjects;

import utils.baseClass;

public class EditContractpo extends baseClass{
	
	public String ADLwelcometitle = "//b[text()='Welcome to your AUL ADL Portal!']";
	public String contractSearchPagetitle = "//h3[text()='Contract Search']";
	public String editContractPagetitle = "//h3[text()='Edit Contract']";
	public String contarctInfoTxtFields1 = "//adl-contract-information-edit-card/section/div[1]/div/adl-text-input/div/div[2]/input";
	public String vehiclePurchaseTxtField = "adl-text-input[label ='Vehicle Purchase Price']>div>div:nth-child(2)>input";
	public String contactRetailPriceTxtField = "adl-text-input[label ='Contract Retail Price']>div>div:nth-child(2)>input";
	public String contarctInfoTxtFields2 = "//adl-contract-information-edit-card/section/div[2]/div/adl-text-input/div/div[2]/input";
	public String coustomerInfoTxtFields = "//adl-customer-information-form/section/div[1]/div/adl-text-input/div/div[2]/input";
	public String coustomerInfoHighlighter = "//adl-customer-information-form/section/div[1]/div/adl-text-input/div/div[2]";
	public String lienholderTxtField = "//adl-typeahead/adl-text-input/div/div[2]/input";
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
}
