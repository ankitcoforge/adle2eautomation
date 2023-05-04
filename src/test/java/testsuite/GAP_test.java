package testsuite;

import java.text.NumberFormat;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageActions.GAPAction;
import pageActions.WebMileageExceptionAction;
import pageActions.generateContractAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import utils.CalenderUtils;
import utils.utilityClass;

/* divyasree */
public class GAP_test extends GAPAction{
	
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	impersonateAction impersonate = new impersonateAction();
	WebMileageExceptionAction wme = new WebMileageExceptionAction();
	utilityClass event = new utilityClass();
	CalenderUtils calander=new CalenderUtils();
	generateContractAction gc = new generateContractAction();
	EditContract_test contractPage =new EditContract_test();
	singleContractAction singleContract=new singleContractAction();
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}

	@Test(priority = 1)
	public void verifyPlaceholderOrTextsInGapForm_9940_9941_9942_9943_9944_9945() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		wme.getProducts("5FNRL6H27NB019645", "100");
		Assert.assertTrue(event.element("xpath", results).isDisplayed());
		Assert.assertTrue(event.element("xpath", makeModelYear).isDisplayed());
		Assert.assertTrue(event.element("xpath", manufacturerPowerTrainWarranty).isDisplayed());
		Assert.assertTrue(event.element("xpath", fullFactoryWarranty).isDisplayed());
		Assert.assertTrue(event.element("xpath", chooseTwoPrograms).isDisplayed());
		Assert.assertTrue(getProgramName("RNL").isDisplayed());
		Assert.assertTrue(getProgramCheckBox("RNL").isDisplayed());
		selectProgram("RNL");
		Thread.sleep(5000);
		selectProgram("RSE");
		Thread.sleep(5000);
		Assert.assertTrue(getProgramHeadingAboveTable("RNL").isDisplayed());
		Assert.assertTrue(getProgramHeadingAboveTable("RSE").isDisplayed());
		Assert.assertTrue(event.getElementsList("xpath", markupforProgram).get(0).isDisplayed());
		Assert.assertTrue(event.getElementsList("xpath", classForprograms).get(0).isDisplayed());
		Assert.assertTrue(event.element("xpath", termMileageMonthsInContractPageTxt).isDisplayed());
		Assert.assertTrue(event.getElementsList("xpath", reserve).get(0).isDisplayed());
		Assert.assertTrue(event.getElementsList("xpath", powertrain).get(0).isDisplayed());
		Assert.assertTrue(event.getElementsList("xpath", sterling).get(0).isDisplayed());
		Assert.assertTrue(event.getElementsList("xpath", estate).get(0).isDisplayed());
		
		Assert.assertTrue(event.element("xpath", AddGapCheckBox).isDisplayed());
		Assert.assertTrue(event.element("xpath", AddGapCheckBoxStatus).getAttribute("aria-checked").equals("false"));
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		Assert.assertTrue(getTxtField("Term").isDisplayed());
		Assert.assertTrue(getTxtField("Finance Amount").isDisplayed());
		Assert.assertTrue(getTxtField("NADA").isDisplayed());
		Assert.assertTrue(getTxtField("MSRP").isDisplayed());
		Assert.assertTrue(getTxtField("APR").isDisplayed());
		Assert.assertTrue(event.element("xpath", gapRateBtn).isDisplayed());
		Assert.assertTrue(event.element("xpath", gapRateBtn).isEnabled());
		Assert.assertTrue(event.element("xpath", selectDealTypeTxt).isDisplayed());
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		Assert.assertTrue(selectDealTypeDropdownList().get(0).getText().contains("Loan"));
		Assert.assertTrue(selectDealTypeDropdownList().get(1).getText().contains("Lease"));
		Assert.assertTrue(selectDealTypeDropdownList().get(2).getText().contains("Balloon"));
		selectDropDown("Loan");
		Thread.sleep(1000);
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(2000);
		Assert.assertTrue(selectDealTypeDropdownList().get(0).getAttribute("aria-selected").equals("true"));
		Assert.assertTrue(event.element("xpath", adlGapForm).isDisplayed());
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		//no such ele
		//Assert.assertFalse(event.element("xpath", adlGapForm).isDisplayed());
			
	}
	
	
	@Test(priority = 2)
	public void verifyGapFormFields_9974_9978_9979_10009_10010_10011_10012_10013_10014_10017_10018_10026_10028() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		wme.getProducts("5FNRL6H27NB019645", "100");
		Assert.assertTrue(event.element("xpath", results).isDisplayed());
		selectProgram("RNL");
		Thread.sleep(5000);
		selectProgram("RSE");
		Thread.sleep(5000);
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		String numericalInput = "123";
		String nonNumericalInput = "abc";
		getTxtField("Term").sendKeys(numericalInput);
		Assert.assertTrue(getTxtField("Term").getAttribute("value").equals(numericalInput));
		Thread.sleep(2000);
		getTxtField("Term").clear();
		Thread.sleep(2000);
		getTxtField("Term").sendKeys(nonNumericalInput);
		Assert.assertTrue(getTxtField("Term").getAttribute("value").equals(""));
		Assert.assertTrue(getTxtField("Term").getAttribute("maxlength").equals("3"));
		
		String numericalInputFinnace = "123456";
		String formatedtednumericalInputFinnace = "123,456.00";
		getTxtField("Finance Amount").sendKeys(numericalInputFinnace);
		Thread.sleep(2000);
		getTxtField("NADA").click();
		Assert.assertTrue(getTxtField("Finance Amount").getAttribute("value").equals(formatedtednumericalInputFinnace));
		Thread.sleep(2000);
		getTxtField("Finance Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Finance Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Finance Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Finance Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Finance Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Finance Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Finance Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Finance Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Finance Amount").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		getTxtField("Finance Amount").sendKeys(nonNumericalInput);
		Assert.assertTrue(getTxtField("Finance Amount").getAttribute("value").equals(""));
		
		getTxtField("NADA").sendKeys(numericalInputFinnace);
		Thread.sleep(2000);
		getTxtField("Finance Amount").click();
		Assert.assertTrue(getTxtField("NADA").getAttribute("value").equals(formatedtednumericalInputFinnace));
		Thread.sleep(2000);
		getTxtField("NADA").sendKeys(Keys.BACK_SPACE);
		getTxtField("NADA").sendKeys(Keys.BACK_SPACE);
		getTxtField("NADA").sendKeys(Keys.BACK_SPACE);
		getTxtField("NADA").sendKeys(Keys.BACK_SPACE);
		getTxtField("NADA").sendKeys(Keys.BACK_SPACE);
		getTxtField("NADA").sendKeys(Keys.BACK_SPACE);
		getTxtField("NADA").sendKeys(Keys.BACK_SPACE);
		getTxtField("NADA").sendKeys(Keys.BACK_SPACE);
		getTxtField("NADA").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		getTxtField("NADA").sendKeys(nonNumericalInput);
		Assert.assertTrue(getTxtField("NADA").getAttribute("value").equals(""));
		
		getTxtField("MSRP").sendKeys(numericalInputFinnace);
		Thread.sleep(2000);
		getTxtField("Finance Amount").click();
		Assert.assertTrue(getTxtField("MSRP").getAttribute("value").equals(formatedtednumericalInputFinnace));
		Thread.sleep(2000);
		getTxtField("MSRP").sendKeys(Keys.BACK_SPACE);
		getTxtField("MSRP").sendKeys(Keys.BACK_SPACE);
		getTxtField("MSRP").sendKeys(Keys.BACK_SPACE);
		getTxtField("MSRP").sendKeys(Keys.BACK_SPACE);
		getTxtField("MSRP").sendKeys(Keys.BACK_SPACE);
		getTxtField("MSRP").sendKeys(Keys.BACK_SPACE);
		getTxtField("MSRP").sendKeys(Keys.BACK_SPACE);
		getTxtField("MSRP").sendKeys(Keys.BACK_SPACE);
		getTxtField("MSRP").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		getTxtField("MSRP").sendKeys(nonNumericalInput);
		Assert.assertTrue(getTxtField("MSRP").getAttribute("value").equals(""));
		
		
		String percentInput = "70";
		getTxtField("APR").sendKeys(percentInput);
		Thread.sleep(2000);
		getTxtField("Finance Amount").click();
		Assert.assertTrue(getTxtField("APR").getAttribute("value").equals(percentInput));
		Thread.sleep(2000);
		getTxtField("APR").sendKeys(Keys.BACK_SPACE);
		getTxtField("APR").sendKeys(Keys.BACK_SPACE);
		getTxtField("APR").sendKeys(Keys.BACK_SPACE);
		getTxtField("APR").sendKeys(Keys.BACK_SPACE);
		getTxtField("APR").sendKeys(Keys.BACK_SPACE);
		getTxtField("APR").sendKeys(Keys.BACK_SPACE);
		getTxtField("APR").sendKeys(Keys.BACK_SPACE);
		getTxtField("APR").sendKeys(Keys.BACK_SPACE);
		getTxtField("APR").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		getTxtField("APR").sendKeys(nonNumericalInput);
		Assert.assertTrue(getTxtField("APR").getAttribute("value").equals(""));
		Thread.sleep(1000);
		Assert.assertTrue(getCurrency("Finance Amount").getText().equals("attach_money"));
		Assert.assertTrue(getCurrency("NADA").getText().equals("attach_money"));
		Assert.assertTrue(getCurrency("MSRP").getText().equals("attach_money"));
		Assert.assertTrue(event.element("xpath", aprSign).getText().equals("%"));
			}
		
	@Test(priority = 3)
	public void verifyADDGapbehaviourWhenCheckedAndUnchecked_10032() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		wme.getProducts("5FNRL6H27NB019645", "100");
		Assert.assertTrue(event.element("xpath", results).isDisplayed());
		selectProgram("RNL");
		Thread.sleep(5000);
		selectProgram("RSE");
		Thread.sleep(5000);
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		Assert.assertTrue(event.element("xpath", adlGapForm).isDisplayed());
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		selectDropDown("Loan");
		Thread.sleep(1000);
		String inputTerm="2";
		String inputFinanceAmount="100";
		String inputNADA="200";
		String inputMSRP="500";
		String inputAPR="60";
		getTxtField("Term").sendKeys(inputTerm);
		getTxtField("Finance Amount").sendKeys(inputFinanceAmount);
		getTxtField("NADA").sendKeys(inputNADA);
		getTxtField("MSRP").sendKeys(inputMSRP);
		getTxtField("APR").sendKeys(inputAPR);
		Thread.sleep(1000);
		event.element("xpath", AddGapCheckBox).click();
		Assert.assertTrue(event.element("xpath", AddGapCheckBoxStatus).getAttribute("aria-checked").equals("false"));
		//form not displayed step
		Thread.sleep(2000);
		event.element("xpath", AddGapCheckBox).click();
		Assert.assertTrue(event.element("xpath", AddGapCheckBoxStatus).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getTxtField("Term").getAttribute("value").contains(inputTerm));
		Assert.assertTrue(getTxtField("Finance Amount").getAttribute("value").contains(inputFinanceAmount));
		Assert.assertTrue(getTxtField("NADA").getAttribute("value").contains(inputNADA));
		Assert.assertTrue(getTxtField("MSRP").getAttribute("value").contains(inputMSRP));
		Assert.assertTrue(getTxtField("APR").getAttribute("value").contains(inputAPR));
	}
	
	@Test(priority = 4)
	public void verifyRequiredErrorMsgAndGapForm_10043_10045_10072() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "34799");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		wme.getProducts("5FNRL6H27NB019645", "100");
		Assert.assertTrue(event.element("xpath", results).isDisplayed());
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		Assert.assertTrue(event.element("xpath", adlGapForm).isDisplayed());
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		selectDropDown("Loan");
		Thread.sleep(1000);
		String inputTerm="1";
		String inputFinanceAmount="1000";
		String inputNADA="100";
		String inputMSRP="10";
		String inputAPR="5";
		String gapRetailPrice="123456";
		String convertedGapRetailPrice="123,456";
		getTxtField("Term").sendKeys(inputTerm);
		getTxtField("Finance Amount").sendKeys(inputFinanceAmount);
		getTxtField("NADA").sendKeys(inputNADA);
		getTxtField("APR").sendKeys(inputAPR);
		Thread.sleep(1000);
		event.element("xpath", gapRateBtn).click();
		Assert.assertTrue(event.element("xpath", requiredErrorMsg).isDisplayed());
		getTxtField("MSRP").sendKeys(inputMSRP);
		Thread.sleep(2000);
		event.element("xpath", gapRateBtn).click();
		Thread.sleep(30000);
		selectProgramPlanAndTermMonths();
		Assert.assertTrue(event.getfield("label", "Program").isDisplayed());
		Assert.assertTrue(event.getfield("label", "Plan").isDisplayed());
		Assert.assertTrue(event.getfield("label", "Term Months").isDisplayed());
		Assert.assertTrue(event.getfield("strong", "GAP Retail Price").isDisplayed());
		Assert.assertTrue(event.getfield("label", "Monthly Payment").isDisplayed());
		Assert.assertTrue(event.getfield("label", "1st Pmt Date").isDisplayed());
		Assert.assertTrue(event.getfield("label", "Residual Amount").isDisplayed());
		Assert.assertTrue(event.element("xpath", leinholderInGapForm).isDisplayed());
		Assert.assertTrue(event.getfield("label", "Lienholder Address").isDisplayed());
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 2500)");
		Assert.assertTrue(event.getfield("h4", "Options").isDisplayed());
		Assert.assertTrue(event.getfield("p", "LS 1 ton Surcharge").isDisplayed());
		Assert.assertTrue(event.getfield("p", "LS Commercial Surcharge").isDisplayed());
		Assert.assertTrue(event.getfield("p", "LS Lease Option").isDisplayed());
		Thread.sleep(2000);
		event.element("xpath", gapRetailPriceTxtBox).clear();
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(gapRetailPrice);
		Thread.sleep(2000);
		System.out.println("value1 is---"+event.element("xpath", gapRetailPriceTxtBox).getAttribute("value"));
		Assert.assertTrue(event.element("xpath", gapRetailPriceTxtBox).getAttribute("value").contains(convertedGapRetailPrice));
		Thread.sleep(2000);
		event.element("xpath", gapRetailPriceTxtBox).clear();
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys("0");
		Thread.sleep(2000);
		System.out.println("value2 is---"+event.element("xpath", gapRetailPriceTxtBox).getAttribute("value"));
		Assert.assertTrue(event.element("xpath", gapRetailPriceTxtBox).getAttribute("value").contains("0"));
		
	}

	@Test(priority = 5)
	public void verifyDollarSignAndErrorMsgNoPragrams_10073_10075_10020() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "34799");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		wme.getProducts("5FNRL6H27NB019645", "100");
		Assert.assertTrue(event.element("xpath", errorMsgNoProgramsAvailable).isDisplayed());
		Assert.assertTrue(event.element("xpath", results).isDisplayed());
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		Assert.assertTrue(event.element("xpath", adlGapForm).isDisplayed());
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		selectDropDown("Balloon");
		enterTermFinanceNadaMsrpApr();
		event.element("xpath", gapRateBtn).click();
		Thread.sleep(10000);
		selectProgramPlanAndTermMonths();
		Assert.assertTrue(getDollarSign("Monthly Payment").getText().equals("attach_money"));
		Assert.assertTrue(getDollarSign("Residual Amount").getText().equals("attach_money"));
		Assert.assertTrue(getDollarSign("Balloon Amount").getText().equals("attach_money"));
	}
	
	@Test(priority = 6)
	public void verifyResidualAmountIsMandatoryForLeaseType_10078() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "34799");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		wme.getProducts("5FNRL6H27NB019645", "100");
		Assert.assertTrue(event.element("xpath", results).isDisplayed());
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		Assert.assertTrue(event.element("xpath", adlGapForm).isDisplayed());
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		selectDropDown("Lease");
		enterTermFinanceNadaMsrpApr();
		event.element("xpath", gapRateBtn).click();
		Thread.sleep(10000);
		Assert.assertTrue(getAsterisk("Residual Amount").isDisplayed());
	}
	
	@Test(priority = 7)
	public void verifyMonthPaymentField_10202_10203_10204_() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "34799");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		wme.getProducts("5FNRL6H27NB019645", "100");
		Assert.assertTrue(event.element("xpath", results).isDisplayed());
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		Assert.assertTrue(event.element("xpath", adlGapForm).isDisplayed());
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		selectDropDown("Lease");
		enterTermFinanceNadaMsrpApr();
		event.element("xpath", gapRateBtn).click();
		Thread.sleep(10000);
		Assert.assertTrue(getAsterisk("Monthly Payment").isDisplayed());
		String nonnemericvalue="abcd";
		String numericvalue="123456";
		String convertedNumericalValue="123,456.00";
		getTxtField("Monthly Payment").sendKeys(nonnemericvalue);
		Assert.assertTrue(getTxtField("Monthly Payment").getAttribute("value").contains(""),"Monthly payment doesnot accept non numerical value");
		getTxtField("Monthly Payment").sendKeys(numericvalue);
		getTxtField("1st Pmt Date").click();
		Thread.sleep(2000);
		Assert.assertTrue(getTxtField("Monthly Payment").getAttribute("value").contains(convertedNumericalValue),"Accepts numerical value");
		getTxtField("Monthly Payment").sendKeys(Keys.BACK_SPACE);
		getTxtField("Monthly Payment").sendKeys(Keys.BACK_SPACE);
		getTxtField("Monthly Payment").sendKeys(Keys.BACK_SPACE);
		getTxtField("Monthly Payment").sendKeys(Keys.BACK_SPACE);
		getTxtField("Monthly Payment").sendKeys(Keys.BACK_SPACE);
		getTxtField("Monthly Payment").sendKeys(Keys.BACK_SPACE);
		getTxtField("Monthly Payment").sendKeys(Keys.BACK_SPACE);
		getTxtField("Monthly Payment").sendKeys(Keys.BACK_SPACE);
		getTxtField("Monthly Payment").sendKeys(Keys.BACK_SPACE);
		getTxtField("Monthly Payment").sendKeys("0");
		Assert.assertTrue(getTxtField("Monthly Payment").getAttribute("value").contains("0"),"Accepts zero");
	}
	
