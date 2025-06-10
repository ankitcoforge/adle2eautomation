package testsuite;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

/* 36960  PBI is pending*/

public class MultipleAgencyAccounts_test extends impersonateAction{
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();

	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
//		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}
	
	@Test(priority = 1)
	public void verifyAgentCorpHasManageAgenciesInGrid_38248() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("AgentCorp", "393");
		System.out.println(getAllHeaders());
		Assert.assertTrue(getAllHeaders().contains("Manage Agencies"));
		impersonate.getUsers("AgentGroup", "393");
		Assert.assertTrue(getAllHeaders().contains("Manage Agencies"));
		 HashMap<Integer, HashMap<String, WebElement>> grid = impersonate.checkGridForEditDelLock();
		grid.get(1).get("Manage Agencies").click();
        selectOnlyRoleId("393");
		utils.getfield("span", "Save").click();
	}
	
	@Test(priority = 2)
	public void verifyAgentPackaccountsAreAssignedToAgent() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("AgentCorp", "393");
		HashMap<Integer, HashMap<String, WebElement>> grid = impersonate.checkGridForEditDelLock();
		grid.get(1).get("Manage Agencies").click();
        selectOnlyRoleId("429");
		utils.getfield("span", "Save").click();
	}
	
	@Test(priority = 3)
	public void verifyDealerPassthroughaccountsAreAssignedToAgent() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your Protective ADL Portal!");
	}
	
	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
	try {
		login.logout();
	} catch (Exception e) {
	}
	}

}
