package pageActions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.GAPpo;
import utils.utilityClass;

public class GAPAction extends GAPpo{
	
	utilityClass event = new utilityClass();
	singleContractAction singleContract=new singleContractAction();
	
	public WebElement getProgramName(String programName) {
		WebElement ele = getDriver().findElement(By.xpath(programfirstname + programName + programlastname));
	return ele;
	}
	
	public WebElement getProgramCheckBox(String programName) {
		WebElement ele = getDriver().findElement(By.xpath(programfirstname + programName + programlastname + "/preceding-sibling::div"));
		return ele;
	}
	
	public void selectProgram(String programName) {

		getDriver().findElement(By.xpath(programfirstname + programName + programlastname)).isDisplayed();
		getDriver().findElement(By.xpath(programfirstname + programName + programlastname + "/preceding-sibling::div"))
				.click();

	}
	
	public WebElement getProgramHeadingAboveTable(String programName) {
		WebElement ele = getDriver().findElement(By.xpath("//div[@class='header']/h3[contains(text(),'"+programName+"')]"));
		return ele;
	}
	
//	
//	public void selectProgram(String Program) {
//	JavascriptExecutor js = ((JavascriptExecutor) driver);
//	programSelect(searchData1.get("program"));
//	if ((searchData1.get("program").contains("Absolute Reserve Care Lease"))) {
//		js.executeScript("window.scrollTo(0, 2200)");
//	}
	
	public  List<WebElement> selectDealTypeDropdownList() throws InterruptedException {
		 Thread.sleep(10000);
		 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		 return list;
	    }
	
	public void selectDropDown(String txt) throws InterruptedException {
		 Thread.sleep(1000);
		 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		 
	    for(int i=0;i<list.size();i++) {
		String text = list.get(i).getText();
		System.out.println("dropdown list is--"+text);
		if(text.contains(txt))
		{
			list.get(i).click();
			break;
		}
	 }
	 }
	
	public void selectDropDown() throws InterruptedException {
		 Thread.sleep(1000);
		 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		 
	    for(int i=0;i<list.size();i++) {
			list.get(i).click();
			break;
		}
	    Thread.sleep(1000);
	 }
	
	public WebElement selectArrow(String txt) {
		WebElement ele = getDriver().findElement(By.xpath("//adl-select[@placeholder='"+txt+"']/ng-select/div/span"));
		return ele;
	}
	
	
	public WebElement getDollarSign(String txt) {
		WebElement ele = getDriver().findElement(By.xpath("//label[text()='"+txt+"']/../../div/span/span/mat-icon"));
		return ele;
	}
	
	public WebElement getTxtField(String txtFld) throws InterruptedException {
		WebElement ele = getDriver().findElement(By.xpath("//label[text()='"+ txtFld +"']/../../div/input"));
		Thread.sleep(1000);
		return ele;
	}
	
	public List<WebElement> getTxtFields(String txtFld) throws InterruptedException {
		List<WebElement> ele = getDriver().findElements(By.xpath("//label[text()='"+ txtFld +"']/../../div/input"));
		Thread.sleep(1000);
		return ele;
	}
	
	public WebElement getCurrency(String txtFld) {
		WebElement ele = getDriver().findElement(By.xpath("//label[text()='"+ txtFld +"']/../../div/span/span/mat-icon"));
		return ele;
	}
	
	
	public WebElement getAsterisk(String txtFld) {
		WebElement ele = getDriver().findElement(By.xpath("//label[text()='"+txtFld+"']/span"));
		return ele;
	}
	
	public WebElement getErrorMsg(String txtFld) {
		WebElement ele = getDriver().findElement(By.xpath("//label[text()='"+txtFld+"']/../../div/adl-form-error/div/span"));
		return ele;
	}
	
	
	public List<WebElement> getAsteriskHeadings() {
		 List<WebElement> ele = getDriver().findElements(By.xpath(aestriskHeadingInPage));
		return ele;
	}
	
	public List<WebElement> getGridformLabels() {
		 List<WebElement> ele = getDriver().findElements(By.xpath(gridformLabels));
		return ele;
	}
	
	public void selectRateTermMonths() throws InterruptedException {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollTo(0, 700)");
		Thread.sleep(2000);
		selectArrow("Select Rate").click();
		Thread.sleep(2000);
		selectDropDown();
		Thread.sleep(2000);
		selectArrow("Select Term Months").click();
		Thread.sleep(2000);
		selectDropDown();
		Thread.sleep(2000);
	}
	
	public void enterTermFinanceMsrpAprVehicleAge(String vehicleAgeType) throws InterruptedException {
	String inputTerm=prop.getProperty("inputTerm");
	String inputFinanceAmount=prop.getProperty("inputFinanceAmount");
	String inputVehclePurchasePrice=prop.getProperty("inputVehiclePurchasePrice");
	String inputMSRP=prop.getProperty("inputMSRP");
	String inputAPR=prop.getProperty("inputAPR");
	getTxtField("Term").sendKeys(inputTerm);
	getTxtField("Finance Amount").sendKeys(inputFinanceAmount);
	Thread.sleep(2000);
//	getTxtField("Vehicle Purchase Price").clear();
	getTxtFields("Vehicle Purchase Price").get(1).sendKeys(inputVehclePurchasePrice);
	getTxtField("MSRP").sendKeys(inputMSRP);
	getTxtField("APR").sendKeys(inputAPR);
	event.element("xpath", vehicleAgeTypeArrow).click();
	Thread.sleep(2000);
	selectDropDown(vehicleAgeType);
	Thread.sleep(2000);
	}
	
