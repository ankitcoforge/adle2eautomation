package testsuite;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.ContractSearchPageAction;
import pageActions.RemitAULAction;
import pageActions.cobuyerContractAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

/* Divyasree */
/* Total Tc's = 81 */

public class RemitAUL_test extends RemitAULAction {
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	// ContractSearchPageAction contractSearchPage = new ContractSearchPageAction();
	singleContractAction singleContract = new singleContractAction();
	cobuyerContractAction cobuyerContract = new cobuyerContractAction();
	impersonateAction ia = new impersonateAction();

	@BeforeClass(alwaysRun = true)
	public void login() throws InterruptedException {
//		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}


//	@Test(priority = 0)
//	public void preCond() throws InterruptedException {
//		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
//		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
//		Thread.sleep(2000);
//		if(!getNoRecordsInGrid().getText().contains("There are no records to display")) {
////		if(getRowLoc().size() < 3 | getNoRecordsInGrid().getText().contains("There are no records to display")) 
//		utils.scrollDownUsingJSE();
////		if(getRowLoc().size() <= 3 )
////				{
//			createContract();
//			}
//		else if (getRowLoc().size() > 3) {
//			getRemitContracts();
//		}
//	
//		login.logout();
//		Thread.sleep(2000);
//		login.login(prop.getProperty("dealerForPaymentDetails"), prop.getProperty("password"));
//		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
//		Thread.sleep(2000);
//		if(!getNoRecordsInGrid().getText().contains("There are no records to display") | getRowLoc().size() < 3) {
////			if(getRowLoc().size() <= 3 ) {
//			createContract();
//			}
//		else if (getRowLoc().size() > 3) {
//			getRemitContracts();
//		}
//		
//	}

	@Test(priority = 1)
	public void verifySelectContractsTabAndAndCheckDetailsTabForCheck_18801_18806_18807_18808()
			throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		
//		String admin = prop.getProperty("adminusername");
//		login.login(admin, prop.getProperty("adminpassword"));
//		Thread.sleep(3000);
//		verticalMenu.navigatetoimpersonate();
//		ia.impersonateUser("Dealer", "78788");
		
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		selectACheckBox();
		Assert.assertTrue((getSelectContractsTab()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
		String expectedOrangeColorInHexa = prop.getProperty("darkOrangeInHexaForm");
		String borderTopColorForSelectTab = getSelectContractByDefault().getCssValue("border-top-color");
		String ActualcolorInHexaformatForSelectTab = Color.fromString(borderTopColorForSelectTab).asHex();
		Assert.assertEquals(ActualcolorInHexaformatForSelectTab, expectedOrangeColorInHexa);

		Assert.assertTrue((getCheckDetailsTab()).isDisplayed());
		Assert.assertEquals((getCheckDetailsTabStatus()).getAttribute("class"), "tab--inactive");
	}

	@Test(priority = 2)
	public void verifySelectContractsTabAndAndPaymentDetailsTabForACH_18809_18810_18811_18812_18864()
			throws InterruptedException {
		login.login(prop.getProperty("dealerForPaymentDetails"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());

		Assert.assertTrue((getSelectContractsTab()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
		String expectedOrangeColorInHexa = prop.getProperty("darkOrangeInHexaForm");
		String borderTopColorForSelectTab = getSelectContractByDefault().getCssValue("border-top-color");
		String ActualcolorInHexaformatForSelectTab = Color.fromString(borderTopColorForSelectTab).asHex();
		Assert.assertEquals(ActualcolorInHexaformatForSelectTab, expectedOrangeColorInHexa);

		Assert.assertTrue((getPaymentDetailsTab()).isDisplayed());
		Assert.assertEquals((getPaymentDetailsTabStatus()).getAttribute("class"), "tab--inactive");
	}

	@Test(priority = 3)
	public void verifySelectContractsTxtDescriptionAndGridHeaders_18818_18819_19056() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
		Assert.assertTrue((getSelectTheContractsTxt()).isDisplayed());
		getAllHeaderNames().contains("Select All");
		getAllHeaderNames().contains("Contract");
		getAllHeaderNames().contains("VIN");
		getAllHeaderNames().contains("Program");
		getAllHeaderNames().contains("First Name");
		getAllHeaderNames().contains("Last Name");
		getAllHeaderNames().contains("Term");
		getAllHeaderNames().contains("Lienholder");
		getAllHeaderNames().contains("Sale Date");
		getAllHeaderNames().contains("AUL Price");
		getAllHeaderNames().contains("Retail Price");
	}

	@Test(priority = 4)
	public void verifyPrefixForMonetoryGridValue_18821() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");

		utils.scrollDown();
		getContractsGrid().isDisplayed();
		HashMap<Integer, HashMap<String, WebElement>> gridElementsBody = getElementsFromGridBody();
		String aulPrice = gridElementsBody.get(1).get("AUL Price").getText();
		Assert.assertTrue(aulPrice.startsWith("$"));
		String ratailPrice = gridElementsBody.get(1).get("Retail Price").getText();
		Assert.assertTrue(ratailPrice.startsWith("$"));
	}

	@Test(priority = 5)
	public void verifyRowsPerPageDropDownAndRangeMsg_18826_18830() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
		utils.scrollDown();

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getRowsPerPageDropdownbtn());
		Thread.sleep(1000);
		getRowsPerPageDropdownlist().get(0).click();
		Thread.sleep(1000);
		Assert.assertTrue(getCurrentPageRecordCount() < 26, "Page 1 is displaying");
		Assert.assertTrue(getCurrentPageRecord().isDisplayed());

	}

	@Test(priority = 6)
	public void verifyEnablingAndDisablingCheckDetailsTabForCheck_18862_18863() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
		utils.scrollDown();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if (getSelectStatusCheckBoxInGrid(i).isSelected()) {
				js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(i));
			}
		}
		Thread.sleep(3000);
		utils.scrollUp();
		//Assert.assertEquals((getCheckDetailsTabStatus()).getAttribute("class"), "tab--inactive tab--disabled");
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		Thread.sleep(1000);
		Assert.assertEquals((getCheckDetailsTabStatus()).getAttribute("class"), "tab--inactive");
	}

	// BUG
	@Test(priority = 7,enabled = false)
	public void verifyEnablingAndDisablingPaymentDetailsTabForACH_18864_18865() throws InterruptedException {
		login.login(prop.getProperty("dealerForPaymentDetails"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
		utils.scrollDown();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if (getSelectStatusCheckBoxInGrid(i).isSelected()) {
				js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(i));
			}
		}
		Thread.sleep(2000);
		utils.scrollUp();
		Assert.assertEquals((getPaymentDetailsTabStatus()).getAttribute("class"), "tab--inactive tab--disabled");
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		Thread.sleep(1000);
		Assert.assertEquals((getPaymentDetailsTabStatus()).getAttribute("class"), "tab--inactive");
	}

	@Test(priority = 8)
	public void verifyContractIsSelectableAndDeselectable_18859_18860_18861() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
		Thread.sleep(2000);
		utils.scrollLittleDownUsingJSE();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (getRowLoc().size() > 1 && getSelectStatusCheckBoxInGrid(1).isSelected()) {
			js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		}
		Assert.assertFalse(getSelectStatusCheckBoxInGrid(1).isSelected());
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		Assert.assertTrue(getSelectStatusCheckBoxInGrid(1).isSelected(), "Contract row is selectable");
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if (!getSelectStatusCheckBoxInGrid(i).isSelected()) {
				js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(i));
			}
		}
		for (int i = 1; i <= getRowLoc().size(); i++) {
		Assert.assertTrue(getSelectStatusCheckBoxInGrid(i).isSelected(), "Multiple Contract rows are selectable");
		}
		}

	
	@Test(priority = 9)
	public void verifySortingFunctionalityForColoumns_18980_18984_18986_18987_18988_18992()
			throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		utils.scrollLittleDownUsingJSE();
		getContractsGrid().isDisplayed();
		getHeaderInTheGrid("Program").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForProgram = getElementsFromGridBody();
		ArrayList<String> obtainedListProgram = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String program = allTableDataForProgram.get(i).get("Program").getText();
			obtainedListProgram.add(program);
		}
		ArrayList<String> programListBeforeSort = obtainedListProgram;
		System.out.println(programListBeforeSort);
		Collections.sort(obtainedListProgram);
		System.out.println(obtainedListProgram);
		Assert.assertEquals(programListBeforeSort, obtainedListProgram, "Sorted Alphabetically in ascending order");

		// color validation
		String expectedProgramColorColorInHexa = prop.getProperty("darkOrangeInHexaForm");
		String programColor = getHeaderInTheGrid("Program").getCssValue("color");
		String actualProgramColor = Color.fromString(programColor).asHex();
		Assert.assertEquals(actualProgramColor, expectedProgramColorColorInHexa);

		getHeaderInTheGrid("Program").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForProgramOnDoubleClick = getElementsFromGridBody();
		ArrayList<String> obtainedListProgramOnArrowClick2 = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String program = allTableDataForProgramOnDoubleClick.get(i).get("Program").getText();
			obtainedListProgramOnArrowClick2.add(program);
		}
		System.out.println(obtainedListProgramOnArrowClick2);
		Collections.reverse(obtainedListProgram);
		System.out.println(obtainedListProgram);
		Assert.assertTrue(obtainedListProgramOnArrowClick2.equals(obtainedListProgram),
				"Sorted Alphabetically in descending order");

		Thread.sleep(1000);

		getHeaderInTheGrid("First Name").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstName = getElementsFromGridBody();
		;
		ArrayList<String> obtainedListFirstName = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstName = allTableDataForFirstName.get(i).get("First Name").getText();
			obtainedListFirstName.add(firstName);
		}
		ArrayList<String> firstNameListBeforeSort = obtainedListFirstName;
		System.out.println(firstNameListBeforeSort);
		Collections.sort(obtainedListFirstName);
		System.out.println(obtainedListFirstName);
		Assert.assertEquals(firstNameListBeforeSort, obtainedListFirstName);

		getHeaderInTheGrid("First Name").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstNameOnDoubleClick = getElementsFromGridBody();
		ArrayList<String> obtainedListFirstNameOnDoubleClick = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstName = allTableDataForFirstNameOnDoubleClick.get(i).get("First Name").getText();
			obtainedListFirstNameOnDoubleClick.add(firstName);
		}
		System.out.println(obtainedListFirstNameOnDoubleClick);
		Collections.reverse(obtainedListFirstName);
		System.out.println(obtainedListFirstName);
		Assert.assertEquals(obtainedListFirstNameOnDoubleClick, obtainedListFirstName);

		Thread.sleep(1000);

		getHeaderInTheGrid("Last Name").click();
		Thread.sleep(1000);
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLastName = getElementsFromGridBody();
		;
		ArrayList<String> obtainedListLastName = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastName = allTableDataForLastName.get(i).get("Last Name").getText();
			obtainedListLastName.add(lastName);
		}
		ArrayList<String> lastNameListBeforeSort = obtainedListLastName;
		System.out.println(lastNameListBeforeSort);
		Collections.sort(obtainedListLastName);
		System.out.println(obtainedListLastName);
		Assert.assertEquals(lastNameListBeforeSort, obtainedListLastName);

		getHeaderInTheGrid("Last Name").click();
		Thread.sleep(10000);
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLastNameOnDoubleClick = getElementsFromGridBody();
		ArrayList<String> obtainedListLastNameOnDoubleClick = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastName = allTableDataForLastNameOnDoubleClick.get(i).get("Last Name").getText();
			obtainedListLastNameOnDoubleClick.add(lastName);
		}
		System.out.println(obtainedListLastNameOnDoubleClick);
		Collections.reverse(obtainedListLastName);
		System.out.println(obtainedListLastName);
		Assert.assertEquals(obtainedListLastNameOnDoubleClick, obtainedListLastName);

		Thread.sleep(1000);

		getHeaderInTheGrid("Lienholder").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLienholder = getElementsFromGridBody();
		;
		ArrayList<String> obtainedListLienholder = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lienholder = allTableDataForLienholder.get(i).get("Lienholder").getText();
			obtainedListLienholder.add(lienholder);
		}
		ArrayList<String> lienholderListBeforeSort = obtainedListLienholder;
		System.out.println(lienholderListBeforeSort);
		Collections.sort(obtainedListLienholder);
		System.out.println(obtainedListLienholder);
		Assert.assertEquals(lienholderListBeforeSort, obtainedListLienholder);

		getHeaderInTheGrid("Lienholder").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLienholderOnDoubleClick = getElementsFromGridBody();
		ArrayList<String> obtainedListLienholderOnDoubleClick = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lienholder = allTableDataForLienholderOnDoubleClick.get(i).get("Lienholder").getText();
			obtainedListLienholderOnDoubleClick.add(lienholder);
		}
		System.out.println(obtainedListLienholderOnDoubleClick);
		Collections.reverse(obtainedListLienholder);
		System.out.println(obtainedListLienholder);
		Assert.assertEquals(obtainedListLienholderOnDoubleClick, obtainedListLienholder);

	}

	@Test(priority = 10)
	public void verifySortingFunctionalityForColoumns_18995_18996_18997_18998_18999()
			throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		utils.scrollLittleDownUsingJSE();
		getContractsGrid().isDisplayed();
		getHeaderInTheGrid("AUL Price").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForAULPrice = getElementsFromGridBody();
		ArrayList<Integer> obtainedListAULPrice = new ArrayList<Integer>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String aulPrice = allTableDataForAULPrice.get(i).get("AUL Price").getText();
			NumberFormat format = NumberFormat.getCurrencyInstance();
			Number number = format.parse(aulPrice);
			int aulvalueInt = Integer.parseInt(number.toString());
			obtainedListAULPrice.add(aulvalueInt);
		}
		ArrayList<Integer> aulPriceListBeforeSort = obtainedListAULPrice;
		System.out.println(aulPriceListBeforeSort);
		Collections.sort(obtainedListAULPrice);
		Thread.sleep(1000);
		System.out.println(obtainedListAULPrice);
		Assert.assertEquals(aulPriceListBeforeSort, obtainedListAULPrice);

		getHeaderInTheGrid("AUL Price").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForAULPriceOnDoubleClick = getElementsFromGridBody();
		ArrayList<Integer> obtainedListAULPriceOnDoubleClick = new ArrayList<Integer>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String aulPrice = allTableDataForAULPriceOnDoubleClick.get(i).get("AUL Price").getText();
			NumberFormat format = NumberFormat.getCurrencyInstance();
			Number number = format.parse(aulPrice);
			int aulvalueInt = Integer.parseInt(number.toString());
			obtainedListAULPriceOnDoubleClick.add(aulvalueInt);
		}
		System.out.println(obtainedListAULPriceOnDoubleClick);
		Collections.reverse(obtainedListAULPrice);
		Thread.sleep(1000);
		System.out.println(obtainedListAULPrice);
		Assert.assertEquals(obtainedListAULPriceOnDoubleClick, obtainedListAULPrice);

		Thread.sleep(1000);

		getHeaderInTheGrid("Retail Price").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForRetailPrice = getElementsFromGridBody();
		;
		ArrayList<Integer> obtainedListRetailPrice = new ArrayList<Integer>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String retailPrice = allTableDataForRetailPrice.get(i).get("Retail Price").getText();
			NumberFormat format = NumberFormat.getCurrencyInstance();
			Number number = format.parse(retailPrice);
			int retailPriceInt = Integer.parseInt(number.toString());
			obtainedListRetailPrice.add(retailPriceInt);
		}
		ArrayList<Integer> retailPriceListBeforeSort = obtainedListRetailPrice;
		System.out.println(retailPriceListBeforeSort);
		Collections.sort(obtainedListRetailPrice);
		System.out.println(obtainedListRetailPrice);
		Assert.assertEquals(retailPriceListBeforeSort, obtainedListRetailPrice);

		getHeaderInTheGrid("Retail Price").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForRetailPriceOnDoubleClick = getElementsFromGridBody();
		ArrayList<Integer> obtainedListRetailPriceOnDoubleClick = new ArrayList<Integer>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String retailPrice = allTableDataForRetailPriceOnDoubleClick.get(i).get("Retail Price").getText();
			NumberFormat format = NumberFormat.getCurrencyInstance();
			Number number = format.parse(retailPrice);
			int retailPriceInt = Integer.parseInt(number.toString());
			obtainedListRetailPriceOnDoubleClick.add(retailPriceInt);
		}
		System.out.println(obtainedListRetailPriceOnDoubleClick);
		Collections.reverse(obtainedListRetailPrice);
		System.out.println(obtainedListRetailPrice);
		Assert.assertEquals(obtainedListRetailPriceOnDoubleClick, obtainedListRetailPrice);

		Thread.sleep(1000);

		getHeaderInTheGrid("Term Months").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForTermMonths = getElementsFromGridBody();
		;
		ArrayList<Integer> obtainedListTerm = new ArrayList<Integer>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String termMonths = allTableDataForTermMonths.get(i).get("Term Months").getText();
			NumberFormat format = NumberFormat.getNumberInstance();
			Number number = format.parse(termMonths);
			int termMonthsInt = Integer.parseInt(number.toString());
			obtainedListTerm.add(termMonthsInt);
		}
		ArrayList<Integer> termListBeforeSort = obtainedListTerm;
		System.out.println(termListBeforeSort);
		Collections.sort(obtainedListTerm);
		System.out.println(obtainedListTerm);
		Assert.assertEquals(termListBeforeSort, obtainedListTerm);

		getHeaderInTheGrid("Term Months").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForTermMonthsOnDoubleClick = getElementsFromGridBody();
		ArrayList<Integer> obtainedListTermMonthsOnDoubleClick = new ArrayList<Integer>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String termMonths = allTableDataForTermMonthsOnDoubleClick.get(i).get("Term Months").getText();
			NumberFormat format = NumberFormat.getNumberInstance();
			Number number = format.parse(termMonths);
			int termMonthsInt = Integer.parseInt(number.toString());
			obtainedListTermMonthsOnDoubleClick.add(termMonthsInt);
		}
		System.out.println(obtainedListTermMonthsOnDoubleClick);
		Collections.reverse(obtainedListTerm);
		System.out.println(obtainedListTerm);
		Assert.assertEquals(obtainedListTermMonthsOnDoubleClick, obtainedListTerm);

		Thread.sleep(1000);

		getHeaderInTheGrid("Contract").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForContract = getElementsFromGridBody();
		;
		ArrayList<String> obtainedListContract = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String contract = allTableDataForContract.get(i).get("Contract").getText();
			obtainedListContract.add(contract);
		}
		ArrayList<String> contractListBeforeSort = obtainedListContract;
		System.out.println(contractListBeforeSort);
		Collections.sort(obtainedListContract);
		System.out.println(obtainedListContract);
		Assert.assertEquals(contractListBeforeSort, obtainedListContract);

		getHeaderInTheGrid("Contract").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForContractOnDoubleClick = getElementsFromGridBody();
		ArrayList<String> obtainedListContractOnDoubleClick = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String contract = allTableDataForContractOnDoubleClick.get(i).get("Contract").getText();
			obtainedListContractOnDoubleClick.add(contract);
		}
		System.out.println(obtainedListContractOnDoubleClick);
		Collections.reverse(obtainedListContract);
		System.out.println(obtainedListContract);
		Assert.assertEquals(obtainedListContractOnDoubleClick, obtainedListContract);

		Thread.sleep(1000);

		getHeaderInTheGrid("VIN").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForVIN = getElementsFromGridBody();
		ArrayList<String> obtainedListVIN = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String VIN = allTableDataForVIN.get(i).get("VIN").getText();
			obtainedListVIN.add(VIN);
		}
		ArrayList<String> VINListBeforeSort = obtainedListVIN;
		System.out.println(VINListBeforeSort);
		Collections.sort(obtainedListVIN);
		System.out.println(obtainedListVIN);
		Assert.assertEquals(VINListBeforeSort, obtainedListVIN);

		getHeaderInTheGrid("VIN").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForVINOnDoubleClick = getElementsFromGridBody();
		ArrayList<String> obtainedListVINOnDoubleClick = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String VIN = allTableDataForVINOnDoubleClick.get(i).get("VIN").getText();
			obtainedListVINOnDoubleClick.add(VIN);
		}
		System.out.println(obtainedListVINOnDoubleClick);
		Collections.reverse(obtainedListVIN);
		System.out.println(obtainedListVIN);
		Assert.assertEquals(obtainedListVINOnDoubleClick, obtainedListVIN);

	}

