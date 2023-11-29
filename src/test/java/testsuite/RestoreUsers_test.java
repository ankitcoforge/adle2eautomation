package testsuite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageActions.LateralMenuAction;
import pageActions.RestoreUsersAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

/* PBI 32625 */
public class RestoreUsers_test extends RestoreUsersAction{

	
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	Impersonate_test impersonate = new Impersonate_test();
//	ManageUsersPage_test ManageUserPage=new ManageUsersPage_test();
//	ManageVSC_GAPprefrences_test ManageVSCGAPprefrences=new ManageVSC_GAPprefrences_test();
	 LateralMenuAction VerticalMenu=new LateralMenuAction();

	@BeforeClass(alwaysRun=true)
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
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", impersonate.headerLoc);
		ArrayList<String> headersList = new ArrayList<String>();
		for (int i = 0; i < allHeaderNames.size(); i++) {
			headersList.add(allHeaderNames.get(i));
	}
		Assert.assertTrue(headersList.contains("First Name"));
		Assert.assertTrue(headersList.contains("Last Name"));
		Assert.assertTrue(headersList.contains("Username"));
		Assert.assertTrue(headersList.contains("Email"));
		Assert.assertTrue(headersList.contains("Role Name"));
		Assert.assertTrue(headersList.contains("PIN"));
		Assert.assertTrue(headersList.contains("Action"));
	}
	
	
	@Test(priority = 2)
	public void verifySearchFunctionality_34724() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		selectDealerInmanageUserPage("28771");
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		String  firstName  = allTableData.get(1).get("First Name");
		getSearchBoxes().get("First Name").sendKeys(firstName);
		String firstNameInGrid = allTableData.get(1).get("First Name");
		Assert.assertTrue(firstNameInGrid.contains(firstName));
		getSearchBoxes().get("First Name").clear();
		String  lastName  = allTableData.get(1).get("Last Name");
		getSearchBoxes().get("Last Name").sendKeys(lastName);
		String lastNameInGrid = allTableData.get(1).get("Last Name");
		Assert.assertTrue(lastNameInGrid.contains(lastName));
		getSearchBoxes().get("Last Name").clear();
		String  username  = allTableData.get(1).get("Username");
		getSearchBoxes().get("Username").sendKeys(username);
		String usernameInGrid = allTableData.get(1).get("Username");
		Assert.assertTrue(usernameInGrid.contains(username));
		getSearchBoxes().get("Username").clear();
		String  email  = allTableData.get(1).get("Email");
		getSearchBoxes().get("Email").sendKeys(email);
		String emailInGrid = allTableData.get(1).get("Email");
		Assert.assertTrue(emailInGrid.contains(email));
		getSearchBoxes().get("Email").clear();
		String roleName  = allTableData.get(1).get("Role Name");
		VerticalMenu.selectRoleType(roleName);
		String roleNameInGrid = allTableData.get(1).get("Role Name");
		Assert.assertTrue(roleNameInGrid.contains(roleName));
		//deselected in below step
		VerticalMenu.selectRoleType(roleName);
		String  pin  = allTableData.get(1).get("PIN");
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
		selectDealerInmanageUserPage("22723");
		utils.waitTillElementIsClickableByWebEle(getArrow("First Name"));
		getArrow("First Name").click();
		HashMap<Integer, HashMap<String, String>> allTableDataForFirstName = checkGridBodyDetails();
		ArrayList<String> firtsNameList = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstName = allTableDataForFirstName.get(i).get("First Name");
			firtsNameList.add(firstName);
		}
		ArrayList<String> FirstNameListBeforeSort = firtsNameList;
		System.out.println("firtsNameList before sort---"+FirstNameListBeforeSort);
		Collections.sort(firtsNameList);
		System.out.println("firtsNameList after sort---"+firtsNameList);
		Assert.assertEquals(FirstNameListBeforeSort,firtsNameList);
		
		utils.waitTillElementIsClickableByWebEle(getArrow("First Name"));
		getArrow("First Name").click();
		HashMap<Integer, HashMap<String, String>> allTableDataForFirstNameOnArrowClick2 = checkGridBodyDetails();
		ArrayList<String> firtsNameListOnArrowClick2 = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String firstName = allTableDataForFirstNameOnArrowClick2.get(i).get("First Name");
			firtsNameListOnArrowClick2.add(firstName);
		}
		ArrayList<String> ObtainedList = firtsNameListOnArrowClick2;
		Collections.sort(firtsNameListOnArrowClick2);
		Collections.reverse(firtsNameListOnArrowClick2);
		Assert.assertTrue(ObtainedList.equals(firtsNameListOnArrowClick2));
		
		getArrow("Last Name").click();
		HashMap<Integer, HashMap<String, String>> allTableDataForLastName = checkGridBodyDetails();
		ArrayList<String> LastNameList = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastName = allTableDataForLastName.get(i).get("Last Name");
			LastNameList.add(lastName);
		}
		ArrayList<String> lastNameListBeforeSort = LastNameList;
		Collections.sort(LastNameList);
		Assert.assertEquals(lastNameListBeforeSort,LastNameList);
		
		utils.waitTillElementIsClickableByWebEle(getArrow("Last Name"));
		getArrow("Last Name").click();
		HashMap<Integer, HashMap<String, String>> allTableDataForLastNameOnArrowClick2 = checkGridBodyDetails();
		ArrayList<String> lastNameListOnArrowClick2 = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String lastName = allTableDataForLastNameOnArrowClick2.get(i).get("Last Name");
			lastNameListOnArrowClick2.add(lastName);
		}
		ArrayList<String> ObtainedListLastName = lastNameListOnArrowClick2;
		Collections.sort(lastNameListOnArrowClick2);
		Collections.reverse(lastNameListOnArrowClick2);
		Assert.assertTrue(ObtainedListLastName.equals(lastNameListOnArrowClick2));
		
		//Username sorting
		getArrow("Username").click();
		HashMap<Integer, HashMap<String, String>> allTableDataForUsername = checkGridBodyDetails();
		ArrayList<String> usernameList = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String userName = allTableDataForUsername.get(i).get("Username");
			usernameList.add(userName);
		}
		ArrayList<String> userNameListBeforeSort = usernameList;
		Collections.sort(usernameList);
		Assert.assertEquals(userNameListBeforeSort,usernameList);
		
		utils.waitTillElementIsClickableByWebEle(getArrow("Username"));
		getArrow("Username").click();
		HashMap<Integer, HashMap<String, String>> allTableDataForUserNameOnArrowClick2 = checkGridBodyDetails();
		ArrayList<String> usernameListOnArrowClick2 = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String userName = allTableDataForUserNameOnArrowClick2.get(i).get("Username");
			usernameListOnArrowClick2.add(userName);
		}
		ArrayList<String> ObtainedListUsername = usernameListOnArrowClick2;
		Collections.sort(usernameListOnArrowClick2);
		Collections.reverse(usernameListOnArrowClick2);
		Assert.assertTrue(ObtainedListUsername.equals(usernameListOnArrowClick2));
		
		//Email sorting
				verifysorting("Email");
				verifysorting("Role Name");
				verifysorting("PIN");
				
	}
	
	@Test(priority = 4)
	public void verifyNoUsersDisplayWhenNoUsersDeleted_35384() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		selectDealerInmanageUserPage("15405");
		Assert.assertTrue(utils.element("xpath", noRecordsToDisplay).isDisplayed());
	}
	
	@Test(priority = 5)
	public void verifyConfirmationPopupWhenClickedOnRestoreIcon_34706_34709() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		selectDealerInmanageUserPage("22723");
		if (getRowLoc().size() > 1) {
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String  firstName  = allTableData.get(1).get("First Name");
			restoreIcon(1).click();
			Assert.assertTrue(utils.getfield("h3", "Are you sure you want to restore the selected user?").isDisplayed());
			Assert.assertTrue(utils.getfield("span", "Yes").isDisplayed());
			Assert.assertTrue(utils.getfield("span", "No").isDisplayed());
			Assert.assertTrue(utils.getfield("mat-icon", "close").isDisplayed());
			utils.getfield("span", "No").click();
			HashMap<Integer, HashMap<String, String>> allTableData1 = checkGridBodyDetails();
			String  firstNameAfterclosingThePopup  = allTableData1.get(1).get("First Name");
			Assert.assertEquals(firstName, firstNameAfterclosingThePopup);
		}
	}
	
	@Test(priority = 5)
	public void verifyRestoredUserInImpersonateGrid_34713() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		selectDealerInmanageUserPage("22723");
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String  emailInRestoreUserPage  = allTableData.get(2).get("Email");
			restoreIcon(2).click();
			utils.getfield("span", "Yes").click();
			verticalMenu.navigatetoimpersonate();
			impersonate.getUsers("Dealer", "22723");
