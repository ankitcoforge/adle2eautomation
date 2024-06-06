package testsuite;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.LateralMenuAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.baseClass;
import utils.utilityClass;

/* PBI 34990 */
public class DealerGrpEmpMenu_test extends baseClass {
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	LateralMenuAction menu = new LateralMenuAction();
	utilityClass utils = new utilityClass();
	impersonateAction io = new impersonateAction();
	ManageMyDealerGrpEmployee_test dealerGrpEmp = new ManageMyDealerGrpEmployee_test();

	@BeforeClass(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}
	

	@Test(priority = 0)
	public void precond_assignPermissionsFordealerGrpEmp() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		Assert.assertTrue(utils.getfield("b", "Welcome to your Protective ADL Portal!").isDisplayed());
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
		dealerGrpEmp.selectUser(prop.getProperty("dealergrpempAutomation"));
		utils.scrollDownUsingJSE(200);
		utils.wait(1000);
		WebElement selectAllCheckBoxstat = utils.element("xpath", dealerGrpEmp.selectAllCheckBoxstatus);
		if (selectAllCheckBoxstat.getAttribute("aria-checked").equals("false")) {
			utils.element("xpath", dealerGrpEmp.selectAllCheckBox).click();
		}
		else {
			utils.element("xpath", dealerGrpEmp.selectAllCheckBox).click();
			utils.element("xpath", dealerGrpEmp.selectAllCheckBox).click();
		}
		Assert.assertTrue(selectAllCheckBoxstat.isSelected());
		utils.getfield("span", "SAVE").click();
		Thread.sleep(2000);
		System.out.println("x1--"+dealerGrpEmp.permissionsSelected());
		System.out.println("x2--"+dealerGrpEmp.AllPermissions());
		Assert.assertTrue(dealerGrpEmp.permissionsSelected().containsAll(dealerGrpEmp.AllPermissions()));
	}

	@Test(priority = 1)
	public void verifyContractsOptionInMenuForDealerGroupEmpUser_35794_35044_35046_36085_35045_36086()
			throws InterruptedException {
		login.login(prop.getProperty("dealergrpempAutomation"), prop.getProperty("password"));
		Assert.assertTrue(utils.getfield("b", "Welcome to your Protective ADL Portal!").isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("Contracts");
		Thread.sleep(10000);
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < verticalMenu.getLaterMenuSubItems().size(); i++) {
			String subItem = verticalMenu.getLaterMenuSubItems().get(i).getText();
			list.add(subItem.trim());
		}
		Assert.assertTrue(list.contains("Contract Search"));
		Assert.assertTrue(list.contains("Remit Contracts to AUL"));
		Assert.assertTrue(list.contains("Edit Remit AUL VSC/LW"));
		Assert.assertTrue(list.contains("Remit Classic GAP/Ancillary"));
		Assert.assertTrue(list.contains("Remit VAS Ancillary"));

		verticalMenu.navigatetoLeftMenu("Contract Search");
		Assert.assertTrue(utils.getTitle("Contract Search").isDisplayed());
		verticalMenu.navigatetoLeftMenu("Remit Contracts to AUL");
		Assert.assertTrue(utils.getTitle("Remit Contracts to AUL").isDisplayed());
		verticalMenu.navigatetoLeftMenu("Edit Remit AUL VSC/LW");
		Assert.assertTrue(utils.getTitle("Edit Remit AUL VSC/LW").isDisplayed());
//The below steps are on hold
//			verticalMenu.navigatetoLeftMenu("Remit Classic GAP/Ancillary");
//			Assert.assertTrue(utils.getTitle("Remit Classic GAP/Ancillary").isDisplayed());
//			verticalMenu.navigatetoLeftMenu("Remit VAS Ancillary");
//			Assert.assertTrue(utils.getTitle("Remit VAS Ancillary").isDisplayed());

	}

	@Test(priority = 2)
	public void verifyAdminImpDealerGrpEmpCannotViewEditRemitOptionForNonACHWhenPermissionNotGiven_36020()
			throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertTrue(utils.getfield("b", "Welcome to your Protective ADL Portal!").isDisplayed());
		verticalMenu.navigatetoimpersonate();
		io.impersonateUserByRemovingPermissions("DealerGrpEmp", "47421");
		verticalMenu.navigatetoLeftMainMenu("Contracts");
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < verticalMenu.getLaterMenuSubItems().size(); i++) {
			String subItem = verticalMenu.getLaterMenuSubItems().get(i).getText();
			list.add(subItem.trim());
		}
		Assert.assertTrue(list.size() == 0);

	}

	@Test(priority = 3)
	public void verifyAdminCanViewEditRemitOptionForNonACHWhenPermissionGiven_36021_35038()
			throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertTrue(utils.getfield("b", "Welcome to your Protective ADL Portal!").isDisplayed());
		verticalMenu.navigatetoimpersonate();
		io.impersonateUserByGivingPermissions("DealerGrpEmp", "47421");
		verticalMenu.navigatetoLeftMainMenu("Contracts");
		Thread.sleep(10000);
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < verticalMenu.getLaterMenuSubItems().size(); i++) {
			String subItem = verticalMenu.getLaterMenuSubItems().get(i).getText();
			list.add(subItem.trim());
		}
		Assert.assertTrue(list.contains("Edit Remit AUL VSC/LW"));
		Assert.assertTrue(list.contains("Contract Search"));
		Assert.assertTrue(list.contains("Remit Contracts to AUL"));
		Assert.assertTrue(list.contains("Remit Classic GAP/Ancillary"));
		Assert.assertTrue(list.contains("Remit VAS Ancillary"));
	}

	@Test(priority = 4)
	public void verifyAdminImpersonatedDealerGrpEmpCanAccessLateralMenuOptions_35793_35036()
			throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertTrue(utils.getfield("b", "Welcome to your Protective ADL Portal!").isDisplayed());
		verticalMenu.navigatetoimpersonate();
		io.impersonateUserByGivingPermissions("DealerGrpEmp", "47421");
		String toolbox = menu.getLateralMenuItems2().get(1).getText();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < menu.getLateralMenuItems1().size(); i++) {
			String[] menuItem = menu.getLateralMenuItems1().get(i).getText().split("chevron_right");
			list.add(menuItem[0].trim());
			list.add(toolbox);
		}
		System.out.println(list);
		Assert.assertTrue(list.contains("E-Rate"));
		Assert.assertTrue(list.contains("Contracts"));
		Assert.assertTrue(list.contains("Report"));
		Assert.assertTrue(list.contains("Cancellations"));
		Assert.assertTrue(list.contains("My Settings"));
		Assert.assertTrue(list.contains("Toolbox"));
		Assert.assertTrue(list.contains("Help"));
	}

	@Test(priority = 5)
	public void verifyDetailedMenuOptionsForDealerGrpEmpRole_35037_35042_35043_35041_35172_35055_35056_35057_35040_35049_35054_35050_35052_35053_35051_35048_35795_35039_35058_35047()
			throws InterruptedException {
		login.login(prop.getProperty("dealergrpempAutomation"), prop.getProperty("password"));
		Assert.assertTrue(utils.getfield("b", "Welcome to your Protective ADL Portal!").isDisplayed());
		Assert.assertTrue(menu.getLateralMenu().isDisplayed());
		// E-rate
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertTrue(menu.getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(1).getText().contains("Quote History"));
		verticalMenu.navigatetoLeftMenu("Rate/Contract");
		Thread.sleep(2000);
		Assert.assertTrue(menu.getRateContractTitle().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("/rate/rate-contract"));
		verticalMenu.navigatetoLeftMenu("Quote History");
		Thread.sleep(2000);
		Assert.assertTrue(menu.getQuoteHistoryTitle().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("/rate/quote-history"));
		// Cancellations
		verticalMenu.navigatetoLeftMainMenu("Cancellations");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("Cancellation Quote"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(1).getText().contains("Cancellation History"));
		verticalMenu.navigatetoLeftMenu("Cancellation Quote");
		Thread.sleep(2000);
		Assert.assertTrue(menu.getCancellationQuoteTitle().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("/cancellations/cancel-quote"));
		verticalMenu.navigatetoLeftMenu("Cancellation History");
		Thread.sleep(2000);
		Assert.assertTrue(menu.getCancellationHistoryTitle().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("/cancellations/cancellation-history"));

		// My Settings
		verticalMenu.navigatetoLeftMainMenu("My Settings");
		Assert.assertTrue(menu.getLaterMenuSubItems().get(0).getText().contains("Manage My Profile"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(1).getText().contains("Manage My Pricing Preferences"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(2).getText().contains("Manage VSC - GAP Preferences"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(3).getText().contains("Manage My Dealer Packs"));

		verticalMenu.navigatetoLeftMenu("Manage My Profile");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Manage My Profile"));
		Assert.assertTrue(utils.getTitle("Manage My Profile").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Manage My Pricing Preferences");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Manage My Pricing Preferences"));
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Manage VSC - GAP Preferences");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Manage VSC - GAP Preferences"));
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Manage My Dealer Packs");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Manage My Dealer Packs"));
		Assert.assertTrue(utils.getTitle("Manage My Dealer Packs").isDisplayed());
		// Report
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(menu.getLaterMenuSubItems().get(0).getText().contains("Unpaid Contracts"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(1).getText().contains("Activations"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(2).getText().contains("Cancellations"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(3).getText().contains("My Account Statements"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(4).getText().contains("Claims History"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(5).getText().contains("Actuarials"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(6).getText().contains("Early Claims"));

		verticalMenu.navigatetoLeftMenu("Unpaid Contracts");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Unpaid Contracts"));
		Assert.assertTrue(utils.getTitle("Unpaid Contracts").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Activations");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Activations"));
		Assert.assertTrue(utils.getTitle("Activations").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Cancellations");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Cancellations"));
		Assert.assertTrue(utils.getTitle("Cancellations").isDisplayed());

		verticalMenu.navigatetoLeftMenu("My Account Statements");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("My Account Statements"));
		Assert.assertTrue(utils.getTitle("My Account Statements").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Claims History");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Claims History"));
		Assert.assertTrue(utils.getTitle("Claims History").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Actuarials");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Actuarials"));
		Assert.assertTrue(utils.getTitle("Actuarials").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Early Claims");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Early Claims"));
		Assert.assertTrue(utils.getTitle("Early Claims").isDisplayed());

	}

	//all the below test case id's are also covered in this testcase
	//_35168_34974_34919_34966_34971_34967_34969_34970_34968_34965_34918_34911
	@Test(priority = 6)
	public void verifyDetailedMenuOptionsForDealerGrpRole_34912_36037_34923_34924_34926_34925_34917_34922_35814_34815_34921_34920_34986_35791_34988_34987_34985_34972_34975_34973() throws InterruptedException  {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		Assert.assertTrue(utils.getfield("b", "Welcome to your Protective ADL Portal!").isDisplayed());
		Assert.assertTrue(menu.getLateralMenu().isDisplayed());
		// E-rate
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertTrue(menu.getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(1).getText().contains("Quote History"));
		verticalMenu.navigatetoLeftMenu("Rate/Contract");
		Thread.sleep(2000);
		Assert.assertTrue(menu.getRateContractTitle().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("/rate/rate-contract"));
		verticalMenu.navigatetoLeftMenu("Quote History");
		Thread.sleep(2000);
		Assert.assertTrue(menu.getQuoteHistoryTitle().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("/rate/quote-history"));

		// Contracts
		verticalMenu.navigatetoLeftMainMenu("Contracts");
		Assert.assertTrue(menu.getLaterMenuSubItems().get(0).getText().contains("Contract Search"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(1).getText().contains("Remit Contracts to AUL"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(2).getText().contains("Edit Remit AUL VSC/LW"));
		verticalMenu.navigatetoLeftMenu("Contract Search");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Contract Search"));
		Assert.assertTrue(utils.getTitle("Contract Search").isDisplayed());
		verticalMenu.navigatetoLeftMenu("Remit Contracts to AUL");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Remit Contracts to AUL"));
		Assert.assertTrue(utils.getTitle("Remit Contracts to AUL").isDisplayed());
		verticalMenu.navigatetoLeftMenu("Edit Remit AUL VSC/LW");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Edit Remit AUL VSC/LW"));
		Assert.assertTrue(utils.getTitle("Edit Remit AUL VSC/LW").isDisplayed());
		Thread.sleep(2000);

		// Cancellations
		verticalMenu.navigatetoLeftMainMenu("Cancellations");
		Assert.assertTrue(menu.getLaterMenuSubItems().get(0).getText().contains("Cancellation Quote"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(1).getText().contains("Cancellation History"));
		verticalMenu.navigatetoLeftMenu("Cancellation Quote");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Cancellation Quote"));
		Assert.assertTrue(utils.getTitle("Cancellation Quote").isDisplayed());
		verticalMenu.navigatetoLeftMenu("Cancellation History");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Cancellation History"));
		Assert.assertTrue(utils.getTitle("Cancellation History").isDisplayed());

		// Report
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(menu.getLaterMenuSubItems().get(0).getText().contains("Unpaid Contracts"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(1).getText().contains("Activations"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(2).getText().contains("Cancellations"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(3).getText().contains("My Account Statements"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(4).getText().contains("Claims History"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(5).getText().contains("Actuarials"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(6).getText().contains("Early Claims"));

		verticalMenu.navigatetoLeftMenu("Unpaid Contracts");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Unpaid Contracts"));
		Assert.assertTrue(utils.getTitle("Unpaid Contracts").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Activations");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Activations"));
		Assert.assertTrue(utils.getTitle("Activations").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Cancellations");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Cancellations"));
		Assert.assertTrue(utils.getTitle("Cancellations").isDisplayed());

		verticalMenu.navigatetoLeftMenu("My Account Statements");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("My Account Statements"));
		Assert.assertTrue(utils.getTitle("My Account Statements").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Claims History");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Claims History"));
		Assert.assertTrue(utils.getTitle("Claims History").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Actuarials");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Actuarials"));
		Assert.assertTrue(utils.getTitle("Actuarials").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Early Claims");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Early Claims"));
		Assert.assertTrue(utils.getTitle("Early Claims").isDisplayed());

		// My Settings
		verticalMenu.navigatetoLeftMainMenu("My Settings");
		Assert.assertTrue(menu.getLaterMenuSubItems().get(0).getText().contains("Manage My Profile"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(1).getText().contains("Manage My Dealer Group Employees"));
		Assert.assertTrue(
				menu.getLaterMenuSubItems().get(2).getText().contains("Assign Dealer to Dealer Group Employee"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(3).getText().contains("Manage My Pricing Preferences"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(4).getText().contains("Manage VSC - GAP Preferences"));
		Assert.assertTrue(menu.getLaterMenuSubItems().get(5).getText().contains("Manage My Dealer Packs"));

		verticalMenu.navigatetoLeftMenu("Manage My Profile");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Manage My Profile"));
		Assert.assertTrue(utils.getTitle("Manage My Profile").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Manage My Dealer Group Employees");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Manage My Dealer Group Employees"));
		Assert.assertTrue(utils.getTitle("Manage My Dealer Group Employees").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Assign Dealer to Dealer Group Employee");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Assign Dealer to Dealer Group Employee"));
		Assert.assertTrue(utils.getTitle("Assign Dealer to Dealer Group Employee").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Manage My Pricing Preferences");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Manage My Pricing Preferences"));
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Manage VSC - GAP Preferences");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Manage VSC - GAP Preferences"));
		Assert.assertTrue(utils.getTitle("Manage VSC - GAP Preferences").isDisplayed());

		verticalMenu.navigatetoLeftMenu("Manage My Dealer Packs");
		utils.waitTillElementIsClickableByWebEle(utils.getTitle("Manage My Dealer Packs"));
		Assert.assertTrue(utils.getTitle("Manage My Dealer Packs").isDisplayed());
	}
	
	// need data for ACH, hence putting ACH tc's on hold
		@Test(priority = 7)
		public void verifyAdminCannotViewEditRemitOptionForACH_35790_35794_36038_35789() throws InterruptedException {
		}
		
		
		
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
