package pageObjects;

import utils.baseClass;

public class UniversalLendersPO extends baseClass{
	
	public String roleDropdownList = "//mat-option/span";
	public String radioButtonForPrograms = "//div[@class='mat-radio-outer-circle']";
	public String programfirstname ="//*[contains(text(),'";
	public String programlastname = "')]";
	public String totalTxt ="//div[@class='total__price col-4_sm-6']/span";
	public String totalValue ="//div[@class='total__price col-4_sm-6']";
	public String nextButton ="//button/span[text()='Next']";
	public String retailPrice ="//label[text()='Retail Price']";
	public String tax ="//label[text()='Tax']";
	public String surchargesErrorMsg ="//SPAN[contains(text(),'You have to either select a surcharge')]";
	public String overrideContractNoCheckbox = "//adl-checkbox[@label='Override Contract Number']/div/mat-checkbox/label/div/input";
	
}
