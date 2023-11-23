package pageObjects;

import utils.baseClass;

public class cancellationQuotespo extends baseClass{
	
	public String vinTextbox = "input[type=text][placeholder=\"Last 6 of VIN\"]";
	public String validationMessage1 = ".validation >div >div > span.required-text";
	public String submit ="button[type='submit']";
	public String frontText = "adl-dealer-guard >div >p";
	public String nameTextbox = "input[placeholder=\"Contract Holder Last Name\"]";
	public String contractTextbox = "input[placeholder=\"Contract Number\"]";
	public String quote = "div >a.link";
	public String disclaimer  ="adl-dealer-guard>div >div >span";
	public String tableText = "tr >td.empty";
	public String modelBox = ".cdk-overlay-pane";
	public String contractNumber1 = "header > h4";
	public String cancelDate = "button.calendar > span > mat-icon";
	public String cancelLabel = "adl-text-input[type =\"datepicker\"] > div> div >label";
	public String initiatedBy = ".mat-radio-button.quote_initiated_radio";
	public String initiatedByLabel = ".mat-radio-button.quote_initiated_radio >label >div.mat-radio-label-content";
	public String cancelReasonText = ".quote_reason_options >span";
	public String cancelReason = ".mat-radio-button.quote_reason_radio";
	public String cancelReasonLabel = ".mat-radio-button.quote_reason_radio >label >div.mat-radio-label-content";
	public String mileage = ".quote_mileage> adl-text-input>div [type='text']";
	public String cancelMileage = ".quote_mileage> adl-text-input>div >div > label";
	public String quoteButton = "button[type='submit'] > span";
	public String cancelButton = "button[type='button'].quote_btn_cancel > span";
	public String retailPrice = "adl-text-input[label ='Retail Price'] input[type='text']";
	public String validationMessage = "adl-form-error >div > span";
	public String close = "button[aria-label = 'Close']";
	public String printGenerateQuote = ".action_btn >button[type='button'] > span";
	public String quoteClose = ".actions >button[type='button'] > span";
	public String edit = "#overlayForm >button[type='button'] > span";
	
	

}
