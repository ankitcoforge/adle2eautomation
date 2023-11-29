package pageActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.NewUserRegistrationPo;
import utils.XmlDataReader;
import utils.utilityClass;

public class NewUserRegistration_Action extends NewUserRegistrationPo {

	public String newemail;
	loginAction lo = new loginAction();
	utilityClass utils = new utilityClass();
	WebMileageExceptionAction wme = new WebMileageExceptionAction();
	impersonateAction impersonate = new impersonateAction();
	verticalMenuAction vo = new verticalMenuAction();
	EmployeePacksAction packs = new EmployeePacksAction();
	XmlDataReader UtilsDataReader = new XmlDataReader("UtilsData");
	LateralMenuAction lateraMenu = new LateralMenuAction();

	public String getEmail() throws InterruptedException {
		driver.get(prop.getProperty("minuteInboxURL"));
//		String newemail1 = driver.findElement(By.cssSelector("span.animace")).getText();
//		System.out.println("old mail before deletion-"+newemail1);
//		utils.element("cssselector", delInGetEmail).click();
		Thread.sleep(1000);
//		if (utils.element("id", closeAdd).isDisplayed()) {
//			utils.element("id", closeAdd).click();
//		}
//        Thread.sleep(1000);
//        driver.switchTo().defaultContent();
		newemail = driver.findElement(By.cssSelector("span.animace")).getText();
		System.out.println(newemail);
		return newemail;
	}
	
	public String getEmailAfter() {
		driver.get(prop.getProperty("minuteInboxURL"));
		newemail = driver.findElement(By.cssSelector("span.animace")).getText();
		System.out.println(newemail);
		return newemail;
	}

	public void enterRoleIDAndCreateUserThroughAdmin(String role, String roleId) throws InterruptedException {
		enterRoleRoleIdAndGetUsers(role, roleId);
		utils.getfield("span", "+ New user").isEnabled();
		utils.getfield("span", "+ New user").click();
		utils.waitTillElementIsVisible(email);
		utils.element("xpath", email).sendKeys(newemail);
		utils.waitTillElementIsVisible(submit);
		utils.element("xpath", submit).click();
	}

	public void getEmailAndCompletenewUserRegistration() throws InterruptedException {
		String email1 = getEmailAfter();
		if (newemail.matches(email1)) {
			List<WebElement> a = driver.findElements(By.cssSelector("#schranka > tr"));
			utils.waituntillPageIsloaded();
			utils.scrollDownUsingJSE();
			int size=a.size();
			System.out.println("a size-----"+size);
			WebDriverWait wait = new WebDriverWait(driver, 100);
			List<WebElement> b = driver.findElements(By.cssSelector("#schranka > tr"));
			System.out.println("b size---"+b.size());
			if (b.size() == size+2) {
				driver.findElement(By.cssSelector("#schranka > tr > td")).click();
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframeMail"));
				// driver.switchTo().frame("iframeMail");
				utils.scrollDownUsingJSE();
				String url = utils.element("cssselector", urlToRegister).getAttribute("href");
				driver.get(url);
				utils.waituntillPageIsloaded();
				utils.waitTillElementIsVisibleCss(firstandLastName);
				utils.getElementsList("cssselector", firstandLastName).get(0).sendKeys(prop.getProperty("firsName"));
				utils.getElementsList("cssselector", firstandLastName).get(1).sendKeys(prop.getProperty("lastName"));
				utils.getElementsList("cssselector", passwordField).get(0).sendKeys(prop.getProperty("password"));
				utils.getElementsList("cssselector", passwordField).get(1).sendKeys(prop.getProperty("password"));
				driver.findElement(By.cssSelector(submitNewUserRegistrationPage)).click();
				utils.waituntillPageIsloaded();
				navigate();
				lo.login(newemail, prop.getProperty("password"));
				utils.waitTillElementIsClickableByWebEle(utils.getfield("mat-icon", "close"));
//				utils.waituntillPageIsloaded();
				utils.getfield("mat-icon", "close").click();
				Thread.sleep(500);
				lo.logout();
				Thread.sleep(2000);
			}
		}
	}
	
