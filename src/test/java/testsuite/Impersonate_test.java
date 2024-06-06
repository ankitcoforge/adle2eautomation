package testsuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

/* Divyasree */
/* Total Tc's = 4 */

@Listeners(utils.listnerlogs.class)

public class Impersonate_test extends impersonateAction {

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();

	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction();
	contract_test contract=new contract_test();

	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}
	
	@Test(priority = 1)
	public void verifyContractCreationThroughDealer() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		Thread.sleep(4000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		contract.singleContract1();
	}
	
	@Test(priority = 2)
	public void verifyContractCreationThroughDealerEmp() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("DealerEmp", "28771");
		Thread.sleep(4000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		contract.singleContract1();
	}

	@Test(priority = 3)
	public void verifyContractCreationThroughLender() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Lender", "3641");
		Thread.sleep(4000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		//contract.singleContractForLender("#1 Auto Liquidators LLC");
	}

//	
//	@Test(priority = 4)
//	public void verifyContractCreationThroughLenderEmp() throws Exception {
//		login.login(prop.getProperty("lenderempAutomation"), prop.getProperty("password"));
//		Thread.sleep(3000);
////		verticalMenu.navigatetoimpersonate();
////		impersonate.impersonateUser("LenderEmp", "3641");
////		Thread.sleep(4000);
//		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
//		Thread.sleep(2000);
//		contract.singleContractForLender("#1 Auto Liquidators LLC");
//	}
	

	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		 try {
				login.logout();
				} catch (Exception e) {
					if(utils.getfield("mat-icon", "close").isDisplayed()) {
					utils.getfield("mat-icon", "close").click();
					}
					login.logout();
			}
	    }
	}

		