//futuredate	
//	@Test(priority = 8)
//	public void verify1stPaymntDateField_10205_10206_10207_10208_10210_10077() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
//		Thread.sleep(3000);
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", "34799");
//		Thread.sleep(2000);
//		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
//		Thread.sleep(2000);
//		event.clickfield("xpath", calanderbtn);
//		String dateSelectedInSoldDate = calander.getCurrentDate(2,"MM/dd/yyyy");
//		calander.selectDate(dateSelectedInSoldDate,"MM/dd/yyyy");
//		Thread.sleep(2000);
//		String soldDateTxtFldValue = event.element("cssSelector", textbox, 4).getAttribute("value");
//		wme.getProducts("5FNRL6H27NB019645", "100");
//		Assert.assertTrue(event.element("xpath", results).isDisplayed());
//		event.element("xpath", AddGapCheckBox).click();
//		Thread.sleep(2000);
//		Assert.assertTrue(event.element("xpath", adlGapForm).isDisplayed());
//		event.element("xpath", selectDealTypeArrow).click();
//		Thread.sleep(1000);
//		selectDropDown("Lease");
//		enterTermFinanceNadaMsrpApr();
//		event.element("xpath", gapRateBtn).click();
//		Thread.sleep(30000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollTo(0, 2500)");
//		Assert.assertTrue(getAsteriskHeadings().get(0).getText().equals("Monthly Payment*"));
//		Assert.assertTrue(getAsteriskHeadings().get(1).getText().equals("Residual Amount*"),"1st payment which is present in the middle of Monthly payment and residual amount doesnot contain asterisk");
//		
//		event.clickfield("xpath", calanderbtn);
//		Thread.sleep(2000);
//		String selectedDateFromCalander = getSelectedDateInCalander();
//		String currentDate = calander.getCurrentDate(0,"MMM/dd/yyyy");
//		
//		String[] date = currentDate.split("/");
//		String datetxtInSystem = date[1];
//		System.out.println("datetxtInSystem-"+datetxtInSystem);
//		System.out.println("selectedDateFromCalander-"+selectedDateFromCalander);
//		//Assert.assertTrue(selectedDateFromCalander.equals(datetxtInSystem));
//		String dateSelected = calander.getCurrentDate(2,"MM/dd/yyyy");
//		calander.selectDate(dateSelected,"MM/dd/yyyy");
//		Thread.sleep(2000);
//		Assert.assertTrue(getTxtField("1st Pmt Date").getAttribute("value").equals(dateSelected));
//		System.out.println("soldDateTxtFldValue-"+soldDateTxtFldValue);
//		System.out.println("dateSelected-"+dateSelected);
//		Assert.assertTrue(soldDateTxtFldValue.equals(dateSelected));
//		Thread.sleep(2000);
//		event.clickfield("xpath",genrateContractButton);
//		Thread.sleep(2000);
//	}
	
	@Test(priority = 9)
	public void verifyTotalValueWithGapRetailPriceModifiedAndUnmodified_10082_10199() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "34799");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		wme.getProducts("5FNRL6H27NB019645", "100");
		Assert.assertTrue(event.element("xpath", results).isDisplayed());
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		Assert.assertTrue(event.element("xpath", adlGapForm).isDisplayed());
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		selectDropDown("Lease");
		enterTermFinanceNadaMsrpApr();
		event.element("xpath", gapRateBtn).click();
		Thread.sleep(30000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 2500)");
		selectProgramPlanAndTermMonths();
		
		String gapRetailPriceUnmodified = event.element("xpath", gapRetailPriceTxtBox).getAttribute("value");
		NumberFormat format = NumberFormat.getNumberInstance();
			Number number = format.parse(gapRetailPriceUnmodified);
			String gapAmount = number.toString();
		   int gapRetailPriceUnmodifiedInt = Integer.parseInt(gapAmount);
		System.out.println("gap price unmodified-"+gapRetailPriceUnmodified);
		
		getPlusIconInOptions().get(0).click();
		Thread.sleep(2000);
		String optionSelected = getOptionSelectedPrice().get(0).getText();
		NumberFormat format1 = NumberFormat.getCurrencyInstance();
		Number option = format1.parse(optionSelected);
		String selectedOptionValue = option.toString();
	   int optionSelectedInt = Integer.parseInt(selectedOptionValue);
		System.out.println("Option selected-"+optionSelectedInt);
		
		 String[] totalPriceInGapForm = event.element("xpath", totalPriceNew).getText().split(" ");
		Number totalPrice = format1.parse(totalPriceInGapForm[1]);
	   int totalPriceInt = Integer.parseInt(totalPrice.toString());
	   Thread.sleep(2000);
		Assert.assertEquals(totalPriceInt, (gapRetailPriceUnmodifiedInt + optionSelectedInt));
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys(Keys.BACK_SPACE);
		event.element("xpath", gapRetailPriceTxtBox).sendKeys("100");
		//clicking on somewhere like monthly payment gives the gap retail price with decimals
		getTxtField("Monthly Payment").click();
		Thread.sleep(2000);
		String gapRetailPricemodified = event.element("xpath", gapRetailPriceTxtBox).getAttribute("value");
		Number gapRetailPricemodifiedInNumber = format.parse(gapRetailPricemodified);
	   int gapRetailPricemodifiedInt = Integer.parseInt(gapRetailPricemodifiedInNumber.toString());
		System.out.println("gap price modified-"+gapRetailPricemodifiedInt);
		
		 String[] totalPriceInGapFormAfterOptionSelection = event.element("xpath", totalPriceNew).getText().split(" ");
		Number totalPriceInGapFormNumber = format1.parse(totalPriceInGapFormAfterOptionSelection[1]);
	   int totalPriceAftrOptionSelection = Integer.parseInt(totalPriceInGapFormNumber.toString());
	   Thread.sleep(2000);
		Assert.assertEquals(totalPriceAftrOptionSelection, (gapRetailPricemodifiedInt + optionSelectedInt));
	
	}
	
	@Test(priority = 10)
	public void verifyResidualAmountField_10212_10213_10214_10215_10216() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "34799");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		wme.getProducts("5FNRL6H27NB019645", "100");
		Assert.assertTrue(event.element("xpath", results).isDisplayed());
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		Assert.assertTrue(event.element("xpath", adlGapForm).isDisplayed());
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		selectDropDown("Lease");
		enterTermFinanceNadaMsrpApr();
		event.element("xpath", gapRateBtn).click();
		Thread.sleep(10000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 2500)");
		//Assert.assertTrue(getAsterisk("Residual Amount").isDisplayed(),"Asterisk is displayed for Lease");
		String nonnemericvalue="abcd";
		String numericvalue="123456";
		String convertedNumericalValue="123,456.00";
		getTxtField("Residual Amount").sendKeys(nonnemericvalue);
		Assert.assertTrue(getTxtField("Residual Amount").getAttribute("value").contains(""),"Residual Amount doesnot accept non numerical value");
		getTxtField("Residual Amount").sendKeys(numericvalue);
		getTxtField("1st Pmt Date").click();
		Thread.sleep(2000);
		Assert.assertTrue(getTxtField("Residual Amount").getAttribute("value").contains(convertedNumericalValue),"Accepts numerical value");
		getTxtField("Residual Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Residual Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Residual Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Residual Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Residual Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Residual Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Residual Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Residual Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Residual Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Residual Amount").sendKeys("0");
		Assert.assertTrue(getTxtField("Residual Amount").getAttribute("value").contains("0"),"Accepts zero");
		
		event.element("xpath", editSearch).click();
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		selectDropDown("Loan");
		event.element("xpath", gapRateBtn).click();
		Thread.sleep(10000);
		
		Assert.assertTrue(getAsteriskHeadings().get(0).getText().contains("Monthly Payment"));
		Assert.assertTrue(getAsteriskHeadings().get(1).getText().contains("Zip Code"),"Residual Amount which is present in between doesnot contain asterisk for type Loan");
		event.element("xpath", editSearch).click();
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		selectDropDown("Balloon");
		event.element("xpath", gapRateBtn).click();
		Thread.sleep(10000);
		Assert.assertTrue(getAsteriskHeadings().get(0).getText().contains("Monthly Payment"));
		Assert.assertTrue(getAsteriskHeadings().get(1).getText().contains("Balloon Amount"),"Residual Amount which is present in the middle of Monthly payment and Balloon amount doesnot contain asterisk for type balloon");
	}

	@Test(priority = 11)
	public void verifyBalloonAmountField_10217_10218_10219() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "34799");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		wme.getProducts("5FNRL6H27NB019645", "100");
		Assert.assertTrue(event.element("xpath", results).isDisplayed());
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		Assert.assertTrue(event.element("xpath", adlGapForm).isDisplayed());
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		selectDropDown("Balloon");
		enterTermFinanceNadaMsrpApr();
		event.element("xpath", gapRateBtn).click();
		Thread.sleep(30000);
		Assert.assertTrue(getAsterisk("Balloon Amount").getText().equals("*"));
		String nonnemericvalue="abcd";
		String numericvalue="123456";
		String convertedNumericalValue="123,456.00";
		getTxtField("Balloon Amount").sendKeys(nonnemericvalue);
		Assert.assertTrue(getTxtField("Balloon Amount").getAttribute("value").contains(""),"Balloon Amount doesnot accept non numerical value");
		getTxtField("Balloon Amount").sendKeys(numericvalue);
		getTxtField("1st Pmt Date").click();
		Thread.sleep(2000);
		Assert.assertTrue(getTxtField("Balloon Amount").getAttribute("value").contains(convertedNumericalValue),"Accepts numerical value");
		getTxtField("Balloon Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Balloon Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Balloon Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Balloon Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Balloon Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Balloon Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Balloon Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Balloon Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Balloon Amount").sendKeys(Keys.BACK_SPACE);
		getTxtField("Balloon Amount").sendKeys("0");
		Assert.assertTrue(getTxtField("Balloon Amount").getAttribute("value").contains("0"),"Accepts zero");
	}
	
	@Test(priority = 11)
	public void verifyPlusAndMinusButtonsInOptionSelection_10220_10221() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "34799");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		wme.getProducts("5FNRL6H27NB019645", "100");
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		selectDropDown("Balloon");
		enterTermFinanceNadaMsrpApr();
		event.element("xpath", gapRateBtn).click();
		Thread.sleep(30000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 2500)");
		selectProgramPlanAndTermMonths();
		getPlusIconInOptions().get(0).click();
		Thread.sleep(2000);
		String expectedBlueColorInHexa = prop.getProperty("blueColorInHexaForm2");
		String OutlineColorBlue = getOptions().get(0).getCssValue("border-color");
		String ActualBluecolorInHexaformat = Color.fromString(OutlineColorBlue).asHex();
		Assert.assertEquals(ActualBluecolorInHexaformat, expectedBlueColorInHexa);
		
		getMinusIconInOptions().get(0).click();
		Thread.sleep(2000);
		String expectedGreyColorInHexa = prop.getProperty("greyColorInHexaForm2");
		String OutlineColorGrey = getOptions().get(1).getCssValue("border-color");
		String ActualGreycolorInHexaformat = Color.fromString(OutlineColorGrey).asHex();
		Assert.assertEquals(ActualGreycolorInHexaformat, expectedGreyColorInHexa);
	}

	@Test(priority = 12)
	public void verifyLeinholderSection_13337_13338_13339_13343_13344_13345_13347() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "34799");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		wme.getProducts("5FNRL6H27NB019645", "100");
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		selectDropDown("Loan");
		enterTermFinanceNadaMsrpApr();
		event.element("xpath", gapRateBtn).click();
		Thread.sleep(30000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 2500)");
		selectProgramPlanAndTermMonths();
		getTxtField("Monthly Payment").sendKeys("100");
		js.executeScript("window.scrollTo(0, 2500)");
		event.clickfield("xpath", genrateContractButton);
		Thread.sleep(2000);
		Assert.assertTrue(getErrorMsg("Lienholder").getText().equals("Required"));
		System.out.println("label1-"+getGridformLabels().get(6).getText());
		System.out.println("label2-"+getGridformLabels().get(7).getText());
		Assert.assertTrue(getGridformLabels().get(6).getText().equals("Lienholder*"));
		Assert.assertTrue(getGridformLabels().get(7).getText().equals("Lienholder Address*"),"Lienholder Address dropdown is displayed after Lienholder field");
		Assert.assertFalse(event.element("xpath", lienholderAddressStatus).isEnabled());
		getTxtFields("Lienholder").get(1).sendKeys("West America Bank");
		getTxtFields("Lienholder").get(1).sendKeys(Keys.ARROW_DOWN , Keys.ENTER);
		Thread.sleep(10000);
		event.clickfield("xpath", lienholderAddressArrow);
		Thread.sleep(1000);
		Assert.assertTrue(event.element("xpath", lienholderAddressTxtfld).getText().equals("RIFEZCCK | SULSUNCITY | CA | 94585"),"Liendholder address filed is in the format of Street | City | State | Zip Code");
		Assert.assertTrue(event.element("xpath", lienholderAddressStatus1).isEnabled());
	}
	
	//NEED TO CHANGE VIN EVRY TIME
