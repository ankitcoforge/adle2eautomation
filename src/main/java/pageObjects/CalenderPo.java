package pageObjects;

import utils.baseClass;

public class CalenderPo extends baseClass{

	public String calenderTxtbox = "//*[contains(@class,'mat-form-field-infix ng-tns')]";
	public String currentMonthandYear = "//button[@aria-label='Choose month and year']/span";
	public String previousArrow =  "//button[@aria-label='Previous month']";
	public String NextArrow =  "//button[@aria-label='Next month']";
}
