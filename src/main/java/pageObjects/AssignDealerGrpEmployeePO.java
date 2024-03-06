package pageObjects;

import utils.baseClass;

public class AssignDealerGrpEmployeePO extends baseClass{
	
	public String selectDealerGrpEmployeeArrow = "//span[@class='ng-arrow-wrapper']";
	public String dealerGrpEmpOptions = "//div[@role='option']/span";
	public String arrowForwardInassignDealerToDealerGrpEmpPage = "//mat-icon[text()='arrow_forward']";
	public String addDealer = "//span[text()=' + Add Dealer ']";
	public String selectDealerArrow = "//span[contains(@class,'ui-multiselect-trigger-icon ui-clickable')]";
	public String btnClose = "//a[contains(@class,'ui-multiselect-close')]";
	public String rowLoc = "table>tbody>tr";
	public String selectAllChckbox = "//mat-checkbox[contains(@id,'mat-checkbox')]";
	public String numOfPages = "span>a";
	public String btnNo = "//button/span[contains(text(),'No')]";

}