//	@Test(priority = 11)
//	public void verifyCalenderDropdownOnSaleDateField_19003() throws InterruptedException, ParseException {
//		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
//		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
//		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
//		Thread.sleep(2000);
//		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
//		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
//		Thread.sleep(3000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollTo(0, 2500)");
//		getCalenderIcon().click();
//		Thread.sleep(2000);
//		Assert.assertTrue(getCalenderPopup().isDisplayed());
//		getCalenderIcon().click();
//
//	}

	@Test(priority = 12)
	public void verifyTextFiltersWithCharectersInGridColoumns_19011_19012_19013_19014_19015_19016_19023_19024_19025_19246() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
		Thread.sleep(2000);
		String[] lienholderFirstLetter = getElementsFromGridBody().get(1).get("Lienholder").getText().split("");
		getSearchBoxesInGrid().get("Lienholder").sendKeys(lienholderFirstLetter[0]);
		Thread.sleep(2000);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String elementTxt = getElementsFromGridBody().get(i).get("Lienholder").getText();
			Assert.assertTrue(elementTxt.startsWith(lienholderFirstLetter[0]));
		}
		getSearchBoxesInGrid().get("Lienholder").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);

		String[] lastNameFirstLetter = getElementsFromGridBody().get(1).get("Last Name").getText().split("");
		getSearchBoxesInGrid().get("Last Name").sendKeys(lastNameFirstLetter[0]);
		Thread.sleep(2000);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String elementTxt = getElementsFromGridBody().get(i).get("Last Name").getText();
			Assert.assertTrue(elementTxt.startsWith(lastNameFirstLetter[0]));
		}
		getSearchBoxesInGrid().get("Last Name").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);

		String[] firstNameFirstLetter = getElementsFromGridBody().get(1).get("First Name").getText().split("");
		getSearchBoxesInGrid().get("First Name").sendKeys(firstNameFirstLetter[0]);
		Thread.sleep(2000);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String elementTxt = getElementsFromGridBody().get(i).get("First Name").getText();
			Assert.assertTrue(elementTxt.startsWith(firstNameFirstLetter[0]));
		}
		getSearchBoxesInGrid().get("First Name").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);

		String[] programFirstLetter = getElementsFromGridBody().get(1).get("Program").getText().split("");
		getSearchBoxesInGrid().get("Program").sendKeys(programFirstLetter[0]);
		Thread.sleep(2000);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String elementTxt = getElementsFromGridBody().get(i).get("Program").getText();
			Assert.assertTrue(elementTxt.startsWith(programFirstLetter[0]));
		}
		getSearchBoxesInGrid().get("Program").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);

		String[] vinFirstLetter = getElementsFromGridBody().get(1).get("VIN").getText().split("");
		getSearchBoxesInGrid().get("VIN").sendKeys(vinFirstLetter[0]);
		Thread.sleep(2000);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String elementTxt = getElementsFromGridBody().get(i).get("VIN").getText();
			Assert.assertTrue(elementTxt.startsWith(vinFirstLetter[0]));
		}
		getSearchBoxesInGrid().get("VIN").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);

		String[] contractNoFirstLetter = getElementsFromGridBody().get(1).get("Contract").getText().split("");
		getSearchBoxesInGrid().get("Contract").sendKeys(contractNoFirstLetter[0]);
		Thread.sleep(2000);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String elementTxt = getElementsFromGridBody().get(i).get("Contract").getText();
			Assert.assertTrue(elementTxt.startsWith(contractNoFirstLetter[0]));
		}
		getSearchBoxesInGrid().get("Contract").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);

		String termMonths = getElementsFromGridBody().get(1).get("Term Months").getText();
		getSearchBoxesInGrid().get("Term Months").sendKeys(termMonths);
		Thread.sleep(2000);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String elementTxt = getElementsFromGridBody().get(i).get("Term Months").getText();
			Assert.assertTrue(elementTxt.equals(termMonths));
		}
		getSearchBoxesInGrid().get("Term Months").sendKeys(Keys.BACK_SPACE);
		getSearchBoxesInGrid().get("Term Months").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);

		String aulPrice = getElementsFromGridBody().get(1).get("AUL Price").getText();
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(aulPrice);
		String aulValue = number.toString();

		getSearchBoxesForAULandRetailPrice().get("AUL Price").sendKeys(aulValue);
		Thread.sleep(2000);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String elementTxt = getElementsFromGridBody().get(i).get("AUL Price").getText();
			Assert.assertTrue(elementTxt.equals(aulPrice));
		}
		getSearchBoxesForAULandRetailPrice().get("AUL Price").clear();
		Thread.sleep(2000);

		String retailPrice = getElementsFromGridBody().get(1).get("Retail Price").getText();
		NumberFormat format2 = NumberFormat.getCurrencyInstance();
		Number number2 = format2.parse(retailPrice);
		String retailValue = number2.toString();

		getSearchBoxesForAULandRetailPrice().get("Retail Price").sendKeys(retailValue);
		Thread.sleep(2000);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String elementTxt = getElementsFromGridBody().get(i).get("Retail Price").getText();
			Assert.assertTrue(elementTxt.equals(retailPrice));
		}
		getSearchBoxesForAULandRetailPrice().get("Retail Price").clear();
	}

	@Test(priority = 13)
	public void verifySelectAllCheckBox_19032_19033_19035() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 2000)");
		js.executeScript("arguments[0].click();", getSelectAllCheckBox());
		for (int i = 0; i <= getRowLoc().size() - 1; i++) {

			Assert.assertTrue(getCheckBoxes().get(i).isSelected());
		}

		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", getSelectAllCheckBox());
		for (int i = 0; i <= getRowLoc().size() - 1; i++) {

			Assert.assertFalse(getCheckBoxes().get(i).isSelected());
		}

	}

	@Test(priority = 14)
	public void verifySelectAllCheckBoxWithOneOptionSelected_19034() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");

		for (int i = 0; i <= getRowLoc().size() - 1; i++) {
			if (getCheckBoxes().get(i).getAttribute("aria-checked").equals("false")) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].scrollIntoView()", getSelectCheckBoxes().get(i));
				getSelectCheckBoxes().get(i).click();
			}
		}
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", getSelectAllCheckBox());
		for (int i = 0; i <= getRowLoc().size() - 1; i++) {

			Assert.assertTrue(getCheckBoxes().get(i).isSelected());
		}
	}

	@Test(priority = 15)
	public void verifyNumOfDigitsInVINcoloumn_19057() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");

		HashMap<Integer, HashMap<String, WebElement>> gridElementsBody = getElementsFromGridBody();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			int vinTxt = gridElementsBody.get(i).get("VIN").getText().length();
			Assert.assertEquals(vinTxt, 6);
		}
	}

	@Test(priority = 16)
	public void verifyPaymentDetailsTabCheckBox_19135_19143() throws InterruptedException {
		login.login(prop.getProperty("dealerForPaymentDetails"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertTrue((getPaymentDetailsTab()).isDisplayed());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		getPaymentDetailsTab().click();
		Thread.sleep(1000);
		getPaymentDetailCheckBox().click();
		Assert.assertTrue(getPaymentDetailCheckBoxAttribute().isSelected());
		getPaymentDetailCheckBox().click();
		Assert.assertFalse(getPaymentDetailCheckBoxAttribute().isSelected());
	}

	@Test(priority = 17)
	public void verifyDeletedTxtOnSearchBox_19139_19231() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");

		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertTrue(getSearchBoxInSelectContractsTab().isDisplayed());
		Thread.sleep(2000);
		String[] contractNoFirstLetter = getElementsFromGridBody().get(1).get("Contract").getText().split("");
		getSearchBoxInSelectContractsTab().sendKeys("123ABC!");
		Thread.sleep(2000);
		Assert.assertTrue(getSearchBoxInSelectContractsTab().getAttribute("value").equals("123ABC!"));

		getSearchBoxInSelectContractsTab().clear();
		Thread.sleep(2000);
		getSearchBoxInSelectContractsTab().sendKeys(contractNoFirstLetter[0]);
		Thread.sleep(2000);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String elementTxt = getElementsFromGridBody().get(i).get("Contract").getText();
			Assert.assertTrue(elementTxt.contains(contractNoFirstLetter[0]));
		}
		getSearchBoxInSelectContractsTab().clear();
		Thread.sleep(2000);
		Assert.assertTrue(getSearchBoxInSelectContractsTab().getAttribute("value").equals(""));
	}

	@Test(priority = 18)
	public void verifyChkBoxTxtAndCommentsBox_19144_19173_19178_19181_19183() throws InterruptedException {
		login.login(prop.getProperty("dealerForPaymentDetails"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, 1500)");
//		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		getPaymentDetailsTab().click();
		Thread.sleep(1000);
		Assert.assertFalse(getPaymentDetailCheckBoxAttribute().isSelected());
		Assert.assertTrue(getPaymentDetailsChkBxTxt().isDisplayed());
		Assert.assertTrue(getPaymentDetailsCommentsBox().isDisplayed());
		Assert.assertTrue(getCommentsTitleTxt().isDisplayed());
		getPaymentDetailsCommentsBox().sendKeys("123ABC!");
		Assert.assertTrue(getPaymentDetailsCommentsBox().getAttribute("value").equals("123ABC!"));
		Assert.assertTrue(getPaymentDetailsCommentsBox().getAttribute("maxlength").equals("52"));
		getPaymentDetailsCommentsBox().clear();
		Assert.assertTrue(getPaymentDetailsCommentsBox().getAttribute("value").equals(""));
	}

	@Test(priority = 19)
	public void verifyMonetoryIconAndlengthInSearchBar_19226_19245() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertTrue(getSearchBoxInSelectContractsTab().isDisplayed());
		Assert.assertEquals(getSearchBoxInSelectContractsTab().getAttribute("maxlength"), "50");
		getSearchBoxInSelectContractsTab().sendKeys("$");
		Thread.sleep(1000);
		Assert.assertTrue(getNoRecordsTxt().isDisplayed());
	}

	@Test(priority = 20)
	public void verifyTotalDueCalculationWhenNoContractIsSelected_19279_19280()
			throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		for (int i = 1; i <= getRowLoc().size(); i++) {
//			if (getSelectStatusCheckBoxInGrid(i).isSelected()) {
//				js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(i));
//			}
//		}
		//utils.scrollUp();
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", getSelectAllCheckBox());
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", getSelectAllCheckBox());
		
		//Assert.assertEquals((getCheckDetailsTabStatus()).getAttribute("class"), "tab--inactive tab--disabled");
		utils.scrollDown();
		Assert.assertTrue(getTotalDueTxt().isDisplayed());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(getTotalDueValue());
		int totalDue = Integer.parseInt(number.toString());
		Assert.assertEquals(totalDue, 0);
	}
	
	@Test(priority = 21)
	public void verifyFixedBarAfterNoRecordsMsg_19284() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", getSelectAllCheckBox());
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", getSelectAllCheckBox());
		Thread.sleep(2000);
		getSearchBoxesInGrid().get("Last Name").sendKeys("$");
		Thread.sleep(1000);
		Assert.assertTrue(getNoRecordsTxt().isDisplayed());
		Assert.assertEquals((getCheckDetailsTabStatus()).getAttribute("class"), "tab--inactive tab--disabled");
		Assert.assertTrue(getTotalDueTxt().isDisplayed());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(getTotalDueValue());
		int totalDue = Integer.parseInt(number.toString());
		Assert.assertEquals(totalDue, 0);
	}
	
	@Test(priority = 22)
	public void verifyMonetoryIconForTotalDueAndCheckAmount_19287() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue(getTotalDueValue().contains("$"));
		Assert.assertTrue(getCheckAmountValue().contains("$"));
	}
	
	@Test(priority = 23)
	public void verifyCheckAmountWhenChangingTabs_19291() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if (getSelectStatusCheckBoxInGrid(i).isSelected()) {
				js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(i));
			}
		}
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		Thread.sleep(2000);
		Assert.assertTrue(getCheckDetailsTab().isEnabled());
		getCheckDetailsTab().click();
		getCheckAmountFieldInCheckdetailsTab().sendKeys(Keys.BACK_SPACE);
		getCheckAmountFieldInCheckdetailsTab().sendKeys(Keys.BACK_SPACE);
		getCheckAmountFieldInCheckdetailsTab().sendKeys(Keys.BACK_SPACE);
		getCheckAmountFieldInCheckdetailsTab().sendKeys(Keys.BACK_SPACE);
		getCheckAmountFieldInCheckdetailsTab().sendKeys(Keys.BACK_SPACE);
		getCheckAmountFieldInCheckdetailsTab().sendKeys(Keys.BACK_SPACE);
		getCheckAmountFieldInCheckdetailsTab().sendKeys(Keys.BACK_SPACE);
		getCheckAmountFieldInCheckdetailsTab().sendKeys(Keys.BACK_SPACE);
		getCheckAmountFieldInCheckdetailsTab().sendKeys("10000");
		Thread.sleep(2000);
		Assert.assertEquals(getCheckAmountFieldInCheckdetailsTab().getAttribute("value"),"10,000");
		utils.scrollDown();
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(getCheckAmountValue());
		int checkAmountValue = Integer.parseInt(number.toString());
		System.out.println("-----"+checkAmountValue);
		Assert.assertEquals(checkAmountValue,10000,"Check amount value is updated in check deatils tab");
		Assert.assertTrue((getSelectContractsTab()).isDisplayed());
		getSelectContractsTab().click();
		Assert.assertEquals(checkAmountValue,10000,"Check amount value is updated in select contracts tab");
	}
	
	@Test(priority = 24)
	public void verifyPlaceholder_18978_19179_19225() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerForPaymentDetails"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
		Assert.assertTrue(getCalenderPlaceholder().getAttribute("aria-haspopup").equals("dialog"),"There is popup and has no placeholder");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		getPaymentDetailsTab().click();
		Thread.sleep(1000);
		Assert.assertTrue(getCommentsTitleTxt().isDisplayed());
		getPaymentDetailsCommentsBox().sendKeys("123ABC!");
		Assert.assertTrue(getPaymentDetailsCommentsBox().getAttribute("value").equals("123ABC!"),"Allows Numbers,Letters,Special charecters");
		Assert.assertTrue(getPaymentDetailsCommentsBox().getTagName().equals("textarea"));
		getSelectContractsTab().click();
		Assert.assertTrue(getSearchBoxInSelectContractsTab().isDisplayed());
		Assert.assertTrue(getSearchBoxInSelectContractsTab().getAttribute("placeholder").equals("Search"));
	}
	
	@Test(priority = 25)
	public void verifyClearFiltersLinkFunctionalityForSearchFilter_19248() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
		
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstName = getElementsFromGridBody();
		ArrayList<String> firstNameListBefore = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt= allTableDataForFirstName.get(i).get("First Name").getText();
			firstNameListBefore.add(firstNameTxt);
		}
		
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLastName = getElementsFromGridBody();
		ArrayList<String> lastNameListBefore = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastNameTxt= allTableDataForFirstName.get(i).get("Last Name").getText();
			lastNameListBefore.add(lastNameTxt);
		}
		utils.scrollLittleDownUsingJSE();
		getHeaderInTheGrid("First Name").click();
		ArrayList<String> obtainedListFirstName = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt = allTableDataForFirstName.get(i).get("First Name").getText();
			obtainedListFirstName.add(firstNameTxt);
		}
		ArrayList<String> firstNameListBeforeSort = obtainedListFirstName;
		System.out.println(firstNameListBeforeSort);
		Collections.sort(obtainedListFirstName);
		System.out.println(obtainedListFirstName);
		Assert.assertEquals(firstNameListBeforeSort, obtainedListFirstName);

		getHeaderInTheGrid("First Name").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstNameOnDoubleClick = getElementsFromGridBody();
		ArrayList<String> obtainedListFirstNameOnDoubleClick = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt = allTableDataForFirstNameOnDoubleClick.get(i).get("First Name").getText();
			obtainedListFirstNameOnDoubleClick.add(firstNameTxt);
		}
		System.out.println(obtainedListFirstNameOnDoubleClick);
		Collections.reverse(obtainedListFirstName);
		System.out.println(obtainedListFirstName);
		Assert.assertEquals(obtainedListFirstNameOnDoubleClick, obtainedListFirstName);
		
		String expectedFirstNameColorInHexa = prop.getProperty("darkOrangeInHexaForm");
		String firstNameColor = getHeaderInTheGrid("First Name").getCssValue("color");
		String actualFirstNameColor = Color.fromString(firstNameColor).asHex();
		Assert.assertEquals(actualFirstNameColor, expectedFirstNameColorInHexa,"Orange color");

		Thread.sleep(1000);

		getHeaderInTheGrid("Last Name").click();
		Thread.sleep(1000);
		ArrayList<String> obtainedListLastName = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastNameTxt = allTableDataForLastName.get(i).get("Last Name").getText();
			obtainedListLastName.add(lastNameTxt);
		}
		ArrayList<String> lastNameListBeforeSort = obtainedListLastName;
		System.out.println(lastNameListBeforeSort);
		Collections.sort(obtainedListLastName);
		System.out.println(obtainedListLastName);
		Assert.assertEquals(lastNameListBeforeSort, obtainedListLastName);

		getHeaderInTheGrid("Last Name").click();
		Thread.sleep(10000);
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLastNameOnDoubleClick = getElementsFromGridBody();
		ArrayList<String> obtainedListLastNameOnDoubleClick = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastNameTxt = allTableDataForLastNameOnDoubleClick.get(i).get("Last Name").getText();
			obtainedListLastNameOnDoubleClick.add(lastNameTxt);
		}
		System.out.println(obtainedListLastNameOnDoubleClick);
		Collections.reverse(obtainedListLastName);
		System.out.println(obtainedListLastName);
		Assert.assertEquals(obtainedListLastNameOnDoubleClick, obtainedListLastName);
		
		String expectedLastNameColorInHexa = prop.getProperty("darkOrangeInHexaForm");
		String lastNameColor = getHeaderInTheGrid("Last Name").getCssValue("color");
		String actualLastNameColor = Color.fromString(lastNameColor).asHex();
		Assert.assertEquals(actualLastNameColor, expectedLastNameColorInHexa,"Orange color");

		String[] contractNoFirstLetter = getElementsFromGridBody().get(1).get("Contract").getText().split("");
		getSearchBoxInSelectContractsTab().clear();
		Thread.sleep(2000);
		getSearchBoxInSelectContractsTab().sendKeys(contractNoFirstLetter[0]);
		Thread.sleep(2000);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String elementTxt = getElementsFromGridBody().get(i).get("Contract").getText();
			Assert.assertTrue(elementTxt.contains(contractNoFirstLetter[0]));
		}
		Thread.sleep(1000);
		utils.scrollUp();
		getClearFiltersTxt().click();
		
		Thread.sleep(2000);
		
		String expectedFirstNameColorInHexaBlack = prop.getProperty("blackColorInHexaForm");
		String firstNameColorBlack = getHeaderInTheGrid("First Name").getCssValue("color");
		String actualFirstNameColorBlack = Color.fromString(firstNameColorBlack).asHex();
		Assert.assertEquals(actualFirstNameColorBlack, expectedFirstNameColorInHexaBlack,"Orange color changed to black after clear filters");
		
		String expectedLastNameColorInHexaBlack = prop.getProperty("blackColorInHexaForm");
		String lastNameColorBlack = getHeaderInTheGrid("Last Name").getCssValue("color");
		String actualLastNameColorBlack = Color.fromString(lastNameColorBlack).asHex();
		Assert.assertEquals(actualLastNameColorBlack, expectedLastNameColorInHexaBlack,"Orange color changed to black after clear filters");
		
		Thread.sleep(2000);
		
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstNameAftrClearFilter = getElementsFromGridBody();
		ArrayList<String> firstNameAfterClearFilter = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt = allTableDataForFirstNameAftrClearFilter.get(i).get("First Name").getText();
			firstNameAfterClearFilter.add(firstNameTxt);
		}
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLastNameAfterClearFilter = getElementsFromGridBody();
		ArrayList<String> lastNameAftrClearFilter = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastName = allTableDataForLastNameAfterClearFilter.get(i).get("Last Name").getText();
			lastNameAftrClearFilter.add(lastName);
		}
		Assert.assertEquals(lastNameAftrClearFilter, lastNameListBefore);
	}
	
	@Test(priority = 26)
	public void verifyClearFiltersLinkFunctionalityForColoumnFilter_19249() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
		
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstName = getElementsFromGridBody();
		ArrayList<String> firstNameListBefore = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt= allTableDataForFirstName.get(i).get("First Name").getText();
			firstNameListBefore.add(firstNameTxt);
		}
		
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLastName = getElementsFromGridBody();
		ArrayList<String> lastNameListBefore = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastNameTxt= allTableDataForFirstName.get(i).get("Last Name").getText();
			lastNameListBefore.add(lastNameTxt);
		}
		utils.scrollLittleDownUsingJSE();
		getHeaderInTheGrid("First Name").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstName2 = getElementsFromGridBody();
		ArrayList<String> obtainedListFirstName = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt = allTableDataForFirstName2.get(i).get("First Name").getText();
			obtainedListFirstName.add(firstNameTxt);
		}
		ArrayList<String> firstNameListBeforeSort = obtainedListFirstName;
		System.out.println(firstNameListBeforeSort);
		Collections.sort(obtainedListFirstName);
		System.out.println(obtainedListFirstName);
		Assert.assertEquals(firstNameListBeforeSort, obtainedListFirstName);

		getHeaderInTheGrid("First Name").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstNameOnDoubleClick = getElementsFromGridBody();
		ArrayList<String> obtainedListFirstNameOnDoubleClick = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt = allTableDataForFirstNameOnDoubleClick.get(i).get("First Name").getText();
			obtainedListFirstNameOnDoubleClick.add(firstNameTxt);
		}
		System.out.println(obtainedListFirstNameOnDoubleClick);
		Collections.reverse(obtainedListFirstName);
		System.out.println(obtainedListFirstName);
		Assert.assertEquals(obtainedListFirstNameOnDoubleClick, obtainedListFirstName);
		
		String expectedFirstNameColorInHexa = prop.getProperty("darkOrangeInHexaForm");
		String firstNameColor = getHeaderInTheGrid("First Name").getCssValue("color");
		String actualFirstNameColor = Color.fromString(firstNameColor).asHex();
		Assert.assertEquals(actualFirstNameColor, expectedFirstNameColorInHexa,"Orange color");

		Thread.sleep(1000);

		getHeaderInTheGrid("Last Name").click();
		Thread.sleep(1000);
		ArrayList<String> obtainedListLastName = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastNameTxt = allTableDataForLastName.get(i).get("Last Name").getText();
			obtainedListLastName.add(lastNameTxt);
		}
		ArrayList<String> lastNameListBeforeSort = obtainedListLastName;
		System.out.println(lastNameListBeforeSort);
		Collections.sort(obtainedListLastName);
		System.out.println(obtainedListLastName);
		Assert.assertEquals(lastNameListBeforeSort, obtainedListLastName);

		getHeaderInTheGrid("Last Name").click();
		Thread.sleep(10000);
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLastNameOnDoubleClick = getElementsFromGridBody();
		ArrayList<String> obtainedListLastNameOnDoubleClick = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastNameTxt = allTableDataForLastNameOnDoubleClick.get(i).get("Last Name").getText();
			obtainedListLastNameOnDoubleClick.add(lastNameTxt);
		}
		System.out.println(obtainedListLastNameOnDoubleClick);
		Collections.reverse(obtainedListLastName);
		System.out.println(obtainedListLastName);
		Assert.assertEquals(obtainedListLastNameOnDoubleClick, obtainedListLastName);
		
		String expectedLastNameColorInHexa = prop.getProperty("darkOrangeInHexaForm");
		String lastNameColor = getHeaderInTheGrid("Last Name").getCssValue("color");
		String actualLastNameColor = Color.fromString(lastNameColor).asHex();
		Assert.assertEquals(actualLastNameColor, expectedLastNameColorInHexa,"Orange color");

		String[] firstNameFirstLetter = getElementsFromGridBody().get(1).get("First Name").getText().split("");
		getSearchBoxesInGrid().get("First Name").clear();
		Thread.sleep(2000);
		getSearchBoxesInGrid().get("First Name").sendKeys(firstNameFirstLetter[0]);
		Thread.sleep(2000);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String elementTxt = getElementsFromGridBody().get(i).get("First Name").getText();
			Assert.assertTrue(elementTxt.contains(firstNameFirstLetter[0]));
		}
		getSearchBoxesInGrid().get("First Name").clear();
		
		String[] lastNameFirstLetter = getElementsFromGridBody().get(1).get("Last Name").getText().split("");
		getSearchBoxesInGrid().get("Last Name").clear();
		Thread.sleep(2000);
		getSearchBoxesInGrid().get("Last Name").sendKeys(lastNameFirstLetter[0]);
		Thread.sleep(2000);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String elementTxt = getElementsFromGridBody().get(i).get("Last Name").getText();
			Assert.assertTrue(elementTxt.contains(lastNameFirstLetter[0]));
		}
		Thread.sleep(1000);
		utils.scrollUp();
		getClearFiltersTxt().click();
		
		Thread.sleep(2000);
		
		String expectedFirstNameColorInHexaBlack = prop.getProperty("blackColorInHexaForm");
		String firstNameColorBlack = getHeaderInTheGrid("First Name").getCssValue("color");
		String actualFirstNameColorBlack = Color.fromString(firstNameColorBlack).asHex();
		Assert.assertEquals(actualFirstNameColorBlack, expectedFirstNameColorInHexaBlack,"Orange color changed to black after clear filters");
		
		String expectedLastNameColorInHexaBlack = prop.getProperty("blackColorInHexaForm");
		String lastNameColorBlack = getHeaderInTheGrid("Last Name").getCssValue("color");
		String actualLastNameColorBlack = Color.fromString(lastNameColorBlack).asHex();
		Assert.assertEquals(actualLastNameColorBlack, expectedLastNameColorInHexaBlack,"Orange color changed to black after clear filters");
		
		Thread.sleep(2000);
		
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstNameAftrClearFilter = getElementsFromGridBody();
		ArrayList<String> firstNameAfterClearFilter = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt = allTableDataForFirstNameAftrClearFilter.get(i).get("First Name").getText();
			firstNameAfterClearFilter.add(firstNameTxt);
		}
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLastNameAfterClearFilter = getElementsFromGridBody();
		ArrayList<String> lastNameAftrClearFilter = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastName = allTableDataForLastNameAfterClearFilter.get(i).get("Last Name").getText();
			lastNameAftrClearFilter.add(lastName);
		}
		Assert.assertEquals(lastNameAftrClearFilter, lastNameListBefore);
	}
	
	@Test(priority = 27)
	public void verifyClearFiltersLinkFunctionalityWithourSearchOperation_19250_19251() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
		
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstName = getElementsFromGridBody();
		ArrayList<String> firstNameListBefore = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt= allTableDataForFirstName.get(i).get("First Name").getText();
			firstNameListBefore.add(firstNameTxt);
		}
		
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLastName = getElementsFromGridBody();
		ArrayList<String> lastNameListBefore = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastNameTxt= allTableDataForFirstName.get(i).get("Last Name").getText();
			lastNameListBefore.add(lastNameTxt);
		}
		utils.scrollLittleDownUsingJSE();
		getHeaderInTheGrid("First Name").click();
		ArrayList<String> obtainedListFirstName = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt = allTableDataForFirstName.get(i).get("First Name").getText();
			obtainedListFirstName.add(firstNameTxt);
		}
		ArrayList<String> firstNameListBeforeSort = obtainedListFirstName;
		System.out.println(firstNameListBeforeSort);
		Collections.sort(obtainedListFirstName);
		System.out.println(obtainedListFirstName);
		Assert.assertEquals(firstNameListBeforeSort, obtainedListFirstName);

		getHeaderInTheGrid("First Name").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstNameOnDoubleClick = getElementsFromGridBody();
		ArrayList<String> obtainedListFirstNameOnDoubleClick = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt = allTableDataForFirstNameOnDoubleClick.get(i).get("First Name").getText();
			obtainedListFirstNameOnDoubleClick.add(firstNameTxt);
		}
		System.out.println(obtainedListFirstNameOnDoubleClick);
		Collections.reverse(obtainedListFirstName);
		System.out.println(obtainedListFirstName);
		Assert.assertEquals(obtainedListFirstNameOnDoubleClick, obtainedListFirstName);
		
		String expectedFirstNameColorInHexa = prop.getProperty("darkOrangeInHexaForm");
		String firstNameColor = getHeaderInTheGrid("First Name").getCssValue("color");
		String actualFirstNameColor = Color.fromString(firstNameColor).asHex();
		Assert.assertEquals(actualFirstNameColor, expectedFirstNameColorInHexa,"Orange color");

		Thread.sleep(1000);

		getHeaderInTheGrid("Last Name").click();
		Thread.sleep(1000);
		ArrayList<String> obtainedListLastName = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastNameTxt = allTableDataForLastName.get(i).get("Last Name").getText();
			obtainedListLastName.add(lastNameTxt);
		}
		ArrayList<String> lastNameListBeforeSort = obtainedListLastName;
		System.out.println(lastNameListBeforeSort);
		Collections.sort(obtainedListLastName);
		System.out.println(obtainedListLastName);
		Assert.assertEquals(lastNameListBeforeSort, obtainedListLastName);

		getHeaderInTheGrid("Last Name").click();
		Thread.sleep(10000);
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLastNameOnDoubleClick = getElementsFromGridBody();
		ArrayList<String> obtainedListLastNameOnDoubleClick = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastNameTxt = allTableDataForLastNameOnDoubleClick.get(i).get("Last Name").getText();
			obtainedListLastNameOnDoubleClick.add(lastNameTxt);
		}
		System.out.println(obtainedListLastNameOnDoubleClick);
		Collections.reverse(obtainedListLastName);
		System.out.println(obtainedListLastName);
		Assert.assertEquals(obtainedListLastNameOnDoubleClick, obtainedListLastName);
		
		String expectedLastNameColorInHexa = prop.getProperty("darkOrangeInHexaForm");
		String lastNameColor = getHeaderInTheGrid("Last Name").getCssValue("color");
		String actualLastNameColor = Color.fromString(lastNameColor).asHex();
		Assert.assertEquals(actualLastNameColor, expectedLastNameColorInHexa,"Orange color");

		Thread.sleep(1000);
		utils.scrollUp();
		getClearFiltersTxt().click();
		
		Thread.sleep(2000);
		
		String expectedFirstNameColorInHexaBlack = prop.getProperty("blackColorInHexaForm");
		String firstNameColorBlack = getHeaderInTheGrid("First Name").getCssValue("color");
		String actualFirstNameColorBlack = Color.fromString(firstNameColorBlack).asHex();
		Assert.assertEquals(actualFirstNameColorBlack, expectedFirstNameColorInHexaBlack,"Orange color changed to black after clear filters");
		
		String expectedLastNameColorInHexaBlack = prop.getProperty("blackColorInHexaForm");
		String lastNameColorBlack = getHeaderInTheGrid("Last Name").getCssValue("color");
		String actualLastNameColorBlack = Color.fromString(lastNameColorBlack).asHex();
		Assert.assertEquals(actualLastNameColorBlack, expectedLastNameColorInHexaBlack,"Orange color changed to black after clear filters");
		
		Thread.sleep(2000);
		
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstNameAftrClearFilter = getElementsFromGridBody();
		ArrayList<String> firstNameAfterClearFilter = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt = allTableDataForFirstNameAftrClearFilter.get(i).get("First Name").getText();
			firstNameAfterClearFilter.add(firstNameTxt);
		}
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLastNameAfterClearFilter = getElementsFromGridBody();
		ArrayList<String> lastNameAftrClearFilter = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastName = allTableDataForLastNameAfterClearFilter.get(i).get("Last Name").getText();
			lastNameAftrClearFilter.add(lastName);
		}
		Assert.assertEquals(lastNameAftrClearFilter, lastNameListBefore);
	}

	
	@Test(priority = 28)
	public void verifyClearFiltersLinkDoesRemoveTheCheckBoxSelection_19253() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		Assert.assertEquals((getSelectContractByDefault()).getAttribute("class"), "tab--active");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if (getSelectStatusCheckBoxInGrid(i).isSelected()) {
				js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(i));
			}
		}
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(2));
		
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstName = getElementsFromGridBody();
		ArrayList<String> firstNameListBefore = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt= allTableDataForFirstName.get(i).get("First Name").getText();
			firstNameListBefore.add(firstNameTxt);
		}
		
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLastName = getElementsFromGridBody();
		ArrayList<String> lastNameListBefore = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastNameTxt= allTableDataForFirstName.get(i).get("Last Name").getText();
			lastNameListBefore.add(lastNameTxt);
		}
		utils.scrollLittleDownUsingJSE();
		getHeaderInTheGrid("First Name").click();
		ArrayList<String> obtainedListFirstName = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt = allTableDataForFirstName.get(i).get("First Name").getText();
			obtainedListFirstName.add(firstNameTxt);
		}
		ArrayList<String> firstNameListBeforeSort = obtainedListFirstName;
		System.out.println(firstNameListBeforeSort);
		Collections.sort(obtainedListFirstName);
		System.out.println(obtainedListFirstName);
		Assert.assertEquals(firstNameListBeforeSort, obtainedListFirstName);

		getHeaderInTheGrid("First Name").click();
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstNameOnDoubleClick = getElementsFromGridBody();
		ArrayList<String> obtainedListFirstNameOnDoubleClick = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt = allTableDataForFirstNameOnDoubleClick.get(i).get("First Name").getText();
			obtainedListFirstNameOnDoubleClick.add(firstNameTxt);
		}
		System.out.println(obtainedListFirstNameOnDoubleClick);
		Collections.reverse(obtainedListFirstName);
		System.out.println(obtainedListFirstName);
		Assert.assertEquals(obtainedListFirstNameOnDoubleClick, obtainedListFirstName);
		
		String expectedFirstNameColorInHexa = prop.getProperty("darkOrangeInHexaForm");
		String firstNameColor = getHeaderInTheGrid("First Name").getCssValue("color");
		String actualFirstNameColor = Color.fromString(firstNameColor).asHex();
		Assert.assertEquals(actualFirstNameColor, expectedFirstNameColorInHexa,"Orange color");

		Thread.sleep(1000);

		getHeaderInTheGrid("Last Name").click();
		Thread.sleep(1000);
		ArrayList<String> obtainedListLastName = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastNameTxt = allTableDataForLastName.get(i).get("Last Name").getText();
			obtainedListLastName.add(lastNameTxt);
		}
		ArrayList<String> lastNameListBeforeSort = obtainedListLastName;
		System.out.println(lastNameListBeforeSort);
		Collections.sort(obtainedListLastName);
		System.out.println(obtainedListLastName);
		Assert.assertEquals(lastNameListBeforeSort, obtainedListLastName);

		getHeaderInTheGrid("Last Name").click();
		Thread.sleep(10000);
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLastNameOnDoubleClick = getElementsFromGridBody();
		ArrayList<String> obtainedListLastNameOnDoubleClick = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastNameTxt = allTableDataForLastNameOnDoubleClick.get(i).get("Last Name").getText();
			obtainedListLastNameOnDoubleClick.add(lastNameTxt);
		}
		System.out.println(obtainedListLastNameOnDoubleClick);
		Collections.reverse(obtainedListLastName);
		System.out.println(obtainedListLastName);
		Assert.assertEquals(obtainedListLastNameOnDoubleClick, obtainedListLastName);
		
		String expectedLastNameColorInHexa = prop.getProperty("darkOrangeInHexaForm");
		String lastNameColor = getHeaderInTheGrid("Last Name").getCssValue("color");
		String actualLastNameColor = Color.fromString(lastNameColor).asHex();
		Assert.assertEquals(actualLastNameColor, expectedLastNameColorInHexa,"Orange color");

		Thread.sleep(1000);
		utils.scrollUp();
		getClearFiltersTxt().click();
		
		Thread.sleep(2000);
		
		String expectedFirstNameColorInHexaBlack = prop.getProperty("blackColorInHexaForm");
		String firstNameColorBlack = getHeaderInTheGrid("First Name").getCssValue("color");
		String actualFirstNameColorBlack = Color.fromString(firstNameColorBlack).asHex();
		Assert.assertEquals(actualFirstNameColorBlack, expectedFirstNameColorInHexaBlack,"Orange color changed to black after clear filters");
		
		String expectedLastNameColorInHexaBlack = prop.getProperty("blackColorInHexaForm");
		String lastNameColorBlack = getHeaderInTheGrid("Last Name").getCssValue("color");
		String actualLastNameColorBlack = Color.fromString(lastNameColorBlack).asHex();
		Assert.assertEquals(actualLastNameColorBlack, expectedLastNameColorInHexaBlack,"Orange color changed to black after clear filters");
		
		Thread.sleep(2000);
		
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForFirstNameAftrClearFilter = getElementsFromGridBody();
		ArrayList<String> firstNameAfterClearFilter = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstNameTxt = allTableDataForFirstNameAftrClearFilter.get(i).get("First Name").getText();
			firstNameAfterClearFilter.add(firstNameTxt);
		}
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, WebElement>> allTableDataForLastNameAfterClearFilter = getElementsFromGridBody();
		ArrayList<String> lastNameAftrClearFilter = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastName = allTableDataForLastNameAfterClearFilter.get(i).get("Last Name").getText();
			lastNameAftrClearFilter.add(lastName);
		}
		Assert.assertEquals(lastNameAftrClearFilter, lastNameListBefore);
		Thread.sleep(2000);
			Assert.assertFalse(getSelectStatusCheckBoxInGrid(1).isSelected());
			Assert.assertFalse(getSelectStatusCheckBoxInGrid(2).isSelected());
	}
	

	@Test(priority = 29)
	public void verifyTotalDueCalculationInCheckDetailsTab_19276() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		
		HashMap<Integer, HashMap<String, WebElement>> allTableData = getElementsFromGridBody();
		ArrayList<Integer> aulPriceList = new ArrayList<Integer>();
		int sum=0;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if(getSelectStatusCheckBoxInGrid(i).isSelected()) {
				String aulPrice = allTableData.get(i).get("AUL Price").getText();
				NumberFormat format = NumberFormat.getCurrencyInstance();
				Number number = format.parse(aulPrice);
				int aulvalueInt = Integer.parseInt(number.toString());
				aulPriceList.add(aulvalueInt);
				Thread.sleep(2000);
			}
		}
			for (int j = 0; j <= aulPriceList.size()-1; j++) {
			 sum += aulPriceList.get(j);
			System.out.println(sum);
			
		}
		getCheckDetailsTab().click();
		Thread.sleep(2000);
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(getTotalDueValue());
		int totalDueValue = Integer.parseInt(number.toString());
		Assert.assertEquals(totalDueValue,sum);
	}
	
	@Test(priority = 30)
	public void verifyFixedTabValuesByChangingValuesAndTabs_19286() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if (getSelectStatusCheckBoxInGrid(i).isSelected()) {
				js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(i));
			}
		}
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(2));
		HashMap<Integer, HashMap<String, WebElement>> allTableData = getElementsFromGridBody();
		ArrayList<Integer> aulPriceList = new ArrayList<Integer>();
		int sum=0;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if(getSelectStatusCheckBoxInGrid(i).isSelected()) {
				String aulPrice = allTableData.get(i).get("AUL Price").getText();
				NumberFormat format = NumberFormat.getCurrencyInstance();
				Number number = format.parse(aulPrice);
				int aulvalueInt = Integer.parseInt(number.toString());
				aulPriceList.add(aulvalueInt);
				Thread.sleep(2000);
			}
		}
			for (int j = 0; j <= aulPriceList.size()-1; j++) {
			 sum += aulPriceList.get(j);
			System.out.println(sum);
			
		}
		Thread.sleep(2000);
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(getTotalDueValue());
		int totalDueValue = Integer.parseInt(number.toString());
		Assert.assertEquals(totalDueValue,sum);

			
			NumberFormat formatCheck = NumberFormat.getCurrencyInstance();
			Number numberCheck = formatCheck.parse(getCheckAmountValue());
			int totalDueValueCheck = Integer.parseInt(numberCheck.toString());
			Assert.assertEquals(totalDueValueCheck,sum);
			
			js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(3));
			//HashMap<Integer, HashMap<String, WebElement>> allTableDataNew = getElementsFromGridBody();
			ArrayList<Integer> aulPriceListNew = new ArrayList<Integer>();
			int sumNew=0;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				if(getSelectStatusCheckBoxInGrid(i).isSelected()) {
					String aulPriceNew = allTableData.get(i).get("AUL Price").getText();
					NumberFormat formatNew = NumberFormat.getCurrencyInstance();
					Number numberNew = formatNew.parse(aulPriceNew);
					int aulvalueInt = Integer.parseInt(numberNew.toString());
					aulPriceListNew.add(aulvalueInt);
					Thread.sleep(2000);
				}
			}
			for (int k = 0; k <= aulPriceListNew.size()-1; k++) {
				 sumNew += aulPriceListNew.get(k);
				System.out.println(sumNew);
			}
			
			getCheckDetailsTab().click();
			
			Thread.sleep(2000);
			NumberFormat formatNew = NumberFormat.getCurrencyInstance();
			Number numberNew = formatNew.parse(getTotalDueValue());
			int totalDueValueNew = Integer.parseInt(numberNew.toString());
			Assert.assertEquals(totalDueValueNew,sumNew);
			
			NumberFormat formatCheckNew = NumberFormat.getCurrencyInstance();
			Number numberCheckNew = formatCheckNew.parse(getCheckAmountValue());
			int checkAmountValue = Integer.parseInt(numberCheckNew.toString());
			Assert.assertEquals(checkAmountValue,sumNew);
			}
		
	@Test(priority = 31)
	public void verifyFixedTabValuesOnBothTabs_19292() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerForPaymentDetails"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if (getSelectStatusCheckBoxInGrid(i).isSelected()) {
				js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(i));
			}
		}
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(2));
		HashMap<Integer, HashMap<String, WebElement>> allTableData = getElementsFromGridBody();
		ArrayList<Integer> aulPriceList = new ArrayList<Integer>();
		int sum=0;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if(getSelectStatusCheckBoxInGrid(i).isSelected()) {
				String aulPrice = allTableData.get(i).get("AUL Price").getText();
				NumberFormat format = NumberFormat.getCurrencyInstance();
				Number number = format.parse(aulPrice);
				int aulvalueInt = Integer.parseInt(number.toString());
				aulPriceList.add(aulvalueInt);
				Thread.sleep(2000);
			}
		}
			for (int j = 0; j <= aulPriceList.size()-1; j++) {
			 sum += aulPriceList.get(j);
			System.out.println(sum);
			
		}
		Thread.sleep(2000);
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(getTotalDueValue());
		int totalDueValue = Integer.parseInt(number.toString());
		Assert.assertEquals(totalDueValue,sum);
        Thread.sleep(2000);
