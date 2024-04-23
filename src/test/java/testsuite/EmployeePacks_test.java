package testsuite;

import java.text.NumberFormat;
import java.util.HashMap;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.EmployeePacksAction;
import pageActions.PricingPreferencesAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import utils.CalenderUtils;
import utils.XmlDataReader;
import utils.utilityClass;

/*PBI No- 31340 */
/* Tc's active = 15, future date invalid tc= 5 */
public class EmployeePacks_test extends EmployeePacksAction {
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	CalenderUtils calenderUtils = new CalenderUtils();
	XmlDataReader UtilsDataReader= new XmlDataReader("UtilsData");
	XmlDataReader employeePacksData= new XmlDataReader("EmployeePacksData");
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction();
	singleContractAction contract = new singleContractAction();
	PricingPreferencesAction preferences = new PricingPreferencesAction();
//	VerticalMenu_test VerticalMenu=new VerticalMenu_test();
	ManageUsersPage_test ManageUserPage=new ManageUsersPage_test();
	
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}

	@Test(priority = 1)
	public void verifyNewPackPopupOpened_31999() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		Assert.assertTrue(getDealerPacksPageTitle().isDisplayed());
		getBtnNewPack().click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getPopup()));
		Assert.assertTrue(getPopup().isDisplayed());