	public void deleteTheCreatedUser(String role,String roleId,String email) throws InterruptedException {
		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		vo.navigatetoimpersonate();
		impersonate.getUsers(role,roleId);
		 HashMap<Integer, HashMap<String, WebElement>> allTableDataInImpersonatePagee = impersonate.checkGridForEditDelLock();
		impersonate.getSearchBoxes().get("Email").sendKeys(email);
		allTableDataInImpersonatePagee.get(1).get("Delete").click();
		utils.getfield("span", "Yes").click();
		impersonate.getSearchBoxes().get("Email").sendKeys(email);
		 Assert.assertTrue(utils.getfield("td", "There are no records to display").isDisplayed());
	}

	public void enterRoleRoleIdAndGetUsers(String role, String roleid) throws InterruptedException {
		utils.waitTillElementIsClickable(impersonate.roleDropdown);
		utils.clickfield("xpath", impersonate.roleDropdown);
		List<WebElement> list = getDriver().findElements(By.xpath(impersonate.roleDropdownList));
//		list.get(9).click();
//		utils.clickfield("xpath", impersonate.roleDropdown);
//		list.get(9).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			System.out.println("elements list-"+text);
			if (text.equals(role)) {
				list.get(i).click();
				utils.inputfield("xpath", impersonate.roleId, roleid);
				break;
			}
		}
		utils.clickfield("xpath", impersonate.getusersButton);
		utils.waitTillElementIsClickable(newUserbtn);
	}

	public void selectDealerInmanageUserPage() throws InterruptedException {
		utils.clickfield("xpath", packs.selectDealerNamearrow);
		WebElement ele = driver.findElement(By.xpath(enterRole));
		ele.sendKeys(UtilsDataReader.getXMLData("dealer3"));
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownListForDealer));
		list.get(0).click();
		utils.waitTillElementIsVisible(impersonate.getusersButton);
		utils.clickfield("xpath", impersonate.getusersButton);
	}

	public void getNewUserPageWithAccountNameSelection(String roleType) throws InterruptedException {
		utils.getfield("span", "+ New user").isEnabled();
		utils.getfield("span", "+ New user").click();
		utils.waitTillElementIsVisible(impersonate.roleDropdown);
		utils.clickfield("xpath", impersonate.roleDropdown);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();

			if (text.equals(roleType)) {
				list.get(i).click();
				break;
			}
		}
		utils.waitTillElementIsClickable(roleDropdownForAccountName);
		utils.clickfield("xpath", roleDropdownForAccountName);
		List<WebElement> list2 = getDriver().findElements(By.xpath(roleDropdownListForAccountName));
		list2.get(0).click();
		utils.waitTillElementIsVisible(email);
		utils.element("xpath", email).sendKeys(newemail);
		utils.waitTillElementIsVisible(submit);
		utils.element("xpath", submit).click();
		utils.waituntillPageIsloaded();
	}

	public void getNewUserPageWithoutAccountNameSelection(String roleType) throws InterruptedException {
		utils.getfield("span", "+ New user").isEnabled();
		driver.findElement(By.xpath(newUserbtn)).click();
		utils.waitTillElementIsVisible(impersonate.roleDropdown);
		utils.clickfield("xpath", impersonate.roleDropdown);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();

			if (text.equals(roleType)) {
				list.get(i).click();
				break;
			}
		}
		utils.waitTillElementIsVisible(email);
		utils.element("xpath", email).sendKeys(newemail);
		utils.waitTillElementIsVisible(submit);
		utils.element("xpath", submit).click();
		utils.waituntillPageIsloaded();
	}

	public void getNewUserForDealerEmpThroughDealer() throws InterruptedException {
		utils.getfield("span", "+ New user").isEnabled();
		utils.getfield("span", "+ New user").click();
		utils.waitTillElementIsVisible(email);
		utils.element("xpath", email).sendKeys(newemail);
		utils.waitTillElementIsVisible(submit);
		utils.element("xpath", submit).click();
		utils.waituntillPageIsloaded();
	}

	public void openNewUserRegistrationPage() throws InterruptedException {
		String email1 = getEmailAfter();
		if (newemail.matches(email1)) {
			List<WebElement> a = driver.findElements(By.cssSelector("#schranka > tr"));
			utils.waituntillPageIsloaded();
			utils.scrollDownUsingJSE();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			if (a.size() == 4) {
				driver.findElement(By.cssSelector("#schranka > tr > td")).click();
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframeMail"));
				utils.scrollDownUsingJSE();
				String url = driver.findElement(By.cssSelector("tbody > tr > td.button > a")).getAttribute("href");
				driver.get(url);
			}
		}
	}

	public WebElement getElement(String txt) {
		WebElement ele = driver.findElement(By.xpath("//label[text()='" + txt + "']/../../div[2]/input"));
		return ele;
	}

	public WebElement getErrorMsg(String txt) {
		WebElement ele = driver.findElement(By.xpath("//label[text()='" + txt + "']/../..//adl-form-error/div/span"));
		return ele;
	}

	public void openNewUserPopup() throws InterruptedException {
		utils.waituntillPageIsloaded();
		utils.getfield("span", "+ New user").isEnabled();
		utils.getfield("span", "+ New user").click();
		utils.waitTillElementIsVisible(email);
		utils.element("xpath", email).sendKeys(newemail);
	}

	public void ClickOnSubmit() throws InterruptedException {
//		utils.waitTillElementIsVisible(submit);
		utils.waituntillPageIsloaded();
		utils.element("xpath", submit).click();
		utils.waituntillPageIsloaded();
	}

	public static ArrayList<String> removeDuplicates(ArrayList<String> list) {
		ArrayList<String> newList = new ArrayList<String>();
		for (String element : list) {
			if (!newList.contains(element)) {

				newList.add(element);
			}
		}
		return newList;
	}

	public Map<ArrayList<String>, ArrayList<String>> getSelectedAndUnselectedPermissions(List<WebElement> perm, int i) {
		Map<ArrayList<String>, ArrayList<String>> map = new HashMap();
		ArrayList<String> selectedPermissionsList = new ArrayList<String>();
		ArrayList<String> unselectedPermissionsList = new ArrayList<String>();
		List<WebElement> permissions = utils.getElementsList("xpath", permissionsCheckedAndUnchecked);
		List<WebElement> permissionCheckboxes = utils.getElementsList("xpath", permissionsCheckbox);
		if (permissionCheckboxes.get(i).getAttribute("class").contains("state-active")) {
			String selectedPermissions = perm.get(i).getAttribute("aria-label");
			selectedPermissionsList.add(selectedPermissions);
		} else {
			String unSelectedPermissions = permissions.get(i).getAttribute("aria-label");
			unselectedPermissionsList.add(unSelectedPermissions);
		}
		map.put(selectedPermissionsList, unselectedPermissionsList);
		return map;
	}

	public String getfield(String a, String name) {
		String str = "//" + a + "[contains(text(),'" + name + "')]";
		return str;
	}

	public void clickOnNewUserAndselectDealerAccountNameEmailWithoutSubmit(String roleType)
			throws InterruptedException {
		// utils.getfield("span", "+ New user").isEnabled();
		utils.waitTillElementIsVisible(newUserbtn);
		utils.getfield("span", "+ New user").click();
		utils.waitTillElementIsVisible(impersonate.roleDropdown);
		utils.clickfield("xpath", impersonate.roleDropdown);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();

			if (text.equals(roleType)) {
				list.get(i).click();
				break;
			}
		}
		utils.waitTillElementIsClickable(roleDropdownForAccountName);
		utils.clickfield("xpath", roleDropdownForAccountName);
		List<WebElement> list2 = getDriver().findElements(By.xpath(roleDropdownListForAccountName));
		list2.get(0).click();
		utils.waitTillElementIsVisible(email);
		utils.element("xpath", email).sendKeys(newemail);
	}

	public void NewUserPageWithoutAccountNameSelectionandSubmit(String roleType) throws InterruptedException {
		utils.getfield("span", "+ New user").isEnabled();
		driver.findElement(By.xpath(newUserbtn)).click();
		utils.waitTillElementIsVisible(impersonate.roleDropdown);
		utils.clickfield("xpath", impersonate.roleDropdown);
		List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();

			if (text.equals(roleType)) {
				list.get(i).click();
				break;
			}
		}
		utils.waitTillElementIsVisible(email);
		utils.element("xpath", email).sendKeys(newemail);
	}

	public void validatePermissionsForDealerEmp() throws InterruptedException {
		utils.element("xpath", permissionsArrow).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions
				.visibilityOfAllElements(utils.getElementsList("xpath", permissionsCheckedAndUnchecked)));
		List<WebElement> permissions1 = utils.getElementsList("xpath", permissionsCheckedAndUnchecked);
		List<WebElement> permissionCheckboxes = utils.getElementsList("xpath", permissionsCheckbox);
		utils.waituntillPageIsloaded();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> selectedPermissionsList = new ArrayList<String>();
		ArrayList<String> unselectedPermissionsList = new ArrayList<String>();
		System.out.println(permissions1.size());
		for (int i = 0; i < permissions1.size(); i++) {
			String permissionName = permissions1.get(i).getAttribute("aria-label");
			list.add(permissionName);
			if (permissionCheckboxes.get(i).getAttribute("class").contains("state-active")) {
				String selectedPermissions = permissions1.get(i).getAttribute("aria-label");
				selectedPermissionsList.add(selectedPermissions);
			} else {
				String unSelectedPermissions = permissions1.get(i).getAttribute("aria-label");
				unselectedPermissionsList.add(unSelectedPermissions);
			}
		}

		permissions1.get(permissions1.size() - 1).click();
		permissions1.get(permissions1.size() - 1).click();
		List<WebElement> permissions2 = utils.getElementsList("xpath", permissionsCheckedAndUnchecked);
		List<WebElement> permission2Checkboxes = utils.getElementsList("xpath", permissionsCheckbox);
		for (int i = 0; i < permissions2.size(); i++) {
			if (permission2Checkboxes.get(i).getAttribute("class").contains("state-active")) {
				String selectedPermissions = permissions2.get(i).getAttribute("aria-label");
				selectedPermissionsList.add(selectedPermissions);
			} else {
				String unSelectedPermissions = permissions2.get(i).getAttribute("aria-label");
				unselectedPermissionsList.add(unSelectedPermissions);
			}
			String permissionsList = permissions2.get(i).getAttribute("aria-label");
			list.add(permissionsList);
		}
		ArrayList<String> TotalListNew = removeDuplicates(list);
		ArrayList<String> selectedPermissionsWithOutDups = removeDuplicates(selectedPermissionsList);
		ArrayList<String> unselectedPermissionsWithOutDups = removeDuplicates(unselectedPermissionsList);
		System.out.println("Total List present -" + TotalListNew);
		System.out.println("selectedPermissionsWithOutDups are-" + selectedPermissionsWithOutDups);
		System.out.println("UnselectedPermissionsWithOutDups are-" + unselectedPermissionsWithOutDups);
		System.out.println("Total List size -" + TotalListNew.size());
		System.out.println("selectedPermissions size -" + selectedPermissionsWithOutDups.size());
		System.out.println("UnselectedPermissions size -" + unselectedPermissionsWithOutDups.size());
		Assert.assertTrue(TotalListNew.size() == 19);
		Assert.assertTrue(selectedPermissionsWithOutDups.size() == 8);
		Assert.assertTrue(unselectedPermissionsWithOutDups.size() == 11);
		utils.element("xpath", permissionsArrow).click();
		ClickOnSubmit();
		lo.logout();
		getEmailAndCompletenewUserRegistration();
		if (utils.getfield("mat-icon", "close").isDisplayed()) {
			utils.getfield("mat-icon", "close").click();
		}
		vo.navigatetoLeftMainMenu("Report");
		Assert.assertEquals(lateraMenu.getLaterMenuSubItems().size(), 3);
		ArrayList<String> subItemslist = new ArrayList<String>();
		for (int i = 0; i < lateraMenu.getLaterMenuSubItems().size(); i++) {
			String submenuItem = lateraMenu.getLaterMenuSubItems().get(i).getText();
			subItemslist.add(submenuItem);
		}
		System.out.println("submenu Items are -" + subItemslist);
		Assert.assertTrue(subItemslist.contains("Activations"));
		Assert.assertTrue(subItemslist.contains("Claims History"));
		Assert.assertTrue(subItemslist.contains("Early Claims"));
	}

	public void validatePermissionsForLenderEmp() throws InterruptedException {
		utils.element("xpath", permissionsArrow).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions
				.visibilityOfAllElements(utils.getElementsList("xpath", permissionsCheckedAndUnchecked)));
		List<WebElement> permissions1 = utils.getElementsList("xpath", permissionsCheckedAndUnchecked);
		List<WebElement> permissionCheckboxes = utils.getElementsList("xpath", permissionsCheckbox);
		utils.waituntillPageIsloaded();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> selectedPermissionsList = new ArrayList<String>();
		ArrayList<String> unselectedPermissionsList = new ArrayList<String>();
		System.out.println(permissions1.size());
		for (int i = 0; i < permissions1.size(); i++) {
			String permissionName = permissions1.get(i).getAttribute("aria-label");
			list.add(permissionName);
			if (permissionCheckboxes.get(i).getAttribute("class").contains("state-active")) {
				String selectedPermissions = permissions1.get(i).getAttribute("aria-label");
				selectedPermissionsList.add(selectedPermissions);
			} else {
				String unSelectedPermissions = permissions1.get(i).getAttribute("aria-label");
				unselectedPermissionsList.add(unSelectedPermissions);
			}
		}
		permissions1.get(permissions1.size() - 1).click();
		permissions1.get(permissions1.size() - 1).click();
		List<WebElement> permissions2 = utils.getElementsList("xpath", permissionsCheckedAndUnchecked);
		List<WebElement> permission2Checkboxes = utils.getElementsList("xpath", permissionsCheckbox);
		for (int i = 0; i < permissions2.size(); i++) {
			if (permission2Checkboxes.get(i).getAttribute("class").contains("state-active")) {
				String selectedPermissions = permissions2.get(i).getAttribute("aria-label");
				selectedPermissionsList.add(selectedPermissions);
			} else {
				String unSelectedPermissions = permissions2.get(i).getAttribute("aria-label");
				unselectedPermissionsList.add(unSelectedPermissions);
			}
			String permissionsList = permissions2.get(i).getAttribute("aria-label");
			list.add(permissionsList);
		}
		ArrayList<String> TotalListNew = removeDuplicates(list);
		ArrayList<String> selectedPermissionsWithOutDups = removeDuplicates(selectedPermissionsList);
		ArrayList<String> unselectedPermissionsWithOutDups = removeDuplicates(unselectedPermissionsList);
		System.out.println("Total List present -" + TotalListNew);
		System.out.println("selectedPermissionsWithOutDups are-" + selectedPermissionsWithOutDups);
		System.out.println("UnselectedPermissionsWithOutDups are-" + unselectedPermissionsWithOutDups);
		System.out.println("Total List size -" + TotalListNew.size());
		System.out.println("selectedPermissions size -" + selectedPermissionsWithOutDups.size());
		System.out.println("UnselectedPermissions size -" + unselectedPermissionsWithOutDups.size());
		Assert.assertTrue(TotalListNew.size() == 17);
		Assert.assertTrue(selectedPermissionsWithOutDups.size() == 11);
		Assert.assertTrue(unselectedPermissionsWithOutDups.size() == 6);
		utils.element("xpath", permissionsArrow).click();
		ClickOnSubmit();
		lo.logout();
		getEmailAndCompletenewUserRegistration();
		if (utils.getfield("mat-icon", "close").isDisplayed()) {
			utils.getfield("mat-icon", "close").click();
		}
		vo.navigatetoLeftMainMenu("Report");
		Assert.assertEquals(lateraMenu.getLaterMenuSubItems().size(), 5);
		ArrayList<String> subItemslist = new ArrayList<String>();
		for (int i = 0; i < lateraMenu.getLaterMenuSubItems().size(); i++) {
			String submenuItem = lateraMenu.getLaterMenuSubItems().get(i).getText();
			subItemslist.add(submenuItem);
		}
		System.out.println("submenu Items are -" + subItemslist);
		Assert.assertTrue(subItemslist.contains("Unpaid Contracts"));
		Assert.assertTrue(subItemslist.contains("Activations"));
		Assert.assertTrue(subItemslist.contains("Cancellations"));
		Assert.assertTrue(subItemslist.contains("Claims History"));
		Assert.assertTrue(subItemslist.contains("Early Claims"));
	}

	public void validateDealerGrpPermissions() throws InterruptedException {
		utils.element("xpath", permissionsArrow).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions
				.visibilityOfAllElements(utils.getElementsList("xpath", permissionsCheckedAndUnchecked)));
		List<WebElement> permissions1 = utils.getElementsList("xpath", permissionsCheckedAndUnchecked);
		List<WebElement> permissionCheckboxes = utils.getElementsList("xpath", permissionsCheckbox);
		utils.waituntillPageIsloaded();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> selectedPermissionsList = new ArrayList<String>();
		ArrayList<String> unselectedPermissionsList = new ArrayList<String>();
		System.out.println(permissions1.size());
		for (int i = 0; i < permissions1.size(); i++) {
			String permissionName = permissions1.get(i).getAttribute("aria-label");
			list.add(permissionName);
			if (permissionCheckboxes.get(i).getAttribute("class").contains("state-active")) {
				String selectedPermissions = permissions1.get(i).getAttribute("aria-label");
				selectedPermissionsList.add(selectedPermissions);
			} else {
				String unSelectedPermissions = permissions1.get(i).getAttribute("aria-label");
				unselectedPermissionsList.add(unSelectedPermissions);
			}
		}

		permissions1.get(permissions1.size() - 1).click();
		permissions1.get(permissions1.size() - 1).click();
		List<WebElement> permissions2 = utils.getElementsList("xpath", permissionsCheckedAndUnchecked);
		List<WebElement> permission2Checkboxes = utils.getElementsList("xpath", permissionsCheckbox);
		for (int i = 0; i < permissions2.size(); i++) {
			if (permission2Checkboxes.get(i).getAttribute("class").contains("state-active")) {
				String selectedPermissions = permissions2.get(i).getAttribute("aria-label");
				selectedPermissionsList.add(selectedPermissions);
			} else {
				String unSelectedPermissions = permissions2.get(i).getAttribute("aria-label");
				unselectedPermissionsList.add(unSelectedPermissions);
			}
			String permissionsList = permissions2.get(i).getAttribute("aria-label");
			list.add(permissionsList);
		}
		ArrayList<String> TotalListNew = removeDuplicates(list);
		ArrayList<String> selectedPermissionsWithOutDups = removeDuplicates(selectedPermissionsList);
		ArrayList<String> unselectedPermissionsWithOutDups = removeDuplicates(unselectedPermissionsList);
		System.out.println("Total List present -" + TotalListNew);
		System.out.println("selectedPermissionsWithOutDups are-" + selectedPermissionsWithOutDups);
		System.out.println("UnselectedPermissionsWithOutDups are-" + unselectedPermissionsWithOutDups);
		System.out.println("Total List size -" + TotalListNew.size());
		System.out.println("selectedPermissions size -" + selectedPermissionsWithOutDups.size());
		System.out.println("UnselectedPermissions size -" + unselectedPermissionsWithOutDups.size());
		Assert.assertTrue(TotalListNew.size() == 17);
		Assert.assertTrue(selectedPermissionsWithOutDups.size() == 6);
		Assert.assertTrue(unselectedPermissionsWithOutDups.size() == 11);
		utils.element("xpath", permissionsArrow).click();
		ClickOnSubmit();
		lo.logout();
		getEmailAndCompletenewUserRegistration();
		if (utils.getfield("mat-icon", "close").isDisplayed()) {
			utils.getfield("mat-icon", "close").click();
		}
		vo.navigatetoLeftMainMenu("Report");
		Assert.assertEquals(lateraMenu.getLaterMenuSubItems().size(), 3);
		ArrayList<String> subItemslist = new ArrayList<String>();
		for (int i = 0; i < lateraMenu.getLaterMenuSubItems().size(); i++) {
			String submenuItem = lateraMenu.getLaterMenuSubItems().get(i).getText();
			subItemslist.add(submenuItem);
		}
		System.out.println("submenu Items are -" + subItemslist);
		Assert.assertTrue(subItemslist.contains("Activations"));
		Assert.assertTrue(subItemslist.contains("Claims History"));
		Assert.assertTrue(subItemslist.contains("Early Claims"));
	}
	
	public void validatePermissionsForDealerEmpWithoutSubmit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfAllElements(utils.getElementsList("xpath", permissionsArrow)));
		utils.element("xpath", permissionsArrow).click();
		//wait.until(ExpectedConditions
