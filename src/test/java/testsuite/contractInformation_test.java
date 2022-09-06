package testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.cobuyerContractAction;
import pageActions.contractInformationAction;
import pageActions.leaseContractAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;

@Listeners(utils.listnerlogs.class)

public class contractInformation_test extends contractInformationAction{

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	singleContractAction sa = new singleContractAction();
	leaseContractAction la = new leaseContractAction();
	cobuyerContractAction cc = new cobuyerContractAction();
	
	
	@BeforeClass
	public void login() throws InterruptedException {

		navigate();

	}

	@Test(priority = 1)
	public void contractInformation() throws InterruptedException {

		contractValidation();

	}
	
	@Test(priority = 2)
	public void contractInformationSPP() throws InterruptedException {

		sppContractValidation();

	}

	@AfterClass
	public void close() throws InterruptedException {

		
	}

}
