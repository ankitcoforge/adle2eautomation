package testsuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.erateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import pageObjects.loginpo;
import pageObjects.verticalMenupo;

public class erate_test extends erateAction {

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();

	/*************
	 * login to the application
	 * 
	 * @throws InterruptedException
	 *********************/
	@BeforeClass
	public void login() throws InterruptedException {

		navigate();
		lo.login("Dealer7032823", "4558600");
		vo.navigatetoContract();

	}

	@Test
	public void quickcode() {
 
		Assert.assertEquals(qc(), true);
		Assert.assertEquals(noVin(), true);
		Assert.assertEquals(state(), true);
		Assert.assertEquals(mandatory(), true);
		Assert.assertEquals(dropdown(), true);
		Assert.assertEquals(businessUse(), true);
		Assert.assertEquals(programListed(),2);
	}

	/***************
	 * logout to the application
	 * 
	 * @throws InterruptedException
	 ********************/
	@AfterClass
	public void close() throws InterruptedException {

		lo.logout();
	}

}
