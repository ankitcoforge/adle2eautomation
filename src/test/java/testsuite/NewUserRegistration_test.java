package testsuite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import pageObjects.MyCommissionsPO;
import utils.XmlDataReader;
import utils.utilityClass;
import pageActions.NewUserRegistration_Action;
import pageActions.RestoreUsersAction;

/* 27501 */
public class NewUserRegistration_test extends NewUserRegistration_Action {
	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	XmlDataReader UtilsDataReader = new XmlDataReader("UtilsData");
	XmlDataReader employeePacksData = new XmlDataReader("EmployeePacksData");
	EmployeePacks_test packs = new EmployeePacks_test();
	utilityClass utils = new utilityClass();
	LateraMenu_test lateraMenu = new LateraMenu_test();
	Impersonate_test impersonate = new Impersonate_test();
	MyCommissionsPO myCommissions =new MyCommissionsPO();
	RestoreUsersAction ru = new RestoreUsersAction();
	
	@BeforeTest(alwaysRun = true)
	public void openDriver() throws InterruptedException {
			getDriver();
	}


	@Test(priority = 1)
	public void agentRegistrationThroughAdmin_31548_31549() throws InterruptedException {
		String newUserEmail = getEmail();
		navigate();
		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		vo.navigatetoLeftMenu("Account Management", "Impersonate");
		String role="Agent";
		String roleId="393";
		enterRoleIDAndCreateUserThroughAdmin(role, roleId);
		lo.logout();
		getEmailAndCompletenewUserRegistration();
		deleteTheCreatedUser(role, roleId, newUserEmail);
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		ru.selectDealerInmanageUserPage("22723");
		
	}

	@Test(priority = 2)
	public void dealerRegistrationThroughAdmin_31551() throws InterruptedException {
		String newUserEmail = getEmail();
		navigate();
		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		vo.navigatetoLeftMenu("Account Management", "Impersonate");
		String role="Dealer";
		String roleId="22723";
		enterRoleIDAndCreateUserThroughAdmin(role, roleId);
		lo.logout();
		getEmailAndCompletenewUserRegistration();
		deleteTheCreatedUser(role, roleId, newUserEmail);
		utils.getfield("a", "Restore Users").click();
		Assert.assertTrue(utils.getfield("h3", "Restore Users").isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.getusersButton).isDisplayed());
		Assert.assertTrue(utils.element("xpath", impersonate.roleId).isDisplayed());
		ru.selectDealerInmanageUserPage("22723");
		
	}

