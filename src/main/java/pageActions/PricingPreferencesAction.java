package pageActions;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.PricingPreferencesPO;
import utils.utilityClass;

public class PricingPreferencesAction extends PricingPreferencesPO{
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();
	singleContractAction contractNew =new singleContractAction();
	generateContractAction gc = new generateContractAction();
	pageActions.ManageVSC_GAPpreferencesAction ManageVSCGAP=new pageActions.ManageVSC_GAPpreferencesAction();
	 createContractAction co = new createContractAction();
	
	 public WebElement getPortalTitle() {
		 WebElement welcomeTitle=driver.findElement(By.xpath(portalTitle));	
		 return welcomeTitle;
	 }
	 
	 public List<String> getAllHeaderNames() {
		 List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
         return allHeaderNames;
	 }
	 
	 public List<String> getAllHeaderNamesInHistoryTable() {
		 List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", historyTableHeaderLoc);
         return allHeaderNames;
	 }
	 
	 public List<WebElement> getDropDwnList() throws InterruptedException {
			 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
			 for(int i=1;i<list.size();i++) {
					String text = list.get(i).getText();
					System.out.println("Progms list is--"+text);
			 }
			 return list;
		}
	 
//	 public List<WebElement> getRadioBtns() {
//		 List<WebElement> radioBtns = getDriver().findElements(By.xpath(markupRadioBtn));
//         return radioBtns;
//	 }
	 
	 
	 public WebElement getMarkupAmountDollarSign() {
		 WebElement amountSign=driver.findElement(By.xpath(markupAmountDollarSign));	
		 return amountSign;
	 }
	 
	 public WebElement getMarkupAmountPercentSign() {
		 WebElement amountSign=driver.findElement(By.xpath(markupAmountPercentSign));	
		 return amountSign;
	 }
	 
	 public List<WebElement> getMarkupTxts() {
		 List<WebElement> amountSign=driver.findElements(By.xpath(markupTxts));	
		 return amountSign;
	 }
	 
	 public List<WebElement> getBtnsmarkup() {
		 List<WebElement> markupbtns=driver.findElements(By.cssSelector(btnsmarkup));	
		 return markupbtns;
	 }
	 
	 public List<WebElement> getMarkupAmountTxtFld() {
		 List<WebElement> markupAmountTxtFlds=driver.findElements(By.xpath(markupAmountTxtFldForFlatType));	
		 return markupAmountTxtFlds;
	 }
	 
	
	 public WebElement mileageSelectionInRateorConrtactPage(String termMonth) {
		 WebElement termMonths = driver.findElement(By.xpath("//td/div/span[contains(text(),'"+termMonth+"')]/../../../td/div[@class='cell cell--price']/span"));	
		 return termMonths; 
	 }
	 
	
	 public WebElement getTxtFldForClassCoverageMileageTermMonthFlat(String selectedClass) {
		 WebElement classs = driver.findElement(By.xpath("//label/span[text()='"+selectedClass+"']/../../adl-text-input/div/div[@class='text-field__input secure text-field__input--prefix']/input"));	
		 return classs; 
	 }
	 
	 public WebElement getTxtFldForClassCoverageMileageTermMonthPercent(String selectedClass) {
		 WebElement classs = driver.findElement(By.xpath("//label/span[text()='"+selectedClass+"']/../../adl-text-input/div/div[@class='text-field__input secure text-field__input--suffix']/input"));	
		 return classs; 
	 }
	 
	 public List<WebElement> getMultipleTxtFldForClassFlat(String selectedClass) {
		 List<WebElement> classs = driver.findElements(By.xpath("//label/span[text()='"+selectedClass+"']/../../adl-text-input/div/div[@class='text-field__input secure text-field__input--prefix']/input"));	
		 return classs; 
	 }
	 
	 public List<WebElement> getMultipleTxtFldForClassPercent(String selectedClass) {
		 List<WebElement> classs = driver.findElements(By.xpath("//label/span[text()='"+selectedClass+"']/../../adl-text-input/div/div[@class='text-field__input secure text-field__input--suffix']/input"));	
		 return classs; 
	 }
	 
