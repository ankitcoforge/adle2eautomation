package testsuite;

import java.util.HashMap;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.EmployeePacksAction;
import pageActions.PricingPreerencesAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import pageObjects.PricingPreferencesPO;
import utils.utilityClass;

public class PricingPreferences_test extends PricingPreerencesAction {
	
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();
	singleContractAction contract =new singleContractAction();
	EmployeePacksAction EmplPacks =new EmployeePacksAction();

	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}
	
	@Test(priority = 1)
	public void verifyPricingPreferencesPage_31666() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "New markup").isEnabled());
		HashMap<Integer, HashMap<String, String>> grid = EmplPacks.checkGridBodyDetailsTxt();
		getAllHeaderNames().contains("Program");
		getAllHeaderNames().contains("Program Code");
		getAllHeaderNames().contains("Prog Markup Eff.Date");
		getAllHeaderNames().contains(" Markup Type ");
		getAllHeaderNames().contains(" Markup By ");
		getAllHeaderNames().contains("Level");
		getAllHeaderNames().contains("Value");
		getAllHeaderNames().contains("Modified By");
		getAllHeaderNames().contains("Impersonated By");
		getAllHeaderNames().contains("Edit");
	}
	

	@Test(priority = 2)
	public void verifyProgramsInMarkupPage_31667() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());
		utils.getfield("span", "New markup").click();
		Thread.sleep(3000);
		EmplPacks.getArrow().click();
		getDropDwnList().contains("United Auto Credit - UA3");
		getDropDwnList().contains("Used Vehicle - RNL");
		getDropDwnList().contains("First Reliance - Used Vehicle - FSL");
		getDropDwnList().contains("First Reliance-New Vehicle (SRD)");
		EmplPacks.getBtnCloseForPopup().click();
		//DB validation
	}
	
	@Test(priority = 3)
	public void verifyMarkupTypes_31668() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());
		utils.getfield("span", "New markup").click();
		Thread.sleep(3000);
		EmplPacks.getArrow().click();
		EmplPacks.selectProgram();
		Thread.sleep(10000);
