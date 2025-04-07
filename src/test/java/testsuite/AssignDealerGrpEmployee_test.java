 package testsuite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.AssignDealerGrpEmployeeAction;
import pageActions.PermissionsAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

/* PBI 34764 */
/*implemented by Divyasree*/

public class AssignDealerGrpEmployee_test extends AssignDealerGrpEmployeeAction {

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction();
//	ManageUsersPage_test manageuser = new ManageUsersPage_test();
	PermissionsAction permissions = new PermissionsAction();

	@BeforeClass(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}

	@Test(priority = 1)
	public void verifyDealerIsAssignedToDealerGrpEmp_34859() throws Exception {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMainMenu("My Settings");
		List<WebElement> subItems = verticalMenu.getLaterMenuSubItems();
		Assert.assertTrue(subItems.get(0).getText().equals("Manage My Profile"));
		Assert.assertTrue(subItems.get(1).getText().equals("Manage My Dealer Group Employees"));
		Assert.assertTrue(subItems.get(2).getText().equals("Assign Dealer to Dealer Group Employee"));
		Assert.assertTrue(subItems.get(3).getText().equals("Manage My Pricing Preferences"));
		Assert.assertTrue(subItems.get(4).getText().equals("Manage VSC - GAP Preferences"));
		Assert.assertTrue(subItems.get(5).getText().equals("Manage My Dealer Packs"));
		verticalMenu.navigatetoLeftMenu("Assign Dealer to Dealer Group Employee");
		Assert.assertTrue(utils.getfield("h3", "Assign Dealer to Dealer Group Employee").isDisplayed());
		Assert.assertTrue(utils.getfield("td", "There are no records to display").isDisplayed());
		selectdealerGrpEmpInDropDown(prop.getProperty("dealergrpempAutomation"));
		utils.element("xpath", arrowForwardInassignDealerToDealerGrpEmpPage).click();
		utils.waitTillElementIsClickable(addDealer);
		utils.element("xpath", addDealer).click();
		utils.waitTillElementIsClickable(selectDealerArrow);
		utils.element("xpath", selectDealerArrow).click();
		Thread.sleep(2000);
		if (!permissions.getSelectAllCheckBoxInPopup().isSelected()) {
			permissions.getSelectAllCheckBoxInPopup().click();
		}
		utils.element("xpath", btnClose).click();
		if (utils.element("xpath", permissions.saveBtn).isEnabled()) {
			utils.clickfield("xpath", permissions.saveBtn);
		} else {
			utils.clickfield("xpath", permissions.cancelBtn);
		}
		Thread.sleep(2000);
		Assert.assertTrue(getRows().size() > 1);
	}

	@Test(priority = 3)
	public void verifyNoDealerIsDeletedAftrClickingNoBtn_34864() throws Exception {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Assign Dealer to Dealer Group Employee");
		Assert.assertTrue(utils.getfield("h3", "Assign Dealer to Dealer Group Employee").isDisplayed());
		Assert.assertTrue(utils.getfield("td", "There are no records to display").isDisplayed());
		selectdealerGrpEmpInDropDown(prop.getProperty("dealergrpempAutomation"));
		utils.element("xpath", arrowForwardInassignDealerToDealerGrpEmpPage).click();
		Thread.sleep(1000);
		utils.waitTillElementIsClickable(addDealer);
		Assert.assertTrue(getRows().size() > 1);
		int rowsBefore = getRows().size();
		HashMap<Integer, HashMap<String, String>> grid = assignDealerToDealerGrpEmpPageGrid();
		String dealerNamebeforeDeletion = grid.get(1).get("Dealer Name");
		System.out.println("Dealer Name---" + dealerNamebeforeDeletion);
		selectCheckBoxForRow(1).click();
		utils.getfield("a", "Delete").click();
		utils.element("xpath", btnNo).click();
		String dealerNameAfter = grid.get(1).get("Dealer Name");
		int rowsAfter = getRows().size();
		Assert.assertTrue(dealerNamebeforeDeletion.equals(dealerNameAfter));
		Assert.assertTrue(rowsBefore == rowsAfter);
	}

