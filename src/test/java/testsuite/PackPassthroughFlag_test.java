package testsuite;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.XmlDataReader;
import utils.baseClass;
import utils.utilityClass;


/*36298 */
public class PackPassthroughFlag_test extends baseClass{
	
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();
//	ManageUsersPage_test manageuser = new ManageUsersPage_test();
	XmlDataReader UtilsDataReader = new XmlDataReader("UtilsData");

	@BeforeMethod(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}

	
	@Test(priority = 1)
	public void verifyShowPackPassThroughNotShownInForAgentPackImpersonatepage_36801() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("Agent Pack", "393");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 12);
		Assert.assertFalse(impersonate.getAllHeaders().get(5).startsWith("Show"));
	}
	
	@Test(priority = 2)
	public void verifyShowPackPassThroughNotShownForDealerPassthroughImpersonatepage_36802() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("Dealer Pass Through", "28771");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 12);
		Assert.assertFalse(impersonate.getAllHeaders().get(5).startsWith("Show"));
	}
	
	@Test(priority = 3,enabled = false)
	public void verifyShowPackPassThroughNotShownForLenderPassthroughImpersonatepage_36803() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("Lender Pass Through", "3641");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 12);
		Assert.assertFalse(impersonate.getAllHeaders().get(5).startsWith("Show"));
	}
	
	@Test(priority = 4)
	public void verifyShowPackPassThroughNotShownForIntegrationPartnerPackImpersonatepage_36804() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("Integration Partner Pack", "1995");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 12);
		Assert.assertFalse(impersonate.getAllHeaders().get(5).startsWith("Show"));
	}
	
	@Test(priority = 5)
	public void verifyShowPackPassThroughNotShownForSubAgentImpersonatepage_36791() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("SubAgent", "393");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 12);
		Assert.assertFalse(impersonate.getAllHeaders().get(5).startsWith("Show"));
	}
	
	@Test(priority = 6)
	public void verifyShowPackPassThroughNotShownForLenderEmpImpersonatepage_36798() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("LenderEmp", "3641");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 12);
		Assert.assertFalse(impersonate.getAllHeaders().get(5).startsWith("Show"));
	}
	
	@Test(priority = 7)
	public void verifyShowPackPassThroughNotShownForDealerGrpImpersonatepage_36799() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("DealerGroup", "47421");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 12);
		Assert.assertFalse(impersonate.getAllHeaders().get(5).startsWith("Show"));
	}
	
	@Test(priority = 8)
	public void verifyShowPackPassThroughNotShownForDealerGrpEmpImpersonatepage_36800() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("DealerGrpEmp", "47421");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 12);
		Assert.assertFalse(impersonate.getAllHeaders().get(5).startsWith("Show"));
	}
	
	@Test(priority = 9)
	public void verifyShowPackPassThroughNotShownForDealerEmpImpersonatepage_36797() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("DealerEmp", "28771");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 12);
		Assert.assertFalse(impersonate.getAllHeaders().get(5).startsWith("Show"));
	}
	
	@Test(priority = 10)
	public void verifyShowPackPassThroughShownForAgentImpersonatepage_36783() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("Agent", "110");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 13);
		Assert.assertTrue(impersonate.getAllHeaders().get(5).startsWith("Show"));
	}
	
	@Test(priority = 11)
	public void verifyShowPackPassThroughShownForDealerImpersonatepage_36784() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("Dealer", "28771");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 13);
		Assert.assertTrue(impersonate.getAllHeaders().get(5).startsWith("Show"));
	}
	
	@Test(priority = 12)
	public void verifyShowPackPassThroughShownForLenderImpersonatepage_36785() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsersForAgentPackDealerPasstroughLenderPassthrough("Lender", "3641");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 13);
		Assert.assertTrue(impersonate.getAllHeaders().get(5).startsWith("Show"));
	}
	
//	@Test(priority = 13)
//	public void verifyShowPackPassThroughNotShownForAgentInManageDealerpage_37064() throws Exception {
//		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
//		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
//		manageuser.selectDealerInmanageUserPageWithOutgetUsers(UtilsDataReader.getXMLData("dealer3"));
//		Assert.assertTrue(impersonate.getAllHeaders().size() == 13);
//		Assert.assertFalse(impersonate.getAllHeaders().get(5).startsWith("Show"));
//	}
//	
//	@Test(priority = 14)
//	public void verifyShowPackPassThroughNotShownForSubAgentInManageDealerpage_37065() throws Exception {
//		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
//		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
//		manageuser.selectDealerInmanageUserPageWithOutgetUsers(UtilsDataReader.getXMLData("dealer3"));
//		Assert.assertTrue(impersonate.getAllHeaders().size() == 13);
//		Assert.assertFalse(impersonate.getAllHeaders().get(5).startsWith("Show"));
//	}
	
	@Test(priority = 15)
	public void verifyShowPackPassThroughNotShownForAgentInManageUserpage_37066() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Agency Settings", "Manage Users");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 11);
		Assert.assertFalse(impersonate.getAllHeaders().get(5).startsWith("Show"));
	}
	
	@Test(priority = 16)
	public void verifyShowPackPassThroughNotShownForDealerInIssueNewUserRegPage_37067() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waitUntilElementisInVisible(utils.getfield("h3", "Issue New User Registration"));
		Assert.assertTrue(impersonate.getAllHeaders().size() == 5);
		Assert.assertFalse(impersonate.getAllHeaders().contains("Show"));
	}
	
	@Test(priority = 17)
	public void verifyShowPackPassThroughNotShownForDealerGrpInIssueNewUserRegPage_37068() throws Exception {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		utils.getfield("h5", "Issue New User Registration").click();
		Assert.assertTrue(impersonate.getAllHeaders().size() == 7);
		Assert.assertFalse(impersonate.getAllHeaders().contains("Show"));
	}
	
	@Test(priority = 18)
	public void verifyShowPackPassThroughNotShownForLenderInIssueNewUserRegPage_37069() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Issue New User Registration");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 7);
		Assert.assertFalse(impersonate.getAllHeaders().get(5).startsWith("Show"));
	}
	
	@Test(priority = 19)
	public void verifyShowPackPassThroughNotShownForLenderInIssueNewUserRegPageManageUser_37070_37071() throws Exception {
		login.login(prop.getProperty("lenderempAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Issue New User Registration");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 7);
		Assert.assertFalse(impersonate.getAllHeaders().contains("Show"));
		verticalMenu.navigatetoLeftMenu("Lender Settings", "Manage Users");
		Assert.assertTrue(impersonate.getAllHeaders().size() == 7);
		Assert.assertFalse(impersonate.getAllHeaders().contains("Show"));
	}
	
	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		try {
			login.logout();
		} catch (Exception e) {
		}
	}
}
