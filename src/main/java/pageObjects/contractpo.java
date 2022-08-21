package pageObjects;

import utils.baseClass;

public class contractpo extends baseClass{

	/*************page object for contract page is declared ********************/
	
	//public String successMessage = "adl-success-screen > div > div:nth-child(3) >span";
	public String successMessage = "div.notification__container__message > span";
	public String textbox = "adl-text-input > div > div.text-field__input.secure > input";
	public String getProducts = "//span[contains(text(),'Get Products')]";
	public String selectProgram = "//mat-checkbox/label/div";
	public String table = "adl-rates-table > table >tbody > tr:nth-child(1) > td:nth-child(2)";
	public String datepicker = "adl-text-input[label='In-Service Date'] >div :nth-child(2) >input";
	public String contract = "div.text-field__input.secure.text-field__input--prefix > input";
	public String checkbox = "//mat-checkbox";
	public String button = "//button";
	public String generateContract = "//span[contains(text(),'Proceed to generate contract(s)')]";
	public String programfirstname ="//*[contains(text(),'";
	public String programlastname = "')]";
	public String total = "adl-rate-contract-footer > footer > div.total__price.col-4_sm-6 ";
	public String qc = "adl-text-input[label='Quick Code']";
	public String businessUse = "//p[contains(text(),'Business Use')]";
	public String noSurcharge = "//span[contains(text(),'No Surcharges')]//..//div//input";
	public String inServiceDate = "adl-text-input[label='In-Service Date']";
	public String inServiceDateTextBox = "button > span >mat-icon";
	public String phone = "adl-text-input[label='Phone Number'] > div > div.text-field__input.secure > input";
	public String newQuotelink = "//a[contains(text(),'Start New Quote')]";
	public String programNameCode = ".rate__card--rates>adl-rates-table >div >h3";
	public String zipcode = "//label[contains(text(),'Zip Code')]//..//..//div//input";
	public String address = "//label[contains(text(),'Address')]//..//..//div//input";
	public String phoneno = "//label[contains(text(),'Phone Number')]//..//..//div//input";
	public String noVin = "adl-checkbox[label=\"No VIN\"]";
	public String state = "adl-select[label=\"State\"]";
	public String mandatoryState = "adl-select[label=\"State\"] >div > label >span";
	public String dropdownState = "ng-select-container";
	public String businessUseCheckbox = "adl-checkbox[label=\"Business Use\"] >div >mat-checkbox > label >div >input[type=\"checkbox\"]";
	public String vinTextbox = "adl-text-input[label=\"VIN\"] >div >div >input";
	public String mileage = "adl-text-input[label=\"Mileage\"] >div >div >input";
	public String getProductsButton = "button[type=\"submit\"]";
	public String programCheckbox = "div[class=\"programs__checkboxes col-12 grid ng-star-inserted\"] >adl-checkbox";
	public String coBuyer = ".customer__hascobuyer >adl-checkbox > div > mat-checkbox >label> div > input[type='checkbox']";
	public String fieldbyLabelName(String label) {
		
		return "adl-text-input[label =\"" + label + "\"]>div >div:nth-child(2) >input";
	}
	
	
}
