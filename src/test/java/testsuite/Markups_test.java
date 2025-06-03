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

/* PBI 32779*/ 

public class Markups_test extends PricingPreferencesAction {
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

	@Test(priority = 0)
	public void verifyNoPacksArePresentAsaPrecondition() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		EmplPacks.verfyNoExistingPacksPresent();
		login.logout();
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		EmplPacks.verfyNoExistingPacksPresent();
	}

	@Test(priority = 1)
	public void verifyMarkupForDealerFlatAll_32805_32744() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
//		EmplPacks.verfyNoExistingPacksPresent();
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(programCode, "Flat", "All", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}

	@Test(priority = 2)
	public void verifyMarkupForDealerFlatClass() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForClass(programCode, "Flat", "3", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}

	@Test(priority = 3)
	public void verifyMarkupForDealerFlatCoverage() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForCoverage(programCode, "Flat", "Reserve", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}

	@Test(priority = 4)
	public void verifyMarkupForDealerFlatMileageband() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForMileageBand(programCode, "Flat", "0-18000", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}

	@Test(priority = 5)
	public void verifyMarkupForDealerFlatTermMonth() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);
		String termMonths = markupData.getXMLData("termMonth4");

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonth(programCode, termMonths);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForTerMonths(programCode, "Flat", termMonths, priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonth(programCode, termMonths);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContractForTermMonth(termMonths);
	}

	@Test(priority = 6)
	public void verifyMarkupForLenderFlatAll() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
//		impersonate.impersonateUserForSubagentLendrEmp("Lender", "3641");
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Lender Packs");
//		EmplPacks.verfyNoExistingPacksPresent();
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(program, "Flat", "All", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}

	@Test(priority = 7)
	public void verifyMarkupForLenderFlatClass() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForSubagentLendrEmp("Lender", "3641");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForClass(program, "Flat", "1", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}

	@Test(priority = 8)
	public void verifyMarkupForLenderFlatCoverage() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForCoverage(programCode, "Flat", "Powertrain", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}

	@Test(priority = 9)
	public void verifyMarkupForLenderFlatMileageband() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForSubagentLendrEmp("Lender", "3641");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForMileageBand(program, "Flat", "0 - 200000", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}

	@Test(priority = 10)
	public void verifyMarkupForLenderFlatTermMonth() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForSubagentLendrEmp("Lender", "3641");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);
		String termMonths = markupData.getXMLData("termMonth1");

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonthLender(programCode, termMonths);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForTerMonths(program, "Flat", termMonths, priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonthLender(programCode, termMonths);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContractForTermMonth(termMonths);
	}

	@Test(priority = 11)
	public void verifyMarkupForDealerPercentageAll() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(programCode, "Percentage", "All", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = getVehiclePriceForPercentageMarkup(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContract();
	}

	@Test(priority = 12)
	public void verifyMarkupForDealerPercentageClass_32860() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForClass(programCode, "Percentage", "3", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContract();
	}

	@Test(priority = 13)
	public void verifyMarkupForDealerPercentageCoverage() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForCoverage(programCode, "Percentage", "Reserve", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContract();
	}

	@Test(priority = 14)
	public void verifyMarkupForDealerPercentageMileageband_32862() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForMileageBand(programCode, "Percentage", "0-18000", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContract();
	}

	@Test(priority = 15)
	public void verifyMarkupForDealerPercentageTermMonth() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;
		String termMonths = markupData.getXMLData("termMonth4");

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonth(programCode, termMonths);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForTerMonths(programCode, "Percentage", termMonths, percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonth(programCode, termMonths);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
//		singleContractForTermMonth(termMonths);
	}

	@Test(priority = 16)
	public void verifyMarkupForLenderPercentageAll() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(program, "Percentage", "All", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContract();
	}

	@Test(priority = 17)
	public void verifyMarkupForLenderPercentageClass() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForClass(program, "Percentage", "1", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContract();
	}

	@Test(priority = 18)
	public void verifyMarkupForLenderPercentageCoverage() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForCoverage(programCode, "Percentage", "Powertrain", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContract();
	}

	@Test(priority = 19)
	public void verifyMarkupForLenderPercentageMileageband() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForSubagentLendrEmp("Lender", "3641");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForMileageBand(program, "Percentage", "0-200000", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContract();
	}

	@Test(priority = 20)
	public void verifyMarkupForLenderPercentageTermMonth() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String termMonths = markupData.getXMLData("termMonth1");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonthLender(programCode, termMonths);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForTerMonths(program, "Percentage", termMonths, percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonthLender(programCode, termMonths);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContractForTermMonth(termMonths);
	}

//	invalid TC
//	@Test(priority = 21)
//	public void verifyNoMarkupAppliedForDealerWhenSaleDatePastDateMarkupCurrentDate_32804() throws Exception {
////		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
////		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
////		verticalMenu.navigatetoimpersonate();
////		impersonate.impersonateUser("Dealer", "28771");
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
//		System.out.println("size--" + EmplPacks.getRows().size());
//		EmplPacks.verfyNoExistingPacksPresent();
//
//		// data
//		String programCode = prop.getProperty("dealerProgramCode");
//		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
//		double markupAmount = Integer.parseInt(priceInStringFormat);
//
//		createMarkupForAll(programCode, "Flat", "All", priceInStringFormat);
//
//		verticalMenu.navigatetoContract();
//		double vehiclePriceCurrentdate = EmplPacks.getVehiclePrice(programCode);
//		System.out.println("vehicle Price current date------" + vehiclePriceCurrentdate);
//
//		driver.navigate().refresh();
//
//		double vehiclePricePastDate = EmplPacks.getVehiclePrice(programCode, -2);
//		System.out.println("vehicle Price past date------" + vehiclePricePastDate);
//		Assert.assertNotEquals(vehiclePriceCurrentdate, vehiclePricePastDate);
////		singleContract();
//	}

	@Test(priority = 21)
	public void verifyMarkupAppliedForDealerFlatAllWhenSaleDateFutureMarkupCurrentDate_32844() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
//		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode,2);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(programCode, "Flat", "All", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode,2);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//				singleContract();
	}
	
	@Test(priority = 22)
	public void verifyMarkupAppliedForDealerFlatCoverageWhenSaleDateFutureMarkupCurrentDate_32845() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
