package testsuite;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.cobuyerContractAction;
import pageActions.createContractAction;
import pageActions.leaseContractAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;

@Listeners(utils.listnerlogs.class)
public class contract_test extends createContractAction {

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	singleContractAction sa = new singleContractAction();
	leaseContractAction la = new leaseContractAction();
	cobuyerContractAction cc = new cobuyerContractAction();

	/*************
	 * login to the application
	 * 
	 * @throws InterruptedException
	 *********************/
	@BeforeClass
	public void login() throws InterruptedException {

		
		navigate();
		lo.login(prop.getProperty("username1"), prop.getProperty("password"));
		vo.navigatetoLeftMenu("E-Rate", "Rate/Contract");

	}

	@Test(priority = 1)
	public void singleContract1() throws InterruptedException {

		sa.singleContract();

	}

	@Test(priority = 2)
	public void leaseContract1() throws InterruptedException {

		la.leaseContract();

	}

	@Test(priority = 2)
	public void coBuyerContract() throws InterruptedException {

		;

	}
	
	
	/***************** Contract creation test case ***************/
	@Test(priority = 3, dataProvider = "test1")
	public void createContract1(String[] inputArray) throws InterruptedException {

		createContract(inputArray);

	}

	@AfterClass
	public void close() throws InterruptedException {

		lo.logout();
	}

}