//				.visibilityOfAllElements(utils.getElementsList("xpath", permissionsCheckedAndUnchecked)));
		List<WebElement> permissions1 = utils.getElementsList("xpath", permissionsCheckedAndUnchecked);
		List<WebElement> permissionCheckboxes = utils.getElementsList("xpath", permissionsCheckbox);
		utils.waituntillPageIsloaded();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> selectedPermissionsList = new ArrayList<String>();
		ArrayList<String> unselectedPermissionsList = new ArrayList<String>();
		System.out.println(permissions1.size());
		for (int i = 0; i < permissions1.size(); i++) {
			String permissionName = permissions1.get(i).getAttribute("aria-label");
			list.add(permissionName);
			if (permissionCheckboxes.get(i).getAttribute("class").contains("state-active")) {
				String selectedPermissions = permissions1.get(i).getAttribute("aria-label");
				selectedPermissionsList.add(selectedPermissions);
			} else {
				String unSelectedPermissions = permissions1.get(i).getAttribute("aria-label");
				unselectedPermissionsList.add(unSelectedPermissions);
			}
		}
		Thread.sleep(1000);
//		permissions1.get(permissions1.size() - 1).click();
		Thread.sleep(1000);
		permissions1.get(permissions1.size() - 1).click();
		List<WebElement> permissions2 = utils.getElementsList("xpath", permissionsCheckedAndUnchecked);
		List<WebElement> permission2Checkboxes = utils.getElementsList("xpath", permissionsCheckbox);
		for (int i = 0; i < permissions2.size(); i++) {
			if (permission2Checkboxes.get(i).getAttribute("class").contains("state-active")) {
				String selectedPermissions = permissions2.get(i).getAttribute("aria-label");
				selectedPermissionsList.add(selectedPermissions);
			} else {
				String unSelectedPermissions = permissions2.get(i).getAttribute("aria-label");
				unselectedPermissionsList.add(unSelectedPermissions);
			}
			String permissionsList = permissions2.get(i).getAttribute("aria-label");
			list.add(permissionsList);
		}
		ArrayList<String> TotalListNew = removeDuplicates(list);
		ArrayList<String> selectedPermissionsWithOutDups = removeDuplicates(selectedPermissionsList);
		ArrayList<String> unselectedPermissionsWithOutDups = removeDuplicates(unselectedPermissionsList);
		System.out.println("Total List present -" + TotalListNew);
		System.out.println("selectedPermissionsWithOutDups are-" + selectedPermissionsWithOutDups);
		System.out.println("UnselectedPermissionsWithOutDups are-" + unselectedPermissionsWithOutDups);
		System.out.println("Total List size -" + TotalListNew.size());
		System.out.println("selectedPermissions size -" + selectedPermissionsWithOutDups.size());
		System.out.println("UnselectedPermissions size -" + unselectedPermissionsWithOutDups.size());
		Assert.assertTrue(TotalListNew.size() == 19);
		Assert.assertTrue(selectedPermissionsWithOutDups.size() == 8);
		Assert.assertTrue(unselectedPermissionsWithOutDups.size() == 11);
		utils.element("xpath", permissionsArrow).click();
	}
	
	public void subAgentPermissionsCheckWithOutSubmit() {
		utils.element("xpath", permissionsArrow).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions
				.visibilityOfAllElements(utils.getElementsList("xpath", permissionsCheckedAndUnchecked)));
		List<WebElement> permissions1 = utils.getElementsList("xpath", permissionsCheckedAndUnchecked);
		List<WebElement> permissionCheckboxes = utils.getElementsList("xpath", permissionsCheckbox);
		utils.waituntillPageIsloaded();
		Assert.assertTrue(permissions1.size() == 1);
		if (permissions1.get(0).getAttribute("aria-label").equals("My Commissions")) {
			Assert.assertFalse(permissionCheckboxes.get(0).getAttribute("class").contains("state-active"));
		}
		utils.element("xpath", permissionsArrow).click();
	}
	
	public HashMap<Integer, HashMap<String, String>> manageUsersPageGrid() {
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", impersonate.headerLoc);
		System.out.println("allHeaderNames: " + allHeaderNames);
		HashMap<Integer, HashMap<String, String>> allTableData = new HashMap<Integer, HashMap<String, String>>();
		
		// Get total rows count
		List<WebElement> allRowsEle = utils.getElementsList("cssSelector", impersonate.rowLoc);
		System.out.println("No of rows in grid: " + allRowsEle.size());
		
		for (int i = 1; i <= allRowsEle.size(); i++) {
//			if (i == 10) 	
//				utils.scrollDown();

			// Getting specific row with each iteration
			String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			for (int j = 1; j < 8; j++) {
				
				String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>span:nth-of-type(2)";
			
				String cellValue = "";
					cellValue = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc).getText();

				eachRowData.put(allHeaderNames.get(j-1), cellValue);
			}
			allTableData.put(i, eachRowData);
		}
		System.out.println("Complete Grid data: " + allTableData);
		utils.scrollUp();	
		return allTableData;
		}

	public HashMap<Integer, HashMap<String, String>> issueNewUserRegistrationPageGrid() {
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", impersonate.headerLoc);
		System.out.println("allHeaderNames: " + allHeaderNames);
		HashMap<Integer, HashMap<String, String>> allTableData = new HashMap<Integer, HashMap<String, String>>();
		
		// Get total rows count
		List<WebElement> allRowsEle = utils.getElementsList("cssSelector", impersonate.rowLoc);
		System.out.println("No of rows in grid: " + allRowsEle.size());
		
		for (int i = 1; i <= allRowsEle.size(); i++) {
			String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			for (int j = 1; j < 4; j++) {
				
				String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>span:nth-of-type(2)";
			
				String cellValue = "";
					cellValue = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc).getText();

				eachRowData.put(allHeaderNames.get(j-1), cellValue);
			}
			allTableData.put(i, eachRowData);
		}
		System.out.println("Complete Grid data: " + allTableData);
		utils.scrollUp();	
		return allTableData;
		}

	public WebElement getEditPermissionsLinkInNewUserRegistrationPage(int i) {
		String str="table>tbody>tr:nth-of-type("+i+")>td:nth-of-type(5)>adl-table-cells>div";
		WebElement EditBtn = utils.element("cssSelector", str);
		return EditBtn;
	}
	
	public void precondToStartBrowser() {
//		init();
//		File directory = new File(System.getProperty("user.dir") + "\\PDF");
//		try {
//			FileUtils.cleanDirectory(directory);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String path1 = System.getProperty("user.dir");
//		System.out.println(path1);
//		createscreenshotfolder(path1);
		getDriver();
	}
}
