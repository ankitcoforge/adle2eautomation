package testsuite;

import java.text.NumberFormat;

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

public class Markups_test extends PricingPreferencesAction {
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	LateralMenuAction lateralMenu=new LateralMenuAction();
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();
	singleContractAction contract =new singleContractAction();
	EmployeePacksAction EmplPacks =new EmployeePacksAction();
	pageActions.ManageVSC_GAPpreferencesAction ManageVSCGAP=new pageActions.ManageVSC_GAPpreferencesAction();
	CalenderUtils calenderUtils= new CalenderUtils();
	XmlDataReader employeePacksData= new XmlDataReader("EmployeePacksData");
	XmlDataReader markupData= new XmlDataReader("MarkupData");
	
	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}
	
	
	@Test(priority = 1)
	public void verifyMarkupForDealerFlatAll() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--"+EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();
		
        //data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		int markupAmount =Integer.parseInt(priceInStringFormat);
		
		verticalMenu.navigatetoContract();
		int vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(programCode,"Flat", "All", priceInStringFormat);
		verticalMenu.navigatetoContract();
		int vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------"+vehiclePriceAfter);
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
		System.out.println("size--"+EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();
		
        //data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		int markupAmount =Integer.parseInt(priceInStringFormat);
		
		verticalMenu.navigatetoContract();
		int vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForClass(programCode,"Flat", "3",priceInStringFormat);
		verticalMenu.navigatetoContract();
		int vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------"+vehiclePriceAfter);
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
		System.out.println("size--"+EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();
		
        //data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		int markupAmount =Integer.parseInt(priceInStringFormat);
		
		verticalMenu.navigatetoContract();
		int vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForCoverage(programCode,"Flat", "Reserve", priceInStringFormat);
		verticalMenu.navigatetoContract();
		int vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------"+vehiclePriceAfter);
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
		System.out.println("size--"+EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();
		
        //data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		int markupAmount =Integer.parseInt(priceInStringFormat);
		
		verticalMenu.navigatetoContract();
		int vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForMileageBand(programCode,"Flat", "0-18000", priceInStringFormat);
		verticalMenu.navigatetoContract();
		int vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------"+vehiclePriceAfter);
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
		System.out.println("size--"+EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();
		
        //data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		int markupAmount =Integer.parseInt(priceInStringFormat);
		String termMonths = markupData.getXMLData("termMonth4");
		
		verticalMenu.navigatetoContract();
		int vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonth(programCode, termMonths);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForTerMonths(programCode,"Flat", termMonths, priceInStringFormat);
		verticalMenu.navigatetoContract();
		int vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonth(programCode, termMonths);
		System.out.println("vehicle Price after------"+vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContractForTermMonth(termMonths);
	}

	@Test(priority = 6)
	public void verifyMarkupForLenderFlatAll() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForSubagentLendrEmp("Lender", "3641");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--"+EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();
		
        //data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		int markupAmount =Integer.parseInt(priceInStringFormat);
		
		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		int vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(program);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForAll(program,"Flat", "All", priceInStringFormat);
		verticalMenu.navigatetoContract();
		int vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(program);
		System.out.println("vehicle Price after------"+vehiclePriceAfter);
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
		System.out.println("size--"+EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();
		
        //data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		int markupAmount =Integer.parseInt(priceInStringFormat);
		
		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		int vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(program);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForClass(program,"Flat", "1",priceInStringFormat);
		verticalMenu.navigatetoContract();
		int vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(program);
		System.out.println("vehicle Price after------"+vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}
	
	@Test(priority = 8)
	public void verifyMarkupForLenderFlatCoverage() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForSubagentLendrEmp("Lender", "3641");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		System.out.println("size--"+EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();
		
        //data
		String programCode = prop.getProperty("lenderProgramCode");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		int markupAmount =Integer.parseInt(priceInStringFormat);
		
		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		int vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForCoverage(programCode,"Flat", "Powertrain", priceInStringFormat);
		verticalMenu.navigatetoContract();
		int vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------"+vehiclePriceAfter);
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
		System.out.println("size--"+EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();
		
        //data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		int markupAmount =Integer.parseInt(priceInStringFormat);
		
		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		int vehiclePriceBefore = EmplPacks.getVehiclePriceForLender(program);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForMileageBand(program,"Flat", "0 - 200000", priceInStringFormat);
		verticalMenu.navigatetoContract();
		int vehiclePriceAfter = EmplPacks.getVehiclePriceForLender(program);
		System.out.println("vehicle Price after------"+vehiclePriceAfter);
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
		System.out.println("size--"+EmplPacks.getRows().size());
		EmplPacks.verfyNoExistingPacksPresent();
		
        //data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
		int markupAmount =Integer.parseInt(priceInStringFormat);
		String termMonths = markupData.getXMLData("termMonth1");
		
		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		int vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonthLender(program, termMonths);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		createMarkupForTerMonths(program,"Flat", termMonths, priceInStringFormat);
		verticalMenu.navigatetoContract();
		int vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonthLender(program, termMonths);
		System.out.println("vehicle Price after------"+vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContractForTermMonth(termMonths);
	}
	
//	@Test(priority = 11)
//	public void verifyMarkupForDealerPercentageAll() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", "28771");
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
//		System.out.println("size--"+EmplPacks.getRows().size());
//		EmplPacks.verfyNoExistingPacksPresent();
//		
//        //data
//		String programCode = prop.getProperty("dealerProgramCode");
//		String priceInStringFormat = markupData.getXMLData("percentage");
//		int markupAmount =Integer.parseInt(priceInStringFormat);
//		int markupInPercent = markupAmount / 100;
//		double markupPercent = Double.parseDouble(String.valueOf(markupInPercent));
//		 
//		
//		verticalMenu.navigatetoContract();
//		int vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
//		double markup = vehiclePriceBefore * markupPercent ;
//		System.out.println("vehicle Price before------"+vehiclePriceBefore);
//		System.out.println("Markup added in percent-"+ priceInStringFormat+"i.e "+ markup);
//		
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
//		createMarkupForAll(programCode,"Percentage", "All", priceInStringFormat);
//		verticalMenu.navigatetoContract();
//		Double vehiclePriceAfter = getVehiclePriceForPercentageMarkup(programCode);
//		System.out.println("vehicle Price after------"+vehiclePriceAfter);
//		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markup));
////		singleContract();
//	}
	
//	@Test(priority = 12)
//	public void verifyMarkupForDealerPercentageClass() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", "28771");
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
//		System.out.println("size--"+EmplPacks.getRows().size());
//		EmplPacks.verfyNoExistingPacksPresent();
//		
//        //data
//		String programCode = prop.getProperty("dealerProgramCode");
//		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
//		int markupAmount =Integer.parseInt(priceInStringFormat);
//		
//		verticalMenu.navigatetoContract();
//		int vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
//		System.out.println("vehicle Price before------"+vehiclePriceBefore);
//		
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
//		createMarkupForClass(programCode,"Percentage", "3",priceInStringFormat);
//		verticalMenu.navigatetoContract();
//		int vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
//		System.out.println("vehicle Price after------"+vehiclePriceAfter);
//		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContract();
//	}
//	
//	@Test(priority = 13)
//	public void verifyMarkupForDealerPercentageCoverage() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", "28771");
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
//		System.out.println("size--"+EmplPacks.getRows().size());
//		EmplPacks.verfyNoExistingPacksPresent();
//		
//        //data
//		String programCode = prop.getProperty("dealerProgramCode");
//		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
//		int markupAmount =Integer.parseInt(priceInStringFormat);
//		
//		verticalMenu.navigatetoContract();
//		int vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
//		System.out.println("vehicle Price before------"+vehiclePriceBefore);
//		
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
//		createMarkupForCoverage(programCode,"Percentage", "Reserve", priceInStringFormat);
//		verticalMenu.navigatetoContract();
//		int vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
//		System.out.println("vehicle Price after------"+vehiclePriceAfter);
//		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContract();
//	}
//	
//	@Test(priority = 14)
//	public void verifyMarkupForDealerPercentageMileageband() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", "28771");
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
//		System.out.println("size--"+EmplPacks.getRows().size());
//		EmplPacks.verfyNoExistingPacksPresent();
//		
//        //data
//		String programCode = prop.getProperty("dealerProgramCode");
//		String priceInStringFormat = employeePacksData.getXMLData("packAmount1");
//		int markupAmount =Integer.parseInt(priceInStringFormat);
//		
//		verticalMenu.navigatetoContract();
//		int vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
//		System.out.println("vehicle Price before------"+vehiclePriceBefore);
//		
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
//		createMarkupForMileageBand(programCode,"Percentage", "0 - 18000", priceInStringFormat);
//		verticalMenu.navigatetoContract();
//		int vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
//		System.out.println("vehicle Price after------"+vehiclePriceAfter);
//		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContract();
//	}
//	
//	@Test(priority = 15)
//	public void verifyMarkupForDealerPercentageTermMonth() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your Protective ADL Portal!");
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", "28771");
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
//		System.out.println("size--"+EmplPacks.getRows().size());
//		EmplPacks.verfyNoExistingPacksPresent();
//		
//        //data
//		String programCode = prop.getProperty("dealerProgramCode");
//		String percentInStringFormat = markupData.getXMLData("percentage");
//		int markupAmount =Integer.parseInt(percentInStringFormat);
//		String termMonths = markupData.getXMLData("termMonth4");
//		
//		verticalMenu.navigatetoContract();
//		int vehiclePriceBefore = EmplPacks.getVehiclePriceForTermMonth(programCode, termMonths);
//		System.out.println("vehicle Price before------"+vehiclePriceBefore);
//		
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
//		createMarkupForTerMonths(programCode,"Percentage", termMonths, percentInStringFormat);
//		verticalMenu.navigatetoContract();
//		int vehiclePriceAfter = EmplPacks.getVehiclePriceForTermMonth(programCode, termMonths);
//		System.out.println("vehicle Price after------"+vehiclePriceAfter);
//		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
//		singleContractForTermMonth(termMonths);
//	}
	
	 @AfterMethod(alwaysRun=true)
	    public void close() throws InterruptedException {
		 try {
			 utils.scrollUpUsingJSE();
				login.logout();
				} catch (Exception e) {
					if(utils.getfield("mat-icon", "close").isDisplayed()) {
					utils.getfield("mat-icon", "close").click();
					}
					login.logout();
			}
	 }

}