//		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode,2);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(programCode, "Flat", "Coverage", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode,2);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//				singleContract();
	}
	
	@Test(priority = 23)
	public void verifyMarkupAppliedForDealerFlatClassWhenSaleDateFutureMarkupCurrentDate_32852() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
//		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode,2);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(programCode, "Flat", "Class", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode,2);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//				singleContract();
	}
	
	@Test(priority = 24)
	public void verifyMarkupForDealerPercentageTermMonthSaledateFutureMarkupCurrentDate_32861() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;
		String termMonths = markupData.getXMLData("termMonth4");

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonth(programCode, termMonths, 2);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForTerMonths(programCode, "Percentage", termMonths, percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonth(programCode, termMonths, 2);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
//		singleContractForTermMonth(termMonths);
	}

	@Test(priority = 25)
	public void verifyMarkupForDealerEmpFlatAllSaledateFuture_32801() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("DealerEmp", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode,3);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(programCode, "Flat", "All", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode,3);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContract();
	}
	
	@Test(priority = 26)
	public void verifyMarkupForDealerEmpFlatTermMonth_32846() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("DealerEmp", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);
		String termMonths = markupData.getXMLData("termMonth4");

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonth(programCode, termMonths);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForTerMonths(programCode, "Flat", termMonths, priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonth(programCode, termMonths);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContractForTermMonth(termMonths);
	}
	
	@Test(priority = 27)
	public void verifyMarkupForLenderFlatTermMonthSaleDateFutureMarkupCurrentdate_32850() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForSubagentLendrEmp("Lender", "3641");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);
		String termMonths = markupData.getXMLData("termMonth1");

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonthLender(programCode, termMonths, 2);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForTerMonths(program, "Flat", termMonths, priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonthLender(programCode, termMonths, 2);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContractForTermMonth(termMonths);
	}
	
	@Test(priority = 28)
	public void verifyMarkupForLenderEmpFlatCoverage_32853() throws Exception {
		login.login(prop.getProperty("lenderempAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForCoverage(programCode, "Flat", "Powertrain", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}

	@Test(priority = 29)
	public void verifyMarkupForLenderEmpPercentageAllSaledateFutureMarkupCurrentDate_32859() throws Exception {
		login.login(prop.getProperty("lenderempAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode, 3);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(program, "Percentage", "All", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode, 3);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContract();
	}

	@Test(priority = 30)
	public void verifyEditandDeleteMarkupForDealerEmpFlatToPercentCovergeToClass_32920() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("DealerEmp", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode, 2);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForCoverage(programCode, "Flat", "Reserve", priceInStringFormat);
		editMarkup("Percentage", "Class", priceInStringFormat);
		EmplPacks.verfyNoExistingPacksPresent();
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode, 2);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, vehiclePriceBefore);
	}

	@Test(priority = 31)
	public void verifyEditandDeleteMarkupForDealerEmpFlatToPercent_32919() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("DealerEmp", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode, 3);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(programCode, "Flat", "All", priceInStringFormat);
		editMarkup("Percentage", "All", priceInStringFormat);
		EmplPacks.verfyNoExistingPacksPresent();
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode, 3);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, vehiclePriceBefore );
	}
	
	@Test(priority = 32)
	public void verifyMarkupForDealerEmpPercentageClassSaleDateFuture_32864() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode, 3);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForClass(programCode, "Percentage", "3", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode, 3);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
