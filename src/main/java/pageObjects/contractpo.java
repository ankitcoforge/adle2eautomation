package pageObjects;

import utils.baseClass;

public class contractpo extends baseClass{

	/*************page object for contract page is declared ********************/
	
	//public String successMessage = "adl-success-screen > div > div:nth-child(3) >span";
	public String successMessage = "div.notification__container__message > span";
	public String textbox = "adl-text-input > div > div.text-field__input.secure > input";
	public String getProducts = "//span[contains(text(),'Get Products')]";
	public String selectProgram = "//mat-checkbox/label/div";
	public String table = "//td";
	public String contract = "div.text-field__input.secure.text-field__input--prefix > input";
	public String checkbox = "//mat-checkbox";
	public String button = "//button";
	public String generateContract = "//span[contains(text(),'Proceed to generate contract(s)')]";
	public String programfirstname ="//*[contains(text(),'";
	public String programlastname = "')]";
	public String total = "adl-rate-contract-footer > footer > div.total__price.col-4_sm-6 ";
	public String qc = "adl-text-input[label='Quick Code']";
	public String businessUse = "//p[contains(text(),'Business Use')]//..";
	public String inServiceDate = "adl-text-input[label='In-Service Date']";
	public String inServiceDateTextBox = "button > span >mat-icon";
	public String phone = "adl-text-input[label='Phone Number'] > div > div.text-field__input.secure > input";
	public String newQuotelink = "//a[contains(text(),'Start New Quote')]";
	public String programNameCode = ".rate__card--rates>adl-rates-table >div >h3";
	
}