//			NumberFormat formatCheck = NumberFormat.getCurrencyInstance();
//			Number numberCheck = formatCheck.parse(getCheckAmountValue());
//			int checkAmountValue = Integer.parseInt(numberCheck.toString());
//			Assert.assertEquals(checkAmountValue,sum);
			
			getPaymentDetailsTab().click();
			Thread.sleep(1000);
			Assert.assertEquals(totalDueValue,sum);
//			Assert.assertEquals(checkAmountValue,sum);
	}
	
	@Test(priority = 32)
	public void verifyFixedBarDoesnotHideWhenFiltering_19278() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		
		String[] lastNameFirstLetter = getElementsFromGridBody().get(1).get("Last Name").getText().split("");
		getSearchBoxesInGrid().get("Last Name").sendKeys(lastNameFirstLetter[0]);
		Thread.sleep(2000);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String elementTxt = getElementsFromGridBody().get(i).get("Last Name").getText();
			Assert.assertTrue(elementTxt.startsWith(lastNameFirstLetter[0]));
		}
		Assert.assertTrue(getTotalDueTxt().isDisplayed(),"Fixed bar is not hidden");
	}

	
	@Test(priority = 33)
	public void verifyCheckAmountCalculationInSelectContractsTab_19282() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if (getSelectStatusCheckBoxInGrid(i).isSelected()) {
				js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(i));
			}
		}
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(2));
		HashMap<Integer, HashMap<String, WebElement>> allTableData = getElementsFromGridBody();
		ArrayList<Integer> aulPriceList = new ArrayList<Integer>();
		int sum=0;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if(getSelectStatusCheckBoxInGrid(i).isSelected()) {
				String aulPrice = allTableData.get(i).get("AUL Price").getText();
				NumberFormat format = NumberFormat.getCurrencyInstance();
				Number number = format.parse(aulPrice);
				int aulvalueInt = Integer.parseInt(number.toString());
				aulPriceList.add(aulvalueInt);
				Thread.sleep(2000);
			}
		}
			for (int j = 0; j <= aulPriceList.size()-1; j++) {
			 sum += aulPriceList.get(j);
			System.out.println(sum);
			
		}
		Thread.sleep(2000);
		utils.scrollDown();
		Assert.assertTrue(getTotalDueTxt().isDisplayed(),"Fixed bar is displayed");
			NumberFormat formatCheck = NumberFormat.getCurrencyInstance();
			Number numberCheck = formatCheck.parse(getCheckAmountValue());
			int checkAmountValue = Integer.parseInt(numberCheck.toString());
			Assert.assertEquals(checkAmountValue,sum);
	}
	
	@Test(priority = 34)
	public void verifyCheckAmountCalculationInCheckDetailsTab_19283() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if (getSelectStatusCheckBoxInGrid(i).isSelected()) {
				js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(i));
			}
		}
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(2));
		HashMap<Integer, HashMap<String, WebElement>> allTableData = getElementsFromGridBody();
		ArrayList<Integer> aulPriceList = new ArrayList<Integer>();
		int sum=0;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if(getSelectStatusCheckBoxInGrid(i).isSelected()) {
				String aulPrice = allTableData.get(i).get("AUL Price").getText();
				NumberFormat format = NumberFormat.getCurrencyInstance();
				Number number = format.parse(aulPrice);
				int aulvalueInt = Integer.parseInt(number.toString());
				aulPriceList.add(aulvalueInt);
				Thread.sleep(2000);
			}
		}
			for (int j = 0; j <= aulPriceList.size()-1; j++) {
			 sum += aulPriceList.get(j);
			System.out.println(sum);
			
		}
		Thread.sleep(2000);
			NumberFormat formatCheck = NumberFormat.getCurrencyInstance();
			Number numberCheck = formatCheck.parse(getCheckAmountValue());
			int checkAmountValue = Integer.parseInt(numberCheck.toString());
			getCheckDetailsTab().click();
			utils.scrollDown();
			Assert.assertTrue(getTotalDueTxt().isDisplayed(),"Fixed bar is displayed");
			Thread.sleep(1000);
			Assert.assertEquals(checkAmountValue,sum);
	}
	
	@Test(priority = 35)
	public void verifyFixedBarAfterNoRecordsMsg_19285() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		utils.scrollDown();
		Assert.assertTrue(getTotalDueTxt().isDisplayed(),"Fixed bar is displayed");
		Thread.sleep(3000);
		getSearchBoxesInGrid().get("Last Name").sendKeys("@");
		Thread.sleep(1000);
		Assert.assertTrue(getNoRecordsTxt().isDisplayed());
		getSearchBoxesInGrid().get("Last Name").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		getCheckDetailsTab().click();
		Assert.assertTrue(getTotalDueTxt().isDisplayed(),"Fixed bar is not hidden");
	}
	
	@Test(priority = 36)
	public void verifyFixedTabWhenChangesTabToCheckDetails_19295() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		Thread.sleep(2000);
		Assert.assertTrue((getRemitContractsTitle()).isDisplayed());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if (getSelectStatusCheckBoxInGrid(i).isSelected()) {
				js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(i));
			}
		}
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(1));
		js.executeScript("arguments[0].click();", getSelectStatusCheckBoxInGrid(2));
		HashMap<Integer, HashMap<String, WebElement>> allTableData = getElementsFromGridBody();
		ArrayList<Integer> aulPriceList = new ArrayList<Integer>();
		int sum=0;
		for (int i = 1; i <= getRowLoc().size(); i++) {
			if(getSelectStatusCheckBoxInGrid(i).isSelected()) {
				String aulPrice = allTableData.get(i).get("AUL Price").getText();
				NumberFormat format = NumberFormat.getCurrencyInstance();
				Number number = format.parse(aulPrice);
				int aulvalueInt = Integer.parseInt(number.toString());
				aulPriceList.add(aulvalueInt);
				Thread.sleep(2000);
			}
		}
			for (int j = 0; j <= aulPriceList.size()-1; j++) {
			 sum += aulPriceList.get(j);
			System.out.println(sum);
			
		}
		Thread.sleep(2000);
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(getTotalDueValue());
		int totalDueValue = Integer.parseInt(number.toString());
		Assert.assertEquals(totalDueValue,sum);

			NumberFormat formatCheck = NumberFormat.getCurrencyInstance();
			Number numberCheck = formatCheck.parse(getCheckAmountValue());
			int checkAmountValue = Integer.parseInt(numberCheck.toString());
			Assert.assertEquals(checkAmountValue,sum);
			
			getCheckDetailsTab().click();
			Thread.sleep(1000);
			Assert.assertEquals(totalDueValue,sum);
			Assert.assertEquals(checkAmountValue,sum);
	}
	
	@AfterMethod(alwaysRun=true)
	public void close() throws InterruptedException {
		try {
			login.logout();
		} catch (Exception e) {
			if (utils.getfield("mat-icon", "close").isDisplayed()) {
				utils.getfield("mat-icon", "close").click();
			}
			login.logout();
		}
	}

}
		
