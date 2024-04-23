package pageObjects;

import utils.baseClass;

public class PacksPassthroughPO extends baseClass{
	
	//show pack model or popup
	public String arrowInshowpackModel="//adl-modal-container//p-multiselect/div/div[3]/span";
	public String packOtionsInpopup = "//div[@class='ui-chkbox ui-widget']/../div/span[@class='options--label']";
	
	public String selectAccountInMydealerPassthroughPage = "//input[@placeholder='Type or Select Dealer Passthrough name']";
	public String selectAccountInMyLenderPassthroughPage = "//input[@placeholder='Type or Select Lender Passthrough name']";
	public String selectAccountInMyMyAgentPacksPage = "//input[@placeholder='Type or Select Agent Pack Name']";
	public String dealerAgentpackOptions = "//span[@class='item__name']";

}
