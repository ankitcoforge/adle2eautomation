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

/* PBI No: 32780*/

public class HistoryTableMarkup_test extends PricingPreferencesAction {

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

	@BeforeClass(alwaysRun = true)
	public void login() throws InterruptedException {
//		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}

	@Test(priority = 1)
	public void verifyHistoryTableDisplaysCorrectlyForLender_39232_39233_39235() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		EmplPacks.verfyNoExistingPacksPresent();
		// data
		String program = prop.getProperty("lenderProgram");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		createMarkupForAll(program, "Flat", "All", priceInStringFormat);
		editMarkupBtn().click();
		utils.scrollDownUsingJSE(700);
		Thread.sleep(3000);
		utils.getfield("h5", "History").isDisplayed();
		getAllHeaderNamesInHistoryTable().get(0).contains("Eff.Date");
		getAllHeaderNamesInHistoryTable().get(1).contains("Markup Type");
		getAllHeaderNamesInHistoryTable().get(2).contains("Markup By");
		getAllHeaderNamesInHistoryTable().get(3).contains("Level");
		getAllHeaderNamesInHistoryTable().get(4).contains("Value");
		getAllHeaderNamesInHistoryTable().get(5).contains("Modified By");
		getAllHeaderNamesInHistoryTable().get(6).contains("Impersonated By");
	}

	@Test(priority = 2)
	public void verifyHistoryTableDisplaysCorrectlyForDealer_39238_39239_39241() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		EmplPacks.verfyNoExistingPacksPresent();
		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		createMarkupForAll(programCode, "Flat", "All", priceInStringFormat);
		editMarkupBtn().click();
		utils.scrollDownUsingJSE(700);
		Thread.sleep(3000);
		utils.getfield("h5", "History").isDisplayed();
		getAllHeaderNamesInHistoryTable().get(0).contains("Eff.Date");
		getAllHeaderNamesInHistoryTable().get(1).contains("Markup Type");
		getAllHeaderNamesInHistoryTable().get(2).contains("Markup By");
		getAllHeaderNamesInHistoryTable().get(3).contains("Level");
		getAllHeaderNamesInHistoryTable().get(4).contains("Value");
		getAllHeaderNamesInHistoryTable().get(5).contains("Modified By");
		getAllHeaderNamesInHistoryTable().get(6).contains("Impersonated By");
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
