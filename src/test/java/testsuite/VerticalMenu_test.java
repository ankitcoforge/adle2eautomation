package testsuite;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.LateralMenuAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

public class VerticalMenu_test extends LateralMenuAction {
	
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();

	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}
	
	@Test(priority = 1)
	public void verifyLateralMenuOptionsForAgent_30209_30214_30238_32342_30314_32343() throws InterruptedException {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		String toolbox = getLateralMenuItems2().get(1).getText();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<getLateralMenuItems1().size(); i++) {
			String[] menuItem = getLateralMenuItems1().get(i).getText().split("chevron_right");
			list.add(menuItem[0].trim());
			list.add(toolbox);
		}
		System.out.println(list);
			Assert.assertTrue(list.contains("E-Rate"));
			Assert.assertTrue(list.contains("Contracts"));
			Assert.assertTrue(list.contains("Report"));
			Assert.assertTrue(list.contains("Dealer Settings"));
			Assert.assertTrue(list.contains("Agency Settings"));
			Assert.assertTrue(list.contains("Toolbox"));
			Assert.assertTrue(list.contains("Help"));
			
			verticalMenu.navigatetoLeftMainMenu("Contracts");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Contract Search"));
			
			verticalMenu.navigatetoLeftMainMenu("Report");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("My Commissions"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Unpaid Contracts"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Activations"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Cancellations"));
			Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("My Account Statements"));
			Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Claims History"));
			Assert.assertTrue(getLaterMenuSubItems().get(6).getText().contains("Actuarials"));
			Assert.assertTrue(getLaterMenuSubItems().get(7).getText().contains("Early Claims"));
			
			verticalMenu.navigatetoLeftMainMenu("Help");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Web Training Manual for E-Contracting"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Web Traning Manual for Remittance"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Web Training Manual for SPP"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Web Training Manual for ACH-Remit"));
			
			verticalMenu.navigatetoLeftMainMenu("Dealer Settings");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Manage Dealers"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Activity Tracker"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Manage Pricing Preferences"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Manage VSC - GAP Preferences"));
			Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Manage My Dealer Packs"));
			
			verticalMenu.navigatetoLeftMainMenu("Agency Settings");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Manage Users"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Assign Dealers to Sub-Agents"));

			verticalMenu.navigatetoLeftMainMenu("E-Rate");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
			
			
			
	}
	
	@Test(priority = 2)
	public void verifyLateralMenuOptionsForDealer_30210_30315_30216_30237_30240_30243() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		String toolbox = getLateralMenuItems2().get(1).getText();
		String dashboard = getLateralMenuItems2().get(0).getText();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<getLateralMenuItems1().size(); i++) {
			String[] menuItem = getLateralMenuItems1().get(i).getText().split("chevron_right");
			list.add(menuItem[0].trim());
			list.add(toolbox);
			list.add(dashboard);
		}
		System.out.println(list);
		    Assert.assertTrue(list.contains("Dashboard"));
			Assert.assertTrue(list.contains("E-Rate"));
			Assert.assertTrue(list.contains("Contracts"));
			Assert.assertTrue(list.contains("Cancellations"));
			Assert.assertTrue(list.contains("Report"));
			Assert.assertTrue(list.contains("My Settings"));
			Assert.assertTrue(list.contains("Toolbox"));
			Assert.assertTrue(list.contains("Help"));
			
			verticalMenu.navigatetoLeftMainMenu("E-Rate");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
			
			verticalMenu.navigatetoLeftMainMenu("Contracts");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Contract Search"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Remit Contracts to AUL"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Edit Remit AUL VSC/LW"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Remit Classic GAP/Ancillary"));
			Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Remit VAS Ancillary"));
			
			verticalMenu.navigatetoLeftMainMenu("Cancellations");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Cancellation Quote"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Cancellation History"));
			
			verticalMenu.navigatetoLeftMainMenu("Report");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Unpaid Contracts"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Activations"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Cancellations"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("My Account Statements"));
			Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Claims History"));
			Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Actuarials"));
			Assert.assertTrue(getLaterMenuSubItems().get(6).getText().contains("Early Claims"));
			
			verticalMenu.navigatetoLeftMainMenu("My Settings");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Manage My Profile"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Manage Employees"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Issue New User Registration"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Manage My Pricing Preferences"));
			Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Manage VSC - GAP Preferences"));
			Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Manage My Dealer Packs"));
	
			verticalMenu.navigatetoLeftMainMenu("Help");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Web Training Manual for E-Contracting"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Web Traning Manual for Remittance"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Web Training Manual for SPP"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Web Training Manual for ACH-Remit"));
			
	}
	
	@Test(priority = 3)
	public void verifyLateralMenuOptionsForLender_30212_30217_30239_30241_30244_30320_30316() throws InterruptedException {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		String toolbox = getLateralMenuItems2().get(1).getText();
		String dashboard = getLateralMenuItems2().get(0).getText();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<getLateralMenuItems1().size(); i++) {
			String[] menuItem = getLateralMenuItems1().get(i).getText().split("chevron_right");
			list.add(menuItem[0].trim());
			list.add(toolbox);
			list.add(dashboard);
		}
		System.out.println(list);
		    Assert.assertTrue(list.contains("Dashboard"));
			Assert.assertTrue(list.contains("E-Rate"));
			Assert.assertTrue(list.contains("Contracts"));
			Assert.assertTrue(list.contains("Cancellations"));
			Assert.assertTrue(list.contains("Report"));
			Assert.assertTrue(list.contains("My Settings"));
			Assert.assertTrue(list.contains("Toolbox"));
			Assert.assertTrue(list.contains("Help"));
			
			verticalMenu.navigatetoLeftMainMenu("Contracts");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Contract Search"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Remit Contracts to AUL"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Edit Remit AUL VSC/LW"));
			
			verticalMenu.navigatetoLeftMainMenu("Cancellations");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Cancellation Quote"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Cancellation History"));
			
			verticalMenu.navigatetoLeftMainMenu("Report");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Unpaid Contracts"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Activations"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Cancellations"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("My Account Statements"));
			Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Claims History"));
			Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Actuarials"));
			Assert.assertTrue(getLaterMenuSubItems().get(6).getText().contains("Early Claims"));
			
			verticalMenu.navigatetoLeftMainMenu("My Settings");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Manage My Profile"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Manage My Lender Employees"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Issue New User Registration"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Manage My Pricing Preferences"));
			Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Manage VSC - GAP Preferences"));
			Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Manage My Lender Packs"));
			
			verticalMenu.navigatetoLeftMainMenu("E-Rate");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
			
			verticalMenu.navigatetoLeftMainMenu("Help");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Web Training Manual for E-Contracting"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Web Traning Manual for Remittance"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Web Training Manual for SPP"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Web Training Manual for ACH-Remit"));
	}
	
	
	@Test(priority = 4)
	public void verifyMenuOptionsForSubagent_30262_30310_30311_30286_30296_30305_30317() throws InterruptedException {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		String toolbox = getLateralMenuItems2().get(1).getText();
		String dashboard = getLateralMenuItems2().get(0).getText();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<getLateralMenuItems1().size(); i++) {
			String[] menuItem = getLateralMenuItems1().get(i).getText().split("chevron_right");
			list.add(menuItem[0].trim());
			list.add(toolbox);
			list.add(dashboard);
		}
		System.out.println(list);
		Assert.assertTrue(list.contains("Dashboard"));
			Assert.assertTrue(list.contains("E-Rate"));
			Assert.assertTrue(list.contains("Contracts"));
			Assert.assertTrue(list.contains("Report"));
			Assert.assertTrue(list.contains("Dealer Settings"));
			Assert.assertTrue(list.contains("Agency Settings"));
			Assert.assertTrue(list.contains("Toolbox"));
			Assert.assertTrue(list.contains("Help"));
			
			verticalMenu.navigatetoLeftMainMenu("Dealer Settings");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Activity Tracker"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Manage Pricing Preferences"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Manage VSC - GAP Preferences"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Manage My Dealer Packs"));
			
			verticalMenu.navigatetoLeftMainMenu("Agency Settings");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Manage Users"));
			
			verticalMenu.navigatetoLeftMainMenu("Contracts");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Contract Search"));
			
			verticalMenu.navigatetoLeftMainMenu("Report");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("My Commissions"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Unpaid Contracts"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Activations"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Cancellations"));
			Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("My Account Statements"));
			Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Claims History"));
			Assert.assertTrue(getLaterMenuSubItems().get(6).getText().contains("Actuarials"));
			Assert.assertTrue(getLaterMenuSubItems().get(7).getText().contains("Early Claims"));
			
			verticalMenu.navigatetoLeftMainMenu("Help");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Web Training Manual for E-Contracting"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Web Traning Manual for Remittance"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Web Training Manual for SPP"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Web Training Manual for ACH-Remit"));
			
			verticalMenu.navigatetoLeftMainMenu("E-Rate");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
			
	}
	
	//bug only for sgrace employee rest all fine
	@Test(priority = 5)
	public void verifyMenuOptionsForDealerEmp_30213_30263_30290_30297_30301_30306_30285() throws InterruptedException {
		login.login(prop.getProperty("dealerempAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		String toolbox = getLateralMenuItems2().get(1).getText();
		String dashboard = getLateralMenuItems2().get(0).getText();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<getLateralMenuItems1().size(); i++) {
			String[] menuItem = getLateralMenuItems1().get(i).getText().split("chevron_right");
			list.add(menuItem[0].trim());
			list.add(toolbox);
			list.add(dashboard);
		}
		System.out.println(list);
		Assert.assertTrue(list.contains("Dashboard"));
			Assert.assertTrue(list.contains("E-Rate"));
			Assert.assertTrue(list.contains("Contracts"));
			Assert.assertTrue(list.contains("Cancellations"));
			Assert.assertTrue(list.contains("Report"));
			Assert.assertTrue(list.contains("My Settings"));
			Assert.assertTrue(list.contains("Toolbox"));
			Assert.assertTrue(list.contains("Help"));
		
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
		
		verticalMenu.navigatetoLeftMainMenu("Cancellations");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Cancellation Quote"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Cancellation History"));
		
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Unpaid Contracts"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Activations"));
		Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Cancellations"));
		Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("My Account Statements"));
		Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Claims History"));
		Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Actuarials"));
		Assert.assertTrue(getLaterMenuSubItems().get(6).getText().contains("Early Claims"));
		
		verticalMenu.navigatetoLeftMainMenu("My Settings");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Manage My Profile"));
		
		verticalMenu.navigatetoLeftMainMenu("Help");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Web Training Manual for E-Contracting"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Web Traning Manual for Remittance"));
		Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Web Training Manual for SPP"));
		Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Web Training Manual for ACH-Remit"));
		
		verticalMenu.navigatetoLeftMainMenu("Contracts");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Contract Search"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Remit Contracts to AUL"));
		Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Edit Remit AUL VSC/LW"));
		Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Remit Classic GAP/Ancillary"));
		Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Remit VAS Ancillary"));
	}
	
	@Test(priority = 6)
	public void verifyMenuOptionsForLenderEmp_30268_30309_30289_30295_30304_30321_30312() throws InterruptedException {
		login.login(prop.getProperty("lenderempAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		String toolbox = getLateralMenuItems2().get(1).getText();
		String dashboard = getLateralMenuItems2().get(0).getText();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<getLateralMenuItems1().size(); i++) {
			String[] menuItem = getLateralMenuItems1().get(i).getText().split("chevron_right");
			list.add(menuItem[0].trim());
			list.add(toolbox);
			list.add(dashboard);
		}
		System.out.println(list);
		Assert.assertTrue(list.contains("Dashboard"));
			Assert.assertTrue(list.contains("E-Rate"));
			Assert.assertTrue(list.contains("Contracts"));
			Assert.assertTrue(list.contains("Cancellations"));
			Assert.assertTrue(list.contains("Report"));
			Assert.assertTrue(list.contains("My Settings"));
			Assert.assertTrue(list.contains("Toolbox"));
			Assert.assertTrue(list.contains("Help"));
			
			verticalMenu.navigatetoLeftMainMenu("Help");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Web Training Manual for E-Contracting"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Web Traning Manual for Remittance"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Web Training Manual for SPP"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Web Training Manual for ACH-Remit"));
			
			verticalMenu.navigatetoLeftMainMenu("Contracts");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Contract Search"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Remit Contracts to AUL"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Edit Remit AUL VSC/LW"));
			
			verticalMenu.navigatetoLeftMainMenu("Cancellations");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Cancellation Quote"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Cancellation History"));
			
			verticalMenu.navigatetoLeftMainMenu("My Settings");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Manage My Profile"));
			
			verticalMenu.navigatetoLeftMainMenu("E-Rate");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
			
			verticalMenu.navigatetoLeftMainMenu("Report");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Unpaid Contracts"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Activations"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Cancellations"));
			Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Claims History"));
			Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Actuarials"));
			Assert.assertTrue(getLaterMenuSubItems().get(6).getText().contains("Early Claims"));
	}
	
	@Test(priority = 7)
	public void verifyMenuOptionsForDealerGrp_30265_30287_30292_30298_30307_30318() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		String toolbox = getLateralMenuItems2().get(1).getText();
		String dashboard = getLateralMenuItems2().get(0).getText();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<getLateralMenuItems1().size(); i++) {
			String[] menuItem = getLateralMenuItems1().get(i).getText().split("chevron_right");
			list.add(menuItem[0].trim());
			list.add(toolbox);
			list.add(dashboard);
		}
		System.out.println(list);
		Assert.assertTrue(list.contains("Dashboard"));
			Assert.assertTrue(list.contains("E-Rate"));
			Assert.assertTrue(list.contains("Contracts"));
			Assert.assertTrue(list.contains("Cancellations"));
			Assert.assertTrue(list.contains("Report"));
			Assert.assertTrue(list.contains("My Settings"));
			Assert.assertTrue(list.contains("Toolbox"));
			Assert.assertTrue(list.contains("Help"));
			
			verticalMenu.navigatetoLeftMainMenu("Contracts");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Contract Search"));
			
			verticalMenu.navigatetoLeftMainMenu("Cancellations");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Cancellation Quote"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Cancellation History"));
			
			verticalMenu.navigatetoLeftMainMenu("Report");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Unpaid Contracts"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Activations"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Cancellations"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("My Account Statements"));
			Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Claims History"));
			Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Actuarials"));
			Assert.assertTrue(getLaterMenuSubItems().get(6).getText().contains("Early Claims"));
			
			verticalMenu.navigatetoLeftMainMenu("Help");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Web Training Manual for E-Contracting"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Web Traning Manual for Remittance"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Web Training Manual for SPP"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Web Training Manual for ACH-Remit"));
			
			verticalMenu.navigatetoLeftMainMenu("E-Rate");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
	}
	
	@Test(priority = 8)
	public void verifyMenuOptionsForDealerGrpEmp_30288_30294_30299_30308_30319() throws InterruptedException {
		login.login(prop.getProperty("dealergrpempAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		String toolbox = getLateralMenuItems2().get(1).getText();
		String dashboard = getLateralMenuItems2().get(0).getText();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<getLateralMenuItems1().size(); i++) {
			String[] menuItem = getLateralMenuItems1().get(i).getText().split("chevron_right");
			list.add(menuItem[0].trim());
			list.add(toolbox);
			list.add(dashboard);
		}
		
		verticalMenu.navigatetoLeftMainMenu("Contracts");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Contract Search"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Remit Contracts to AUL"));
		Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Remit Classic GAP/Ancillary"));
		Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Remit VAS Ancillary"));
		
		verticalMenu.navigatetoLeftMainMenu("Cancellations");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Cancellation Quote"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Cancellation History"));
		
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Unpaid Contracts"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Activations"));
		Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Cancellations"));
		Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("My Account Statements"));
		Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Claims History"));
		Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Actuarials"));
		Assert.assertTrue(getLaterMenuSubItems().get(6).getText().contains("Early Claims"));
		
		verticalMenu.navigatetoLeftMainMenu("Help");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Web Training Manual for E-Contracting"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Web Traning Manual for Remittance"));
		Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Web Training Manual for SPP"));
		Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Web Training Manual for ACH-Remit"));
		
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
	}

	@Test(priority = 9)
	public void verifyImpersonationPage_30782() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		Assert.assertTrue(impersonate.getImpersonatedPageRoledID().equals("28771"),"Impersonated Successfully");
	}

	@Test(priority = 10)
	public void verifyNewUserPopup_30783() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Dealer", "28771");
		getNewuserBtn().click();
		Thread.sleep(1000);
		Assert.assertTrue(getNewuserPopupHeader().isDisplayed());
		Thread.sleep(1000);
		getNewUserBtnClose().click();
	}
	

	
	@Test(priority = 11)
	public void verifyNewExceptionBtnActivated_30784() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigateToMileageAndAgeException();
		impersonate.getUsers("Dealer", "28771");
		Assert.assertTrue(getNewuserBtn().isEnabled());
		
	}
	
	@Test(priority = 12)
	public void verifyDashboardReportsforDealer_32243() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMainMenu("Report");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Unpaid Contracts"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Activations"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Cancellations"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("My Account Statements"));
			Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Claims History"));
			Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Actuarials"));
			Assert.assertTrue(getLaterMenuSubItems().get(6).getText().contains("Early Claims"));
		verticalMenu.navigatetoLeftMenu("Dashboard");
		utils.scrollDown();
		Assert.assertTrue(getDashboardPageReports("Unpaid Contracts").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Activations").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Cancellations").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("My Account Statements").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Actuarials").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Early Claims").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Contract Search").isDisplayed());
	}

	
	@Test(priority = 13)
	public void verifyDashboardReportsforAgent_32244() throws InterruptedException {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("My Commissions"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Unpaid Contracts"));
		Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Activations"));
		Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Cancellations"));
		Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("My Account Statements"));
		Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Claims History"));
		Assert.assertTrue(getLaterMenuSubItems().get(6).getText().contains("Actuarials"));
		Assert.assertTrue(getLaterMenuSubItems().get(7).getText().contains("Early Claims"));
		verticalMenu.navigatetoLeftMenu("Dashboard");
		utils.scrollDown();
		//Assert.assertTrue(getDashboardPageReports("My Commissions").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Unpaid Contracts").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Activations").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Cancellations").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("My Account Statements").isDisplayed());
		//Assert.assertTrue(getDashboardPageReports("Actuarials").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Early Claims").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Contract Search").isDisplayed());
	}

	@Test(priority = 14)
	public void verifyDashboardReportsforLender_32245() throws InterruptedException {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Unpaid Contracts"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Activations"));
		Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Cancellations"));
		Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("My Account Statements"));
		Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Claims History"));
		Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Actuarials"));
		Assert.assertTrue(getLaterMenuSubItems().get(6).getText().contains("Early Claims"));
		verticalMenu.navigatetoLeftMenu("Dashboard");
		utils.scrollDown();
		Assert.assertTrue(getDashboardPageReports("Unpaid Contracts").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Activations").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Cancellations").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("My Account Statements").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Actuarials").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Early Claims").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Contract Search").isDisplayed());
	}

	@Test(priority = 15)
	public void verifyDashboardReportsforSubAgent_32253() throws InterruptedException {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("My Commissions"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Unpaid Contracts"));
		Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Activations"));
		Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Cancellations"));
		Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("My Account Statements"));
		Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Claims History"));
		Assert.assertTrue(getLaterMenuSubItems().get(6).getText().contains("Actuarials"));
		Assert.assertTrue(getLaterMenuSubItems().get(7).getText().contains("Early Claims"));
		verticalMenu.navigatetoLeftMenu("Dashboard");
		utils.scrollDown();
		//Assert.assertTrue(getDashboardPageReports("My Commissions").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Unpaid Contracts").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Activations").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Cancellations").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("My Account Statements").isDisplayed());
	//	Assert.assertTrue(getDashboardPageReports("Actuarials").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Early Claims").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Contract Search").isDisplayed());
	}
	
	@Test(priority = 16)
	public void verifyDashboardReportsforDealerEmp_32254() throws InterruptedException {
		login.login(prop.getProperty("dealerempAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Unpaid Contracts"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Activations"));
		Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Cancellations"));
		Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("My Account Statements"));
		Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Claims History"));
		Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Actuarials"));
		Assert.assertTrue(getLaterMenuSubItems().get(6).getText().contains("Early Claims"));
		verticalMenu.navigatetoLeftMenu("Dashboard");
		utils.scrollDown();
		Assert.assertTrue(getDashboardPageReports("Unpaid Contracts").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Activations").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Cancellations").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("My Account Statements").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Actuarials").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Early Claims").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Contract Search").isDisplayed());
	}
	
	@Test(priority = 17)
	public void verifyDashboardReportsforLenderEmp_32255() throws InterruptedException {
		login.login(prop.getProperty("lenderempAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Unpaid Contracts"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Activations"));
		Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Cancellations"));
		Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("My Account Statements"));
		Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Claims History"));
		Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Actuarials"));
		Assert.assertTrue(getLaterMenuSubItems().get(6).getText().contains("Early Claims"));
		verticalMenu.navigatetoLeftMenu("Dashboard");
		utils.scrollDown();
		Assert.assertTrue(getDashboardPageReports("Unpaid Contracts").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Activations").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Cancellations").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("My Account Statements").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Actuarials").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Early Claims").isDisplayed());
		Assert.assertTrue(getDashboardPageReports("Contract Search").isDisplayed());
	}

	
	 @AfterMethod(alwaysRun=true)
	    public void close() throws InterruptedException {
	        login.logout();
	    }

}
