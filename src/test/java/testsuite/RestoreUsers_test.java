package testsuite;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageActions.LateralMenuAction;
import pageActions.RestoreUsersAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

/* PBI 32625 35373*/
/*Tc's=16*/
public class RestoreUsers_test extends RestoreUsersAction {

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	Impersonate_test impersonate = new Impersonate_test();
	LateralMenuAction VerticalMenu = new LateralMenuAction();

	@BeforeClass(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}
	

	@Test(priority = 1)
	public void verifyRestoreUsersPage_34678_34676() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertTrue(utils.getfield("a", "Restore Users").isDisplayed());
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		Assert.assertTrue(getHeaderList().contains("First Name"));
		Assert.assertTrue(getHeaderList().contains("Last Name"));
		Assert.assertTrue(getHeaderList().contains("Username"));
		Assert.assertTrue(getHeaderList().contains("Email"));
		Assert.assertTrue(getHeaderList().contains("Role Name"));
		Assert.assertTrue(getHeaderList().contains("PIN"));
		Assert.assertTrue(getHeaderList().contains("Action"));
	}

	@Test(priority = 2)
	public void verifySearchFunctionality_34724() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		String accountName = getDeletedUsersDateFromDB().get(1).get("NAME");
		String roleName = getDeletedUsersDateFromDB().get(1).get("roleName");
		selectDealerInmanageUserPage(accountName);
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		String firstName = allTableData.get(1).get("First Name");
		getSearchBoxes().get("First Name").sendKeys(firstName);
		String firstNameInGrid = allTableData.get(1).get("First Name");
		Assert.assertTrue(firstNameInGrid.contains(firstName));
		getSearchBoxes().get("First Name").clear();
		String lastName = allTableData.get(1).get("Last Name");
		getSearchBoxes().get("Last Name").sendKeys(lastName);
		String lastNameInGrid = allTableData.get(1).get("Last Name");
		Assert.assertTrue(lastNameInGrid.contains(lastName));
		getSearchBoxes().get("Last Name").clear();
		String username = allTableData.get(1).get("Username");
		getSearchBoxes().get("Username").sendKeys(username);
		String usernameInGrid = allTableData.get(1).get("Username");
		Assert.assertTrue(usernameInGrid.contains(username));
		getSearchBoxes().get("Username").clear();
		String email = allTableData.get(1).get("Email");
		getSearchBoxes().get("Email").sendKeys(email);
		String emailInGrid = allTableData.get(1).get("Email");
		Assert.assertTrue(emailInGrid.contains(email));
		getSearchBoxes().get("Email").clear();
		VerticalMenu.selectRoleType(roleName);
		String roleNameInGrid = allTableData.get(1).get("Role Name");
		Assert.assertTrue(roleNameInGrid.contains(roleName));
		// deselected in below step
		VerticalMenu.selectRoleType(roleName);
		String pin = allTableData.get(1).get("PIN");
		getPINSearchBox().get("PIN").sendKeys(pin);
		String pinnGrid = allTableData.get(1).get("PIN");
		Assert.assertTrue(pinnGrid.contains(pin));
		getPINSearchBox().get("PIN").clear();
	}

	@Test(priority = 3)
	public void verifySortingFunctionality_34723() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		String accountName = getDeletedUsersDateFromDB().get(1).get("NAME");
		selectDealerInmanageUserPage(accountName);
		utils.waitTillElementIsClickableByWebEle(getArrow("First Name"));
		verifysorting("First Name");
		verifysorting("Last Name");
		verifysorting("Username");
		verifysorting("Email");
		verifysorting("Role Name");
		verifysorting("PIN");
	}

	@Test(priority = 4)
	public void verifyNoUsersDisplayWhenNoUsersDeleted_35384() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		selectDealerWithOutWaitTime("15405");
		Assert.assertTrue(utils.element("xpath", noRecordsToDisplay).isDisplayed());
	}

	@Test(priority = 5)
	public void verifyConfirmationPopupWhenClickedOnRestoreIconAndThenClickedOnNo_34706_34709() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		String accountName = getDeletedUsersDateFromDB().get(1).get("NAME");
		selectDealerInmanageUserPage(accountName);
		if (getRowLoc().size() > 1) {
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String firstName = allTableData.get(1).get("First Name");
			restoreIcon(1).click();
			Assert.assertTrue(utils.getfield("h3", "Are you sure you want to restore the selected user?").isDisplayed());
			Assert.assertTrue(utils.getfield("span", "Yes").isDisplayed());
			Assert.assertTrue(utils.getfield("span", "No").isDisplayed());
			Assert.assertTrue(utils.getfield("mat-icon", "close").isDisplayed());
			utils.getfield("span", "No").click();
			HashMap<Integer, HashMap<String, String>> allTableData1 = checkGridBodyDetails();
			String firstNameAfterclosingThePopup = allTableData1.get(1).get("First Name");
			Assert.assertEquals(firstName, firstNameAfterclosingThePopup);
		}
	}

	@Test(priority = 6,enabled= false)
	public void verifyRestoredUserInImpersonateGrid_34713_34707() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		String accountName = getDeletedUsersDateFromDB().get(1).get("NAME");
		String roleName = getDeletedUsersDateFromDB().get(1).get("roleName");
		selectDealerInmanageUserPage(accountName);
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		String emailInRestoreUserPage = allTableData.get(2).get("Email");
		restoreIcon(2).click();
		utils.getfield("span", "Yes").click();
		utils.waitTillElementIsClickableByWebEle(utils.getfield("div", "User has been restored!"));
		Assert.assertTrue(utils.getfield("div", "User has been restored!").isDisplayed());
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers(roleName, accountName);
		getSearchBoxes().get("Email").sendKeys(emailInRestoreUserPage);
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, String>> allTableDataInImpersonatePagee = impersonate.checkGridBodyDetails();
		String emailInImpersonatePage = allTableDataInImpersonatePagee.get(1).get("Email");
		Assert.assertEquals(emailInRestoreUserPage, emailInImpersonatePage);
		HashMap<Integer, HashMap<String, WebElement>> editDelLockinImpersonatePage = impersonate
				.checkGridForEditDelLock();
		editDelLockinImpersonatePage.get(1).get("Delete").click();
		utils.getfield("span", "Yes").click();
		utils.waitTillElementIsClickableByWebEle(
				utils.getfield("div", "The user account has been deleted successfully"));
		Assert.assertTrue(utils.getfield("div", "The user account has been deleted successfully").isDisplayed());
		Assert.assertTrue(utils.getfield("td", "There are no records to display").isDisplayed());
	}

	@Test(priority = 7)
	public void verifyUserNotRestoredWhenConfirmationPopupClosed_34708() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		String accountName = getDeletedUsersDateFromDB().get(1).get("NAME");
		selectDealerInmanageUserPage(accountName);
		if (getRowLoc().size() > 1) {
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String firstName = allTableData.get(1).get("First Name");
			restoreIcon(1).click();
			Assert.assertTrue(
					utils.getfield("h3", "Are you sure you want to restore the selected user?").isDisplayed());
			Assert.assertTrue(utils.getfield("span", "Yes").isDisplayed());
			Assert.assertTrue(utils.getfield("span", "No").isDisplayed());
			Assert.assertTrue(utils.getfield("mat-icon", "close").isDisplayed());
			utils.getfield("mat-icon", "close").click();
			HashMap<Integer, HashMap<String, String>> allTableData1 = checkGridBodyDetails();
			String firstNameAfterclosingThePopup = allTableData1.get(1).get("First Name");
			Assert.assertEquals(firstName, firstNameAfterclosingThePopup);
		}
	}
	
	@Test(priority = 8, enabled = false)
	public void verifyRegistrationStatusAftrRestoringAccount_34710() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		String accountName = getDeletedUsersDateFromDB().get(1).get("NAME");
		String roleName = getDeletedUsersDateFromDB().get(1).get("roleName");
		selectDealerInmanageUserPage(accountName);
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		String firstNameInRestoreUserPage = allTableData.get(1).get("First Name");
		String lastNameInRestoreUserPage = allTableData.get(1).get("Last Name");
		String usernameInRestoreUserPage = allTableData.get(1).get("Username");
		String emailInRestoreUserPage = allTableData.get(1).get("Email");
		String roleNameInRestoreUserPage = allTableData.get(1).get("Role Name");
		String pinInRestoreUserPage = allTableData.get(1).get("PIN");
		restoreIcon(1).click();
		utils.getfield("span", "Yes").click();
		utils.waitTillElementIsClickableByWebEle(utils.getfield("div", "User has been restored!"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers(roleName, accountName);
		getSearchBoxes().get("Email").sendKeys(emailInRestoreUserPage);
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, String>> allTableDataInImpersonatePagee = impersonate.checkGridBodyDetails();
		String firstNameInImpersonatePage = allTableDataInImpersonatePagee.get(1).get("First Name");
		String lastNameInImpersonatePage = allTableDataInImpersonatePagee.get(1).get("Last Name");
		String userNameInImpersonatePage = allTableDataInImpersonatePagee.get(1).get("Username");
		String emailInImpersonatePage = allTableDataInImpersonatePagee.get(1).get("Email");
		String roleTypeInImpersonatePage = allTableDataInImpersonatePagee.get(1).get("Role Type");
		String pinInImpersonatePage = allTableDataInImpersonatePagee.get(1).get("PIN");
		String registrationStatusInImpersonatePage = allTableDataInImpersonatePagee.get(1).get("Registration Status");
		//validation
		Assert.assertEquals(firstNameInRestoreUserPage, firstNameInImpersonatePage);
		Assert.assertEquals(lastNameInRestoreUserPage, lastNameInImpersonatePage);
		Assert.assertEquals(usernameInRestoreUserPage, userNameInImpersonatePage);
		Assert.assertEquals(emailInRestoreUserPage, emailInImpersonatePage);
		Assert.assertEquals(roleNameInRestoreUserPage, roleTypeInImpersonatePage);
		Assert.assertEquals(pinInRestoreUserPage, pinInImpersonatePage);
		Assert.assertTrue(registrationStatusInImpersonatePage.equals("Pending"));
		HashMap<Integer, HashMap<String, WebElement>> editDelLockinImpersonatePage = impersonate
				.checkGridForEditDelLock();
		editDelLockinImpersonatePage.get(1).get("Delete").click();
		utils.getfield("span", "Yes").click();
		utils.waitTillElementIsClickableByWebEle(getUserAccountHasBeenDeletedSuccessfully());
		Assert.assertTrue(getUserAccountHasBeenDeletedSuccessfully().isDisplayed());
		Assert.assertTrue(utils.getfield("td", "There are no records to display").isDisplayed());
	}
	
	@Test(priority = 9)
	public void verifyUsersDeletedInLast30daysAreShownInGrid_34679() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertTrue(utils.getfield("a", "Restore Users").isDisplayed());
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		String accountName = getDeletedUsersDateFromDB().get(1).get("NAME");
		selectDealerInmanageUserPage(accountName);
		Assert.assertTrue(getRowLoc().size()>=1);
	}
	
	//bug
	@Test(priority = 10,enabled = false)
	public void verifyTheUserDeletedAndRestoredAreNotInShownInGrid_35245() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		String accountName = getDeletedUsersDateFromDB().get(1).get("NAME");
		String roleName = getDeletedUsersDateFromDB().get(1).get("roleName");
		selectDealerInmanageUserPage(accountName);
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		String emailBeoreRestoring= allTableData.get(2).get("Email");
		restoreIcon(2).click();
		utils.getfield("span", "Yes").click();
		utils.waitTillElementIsClickableByWebEle(utils.getfield("div", "User has been restored!"));
		Assert.assertTrue(utils.getfield("div", "User has been restored!").isDisplayed());
		Thread.sleep(1000);
		HashMap<Integer, HashMap<String, String>> allTableData1 = checkGridBodyDetails();
		for(int i=1;i<getRowLoc().size();i++) {
		String emailsAftrRestoringAccount = allTableData1.get(i).get("Email");
		Assert.assertFalse(emailsAftrRestoringAccount.contains(emailBeoreRestoring));
		}
		//deleting again as a precond
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers(roleName, accountName);
		getSearchBoxes().get("Email").sendKeys(emailBeoreRestoring);
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, String>> allTableDataInImpersonatePagee = impersonate.checkGridBodyDetails();
		String emailInImpersonatePage = allTableDataInImpersonatePagee.get(1).get("Email");
		Assert.assertEquals(emailBeoreRestoring, emailInImpersonatePage);
		HashMap<Integer, HashMap<String, WebElement>> editDelLockinImpersonatePage = impersonate
				.checkGridForEditDelLock();
		editDelLockinImpersonatePage.get(1).get("Delete").click();
		utils.getfield("span", "Yes").click();
		utils.waitTillElementIsClickableByWebEle(
				utils.getfield("div", "The user account has been deleted successfully"));
		Assert.assertTrue(utils.getfield("div", "The user account has been deleted successfully").isDisplayed());
	}
	
	@Test(priority = 11)
	public void verifyRestoreUsersPageForAndroid_34735() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertTrue(utils.getfield("a", "Restore Users").isDisplayed());
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
	}
	
	@Test(priority = 12)
	public void verifyRestoreUsersPageForIOS_34734() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertTrue(utils.getfield("a", "Restore Users").isDisplayed());
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
	}
	
	@Test(priority = 13)
	public void verifyRegisteredUserIsDeletedAndReflectedInDB_35402() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertTrue(utils.getfield("a", "Restore Users").isDisplayed());
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Dealer", "22723");
		getSelectStatusAsCompleted();
		HashMap<Integer, HashMap<String, String>> allTableDataInImpersonatePagee = impersonate.checkGridBodyDetails();
		String emailInImpersonatePage = allTableDataInImpersonatePagee.get(2).get("Email");
		HashMap<Integer, HashMap<String, WebElement>> editDelLockinImpersonatePage = impersonate
				.checkGridForEditDelLock();
		editDelLockinImpersonatePage.get(2).get("Delete").click();
		utils.getfield("span", "Yes").click();
		utils.waitTillElementIsClickableByWebEle(
				utils.getfield("div", "The user account has been deleted successfully"));
		Assert.assertTrue(utils.getfield("div", "The user account has been deleted successfully").isDisplayed());
		System.out.println("del users data-"+getAllDeletedUsersFromDB());
		for(int i=1;i<6;i++) {
		String deletedUser = getAllDeletedUsersFromDB().get(i).get("UserName");
		System.out.println("userName-"+deletedUser);
		if (deletedUser.contains(emailInImpersonatePage)) {
			Assert.assertTrue(deletedUser.contains("_DELETED"));
			break;
		}
		}
		Thread.sleep(2000);
		//precond
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		selectDealerInmanageUserPage("22723");
		getSearchBoxes().get("Email").sendKeys(emailInImpersonatePage);
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, String>> allTableDataInRestoreUsersPage = checkGridBodyDetails();
		String emailInRestoreUserPage = allTableDataInRestoreUsersPage.get(1).get("Email");
		Assert.assertEquals(emailInRestoreUserPage, emailInImpersonatePage);
		restoreIcon(1).click();
		utils.getfield("span", "Yes").click();
	}
	
	

	

	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		try {
			login.logout();
		} catch (Exception e) {
			utils.getfield("mat-icon", "close").click();
			login.logout();
		}
	}

}