//		singleContract();
	}

	@Test(priority = 33)
	public void verifyMarkupForDealerEmpPercentageClassSaleDateCurrentDate_32865() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForClass(programCode, "Percentage", "3", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContract();
	}

	@Test(priority = 34)
	public void verifyMarkupForLenderPercentageMileagebandSoldDateFutureDate_32867() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForSubagentLendrEmp("Lender", "3641");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode, 2);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForMileageBand(program, "Percentage", "0-200000", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode, 2);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContract();
	}
	
	@Test(priority = 35)
	public void verifyEditMarkupForDealerFlatCoverageToPercentTermMonth_32874() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;
		String termMonths = markupData.getXMLData("termMonth4");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonth(programCode, termMonths);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForCoverage(programCode, "Flat", "Reserve", priceInStringFormat);
		editMarkup("Percentage", termMonths , percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonth(programCode, termMonths);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
//		singleContractForTermMonth(termMonths);
	}
	
	@Test(priority = 36)
	public void verifyEditMarkupForLenderFlatClassToPercentageCoverageCurrentDate_32878() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForClass(programCode, "Flat", "1", priceInStringFormat);
		editMarkup("Percentage", "Powertrain", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContract();
	}

	@Test(priority = 37)
	public void verifyEditMarkupForLenderFlatCoverageToPercentageTermMonthCurrentDate_32879() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String termMonths = markupData.getXMLData("termMonth1");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonthLender(programCode, termMonths);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForCoverage(programCode, "Flat", "Powertrain", priceInStringFormat);
		editMarkup("Percentage", termMonths, percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonthLender(programCode, termMonths);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
//		singleContractForTermMonth(termMonths);
	}


	@Test(priority = 38)
	public void verifyEditMarkupForDealerFlatMilaegeToPercentageAllCurrentDate_32881() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForMileageBand(programCode, "Flat", "0-18000", priceInStringFormat);
		editMarkup("Percentage", "All", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = getVehiclePriceForPercentageMarkup(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContract();
	}


	@Test(priority = 39)
	public void verifyEditMarkupForDealerFlatClassToPercentageCoverageSaleDateFutureDate_32883() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode, 3);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForClass(programCode, "Flat", "3", priceInStringFormat);
		editMarkup("Percentage", "Reserve", percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode, 3);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
		singleContract();
	}

	@Test(priority = 40)
	public void verifyEditMarkupForLenderEmpFlatCoverageToPercentageTermMonthCurrentDate_32884() throws Exception {
		login.login(prop.getProperty("lenderempAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String termMonths = markupData.getXMLData("termMonth1");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonthLender(programCode, termMonths);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForCoverage(programCode, "Flat", "Powertrain", priceInStringFormat);
		editMarkup("Percentage", termMonths, percentValueInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonthLender(programCode, termMonths);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
//		singleContractForTermMonth(termMonths);
	}

	@Test(priority = 41)
	public void verifyEditMarkupAppliedForLenderPercentageAllToFlatClassCurrentDate_32887() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(programCode, "Percentage", "All", percentValueInStringFormat);
		editMarkup("Flat", "1", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContract();
	}
	
	@Test(priority = 42)
	public void verifyEditMarkupAppliedForLenderPercentageCoverageToFlatTermMonthFutureDate_32889() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);
		String termMonths = markupData.getXMLData("termMonth1");

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonthLender(programCode, termMonths, 2);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(programCode, "Percentage", "Reserve", percentValueInStringFormat);
		editMarkup("Flat", termMonths, priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonthLender(programCode, termMonths, 2);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContractForTermMonth(termMonths);
	}
	
	@Test(priority = 43)
	public void verifyEditMarkupAppliedForLenderPercentageTermMonthToFlatMileageCurrentDate_32891() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);
		String termMonths = markupData.getXMLData("termMonth1");

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForTerMonths(programCode, "Percentage", termMonths, percentValueInStringFormat);
		editMarkup("Flat", "0 - 200000", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContract();
	}
	
	@Test(priority = 44)
	public void verifyEditMarkupForDealerPercentageAllToFlatClass_32893() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
//		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
//		double markupInPercent = (double) markupPercentAmount / 100;
//		String termMonths = markupData.getXMLData("termMonth4");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
//		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(programCode, "Percentage", "All", percentValueInStringFormat);
		editMarkup("Flat", "3", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}
	
	@Test(priority = 45)
	public void verifyEditMarkupForDealerPercentageClassToFlatCoverageFutureDate_32894() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;
		String termMonths = markupData.getXMLData("termMonth4");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode, 2);