//			allTableDataInImpersonatePagee.get(0).get("Email");
			HashMap<Integer, HashMap<String, String>> allTableDataInImpersonatePagee = impersonate.checkGridBodyDetails();
			getSearchBoxes().get("Email").sendKeys(emailInRestoreUserPage);
			String emailInImpersonatePage = allTableDataInImpersonatePagee.get(1).get("Email");
			Assert.assertEquals(emailInRestoreUserPage, emailInImpersonatePage);
	}
	
	@Test(priority = 6)
	public void verifyUserNotRestoredWhenConfirmationPopupClosed_34708() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		selectDealerInmanageUserPage("22723");
		if (getRowLoc().size() > 1) {
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String  firstName  = allTableData.get(1).get("First Name");
			restoreIcon(1).click();
			Assert.assertTrue(utils.getfield("h3", "Are you sure you want to restore the selected user?").isDisplayed());
			Assert.assertTrue(utils.getfield("span", "Yes").isDisplayed());
			Assert.assertTrue(utils.getfield("span", "No").isDisplayed());
			Assert.assertTrue(utils.getfield("mat-icon", "close").isDisplayed());
			utils.getfield("mat-icon", "close").click();
			HashMap<Integer, HashMap<String, String>> allTableData1 = checkGridBodyDetails();
			String  firstNameAfterclosingThePopup  = allTableData1.get(1).get("First Name");
			Assert.assertEquals(firstName, firstNameAfterclosingThePopup);
		}
	}
	
}