//	@Test(priority = 3)
//	public void lenderRegistrationThroughAdmin_31556() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("Lender", "3641");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 4)
//	public void subAgentRegistrationThroughAdmin_31647() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("SubAgent", "110");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//		if (utils.getfield("mat-icon", "close").isDisplayed()) {
//			utils.getfield("mat-icon", "close").click();
//		}
//		lo.logout();
//	}
//
//	@Test(priority = 5)
//	public void dealerEmpRegistrationThroughAdmin_31552() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("DealerEmp", "22723");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 6)
//	public void dealerGrpRegistrationThroughAdmin_31554() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("DealerGroup", "22723");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 7)
//	public void dealerGrpEmpRegistrationThroughAdmin_31555() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("DealerGroupEmp", "22723");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 8)
//	public void lenderEmpRegistrationThroughAdmin_31557() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("LenderEmp", "30");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 9)
//	public void subAgentNewUserRegistrationThroughAgent_31648_31562() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
////		vo.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
////		selectDealerInmanageUserPage();
//		vo.navigatetoLeftMenu("Agency Settings", "Manage Users");
//		utils.waituntillPageIsloaded();
//		getNewUserPageWithAccountNameSelection("SubAgent");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 10)
//	public void dealerNewUserRegistrationThroughAgent_31563() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
////		vo.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
////		selectDealerInmanageUserPage();
//		vo.navigatetoLeftMenu("Agency Settings", "Manage Users");
//		utils.waituntillPageIsloaded();
//		getNewUserPageWithAccountNameSelection("Dealer");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 11)
//	public void dealerEmpNewUserRegistrationThroughAgent_31564() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
////		vo.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
////		selectDealerInmanageUserPage();
//		vo.navigatetoLeftMenu("Agency Settings", "Manage Users");
//		utils.waituntillPageIsloaded();
//		getNewUserPageWithAccountNameSelection("DealerEmp");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 12)
//	public void dealerEmpNewUserRegistrationThroughDealer_31569() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		getNewUserForDealerEmpThroughDealer();
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 13)
//	public void dealerNewUserRegistrationThroughDealerGrp_31570() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		getNewUserPageWithAccountNameSelection("Dealer");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 14)
//	public void dealerEmpNewUserRegistrationThroughDealerGrp_31571() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		getNewUserPageWithAccountNameSelection("DealerEmp");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 15)
//	public void dealerGrpEmpNewUserRegistrationThroughDealerGrp_31572() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		getNewUserPageWithoutAccountNameSelection("DealerGrpEmp");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 16)
//	public void dealerNewUserRegistrationThroughLender_31573() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		getNewUserPageWithAccountNameSelection("Dealer");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 17)
//	public void dealerEmpNewUserRegistrationThroughLender_31574() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		getNewUserPageWithAccountNameSelection("DealerEmp");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 18)
//	public void lenderEmpNewUserRegistrationThroughLender_31577() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		getNewUserPageWithoutAccountNameSelection("LenderEmp");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 19)
//	public void verifyNewUserRegistrationPage_31634() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("Dealer", "22723");
//		lo.logout();
//		openNewUserRegistrationPage();
//		Assert.assertTrue(utils.element("xpath", username).isDisplayed());
//		Assert.assertTrue(getElement("First Name").isDisplayed());
//		Assert.assertTrue(getElement("Last Name").isDisplayed());
//		Assert.assertTrue(getElement("Password").isDisplayed());
//		Assert.assertTrue(getElement("Confirm Password").isDisplayed());
//		Assert.assertTrue(utils.getfield("span", "Register").isDisplayed());
////		lo.logout();
////		driver.close();
//	}
//
//	@Test(priority = 20)
//	public void verifyNewUserRegistrationPageForDealerRole_31635() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("Dealer", "22723");
//		lo.logout();
//		openNewUserRegistrationPage();
//		getElement("First Name").sendKeys(prop.getProperty("firsName"));
//		getElement("Last Name").sendKeys(prop.getProperty("lastName"));
//		getElement("Password").sendKeys(prop.getProperty("password"));
//		getElement("Confirm Password").sendKeys(prop.getProperty("password"));
//		utils.getfield("span", "Register").click();
//		Assert.assertTrue(utils.getfield("p", "Your registration has been completed successfully.").isDisplayed());
////		lo.logout();
////		driver.close();
//	}
//
//	@Test(priority = 21)
//	public void verifyErrorMsgInNewUserRegistrationPage_31636() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("Dealer", "22723");
//		lo.logout();
//		openNewUserRegistrationPage();
//		getElement("First Name").clear();
//		getElement("Last Name").clear();
//		getElement("Password").clear();
//		getElement("Confirm Password").clear();
//		utils.getfield("span", "Register").click();
//		Assert.assertTrue(getErrorMsg("First Name").isDisplayed());
//		Assert.assertTrue(getErrorMsg("Last Name").isDisplayed());
//		Assert.assertTrue(getErrorMsg("Password").isDisplayed());
//		Assert.assertTrue(getErrorMsg("Confirm Password").isDisplayed());
////		lo.logout();
////		driver.close();
//	}
//
//	@Test(priority = 22)
//	public void verifyPasswordFieldInNewUserRegistrationPage_31637() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("Dealer", "22723");
//		lo.logout();
//		openNewUserRegistrationPage();
//		getElement("First Name").sendKeys(prop.getProperty("firsName"));
//		getElement("Last Name").sendKeys(prop.getProperty("lastName"));
//		getElement("Password").sendKeys(prop.getProperty("incorrectpassword"));
//		utils.getfield("span", "Register").click();
//		Assert.assertTrue(getErrorMsg("Password").getText().equals("Password does not meet requirements"));
////		lo.logout();
////		driver.close();
//	}
//
//	@Test(priority = 23)
//	public void verifyPasswordsDoestntMatch_31638() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("Dealer", "22723");
//		lo.logout();
//		openNewUserRegistrationPage();
//		getElement("First Name").sendKeys(prop.getProperty("firsName"));
//		getElement("Last Name").sendKeys(prop.getProperty("lastName"));
//		getElement("Password").sendKeys(prop.getProperty("incorrectpassword"));
//		getElement("Confirm Password").sendKeys(prop.getProperty("password"));
//		utils.getfield("span", "Register").click();
//		Assert.assertTrue(getErrorMsg("Confirm Password").getText().equals("Passwords don't match"));
////		lo.logout();
////		driver.close();
//	}
//
//	@Test(priority = 24)
//	public void verifyNewUserRegistrationPage_31640() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("Dealer", "22723");
//		lo.logout();
//		openNewUserRegistrationPage();
//		getElement("First Name").sendKeys(prop.getProperty("firsName"));
//		getElement("Last Name").sendKeys(prop.getProperty("lastName"));
//		getElement("Password").sendKeys(prop.getProperty("password"));
//		getElement("Confirm Password").sendKeys(prop.getProperty("password"));
//		utils.getfield("span", "Register").click();
//		Assert.assertTrue(utils.getfield("p", "Your registration has been completed successfully.").isDisplayed());
//		openNewUserRegistrationPage();
//		Assert.assertTrue(utils.getfield("h1", "We are sorry.").isDisplayed());
////		lo.logout();
////		driver.close();
//	}
//
//	@Test(priority = 25)
//	public void verifyNewUserRegistrationPageForAgentRole_31642() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("Agent", "110");
//		lo.logout();
//		openNewUserRegistrationPage();
//		getElement("First Name").sendKeys(prop.getProperty("firsName"));
//		getElement("Last Name").sendKeys(prop.getProperty("lastName"));
//		getElement("Password").sendKeys(prop.getProperty("password"));
//		getElement("Confirm Password").sendKeys(prop.getProperty("password"));
//		utils.getfield("span", "Register").click();
//		Assert.assertTrue(utils.getfield("p", "Your registration has been completed successfully.").isDisplayed());
////		lo.logout();
////		driver.close();
//	}
//
//	@Test(priority = 26)
//	public void verifyNewUserRegistrationPageForLenderRole_31642() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("Lender", "30");
//		lo.logout();
//		openNewUserRegistrationPage();
//		getElement("First Name").sendKeys(prop.getProperty("firsName"));
//		getElement("Last Name").sendKeys(prop.getProperty("lastName"));
//		getElement("Password").sendKeys(prop.getProperty("password"));
//		getElement("Confirm Password").sendKeys(prop.getProperty("password"));
//		utils.getfield("span", "Register").click();
//		Assert.assertTrue(utils.getfield("p", "Your registration has been completed successfully.").isDisplayed());
////		lo.logout();
////		driver.close();
//	}
//
//	@Test(priority = 27)
//	public void verifySubAgentPermissionsCreatedByAdmin_31550() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleRoleIdAndGetUsers("SubAgent", "110");
//		openNewUserPopup();
//		utils.element("xpath", permissionsArrow).click();
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions
//				.visibilityOfAllElements(utils.getElementsList("xpath", permissionsCheckedAndUnchecked)));
//		List<WebElement> permissions1 = utils.getElementsList("xpath", permissionsCheckedAndUnchecked);
//		List<WebElement> permissionCheckboxes = utils.getElementsList("xpath", permissionsCheckbox);
//		utils.waituntillPageIsloaded();
//		Assert.assertTrue(permissions1.size() == 1);
//		if (permissions1.get(0).getAttribute("aria-label").equals("My Commissions")) {
//			Assert.assertFalse(permissionCheckboxes.get(0).getAttribute("class").contains("state-active"));
//		}
//		utils.element("xpath", permissionsArrow).click();
//		ClickOnSubmit();
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//		if (utils.getfield("mat-icon", "close").isDisplayed()) {
//			utils.getfield("mat-icon", "close").click();
//		}
//		vo.navigatetoLeftMainMenu("Report");
//		ArrayList<String> subItemslist = new ArrayList<String>();
//		for (int i = 0; i < lateraMenu.getLaterMenuSubItems().size(); i++) {
//			String submenuItem = lateraMenu.getLaterMenuSubItems().get(i).getText();
//			subItemslist.add(submenuItem);
//		}
//		System.out.println("submenu Items are -" + subItemslist);
//		Assert.assertFalse(subItemslist.contains("My Commissions"));
//	}
//
//	@Test(priority = 28)
//	public void verifyDealerEmpPermissionsCreatedByAdmin_31649() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleRoleIdAndGetUsers("DealerEmp", "22723");
//		openNewUserPopup();
//		validatePermissionsForDealerEmp();
//	}
//
//	@Test(priority = 29)
//	public void verifyDealerGrpEmpPermissionsCreatedByAdmin_31650() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleRoleIdAndGetUsers("DealerGrpEmp", "47421");
//		openNewUserPopup();
//validateDealerGrpPermissions();
//	}
//
//	@Test(priority = 30)
//	public void verifyLenderEmpPermissionsCreatedByAdmin_31651() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleRoleIdAndGetUsers("LenderEmp", "3641");
//		openNewUserPopup();
//		validatePermissionsForLenderEmp();
//	}
//
//	@Test(priority = 31)
//	public void verifyDealerEmpPermissionsCreatedByLender_31653() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		utils.waituntillPageIsloaded();
//		vo.navigatetoimpersonate();
//		impersonate.impersonateUser("Lender", "3641");
//		utils.waituntillPageIsloaded();
////		lo.login(prop.getProperty("lenderAutomation"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		clickOnNewUserAndselectDealerAccountNameEmailWithoutSubmit("DealerEmp");
//		validatePermissionsForDealerEmp();
//	}
//
//	@Test(priority = 32)
//	public void verifyLenderEmpPermissionsCreatedByLender_31652() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		utils.waituntillPageIsloaded();
//		vo.navigatetoimpersonate();
//		impersonate.impersonateUser("Lender", "3641");
//		utils.waituntillPageIsloaded();
////		lo.login(prop.getProperty("lenderempAutomation"), prop.getProperty("password"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		NewUserPageWithoutAccountNameSelectionandSubmit("LenderEmp");
//		validatePermissionsForLenderEmp();
//	}
//
//	@Test(priority = 33)
//	public void verifySubAgentPermissionsCreatedByagent_31655() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		utils.waituntillPageIsloaded();
//		vo.navigatetoimpersonate();
//		impersonate.impersonateUser("Agent", "110");
//		utils.waituntillPageIsloaded();
////		lo.login(prop.getProperty("agentAutomation"),prop.getProperty("password"));
//		vo.navigatetoLeftMenu("Agency Settings", "Manage Users");
//		utils.waituntillPageIsloaded();
//		clickOnNewUserAndselectDealerAccountNameEmailWithoutSubmit("SubAgent");
//		utils.element("xpath", permissionsArrow).click();
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions
//				.visibilityOfAllElements(utils.getElementsList("xpath", permissionsCheckedAndUnchecked)));
//		List<WebElement> permissions1 = utils.getElementsList("xpath", permissionsCheckedAndUnchecked);
//		List<WebElement> permissionCheckboxes = utils.getElementsList("xpath", permissionsCheckbox);
//		utils.waituntillPageIsloaded();
//		Assert.assertTrue(permissions1.size() == 1);
//		if (permissions1.get(0).getAttribute("aria-label").equals("My Commissions")) {
//			Assert.assertFalse(permissionCheckboxes.get(0).getAttribute("class").contains("state-active"));
//		}
//		utils.element("xpath", permissionsArrow).click();
//		ClickOnSubmit();
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//		if (utils.getfield("mat-icon", "close").isDisplayed()) {
//			utils.getfield("mat-icon", "close").click();
//		}
//		vo.navigatetoLeftMainMenu("Report");
//		ArrayList<String> subItemslist = new ArrayList<String>();
//		for (int i = 0; i < lateraMenu.getLaterMenuSubItems().size(); i++) {
//			String submenuItem = lateraMenu.getLaterMenuSubItems().get(i).getText();
//			subItemslist.add(submenuItem);
//		}
//		System.out.println("submenu Items are -" + subItemslist);
//		Assert.assertFalse(subItemslist.contains("My Commissions"));
//	}
//
//	@Test(priority = 34)
//	public void verifyDealerEmpPermissionsCreatedByAgent_31656() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		utils.waituntillPageIsloaded();
//		vo.navigatetoimpersonate();
//		impersonate.impersonateUser("Agent", "393");
//		utils.waituntillPageIsloaded();
////		lo.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Agency Settings", "Manage Users");
//		utils.waituntillPageIsloaded();
//		clickOnNewUserAndselectDealerAccountNameEmailWithoutSubmit("DealerEmp");
//		validatePermissionsForDealerEmp();
//	}
//
//	@Test(priority = 35)
//	public void verifyDealerEmpPermissionsCreatedByDealer_31657() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		utils.waituntillPageIsloaded();
//		vo.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", "22723");
//		utils.waituntillPageIsloaded();
////		lo.login(prop.getProperty("dealerAutomation"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		utils.getfield("span", "+ New user").isEnabled();
//		utils.getfield("span", "+ New user").click();
//		utils.waitTillElementIsVisible(email);
//		utils.element("xpath", email).sendKeys(newemail);
//		validatePermissionsForDealerEmp();
//	}
//
//	@Test(priority = 36)
//	public void verifyDealerEmpPermissionsCreatedByDealerGrp_31658() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		utils.waituntillPageIsloaded();
//		vo.navigatetoimpersonate();
//		impersonate.impersonateUser("DealerGroup", "47421");
//		utils.waituntillPageIsloaded();
////		lo.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		clickOnNewUserAndselectDealerAccountNameEmailWithoutSubmit("DealerEmp");
//		validatePermissionsForDealerEmp();
//	}
//
//	@Test(priority = 37)
//	public void dealerNewUserRegistrationThroughLenderEmp_32118() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("lenderempAutomation"), prop.getProperty("password"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		getNewUserPageWithAccountNameSelection("Dealer");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 38)
//	public void dealerEmpNewUserRegistrationThroughLenderEmp_32119() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("lenderempAutomation"), prop.getProperty("password"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		getNewUserPageWithAccountNameSelection("DealerEmp");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//
//	@Test(priority = 39)
//	public void lenderEmpNewUserRegistrationThroughLenderEmp_32122() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("lenderempAutomation"), prop.getProperty("password"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		getNewUserPageWithoutAccountNameSelection("LenderEmp");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//	
//	@Test(priority = 40)
//	public void verifyEditsPermissionsForSubagentDealerEmpDealerGrpThroughAgent_31952() throws InterruptedException {
//		navigate();
//		lo.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
//		vo.navigatetoLeftMenu("Agency Settings", "Manage Users");
//		utils.waituntillPageIsloaded();
//		 utils.element("xpath", registrationStatusArrow).click();
//		 utils.element("xpath", completedCheckbox).click();
//		 utils.element("xpath", registrationStatusArrow).click();
//		 Thread.sleep(1000);
//		 HashMap<Integer, HashMap<String, String>> allTableData = manageUsersPageGrid();
//		 HashMap<Integer, HashMap<String, WebElement>> tableDataForEditDelLock = impersonate.checkGridForEditDelLock();
//			for(int i=1;i<=impersonate.getRows().size();i++){
//			if(allTableData.get(i).get("Role Type").equals("SubAgent") && allTableData.get(i).get("Registration Status").equals("Completed") )
//			{
//				tableDataForEditDelLock.get(i).get("Edit").click();
//				subAgentPermissionsCheckWithOutSubmit();
//				break;
//			}
//			}
//	}
//
//	@Test(priority = 41)
//	public void verifyEditPermissionsForDealerEmpThroughDealer_31995() throws InterruptedException {
//		navigate();
//		lo.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
//		vo.navigatetoLeftMenu("My Settings", "Issue New User Registration");
//		utils.waituntillPageIsloaded();
//		 utils.element("xpath", registrationStatusArrowNewUserPage).click();
//		 utils.element("xpath", completedCheckbox).click();
//		 utils.element("xpath", registrationStatusArrow).click();
//		 Thread.sleep(1000);
//		 HashMap<Integer, HashMap<String, String>> allTableData = issueNewUserRegistrationPageGrid();
//			for(int i=1;i<=impersonate.getRows().size();i++){
//				System.out.println("reg status--"+allTableData.get(i).get("Registration Status"));
//			if(allTableData.get(i).get("Registration Status").equals("Completed") )
//			{
//				getEditPermissionsLinkInNewUserRegistrationPage(1).click();
//				validatePermissionsForDealerEmpWithoutSubmit();
//				break;
//			}
//			}
//	}
//	
//	@Test(priority = 42)
//	public void agentPacksRegistrationThroughAdmin_35635() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("Agent Pack", "1991");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//	
//	@Test(priority = 43)
//	public void dealerPassThroughRegistrationThroughAdmin_35636() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("Dealer Pass Through", "1271");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//	
//	@Test(priority = 44)
//	public void lenderPassThroughRegistrationThroughAdmin_35637() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("Lender Pass Through", "1970");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//	
//	@Test(priority = 45)
//	public void integrationPartnerThroughRegistrationThroughAdmin_35638() throws InterruptedException {
//		getEmail();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoLeftMenu("Account Management", "Impersonate");
//		enterRoleIDAndCreateUserThroughAdmin("Integration Partner Pack", "2");
//		lo.logout();
//		getEmailAndCompletenewUserRegistration();
//	}
//	
//	@Test(priority = 47)
//	public void verifyLateralMenuItemsForForAgentPackDealerLenderPassthroughIntegrationPack_35639() throws InterruptedException {
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoimpersonate();
//		impersonate.impersonateUser("Agent Pack", "1991");
//		utils.waituntillPageIsloaded();
//		ArrayList<String> list = new ArrayList<String>();
//			String[] menuItem =lateraMenu.getLateralMenuItems2().get(0).getText().split("chevron_right");
//			list.add(menuItem[0].trim());
//			String[] menuItem1 =lateraMenu.getLateralMenuItems1().get(0).getText().split("chevron_right");
//			list.add(menuItem1[0].trim());
//		Assert.assertTrue(list.contains("Dashboard"));
//		Assert.assertTrue(list.contains("Report"));
//		vo.navigatetoLeftMainMenu("Report");
//		Assert.assertTrue(lateraMenu.getLaterMenuSubItems().get(0).getText().contains("My Commissions"));
//		lo.logout();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer Pass Through", "1271");
//		utils.waituntillPageIsloaded();
//		Assert.assertTrue(list.contains("Dashboard"));
//		Assert.assertTrue(list.contains("Report"));
//		vo.navigatetoLeftMainMenu("Report");
//		Assert.assertTrue(lateraMenu.getLaterMenuSubItems().get(0).getText().contains("My Commissions"));
//		lo.logout();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoimpersonate();
//		impersonate.impersonateUser("Lender Pass Through", "1970");
//		utils.waituntillPageIsloaded();
//		Assert.assertTrue(list.contains("Dashboard"));
//		Assert.assertTrue(list.contains("Report"));
//		vo.navigatetoLeftMainMenu("Report");
//		Assert.assertTrue(lateraMenu.getLaterMenuSubItems().get(0).getText().contains("My Commissions"));
//		lo.logout();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoimpersonate();
//		impersonate.impersonateUser("Integration Partner Pack", "2");
//		utils.waituntillPageIsloaded();
//		Assert.assertTrue(list.contains("Dashboard"));
//		Assert.assertTrue(list.contains("Report"));
//		vo.navigatetoLeftMainMenu("Report");
//		Assert.assertTrue(lateraMenu.getLaterMenuSubItems().get(0).getText().contains("My Commissions"));
//	}
//	
//	@Test(priority = 48)
//	public void verifyMyCommissionsPageForAgentPackDealerLenderPassthroughIntegrationPack_35640() throws InterruptedException {
//		getEmail();
//		navigate();
//		navigate();
//		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		vo.navigatetoimpersonate();
//		impersonate.impersonateUser("Agent Pack", "1991");
//		utils.waituntillPageIsloaded();
//		vo.navigatetoLeftMenu("Report", "My Commissions");
//		utils.waitTillElementIsVisible(myCommissions.myCommissionsTitle);
//		utils.element("xpath", myCommissions.CoustNameNumVIN).sendKeys("ab");
//		Assert.assertTrue(utils.element("xpath", myCommissions.yearArrow).isDisplayed());
//		Assert.assertTrue(utils.element("xpath", myCommissions.monthArrow).isDisplayed());
//		utils.element("xpath", myCommissions.arrowForward).click();
//		Assert.assertTrue(utils.getElementsList("xpath", myCommissions.rows).size() > 0);
//		
//	}
//	
//	

	@AfterTest(alwaysRun = true)
	public void close() throws InterruptedException {
//		try {
//			lo.logout();
//		} catch (Exception e) {
//			if (utils.getfield("mat-icon", "close").isDisplayed()) {
//				utils.getfield("mat-icon", "close").click();
//			}
//			lo.logout();
//			driver.close();
//			Thread.sleep(500);
//			getDriver();
//		}
	}
}
