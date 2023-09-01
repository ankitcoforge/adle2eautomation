package pageObjects;

import utils.baseClass;

public class ActuarialReportPO extends baseClass{
	
	public String timeframePlaceholder = "//div[@class='ng-input']";
	public String fromAndToField = "small>b";
	public String fromAndToFieldPositionedAfterTimeFrame = "//h5[text()='Timeframe']/../small/b";
	public String remitMonthGraph = "//canvas[@class='chartjs-render-monitor']";
	public String remitMonthTxt = "//h4[text()='Remit Month (Recent Activity)']";
	public String dealerProgramGrid = "[class='ui-table-wrapper ng-star-inserted']";
	public String remitYearInception = "//h4[text()='Remit Year (Inception)']";
	public String remitYearInceptionGraph = "//canvas[@class='ng-star-inserted chartjs-render-monitor']";
	public String searchPlaceholder = "//input[@placeholder='Search']";
	public String searchBarBelowTheDescriptionTxt = "//p/../adl-table/p-table/div/div/div/div/section/input";
	public String noRecords = "//td[text()=' There are no records to display ']";
	
	

}
