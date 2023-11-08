package pageObjects;

import utils.baseClass;

public class QuickCodeMarkupAListLienholderPO extends baseClass{
	
	public String quickCode = "//label[text()='Quick Code']/../../div[2]/input";
	public String lienholder = "//label[text()='Lienholder']/../../div/input";
	public String partner = "//span[text()='Partner']";
	public String elementsInRateContractPage = "//div/div/input/../../div/label";
	public String textbox = "adl-text-input > div > div.text-field__input.secure > input";
	public String getProducts = "//span[contains(text(),'Get Products')]";
	public String SCtogglebar = "//div[@class='mat-slide-toggle-bar']/input";
	public String editSearch = "//span[text()='Edit Search']/..";
}