	@Test(priority = 4, dependsOnMethods = "verifyDealerIsAssignedToDealerGrpEmp_34859")
	public void verifyDealerIsDeletedAftrClickingYesBtn_34863() throws Exception {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Assign Dealer to Dealer Group Employee");
		Assert.assertTrue(utils.getfield("h3", "Assign Dealer to Dealer Group Employee").isDisplayed());
		Assert.assertTrue(utils.getfield("td", "There are no records to display").isDisplayed());
		selectdealerGrpEmpInDropDown(prop.getProperty("dealergrpempAutomation"));
		utils.element("xpath", arrowForwardInassignDealerToDealerGrpEmpPage).click();
		Thread.sleep(1000);
		utils.waitTillElementIsClickable(addDealer);
		Assert.assertTrue(getRows().size() > 1);
		HashMap<Integer, HashMap<String, String>> grid = assignDealerToDealerGrpEmpPageGrid();
		String dealerNamebeforeDeletion = grid.get(1).get("Dealer Name");
		selectCheckBoxForRow(1).click();
		utils.getfield("a", "Delete").click();
		utils.getfield("span", "Yes").click();
		utils.waitTillElementIsClickableByWebEle(utils.getfield("div", "Dealer Assign/Unassign successfully."));
		Thread.sleep(1000);
		HashMap<Integer, HashMap<String, String>> gridNew = assignDealerToDealerGrpEmpPageGrid();
		String dealerNameAfter = gridNew.get(1).get("Dealer Name");
		Assert.assertFalse(dealerNamebeforeDeletion.equals(dealerNameAfter));
		selectAllAndDelete();
		if (!utils.getfield("td", "There are no records to display").isDisplayed()) {
			selectAllAndDelete();
		}
		Assert.assertTrue(utils.getfield("td", "There are no records to display").isDisplayed());
	}

	@Test(priority = 2)
	public void verifyUserCanAddTwoOrMoreDealers_34860() throws Exception {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Assign Dealer to Dealer Group Employee");
		Assert.assertTrue(utils.getfield("h3", "Assign Dealer to Dealer Group Employee").isDisplayed());
		Assert.assertTrue(utils.getfield("td", "There are no records to display").isDisplayed());
		selectdealerGrpEmpInDropDown(prop.getProperty("dealergrpempAutomation"));
		utils.element("xpath", arrowForwardInassignDealerToDealerGrpEmpPage).click();
		utils.waitTillElementIsClickable(addDealer);
		Thread.sleep(2000);
		if (permissions.getSelectAllCheckBoxstatus().getAttribute("aria-checked").equals("false")) {
			permissions.getSelectAllCheckBoxInGrid().click();
		}
		utils.getfield("a", "Delete").click();
		utils.getfield("span", "Yes").click();
		Thread.sleep(2000);
		
		utils.element("xpath", addDealer).click();
		utils.waitTillElementIsClickable(selectDealerArrow);
		utils.element("xpath", selectDealerArrow).click();
		Thread.sleep(2000);
		
		
		for (int i = 0; i < 2; i++) {
			if (!permissions.getSelectCheckBoxInPopup().get(i).isSelected()) {
				permissions.getSelectCheckBoxInPopup().get(i).click();
			}
		}
		utils.element("xpath", btnClose).click();
		if (utils.element("xpath", permissions.saveBtn).isEnabled()) {
			utils.clickfield("xpath", permissions.saveBtn);
		} else {
			utils.clickfield("xpath", permissions.cancelBtn);
		}
		Thread.sleep(2000);
		utils.waitTillElementIsClickable(addDealer);
		utils.element("xpath", addDealer).click();
		utils.waitTillElementIsClickable(selectDealerArrow);
		utils.element("xpath", selectDealerArrow).click();
		Thread.sleep(2000);
		if (permissions.getSelectAllCheckBoxstatus().getAttribute("aria-checked").equals("false")) {
			permissions.getSelectAllCheckBoxInPopup().click();
		}
		utils.element("xpath", btnClose).click();
		if (utils.element("xpath", permissions.saveBtn).isEnabled()) {
			utils.clickfield("xpath", permissions.saveBtn);
		} else {
			utils.clickfield("xpath", permissions.cancelBtn);
		}
		Thread.sleep(2000);
		Assert.assertTrue(getRows().size() > 1);
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
