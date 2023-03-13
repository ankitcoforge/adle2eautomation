package testsuite;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.EmployeePacksAction;
import pageActions.ManageVSC_GAPpreferencesAction;
import pageActions.PricingPreferencesAction;
import pageActions.WebMileageExceptionAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import utils.CalenderUtils;
import utils.utilityClass;

/* PBI No- 27421 */
public class ManageVSC_GAPprefrences_test extends ManageVSC_GAPpreferencesAction {

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();

	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction();
	singleContractAction contract = new singleContractAction();
	EmployeePacksAction grid = new EmployeePacksAction();
	WebMileageExceptionAction wme = new WebMileageExceptionAction();
	PricingPreferencesAction preferences = new PricingPreferencesAction();
	CalenderUtils calenderUtils= new CalenderUtils();

	@BeforeClass(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}

	@Test(priority = 1)
	public void verifyManageVscGAPage_31322() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
	}

	@Test(priority = 2)
	public void verifySearchFunctionality_31323_31324_31325_31326_31327_31329() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);

		String program = "RSE";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		createNewProgram(program);
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
		String programCode = allTableDataTxt.get(1).get("Program Code");
		getSearchBoxesInGrid().get("Program Code").sendKeys(programCode);
		Thread.sleep(2000);
		String programCodeInGrid = allTableDataTxt.get(1).get("Program Code");
		;
		Assert.assertTrue(programCodeInGrid.contains(programCode));
		getSearchBoxesInGrid().get("Program Code").clear();
		Thread.sleep(2000);

		String programName = allTableDataTxt.get(1).get("Program Name");
		getSearchBoxesInGrid().get("Program Name").sendKeys(programName);
		Thread.sleep(2000);
		String programNameInGrid = allTableDataTxt.get(1).get("Program Name");
		;
		Assert.assertTrue(programNameInGrid.contains(programName));
		getSearchBoxesInGrid().get("Program Name").clear();
		Thread.sleep(2000);

		String defaultDeductible = allTableDataTxt.get(1).get("Default Deductible");
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(defaultDeductible);
		String DD = number.toString();
		getSearchBoxesInGrid().get("Default Deductible").sendKeys(DD);
		Thread.sleep(2000);
		String defaultDeductibleInGrid = allTableDataTxt.get(1).get("Default Deductible");
		NumberFormat formatGrid = NumberFormat.getCurrencyInstance();
		Number numberGrid = formatGrid.parse(defaultDeductibleInGrid);
		Assert.assertTrue(number.toString().contains(numberGrid.toString()));
		getSearchBoxesInGrid().get("Default Deductible").clear();
		Thread.sleep(2000);

		getSearchBoxesWithArrowSelection().get("S&G").click();
		String status = "ON";
		getStatus(status).click();
		getSearchBoxesWithArrowSelection().get("S&G").click();
		String sg = allTableDataTxt.get(1).get("S&G");
		Assert.assertTrue(sg.contains(status));
		// clearing the field
		getSearchBoxesWithArrowSelection().get("S&G").click();
		getStatus(status).click();
		getSearchBoxesWithArrowSelection().get("S&G").click();

		getSearchBoxesWithArrowSelection().get("Warranty Remaining").click();
		// String status="ON";
		getStatus(status).click();
		getSearchBoxesWithArrowSelection().get("Warranty Remaining").click();
		String warrantyRemaining = allTableDataTxt.get(1).get("Warranty Remaining");
		Assert.assertTrue(warrantyRemaining.contains(status));
		// clearing the field
		getSearchBoxesWithArrowSelection().get("Warranty Remaining").click();
		getStatus(status).click();
		getSearchBoxesWithArrowSelection().get("Warranty Remaining").click();

		getSearchBoxesWithArrowSelection().get("Lift Kit").click();
		// String statusOFF="OFF";
		getStatus(status).click();
		getSearchBoxesWithArrowSelection().get("Lift Kit").click();
		// HashMap<Integer, HashMap<String, String>> allTableDataTxtNew =
		// grid.checkGridBodyDetailsTxt();
		String liftKit = allTableDataTxt.get(1).get("Lift Kit");
		Assert.assertTrue(liftKit.contains(status));
		Thread.sleep(2000);
		// clearing the field
		getSearchBoxesWithArrowSelection().get("Lift Kit").click();
		getStatus(status).click();
		getSearchBoxesWithArrowSelection().get("Lift Kit").click();

		String modifiedBy = allTableDataTxt.get(1).get("Modified By");
		getSearchBoxModifiedBy().get("Modified By").sendKeys(modifiedBy);
		Thread.sleep(2000);
		String modifiedByInGrid = allTableDataTxt.get(1).get("Modified By");
		;
		Assert.assertTrue(modifiedByInGrid.contains(modifiedBy));
		getSearchBoxModifiedBy().get("Modified By").clear();
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void verifyDeleteFuctionality_31332_31334() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		createNewProgram();
		Thread.sleep(3000);
		grid.getSelectCheckBoxes().get(0).click();
		if (grid.getCurrentPageRecord() > 1) {
		grid.getSelectCheckBoxes().get(1).click();
		}
		grid.getDeleteLink().click();
		grid.getBtnYes().click();
		Thread.sleep(2000);
		grid.getDeletedConfirmationMsg().isDisplayed();
	}

	// gap functionality-BUG
	@Test(priority = 4)
	public void verifyGAPFuctionality_31333() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
