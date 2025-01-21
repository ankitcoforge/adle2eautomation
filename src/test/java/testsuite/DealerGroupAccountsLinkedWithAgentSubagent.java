package testsuite;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.ManageUserPageAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.XmlDataReader;
import utils.baseClass;
import utils.utilityClass;

/* PBI No : 35495*/
/* Total test cases = 14 */
public class DealerGroupAccountsLinkedWithAgentSubagent extends baseClass{
	
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();
	ManageUserPageAction manageuser = new ManageUserPageAction();
	XmlDataReader UtilsDataReader=new XmlDataReader("UtilsData");
	
	@BeforeMethod(alwaysRun=true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}

	@Test(priority = 1)
	public void verifyAdminImpersonatedAgentCanViewDealerGrpAndDealerGrpEmpAccounts_36305_36310() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Agent", "110");
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage("Hansel Auto Group");
	    HashMap<Integer, HashMap<String, String>> gridManageUserPage = manageuser.manageUsersPageGrid();
	    for (int i = 1; i < manageuser.getRows().size(); i++) {
	    Assert.assertTrue(gridManageUserPage.get(i).get("Role Type").equals("DealerGroup") | gridManageUserPage.get(i).get("Role Type").equals("DealerGrpEmp"));
		}
	}
	
	@Test(priority = 2)
	public void verifyAdminImpersonatedSubagentCanViewDealerGrpAndDealerGrpEmpAccounts_36306() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForSubagentLendrEmp("SubAgent", "110");
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealerGrp"));
	    HashMap<Integer, HashMap<String, String>> gridManageUserPage = manageuser.manageUsersPageGrid();
	    for (int i = 1; i < manageuser.getRows().size(); i++) {
	    Assert.assertTrue(gridManageUserPage.get(i).get("Role Type").equals("DealerGroup") | gridManageUserPage.get(i).get("Role Type").equals("DealerGrpEmp"));
		}
	}
	
	@Test(priority = 3)
	public void verifyAgentCanViewDealerGrpAndDealerGrpEmpAccounts_36247_36248() throws InterruptedException {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealerGrp"));
	    HashMap<Integer, HashMap<String, String>> gridManageUserPage = manageuser.manageUsersPageGrid();
	    for (int i = 1; i < manageuser.getRows().size(); i++) {
	    Assert.assertTrue(gridManageUserPage.get(i).get("Role Type").equals("DealerGroup") | gridManageUserPage.get(i).get("Role Type").equals("DealerGrpEmp"));
		}
	}
	
	@Test(priority = 4)
	public void verifySubAgentCanViewDealerGrpAndDealerGrpEmpAccounts_36252_36253() throws InterruptedException {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealerGrp"));
	    HashMap<Integer, HashMap<String, String>> gridManageUserPage = manageuser.manageUsersPageGrid();
	    for (int i = 1; i < manageuser.getRows().size(); i++) {
	    Assert.assertTrue(gridManageUserPage.get(i).get("Role Type").equals("DealerGroup") | gridManageUserPage.get(i).get("Role Type").equals("DealerGrpEmp"));
		}
	}
	
	@Test(priority = 5)
	public void verifyAgentCanViewDealerAccounts_36250_36251() throws InterruptedException {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealer3"));
	    HashMap<Integer, HashMap<String, String>> gridManageUserPage = manageuser.manageUsersPageGrid();
	    for (int i = 1; i < manageuser.getRows().size(); i++) {
	    Assert.assertTrue(gridManageUserPage.get(i).get("Role Type").equals("Dealer") | gridManageUserPage.get(i).get("Role Type").equals("DealerEmp"));
		}
	}
	
	@Test(priority = 6)
	public void verifySubAgentCanViewDealerAccounts_36254_36255() throws InterruptedException {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealer3"));
	    HashMap<Integer, HashMap<String, String>> gridManageUserPage = manageuser.manageUsersPageGrid();
	    for (int i = 1; i < manageuser.getRows().size(); i++) {
	    Assert.assertTrue(gridManageUserPage.get(i).get("Role Type").equals("Dealer") | gridManageUserPage.get(i).get("Role Type").equals("DealerEmp"));
		}
	}
	
	@Test(priority = 7)
	public void verifyAdminImpersonatedAgentGenericCanViewDealerGrpAndDealerGrpEmpAccounts_36302_36309() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUserWith("Agent", "110","Agent");
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealerGrp"));
	    HashMap<Integer, HashMap<String, String>> gridManageUserPage = manageuser.manageUsersPageGrid();
	    for (int i = 1; i < manageuser.getRows().size(); i++) {
	    Assert.assertTrue(gridManageUserPage.get(i).get("Role Type").equals("DealerGroup") | gridManageUserPage.get(i).get("Role Type").equals("DealerGrpEmp"));
		}
	}

	
	@Test(priority = 8)
	public void verifyAdminImpersonatedSubAgentGenericCanViewDealerGrpAndDealerGrpEmpAccounts_36303() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUserWith("SubAgent", "110","SubAgent");
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealerGrp"));
	    HashMap<Integer, HashMap<String, String>> gridManageUserPage = manageuser.manageUsersPageGrid();
	    for (int i = 1; i < manageuser.getRows().size(); i++) {
	    Assert.assertTrue(gridManageUserPage.get(i).get("Role Type").equals("DealerGroup") | gridManageUserPage.get(i).get("Role Type").equals("DealerGrpEmp"));
		}
	}
	
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
