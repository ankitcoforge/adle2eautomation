package pageObjects;

import utils.baseClass;

public class GAPpo extends baseClass {
	
	public String results = "//p[@class='information__header']";
	public String makeModelYear= "//h3[@class='information__makeModelYear']";
	public String manufacturerPowerTrainWarranty= "(//p[@class='information__warranty'])[1]";
	public String fullFactoryWarranty= "(//p[@class='information__warranty'])[2]";
	public String chooseTwoPrograms = "//p[contains(@class,'programs__section col')]";
	public String programfirstname ="//*[contains(text(),'";
	public String programlastname = "')]";
	public String  markupforProgram= "//div[@class='header']/div/span";
	public String classForprograms = "//p/span[contains(text(),'Class')]";
	public String liftkitInContractpage = "//p[contains(text(),'Lift Kit')]";
	public String termMileageMonthsInContractPage = "[class='cell']>span";
	public String classes = "//span[contains(text(),'Class')]/..";
	public String reserve = "//p[text()='RESERVE']";
	public String powertrain = "//p[text()='POWERTRAIN']";
	public String sterling = "//p[text()='STERLING']";
	public String estate = "//p[text()='ESTATE']";
	public String termMileageMonthsInContractPageTxt= "//button[@aria-label='Change sorting for term']/p";
	public String AddGapCheckBox = "//adl-checkbox[@label='Add GAP']/div/mat-checkbox/label/div";
	public String AddGapCheckBoxStatus = "//adl-checkbox[@label='Add GAP']/div/mat-checkbox/label/div/input";
	public String roleDropdownList = "//div[@class='scrollable-content']/div";
	public String selectDealTypeArrow = "//div[text()='Select Deal Type']/../../span";
	public String vehicleAgeTypeArrow = "//label[text()='Vehicle Age Type']/../../ng-select/div/span";
	public String gapRateBtn = "//span[text()='Get GAP Rate']/..";
	public String selectDealTypeTxt = "//div[text()='Select Deal Type']";
	public String adlGapForm=  "//adl-gap-form[@class='gap__form ng-star-inserted']";
	public String aprSign=  "//label[text()='APR']/../../div/span/span";
	public String requiredErrorMsg = "//span[text()='Required']";
	public String leinholderInGapForm = "(//label[text()='Lienholder'])[2]";
	public String gapRetailPriceTxtBox = "//strong[text()='GAP Retail Price']/../adl-text-input/div/div/input";
	public String aestriskHeadingInPage = "//div[@class='col-2_xs-6']//span[text()='*']/..";
	//public String calanderbtn="//button[@type='button']/span/mat-icon";
	public String calanderbtn="//button[contains(@class,'calendar ng-star-inserted')]/span/mat-icon";
	public String cells="//tr/td";
	public String selectedDateInCalanderBox="//tr/td[@aria-selected='true']";
	public String selectedDateTxtInCalanderBox="//tr/td[@aria-selected='true']/div";
	public String errorMsgNoProgramsAvailable="//div[@class='error']";
	public String textbox = "adl-text-input > div > div.text-field__input.secure > input";
	public String totalPriceNew = "//div[@class='total__price col-4_sm-6']";
	public String options = "//adl-option-card/div";
	public String plusIconInOptions = "//mat-icon[text()='add_circle']";
	public String minusIconInOptions = "//mat-icon[text()='remove_circle_outline']";
	public String optionSelectedPrice = "//div[@class='card']/div/span";
	public String editSearch = "//div[contains(@class,'gap__button')]/button/span";
	public String genrateContractButton = "//span[contains(text(),'Proceed to generate contract(s)')]";
	public String gridformLabels = "//div[@class='grid form']//label";
	public String lienholderAddressArrow = "//div[text()='Select Address']/../../span";
	public String lienholderAddressTxtfld = "//div[text()='Select Address']/../div[2]/span[2]";
	public String lienholderAddressStatus = "//div[text()='Select Address']/../div[2]/input";
	public String lienholderAddressStatus1 = "//div[text()='Select Address']/../div[2]";
	public String disabledLienholderfld = "//div[@class='text-field__input secure text-field__input--disabled']/input[@placeholder='Type & Select a Lienholder']";
	public String notOnTheListLink = "//a[text()=' Not on the list ']";
	public String table = "adl-rates-table > table >tbody > tr:nth-child(1) > td:nth-child(2)";
	
}
