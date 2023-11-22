package pageObjects;

import utils.baseClass;

public class MyCommissionsPO extends baseClass{
	
	public String CoustNameNumVIN = "//input[@placeholder='Contract Number, Customer Last Name or VIN']";
	public String yearArrow= "//adl-select[@class='sel-year ng-star-inserted']/ng-select/div/span";
	public String monthArrow= "//adl-select[@class='sel-month ng-star-inserted']/ng-select/div/span";
	public String arrowForward= "//mat-icon[text()='arrow_forward']";
	public String rows = "//table/tbody/tr";
	public String myCommissionsTitle = "//h3[text()='My Commissions']";

}
