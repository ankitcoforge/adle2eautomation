package testsuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.baseClass;
import utils.utilityClass;

public class SPPcontract_test extends baseClass{
	
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	contractInformation_test contractTest=new contractInformation_test();

	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}

	@Test(priority = 1 )
	public void verifySPPcontractCreation_34156_34157() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		contractTest.sppContractValidation("New Vehicle - RSE");
	}

	 @AfterMethod(alwaysRun=true)
	    public void close() throws InterruptedException {
		 try {
				login.logout();
				} catch (Exception e) {
			}
	    }
}
