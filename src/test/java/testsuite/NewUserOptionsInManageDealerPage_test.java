package testsuite;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.ManageUserPageAction;
import pageActions.NewUserRegistration_Action;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.XmlDataReader;
import utils.utilityClass;


/*PBI 35497 - Total Tc's - 19 */
public class NewUserOptionsInManageDealerPage_test extends ManageUserPageAction{
	
	
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();
	ManageUserPageAction manageuser = new ManageUserPageAction();
	XmlDataReader UtilsDataReader=new XmlDataReader("UtilsData");
	NewUserRegistration_Action newUserPage=new NewUserRegistration_Action();
	
	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
//		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}

	
	@Test(priority = 1)
	public void verifySubAgentCanCreateDealer_35922() throws InterruptedException {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealer3"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("Dealer",newUserEmail);
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		 System.out.println("mail----"+manageUserPageGrid.get(1).get("Email"));
		 System.out.println("reg status----"+manageUserPageGrid.get(1).get("Registration Status"));
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}
	
	@Test(priority = 2)
	public void verifySubAgentCanCreateDealerEmp_35923() throws InterruptedException {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealer3"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("DealerEmp",newUserEmail);
		manageuser.selectRoleTypeInGrid("DealerEmp");
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		 System.out.println("mail----"+manageUserPageGrid.get(1).get("Email"));
		 System.out.println("reg status----"+manageUserPageGrid.get(1).get("Registration Status"));
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}
	
	@Test(priority = 3)
	public void verifySubAgentCanCreateDealerGrp_35924() throws InterruptedException {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealerGrp"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("DealerGroup",newUserEmail);
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		 System.out.println("mail----"+manageUserPageGrid.get(1).get("Email"));
		 System.out.println("reg status----"+manageUserPageGrid.get(1).get("Registration Status"));
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}
	
	@Test(priority = 4)
	public void verifySubAgentCanCreateDealerGrpEmp_35926() throws InterruptedException {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealerGrp"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("DealerGrpEmp",newUserEmail);
		manageuser.selectRoleTypeInGrid("DealerGrpEmp");
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		 System.out.println("mail----"+manageUserPageGrid.get(1).get("Email"));
		 System.out.println("reg status----"+manageUserPageGrid.get(1).get("Registration Status"));
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}
	
	@Test(priority = 5)
	public void verifyAgentCanCreateDealer_35913() throws InterruptedException {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealer3"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("Dealer",newUserEmail);
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}
	
	@Test(priority = 6)
	public void verifyAgentCanCreateDealerEmp_35919() throws InterruptedException {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealer3"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("DealerEmp",newUserEmail);
		manageuser.selectRoleTypeInGrid("DealerEmp");
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}
	
	@Test(priority = 7)
	public void verifyAgentCanCreateDealerGrp_35920() throws InterruptedException {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealerGrp"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("DealerGroup",newUserEmail);
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}
	
	@Test(priority = 8)
	public void verifyAgentCanCreateDealerGrpEmp_35921() throws InterruptedException {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealerGrp"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("DealerGrpEmp",newUserEmail);
		utils.wait(1000);
		manageuser.selectRoleTypeInGrid("DealerGrpEmp");
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}
	
	
	@Test(priority = 9)
	public void verifySubAgentCanCreateDealerThroughAdminLogin_35939() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForSubagentLendrEmp("SubAgent", "110");
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealer3"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("Dealer",newUserEmail);
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}
	
	@Test(priority = 10)
	public void verifySubAgentCanCreateDealerEmpThroughAdminLogin_35941() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForSubagentLendrEmp("SubAgent", "110");
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealer3"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("DealerEmp",newUserEmail);
		manageuser.selectRoleTypeInGrid("DealerEmp");
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}
	
	@Test(priority = 11)
	public void verifySubAgentCanCreateDealerGrpThroughAdminLogin_35942() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForSubagentLendrEmp("SubAgent", "110");
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealerGrp"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("DealerGroup",newUserEmail);
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}

	
	@Test(priority = 12)
	public void verifySubAgentCanCreateDealerGrpEmpThroughAdminLogin_35943() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForSubagentLendrEmp("SubAgent", "110");
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealerGrp"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("DealerGrpEmp",newUserEmail);
		manageuser.selectRoleTypeInGrid("DealerGrpEmp");
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}

	
	@Test(priority = 13)
	public void verifyAgentCanCreateDealerThroughAdminLogin_35928() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Agent", "110");
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealer3"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("Dealer",newUserEmail);
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}
	
	@Test(priority = 14)
	public void verifyAgentCanCreateDealerEmpThroughAdminLogin_35935() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Agent", "110");
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealer3"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("DealerEmp",newUserEmail);
		manageuser.selectRoleTypeInGrid("DealerEmp");
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}
	
	@Test(priority = 15)
	public void verifyAgentCanCreateDealerGrpThroughAdminLogin_35936_36312() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Agent", "110");
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealerGrp"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("DealerGroup",newUserEmail);
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
	}

	
	@Test(priority = 16)
	public void verifyAgentCanCreateDealerGrpEmpThroughAdminLogin_35937() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Agent", "110");
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealerGrp"));
		String newUserEmail = UtilsDataReader.getXMLData("newUserMailId");
		getNewUserPageWithoutAccountNameSelection("DealerGrpEmp",newUserEmail);
		utils.wait(1000);
		manageuser.selectRoleTypeInGrid("DealerGrpEmp");
		 HashMap<Integer, HashMap<String, String>> manageUserPageGrid = manageuser.manageUsersPageGrid();
		if(manageUserPageGrid.get(1).get("Email").equals(newUserEmail)) {
			manageUserPageGrid.get(1).get("Registration Status").equals("Pending");
		}
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
