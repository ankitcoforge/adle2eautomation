package testsuite;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.DeleteGenericUserAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

/* PBI 35646 & 35496  */
public class DeleteGenericUser_test extends DeleteGenericUserAction{
	
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();
	ManageUsersPage_test manageuser = new ManageUsersPage_test();
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}

	@Test(priority = 1)
	public void verifyDeleteOptionIsDisabledForDealerGeneric_35931_35932() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Dealer", "28771");
		Assert.assertTrue(utils.element("xpath", impersonate.impersonateAsGenericUserButton).isDisplayed());
		utils.clickfield("xpath", impersonate.impersonateAsGenericUserButton);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Dealer");
		Thread.sleep(200);
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.waituntillPageIsloaded(10);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Dealer").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").getText().contains("generic"));
		String[] mailId = utils.getfield("span", "Username").getText().split(" ");
		String impersonatedGenericMailId = mailId[1];
		System.out.println("mailId---"+impersonatedGenericMailId);
	    impersonate.getEndImpersonate();
	    verticalMenu.navigatetoimpersonate();
	    impersonate.getUsers("Dealer", "28771");
	    manageuser.selectRoleTypeInGrid("Dealer");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> gridBodyDetails = checkGridBodyDetailsInImpersonatePage();
	     HashMap<Integer, HashMap<String, WebElement>> editDelLock = checkGridForEditLockResendInvitationImpersonate();
	    Assert.assertTrue(gridBodyDetails.get(1).get("Email").contains(impersonatedGenericMailId));
	    Assert.assertTrue(editDelLock.get(1).get("Locked Out").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Edit").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Impersonate").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Resend Invitation").getAttribute("class").contains("disabled"));
	    Assert.assertTrue(deleteLinkInGrid(1).isEnabled());
	}
	
	@Test(priority = 2)
	public void verifyDeleteOptionIsDisabledForDealerEmpGeneric_35933_35934() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("DealerEmp", "28771");
		Assert.assertTrue(utils.element("xpath", impersonate.impersonateAsGenericUserButton).isDisplayed());
		utils.clickfield("xpath", impersonate.impersonateAsGenericUserButton);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerEmp");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.waituntillPageIsloaded(10);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").getText().contains("generic"));
		String[] mailId = utils.getfield("span", "Username").getText().split(" ");
		String impersonatedGenericMailId = mailId[1];
		System.out.println("mailId---"+impersonatedGenericMailId);
	    impersonate.getEndImpersonate();
	    verticalMenu.navigatetoimpersonate();
	    impersonate.getUsers("DealerEmp", "28771");
	    manageuser.selectRoleTypeInGrid("DealerEmp");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> gridBodyDetails = checkGridBodyDetailsInImpersonatePage();
	     HashMap<Integer, HashMap<String, WebElement>> editDelLock = checkGridForEditLockResendInvitationImpersonate();
	    Assert.assertTrue(gridBodyDetails.get(1).get("Email").contains(impersonatedGenericMailId));
	    Assert.assertTrue(editDelLock.get(1).get("Locked Out").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Edit").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Impersonate").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Resend Invitation").getAttribute("class").contains("disabled"));
	    Assert.assertTrue(deleteLinkInGrid(1).isEnabled());
	}
	
	
	@Test(priority = 3)
	public void verifyDeleteOptionIsDisabledForAgentGeneric_35916_35918() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Agent", "393");
		Assert.assertTrue(utils.element("xpath", impersonate.impersonateAsGenericUserButton).isDisplayed());
		utils.clickfield("xpath", impersonate.impersonateAsGenericUserButton);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Agent");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.waituntillPageIsloaded(10);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Agent").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").getText().contains("generic"));
		String[] mailId = utils.getfield("span", "Username").getText().split(" ");
		String impersonatedGenericMailId = mailId[1];
		System.out.println("mailId---"+impersonatedGenericMailId);
	    impersonate.getEndImpersonate();
	    verticalMenu.navigatetoimpersonate();
	    impersonate.getUsers("Agent", "393");
	    manageuser.selectRoleTypeInGrid("Agent");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> gridBodyDetails = checkGridBodyDetailsInImpersonatePage();
	     HashMap<Integer, HashMap<String, WebElement>> editDelLock = checkGridForEditLockResendInvitationImpersonate();
	    Assert.assertTrue(gridBodyDetails.get(1).get("Email").contains(impersonatedGenericMailId));
	    Assert.assertTrue(editDelLock.get(1).get("Locked Out").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Edit").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Impersonate").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Resend Invitation").getAttribute("class").contains("disabled"));
	    Assert.assertTrue(deleteLinkInGrid(1).isEnabled());
	}
	
	
	@Test(priority = 4)
	public void verifyDeleteOptionIsDisabledForSubAgentGeneric_35925_35927() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("SubAgent", "393");
		Assert.assertTrue(utils.element("xpath", impersonate.impersonateAsGenericUserButton).isDisplayed());
		utils.clickfield("xpath", impersonate.impersonateAsGenericUserButton);
		manageuser.selectRoleTypeInGenericImpersonatePopup("SubAgent");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.waituntillPageIsloaded(10);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "SubAgent").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").getText().contains("generic"));
		String[] mailId = utils.getfield("span", "Username").getText().split(" ");
		String impersonatedGenericMailId = mailId[1];
		System.out.println("mailId---"+impersonatedGenericMailId);
	    impersonate.getEndImpersonate();
	    verticalMenu.navigatetoimpersonate();
	    impersonate.getUsers("SubAgent", "393");
	    manageuser.selectRoleTypeInGrid("SubAgent");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> gridBodyDetails = checkGridBodyDetailsInImpersonatePage();
	     HashMap<Integer, HashMap<String, WebElement>> editDelLock = checkGridForEditLockResendInvitationImpersonate();
	    Assert.assertTrue(gridBodyDetails.get(1).get("Email").contains(impersonatedGenericMailId));
	    Assert.assertTrue(editDelLock.get(1).get("Locked Out").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Edit").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Impersonate").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Resend Invitation").getAttribute("class").contains("disabled"));
	    Assert.assertTrue(deleteLinkInGrid(1).isEnabled());
	}
	
	@Test(priority = 5)
	public void verifyDeleteOptionIsDisabledForLenderGeneric_36004() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Lender", "30");
		Assert.assertTrue(utils.element("xpath", impersonate.impersonateAsGenericUserButton).isDisplayed());
		utils.clickfield("xpath", impersonate.impersonateAsGenericUserButton);
		manageuser.selectRoleTypeInGenericImpersonatePopup("Lender");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.waituntillPageIsloaded(10);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Lender").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").getText().contains("generic"));
		String[] mailId = utils.getfield("span", "Username").getText().split(" ");
		String impersonatedGenericMailId = mailId[1];
		System.out.println("mailId---"+impersonatedGenericMailId);
	    impersonate.getEndImpersonate();
	    verticalMenu.navigatetoimpersonate();
	    impersonate.getUsers("Lender", "30");
	    manageuser.selectRoleTypeInGrid("Lender");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> gridBodyDetails = checkGridBodyDetailsInImpersonatePage();
	     HashMap<Integer, HashMap<String, WebElement>> editDelLock = checkGridForEditLockResendInvitationImpersonate();
	    Assert.assertTrue(gridBodyDetails.get(1).get("Email").contains(impersonatedGenericMailId));
	    Assert.assertTrue(editDelLock.get(1).get("Locked Out").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Edit").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Impersonate").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Resend Invitation").getAttribute("class").contains("disabled"));
	    Assert.assertTrue(deleteLinkInGrid(1).isEnabled());
	}
	
	@Test(priority = 6)
	public void verifyDeleteOptionIsDisabledForLenderEmpGeneric_36005() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("LenderEmp", "30");
		Assert.assertTrue(utils.element("xpath", impersonate.impersonateAsGenericUserButton).isDisplayed());
		utils.clickfield("xpath", impersonate.impersonateAsGenericUserButton);
		manageuser.selectRoleTypeInGenericImpersonatePopup("LenderEmp");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.waituntillPageIsloaded(10);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "LenderEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").getText().contains("generic"));
		String[] mailId = utils.getfield("span", "Username").getText().split(" ");
		String impersonatedGenericMailId = mailId[1];
		System.out.println("mailId---"+impersonatedGenericMailId);
	    impersonate.getEndImpersonate();
	    verticalMenu.navigatetoimpersonate();
	    impersonate.getUsers("LenderEmp", "30");
	    manageuser.selectRoleTypeInGrid("LenderEmp");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> gridBodyDetails = checkGridBodyDetailsInImpersonatePage();
	     HashMap<Integer, HashMap<String, WebElement>> editDelLock = checkGridForEditLockResendInvitationImpersonate();
	    Assert.assertTrue(gridBodyDetails.get(1).get("Email").contains(impersonatedGenericMailId));
	    Assert.assertTrue(editDelLock.get(1).get("Locked Out").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Edit").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Impersonate").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Resend Invitation").getAttribute("class").contains("disabled"));
	    Assert.assertTrue(deleteLinkInGrid(1).isEnabled());
	}
	
	
	@Test(priority = 7)
	public void verifyDeleteOptionIsDisabledForDealerGrpGeneric_35938_35940() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("DealerGroup", "47421");
		Assert.assertTrue(utils.element("xpath", impersonate.impersonateAsGenericUserButton).isDisplayed());
		utils.clickfield("xpath", impersonate.impersonateAsGenericUserButton);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerGroup");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.waituntillPageIsloaded(10);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerGroup").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").getText().contains("generic"));
		String[] mailId = utils.getfield("span", "Username").getText().split(" ");
		String impersonatedGenericMailId = mailId[1];
		System.out.println("mailId---"+impersonatedGenericMailId);
	    impersonate.getEndImpersonate();
	    verticalMenu.navigatetoimpersonate();
	    impersonate.getUsers("DealerGroup", "47421");
	    manageuser.selectRoleTypeInGrid("DealerGroup");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> gridBodyDetails = checkGridBodyDetailsInImpersonatePage();
	     HashMap<Integer, HashMap<String, WebElement>> editDelLock = checkGridForEditLockResendInvitationImpersonate();
	    Assert.assertTrue(gridBodyDetails.get(1).get("Email").contains(impersonatedGenericMailId));
	    Assert.assertTrue(editDelLock.get(1).get("Locked Out").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Edit").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Impersonate").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Resend Invitation").getAttribute("class").contains("disabled"));
	    Assert.assertTrue(deleteLinkInGrid(1).isEnabled());
	}
	
	@Test(priority = 8)
	public void verifyDeleteOptionIsDisabledForDealerGrpEmpGeneric_35944_35955() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("DealerGrpEmp", "47421");
		Assert.assertTrue(utils.element("xpath", impersonate.impersonateAsGenericUserButton).isDisplayed());
		utils.clickfield("xpath", impersonate.impersonateAsGenericUserButton);
		manageuser.selectRoleTypeInGenericImpersonatePopup("DealerGrpEmp");
		utils.element("xpath", impersonate.impersonateInGenericImpPopupInImpPage).click();
		utils.waituntillPageIsloaded(10);
		Assert.assertTrue(utils.getfield("span", "Impersonating").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "DealerGrpEmp").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "Username").getText().contains("generic"));
		String[] mailId = utils.getfield("span", "Username").getText().split(" ");
		String impersonatedGenericMailId = mailId[1];
		System.out.println("mailId---"+impersonatedGenericMailId);
	    impersonate.getEndImpersonate();
	    verticalMenu.navigatetoimpersonate();
	    impersonate.getUsers("DealerGrpEmp", "47421");
	    manageuser.selectRoleTypeInGrid("DealerGrpEmp");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> gridBodyDetails = checkGridBodyDetailsInImpersonatePage();
	     HashMap<Integer, HashMap<String, WebElement>> editDelLock = checkGridForEditLockResendInvitationImpersonate();
	    Assert.assertTrue(gridBodyDetails.get(1).get("Email").contains(impersonatedGenericMailId));
	    Assert.assertTrue(editDelLock.get(1).get("Locked Out").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Edit").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Impersonate").isEnabled());
	    Assert.assertTrue(editDelLock.get(1).get("Resend Invitation").getAttribute("class").contains("disabled"));
	    Assert.assertTrue(deleteLinkInGrid(1).isEnabled());
	}
	
	
	@Test(priority = 9)
	public void verifyDeleteOptionIsDisabledForDealerGenericWhenLoggedInAsAgent_35946() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage("a");
		manageuser.selectRoleTypeInGrid("Dealer");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    HashMap<Integer, HashMap<String, WebElement>> gridManageUserPage = manageuser.checkGridForLockImpersonateResendInvitationManageuser();
	    Assert.assertTrue(gridManageUserPage.get(1).get("Locked Out").isEnabled());
	    Assert.assertTrue(manageuser.editLinkInGrid(1).isEnabled());
	    Assert.assertTrue(manageuser.deleteLinkInGrid(1).getAttribute("class").contains("disabled"));
	    Assert.assertTrue(gridManageUserPage.get(1).get("Resend Invitation").getAttribute("class").contains("disabled"));
	    Assert.assertTrue(gridManageUserPage.get(1).get("Impersonate").isEnabled());
	}
	
	@Test(priority = 10)
	public void verifyDeleteOptionIsDisabledForDealerEmpGenericWhenLoggedInAsAgent_35947() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage("a");
		manageuser.selectRoleTypeInGrid("DealerEmp");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    HashMap<Integer, HashMap<String, WebElement>> gridManageUserPage = manageuser.checkGridForLockImpersonateResendInvitationManageuser();
	    Assert.assertTrue(gridManageUserPage.get(1).get("Locked Out").isEnabled());
	    Assert.assertTrue(manageuser.editLinkInGrid(1).isEnabled());
	    Assert.assertTrue(manageuser.deleteLinkInGrid(1).getAttribute("class").contains("disabled"));
	    Assert.assertTrue(gridManageUserPage.get(1).get("Resend Invitation").getAttribute("class").contains("disabled"));
	    Assert.assertTrue(gridManageUserPage.get(1).get("Impersonate").isEnabled());
	}
	
	@Test(priority = 11)
	public void verifyDeleteOptionIsDisabledForDealerGenericWhenLoggedInAsSubAgent_35948() throws Exception {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage("a");
		manageuser.selectRoleTypeInGrid("Dealer");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    HashMap<Integer, HashMap<String, WebElement>> gridManageUserPage = manageuser.checkGridForLockImpersonateResendInvitationManageuser();
	    Assert.assertTrue(gridManageUserPage.get(1).get("Locked Out").isEnabled());
	    Assert.assertTrue(manageuser.editLinkInGrid(1).isEnabled());
	    Assert.assertTrue(manageuser.deleteLinkInGrid(1).getAttribute("class").contains("disabled"));
	    Assert.assertTrue(gridManageUserPage.get(1).get("Resend Invitation").getAttribute("class").contains("disabled"));
	    Assert.assertTrue(gridManageUserPage.get(1).get("Impersonate").isEnabled());
	}
	
	@Test(priority = 12)
	public void verifyDeleteOptionIsDisabledForDealerEmpGenericWhenLoggedInAsSubAgent_35949() throws Exception {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage("a");
		manageuser.selectRoleTypeInGrid("DealerEmp");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    HashMap<Integer, HashMap<String, WebElement>> gridManageUserPage = manageuser.checkGridForLockImpersonateResendInvitationManageuser();
	    Assert.assertTrue(gridManageUserPage.get(1).get("Locked Out").isEnabled());
	    Assert.assertTrue(manageuser.editLinkInGrid(1).isEnabled());
	    Assert.assertTrue(manageuser.deleteLinkInGrid(1).getAttribute("class").contains("disabled"));
	    Assert.assertTrue(gridManageUserPage.get(1).get("Resend Invitation").getAttribute("class").contains("disabled"));
	    Assert.assertTrue(gridManageUserPage.get(1).get("Impersonate").isEnabled());
	}
	
	/* PBI 35496 starts from here*/
	
	@Test(priority = 13)
	public void verifyImpersonateAsGenericRoleBtnHiddenWhenLoggedInAsSubagent_36256() throws Exception {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage("Hansel Auto Group");
		Assert.assertTrue(manageuser.getUsersAndImpersonateAsGenericBtnsList().size() == 1);
	}
	
	@Test(priority = 14)
	public void verifyImpersonateIconDisabledForDealerGrpWhenLoggedInAsSubagent_36258() throws Exception {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage("Hansel Auto Group");
		manageuser.selectRoleTypeInGrid("DealerGroup");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    HashMap<Integer, HashMap<String, WebElement>> gridManageUserPage = manageuser.checkGridForLockImpersonateResendInvitationManageuser();
	    Assert.assertTrue(gridManageUserPage.get(1).get("Impersonate").getAttribute("class").contains("disabled"));
	}
	
	
	@Test(priority = 15)
	public void verifyImpersonateIconDisabledForDealerGrpEmpWhenLoggedInAsSubagent_36257() throws Exception {
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage("Hansel Auto Group");
		manageuser.selectRoleTypeInGrid("DealerGroupEmp");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    HashMap<Integer, HashMap<String, WebElement>> gridManageUserPage = manageuser.checkGridForLockImpersonateResendInvitationManageuser();
	    Assert.assertTrue(gridManageUserPage.get(1).get("Impersonate").getAttribute("class").contains("disabled"));
	}
	
	@Test(priority = 16)
	public void verifyImpersonateAsGenericRoleBtnHiddenWhenLoggedInAsAgent_35959() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage("Hansel Auto Group");
		Assert.assertTrue(manageuser.getUsersAndImpersonateAsGenericBtnsList().size() == 1);
	}
	
	@Test(priority = 17)
	public void verifyImpersonateIconDisabledForDealerGrpWhenLoggedInAsAgent_35960() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage("Hansel Auto Group");
		manageuser.selectRoleTypeInGrid("DealerGroup");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    HashMap<Integer, HashMap<String, WebElement>> gridManageUserPage = manageuser.checkGridForLockImpersonateResendInvitationManageuser();
	    Assert.assertTrue(gridManageUserPage.get(1).get("Impersonate").getAttribute("class").contains("disabled"));
	}
	
	
	@Test(priority = 18)
	public void verifyImpersonateIconDisabledForDealerGrpEmpWhenLoggedInAsAgent_35961() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		manageuser.selectDealerInmanageUserPage("Hansel Auto Group");
		manageuser.selectRoleTypeInGrid("DealerGroupEmp");
	    impersonate.getSearchBoxes().get("Email").sendKeys("generic");
	    HashMap<Integer, HashMap<String, WebElement>> gridManageUserPage = manageuser.checkGridForLockImpersonateResendInvitationManageuser();
	    Assert.assertTrue(gridManageUserPage.get(1).get("Impersonate").getAttribute("class").contains("disabled"));
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