//	@Test(priority = 13)
//	public void verifyMsgCreatedSuccessfullyForGapContracts_13358_13368() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
//		Thread.sleep(3000);
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", "28771");
//		Thread.sleep(2000);
//		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
//		Thread.sleep(2000);
//		singleContract();
//		Assert.assertTrue(contractPage.getIconCheckMark().isDisplayed());
//		Assert.assertTrue(contractPage.getSuccessMessage().isDisplayed());
//		Assert.assertTrue(event.element("xpath",contractPage.gapContractFileSuccessMsg).isDisplayed());
//		Assert.assertTrue(contractPage.getBtnViewOrPrintContract().isDisplayed());
//		Assert.assertTrue(contractPage.getGoToContractsPageLink().isDisplayed());
//		Assert.assertTrue(contractPage.getStartNewQuote().isDisplayed());
//		Assert.assertTrue(contractPage.getIconClose().isDisplayed());
//	}
	
	@Test(priority = 14)
	public void verifyLiennholderSectionWhenLeinholderIsAlreadySelected_13353_13354_13355() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "34799");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		String lienholder = "West America Bank";
		getTxtFields("Lienholder").get(0).sendKeys(lienholder);
		getTxtFields("Lienholder").get(0).sendKeys(Keys.ARROW_DOWN , Keys.ENTER);
		Thread.sleep(10000);
		wme.getProducts("5FNRL6H27NB019645", "100");
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		selectDropDown("Loan");
		enterTermFinanceNadaMsrpApr();
		event.element("xpath", gapRateBtn).click();
		Thread.sleep(30000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 2500)");
		selectProgramPlanAndTermMonths();
		getTxtField("Monthly Payment").sendKeys("100");
		js.executeScript("window.scrollTo(0, 2500)");
		Thread.sleep(1000);
		Assert.assertTrue(getTxtFields("Lienholder").get(1).getAttribute("value").equals(lienholder));
		Assert.assertFalse(getDisabledLienholderfld().get(1).isEnabled());
		Assert.assertTrue(event.element("xpath", lienholderAddressStatus1).isEnabled());
	}
	
	@Test(priority = 15)
	public void verifyLienholderSectionWhenNotInList_13356() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "34799");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		event.element("xpath",notOnTheListLink).click();
		Thread.sleep(1000);
		getTxtFields("Lienholder").get(0).sendKeys("Test1");
		Thread.sleep(1000);
		wme.getProducts("5FNRL6H27NB019645", "100");
		event.element("xpath", AddGapCheckBox).click();
		Thread.sleep(2000);
		event.element("xpath", selectDealTypeArrow).click();
		Thread.sleep(1000);
		selectDropDown("Loan");
		enterTermFinanceNadaMsrpApr();
		event.element("xpath", gapRateBtn).click();
		Thread.sleep(30000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 2500)");
		selectProgramPlanAndTermMonths();
		getTxtField("Monthly Payment").sendKeys("100");
		js.executeScript("window.scrollTo(0, 2500)");
		Assert.assertTrue(getTxtFields("Lienholder").get(1).getAttribute("value").equals(""),"lienholder value is blank");
	}
	