//		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(programCode, "Percentage", "3", percentValueInStringFormat);
		editMarkup("Flat", "Reserve", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode, 2);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContract();
	}
	

	@Test(priority = 46)
	public void verifyEditMarkupForDealerPercentageTermMonthToFlatMileageFutureDate_32896() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		String termMonths = markupData.getXMLData("termMonth4");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode, 2);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForTerMonths(programCode, "Percentage", termMonths, percentValueInStringFormat);
		editMarkup("Flat", "0-18000", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode, 2);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContract();
	}
	
	@Test(priority = 47)
	public void verifyEditMarkupForDealerEmpPercentageMileageToFlatAllCurrentDate_32897() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("DealerEmp", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForMileageBand(programCode, "Percentage", "0-18000", percentValueInStringFormat);
		editMarkup("Flat", "All", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}
	

	@Test(priority = 48)
	public void verifyEditMarkupForDealerEmpPercentageClassToFlatCoveragefutureDate_32898() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("DealerEmp", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode, 2);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(programCode, "Percentage", "3", percentValueInStringFormat);
		editMarkup("Flat", "Reserve", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode, 2);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContract();
	}
	
	@Test(priority = 49)
	public void verifyEditMarkupAppliedForLenderPercentageCoverageToFlatTermMonthCurrentDate_32899() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);
		String termMonths = markupData.getXMLData("termMonth1");

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonthLender(programCode, termMonths);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForCoverage(programCode, "Percentage", "Powertrain", percentValueInStringFormat);
		editMarkup("Flat", termMonths, priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonthLender(programCode, termMonths);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContractForTermMonth(termMonths);
	}
	
	@Test(priority = 50)
	public void verifyEditMarkupAppliedForLenderPercentageMileageToFlatAllFutureDate_32900() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("lenderProgramCode");
		String percentValueInStringFormat = markupData.getXMLData("percentage");
		int markupPercentAmount = Integer.parseInt(percentValueInStringFormat);
		double markupInPercent = (double) markupPercentAmount / 100;
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		double markupAmount = Integer.parseInt(priceInStringFormat);

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		double vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode, 3);
		double markup = vehiclePriceBefore * markupInPercent;
		System.out.println("vehicle Price before------" + vehiclePriceBefore);
		System.out.println("Markup added - " + percentValueInStringFormat + "%" + "  i.e " + markup);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForMileageBand(programCode, "Percentage", "0-200000", percentValueInStringFormat);
		editMarkup("Flat", "All", priceInStringFormat);
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode, 3);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContract();
	}
	
	@Test(priority = 51)
	public void verifyDeletedMarkupNotAppliedForDealerCurrentDate_32915() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("DealerEmp", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--" + EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();

		// data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");

		verticalMenu.navigatetoContract();
		double vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price before------" + vehiclePriceBefore);

		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(programCode, "Flat", "All", priceInStringFormat);
		EmplPacks.verfyNoExistingPacksPresent();
		verticalMenu.navigatetoContract();
		double vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode, 3);
		System.out.println("vehicle Price after------" + vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, vehiclePriceBefore );
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
