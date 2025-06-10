package testsuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.AssigningLenderPassthroughToAgentCorpAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;


/* PBI 39021 */
/*implemented by Divyasree*/
public class AssignLenderAndLenderPackAccountsToAgentCorpAgentGroupUsers_test
		extends AssigningLenderPassthroughToAgentCorpAction {

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	impersonateAction impersonate = new impersonateAction();
	utilityClass utils = new utilityClass();
	cancellationQuotes_test quotePage = new cancellationQuotes_test();
	cancellationHistory_test historyPage = new cancellationHistory_test();
	singleContractAction contract = new singleContractAction();

	@BeforeClass(alwaysRun = true)
	public void login() throws InterruptedException {
//		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}

//	@Test(priority = 1)
//	public void verifyAssigningLenderToAgentGroupUser_39105_39125() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoimpersonate();
//		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("AgentGroup", "110");
//		getManageAgencyBtn(1).click();
//		Thread.sleep(2000);
//		removeAssignedLenders();
//		selectRoleID("Coastal Credit LLC");
//		getAssignLenders();
//	}
//
//	@Test(priority = 2)
//	public void verifyAssigningLenderPassthroughToAgentGroupUser_39104_39123() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoimpersonate();
//		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("AgentGroup", "110");
//		getManageAgencyBtn(1).click();
//		Thread.sleep(2000);
//		removeAssignedLenders();
//		selectRoleID("Carvant Financial");
//		getAssignLenders();
//	}
//
//	@Test(priority = 3)
//	public void verifyAssigningLenderToAgentCorp_39103_39124() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoimpersonate();
//		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("AgentCorp", "110");
//		getManageAgencyBtn(1).click();
//		Thread.sleep(2000);
//		removeAssignedLenders();
//		selectRoleID("Coastal Credit LLC");
//		getAssignLenders();
//	}
//
//	@Test(priority = 4)
//	public void verifyAssigningLenderPassthroughToAgentCorpUser_39106_39126() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoimpersonate();
//		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("AgentCorp", "110");
//		getManageAgencyBtn(1).click();
//		Thread.sleep(2000);
//		removeAssignedLenders();
//		selectRoleID("Carvant Financial");
//		getAssignLenders();
//	}
//
//	@Test(priority = 5)
//	public void verifyAdminCanAddMoreThanOneLenderAccountToAgentCorpUser_39110_39120() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoimpersonate();
//		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("AgentCorp", "110");
//		getManageAgencyBtn(1).click();
//		Thread.sleep(2000);
//		removeAssignedLenders();
//		getAssignMoreThanOneLender("Coastal Credit LLC", "Community Finance");
//		removeAssignedLenders();
//	}
//
//	@Test(priority = 6)
//	public void verifyAdminCanAddMoreThanOneLenderPassthroughAccountToAgentCorpUser_39111_39143() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoimpersonate();
//		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("AgentCorp", "110");
//		getManageAgencyBtn(1).click();
//		Thread.sleep(2000);
//		removeAssignedLenders();
//		getAssignMoreThanOneLender("Carvant Financial", "United Finance - Spiff Account");
//		removeAssignedLenders();
//	}
//
//	@Test(priority = 7)
//	public void verifyAdminCanAddMoreThanOneLenderAccountToAgentGroupUser_39112_39119() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoimpersonate();
//		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("AgentGroup", "110");
//		getManageAgencyBtn(1).click();
//		Thread.sleep(2000);
//		removeAssignedLenders();
//		getAssignMoreThanOneLender("Coastal Credit LLC", "Community Finance");
//		removeAssignedLenders();
//	}
//
//	@Test(priority = 8)
//	public void verifyAdminCanAddMoreThanOneLenderPassthroughAccountToAgentGroupUser_39113_39118() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoimpersonate();
//		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("AgentGroup", "110");
//		getManageAgencyBtn(1).click();
//		Thread.sleep(2000);
//		removeAssignedLenders();
//		getAssignMoreThanOneLender("Carvant Financial", "United Finance - Spiff Account");
//		removeAssignedLenders();
//	}

	// To do
//	@Test(priority = 9)
//	public void verify_39115_39144() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoimpersonate();
//	}
//	
//	@Test(priority = 10)
//	public void verify_39114_39145() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoimpersonate();
//	}

	@Test(priority = 11)
	public void verifyAssignmentModelIsOpenedWhenUserClickedOnAgentCorpUser_39146() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("AgentCorp", "110");
		getManageAgencyBtn(1).click();
		Thread.sleep(2000);
		Assert.assertTrue(utils.element("xpath", removeLink).isDisplayed());
		Assert.assertTrue(utils.element("xpath", saveBtn).isDisplayed());
		Assert.assertTrue(utils.element("xpath", cancelBtn).isDisplayed());
		Assert.assertTrue(utils.element("xpath", roleId).isDisplayed());
		if (utils.getfield("mat-icon", "close").isDisplayed()) {
			utils.getfield("mat-icon", "close").click();
		}
	}

	@Test(priority = 12)
	public void verifyAssignmentModelIsOpenedWhenUserClickedOnAgentGroupUser_39147() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("AgentGroup", "110");
		getManageAgencyBtn(1).click();
		Thread.sleep(2000);
		Assert.assertTrue(utils.element("xpath", removeLink).isDisplayed());
		Assert.assertTrue(utils.element("xpath", saveBtn).isDisplayed());
		Assert.assertTrue(utils.element("xpath", cancelBtn).isDisplayed());
		Assert.assertTrue(utils.element("xpath", roleId).isDisplayed());
		if (utils.getfield("mat-icon", "close").isDisplayed()) {
			utils.getfield("mat-icon", "close").click();
		}
	}

	@Test(priority = 13)
	public void verifyAgentCorpLenderAccountImpersonateAgency_39161() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("AgentCorp", "110");
		getManageAgencyBtn(1).click();
		Thread.sleep(2000);
		removeAssignedLenders();
		String lender="Vermont State Employee Credit Union";
		selectRoleID(lender);
		getAssignLenders();
		utils.clickfield("xpath", impersonate.tableFirstRow);
		Thread.sleep(5000);
		verticalMenu.navigatetoLeftMenu("Agency Settings", "Impersonate Agency");
		getSelectLenderLenderPassthroughTogenerateContract(lender);
		Assert.assertTrue(utils.getfield("span", "AgentCorp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Lender").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
	}
	
	@Test(priority = 14)
	public void verifyAgentCorpLenderPassThroughAccountImpersonateAgency_39162() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("AgentCorp", "110");
		getManageAgencyBtn(1).click();
		Thread.sleep(2000);
		removeAssignedLenders();
		String lenderPassthrough="Eta Consulting Llc";
		selectRoleID(lenderPassthrough);
		getAssignLenders();
		utils.clickfield("xpath", impersonate.tableFirstRow);
		Thread.sleep(5000);
		verticalMenu.navigatetoLeftMenu("Agency Settings", "Impersonate Agency");
		getSelectLenderLenderPassthroughTogenerateContract(lenderPassthrough);
		Assert.assertTrue(utils.getfield("span", "AgentCorp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Lender Pass Through").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
	}

	@Test(priority = 15)
	public void verifyAgentGroupLenderAccountImpersonateAgency_39163() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("AgentGroup", "110");
		getManageAgencyBtn(1).click();
		Thread.sleep(2000);
		removeAssignedLenders();
		String lender="Vermont State Employee Credit Union";
		selectRoleID(lender);
		getAssignLenders();
		utils.clickfield("xpath", impersonate.tableFirstRow);
		Thread.sleep(5000);
		verticalMenu.navigatetoLeftMenu("Agency Settings", "Impersonate Agency");
		getSelectLenderLenderPassthroughTogenerateContract(lender);
		Assert.assertTrue(utils.getfield("span", "AgentGroup").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Lender").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
	}
	
	@Test(priority = 16)
	public void verifyAgentGroupLenderPassThroughAccountImpersonateAgency_39164() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("AgentGroup", "110");
		getManageAgencyBtn(1).click();
		Thread.sleep(2000);
		removeAssignedLenders();
		String lenderPassthrough="Eta Consulting Llc";
		selectRoleID(lenderPassthrough);
		getAssignLenders();
		utils.clickfield("xpath", impersonate.tableFirstRow);
		Thread.sleep(5000);
		verticalMenu.navigatetoLeftMenu("Agency Settings", "Impersonate Agency");
		getSelectLenderLenderPassthroughTogenerateContract(lenderPassthrough);
		Assert.assertTrue(utils.getfield("span", "AgentGroup").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Lender Pass Through").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
	}
	
	//To do
	//add lender and lender passthrough accounts in xml/properties file
	//crosscheck lender and lendrPT accounts one more time in ocean also check impersonation page
	//check whethr the bug 39528 is fixed and then do pririty 9,10
	
	
	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		try {
			login.logout();
		} catch (Exception e) {
//			if (utils.getfield("mat-icon", "close").isDisplayed()) {
//				utils.getfield("mat-icon", "close").click();
//			}
//			login.logout();
		}
	}

}