	 public List<WebElement> getMarkupAmountTxtFldForPercentage() {
		 List<WebElement> markupAmountTxtFlds=driver.findElements(By.xpath(markupAmountTxtFldForPercentage));	
		 return markupAmountTxtFlds;
	 }
	 
	 public WebElement getSelectAllCheckBox() {
		 WebElement selectAll=driver.findElement(By.cssSelector(selectAllCheckBox));	
		 return selectAll;
	 }
	 
	 public WebElement getNoRecordsInGrid() {
		  WebElement rows = driver.findElement(By.cssSelector(noRecordsInGrid));	
		 return rows; 
	 }
	 
	 public WebElement getLiftKit() {
		  WebElement rows = driver.findElement(By.xpath(liftkit));	
		 return rows; 
	 }
	 
	 public WebElement getLiftKitStatus() {
		  WebElement rows = driver.findElement(By.xpath(liftkitSelectionStatus));	
		 return rows; 
	 }
	 
	 public String singleContract() throws InterruptedException {
		 Thread.sleep(2000);
			utils.clickfield("cssSelector", table, 0);
			Thread.sleep(5000);
			utils.scrollDown();
			utils.inputfield("cssSelector", textbox, "22723", 7);
			utils.inputfield("cssSelector", contract, "10000", 0);
			Thread.sleep(1000);
			//utils.clickfield("xpath", noSurchargesChkbx);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			if(!getLiftKitStatus().isSelected()) {
			js.executeScript("arguments[0].scrollIntoView();", getLiftKit());
			js.executeScript("arguments[0].click();", getLiftKit());
			}
			//utils.clickfield("xpath", liftkit);
//			utils.clickfield("xpath", businessUse);
			String contractNumber = driver.findElement(By.cssSelector(contractNo)).getDomProperty("value");
			System.out.println("Contract Number is:"+contractNumber);
			
			List <WebElement> a = driver.findElements(By.cssSelector(contractNew.inServiceDate));
			if(a.size() == 1) {
				String a1  = driver.findElement(By.cssSelector(contractNew.inServicefield)).getAttribute("class");
				if(!(a1.contains("disabled"))) {
					driver.findElement(By.cssSelector(contractNew.inServiceDateTextBox)).click();
					driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
				}
				
			}
			//Assert.assertEquals(contractNew.addGapLabel(), "Add GAP");

