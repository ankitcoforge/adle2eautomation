package testsuite;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.LateralMenuAction;
import pageActions.PermissionsAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

/* PBI No: 30708 - Divyasree */
/* Total Tc's = 4 */
public class Permissions_test extends PermissionsAction {

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();

	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction();
	LateralMenuAction lateralMenu = new LateralMenuAction();

	@BeforeClass(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}

//	@Test(priority = 1)
//	public void verifyPermissionsPage_30720() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
//		Thread.sleep(3000);
//		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", "28771");
//		Thread.sleep(2000);
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage Employees");
//		Thread.sleep(2000);
//		Assert.assertTrue(utils.getTitle("Manage Employees").isDisplayed());
//	}

	@Test(priority = 2)
	public void verifyPermissionsPageForDealer() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Thread.sleep(3000);
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("My Settings", "Issue New User Registration");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Issue New User Registration").isDisplayed());
		String dealerEmp = prop.getProperty("dealerempAutomation");
		utils.inputfield("cssselector", txtFieldNewUserRegistration, dealerEmp);
		Thread.sleep(2000);
		utils.clickfield("xpath", editBtn);
		Thread.sleep(1000);
		Assert.assertTrue(getEditPermissions().isDisplayed());
		utils.clickfield("xpath", permissionsDropdownInPopup);

		getPermissionListInPopup().get(12).click();

		ArrayList<String> list = new ArrayList<String>();
		if (getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("false")) {
			getSelectAllCheckBoxInPopup().click();
		}
		if (getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("true")) {
			for (int i = 0; i < getPermissionListInPopup().size(); i++) {
				String selectedPermissionsInList = getPermissionListInPopup().get(i).getText();
				list.add(selectedPermissionsInList);
			}
			list.add("Cancellation History");
			list.add("Actuarials");
			list.add("Activations");
		}
		Collections.sort(list);
		System.out.println("list1:" + list);
		utils.clickfield("xpath", saveBtn);
		Thread.sleep(5000);
		login.logout();
		Thread.sleep(10000);
		login.login(dealerEmp, prop.getProperty("password"));
		Thread.sleep(3000);

		ArrayList<String> list2 = new ArrayList<String>();
		List<WebElement> subMenuItemsList = null;
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		list2.add(subMenuItemsList.get(0).getText());
		list2.add(subMenuItemsList.get(1).getText());

		verticalMenu.navigatetoLeftMainMenu("Contracts");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		for (int i = 0; i < subMenuItemsList.size(); i++) {
			String contracts = subMenuItemsList.get(i).getText();
			list2.add(contracts);
		}

		verticalMenu.navigatetoLeftMainMenu("Cancellations");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		for (int i = 0; i < subMenuItemsList.size(); i++) {
			String cancellations = subMenuItemsList.get(i).getText();
			list2.add(cancellations);
		}

		verticalMenu.navigatetoLeftMainMenu("Report");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		for (int i = 0; i < subMenuItemsList.size(); i++) {
			String reports = subMenuItemsList.get(i).getText();
			list2.add(reports);
		}

		verticalMenu.navigatetoLeftMainMenu("My Settings");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		for (int i = 1; i < subMenuItemsList.size(); i++) {
			String mySettings = subMenuItemsList.get(i).getText();
			list2.add(mySettings);
		}
		Collections.sort(list2);
		System.out.println("list1 size:" + list.size());
		System.out.println("list2 size:" + list2.size());
		System.out.println("list2:" + list2);
		assertTrue(list.equals(list2));

