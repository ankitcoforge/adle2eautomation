package pageObjects;

import utils.baseClass;

public class AssignDealerToSubagentPO extends baseClass{
	public String selectSubagentArrow = "//span[@class='ng-arrow-wrapper']";
	public String subAgentOptions = "//div[@role='option']/span";
	public String arrowForwardInassignDealerToSubagentPage = "//mat-icon[text()='arrow_forward']";
	public String addDealer = "//span[text()=' + Add Dealer ']";
	public String selectDealerArrow = "//span[contains(@class,'ui-multiselect-trigger-icon ui-clickable')]";
	public String btnClose = "//a[contains(@class,'ui-multiselect-close')]";
}