	public WebElement getSelectedDateInCalanderBox(){
		WebElement ele = getDriver().findElement(By.xpath(selectedDateInCalanderBox));
		return ele;
	}
	
	public WebElement getSelectedDateTxtInCalanderBox(){
		WebElement ele = getDriver().findElement(By.xpath(selectedDateTxtInCalanderBox));
		return ele;
	}
	
	public List<WebElement> getCellesInCalender(){
		 List<WebElement> ele = getDriver().findElements(By.xpath(cells));
		return ele;
	}
	
	public List<WebElement> getOptions(){
		 List<WebElement> ele = getDriver().findElements(By.xpath(options));
		return ele;
	}
	
	public List<WebElement> getDisabledLienholderfld(){
		 List<WebElement> ele = getDriver().findElements(By.xpath(disabledLienholderfld));
		return ele;
	}
	
	public List<WebElement> getPlusIconInOptions(){
		 List<WebElement> ele = getDriver().findElements(By.xpath(plusIconInOptions));
		return ele;
	}
	
	public List<WebElement> getMinusIconInOptions(){
		 List<WebElement> ele = getDriver().findElements(By.xpath(minusIconInOptions));
		return ele;
	}
	
	
	public List<WebElement> getOptionSelectedPrice(){
		 List<WebElement> ele = getDriver().findElements(By.xpath(optionSelectedPrice));
		return ele;
	}
	
	
	public String getSelectedDateInCalander() {
		String dateselected = null;
		//String datenew = null;
		for(int i=1;i<getCellesInCalender().size();i++) {
		if(getCellesInCalender().get(i).getAttribute("aria-selected").equals("true"))
		{
			 dateselected = getSelectedDateTxtInCalanderBox().getText();
//			 DateFormat dateFormat = new SimpleDateFormat("dd");
//				 datenew = dateFormat.format(dateselected);
			 break;
		}
	}
		return dateselected;
		
	}
	
	public String createGapContract(String DealType, String vehicleAgeType) throws InterruptedException {
		String contractNumber = null;
//		try {
			event.inputfield("cssSelector", textbox, "1000", 5);
			event.inputfield("cssSelector", textbox, "1HGCY2F69PA001019", 6);
			event.clickfield("xpath", singleContract.getProducts);
			singleContract.co.programSelect("Limited Warranty");
			event.clickfield("cssSelector", singleContract.table, 0);
//			event.inputfield("cssSelector", textbox, "22723", 8);
			event.inputfield("cssSelector", singleContract.contract, "10000", 0);
			//contractNumber = driver.findElement(By.cssSelector(singleContract.contractNo)).getDomProperty("value");
			//System.out.println("Contract Number is:" + contractNumber);

//			List<WebElement> a = driver.findElements(By.cssSelector(singleContract.inServiceDate));
//			if (a.size() == 1) {
//				String a1 = driver.findElement(By.cssSelector(singleContract.inServicefield)).getAttribute("class");
//				if (!(a1.contains("disabled"))) {
//					driver.findElement(By.cssSelector(singleContract.inServiceDateTextBox)).click();
//					driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
//				}
//
//			}
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0, 1300)");
			Assert.assertEquals(singleContract.addGapLabel(), "Add GAP");
			event.element("xpath", AddGapCheckBox).click();
			Thread.sleep(2000);
			event.element("xpath", selectDealTypeArrow).click();
			Thread.sleep(1000);
			selectDropDown(DealType);
			enterTermFinanceMsrpAprVehicleAge("New");
			event.element("xpath", gapRateBtn).click();
			Thread.sleep(10000);
//			JavascriptExecutor jse=(JavascriptExecutor)driver;
//			jse.executeScript("window.scrollTo(0,2500)");
			selectRateTermMonths();
			getTxtField("Monthly Payment").sendKeys("100");
			event.inputfield("cssSelector", textbox, "10", 19);
			getTxtFields("Lienholder").get(1).sendKeys("West America Bank");
			getTxtFields("Lienholder").get(1).sendKeys(Keys.ARROW_DOWN , Keys.ENTER);
			Thread.sleep(20000);
			
			js.executeScript("window.scrollTo(0, 2500)");
			driver.findElements(By.cssSelector(textbox)).get(22).clear();
			event.inputfield("cssSelector", textbox, "tom", 22);
//			driver.findElements(By.cssSelector(textbox)).get(20).clear();
//			event.inputfield("cssSelector", textbox, "alexa", 20);
			driver.findElements(By.cssSelector(textbox)).get(24).clear();
			event.inputfield("cssSelector", textbox, "20130", 24);
			driver.findElements(By.cssSelector(textbox)).get(23).clear();
			event.inputfield("cssSelector", textbox, "Address", 23);
			driver.findElements(By.cssSelector(textbox)).get(26).clear();
			event.inputfield("cssSelector", textbox, "test@gmail.com", 26);
			Thread.sleep(2000);
			event.clearfield("cssSelector", singleContract.phone);
			event.inputfield("cssSelector", singleContract.phone, "1234567890");
			event.clickfield("xpath", singleContract.generateContract);
			getDriver().findElement(By.xpath(singleContract.gc.generateContractHeading)).isDisplayed();
			Thread.sleep(2000);
			event.clickfield("cssSelector", singleContract.gc.checkbox, 0);
			event.clickfield("cssSelector", singleContract.gc.checkbox, 1);
			event.clickfield("xpath",singleContract.gc.genrateContractButton);
			Thread.sleep(20000);
//			String text1 = event.text("cssSelector", singleContract.successMessage);
//			Assert.assertTrue(text1, "You have successfully generated a contract!");
		//	event.clickfield("xpath", singleContract.newQuotelink);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return contractNumber;
	}

	

	
}