//		getGapCheckbox().click();
//		Thread.sleep(2000);
//		getGapCheckboxStatus().getAttribute("aria-checked").equals("true");
	}

	@Test(priority = 5)
	public void verifyPagination_31335() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 2500)");
		wme.getRowsPerPageDropdownbtn().click();
		wme.getRowsPerPageDropdownlist().get(0).click();
		Assert.assertTrue(wme.getRowsPerPageSelected().getText().equals("25"), "25 is displayed in dropdown");
		Thread.sleep(2000);
		wme.getRowsPerPageDropdownbtn().click();
		wme.getRowsPerPageDropdownlist().get(1).click();
		Assert.assertTrue(wme.getRowsPerPageSelected().getText().equals("50"), "25 is displayed in dropdown");
		Thread.sleep(2000);
		wme.getRowsPerPageDropdownbtn().click();
		wme.getRowsPerPageDropdownlist().get(2).click();
		Assert.assertTrue(wme.getRowsPerPageSelected().getText().equals("100"), "25 is displayed in dropdown");

	}

	@Test(priority = 5)
	public void verifyEditPage_31338_31420_31421_31422() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "RSE";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		createNewProgram(program);
		HashMap<Integer, HashMap<String, WebElement>> allTableData = grid.checkGridBodyDetails();
		allTableData.get(1).get("Edit").click();
		Assert.assertTrue(getProgramTxt().isDisplayed());
		if (!getChckboxesInPrfrncepageStatus().get(1).isSelected()) {
			getChckboxesInPrfrncepage().get(1).click();
		}
		if (!getChckboxesInPrfrncepageStatus().get(7).isSelected()) {
			getChckboxesInPrfrncepage().get(7).click();
		}
		if (!getChckboxesInPrfrncepageStatus().get(8).isSelected()) {
			getChckboxesInPrfrncepage().get(8).click();
		}
		if (!getChckboxesInPrfrncepageStatus().get(12).isSelected()) {
			getChckboxesInPrfrncepage().get(12).click();
		}
		Assert.assertTrue(getBtnSave().isEnabled());
		getBtnSave().click();
		getBtnYes().click();
		Thread.sleep(2000);
		Assert.assertTrue(getRowLoc().get(0).isDisplayed(), "preferences Saved Successfully and back to grid page");
		HashMap<Integer, HashMap<String, WebElement>> allTableDataNew = grid.checkGridBodyDetails();
		allTableDataNew.get(1).get("Edit").click();
		getBtnCancel().click();
		Thread.sleep(2000);
		Assert.assertTrue(getRowLoc().get(0).isDisplayed(), "cancel button working successfully and back to grid page");
	}

	@Test(priority = 6)
	public void verifyNewPreferencePage_31339_31431_31432_31433() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		Thread.sleep(3000);
		getNewPrfrncesBtn().click();
		Thread.sleep(2000);
		grid.getArrow().click();
		grid.selectProgramNew("RSE");
		if (!getChckboxesInPrfrncepageStatus().get(1).isSelected()) {
			getChckboxesInPrfrncepage().get(1).click();
		}
		if (!getChckboxesInPrfrncepageStatus().get(7).isSelected()) {
			getChckboxesInPrfrncepage().get(7).click();
		}
		if (!getChckboxesInPrfrncepageStatus().get(8).isSelected()) {
			getChckboxesInPrfrncepage().get(8).click();
		}
		if (!getChckboxesInPrfrncepageStatus().get(12).isSelected()) {
			getChckboxesInPrfrncepage().get(12).click();
		}
		Assert.assertTrue(getBtnSave().isEnabled());
		getBtnSave().click();
		getBtnYes().click();
		Thread.sleep(2000);
		Assert.assertTrue(getRowLoc().get(0).isDisplayed(), "preferences Saved Successfully and back to grid page");
		HashMap<Integer, HashMap<String, WebElement>> allTableDataNew = grid.checkGridBodyDetails();
		allTableDataNew.get(1).get("Edit").click();
		getBtnCancel().click();
		Thread.sleep(2000);
		Assert.assertTrue(getRowLoc().get(0).isDisplayed(), "cancel button working successfully and back to grid page");
	}

	@Test(priority = 7)
	public void verifySettingsFunctionalityInEditFunction_31412() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "RSE";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		createNewProgram(program);
		HashMap<Integer, HashMap<String, WebElement>> allTableData = grid.checkGridBodyDetails();
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = grid.checkGridBodyDetailsTxt();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String programCode = allTableDataTxt.get(i).get("Program Code");
			if (programCode.equals(program)) {
				allTableData.get(i).get("Edit").click();
			}
		}
		if (!getChckboxesInPrfrncepageStatus().get(0).isSelected()) {
			getChckboxesInPrfrncepage().get(0).click();
		}
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(0).getAttribute("aria-checked").equals("true"));
		getBtnSave().click();
		getBtnYes().click();
		verticalMenu.navigatetoContract();
		wme.getProducts("5FNRL6H27NB019645", "100");
		getPrograms(program);
		utils.scrollDown();
		Assert.assertTrue(getLiftkitInContractCreationPage().isDisplayed());
	}

	@Test(priority = 8)
	public void verifyClassesInEditFunction_31413() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "RSE";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		createNewProgram(program);
		
		HashMap<Integer, HashMap<String, WebElement>> allTableData = grid.checkGridBodyDetails();
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = grid.checkGridBodyDetailsTxt();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String programCode = allTableDataTxt.get(i).get("Program Code");
			if (programCode.equals(program)) {
				allTableData.get(i).get("Edit").click();
			}
		}

		for (int i = 1; i < 4; i++) {
			if (!getChckboxesInPrfrncepageStatus().get(i).isSelected()) {
				getChckboxesInPrfrncepage().get(i).click();
			}
		}
		for (int i = 4; i <= 6; i++) {
			if (getChckboxesInPrfrncepageStatus().get(i).isSelected()) {
				getChckboxesInPrfrncepage().get(i).click();
			}
		}
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(1).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(2).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(3).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(4).getAttribute("aria-checked").equals("false"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(5).getAttribute("aria-checked").equals("false"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(6).getAttribute("aria-checked").equals("false"));

		getBtnSave().click();
		getBtnYes().click();
		verticalMenu.navigatetoContract();
		wme.getProducts("5FNRL6H27NB019645", "100");
		getPrograms(program);
		String classValue = getClassInContractCreationPage().getText();
		if (classValue.contains("Class: 1") | classValue.contains("Class: 2") | classValue.contains("Class: 3")) {
			System.out.println("Class displaying in contract page is correct as per the preferences");
		}
	}

	@Test(priority = 9)
	public void verifyCoverageInEditFunction_31414() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "RSE";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		createNewProgram(program);
		
		HashMap<Integer, HashMap<String, WebElement>> allTableData = grid.checkGridBodyDetails();
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = grid.checkGridBodyDetailsTxt();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String programCode = allTableDataTxt.get(i).get("Program Code");
			if (programCode.equals(program)) {
				allTableData.get(i).get("Edit").click();
			}
		}
		if (!getChckboxesInPrfrncepageStatus().get(7).isSelected()) {
			getChckboxesInPrfrncepage().get(7).click();
		}

		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(7).getAttribute("aria-checked").equals("true"));
		getBtnSave().click();
		getBtnYes().click();
		verticalMenu.navigatetoContract();
		wme.getProducts("5FNRL6H27NB019645", "100");
		getPrograms(program);
		Assert.assertTrue(getReserve().isDisplayed());
	}

	@Test(priority = 10)
	public void verifyDeductableInEditFunction_31415_31416() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "RSE";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		createNewProgram(program);
		
		HashMap<Integer, HashMap<String, WebElement>> allTableData = grid.checkGridBodyDetails();
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = grid.checkGridBodyDetailsTxt();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String programCode = allTableDataTxt.get(i).get("Program Code");
			if (programCode.equals(program)) {
				allTableData.get(i).get("Edit").click();
			}
		}
		for (int i = 8; i < 11; i++) {
			if (!getChckboxesInPrfrncepageStatus().get(i).isSelected()) {
				getChckboxesInPrfrncepage().get(i).click();
			}
		}

		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(8).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(9).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(10).getAttribute("aria-checked").equals("true"));
		getDefaultDeductablesRadioBtns().get(1).isSelected();
		getBtnSave().click();
		getBtnYes().click();
		verticalMenu.navigatetoContract();
		wme.getProducts("5FNRL6H27NB019645", "100");
		getPrograms(program);
		Assert.assertTrue(getDeductibleTxtInContractPage().getText().contains("100"));
	}

	@Test(priority = 11)
	public void verifyMileageBandInEditFunction_31417() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "RSE";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		createNewProgram(program);
		
		HashMap<Integer, HashMap<String, WebElement>> allTableData = grid.checkGridBodyDetails();
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = grid.checkGridBodyDetailsTxt();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String programCode = allTableDataTxt.get(i).get("Program Code");
			if (programCode.equals(program)) {
				allTableData.get(i).get("Edit").click();
			}
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 2500)");
		for (int i = 12; i <= 13; i++) {
			if (getChckboxesInPrfrncepageStatus().get(i).isSelected()) {
				getChckboxesInPrfrncepage().get(i).click();
			}
		}
		if (!getChckboxesInPrfrncepageStatus().get(14).isSelected()) {
			getChckboxesInPrfrncepage().get(14).click();
		}
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(12).getAttribute("aria-checked").equals("false"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(13).getAttribute("aria-checked").equals("false"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(14).getAttribute("aria-checked").equals("true"));
		getBtnSave().click();
		getBtnYes().click();
		verticalMenu.navigatetoContract();
		wme.getProducts("5FNRL6H27NB019645", "50000");
		getPrograms(program);
		Assert.assertTrue(getReserve().isDisplayed());
	}

	@Test(priority = 12)
	public void verifyTermMileageAndMonthsInEditFunction_31417() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "RSE";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		createNewProgram(program);
		
		HashMap<Integer, HashMap<String, WebElement>> allTableData = grid.checkGridBodyDetails();
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = grid.checkGridBodyDetailsTxt();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String programCode = allTableDataTxt.get(i).get("Program Code");
			if (programCode.equals(program)) {
				allTableData.get(i).get("Edit").click();
			}
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 2500)");
		for (int i = 15; i <= 20; i++) {
			if (!getChckboxesInPrfrncepageStatus().get(i).isSelected()) {
				getChckboxesInPrfrncepage().get(i).click();
			}
		}
		for (int i = 21; i <= 25; i++) {
			if (getChckboxesInPrfrncepageStatus().get(i).isSelected()) {
				getChckboxesInPrfrncepage().get(i).click();
			}
		}
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(15).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(16).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(17).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(18).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(19).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(20).getAttribute("aria-checked").equals("true"));
		getBtnSave().click();
		getBtnYes().click();
		verticalMenu.navigatetoContract();
		wme.getProducts("5FNRL6H27NB019645", "100");
		getPrograms(program);
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < getTermMileageMonthsInContractPage().size(); i++) {
			String[] menuItem = getTermMileageMonthsInContractPage().get(i).getText().split(",");
			list.add(menuItem[0].trim());
		}
		System.out.println("list is-" + list);
		Assert.assertTrue(list.contains("48/100"));
		Assert.assertTrue(list.contains("48/60"));
		Assert.assertTrue(list.contains("48/75"));
		Assert.assertTrue(list.contains("60/100"));
		Assert.assertTrue(list.contains("60/125"));
		Assert.assertTrue(list.contains("60/60"));
	}

	@Test(priority = 13)
	public void verifySurchargesAndOptionsAndClassesInNewPreference_31423_31424() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "RNL";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		Thread.sleep(3000);
		getNewPrfrncesBtn().click();
		Thread.sleep(2000);
		grid.getArrow().click();
		grid.selectProgramNew(program);
		
		for (int i = 0; i <= 4; i++) {
			if (!getChckboxesInPrfrncepageStatus().get(i).isSelected()) {
				getChckboxesInPrfrncepage().get(i).click();
			}
		}
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(0).getAttribute("aria-checked").equals("true"),"Lift kit selected");
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(1).getAttribute("aria-checked").equals("true"),"Seal & Gasket selected");
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(2).getAttribute("aria-checked").equals("true"),"Warranty Remaining selected");
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(3).getAttribute("aria-checked").equals("true"),"class 1 selected");
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(4).getAttribute("aria-checked").equals("true"),"class 2 selected");
		getBtnSave().click();
		getBtnYes().click();
		verticalMenu.navigatetoContract();
		wme.getProducts("5FNRL6H27NB019645", "100");
		getPrograms(program);
		utils.scrollDown();
		Assert.assertTrue(getLiftkitInContractCreationPage().isDisplayed());
		Assert.assertTrue(utils.getfield("p", "Seals and Gaskets").isDisplayed());
		Assert.assertTrue(utils.getfield("p", "Warranty Remaining").isDisplayed());
		String classValue = getClassInContractCreationPage().getText();
		if (classValue.contains("Class: 1") | classValue.contains("Class: 2")) {
			System.out.println("Class displaying in contract page is correct as per the preferences");
		}
	}

	@Test(priority = 14)
	public void verifyCoverageAndDeductiblesInNewPreference_31425_31426_31427() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "RNL";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		Thread.sleep(3000);
		getNewPrfrncesBtn().click();
		Thread.sleep(2000);
		grid.getArrow().click();
		grid.selectProgramNew(program);
		Thread.sleep(1000);
		for (int i = 7; i <= 10; i++) {
		if (!getChckboxesInPrfrncepageStatus().get(i).isSelected()) {
			getChckboxesInPrfrncepage().get(i).click();
		}
		}
		for (int i = 11; i <=13; i++) {
			if (!getChckboxesInPrfrncepageStatus().get(i).isSelected()) {
				getChckboxesInPrfrncepage().get(i).click();
			}
		}

		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(7).getAttribute("aria-checked").equals("true"),"Estate selected");
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(8).getAttribute("aria-checked").equals("true"),"Powertrain selected");
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(9).getAttribute("aria-checked").equals("true"),"Reserve selected");
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(10).getAttribute("aria-checked").equals("true"),"Sterling selected");
		
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(11).getAttribute("aria-checked").equals("true"),"0 Deductible selected");
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(12).getAttribute("aria-checked").equals("true"),"100 Deductible selected");
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(13).getAttribute("aria-checked").equals("true"),"250 Deductible selected");
		getDefaultDeductablesRadioBtns().get(1).isSelected();
		getBtnSave().click();
		getBtnYes().click();
		verticalMenu.navigatetoContract();
		wme.getProducts("5FNRL6H27NB019645", "100");
		getPrograms(program);
		Assert.assertTrue(utils.getfield("p", "RESERVE").isDisplayed());
		Assert.assertTrue(utils.getfield("p", "POWERTRAIN").isDisplayed());
		Assert.assertTrue(utils.getfield("p", "STERLING").isDisplayed());
		Assert.assertTrue(utils.getfield("p", "ESTATE").isDisplayed());
		Assert.assertTrue(getDeductibleTxtInContractPage().getText().contains("100"));
	}
	
	@Test(priority = 15)
	public void verifyMileageBandAndTermMileageAndMonthsInNewPreference_31428_31429() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "RSE";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		getNewPrfrncesBtn().click();
		Thread.sleep(2000);
		grid.getArrow().click();
		grid.selectProgramNew(program);
		Thread.sleep(1000);
		for (int i = 12; i <= 14; i++) {
			if (!getChckboxesInPrfrncepageStatus().get(i).isSelected()) {
				getChckboxesInPrfrncepage().get(i).click();
			}
		}
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(12).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(13).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(14).getAttribute("aria-checked").equals("true"));
		for (int i = 15; i <= 20; i++) {
			if (!getChckboxesInPrfrncepageStatus().get(i).isSelected()) {
				getChckboxesInPrfrncepage().get(i).click();
			}
		}
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(15).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(16).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(17).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(18).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(19).getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(20).getAttribute("aria-checked").equals("true"));
		getBtnSave().click();
		getBtnYes().click();
		verticalMenu.navigatetoContract();
		wme.getProducts("5FNRL6H27NB019645", "100");
		getPrograms(program);
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < getTermMileageMonthsInContractPage().size(); i++) {
			String[] menuItem = getTermMileageMonthsInContractPage().get(i).getText().split(",");
			list.add(menuItem[0].trim());
		}
		Assert.assertTrue(getReserve().isDisplayed());
		Assert.assertTrue(list.contains("48/100"));
		Assert.assertTrue(list.contains("48/60"));
		Assert.assertTrue(list.contains("48/75"));
		Assert.assertTrue(list.contains("60/100"));
		Assert.assertTrue(list.contains("60/125"));
		Assert.assertTrue(list.contains("60/60"));
	}
	
	@Test(priority = 16)
	public void verifySurchargesAndOptionsInEditFunction_31612_31613_31614() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "FSL";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		createNewProgram(program);
		HashMap<Integer, HashMap<String, WebElement>> allTableData = grid.checkGridBodyDetails();
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = grid.checkGridBodyDetailsTxt();
			if (allTableDataTxt.get(1).get("Program Code").equals(program)) {
				allTableData.get(1).get("Edit").click();
			}
		for (int i = 0; i <= 1; i++) {
		if (!getChckboxesInPrfrncepageStatus().get(i).isSelected()) {
			getChckboxesInPrfrncepage().get(i).click();
		}
		}
		if (getChckboxesInPrfrncepageStatus().get(2).isSelected()) {
			getChckboxesInPrfrncepage().get(2).click();
		}
		Thread.sleep(2000);
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(0).getAttribute("aria-checked").equals("true"),"Lift kit is ON");
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(1).getAttribute("aria-checked").equals("true"),"S&G is ON");
		Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(2).getAttribute("aria-checked").equals("false"),"WR is OFF");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 2500)");
		getBtnSave().click();
		getBtnYes().click();
		Thread.sleep(5000);
		HashMap<Integer, HashMap<String, String>> allTableDataTxtNew = grid.checkGridBodyDetailsTxt();
		String liftKit = allTableDataTxtNew.get(1).get("Lift Kit");
		String SG = allTableDataTxtNew.get(1).get("S&G");
		String WR = allTableDataTxtNew.get(1).get("Warranty Remaining");
		Assert.assertTrue(liftKit.contains("ON"));
		Assert.assertTrue(SG.contains("ON"));
		Assert.assertTrue(WR.contains("OFF"));
	}

	@Test(priority = 17)
	public void verifyDisappearingDeductibleOption_32476() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "RSE";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		createNewProgram(program);
		
		verticalMenu.navigatetoContract();
		wme.getProducts("5FNRL6H27NB019645", "100");
		getPrograms(program);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 2500)");
		getDeductibleArrow().isDisplayed();
		getDeductibleArrow().click();
		Assert.assertTrue(getDropDown().size()==4,"Deductible dropdown does contain disappearing in list");
		
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, WebElement>> allTableData = grid.checkGridBodyDetails();
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = grid.checkGridBodyDetailsTxt();
			if (allTableDataTxt.get(1).get("Program Code").equals(program)) {
				allTableData.get(1).get("Edit").click();
			}
			js.executeScript("window.scrollTo(0, 2500)");
			if (getChckboxesInPrfrncepageStatus().get(11).isSelected()) {
				getChckboxesInPrfrncepage().get(11).click();
			}
			Assert.assertTrue(getChckboxesInPrfrncepageStatus().get(11).getAttribute("aria-checked").equals("false"),"disappearing deductible is not selected");
			getBtnSave().click();
			getBtnYes().click();
			Thread.sleep(2000);
			 
			verticalMenu.navigatetoContract();
			wme.getProducts("5FNRL6H27NB019645", "100");
			getPrograms(program);
			js.executeScript("window.scrollTo(0, 2500)");
			getDeductibleArrow().click();
			Assert.assertTrue(getDropDown().size()==3,"Deductible dropdown does not contain disappearing in list");
			
			
	}
	
	@Test(priority = 18)
	public void verifyDateFunctionality_31330() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "FSL";
		if (grid.getCurrentPageRecord() == 0) {
			 createNewProgramWithDate(program,0);
		}
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = grid.checkGridBodyDetailsTxt();
		String dateInGrid = allTableDataTxt.get(1).get("Prog Eff.Date");
		System.out.println("Date in grid"+dateInGrid);
		utils.clickfield("xpath", calenderUtils.calenderTxtbox);
		calenderUtils.selectDate(dateInGrid,"MM/dd/yyyy");
		Thread.sleep(2000);
		
		HashMap<Integer, HashMap<String, String>> allTableDataTxtNew = checkGridBodyDetailsTxt();
		String effectiveDateInGrid = allTableDataTxtNew.get(1).get("Prog Eff.Date");
		Assert.assertTrue(dateInGrid.equalsIgnoreCase(effectiveDateInGrid));
	}
		
	@Test(priority = 19)
	public void verifySortingAndUnsortingDate_31336_31337() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "FSL";
		String program1 = "RSE";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		 createNewProgramWithDate(program,3);
		 createNewProgramWithDate(program1,0);
		Thread.sleep(10000);
		wme.getGridArrowBtn("Prog Eff.Date").click();
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
		ArrayList<String> dateList = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String date = allTableDataTxt.get(i).get("Prog Eff.Date");
			dateList.add(date);
		}
		ArrayList<String> dateListBeforeSort = dateList;
		System.out.println(dateListBeforeSort);
		Collections.sort(dateList);
		System.out.println(dateList);
		Assert.assertEquals(dateListBeforeSort,dateList);
		Thread.sleep(2000);
		
		wme.getGridArrowBtn("Prog Eff.Date").click();
		HashMap<Integer, HashMap<String, String>> allTableDataTxtOnArrowClick2 = checkGridBodyDetailsTxt();
		ArrayList<String> dateListOnArrowClick2 = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String date = allTableDataTxtOnArrowClick2.get(i).get("Prog Eff.Date");
			dateListOnArrowClick2.add(date);
		}
		System.out.println(dateListOnArrowClick2);
		Collections.reverse(dateList);
		System.out.println(dateList);
		Assert.assertTrue(dateListOnArrowClick2.equals(dateList));

	}
	
	@Test(priority = 20)
	public void verifyDateFunctionalyInEditPage_31419() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "RSE";
		if (grid.getCurrentPageRecord() == 0) {
			createNewProgram(program);
		}
		HashMap<Integer, HashMap<String, WebElement>> allTableData = grid.checkGridBodyDetails();
		allTableData.get(1).get("Edit").click();
		Assert.assertTrue(getProgramTxt().isDisplayed());
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 3000)");
		Thread.sleep(2000);
		getChckboxesInPrfrncepage().get(11).click();
		Thread.sleep(2000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollTo(0, 2000)");
		Thread.sleep(2000);
		utils.clickfield("xpath", calenderInPopup);
		String futureDate = calenderUtils.getCurrentDate(3,"MMM/dd/yyyy");
		System.out.println("Selected Date-"+futureDate);
		calenderUtils.selectDate(futureDate,"MMM/dd/yyyy");
		Thread.sleep(2000);
		utils.clickfield("xpath", calenderInPopup);
		String currentDate = calenderUtils.getCurrentDate(0,"MMM/dd/yyyy");
		System.out.println("Current Date-"+currentDate);
		calenderUtils.selectDate(currentDate,"MMM/dd/yyyy");
		getBtnSave().click();
		getBtnYes().click();
		Thread.sleep(2000);
		Assert.assertTrue(getRowLoc().get(0).isDisplayed(), "preferences Saved Successfully and back to grid page");
	}
	
	
	@Test(priority = 21)
	public void verifyDateFunctionalyInNewPreferencePage_31430() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage VSC - GAP Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());
		Thread.sleep(2000);
		String program = "RSE";
		if (grid.getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			grid.getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(7000);
		}
		getNewPrfrncesBtn().click();
		Thread.sleep(2000);
		getArrow().click();
		selectProgramNew(program);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 3000)");
		Thread.sleep(2000);
		getChckboxesInPrfrncepage().get(11).click();
		Thread.sleep(2000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollTo(0, 2000)");
		Thread.sleep(2000);
		utils.clickfield("xpath", calenderInPopup);
		String futureDate = calenderUtils.getCurrentDate(3,"MMM/dd/yyyy");
		System.out.println("Selected Date-"+futureDate);
		calenderUtils.selectDate(futureDate,"MMM/dd/yyyy");
		Thread.sleep(2000);
		utils.clickfield("xpath", calenderInPopup);
		String currentDate = calenderUtils.getCurrentDate(0,"MMM/dd/yyyy");
		System.out.println("Current Date-"+currentDate);
		calenderUtils.selectDate(currentDate,"MMM/dd/yyyy");
		getBtnSave().click();
		getBtnYes().click();
		Thread.sleep(2000);
		Assert.assertTrue(getRowLoc().get(0).isDisplayed(), "preferences Saved Successfully and back to grid page");
	}

	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		login.logout();
	}

}
