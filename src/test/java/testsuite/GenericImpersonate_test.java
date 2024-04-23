package testsuite;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pageActions.DeleteGenericUserAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.XmlDataReader;
import utils.utilityClass;

/* PBI 33085 */
/* Total Tc's - 32*/

/* 5 Tc's added from PBI 35606 */
public class GenericImpersonate_test extends impersonateAction{
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	ManageUsersPage_test manageuser = new ManageUsersPage_test();
	XmlDataReader UtilsDataReader = new XmlDataReader("UtilsData");
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction();
	contract_test contract=new contract_test();
	DeleteGenericUserAction genericUserPage=new DeleteGenericUserAction();
	Permissions_test permissions=new Permissions_test();

	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}
	
	@Test(priority = 1)
	public void verifyAgentIsNotImpersonatedAsGenericDealerWhenClickedOnNoBtn_35600() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers(UtilsDataReader.getXMLData("dealer3"));
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Dealer");
		utils.getfield("span","No").click();
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
	}

	@Test(priority = 2)
	public void verifyAgentIsNotImpersonatedAsGenericDealerWhenClickedOnCloseBtn_35599() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers(UtilsDataReader.getXMLData("dealer3"));
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Dealer");
		utils.getfield("mat-icon","close").click();
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
	}
	
	@Test(priority = 3)
	public void verifysubAgentImpersonatedAsDealer_34948() throws Exception {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers(UtilsDataReader.getXMLData("dealer3"));
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Dealer");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
//		utils.waituntillPageIsloaded(1);
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Dealer").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
	}
	
	@Test(priority = 4)
	public void verifysubAgentImpersonatedAsDealeEmp_34953() throws Exception {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers(UtilsDataReader.getXMLData("dealer3"));
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrow);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrow);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerEmp");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
	}
	@Test(priority = 5)
	public void verifysubAgentCannotImpersonateAsGenericDealerWhenDealerIsNotAssignedToSubagent_35687() throws Exception {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		utils.element("xpath", manageuser.enterRole).sendKeys(UtilsDataReader.getXMLData("accountName"));
		Assert.assertTrue(utils.element("xpath", impersonateInGenericRoleBtn).getAttribute("disabled").equals("true"));
	}
	
	@Test(priority = 6)
	public void verifyAgentIsAbleToAccessAllTheOptionsAftrEndingGenericImpersonationAsDealer_34929() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers(UtilsDataReader.getXMLData("dealer3"));
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Dealer");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Dealer").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		getEndImpersonate();
		verticalMenu.navigatetoLeftMainMenu("Dealer Settings");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("Manage Dealers"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(1).getText().contains("Activity Tracker"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(2).getText().contains("Manage Pricing Preferences"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(3).getText().contains("Manage VSC - GAP Preferences"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(4).getText().contains("Manage My Dealer Packs"));
	}
	
	@Test(priority = 7)
	public void verifyAgentIsAbleToAccessAllTheOptionsAftrEndingGenericImpersonationAsDealerEmp_34934() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers(UtilsDataReader.getXMLData("dealer3"));
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerEmp");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		getEndImpersonate();
		verticalMenu.navigatetoLeftMainMenu("Dealer Settings");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("Manage Dealers"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(1).getText().contains("Activity Tracker"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(2).getText().contains("Manage Pricing Preferences"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(3).getText().contains("Manage VSC - GAP Preferences"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(4).getText().contains("Manage My Dealer Packs"));
	}
	
	@Test(priority = 8)
	public void verifyAgentGenericCanBeImpersonatedAsGenericDealer_34906() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUser("Agent", "393");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Agent"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("SubAgent"));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Agent");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		verticalMenu.verifyLateralmenuMainItemsForAgentSubAgent();
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers("a");
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrow));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Dealer");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait1();
		utils.wait1();
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Dealer").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("My Settings");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("Manage Employees"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(1).getText().contains("Issue New User Registration"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(2).getText().contains("Manage My Pricing Preferences"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(3).getText().contains("Manage VSC - GAP Preferences"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(4).getText().contains("Manage My Dealer Packs"));
	}
	
	@Test(priority = 9)
	public void verifyAgentGenericCanBeImpersonatedAsGenericDealerEmp_34977() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUser("Agent", "393");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Agent"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("SubAgent"));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Agent");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		verticalMenu.verifyLateralmenuMainItemsForAgentSubAgent();
		//
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers("a");
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrow));
		utils.clickfield("xpath", impersonate.roleDropdownArrow);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerEmp");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("Report");
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<verticalMenu.getLaterMenuSubItems().size(); i++) {
			String[] menuItem = verticalMenu.getLaterMenuSubItems().get(i).getText().split("chevron_right");
			list.add(menuItem[0].trim());
		}
		System.out.println(list);
			Assert.assertTrue(list.contains("Activations"));
			Assert.assertTrue(list.contains("Claims History"));
			Assert.assertTrue(list.contains("Early Claims"));
	}
	
	@Test(priority = 10)
	public void verifyAgentImpersonatedAsDealerGeneric_34930_35878() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers(UtilsDataReader.getXMLData("dealer3"));
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Dealer");
		Thread.sleep(200);
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Dealer").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").getText().contains("generic"));
	}
	
	
	@Test(priority = 11)
	public void verifyAgentImpersonatedAsDealerEmp_34935() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers(UtilsDataReader.getXMLData("dealer3"));
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerEmp");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
	}
	
	@Test(priority = 12)
	public void verifySubAgentIsAbleToAccessAllTheOptionsAftrEndingGenericImpersonationAsGenericDealer_34947_34916() throws Exception {
		permissions.getDefaultpermissionForsubAgent();
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers(UtilsDataReader.getXMLData("dealer3"));
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Dealer");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Dealer").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		getEndImpersonate();
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("My Commissions"));
	}
	
	@Test(priority = 13)
	public void verifySubAgentIsAbleToAccessAllTheOptionsAftrEndingGenericImpersonationAsGenericDealerEmp_34952() throws Exception {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers(UtilsDataReader.getXMLData("dealer3"));
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerEmp");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		getEndImpersonate();
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("My Commissions"));
	}
	
	@Test(priority = 14)
	public void verifySubagentGenericCanBeImpersonatedAsGenericDealer_34997() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUser("SubAgent", "393");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Agent"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("SubAgent"));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("SubAgent");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		verticalMenu.verifyLateralmenuMainItemsForAgentSubAgent();
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers("a");
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrow));
		utils.clickfield("xpath", impersonate.roleDropdownArrow);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrow);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Dealer");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Dealer").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("My Settings");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("Manage Employees"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(1).getText().contains("Issue New User Registration"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(2).getText().contains("Manage My Pricing Preferences"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(3).getText().contains("Manage VSC - GAP Preferences"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(4).getText().contains("Manage My Dealer Packs"));
	}
	
	@Test(priority = 15)
	public void verifySubagentGenericCanBeImpersonatedAsGenericDealerEmp_34994() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUser("SubAgent", "393");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Agent"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("SubAgent"));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("SubAgent");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		verticalMenu.verifyLateralmenuMainItemsForAgentSubAgent();
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers("a");
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrow));
		utils.clickfield("xpath", impersonate.roleDropdownArrow);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrow);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerEmp");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("Report");
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<verticalMenu.getLaterMenuSubItems().size(); i++) {
			String[] menuItem = verticalMenu.getLaterMenuSubItems().get(i).getText().split("chevron_right");
			list.add(menuItem[0].trim());
		}
		System.out.println(list);
			Assert.assertTrue(list.contains("Activations"));
			Assert.assertTrue(list.contains("Claims History"));
			Assert.assertTrue(list.contains("Early Claims"));
	}
	
	@Test(priority = 16)
	public void verifyAgentGenericCanBeImpersonatedAsGenericDealerEmpAndEndImperosonate_34978() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUser("SubAgent", "393");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Agent"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("SubAgent"));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Agent");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		verticalMenu.verifyLateralmenuMainItemsForAgentSubAgent();
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers("a");
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerEmp");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		getEndImpersonate();
		verticalMenu.navigatetoLeftMainMenu("Dealer Settings");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("Manage Dealers"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(1).getText().contains("Activity Tracker"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(2).getText().contains("Manage Pricing Preferences"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(3).getText().contains("Manage VSC - GAP Preferences"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(4).getText().contains("Manage My Dealer Packs"));
	}

	
	@Test(priority = 17)
	public void verifySubAgentGenericCanBeImpersonatedAsGenericDealerEmpAndEndImperosonate_34995() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUser("SubAgent", "393");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Agent"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("SubAgent"));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("SubAgent");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		verticalMenu.verifyLateralmenuMainItemsForAgentSubAgent();
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers("a");
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrow));
		utils.clickfield("xpath", impersonate.roleDropdownArrow);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrow);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerEmp");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		getEndImpersonate();
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("Unpaid Contracts"));
	}

	@Test(priority = 18)
	public void verifyAgentGenericCanBeImpersonatedAsGenericDealerAndEndImperosonate_34908() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUser("Agent", "393");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Agent"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("SubAgent"));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Agent");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		verticalMenu.verifyLateralmenuMainItemsForAgentSubAgent();
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers("a");
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrow));
		utils.clickfield("xpath", impersonate.roleDropdownArrow);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrow);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Dealer");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Dealer").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		getEndImpersonate();
		verticalMenu.navigatetoLeftMainMenu("Dealer Settings");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("Manage Dealers"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(1).getText().contains("Activity Tracker"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(2).getText().contains("Manage Pricing Preferences"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(3).getText().contains("Manage VSC - GAP Preferences"));
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(4).getText().contains("Manage My Dealer Packs"));
	}
	
	@Test(priority = 19)
	public void verifySubAgentGenericCanBeImpersonatedAsGenericDealerAndEndImperosonate_34998_34915() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUser("SubAgent", "393");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Agent"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("SubAgent"));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("SubAgent");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		verticalMenu.verifyLateralmenuMainItemsForAgentSubAgent();
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPageWithOutgetUsers("a");
		utils.waitTillElementIsClickableByWebEle(utils.getfield("span", "Impersonate as Generic Role"));
		utils.getfield("span", "Impersonate as Generic Role").click();
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrow));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		Assert.assertTrue(utils.getfield("span","Impersonate").isEnabled());
		Assert.assertTrue(utils.getfield("span","No").isEnabled());
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Dealer");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Dealer").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		getEndImpersonate();
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("Unpaid Contracts"));
	}

	
	@Test(priority = 20)
	public void verifyImpersonateAsGenericRolePopupDisplayedWithCorrectRoles_34904_34913() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUser("Agent", "393");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Agent"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("SubAgent"));
		utils.getfield("mat-icon","close").click();
		Thread.sleep(1000);
		utils.element("xpath", roleId).clear();
		impersonate.impersonateAsGenericUser("Dealer", "28771");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		utils.getfield("mat-icon","close").click();
		Thread.sleep(1000);
		utils.element("xpath", roleId).clear();
		impersonate.impersonateAsGenericUser("DealerGroup", "47421");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("DealerGroup"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerGrpEmp"));
		utils.getfield("mat-icon","close").click();
		
		
	}
	
	@Test(priority = 21)
	public void verifyUserIsImpersonatedAsAgentGenericRoleSuccessfully_34905() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUser("Agent", "393");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Agent"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("SubAgent"));
		manageuser.selectRoleTypeInGenericImpersonatePopup("Agent");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		verticalMenu.verifyLateralmenuMainItemsForAgentSubAgent();
	}

	@Test(priority = 21)
	public void verifyUserIsImpersonatedAsSubAgenetGenericRoleSuccessfully_34914() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUser("SubAgent", "393");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Agent"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("SubAgent"));
		manageuser.selectRoleTypeInGenericImpersonatePopup("SubAgent");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		verticalMenu.verifyLateralmenuMainItemsForAgentSubAgent();
	}
	
	@Test(priority = 22)
	public void verifyAdminCanImpersonateDealerEmpGeneric_35008_35873_35874() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		String roleId=UtilsDataReader.getXMLData("dealerId");
		impersonate.impersonateAsGenericUser("DealerEmp", roleId);
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerEmp");
		Thread.sleep(200);
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").getText().contains("generic"));
		String[] mailId = utils.getfield("span", "Username").getText().split(" ");
		String impersonatedGenericMailId = mailId[1];
		System.out.println("generic uset Id-"+impersonatedGenericMailId);
		verticalMenu.verifyLateralmenuMainItemsForDealerDealerEmpDealerGrpEmp();
		impersonate.getEndImpersonate();
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("DealerEmp", roleId);
		impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> impersonatePage = genericUserPage.checkGridBodyDetailsInImpersonatePage();
	    System.out.println("email:"+impersonatePage.get(1).get("Email"));
	    Assert.assertTrue(impersonatePage.get(1).get("Email").contains(impersonatedGenericMailId));
	}
	
	@Test(priority = 23)
	public void verifyAdminCanImpersonateDealerGeneric_35005_35850_35851() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		String roleId=UtilsDataReader.getXMLData("dealerId");
		impersonate.impersonateAsGenericUser("Dealer", roleId);
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		manageuser.selectRoleTypeInGenericImpersonatePopup("Dealer");
		Thread.sleep(200);
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Dealer").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").getText().contains("generic"));
		String[] mailId = utils.getfield("span", "Username").getText().split(" ");
		String impersonatedGenericMailId = mailId[1];
		System.out.println("generic uset Id-"+impersonatedGenericMailId);
		verticalMenu.verifyLateralmenuMainItemsForDealerDealerEmpDealerGrpEmp();
		impersonate.getEndImpersonate();
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Dealer", roleId);
		impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> impersonatePage = genericUserPage.checkGridBodyDetailsInImpersonatePage();
	    System.out.println("email:"+impersonatePage.get(1).get("Email"));
	    Assert.assertTrue(impersonatePage.get(1).get("Email").contains(impersonatedGenericMailId));
	}
	
	@Test(priority = 24)
	public void verifyAdminCanImpersonateDealerGrpEmpGeneric_35014() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		String roleId=UtilsDataReader.getXMLData("dealerGrpId");
		impersonate.impersonateAsGenericUser("DealerGrpEmp", roleId);
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("DealerGroup"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerGrpEmp"));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerGrpEmp");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerGrpEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").getText().contains("generic"));
		String[] mailId = utils.getfield("span", "Username").getText().split(" ");
		String impersonatedGenericMailId = mailId[1];
		System.out.println("generic uset Id-"+impersonatedGenericMailId);
		verticalMenu.verifyLateralmenuMainItemsForDealerDealerEmpDealerGrpEmp();
		impersonate.getEndImpersonate();
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("DealerGrpEmp", roleId);
		impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> impersonatePage = genericUserPage.checkGridBodyDetailsInImpersonatePage();
	    System.out.println("email:"+impersonatePage.get(1).get("Email"));
	    Assert.assertTrue(impersonatePage.get(1).get("Email").contains(impersonatedGenericMailId));
	}
	
	@Test(priority = 25)
	public void verifyAdminCanImpersonateDealerGrpGeneric_35011() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		impersonate.impersonateAsGenericUser("DealerGroup", "47421");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("DealerGroup"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerGrpEmp"));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerGroup");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerGroup").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		verticalMenu.verifyLateralmenuMainItemsForDealerDealerEmpDealerGrpEmp();
	}
	
	@Test(priority = 26)
	public void verifyAdminIsLoggedInAfterEndingImpersonationAsDealer_35006() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		impersonate.impersonateAsGenericUser("Dealer", "22723");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Dealer");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Dealer").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		getEndImpersonate();
		Assert.assertTrue(utils.element("xpath", aulAdmin).isDisplayed());
		Assert.assertTrue(getImpersonatingDataList().size()==0);
	}
	
	@Test(priority = 27)
	public void verifyAdminIsLoggedInAfterEndingImpersonationAsDealerEmp_35009() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		impersonate.impersonateAsGenericUser("DealerEmp", "22723");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("Dealer"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerEmp"));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerEmp");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		getEndImpersonate();
		Assert.assertTrue(utils.element("xpath", aulAdmin).isDisplayed());
		Assert.assertTrue(getImpersonatingDataList().size()==0);
	}
	
	@Test(priority = 28)
	public void verifyAdminIsLoggedInAfterEndingImpersonationAsDealerGrp_35012() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		impersonate.impersonateAsGenericUser("DealerGroup", "47421");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("DealerGroup"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerGrpEmp"));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerGroup");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerGroup").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		getEndImpersonate();
		Assert.assertTrue(utils.element("xpath", aulAdmin).isDisplayed());
		Assert.assertTrue(getImpersonatingDataList().size()==0);
	}
	
	@Test(priority = 29)
	public void verifyAdminIsLoggedInAfterEndingImpersonationAsDealerGrpEmp_35015() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		impersonate.impersonateAsGenericUser("DealerGrpEmp", "47421");
		utils.waitTillElementIsClickableByWebEle(utils.element("xpath", impersonate.roleDropdownArrowInPopup));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		utils.waitTillElementIsClickableByWebEle(manageuser.getDropDownlistForRoleType().get(0));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(0).getText().equals("DealerGroup"));
		Assert.assertTrue(manageuser.getDropDownlistForRoleType().get(1).getText().equals("DealerGrpEmp"));
		utils.clickfield("xpath", impersonate.roleDropdownArrowInPopup);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerGrpEmp");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.wait(20000);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerGrpEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").isDisplayed());
		getEndImpersonate();
		Assert.assertTrue(utils.element("xpath", aulAdmin).isDisplayed());
		Assert.assertTrue(getImpersonatingDataList().size()==0);
	}
	
	@Test(priority = 30)
	public void verifyDealerEmpIsShownInGridWhenLoggedInAsSubagent_34898() throws Exception {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealer3"));
		impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    Thread.sleep(1000);
		 HashMap<Integer, HashMap<String, String>> impersonatePage = genericUserPage.checkGridBodyDetailsInImpersonatePage();
		 manageuser.selectRoleTypeInGrid("DealerEmp");
		 Assert.assertTrue(impersonatePage.get(1).get("Email").contains("generic"));
		 HashMap<Integer, HashMap<String, WebElement>> editDelLock = genericUserPage.checkGridForEditLockResendInvitationImpersonateForAllRolesExceptagentDealerLender();
		    Assert.assertTrue(editDelLock.get(1).get("Locked Out").isEnabled());
		    Assert.assertTrue(editDelLock.get(1).get("Edit").isEnabled());
		    Assert.assertTrue(editDelLock.get(1).get("Impersonate").isEnabled());
		    Assert.assertTrue(editDelLock.get(1).get("Resend Invitation").getAttribute("class").contains("disabled"));
	}
	
	@Test(priority = 31)
	public void verifyDealerEmpIsShownInGridWhenLoggedInAsAgent_35882() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		Assert.assertTrue(utils.getfield("h3", "Manage Dealers").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(utils.getfield("span", " + New user ").isDisplayed());
		manageuser.verifyAllTheHeaders();
		manageuser.selectDealerInmanageUserPage(UtilsDataReader.getXMLData("dealer3"));
		impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    Thread.sleep(1000);
		 HashMap<Integer, HashMap<String, String>> impersonatePage = genericUserPage.checkGridBodyDetailsInImpersonatePage();
		 manageuser.selectRoleTypeInGrid("DealerEmp");
		 Assert.assertTrue(impersonatePage.get(1).get("Email").contains("generic"));
		 HashMap<Integer, HashMap<String, WebElement>> editDelLock = manageuser.checkGridForLockImpersonateResendInvitationManageuser();
		    Assert.assertTrue(editDelLock.get(1).get("Locked Out").isEnabled());
		    Assert.assertTrue(editDelLock.get(1).get("Edit").isEnabled());
		    Assert.assertTrue(editDelLock.get(1).get("Impersonate").isEnabled());
		    Assert.assertTrue(editDelLock.get(1).get("Resend Invitation").getAttribute("class").contains("disabled"));
	}
	
	 @AfterMethod(alwaysRun=true)
	    public void close() throws InterruptedException {
		 try {
				login.logout();
				} catch (Exception e) {
					if(utils.getfield("mat-icon", "close").isDisplayed()) {
					utils.getfield("mat-icon", "close").click();
					login.logout();
					}
			}
	    }

}
