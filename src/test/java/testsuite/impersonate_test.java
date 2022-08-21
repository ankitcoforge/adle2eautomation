package testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

@Listeners(utils.listnerlogs.class)

public class impersonate_test extends impersonateAction {

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	utilityClass event = new utilityClass();

	
	@BeforeClass
	public void login() throws InterruptedException {

		navigate();
		lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));

	}

	@Test(priority = 1)
	public void newImpersonate_11485() {

		Assert.assertEquals(loginImpersonate().get(0), "coforgeadmin");
		Assert.assertEquals(loginImpersonate().get(1), "AULadmin");

	}

	@Test(priority = 2)
	public void navigateImpersonate_11564() throws InterruptedException {

		Assert.assertEquals(navigateImpersonate(), "https://qa.adl.aulcorp.com/portal/reports/impersonate");
	}

	@Test(priority = 3)
	public void impersonateOption_11563_11580() throws InterruptedException {

		Assert.assertEquals(impersonateOptions(), "Impersonate");
		event.clickfield("cssSelector", impersonate);
	}

	
	/****** Failing in after method*************/
	
//	@Test(priority = 4, dependsOnMethods = { "impersonateOption_11563_11580"})
//	public void impersonateUser_11566() throws InterruptedException {
//
//		
//		Assert.assertEquals(endImpersonate("Dealer", "22723"), "End Impersonating");
//
//		
//	}
//	
	
	/***************logout to the application
	 * @throws InterruptedException ********************/
	@AfterClass
	public void close() throws InterruptedException {
 
		lo.logout();
	    }
		
	}


