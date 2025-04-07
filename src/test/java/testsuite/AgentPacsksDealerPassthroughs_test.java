package testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageActions.MyCommissionsAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.baseClass;
import utils.utilityClass;

/* PBI 35236 */
/*implemented by Divyasree*/
public class AgentPacsksDealerPassthroughs_test extends baseClass{

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();
	MyCommissionsAction myCommissions = new MyCommissionsAction();

	@BeforeClass(alwaysRun = true)
	public void login() throws InterruptedException {
//		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}
	
	@Test(priority = 1)
	public void verifyAgentPacks_35639_35640() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForAgentPacksDealerPassthroughs("Agent Pack", "2337");
		Assert.assertTrue(verticalMenu.getLateralMenuItems2().get(0).getText().contains("Dashboard"));
		Assert.assertTrue(verticalMenu.getLateralMenuItems1().get(0).getText().contains("Report"));
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("My Commissions"));
		verticalMenu.navigatetoLeftMenu("My Commissions");
        utils.element("xpath", myCommissions.CoustNameNumVIN).sendKeys("brown");
        utils.element("xpath", myCommissions.yearArrow).click();
        utils.selectDropdown("2023");
        utils.element("xpath", myCommissions.monthArrow).click();
        utils.selectDropdown("April");
        utils.element("xpath", myCommissions.arrowForward).click();
        Assert.assertTrue(utils.getElementsList("xpath", myCommissions.rows).size()>0);
	}
	
	@Test(priority = 2)
	public void verifyDealerPassthrough_39580_39583() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUserForAgentPacksDealerPassthroughs("Dealer Pass Through", "2593");
		Assert.assertTrue(verticalMenu.getLateralMenuItems2().get(0).getText().contains("Dashboard"));
		Assert.assertTrue(verticalMenu.getLateralMenuItems1().get(0).getText().contains("Report"));
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("My Commissions"));
		verticalMenu.navigatetoLeftMenu("My Commissions");
        utils.element("xpath", myCommissions.CoustNameNumVIN).sendKeys("brown");
        utils.element("xpath", myCommissions.yearArrow).click();
        utils.selectDropdown("2021");
        utils.element("xpath", myCommissions.monthArrow).click();
        utils.selectDropdown("December");
        utils.element("xpath", myCommissions.arrowForward).click();
        Assert.assertTrue(utils.getElementsList("xpath", myCommissions.rows).size()>0);
	}
	
	@Test(priority = 3)
	public void verifyLenderPassthrough_39581_39584() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUserUserForAgentPacksDealerPassthroughs("Lender Pass Through", "1585");
		Assert.assertTrue(verticalMenu.getLateralMenuItems2().get(0).getText().contains("Dashboard"));
		Assert.assertTrue(verticalMenu.getLateralMenuItems1().get(0).getText().contains("Report"));
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("My Commissions"));
		verticalMenu.navigatetoLeftMenu("My Commissions");
        utils.element("xpath", myCommissions.CoustNameNumVIN).sendKeys("brown");
        utils.element("xpath", myCommissions.yearArrow).click();
        utils.selectDropdown("2021");
        utils.element("xpath", myCommissions.monthArrow).click();
        utils.selectDropdown("December");
        utils.element("xpath", myCommissions.arrowForward).click();
        Assert.assertTrue(utils.getElementsList("xpath", myCommissions.rows).size()>0);
	}
	
	@Test(priority = 4)
	public void verifyIntegrationPartnerPack_39582_39585() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUserUserForAgentPacksDealerPassthroughs("Integration Partner Pack", "2");
		Assert.assertTrue(verticalMenu.getLateralMenuItems2().get(0).getText().contains("Dashboard"));
		Assert.assertTrue(verticalMenu.getLateralMenuItems1().get(0).getText().contains("Report"));
		verticalMenu.navigatetoLeftMainMenu("Report");
		Assert.assertTrue(verticalMenu.getLaterMenuSubItems().get(0).getText().contains("My Commissions"));
		verticalMenu.navigatetoLeftMenu("My Commissions");
        utils.element("xpath", myCommissions.CoustNameNumVIN).sendKeys("brown");
        utils.element("xpath", myCommissions.yearArrow).click();
        utils.selectDropdown("2021");
        utils.element("xpath", myCommissions.monthArrow).click();
        utils.selectDropdown("December");
        utils.element("xpath", myCommissions.arrowForward).click();
        Assert.assertTrue(utils.getElementsList("xpath", myCommissions.rows).size()>0);
	}
	
	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		try {
			login.logout();
		} catch (Exception e) {
		}
	}
	
	
}