		Thread.sleep(5000);
		login.logout();
		Thread.sleep(10000);
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Issue New User Registration");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Issue New User Registration").isDisplayed());
		utils.inputfield("cssselector", txtFieldNewUserRegistration, dealerEmp);
		Thread.sleep(2000);
		utils.clickfield("xpath", editBtn);
		Thread.sleep(1000);
		Assert.assertTrue(getEditPermissions().isDisplayed());
		utils.clickfield("xpath", permissionsDropdownInPopup);

		if (getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("true")) {
			getSelectAllCheckBoxInPopup().click();
		}

		Assert.assertFalse(getCheckboxesPermissions().get(1).isSelected());
		utils.clickfield("xpath", saveBtn);
		Thread.sleep(5000);
		login.logout();
		Thread.sleep(10000);
		login.login(dealerEmp, prop.getProperty("password"));
		Thread.sleep(3000);

		List<WebElement> subMenuItemsList1 = null;
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertEquals(lateralMenu.getLaterMenuSubItems().size(), 0);

		verticalMenu.navigatetoLeftMainMenu("Contracts");
		subMenuItemsList1 = lateralMenu.getLaterMenuSubItems();
		Assert.assertEquals(subMenuItemsList1.size(), 0);

		verticalMenu.navigatetoLeftMainMenu("Cancellations");
		subMenuItemsList1 = lateralMenu.getLaterMenuSubItems();
		Assert.assertEquals(subMenuItemsList1.size(), 0);

		verticalMenu.navigatetoLeftMainMenu("Report");
		subMenuItemsList1 = lateralMenu.getLaterMenuSubItems();
		Assert.assertEquals(subMenuItemsList1.size(), 0);

		verticalMenu.navigatetoLeftMainMenu("My Settings");
		subMenuItemsList1 = lateralMenu.getLaterMenuSubItems();
		Assert.assertEquals(subMenuItemsList1.size(), 1);
	}

	@Test(priority = 3)
	public void verifyPermissionsPageForAgent() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		Thread.sleep(3000);
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Agency Settings", "Manage Users");
		Thread.sleep(2000);
		// Assert.assertTrue(utils.getTitle("Issue New User
		// Registration").isDisplayed());
		String subAgent = prop.getProperty("subagentAutomation");
		utils.inputfield("cssselector", txtFieldNewUserRegistration, subAgent);
		Thread.sleep(2000);
		utils.clickfield("xpath", editBtn);
		Thread.sleep(1000);
		Assert.assertTrue(getEditPermissions().isDisplayed());
		utils.clickfield("xpath", permissionsDropdownInAgentPopup);

		ArrayList<String> list = new ArrayList<String>();
		if (getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("false")) {
			getSelectAllCheckBoxInPopup().click();
		}
		Assert.assertTrue((getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("true")));
		String commissionsInPermissionPopup = getPermissionListInPopup().get(0).getText();

		utils.clickfield("xpath", saveBtn);
		Thread.sleep(5000);
		login.logout();
		Thread.sleep(10000);
		login.login(subAgent, prop.getProperty("password"));
		Thread.sleep(3000);

		verticalMenu.navigatetoLeftMainMenu("Report");
		String myCommissionsInLateralMenu = lateralMenu.getLaterMenuSubItems().get(0).getText();
		assertTrue(commissionsInPermissionPopup.equals(myCommissionsInLateralMenu));

		Thread.sleep(5000);
		login.logout();
		Thread.sleep(10000);
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoLeftMenu("Agency Settings", "Manage Users");
		Thread.sleep(2000);
		utils.inputfield("cssselector", txtFieldNewUserRegistration, subAgent);
		Thread.sleep(2000);
		utils.clickfield("xpath", editBtn);
		Thread.sleep(1000);
		Assert.assertTrue(getEditPermissions().isDisplayed());
		utils.clickfield("xpath", permissionsDropdownInAgentPopup);

		if (getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("true")) {
			getSelectAllCheckBoxInPopup().click();
		}

		Assert.assertFalse(getCheckboxesPermissions().get(0).isSelected());
		utils.clickfield("xpath", saveBtn);
		Thread.sleep(5000);
		login.logout();
		Thread.sleep(10000);
		login.login(subAgent, prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoLeftMainMenu("Report");
		String reportSubmenu = lateralMenu.getLaterMenuSubItems().get(0).getText();
		assertTrue(!reportSubmenu.contains("My Commissions"));
	}

	@Test(priority = 4)
	public void verifyPermissionsPageForLender() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		Thread.sleep(3000);
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Lender Settings", "Manage Users");
		Thread.sleep(2000);
		String lenderEmp = prop.getProperty("lenderempAutomation");
		utils.inputfield("cssselector", txtFieldNewUserRegistration, lenderEmp);
		Thread.sleep(2000);
		utils.clickfield("xpath", editBtn);
		Thread.sleep(1000);
		// Assert.assertTrue(getEditPermissions().isDisplayed());
		utils.clickfield("xpath", permissionsDropdownInAgentPopup);

		getPermissionListInPopup().get(12).click();

		ArrayList<String> list = new ArrayList<String>();
		if (getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("false")) {
			getSelectAllCheckBoxInPopup().click();
		}
		if (getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("true")) {
			for (int i = 0; i < getPermissionListInPopup().size(); i++) {
				String selectedPermissionsInList = getPermissionListInPopup().get(i).getText();
				list.add(selectedPermissionsInList);
			}
			list.add("Cancellation History");
			list.add("Actuarials");
			list.add("Activations");
		}
		Collections.sort(list);
		System.out.println("list1:" + list);
		utils.clickfield("xpath", updateBtn);
		Thread.sleep(5000);
		login.logout();
		Thread.sleep(10000);
		login.login(lenderEmp, prop.getProperty("password"));
		Thread.sleep(3000);

		ArrayList<String> list2 = new ArrayList<String>();
		List<WebElement> subMenuItemsList = null;

		verticalMenu.navigatetoLeftMainMenu("Contracts");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		for (int i = 0; i < subMenuItemsList.size(); i++) {
			String contracts = subMenuItemsList.get(i).getText();
			list2.add(contracts);
		}

		verticalMenu.navigatetoLeftMainMenu("Cancellations");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		for (int i = 0; i < subMenuItemsList.size(); i++) {
			String cancellations = subMenuItemsList.get(i).getText();
			list2.add(cancellations);
		}

		verticalMenu.navigatetoLeftMainMenu("Report");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		for (int i = 0; i < subMenuItemsList.size(); i++) {
			String reports = subMenuItemsList.get(i).getText();
			list2.add(reports);
		}

		verticalMenu.navigatetoLeftMainMenu("My Settings");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		for (int i = 1; i < subMenuItemsList.size(); i++) {
			String mySettings = subMenuItemsList.get(i).getText();
			list2.add(mySettings);
			list2.remove("Manage My Lender Packs");
		}

		verticalMenu.navigatetoLeftMainMenu("Lender Settings");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		list2.add(subMenuItemsList.get(0).getText());

		Collections.sort(list2);
		System.out.println("list1 size:" + list.size());
		System.out.println("list2 size:" + list2.size());
		System.out.println("list2:" + list2);
		assertTrue(list.equals(list2));

		Thread.sleep(5000);
		login.logout();
		Thread.sleep(10000);
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoLeftMenu("Lender Settings", "Manage Users");
		Thread.sleep(2000);
		utils.inputfield("cssselector", txtFieldNewUserRegistration, lenderEmp);
		Thread.sleep(2000);
		utils.clickfield("xpath", editBtn);
		Thread.sleep(1000);
		utils.clickfield("xpath", permissionsDropdownInAgentPopup);

		if (getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("true")) {
			getSelectAllCheckBoxInPopup().click();
		}

		Assert.assertFalse(getCheckboxesPermissions().get(1).isSelected());
		utils.clickfield("xpath", updateBtn);
		Thread.sleep(5000);
		login.logout();
		Thread.sleep(10000);
		login.login(lenderEmp, prop.getProperty("password"));
		Thread.sleep(3000);

		List<WebElement> subMenuItemsList1 = null;

		verticalMenu.navigatetoLeftMainMenu("Contracts");
		subMenuItemsList1 = lateralMenu.getLaterMenuSubItems();
		Assert.assertEquals(subMenuItemsList1.size(), 0);

		verticalMenu.navigatetoLeftMainMenu("Cancellations");
		subMenuItemsList1 = lateralMenu.getLaterMenuSubItems();
		Assert.assertEquals(subMenuItemsList1.size(), 0);

		verticalMenu.navigatetoLeftMainMenu("Report");
		subMenuItemsList1 = lateralMenu.getLaterMenuSubItems();
		Assert.assertEquals(subMenuItemsList1.size(), 0);

		verticalMenu.navigatetoLeftMainMenu("My Settings");
		subMenuItemsList1 = lateralMenu.getLaterMenuSubItems();
		Assert.assertEquals(subMenuItemsList1.size(), 2,
				"By default 2 permissions are preesent for lender in My settings");

		verticalMenu.navigatetoLeftMainMenu("Lender Settings");
		subMenuItemsList1 = lateralMenu.getLaterMenuSubItems();
		Assert.assertEquals(subMenuItemsList1.size(), 0);
	}

	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		try {
			login.logout();
			} catch (Exception e) {
		}
	}
}
