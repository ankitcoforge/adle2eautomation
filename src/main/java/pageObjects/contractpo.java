package pageObjects;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.baseClass;
import utils.utilityClass;

public class contractpo extends baseClass{

	utilityClass event = new utilityClass();
	/*************page object for contract page is declared ********************/
	
	//public String successMessage = "adl-success-screen > div > div:nth-child(3) >span";
	public String successMessage = "div.notification__container__message > span";
	public String textbox = "adl-text-input > div > div.text-field__input.secure > input";
	public String getProducts = "//span[contains(text(),'Get Products')]";
	public String editProducts = "//span[contains(text(),'Edit Search')]";
	public String selectProgram = "//mat-checkbox/label/div";
	public String table = "adl-rates-table > table >tbody > tr:nth-child(1) > td:nth-child(2)";
	public String tableborder = "adl-rates-table > table >tbody > tr:nth-child(1) > td:nth-child(2)> div";
	public String datepicker = "adl-text-input[label='In-Service Date'] >div :nth-child(2) >input";
//	public String contract = "div.text-field__input.secure.text-field__input--prefix > input";
	public String contract = " adl-text-input[label='Vehicle Purchase Price'] > div > div:nth-child(2) > input";
	public String leaseMonths = "adl-lease-term >div >div> span";
	public String leaseWarning = "adl-warning-message >div > p>span";
	public String leaseMiles = "adl-lease-term >div >div> span";
	public String checkbox = "//mat-checkbox";
	public String leaseLabel = "adl-lease-term >div >div> span";
	public String button = "//button";
	public String generateContract = "//span[contains(text(),'Proceed to generate contract(s)')]";
	public String programfirstname ="//*[contains(text(),'";
	public String programlastname = "')]";
	public String total = "adl-rate-contract-footer > footer > div.total__price.col-4_sm-6 ";
	public String qc = "adl-text-input[label='Quick Code']";
	public String businessUse = "//p[contains(text(),'Business Use')]";
	public String noSurcharge = "//span[contains(text(),'No Surcharges')]//..//div//input";
	public String inServiceDate = "adl-text-input[label='In-Service Date']";
	public String inServiceDateTextBox = "button > span >mat-icon";
	public String phone = "adl-text-input[label='Phone Number'] > div > div.text-field__input.secure > input";
	public String newQuotelink = "div.notification__container__actions > a.ng-star-inserted:nth-child(3)";
	public String programNameCode = ".rate__card--rates>adl-rates-table >div >h3";
	public String zipcode = "//label[contains(text(),'Zip Code')]//..//..//div//input";
	public String Zipcode ="[label='Zip Code'] >div >div:nth-child(2) >input";
	public String address = "//label[contains(text(),'Address')]//..//..//div//input";
	public String Address = "[label='Address'] >div >div:nth-child(2) >input";
	public String Email = "[label='Email'] >div >div:nth-child(2) >input";
	public String phoneno = "//label[contains(text(),'Phone Number')]//..//..//div//input";
	public String noVin = "adl-checkbox[label=\"No VIN\"]";
	public String state = "adl-select[label=\"State\"]";
	public String mandatoryState = "adl-select[label=\"State\"] >div > label >span";
	public String dropdownState = "ng-select-container";
	public String businessUseCheckbox = "adl-checkbox[label=\"Business Use\"] >div >mat-checkbox > label >div >input[type=\"checkbox\"]";
	public String vinTextbox = "adl-text-input[label=\"VIN\"] >div >div >input";
	public String mileage = "adl-text-input[label=\"Mileage\"] >div >div >input";
	public String getProductsButton = "button[type=\"submit\"]";
	public String programCheckbox = "div[class=\"programs__checkboxes col-12 grid ng-star-inserted\"] >adl-checkbox";
	public String coBuyer = ".customer__hascobuyer >adl-checkbox > div > mat-checkbox >label> div > input[type='checkbox']";
	public String goToQuote = ".notification__container__actions > a:nth-child(3)";
	public String monthDropdown = "adl-select[placeholder=\"Select Months\"]>ng-select";
	public String milesDropdown = "adl-select[placeholder=\"Select Miles\"]>ng-select";
	public String optionFirst = ".ng-dropdown-panel-items > div > div";
	public String contractNo = "div input[disabled][maxlength='16']";
	public String overideContractNo = "adl-checkbox[label =\"Override Contract Number\"]";
	public String overideContractNoCheckbox = "adl-checkbox[label ='Override Contract Number'] >div > mat-checkbox >label > div";
	public String retailPrice = "adl-text-input[label =\"Contract Retail Price\"]";
	public String retailPriceTextBox = "adl-text-input[label =\"Contract Retail Price\"] > div > div:nth-child(2) >input";
	public String vehiclePurchasePrice = "adl-text-input[label =\"Vehicle Purchase Price\"]";
	public String totalFooter = "div.total__price";
	public String required = ".error-anchor >span";
	public String inServicefield = "adl-text-input[label='In-Service Date'] >div  >div + div";
	public String warningMessage = "adl-warning-message >div > p>span";
	public String addGap = "div.gap__title >adl-checkbox";
	public String noSurcharges = "adl-checkbox[label= \"No Surcharges\"] > div >mat-checkbox > label >div";
	public String inServiceTextBox = "adl-text-input[label =\"In-Service Date\"] >div >div:nth-child(2) >input";
	public String sppNext = ".grid >div:nth-child(4) >button";
	public String gapCheckbox = "div.gap__title >adl-checkbox > div >mat-checkbox > label > div";
	public String getGapButton = ".gap__button > button > span";
	public String lienHolder = "[label =\"Lienholder\"]>adl-text-input >div >div:nth-child(2) >input";
	public String lienholderOption ="div[role='listbox']>mat-option";
	public String partner = "div[role='listbox']>mat-option>span>.option__suffix";
	public String notInTheList = "div > a";
	public String labelDealNumber = "adl-text-input[label=\"Deal Number\"]";
	public String labelVPP = "adl-text-input[label=\"Vehicle Purchase Price\"]";
	public String labelCRP = "adl-text-input[label=\"Contract Retail Price\"]";
	public String slideToggle = "adl-slide-toggle";
	public String saveQuoteButton = "//span[contains(text(),'Save Quote')]//..";
	public String printQuoteButton = "//span[contains(text(),'Print Quote')]//..";
	public String warningLabel =".warning__label";
	public String headerMarkUp = "div.header__markup > span";
	public String noVIN  = "//span[contains(text(),'No VIN')]//../div";
	public String year = "input[placeholder=\"Type & Select\"]";
	public String make  ="adl-typeahead[label='Make'] >adl-text-input > div>div >input";
	public String wdfield = "//span[contains(text(),'AWD/4WD')]//../div";
	public String selectDealerTogenerateContract = "//input[@placeholder='Type or Select Dealer Name']";
	public String btnSignIn = "//span[text()='Sign In']";
	public String pincode = "adl-text-input[label='Zip Code'] > div > div.text-field__input.secure > input";
	public String email = "adl-text-input[label='Email'] > div > div.text-field__input.secure > input";
	
