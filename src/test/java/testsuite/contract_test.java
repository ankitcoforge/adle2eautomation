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
<<<<<<< Updated upstream
		lo.login(prop.getProperty("username1"), prop.getProperty("password"));
=======
		lo.login("dvidesdealer", "Test@1234");
		getDriver().findElement(By.cssSelector("button[color=\"white-primary\"]")).click();
>>>>>>> Stashed changes
		vo.navigatetoLeftMenu("E-Rate", "Rate/Contract");

	}

	@Test(priority = 1)
	public void singleContract1() throws InterruptedException {

		sa.singleContract();

	}

<<<<<<< Updated upstream
	@Test(priority = 2)
	public void leinHolderContract1() throws InterruptedException {
=======
	@Test(priority = 2, dependsOnMethods = {"singleContract1"})
	public void leinHolderContract() throws InterruptedException {
>>>>>>> Stashed changes

		sa.singleContract("Bank of America");

	}

	
	@Test(priority = 3)
	public void leaseContract1() throws InterruptedException {

		la.leaseContract();

	}

	@Test(priority = 4)
	public void coBuyerContract() throws InterruptedException {

		cc.coBuyerContract();

	}
	
	@Test(priority = 5)
	public void singleContractForLender(String selectDealer) throws InterruptedException {

		sa.singleContractForLender(selectDealer);

	}
	
<<<<<<< Updated upstream
	
	/***************** Contract creation test case ***************/
	@Test(priority = 3, dataProvider = "test1")
	public void createContract1(String[] inputArray) throws InterruptedException {

		createContract(inputArray);

	}
=======
//	@Test(priority = 6, dataProvider = "lendertest")
//	public void singleContractlender(String[] inputArray) throws Exception {
//
//		createlenderContract(inputArray);
//
//	}
>>>>>>> Stashed changes

	@AfterClass
	public void close() throws InterruptedException {

		lo.logout();
	}

}