//		String a = getMarkupTxts().get(0).getText();
//		System.out.println("txt isss-"+a);
//		Thread.sleep(3000);
		getBtnsmarkup().get(1).click();
		Assert.assertTrue(getMarkupAmountPercentSign().getText().equals("%"),"% sign is shown if percent is selected");
		getBtnsmarkup().get(0).click();
		Assert.assertTrue(getMarkupAmountDollarSign().getText().equals("attach_money"),"$ sign is shown if flat is selected");
		EmplPacks.getBtnCloseForPopup().click();

		
	}
	
	@Test(priority = 4)
	public void verifyMarkupByWithFlatType_31669() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());
		utils.getfield("span", "New markup").click();
		Thread.sleep(3000);
		EmplPacks.getArrow().click();
		EmplPacks.selectProgram();
		Thread.sleep(2000);
		getBtnsmarkup().get(0).click();
		getBtnsmarkup().get(2).click();
		Assert.assertTrue(getMarkupAmountTxtFld().size() == 1);
		getBtnsmarkup().get(3).click();
		Thread.sleep(2000);
		Assert.assertTrue(getMarkupAmountTxtFld().size() == 4);
		getBtnsmarkup().get(4).click();
		Thread.sleep(2000);
		Assert.assertTrue(getMarkupAmountTxtFld().size() == 3);
		getBtnsmarkup().get(5).click();
		Thread.sleep(2000);
		Assert.assertTrue(getMarkupAmountTxtFld().size() == 18);
		getBtnsmarkup().get(6).click();
		Thread.sleep(2000);
		Assert.assertTrue(getMarkupAmountTxtFld().size() == 6);
		EmplPacks.getBtnCloseForPopup().click();

	}
	
	@Test(priority = 5)
	public void verifySaveBtn_31671() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());
		utils.getfield("span", "New markup").click();
		Thread.sleep(3000);
		EmplPacks.getArrow().click();
		EmplPacks.selectProgram();
		Thread.sleep(2000);
		getBtnsmarkup().get(0).click();
		getBtnsmarkup().get(2).click();
		Thread.sleep(2000);
		getMarkupAmountTxtFld().get(0).sendKeys("100");
		utils.getfield("span", "Save").click();
	}
	
	@Test(priority = 6)
	public void verifyMarkupWithContract_31672() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());
		System.out.println("size--"+EmplPacks.getRows().size());
		if(EmplPacks.getRows().size() > 0)
		{
		getSelectAllCheckBox().click();
		EmplPacks.getDeleteLink().click();
		EmplPacks.getBtnYes().click();
		Thread.sleep(2000);
		}
		
        //data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceTobeEnteredInStringFormat = "100";
		int markupAmount =Integer.parseInt(priceTobeEnteredInStringFormat);
		
		verticalMenu.navigatetoContract();
		 int vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		
		utils.getfield("span", "New markup").click();
		Thread.sleep(3000);
		EmplPacks.getArrow().click();
		EmplPacks.selectProgramNew(programCode);
		Thread.sleep(2000);
		getBtnsmarkup().get(0).click();
		getBtnsmarkup().get(2).click();
		Thread.sleep(2000);
		getMarkupAmountTxtFld().get(0).sendKeys(priceTobeEnteredInStringFormat);
		utils.getfield("span", "Save").click();
		verticalMenu.navigatetoContract();
		int vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------"+vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}
	
	@Test(priority = 7)
	public void verifyMarkupWithContractForLender_31673() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Lender", "3641");
		Thread.sleep(5000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());
		System.out.println("size--"+EmplPacks.getRows().size());
		if(EmplPacks.getRows().size() > 0 )
		{
		getSelectAllCheckBox().click();
		EmplPacks.getDeleteLink().click();
		EmplPacks.getBtnYes().click();
		Thread.sleep(2000);
		}
		
        //data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String priceTobeEnteredInStringFormat = "100";
		int markupAmount =Integer.parseInt(priceTobeEnteredInStringFormat);
		
		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		 int vehiclePriceBefore =  EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		
		utils.getfield("span", "New markup").click();
		Thread.sleep(3000);
		EmplPacks.getArrow().click();
		EmplPacks.selectProgramNew(programCode);
		Thread.sleep(2000);
		getBtnsmarkup().get(0).click();
		getBtnsmarkup().get(2).click();
		Thread.sleep(2000);
		getMarkupAmountTxtFld().get(0).sendKeys(priceTobeEnteredInStringFormat);
		utils.getfield("span", "Save").click();
		verticalMenu.navigatetoContract();
		int vehiclePriceBeforeAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------"+vehiclePriceBeforeAfter);
		Assert.assertEquals(vehiclePriceBeforeAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}
	
	@Test(priority = 8)
	public void verifySaveBtnForLender_31674() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());
		utils.getfield("span", "New markup").click();
		Thread.sleep(3000);
		EmplPacks.getArrow().click();
		EmplPacks.selectProgram();
		Thread.sleep(2000);
		getBtnsmarkup().get(0).click();
		getBtnsmarkup().get(2).click();
		Thread.sleep(2000);
		getMarkupAmountTxtFld().get(0).sendKeys("100");
		utils.getfield("span", "Save").click();
	}
	
	@Test(priority = 9)
	public void verifyMarkupWithContractForLenderEmp_31686() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("LenderEmp", "3641");
		Thread.sleep(5000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());
		System.out.println("size--"+EmplPacks.getRows().size());
		if(EmplPacks.getRows().size() > 0 )
		{
		getSelectAllCheckBox().click();
		EmplPacks.getDeleteLink().click();
		EmplPacks.getBtnYes().click();
		Thread.sleep(2000);
		}
		
        //data
		String programCode = prop.getProperty("lenderProgramCode");
		String program = prop.getProperty("lenderProgram");
		String priceTobeEnteredInStringFormat = "100";
		int markupAmount =Integer.parseInt(priceTobeEnteredInStringFormat);
		
		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		 int vehiclePriceBefore =  EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		
		utils.getfield("span", "New markup").click();
		Thread.sleep(3000);
		EmplPacks.getArrow().click();
		EmplPacks.selectProgramNew(programCode);
		Thread.sleep(2000);
		getBtnsmarkup().get(0).click();
		getBtnsmarkup().get(2).click();
		Thread.sleep(2000);
		getMarkupAmountTxtFld().get(0).sendKeys(priceTobeEnteredInStringFormat);
		utils.getfield("span", "Save").click();
		verticalMenu.navigatetoContract();
		int vehiclePriceBeforeAfter = EmplPacks.getVehiclePriceForLender(programCode);
		System.out.println("vehicle Price after------"+vehiclePriceBeforeAfter);
		Assert.assertEquals(vehiclePriceBeforeAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}
	
	
	
	@Test(priority = 10)
	public void verifyMarkupWithContractForDealerEmp_31687() throws Exception {
		login.login(prop.getProperty("dealerempAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());
		System.out.println("size--"+EmplPacks.getRows().size());
		if(EmplPacks.getRows().size() > 0)
		{
		getSelectAllCheckBox().click();
		EmplPacks.getDeleteLink().click();
		EmplPacks.getBtnYes().click();
		Thread.sleep(2000);
		}
		
        //data
		String programCode = prop.getProperty("dealerProgramCode");
		String priceTobeEnteredInStringFormat = "100";
		int markupAmount =Integer.parseInt(priceTobeEnteredInStringFormat);
		
		verticalMenu.navigatetoContract();
		 int vehiclePriceBefore = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		
		utils.getfield("span", "New markup").click();
		Thread.sleep(3000);
		EmplPacks.getArrow().click();
		EmplPacks.selectProgramNew(programCode);
		Thread.sleep(2000);
		getBtnsmarkup().get(0).click();
		getBtnsmarkup().get(2).click();
		Thread.sleep(2000);
		getMarkupAmountTxtFld().get(0).sendKeys(priceTobeEnteredInStringFormat);
		utils.getfield("span", "Save").click();
		verticalMenu.navigatetoContract();
		int vehiclePriceAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------"+vehiclePriceAfter);
		Assert.assertEquals(vehiclePriceAfter, (vehiclePriceBefore + markupAmount));
		singleContract();	
		}
	
	@Test(priority = 11)
	public void verifyProgramsInMarkupPageForAgent_31688() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage Pricing Preferences").isDisplayed());
		EmplPacks.selectDealerName("Angel Motors Inc");
		Thread.sleep(2000);
		if(EmplPacks.getRows().size() > 1)
		{
		getSelectAllCheckBox().click();
		EmplPacks.getDeleteLink().click();
		EmplPacks.getBtnYes().click();
		Thread.sleep(2000);
		}
		utils.getfield("span", "New markup").click();
		Thread.sleep(3000);
		EmplPacks.getArrow().click();
		getDropDwnList().contains("NSE");
		getDropDwnList().contains("SNI");
		EmplPacks.getBtnCloseForPopup().click();

		//DB validation
	}
	
	@Test(priority = 12)
	public void verifySaveBtnForAgent_31689() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage Pricing Preferences").isDisplayed());
		EmplPacks.selectDealerName("Angel Motors Inc");
		Thread.sleep(2000);
		if(EmplPacks.getRows().size() > 1)
		{
		getSelectAllCheckBox().click();
		EmplPacks.getDeleteLink().click();
		EmplPacks.getBtnYes().click();
		Thread.sleep(2000);
		}
		utils.getfield("span", "New markup").click();
		Thread.sleep(3000);
		EmplPacks.getArrow().click();
		EmplPacks.selectProgram();
		Thread.sleep(2000);
		getBtnsmarkup().get(0).click();
		getBtnsmarkup().get(2).click();
		Thread.sleep(2000);
		getMarkupAmountTxtFld().get(0).sendKeys("100");
		utils.getfield("span", "Save").click();
	}
	
	@Test(priority = 13)
	public void verifyMarkupWithContractForAgent_31673_31690() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage Pricing Preferences").isDisplayed());
		EmplPacks.selectDealerName("Angel Motors Inc");
		Thread.sleep(2000);
		if(EmplPacks.getRows().size() > 1 )
		{
		getSelectAllCheckBox().click();
		EmplPacks.getDeleteLink().click();
		EmplPacks.getBtnYes().click();
		Thread.sleep(2000);
		}
		
        //data
		String programCode = prop.getProperty("agentProgramCode");
		String program = prop.getProperty("agentProgram");
		String priceTobeEnteredInStringFormat = "100";
		int markupAmount =Integer.parseInt(priceTobeEnteredInStringFormat);
		
		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("Angel Motors Inc");
		 int vehiclePriceBefore =  EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Pricing Preferences");
		Thread.sleep(2000);
		
		utils.getfield("span", "New markup").click();
		Thread.sleep(3000);
		EmplPacks.getArrow().click();
		EmplPacks.selectProgramNew(programCode);
		Thread.sleep(2000);
		getBtnsmarkup().get(0).click();
		getBtnsmarkup().get(2).click();
		Thread.sleep(2000);
		getMarkupAmountTxtFld().get(0).sendKeys(priceTobeEnteredInStringFormat);
		utils.getfield("span", "Save").click();
		verticalMenu.navigatetoContract();
		int vehiclePriceBeforeAfter = EmplPacks.getVehiclePrice(programCode);
		System.out.println("vehicle Price after------"+vehiclePriceBeforeAfter);
		Assert.assertEquals(vehiclePriceBeforeAfter, (vehiclePriceBefore + markupAmount));
		singleContract();
	}
	

	 @AfterMethod(alwaysRun=true)
	    public void close() throws InterruptedException {
	        login.logout();
	    }

}
