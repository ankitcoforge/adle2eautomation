package testsuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.EmployeePacksAction;
import pageActions.LateralMenuAction;
import pageActions.PricingPreferencesAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import utils.CalenderUtils;
import utils.XmlDataReader;
import utils.utilityClass;

public class HistoryTablePacks_test extends PricingPreferencesAction {


	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	LateralMenuAction lateralMenu = new LateralMenuAction();
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction();
	singleContractAction contract = new singleContractAction();
	EmployeePacksAction EmplPacks = new EmployeePacksAction();
	pageActions.ManageVSC_GAPpreferencesAction ManageVSCGAP = new pageActions.ManageVSC_GAPpreferencesAction();
	CalenderUtils calenderUtils = new CalenderUtils();
	XmlDataReader employeePacksData = new XmlDataReader("EmployeePacksData");
	XmlDataReader markupData = new XmlDataReader("MarkupData");
	EmployeePacksAction packs = new EmployeePacksAction();

	@BeforeClass(alwaysRun = true)
	public void login() throws InterruptedException {
//		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}

	@Test(priority = 1)
	public void verifyHistoryTableDisplaysCorrectlyForLender_39875_39876_39878() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Lender Packs");
		EmplPacks.verfyNoExistingPacksPresent();
		// data
		String program = prop.getProperty("lenderProgramCode");
		String priceTobeEnteredInStringFormat = employeePacksData.getXMLData("packAmount4");
		packs.createNewPack(program, priceTobeEnteredInStringFormat);
		packs.editPack(1);
		utils.scrollDownUsingJSE(700);
		Thread.sleep(3000);
		utils.getfield("div", "History").isDisplayed();
		getAllHeaderNamesInHistoryTable().get(0).contains("Eff.Date");
		getAllHeaderNamesInHistoryTable().get(1).contains("Impersonated By");
		getAllHeaderNamesInHistoryTable().get(2).contains("Modified By");
		getAllHeaderNamesInHistoryTable().get(3).contains("Pack Amount");
	}

	@Test(priority = 2)
	public void verifyHistoryTableDisplaysCorrectlyForDealer_39881_39882_39884() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		EmplPacks.verfyNoExistingPacksPresent();
		// data
		packs.createNewPack("RSE", employeePacksData.getXMLData("packAmount2"));
		packs.editPack(1);
		utils.scrollDownUsingJSE(700);
		Thread.sleep(3000);
		utils.getfield("div", "History").isDisplayed();
		getAllHeaderNamesInHistoryTable().get(0).contains("Eff.Date");
		getAllHeaderNamesInHistoryTable().get(1).contains("Impersonated By");
		getAllHeaderNamesInHistoryTable().get(2).contains("Modified By");
		getAllHeaderNamesInHistoryTable().get(3).contains("Pack Amount");
	}

	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		try {
			utils.scrollUpUsingJSE();
			login.logout();
		} catch (Exception e) {
			if (utils.getfield("mat-icon", "close").isDisplayed()) {
				utils.getfield("mat-icon", "close").click();
			}
			login.logout();
		}
	}



}
