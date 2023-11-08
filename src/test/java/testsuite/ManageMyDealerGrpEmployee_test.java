package testsuite;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.LateralMenuAction;
import pageActions.ManageMyDealerGrpEmployeeAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

public class ManageMyDealerGrpEmployee_test extends ManageMyDealerGrpEmployeeAction{

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	LateralMenuAction lateralMenu = new LateralMenuAction();

	@BeforeMethod(alwaysRun=true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}

	@Test(priority = 1)
	public void verifyAllPermissionsInGrid_34842() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
		List<WebElement> permissionsList = utils.getElementsList("xpath", permissions);
		ArrayList<String> list = new ArrayList<>();
		for (int i=0;i<permissionsList.size();i++) {
			String permission = permissionsList.get(i).getText();
			list.add(permission);
		}
		Assert.assertTrue(list.size() == 19);
		Assert.assertTrue(list.contains("Activations"));
		Assert.assertTrue(list.contains("Actuarials"));
		Assert.assertTrue(list.contains("Cancellation History"));
		Assert.assertTrue(list.contains("Cancellation Quote"));
		Assert.assertTrue(list.contains("Cancellations"));
		Assert.assertTrue(list.contains("Claims History"));
		Assert.assertTrue(list.contains("Contract Search"));
		Assert.assertTrue(list.contains("Early Claims"));
		Assert.assertTrue(list.contains("Edit Remit AUL VSC/LW"));
		Assert.assertTrue(list.contains("Manage My Dealer Packs"));
		Assert.assertTrue(list.contains("Manage My Pricing Preferences"));
		Assert.assertTrue(list.contains("Manage VSC - GAP Preferences"));
		Assert.assertTrue(list.contains("My Account Statements"));
		Assert.assertTrue(list.contains("Quote History"));
		Assert.assertTrue(list.contains("Rate/Contract"));
		Assert.assertTrue(list.contains("Remit Classic GAP/Ancillary"));
		Assert.assertTrue(list.contains("Remit Contracts to AUL"));
		Assert.assertTrue(list.contains("Remit VAS Ancillary"));
		Assert.assertTrue(list.contains("Unpaid Contracts"));
	}
	
	@Test(priority = 2)
	public void verifyPermissionsAreSavedCorrectlyForDiffUsers_35419() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
		WebElement selectUserDropdwn = utils.element("xpath", selectUserDropdown);
		List<WebElement> list = null;
		selectUserDropdwn.click();
		list = getDriver().findElements(By.xpath(roleDropdownList));
		if(list.size() > 1) {
		list.get(0).click();
		deSelectedSelectAllChkBx();
		Thread.sleep(500);
			permissionCheckbox("Activations").click();
			permissionCheckbox("Actuarials").click();
		utils.getfield("span", "SAVE").click();
		selectUserDropdwn.click();
		list = getDriver().findElements(By.xpath(roleDropdownList));
		list.get(1).click();
		deSelectedSelectAllChkBx();
		utils.scrollDownUsingJSE();
			permissionCheckbox("Cancellation History").click();
			permissionCheckbox("Cancellation Quote").click();
			Thread.sleep(1000);
		utils.getfield("span", "SAVE").click();
		utils.scrollUpUsingJSE();
		selectUserDropdwn.click();
		 list = getDriver().findElements(By.xpath(roleDropdownList));
		 list.get(2).click();
		selectedSelectAllChkbx();
		utils.getfield("span", "SAVE").click();
		selectUserDropdwn.click();
		list = getDriver().findElements(By.xpath(roleDropdownList));
		list.get(0).click();
		Assert.assertTrue(permissionCheckboxStatus("Actuarials").isSelected());
		Assert.assertTrue(permissionCheckboxStatus("Actuarials").isSelected());
		selectUserDropdwn.click();
		list = getDriver().findElements(By.xpath(roleDropdownList));
		list.get(1).click();
		utils.waituntillPageIsloaded(1);
		utils.scrollDownUsingJSE();
		Assert.assertTrue(permissionCheckboxStatus("Cancellation History").isSelected());
		Assert.assertTrue(permissionCheckboxStatus("Cancellation Quote").isSelected());
		utils.scrollUpUsingJSE();
		selectUserDropdwn.click();
		list = getDriver().findElements(By.xpath(roleDropdownList));
		list.get(2).click();
		utils.waituntillPageIsloaded(1);
		Assert.assertTrue(permissionsSelected().equals(AllPermissions()));
	}
	}
	
	@Test(priority = 3)
	public void verifyPermissionOfFirstUserIsShownByDeafault_34841() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
		Assert.assertTrue(utils.element("xpath", defaultMailIdForSelectedUser).getText().contains(".com"));
		List<WebElement> permissionsList = utils.getElementsList("xpath", permissions);
		ArrayList<String> list = new ArrayList<>();
		String selectedPermission = null;
		for (int i=0;i<permissionsList.size();i++) {
			if(utils.getElementsList("xpath", checkbox).get(i).isSelected()) {
				 selectedPermission=permissionsList.get(i).getText();
				 list.add(selectedPermission);
			}
		}
		Collections.sort(list);
		System.out.println("permissions selected List--"+list);
	}
	
	@Test(priority = 4)
	public void verifyTheLayoutOfPage_34817() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
		Assert.assertTrue(utils.getfield("p", "Modify Permissions").isDisplayed());
		Assert.assertTrue(utils.getfield("p", "Select User").isDisplayed());
		Assert.assertTrue(utils.element("xpath", selectUserDropdown).isDisplayed());
		List<WebElement> permissionsList = utils.getElementsList("xpath", permissions);
		List<WebElement> checkBoxesList = utils.getElementsList("xpath", checkbox);
		Assert.assertTrue(checkBoxesList.size() == 19,"All checkBoxes are displayed");
		Assert.assertTrue(permissionsList.size() == 19,"All permissiona are displayed");
		Assert.assertTrue(utils.element("xpath", selectAllCheckBox).isDisplayed());
		Assert.assertTrue(utils.element("xpath", permissionsTxtField).isDisplayed());
		Assert.assertTrue(utils.element("xpath", permissionSortIcon).isDisplayed());
		Assert.assertTrue(utils.element("cssselector", rowsPerPage).isDisplayed());
		Assert.assertTrue(utils.element("cssselector", rowsPerPageSelected).getText().equals("25"));
		Assert.assertTrue(utils.element("xpath", currentPageRecord).isDisplayed());
	}
	
	@Test(priority = 5)
	public void verifyFilteringFunctionalityOfPermissionsColoumn_34845() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
		String letter = "A";
		utils.element("xpath", permissionsTxtField).sendKeys(letter);
		Thread.sleep(1000);
		List<WebElement> permissionsList = utils.getElementsList("xpath", permissions);
		System.out.println("permissions starting with letter '"+ letter + "' are - ");
		for (int i=0;i<permissionsList.size();i++) {
			System.out.println(permissionsList.get(i).getText());
			Assert.assertTrue(permissionsList.get(i).getText().startsWith(letter));
		}
		utils.element("xpath", permissionsTxtField).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		List<WebElement> permissionsList2 = utils.getElementsList("xpath", permissions);
		Assert.assertTrue(permissionsList2.size()>10);
	}
	
	@Test(priority = 6)
	public void verifySortingFunctionalityOfPermissionsColoumn_34876() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
		List<WebElement> permissionsList = utils.getElementsList("xpath", permissions);
		ArrayList<String> list1 = new ArrayList<>();
		for (int i=0;i<permissionsList.size();i++) {
			String permission = permissionsList.get(i).getText();
			list1.add(permission);
		}
		Collections.sort(list1);
		utils.element("xpath", permissionSortIcon).click();
		List<WebElement> permissionsList2 = utils.getElementsList("xpath", permissions);
		ArrayList<String> list2 = new ArrayList<>();
		for (int i=0;i<permissionsList2.size();i++) {
			String permission = permissionsList2.get(i).getText();
			list2.add(permission);
		}
		Assert.assertTrue(list1.equals(list2),"Sorting verified in ascending alphabetical order");
		String expectedRedColorInHexa = prop.getProperty("darkOrangeInHexaForm");
		String borderColorForPermission = utils.element("xpath", permissionTxt).getCssValue("border-top-color");
		String ActualcolorInHexaformatForPermission = Color.fromString(borderColorForPermission).asHex();
		Assert.assertEquals(ActualcolorInHexaformatForPermission, expectedRedColorInHexa,"Permissions txt is in red color");
		
		//Reverse sorting
		Collections.reverse(list1);
		utils.element("xpath", permissionSortIcon).click();
		List<WebElement> permissionsList3 = utils.getElementsList("xpath", permissions);
		ArrayList<String> list3 = new ArrayList<>();
		for (int i=0;i<permissionsList3.size();i++) {
			String permission = permissionsList3.get(i).getText();
			list3.add(permission);
		}
		Assert.assertTrue(list1.equals(list3),"Sorting verified in descending alphabetical order");
		String borderColorForPermissionNew = utils.element("xpath", permissionTxt).getCssValue("border-top-color");
		String ActualcolorInHexaformatForPermissionNew = Color.fromString(borderColorForPermissionNew).asHex();
		Assert.assertEquals(ActualcolorInHexaformatForPermissionNew, expectedRedColorInHexa,"Permissions txt is still in red color");
	}
	
