package testsuite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
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
	public void verifyRestoreUsersPage_34678() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
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

	
}
