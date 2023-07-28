package testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.cobuyerContractAction;
import pageActions.createContractAction;
import pageActions.leaseContractAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;

public class inflatoryPrice extends createContractAction {
	
	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	singleContractAction sa = new singleContractAction();
	leaseContractAction la = new leaseContractAction();
	cobuyerContractAction cc = new cobuyerContractAction();

	@BeforeClass
	public void login() throws InterruptedException {
		
		navigate();
	}

	@Test(priority = 1, dataProvider = "test1")
	public void singleContract1(String[] inputArray) throws Exception {

		sa.inflatoryPrice(inputArray);

	}
	

	@Test(priority = 1, dataProvider = "lendertest")
	public void singleContractlender(String[] inputArray) throws Exception {

		sa.inflatoryLenderPrice(inputArray);

	}
}