			driver.findElements(By.cssSelector(pincode)).get(0).clear();
			utils.inputfield("cssSelector", pincode, "20130", 0);
			driver.findElements(By.cssSelector(address)).get(0).clear();
			utils.inputfield("cssSelector", address, "Address", 0);
			driver.findElements(By.cssSelector(email)).get(0).clear();
			utils.inputfield("cssSelector", email, "test@gmail.com", 0);
			Thread.sleep(2000);
			utils.clearfield("cssSelector", contractNew.phone);
			utils.inputfield("cssSelector", contractNew.phone, "1234567890");
			utils.clickfield("xpath", contractNew.generateContract);
			getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
			utils.wait(2000);
			utils.clickfield("cssSelector", gc.checkbox, 0);
			utils.clickfield("cssSelector", gc.checkbox, 1);
			utils.wait(2000);
			utils.clickfield("xpath", gc.genrateContractButton);
			Thread.sleep(10000);
			String text1 = utils.text("cssSelector", contractNew.successMessage);
			Assert.assertEquals(text1, "You have successfully generated a contract!");
			utils.clickfield("cssSelector", contractNew.newQuotelink);
			return contractNumber;
			}

	 public String singleContractForTermMonth(String termMonth) throws InterruptedException {
		 Thread.sleep(2000);
		 mileageSelectionInRateorConrtactPage(termMonth).click();
			Thread.sleep(5000);
			utils.scrollDown();
			utils.inputfield("cssSelector", textbox, "22723", 7);
			utils.inputfield("cssSelector", contract, "10000", 0);
			Thread.sleep(1000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			if(!getLiftKitStatus().isSelected()) {
			js.executeScript("arguments[0].scrollIntoView();", getLiftKit());
			js.executeScript("arguments[0].click();", getLiftKit());
			}
			//utils.clickfield("xpath", liftkit);
//			utils.clickfield("xpath", businessUse);
			String contractNumber = driver.findElement(By.cssSelector(contractNo)).getDomProperty("value");
			System.out.println("Contract Number is:"+contractNumber);
			
			List <WebElement> a = driver.findElements(By.cssSelector(contractNew.inServiceDate));
			if(a.size() == 1) {
				String a1  = driver.findElement(By.cssSelector(contractNew.inServicefield)).getAttribute("class");
				if(!(a1.contains("disabled"))) {
					driver.findElement(By.cssSelector(contractNew.inServiceDateTextBox)).click();
					driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
				}
				
			}
			driver.findElements(By.cssSelector(pincode)).get(0).clear();
			utils.inputfield("cssSelector", pincode, "20130", 0);
			driver.findElements(By.cssSelector(address)).get(0).clear();
			utils.inputfield("cssSelector", address, "Address", 0);
			driver.findElements(By.cssSelector(email)).get(0).clear();
			utils.inputfield("cssSelector", email, "test@gmail.com", 0);
			Thread.sleep(2000);
			utils.clearfield("cssSelector", contractNew.phone);
			utils.inputfield("cssSelector", contractNew.phone, "1234567890");
			utils.clickfield("xpath", contractNew.generateContract);
			getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
			utils.wait(2000);
			utils.clickfield("cssSelector", gc.checkbox, 0);
			utils.clickfield("cssSelector", gc.checkbox, 1);
			utils.wait(2000);
			utils.clickfield("xpath", gc.genrateContractButton);
			Thread.sleep(10000);
			String text1 = utils.text("cssSelector", contractNew.successMessage);
			Assert.assertEquals(text1, "You have successfully generated a contract!");
			utils.clickfield("cssSelector", contractNew.newQuotelink);
			return contractNumber;
			}

	 
	 public String singleContractForLender() throws InterruptedException {
		 Thread.sleep(2000);
		 
			utils.clickfield("cssSelector", table, 0);
			Thread.sleep(5000);
			utils.scrollDown();
			utils.inputfield("cssSelector", textbox, "22723", 7);
			utils.inputfield("cssSelector", contract, "10000", 0);
			Thread.sleep(1000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			if(!getLiftKitStatus().isSelected()) {
			js.executeScript("arguments[0].scrollIntoView();", getLiftKit());
			js.executeScript("arguments[0].click();", getLiftKit());
			}
			//utils.clickfield("xpath", liftkit);
//			utils.clickfield("xpath", businessUse);
			String contractNumber = driver.findElement(By.cssSelector(contractNo)).getDomProperty("value");
			System.out.println("Contract Number is:"+contractNumber);
			
			List <WebElement> a = driver.findElements(By.cssSelector(contractNew.inServiceDate));
			if(a.size() == 1) {
				String a1  = driver.findElement(By.cssSelector(contractNew.inServicefield)).getAttribute("class");
				if(!(a1.contains("disabled"))) {
					driver.findElement(By.cssSelector(contractNew.inServiceDateTextBox)).click();
					driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
				}
				
			}
			//Assert.assertEquals(contractNew.addGapLabel(), "Add GAP");

			driver.findElements(By.cssSelector(pincode)).get(0).clear();
			utils.inputfield("cssSelector", pincode, "20130", 0);
			driver.findElements(By.cssSelector(address)).get(0).clear();
			utils.inputfield("cssSelector", address, "Address", 0);
			driver.findElements(By.cssSelector(email)).get(0).clear();
			utils.inputfield("cssSelector", email, "test@gmail.com", 0);
			Thread.sleep(2000);
			utils.clearfield("cssSelector", contractNew.phone);
			utils.inputfield("cssSelector", contractNew.phone, "1234567890");
			utils.clickfield("xpath", contractNew.generateContract);
			getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
			Thread.sleep(2000);
			utils.clickfield("cssSelector", gc.checkbox, 0);
			utils.clickfield("cssSelector", gc.checkbox, 1);
			utils.clickfield("xpath", gc.genrateContractButton);
			Thread.sleep(10000);
			String text1 = utils.text("cssSelector", contractNew.successMessage);
			Assert.assertEquals(text1, "You have successfully generated a contract!");
			utils.clickfield("cssSelector", contractNew.newQuotelink);
			return contractNumber;
			}
	 
	 public WebElement getArrow() {
		 WebElement arrow1=driver.findElement(By.xpath(packArrow));	
		 return arrow1;
	 }
	 
	 public void selectProgramNew(String program) throws InterruptedException {
		 Thread.sleep(10000);
		 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		 
	    for(int i=0;i<list.size();i++) {
		String text = list.get(i).getText();
		System.out.println("Progms list is--"+text);
		if(text.contains(program))
		{
			list.get(i).click();
			break;
		}
	 }
	    Thread.sleep(2000);
	 }
	 
	 public void createMarkupForClass(String programCode,String markupType,String selectedClass,String amount) throws InterruptedException {
		 utils.getfield("span", "New Markup").click();
			Thread.sleep(3000);
			getArrow().click();
			selectProgramNew(programCode);
		 if(markupType.equals("Flat")) {
			 getBtnsmarkup().get(0).click();
			 getBtnsmarkup().get(3).click(); 
			 if(selectedClass.equals("1")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("1").sendKeys(amount);
			 }
			 else if (selectedClass.equals("2")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("2").sendKeys(amount);
			}
			 else if (selectedClass.equals("3")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("3").sendKeys(amount);
			}
			 else if (selectedClass.equals("4")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("4").sendKeys(amount);
			}
			 else if (selectedClass.equals("5")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("5").sendKeys(amount);
			}
		 }
		 
		 else if(markupType.equals("Percentage")) {
			 getBtnsmarkup().get(1).click();
			 getBtnsmarkup().get(3).click(); 
			 if(selectedClass.equals("1")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("1").sendKeys(amount);
			 }
			 else if (selectedClass.equals("2")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("2").sendKeys(amount);
			}
			 else if (selectedClass.equals("3")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("3").sendKeys(amount);
			}
			 else if (selectedClass.equals("4")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("4").sendKeys(amount);
			}
			 else if (selectedClass.equals("5")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("5").sendKeys(amount);
			}
		 }
		 utils.getfield("span", "Save").click();
		 Thread.sleep(3000);
		 }
	 
	 public void createMarkupForCoverage(String programCode,String markupType,String coverage,String amount) throws InterruptedException {
		 utils.getfield("span", "New Markup").click();
			Thread.sleep(3000);
			getArrow().click();
			selectProgramNew(programCode);
		 if(markupType.equals("Flat")) {
			 getBtnsmarkup().get(0).click();
			 getBtnsmarkup().get(4).click(); 
			 if(coverage.equalsIgnoreCase("Basic")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("Basic").sendKeys(amount);
			 }
			 else if (coverage.equalsIgnoreCase("Comprehensive")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("Comprehensive").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Essential")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("Essential").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Exclusionary")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("Exclusionary").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Classic")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("Classic").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Estate")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("Estate").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Powertrain")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("Powertrain").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Reserve")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("Reserve").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Vintage")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("Vintage").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Sterling")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("Sterling").sendKeys(amount);
			}
		 }
		 else if(markupType.equals("Percentage")) {
			 getBtnsmarkup().get(1).click();
			 getBtnsmarkup().get(4).click(); 
			 if(coverage.equalsIgnoreCase("Basic")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("Basic").sendKeys(amount);
			 }
			 else if (coverage.equalsIgnoreCase("Comprehensive")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("Comprehensive").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Essential")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("Essential").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Exclusionary")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("Exclusionary").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Classic")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("Classic").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Estate")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("Estate").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Powertrain")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("Powertrain").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Reserve")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("Reserve").sendKeys(amount);
			}
			 else if (coverage.equalsIgnoreCase("Vintage")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("Vintage").sendKeys(amount);
			}
		 }
		 utils.getfield("span", "Save").click();
		 Thread.sleep(3000);
		 }
	
	 
	 public void createMarkupForMileageBand(String programCode,String markupType,String mileageBand,String amount) throws InterruptedException {
		 utils.getfield("span", "New Markup").click();
			Thread.sleep(3000);
			getArrow().click();
			selectProgramNew(programCode);
		 if(markupType.equals("Flat")) {
			 getBtnsmarkup().get(0).click();
			 getBtnsmarkup().get(5).click(); 
			 if(mileageBand.equals("0-18000")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("0").sendKeys(amount);
			 }
			 else if (mileageBand.equals("18001-36000")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("18001").sendKeys(amount);
			}
			 else if (mileageBand.equals("36001-60000")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("36001").sendKeys(amount);
			}
			 else if (mileageBand.equals("0-48000")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("0").sendKeys(amount);
			}
			 else if (mileageBand.equals("0 - 80000")) {
				 getMultipleTxtFldForClassFlat("0").get(0).sendKeys(amount);
			}
			 else if (mileageBand.equals("0 - 100000")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("0").sendKeys(amount);
			}
			 else if (mileageBand.equals("0 - 200000")) {
				 getMultipleTxtFldForClassFlat("0").get(2).sendKeys(amount);
			}
		 }
		 
		 else if(markupType.equals("Percentage")) {
			 getBtnsmarkup().get(1).click();
			 getBtnsmarkup().get(5).click(); 
			 if(mileageBand.equals("0-18000")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("0").sendKeys(amount);
			 }
			 else if (mileageBand.equals("18001-36000")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("18001").sendKeys(amount);
			}
			 else if (mileageBand.equals("36001-60000")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("36001").sendKeys(amount);
			}
			 else if (mileageBand.equals("0-48000")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("0").sendKeys(amount);
			}
			 else if (mileageBand.equals("0 - 80000")) {
				 getMultipleTxtFldForClassPercent("0").get(0).sendKeys(amount);
			}
			 else if (mileageBand.equals("0 - 100000")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("0").sendKeys(amount);
			}
			 else if (mileageBand.equals("0-200000")) {
				 getMultipleTxtFldForClassPercent("0").get(2).sendKeys(amount);
			}
		 }
		 utils.getfield("span", "Save").click();
		 Thread.sleep(3000);
		 }
	
	 public void createMarkupForTerMonths(String programCode,String markupType,String termMonths,String amount) throws InterruptedException {
		 utils.getfield("span", "New Markup").click();
			Thread.sleep(3000);
			getArrow().click();
			selectProgramNew(programCode);
		 if(markupType.equals("Flat")) {
			 getBtnsmarkup().get(0).click();
			 getBtnsmarkup().get(6).click(); 
			 if(termMonths.equals("12")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("12").sendKeys(amount);
			 }
			 else if (termMonths.equals("24")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("24").sendKeys(amount);
			}
			 else if (termMonths.equals("36")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("36").sendKeys(amount);
			}
			 else if (termMonths.equals("48")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("48").sendKeys(amount);
			}
			 else if (termMonths.equals("60")) {
				 getTxtFldForClassCoverageMileageTermMonthFlat("60").sendKeys(amount);
			}
		 }
		 
		 else if(markupType.equals("Percentage")) {
			 getBtnsmarkup().get(1).click();
			 getBtnsmarkup().get(6).click(); 
			 if(termMonths.equals("12")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("12").sendKeys(amount);
			 }
			 else if (termMonths.equals("24")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("24").sendKeys(amount);
			}
			 else if (termMonths.equals("36")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("36").sendKeys(amount);
			}
			 else if (termMonths.equals("48")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("48").sendKeys(amount);
			}
			 else if (termMonths.equals("60")) {
				 getTxtFldForClassCoverageMileageTermMonthPercent("60").sendKeys(amount);
			}
		 }
		 utils.getfield("span", "Save").click();
		 Thread.sleep(3000);
		 }
	 
	 public void editMarkup(String markupType, String markupBy, String amount) throws InterruptedException {
		 editMarkupBtn().click();
			Thread.sleep(1000);
		 if(markupType.equals("Flat")) {
			 getBtnsmarkup().get(0).click();
			 selectMarkupBy(markupBy);
			 getMarkupAmountTxtFld().get(0).sendKeys(amount);
		 }
		 else if(markupType.equals("Percentage")) {
			 getBtnsmarkup().get(1).click();
			 selectMarkupBy(markupBy);
			 getMarkupAmountTxtFldForPercentage().get(0).sendKeys(amount);
		 }
		 utils.getfield("span", "Save").click();
		 Thread.sleep(3000);
		 }
	
	 public void createMarkupForAll(String programCode,String markupType, String markupBy, String amount) throws InterruptedException {
		 utils.getfield("span", "New Markup").click();
			Thread.sleep(3000);
			getArrow().click();
			selectProgramNew(programCode);
		 if(markupType.equals("Flat")) {
			 getBtnsmarkup().get(0).click();
			 selectMarkupBy(markupBy);
			 getMarkupAmountTxtFld().get(0).sendKeys(amount);
		 }
		 else if(markupType.equals("Percentage")) {
			 getBtnsmarkup().get(1).click();
			 selectMarkupBy(markupBy);
			 getMarkupAmountTxtFldForPercentage().get(0).sendKeys(amount);
		 }
		 utils.getfield("span", "Save").click();
		 Thread.sleep(3000);
		 }
	 
	 public void selectMarkupBy(String markupBy) throws InterruptedException {
		 if(markupBy.equals("All")) {
			 getBtnsmarkup().get(2).click(); 
		 }
		 else if (markupBy.equals("Class")) {
			 
			 getBtnsmarkup().get(3).click(); 
			 
		}
		 else if (markupBy.equals("Coverage")) {
			 getBtnsmarkup().get(4).click(); 
		}
		 else if (markupBy.equals("Mileage Band")) {
			 getBtnsmarkup().get(5).click(); 
		}
		 else if (markupBy.equals("Term Months")) {
			 getBtnsmarkup().get(6).click(); 
		}
		 utils.scrollLittleDownUsingJSE(); 
	 }
	 

	 public Double getVehiclePriceForPercentageMarkup(String vehicleProgram) throws ParseException, InterruptedException {
		 utils.inputfield("cssSelector", textbox, "Single", 0);
		 //utils.getfield("cssSelector", "textbox").clear();
		 utils.inputfield("cssSelector", textbox, "Test", 1);
		 utils.inputfield("cssSelector", textbox, "100", 5);
		 utils.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
		 utils.clickfield("xpath", getProducts);
		 co.programSelect(vehicleProgram);
		 utils.scrollLittleDownUsingJSE();
		 String txt = utils.text("cssSelector", table, 0);
		 Thread.sleep(2000);
		 NumberFormat format = NumberFormat.getCurrencyInstance();
			Number number = format.parse(txt);
			String packAmount = number.toString();
		 Double txtInDouble= Double.parseDouble(packAmount);
		 System.out.println("double value is--"+txtInDouble);
		 return txtInDouble;
		 }
	 
//	 public void parseNum(String no) throws ParseException {
//	 }
//	 
	 
	 void add2(Integer i, Double d1) {
		  Double d2= Double.valueOf((double) i.intValue() + d1.doubleValue());
		}
	 
	 public WebElement editMarkupBtn() throws InterruptedException {
			String editLoc = "table>tbody>tr:nth-of-type(1)>td:nth-of-type(11)>adl-table-cells>div";
			WebElement ele = utils.element("cssSelector", editLoc);
			return ele;
		}


}