	public WebElement getBtnSignIn() {
		WebElement ele = driver.findElement(By.xpath(btnSignIn));	
		 return ele; 
	 }
	
	public void checkGAP() {
		
	      driver.findElement(By.cssSelector(gapCheckbox)).click();
	}
	
	public String fieldlength() {
		
		return driver.findElement(By.cssSelector(inServiceTextBox)).getAttribute("maxlength");
	}
	
	public void dealerList(String dealerName) {
		
		List<WebElement> l = driver.findElements(By.cssSelector("span.dealer__name"));
		for(int i =0; i <l.size(); i++) {
			if(l.get(i).getText().contains(dealerName)) {
				l.get(i).click();
			}
		}
		
		driver.findElement(By.cssSelector("button[color='primary'] > span.mat-button-wrapper")).click();
	}
	
	
	public String fieldbyLabelName(String label) {
		
		return "adl-text-input[label =\"" + label + "\"]>div >div:nth-child(2) >input";
	}
	
	public String typeaheadbyLabelName(String label) {
		
		return "adl-typeahead[label='" + label + "'] >adl-text-input > div> div >input";
	}
	
	public int length(String field) {
		
		return driver.findElements(By.cssSelector(field)).size();
	}
	
	public String warningTextMesssage() {
		
		return driver.findElement(By.cssSelector(warningMessage)).getText();
	}
	
	public String addGapLabel() {
		
		return driver.findElement(By.cssSelector(addGap)).getAttribute("label");
	}
	
	public String getGapRateButton() {
		
		return driver.findElement(By.cssSelector(getGapButton)).getText();
	}
	
	public void leaseProgram(){
		Assert.assertEquals(driver.findElements(By.cssSelector(leaseMonths)).get(0).getText(), "Lease Term Months:");
		Assert.assertEquals(driver.findElements(By.cssSelector("adl-lease-term >div >div> span")).get(1).getText(), "Lease Term Miles:");
		driver.findElement(By.cssSelector("adl-select[placeholder=\"Select Months\"]>ng-select")).click();
		driver.findElement(By.cssSelector(".ng-dropdown-panel-items > div > div")).click();
		driver.findElement(By.cssSelector("adl-select[placeholder=\"Select Miles\"]>ng-select")).click();
		driver.findElement(By.cssSelector(".ng-dropdown-panel-items > div > div")).click();
		Assert.assertEquals(warningTextMesssage(), "Please select the rate in the table.");
	}
	
	public void filladdress() {
		
		driver.findElements(By.cssSelector(textbox)).get(14).clear();
		event.inputfield("cssSelector", textbox, "20130", 14);
		driver.findElements(By.cssSelector(textbox)).get(13).clear();
		event.inputfield("cssSelector", textbox, "Address", 13);
		event.clearfield("cssSelector", phone);
		event.inputfield("cssSelector", phone, "1234567890");
		event.clickfield("xpath", generateContract);
	}
	
	public String[] getProgramCodeName() {
		
		String header = event.text("cssSelector", programNameCode);
		String[] program = header.split(" • ");
		return (program );
	}
	
	public void selectOptionSurcharge() {
		List<WebElement> card = driver.findElements(By.cssSelector("div.card"));
		System.out.println(card.size());
		if(card.size() != 0) {
			for(int x =0; x<card.size(); x++) {
				String selection = card.get(x).getAttribute("Class");
				if(!(selection.contains("card--selected"))) {
					WebElement element = new WebDriverWait(driver, Duration.ofSeconds(9)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.card")));
					card.get(x).click();
				}
				
			}
		}
		
	}
	
	public void inserviceDate() {
		List<WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
		if (a.size() == 1) {
			String a1 = driver
					.findElement(By.cssSelector(inServicefield))
					.getAttribute("class");
			if (!(a1.contains("disabled"))) {
				driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
				driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
			}

		}
	}
	
	
}
