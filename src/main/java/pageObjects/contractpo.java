package pageObjects;

import utils.baseClass;

public class contractpo extends baseClass{

	/*************page object for contract page is declared ********************/
	
	public String successMessage = ".notification__container__message >span";
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
	
}
