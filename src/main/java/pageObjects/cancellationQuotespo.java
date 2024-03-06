package pageObjects;

import utils.baseClass;

public class cancellationQuotespo extends baseClass{
	
	public String vinTextbox = "input[type=text][placeholder=\"Last 6 of VIN\"]";
	public String validationMessage1 = ".validation >div >div > span.required-text";
	public String submit ="button[type='submit']";
	public String frontText = "adl-dealer-guard >div >p";
	public String nameTextbox = "input[placeholder=\"Contract Holder Last Name\"]";
	public String contractTextbox = "input[placeholder=\"Contract Number\"]";
	public String quoteLink = "div >a.link";
	public String cancelMileageInput = "//label[text()='Cancel Mileage']/../../div[2]/input";
	public String quoteBtn = "//button/span[text()='Quote']";
	public String cancelBtn = "//button/span[text()='Cancel']";
	public String cancelContractBtn="//button/span[text()=' Cancel Contract']";
	public String checkBox="//input[@type='checkbox']/..";
	public String completeCancellationBtn="//span[text()=' Complete Cancellation']";
	public String backBtn="//span[text()=' Complete Cancellation']/../../button/span[text()=' Complete Cancellation']";
	public String closeBtn="//mat-icon[text()='close']";
	public String quoteError="//span[contains(text(),'Error')] | //span[contains(text(),'Policy expired')]";
	public String cancellationError="//div[contains(@aria-label,'This contract cannot be cancelled online')]";
	public String elementsInError="//div[@class='overlay-container']/div/div";
	public String editBtn="//span[text()='Edit']/..";

}
