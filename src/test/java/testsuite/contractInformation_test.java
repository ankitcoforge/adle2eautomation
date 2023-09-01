package testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageActions.contractInformationAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;

@Listeners(utils.listnerlogs.class)

public class contractInformation_test extends contractInformationAction{

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	
	
	@BeforeClass
	public void login() throws InterruptedException {

		navigate();
		lo.login(prop.getProperty("username1"), prop.getProperty("password"));
		vo.navigatetoLeftMenu("E-Rate", "Rate/Contract");

	}

	@Test(priority = 1)
	public void contractInformation() throws InterruptedException {

		contractValidation();

	}
	
//	@Test(priority = 2)
//	public void contractInformationSPP() throws InterruptedException {
//
//		sppContractValidation();
//
//	}
	
	@Test(priority = 3)
	public void cobuyerValidation() throws InterruptedException {

		cobuyerContractValidation();

	}


	@Test(priority = 4)
	public void upSellProductValidation() throws InterruptedException {

		upSellProduct();
		
	}
	
	@Test(priority = 5)
	public void  showToggleValidation() throws InterruptedException {

		showToggle();
		
	}
	
	@AfterClass
	public void close() throws InterruptedException {

		lo.logout();	
	}

}
