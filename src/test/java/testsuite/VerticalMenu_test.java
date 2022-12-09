package testsuite;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.LateralMenuAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import pageObjects.impersonatepo;
import utils.utilityClass;

public class VerticalMenu_test extends LateralMenuAction {
	
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	impersonatepo io = new impersonatepo ();

	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}
	
	@Test(priority = 1)
	public void verifyLateralMenuOptionsForAgent_30209_30214_30238() throws InterruptedException {
		login.login(prop.getProperty("agentusername"), prop.getProperty("password"));
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
			
	}
	
	@Test(priority = 2)
	public void verifyLateralMenuOptionsForDealer_30210_30315_30216_30237_30240_30243() throws InterruptedException {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
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
			
			verticalMenu.navigatetoLeftMenu("My Settings", "Preferences");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Manage My Profile"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Manage My Employees"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Issue New User Registration"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Manage My Pricing Preferences"));
			Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Manage VSC - GAP Preferences"));
			Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Manage My Dealer Packs"));
	}
	
	@Test(priority = 3)
	public void verifyLateralMenuOptionsForLender_30212_30217_30239_30241_30244() throws InterruptedException {
		login.login(prop.getProperty("lenderusername"), prop.getProperty("password"));
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
			
			verticalMenu.navigatetoLeftMenu("My Settings", "Preferences");
			Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Manage My Profile"));
			Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Manage My Lender Employees"));
			Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Issue New User Registration"));
			Assert.assertTrue(getLaterMenuSubItems().get(3).getText().contains("Manage My Pricing Preferences"));
			Assert.assertTrue(getLaterMenuSubItems().get(4).getText().contains("Manage VSC - GAP Preferences"));
			Assert.assertTrue(getLaterMenuSubItems().get(5).getText().contains("Manage My Lender Packs"));
	}
	
	
	//bug for sgrace employee rest all fine
	@Test(priority = 4)
	public void verifyMenuOptionsForDealerEmp_30213() throws InterruptedException {
		login.login(prop.getProperty("dealerempusername"), prop.getProperty("dealeremppassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Thread.sleep(1000);
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
	}
	
	
	
	 @AfterMethod(alwaysRun=true)
	    public void close() throws InterruptedException {
	        login.logout();
	    }

}