//	@Test(priority = 7)
//	public void verifySelectUserFieldValues_34819() throws InterruptedException {
//		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
//		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
//		WebElement selectUserDropdwn = utils.element("xpath", selectUserDropdown);
//		List<WebElement> dropdownList = null;
//		selectUserDropdwn.click();
//		dropdownList = getDriver().findElements(By.xpath(roleDropdownList));
//		selectUserDropdwn.click();
//		if(dropdownList.size() > 1) {
//			selectUser(prop.getProperty("dealergrpempAutomation"));
//			dropdownList = getDriver().findElements(By.xpath(roleDropdownList));
//		Assert.assertTrue(dropdownList.size()== 0,"dropdown collapses");
//		ArrayList<String> permissionsSelectedForUser = permissionsSelected();
////		int totalPermissionsForFirstUser = permissionsSelected().size();
//		login.logout();
//		login.login(prop.getProperty("dealergrpempAutomation"), prop.getProperty("password"));
//		ArrayList<String> list = new ArrayList<String>();
//		List<WebElement> subMenuItemsList = null;
//		verticalMenu.navigatetoLeftMainMenu("E-Rate");
//		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
//		list.add(subMenuItemsList.get(0).getText());
//		list.add(subMenuItemsList.get(1).getText());
//
//		verticalMenu.navigatetoLeftMainMenu("Contracts");
//		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
//		for (int i = 0; i < subMenuItemsList.size(); i++) {
//			String contracts = subMenuItemsList.get(i).getText();
//			list.add(contracts);
//		}
//
//		verticalMenu.navigatetoLeftMainMenu("Cancellations");
//		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
//		for (int i = 0; i < subMenuItemsList.size(); i++) {
//			String cancellations = subMenuItemsList.get(i).getText();
//			list.add(cancellations);
//		}
//
//		verticalMenu.navigatetoLeftMainMenu("Report");
//		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
//		for (int i = 0; i < subMenuItemsList.size(); i++) {
//			String reports = subMenuItemsList.get(i).getText();
//			list.add(reports);
//		}
//
//		verticalMenu.navigatetoLeftMainMenu("My Settings");
//		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
//		for (int i = 1; i < subMenuItemsList.size(); i++) {
//			String mySettings = subMenuItemsList.get(i).getText();
//			list.add(mySettings);
//		}
//		Collections.sort(list);
//		assertTrue(list.equals(permissionsSelectedForUser));
//		login.logout();
//		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
//		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
//		selectUserDropdwn.click();
//		dropdownList = getDriver().findElements(By.xpath(roleDropdownList));
//		dropdownList.get(1).click();
//		dropdownList = getDriver().findElements(By.xpath(roleDropdownList));
//		Assert.assertTrue(dropdownList.size()== 0,"dropdown collapses");
//		List<WebElement> permissionsList = utils.getElementsList("xpath", permissions);
//		for (int i = 1; i < permissionsList.size(); i++) {
//			Assert.assertTrue(permissionsList.get(i).isDisplayed());
//		}
//		}
//	}
	
	@Test(priority = 8)
	public void verifyUserCanEditTheOption_34816() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
		if(permissionCheckboxStatus("Actuarials").isSelected()) {
			permissionCheckbox("Actuarials").click();
			Assert.assertFalse(permissionCheckboxStatus("Actuarials").isSelected());
		}
		else if(!permissionCheckboxStatus("Actuarials").isSelected()) {
			permissionCheckbox("Actuarials").click();
			Assert.assertTrue(permissionCheckboxStatus("Actuarials").isSelected());
		}
	}
	
	@Test(priority = 9)
	public void verifyUserCanAddAllPermToDealerEmp_34833() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
		selectUser(prop.getProperty("dealergrpempAutomation"));
		WebElement selectAllCheckBoxstat = utils.element("xpath", selectAllCheckBoxstatus);
		if(!selectAllCheckBoxstat.isSelected()) {
		utils.element("xpath", selectAllCheckBox).click();
		}
		else {
			utils.element("xpath", selectAllCheckBox).click();
			utils.element("xpath", selectAllCheckBox).click();
		}
		Assert.assertTrue(selectAllCheckBoxstat.isSelected());
		utils.getfield("span", "SAVE").click();
		Assert.assertTrue(permissionsSelected().containsAll(AllPermissions()));
		ArrayList<String> selectedPermissions = permissionsSelected();
		login.logout();
		login.login(prop.getProperty("dealergrpempAutomation"), prop.getProperty("password"));
		ArrayList<String> list = new ArrayList<String>();
		List<WebElement> subMenuItemsList = null;
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		list.add(subMenuItemsList.get(0).getText());
		list.add(subMenuItemsList.get(1).getText());

		verticalMenu.navigatetoLeftMainMenu("Contracts");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		for (int i = 0; i < subMenuItemsList.size(); i++) {
			String contracts = subMenuItemsList.get(i).getText();
			list.add(contracts);
		}

		verticalMenu.navigatetoLeftMainMenu("Cancellations");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		for (int i = 0; i < subMenuItemsList.size(); i++) {
			String cancellations = subMenuItemsList.get(i).getText();
			list.add(cancellations);
		}

		verticalMenu.navigatetoLeftMainMenu("Report");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		for (int i = 0; i < subMenuItemsList.size(); i++) {
			String reports = subMenuItemsList.get(i).getText();
			list.add(reports);
		}

		verticalMenu.navigatetoLeftMainMenu("My Settings");
		subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		for (int i = 1; i < subMenuItemsList.size(); i++) {
			String mySettings = subMenuItemsList.get(i).getText();
			list.add(mySettings);
		}
		Collections.sort(list);
		assertTrue(list.equals(selectedPermissions));
	}
	
	@Test(priority = 10)
	public void verifyUserCanAddMoreThanOnePermForDealerEmp_34832() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
		selectUser(prop.getProperty("dealergrpempAutomation"));
		WebElement selectAllCheckBoxstat = utils.element("xpath", selectAllCheckBoxstatus);
		if(selectAllCheckBoxstat.isSelected()) {
		utils.element("xpath", selectAllCheckBox).click();
		}
		else {
			utils.element("xpath", selectAllCheckBox).click();
			utils.element("xpath", selectAllCheckBox).click();
		}
		Assert.assertFalse(selectAllCheckBoxstat.isSelected());
		permissionCheckbox("Rate/Contract").click();
		permissionCheckbox("Quote History").click();
		utils.getfield("span", "SAVE").click();
		ArrayList<String> selectedPermissions = permissionsSelected();
		login.logout();
		login.login(prop.getProperty("dealergrpempAutomation"), prop.getProperty("password"));
		ArrayList<String> list = new ArrayList<String>();
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		List<WebElement> subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		list.add(subMenuItemsList.get(0).getText());
		list.add(subMenuItemsList.get(1).getText());
		assertTrue(list.equals(selectedPermissions));
	}

	@Test(priority = 11)
	public void verifyUserCanAddOnlyOnePermForDealerEmp_34826() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
		selectUser(prop.getProperty("dealergrpempAutomation"));
		WebElement selectAllCheckBoxstat = utils.element("xpath", selectAllCheckBoxstatus);
		if(selectAllCheckBoxstat.isSelected()) {
		utils.element("xpath", selectAllCheckBox).click();
		}
		else {
			utils.element("xpath", selectAllCheckBox).click();
			utils.element("xpath", selectAllCheckBox).click();
		}
		Assert.assertFalse(selectAllCheckBoxstat.isSelected());
		utils.scrollDownUsingJSE();
		permissionCheckbox("Manage My Dealer Packs").click();
		utils.getfield("span", "SAVE").click();
		ArrayList<String> selectedPermissions = permissionsSelected();
		login.logout();
		login.login(prop.getProperty("dealergrpempAutomation"), prop.getProperty("password"));
		ArrayList<String> list = new ArrayList<String>();
		verticalMenu.navigatetoLeftMainMenu("My Settings");
		List<WebElement> subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		list.add(subMenuItemsList.get(1).getText());
		assertTrue(list.equals(selectedPermissions));
	}
	
	@Test(priority = 12)
	public void verifyUserCanDeselectAllPermOfDealerEmp_34840() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
		selectUser(prop.getProperty("dealergrpempAutomation"));
		WebElement selectAllCheckBoxstat = utils.element("xpath", selectAllCheckBoxstatus);
		if(selectAllCheckBoxstat.isSelected()) {
		utils.element("xpath", selectAllCheckBox).click();
		}
		else {
			utils.element("xpath", selectAllCheckBox).click();
			utils.element("xpath", selectAllCheckBox).click();
		}
		Assert.assertFalse(selectAllCheckBoxstat.isSelected());
		utils.getfield("span", "SAVE").click();
		Assert.assertTrue(permissionsSelected().size() == 0);
		login.logout();
		login.login(prop.getProperty("dealergrpempAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertEquals(lateralMenu.getLaterMenuSubItems().size(), 0);

		verticalMenu.navigatetoLeftMainMenu("Contracts");
		Assert.assertEquals(lateralMenu.getLaterMenuSubItems().size(), 0);

		verticalMenu.navigatetoLeftMainMenu("Cancellations");
		Assert.assertEquals(lateralMenu.getLaterMenuSubItems().size(), 0);

		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertEquals(lateralMenu.getLaterMenuSubItems().size(), 0);
		
		verticalMenu.navigatetoLeftMainMenu("My Settings");
		Assert.assertEquals(lateralMenu.getLaterMenuSubItems().size(), 1);
	}
	
	@Test(priority = 13)
	public void verifyUserCanRemoveMoreThanOnePermForDealerEmp_34838() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
		selectUser(prop.getProperty("dealergrpempAutomation"));
		WebElement selectAllCheckBoxstat = utils.element("xpath", selectAllCheckBoxstatus);
		if(!selectAllCheckBoxstat.isSelected()) {
		utils.element("xpath", selectAllCheckBox).click();
		}
		else {
			utils.element("xpath", selectAllCheckBox).click();
			utils.element("xpath", selectAllCheckBox).click();
		}
		Assert.assertTrue(selectAllCheckBoxstat.isSelected());
		permissionCheckbox("Cancellation History").click();
		permissionCheckbox("Cancellation Quote").click();
		Assert.assertTrue(!permissionCheckboxStatus("Cancellation History").isSelected());
		Assert.assertTrue(!permissionCheckboxStatus("Cancellation Quote").isSelected());
		utils.getfield("span", "SAVE").click();
		Assert.assertTrue(permissionsUnselected().size() == 2);
		login.logout();
		login.login(prop.getProperty("dealergrpempAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertEquals(lateralMenu.getLaterMenuSubItems().size(), 2 ,"E-rate has the permission");
		verticalMenu.navigatetoLeftMainMenu("Cancellations");
		Assert.assertEquals(lateralMenu.getLaterMenuSubItems().size(), 0,"Cancellations doesnot have the permission");
	}
	
	@Test(priority = 14)
	public void verifyUserCanRemoveOnePermForDealerEmp_34834() throws InterruptedException {
		login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Group Employees");
		Assert.assertTrue(utils.getfield("h3", "Manage My Dealer Group Employees").isDisplayed());
		selectUser(prop.getProperty("dealergrpempAutomation"));
		WebElement selectAllCheckBoxstat = utils.element("xpath", selectAllCheckBoxstatus);
		if(!selectAllCheckBoxstat.isSelected()) {
		utils.element("xpath", selectAllCheckBox).click();
		}
		else {
			utils.element("xpath", selectAllCheckBox).click();
			utils.element("xpath", selectAllCheckBox).click();
		}
		Assert.assertTrue(selectAllCheckBoxstat.isSelected());
		permissionCheckbox("Actuarials").click();
		Assert.assertTrue(!permissionCheckboxStatus("Actuarials").isSelected());
		utils.getfield("span", "SAVE").click();
		Assert.assertTrue(permissionsUnselected().size() == 1);
		login.logout();
		login.login(prop.getProperty("dealergrpempAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMainMenu("Report");
		ArrayList<String> list = new ArrayList<String>();
		List<WebElement> subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		for (int i = 1; i < subMenuItemsList.size(); i++) {
			String report = subMenuItemsList.get(i).getText();
			list.add(report);
		}
		System.out.println("Reports list-" + list);
		Assert.assertTrue(list.contains("Activations"),"Permission given for activations");
		Assert.assertTrue(!list.contains("Actuarials"),"Permission not given for actuarials");
	}
	


}