//		//Closing the popup to logout from the page as precondition
//		getBtnCloseForPopup().click();
	}

	@Test(priority = 2)
	public void verifyNewPackCreation_32000() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		Assert.assertTrue(getDealerPacksPageTitle().isDisplayed());

		if (getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}

		getBtnNewPack().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getPopup()));
		getArrow().click();
		selectProgram();
		getPackAmount().sendKeys(employeePacksData.getXMLData("packAmount1"));
		getBtnSave().click();
		Thread.sleep(2000);
		Assert.assertTrue(getSuccessMsg().isDisplayed());
	}

	@Test(priority = 3)
	public void verifyEditFunctionality_32001() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		Assert.assertTrue(getDealerPacksPageTitle().isDisplayed());
		String packAmount=employeePacksData.getXMLData("packAmount2");
		if (getCurrentPageRecord() == 0) {
			createNewPack("RSE", packAmount);
		} else {
			preferences.getSelectAllCheckBox().click();
			getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
			createNewPack("RSE", packAmount);
		}
		HashMap<Integer, HashMap<String, WebElement>> allTableData = checkGridBodyDetails();
		Thread.sleep(2000);
		allTableData.get(1).get("Edit").click();
		Thread.sleep(2000);
		getPackAmount().clear();
		String packAmountEdited = employeePacksData.getXMLData("packAmount3");
		getPackAmount().sendKeys(packAmountEdited);
		getBtnSave().click();
		Thread.sleep(5000);
		verticalMenu.navigatetoLeftMenu("Dashboard");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(10000);
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt2();
		String packAmountInGrid = allTableDataTxt.get(1).get("Pack Amount");
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(packAmountInGrid);
		String packAmountInGridValue = number.toString();
		Assert.assertTrue(packAmountEdited.equals(packAmountInGridValue));
	}

	@Test(priority = 4)
	public void verifySearchBoxes_32002() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		Assert.assertTrue(getDealerPacksPageTitle().isDisplayed());

		if (getCurrentPageRecord() == 0) {
			getBtnNewPack().click();
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(getPopup()));
			getArrow().click();
			selectProgram();
			getPackAmount().sendKeys(employeePacksData.getXMLData("packAmount1"));
			getBtnSave().click();
			Thread.sleep(2000);
		}

		HashMap<Integer, HashMap<String, WebElement>> allTableData = checkGridBodyDetails();
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt2();
		String[] programFirstLetter = allTableData.get(1).get("Program").getText().split("");
		getSearchBoxesInGrid().get("Program").sendKeys(programFirstLetter[0]);
		Thread.sleep(2000);
		String elementTxt = allTableDataTxt.get(1).get("Program");
		Assert.assertTrue(elementTxt.startsWith(programFirstLetter[0]));
		getSearchBoxesInGrid().get("Program").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);

		String packAmountInGrid = allTableDataTxt.get(1).get("Pack Amount");
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(packAmountInGrid);
		String packAmountValue = number.toString();

		getSearchBoxesFromPackAmount().get("Pack Amount").sendKeys(packAmountValue);
		Thread.sleep(2000);
		String elementTxt1 = allTableDataTxt.get(1).get("Pack Amount");
		Assert.assertTrue(elementTxt1.equals(packAmountInGrid));

		getSearchBoxesFromPackAmount().get("Pack Amount").clear();
		Thread.sleep(2000);

		String[] programCodeFirstLetter = allTableDataTxt.get(1).get("Program Code").split("");
		getSearchBoxesInGrid().get("Program Code").sendKeys(programCodeFirstLetter[0]);
		Thread.sleep(2000);
		String elementTxtProgramCode = allTableDataTxt.get(1).get("Program Code");
		Assert.assertTrue(elementTxtProgramCode.startsWith(programCodeFirstLetter[0]));
		getSearchBoxesInGrid().get("Program Code").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);

		String[] modifiedByFirstLetter = allTableDataTxt.get(1).get("Modified By").split("");
		getSearchBoxesFromPackAmount().get("Modified By").sendKeys(modifiedByFirstLetter[0]);
		Thread.sleep(2000);
		for (int i = 1; i <= getRows().size(); i++) {
			String elementTxtModifiedByFirstLetter = allTableDataTxt.get(1).get("Modified By");
			Assert.assertTrue(elementTxtModifiedByFirstLetter.startsWith(modifiedByFirstLetter[0]));
		}
		getSearchBoxesFromPackAmount().get("Modified By").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);

		String dateInGrid = allTableDataTxt.get(1).get("Effective Date");
		System.out.println("Date in grid" + dateInGrid);
		utils.clickfield("xpath", calenderUtils.calenderIcon);
		calenderUtils.selectDate(dateInGrid, "MM/dd/yyyy");
		Thread.sleep(2000);

		HashMap<Integer, HashMap<String, String>> allTableDataTxtNew = checkGridBodyDetailsTxt2();
		String effectiveDateInGrid = allTableDataTxtNew.get(1).get("Effective Date");
		Assert.assertTrue(dateInGrid.equalsIgnoreCase(effectiveDateInGrid));
	}

	@Test(priority = 5)
	public void verifyDealerPackImpactContractCreationPage_32013() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		if (getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String program = prop.getProperty("dealerProgram");
		String priceTobeEnteredInStringFormat = employeePacksData.getXMLData("packAmount1");
		int packAmount = Integer.parseInt(priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		int vehiclePriceBefore = getVehiclePrice(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		createNewPack(program, priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		Thread.sleep(5000);
		int vehiclePriceBeforeAfter = getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceBeforeAfter);
		Assert.assertEquals(vehiclePriceBeforeAfter, (vehiclePriceBefore+packAmount));
	}

	@Test(priority = 6)
	public void verifyLenderPackImpactContractCreationPage_32014() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Lender", UtilsDataReader.getXMLData("lenderId"));
		Thread.sleep(5000);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Lender Packs");
		Assert.assertTrue(getlenderPackstitle().isDisplayed());
		Thread.sleep(2000);
		verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgramCode");
		String priceTobeEnteredInStringFormat = employeePacksData.getXMLData("packAmount4");
		int packAmount = Integer.parseInt(priceTobeEnteredInStringFormat);

		// checking the price in contract page before creating pack
		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract(UtilsDataReader.getXMLData("dealer"));
		int vehiclePriceBefore = getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		// Creation of Pack
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Lender Packs");
		Thread.sleep(2000);
		createNewPack(program, priceTobeEnteredInStringFormat);
		Thread.sleep(5000);

		// checking the price in contract page After creating pack
		verticalMenu.navigatetoContract();
		int vehiclePriceBeforeAfter = getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceBeforeAfter);
		Assert.assertEquals(vehiclePriceBeforeAfter, (vehiclePriceBefore+packAmount));
	}

	@Test(priority = 7)
	public void verifyDealerPackImpactContractCreationPageThroughAgentLogin_32116() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
		Thread.sleep(5000);

		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage My Dealer Packs");
		selectDealerName(UtilsDataReader.getXMLData("dealer2"));
		Thread.sleep(2000);
		if (getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}

		// data
		String programCode = prop.getProperty("agentProgramCode");
		// String program = prop.getProperty("agentProgram");
		String priceTobeEnteredInStringFormat = employeePacksData.getXMLData("packAmount1");
		int packAmount = Integer.parseInt(priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract(UtilsDataReader.getXMLData("dealer2"));
		Thread.sleep(2000);
		int vehiclePriceBefore = getVehiclePrice(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage My Dealer Packs");
		selectDealerName(UtilsDataReader.getXMLData("dealer2"));
		Thread.sleep(2000);
		createNewPack(programCode, priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		Thread.sleep(2000);
		int vehiclePriceBeforeAfter = getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceBeforeAfter);
		Assert.assertEquals(vehiclePriceBeforeAfter, (vehiclePriceBefore+packAmount));
	}

	//impersonate as generic role added,hence putting it on hold
		@Test(priority = 8)
	public void verifyDealerPackImpactContractCreationPageThroughSubAgentLogin_35142() throws Exception {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));

		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage My Dealer Packs");
		selectDealerName(UtilsDataReader.getXMLData("dealer2"));
		Thread.sleep(2000);
		if (getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}

		// data
		String programCode = prop.getProperty("agentProgramCode");
		String program = prop.getProperty("agentProgram");
		String priceTobeEnteredInStringFormat = employeePacksData.getXMLData("packAmount1");
		int packAmount = Integer.parseInt(priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract(UtilsDataReader.getXMLData("dealer2"));
		int vehiclePriceBefore = getVehiclePrice(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage My Dealer Packs");
		selectDealerName(UtilsDataReader.getXMLData("dealer2"));
		Thread.sleep(2000);
		createNewPack(programCode, priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		Thread.sleep(2000);
		int vehiclePriceBeforeAfter = getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceBeforeAfter);
		Assert.assertEquals(vehiclePriceBeforeAfter, (vehiclePriceBefore+packAmount));
	}

	@Test(priority = 9)
	public void verifyDeleteFunctionality_32003() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);

		if (getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		} else {
			createNewPack("RSE", employeePacksData.getXMLData("packAmount2"));
			Thread.sleep(2000);
			getSelectCheckBoxes().get(0).click();
			getDeleteLink().click();
			getBtnYes().click();
		}
	}
	
	@Test(priority = 10)
	public void verifyDealerEmpPackImpactsContractCreationPage_35149() throws Exception {
		getPermissionsForDealerEmp();
		login.login(prop.getProperty("dealerempAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		if (getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String program = prop.getProperty("dealerProgram");
		String priceTobeEnteredInStringFormat = employeePacksData.getXMLData("packAmount1");
		int packAmount = Integer.parseInt(priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		int vehiclePriceBefore = getVehiclePrice(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		createNewPack(program, priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		Thread.sleep(5000);
		int vehiclePriceBeforeAfter = getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceBeforeAfter);
		Assert.assertEquals(vehiclePriceBeforeAfter, (vehiclePriceBefore+packAmount));
	}
	
	@Test(priority = 11)
	public void verifyLenderEmpPackImpactContractCreationPage_35150() throws Exception {
		getPermissionsForLenderEmp();
		login.login(prop.getProperty("lenderempAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("LenderEmp", UtilsDataReader.getXMLData("lenderId"));
		Thread.sleep(5000);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Lender Packs");
		Assert.assertTrue(getlenderPackstitle().isDisplayed());
		Thread.sleep(2000);
		verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgramCode");
		String priceTobeEnteredInStringFormat = employeePacksData.getXMLData("packAmount4");
		int packAmount = Integer.parseInt(priceTobeEnteredInStringFormat);

		// checking the price in contract page before creating pack
		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract(UtilsDataReader.getXMLData("dealer"));
		int vehiclePriceBefore = getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		// Creation of Pack
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Lender Packs");
		Thread.sleep(2000);
		createNewPack(program, priceTobeEnteredInStringFormat);
		Thread.sleep(5000);

		// checking the price in contract page After creating pack
		verticalMenu.navigatetoContract();
		int vehiclePriceBeforeAfter = getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceBeforeAfter);
		Assert.assertEquals(vehiclePriceBeforeAfter, (vehiclePriceBefore+packAmount));
	}

	//impersonate as generic role added,hence putting it on hold
	@Test(priority = 12)
	public void verifyDealerPackImpactContractCreationPageWhenDealerImpersontedThroughAgent_32015() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
		Thread.sleep(5000);
		
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		selectDealerInManageUserPage();
		selectRoleTypeAndStatusCompleted("Dealer");
		utils.clickfield("xpath", impersonate.tableFirstRow);
		utils.waituntillPageIsloaded(60);
//Impersonated as Dealer
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		utils.waituntillPageIsloaded();
		if (getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		// data
		String programCode = prop.getProperty("agentProgramCode");
		String priceTobeEnteredInStringFormat = employeePacksData.getXMLData("packAmount1");
		int packAmount = Integer.parseInt(priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		Thread.sleep(2000);
		int vehiclePriceBefore = getVehiclePrice(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		createNewPack(programCode, priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		Thread.sleep(2000);
		int vehiclePriceAfter = getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore+packAmount));
	}

	
	//bug raised
	//impersonate as generic role added,hence putting it on hold
		@Test(priority = 13)
	public void verifyDealerEmpPackImpactsContractCreationPageWhenDealerEmpImpersontedThroughAgent_32032() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
		Thread.sleep(5000);
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		selectDealerInManageUserPage();
		selectRoleTypeAndStatusCompleted("DealerEmp");
		 getEditPermissionsInManageUsersPage("DealerEmp","Completed");
		utils.clickfield("xpath", impersonate.tableFirstRow);
		utils.waituntillPageIsloaded(60);
		//Impersonated as DealerEmp
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		if (getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		// data
		String programCode = prop.getProperty("agentProgramCode");
		String priceTobeEnteredInStringFormat = employeePacksData.getXMLData("packAmount1");
		int packAmount = Integer.parseInt(priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		Thread.sleep(2000);
		int vehiclePriceBefore = getVehiclePrice(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		createNewPack(programCode, priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		Thread.sleep(2000);
		int vehiclePriceBeforeAfter = getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceBeforeAfter);
		Assert.assertEquals(vehiclePriceBeforeAfter, (vehiclePriceBefore+packAmount));
	}

		//impersonate as generic role added,hence putting it on hold
		@Test(priority = 14 )
	public void verifyDealerPackImpactContractCreationPageWhenDealerImpersontedThroughSubAgent_35143() throws Exception {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
		Thread.sleep(5000);
		
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		selectDealerInManageUserPage();
		selectRoleTypeAndStatusCompleted("Dealer");
		utils.clickfield("xpath", impersonate.tableFirstRow);
		utils.waituntillPageIsloaded(60);
//Impersonated as Dealer
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		utils.waituntillPageIsloaded();
		if (getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		// data
		String programCode = prop.getProperty("agentProgramCode");
		String priceTobeEnteredInStringFormat = employeePacksData.getXMLData("packAmount1");
		int packAmount = Integer.parseInt(priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		Thread.sleep(2000);
		int vehiclePriceBefore = getVehiclePrice(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		createNewPack(programCode, priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		Thread.sleep(2000);
		int vehiclePriceAfter = getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore+packAmount));
	}

	//bug raised
		//impersonate as generic role added,hence putting it on hold
		@Test(priority = 15 )
	public void verifyDealerEmpPackImpactsContractCreationPageWhenDealerEmpImpersontedThroughSubAgent_35144() throws Exception {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
		Thread.sleep(5000);
		
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		selectDealerInManageUserPage();
		selectRoleTypeAndStatusCompleted("DealerEmp");
		 getEditPermissionsInManageUsersPage("DealerEmp","Completed");
		utils.clickfield("xpath", impersonate.tableFirstRow);
		utils.waituntillPageIsloaded(60);
		//Impersonated as DealerEmp
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		if (getCurrentPageRecord() > 0) {
			preferences.getSelectAllCheckBox().click();
			getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
		}
		// data
		String programCode = prop.getProperty("agentProgramCode");
		String priceTobeEnteredInStringFormat = employeePacksData.getXMLData("packAmount1");
		int packAmount = Integer.parseInt(priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		Thread.sleep(2000);
		int vehiclePriceBefore = getVehiclePrice(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		createNewPack(programCode, priceTobeEnteredInStringFormat);

		verticalMenu.navigatetoContract();
		Thread.sleep(2000);
		int vehiclePriceBeforeAfter = getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceBeforeAfter);
		Assert.assertEquals(vehiclePriceBeforeAfter, (vehiclePriceBefore+packAmount));
	}

//		@Test(priority = 10)
//		public void verifyEffectiveDateFeild_() throws Exception {
//			login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
//			Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
//			verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
//			Thread.sleep(2000);
//			Assert.assertTrue(getDealerPacksPageTitle().isDisplayed());
//
//			if (getCurrentPageRecord() > 0) {
//				preferences.getSelectAllCheckBox().click();
//				getDeleteLink().click();
//				getBtnYes().click();
//				Thread.sleep(2000);
//			}
//			getBtnNewPack().click();
//			Thread.sleep(5000);
//			WebDriverWait wait = new WebDriverWait(driver, 30);
//			wait.until(ExpectedConditions.visibilityOf(getPopup()));
//			getArrow().click();
//			selectProgram();
//			getPackAmount().sendKeys(employeePacksData.getXMLData("packAmount1"));
//			utils.clickfield("xpath", calenderUtils.calenderInPopup);
//			String selectedDate = calenderUtils.getCurrentDate(0,"MMM/dd/yyyy");
//			System.out.println("Selected Date-"+selectedDate);
//			calenderUtils.selectDate(selectedDate,"MMM/dd/yyyy");
//			getBtnSave().click();
//			Thread.sleep(2000);
//			Assert.assertTrue(getSuccessMsg().isDisplayed());
//			utils.clickfield("xpath", calenderUtils.calenderTxtbox);
//			calenderUtils.selectDate(selectedDate,"MMM/dd/yyyy");
//			
//			HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt2();
//			String effectiveDateInGrid = allTableDataTxt.get(1).get("Effective Date");
//			String formattedDateInGrid = calenderUtils.covertDateFromOneFormatToOther(effectiveDateInGrid,"MM/dd/yyyy","MMM/dd/yyyy");
//			Assert.assertTrue(selectedDate.equalsIgnoreCase(formattedDateInGrid));
//		}

	// futuredate
//	@Test(priority = 10)
//	public void verifyDealerPackDoesnotImpactsContractCreationPageThroughAgentLogin() throws Exception {
//		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
//		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
//		Thread.sleep(5000);
//
//		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage My Dealer Packs");
//		selectDealerName(UtilsDataReader.getXMLData("dealer"));
//		Thread.sleep(2000);
//		if (getCurrentPageRecord() > 0) {
//			preferences.getSelectAllCheckBox().click();
//			getDeleteLink().click();
//			getBtnYes().click();
//			Thread.sleep(2000);
//		}
//
//		// data
//		String programCode = prop.getProperty("agentProgramCode");
//		//String program = prop.getProperty("agentProgram");
//		String priceTobeEnteredInStringFormat = employeePacksData.getXMLData("packAmount1");
//		//int packAmount = Integer.parseInt(priceTobeEnteredInStringFormat);
//
//		verticalMenu.navigatetoContract();
//		contract.getSelectDealerTogenerateContract(UtilsDataReader.getXMLData("dealer"));
//		int vehiclePriceBefore = getVehiclePrice(programCode);
//		System.out.println("vehicle Price before------" + vehiclePriceBefore);
//
//		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage My Dealer Packs");
//		selectDealerName(UtilsDataReader.getXMLData("dealer"));
//		Thread.sleep(2000);
//		createNewPackFutureDate(programCode, priceTobeEnteredInStringFormat,5);
//
//		verticalMenu.navigatetoContract();
//		Thread.sleep(2000);
//		int vehiclePriceBeforeAfter = getVehiclePrice(programCode);
//		System.out.println("vehicle Price after------" + vehiclePriceBeforeAfter);
//		Assert.assertEquals(vehiclePriceBeforeAfter, vehiclePriceBefore);
//	}

	// futuredate
//	@Test(priority = 11)
//	public void verifyDealerPackDoesnotImpactsContractCreationPageForFutureDate_32132() throws Exception {
//		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
//		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
//
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
//		Thread.sleep(2000);
//		if (getCurrentPageRecord() > 0) {
//			preferences.getSelectAllCheckBox().click();
//			getDeleteLink().click();
//			getBtnYes().click();
//			Thread.sleep(2000);
//		}
//
//		// data
//		String programCode = prop.getProperty("dealerProgramCode");
//		String program = prop.getProperty("dealerProgram");
//		String priceTobeEnteredInStringFormat = employeePacksData.getXMLData("packAmount1");
//		//int packAmount = Integer.parseInt(priceTobeEnteredInStringFormat);
//
//		verticalMenu.navigatetoContract();
//		int vehiclePriceBefore = getVehiclePrice(programCode);
//		System.out.println("vehicle Price before------" + vehiclePriceBefore);
//
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
//		Thread.sleep(2000);
//		createNewPackFutureDate(program, priceTobeEnteredInStringFormat,3);
//
//		verticalMenu.navigatetoContract();
//		Thread.sleep(5000);
//		int vehiclePriceBeforeAfter = getVehiclePrice(programCode);
//		System.out.println("vehicle Price after------" + vehiclePriceBeforeAfter);
//		Assert.assertEquals(vehiclePriceBeforeAfter, vehiclePriceBefore);
//	}

	// futuredate
//	@Test(priority = 12)
//	public void verifyLenderPackDoesNotImpactsContractCreationPage_32133() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		//Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Lender", "3641");
//		Thread.sleep(5000);
//
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Lender Packs");
//		Thread.sleep(2000);
//		if (getCurrentPageRecord() > 0) {
//			preferences.getSelectAllCheckBox().click();
//			getDeleteLink().click();
//			getBtnYes().click();
//			Thread.sleep(2000);
//		}
//
//		// data
//		String programCode = prop.getProperty("lenderProgramCode");
//		String program = prop.getProperty("lenderProgramCode");
//		String priceTobeEnteredInStringFormat = "120";
//		//int packAmount = Integer.parseInt(priceTobeEnteredInStringFormat);
//		
//		verticalMenu.navigatetoContract();
//		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
//		int vehiclePriceBefore = getVehiclePriceForLender(programCode);
//		System.out.println("vehicle Price before------" + vehiclePriceBefore);
//		
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Lender Packs");
//		Thread.sleep(2000);
//		createNewPackFutureDate(program, priceTobeEnteredInStringFormat,2);
//		Thread.sleep(5000);
//		
//		verticalMenu.navigatetoContract();
//		int vehiclePriceBeforeAfter = getVehiclePriceForLender(programCode);
//		System.out.println("vehicle Price after------" + vehiclePriceBeforeAfter);
//		Assert.assertEquals(vehiclePriceBeforeAfter, vehiclePriceBefore);
//	}

//	//futuredate
//	@Test(priority = 13)
//	public void verifyDealerPackDoesnotImpactsContractCreationPageThroughSubAgentLogin_32117() throws Exception {
//		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
//		Assert.assertEquals(getPortalTitle().getText(), UtilsDataReader.getXMLData("ADLpageTitle"));
//
//		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage My Dealer Packs");
//		selectDealerName(UtilsDataReader.getXMLData("dealer"));
//		Thread.sleep(2000);
//		if (getCurrentPageRecord() > 0) {
//			preferences.getSelectAllCheckBox().click();
//			getDeleteLink().click();
//			getBtnYes().click();
//			Thread.sleep(2000);
//		}
//
//		// data
//		String programCode = prop.getProperty("agentProgramCode");
//		String program = prop.getProperty("agentProgram");
//		String priceTobeEnteredInStringFormat = employeePacksData.getXMLData("packAmount1");
//		int packAmount = Integer.parseInt(priceTobeEnteredInStringFormat);
//
//		verticalMenu.navigatetoContract();
//		contract.getSelectDealerTogenerateContract(UtilsDataReader.getXMLData("dealer"));
//		int vehiclePriceBefore = getVehiclePrice(programCode);
//		System.out.println("vehicle Price before------" + vehiclePriceBefore);
//
//		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage My Dealer Packs");
//		selectDealerName(UtilsDataReader.getXMLData("dealer"));
//		Thread.sleep(2000);
//		createNewPackFutureDate(programCode, priceTobeEnteredInStringFormat,4);
//
//		verticalMenu.navigatetoContract();
//		Thread.sleep(2000);
//		int vehiclePriceBeforeAfter = getVehiclePrice(programCode);
//		System.out.println("vehicle Price after------" + vehiclePriceBeforeAfter);
//		Assert.assertEquals(vehiclePriceBeforeAfter, vehiclePriceBefore);
//	}

	@AfterMethod(alwaysRun = true)
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