//	@Test(priority = 16)
//	public void verify1stPaymntDateField_10077() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
//		Thread.sleep(3000);
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", "34799");
//		Thread.sleep(2000);
//		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
//		Thread.sleep(2000);
//		event.clickfield("xpath", calanderbtn);
//		String dateSelectedInSoldDate = calander.getCurrentDate(3,"MM/dd/yyyy");
//		calander.selectDate(dateSelectedInSoldDate,"MM/dd/yyyy");
//		Thread.sleep(2000);
//		String soldDateTxtFldValue = event.element("cssSelector", textbox).getAttribute("value");
//		wme.getProducts("5FNRL6H27NB019645", "100");
//		Assert.assertTrue(event.element("xpath", results).isDisplayed());
//		event.element("xpath", AddGapCheckBox).click();
//		Thread.sleep(2000);
//		Assert.assertTrue(event.element("xpath", adlGapForm).isDisplayed());
//		event.element("xpath", selectDealTypeArrow).click();
//		Thread.sleep(1000);
//		selectDropDown("Lease");
//		enterTermFinanceNadaMsrpApr();
//		event.element("xpath", gapRateBtn).click();
//		Thread.sleep(30000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollTo(0, 2500)");
//		String dateSelected = calander.getCurrentDate(3,"MM/dd/yyyy");
//		calander.selectDate(dateSelected,"MM/dd/yyyy");
//		Thread.sleep(2000);
//		Assert.assertTrue(getTxtField("1st Pmt Date").getAttribute("value").equals(dateSelected));
//		event.clickfield("xpath", calanderbtn);
//		getTxtField("Monthly Payment").click();
//		Assert.assertTrue(getTxtField("1st Pmt Date").getAttribute("value").equals(dateSelected));
//		Assert.assertTrue(soldDateTxtFldValue.equals(dateSelected));
//	}
	
	@AfterMethod(alwaysRun=true)
	public void close() throws InterruptedException {
		 try {
				login.logout();
				} catch (Exception e) {
					event.getfield("mat-icon", "close").click();
					login.logout();
			}
	    }
	
	
}

