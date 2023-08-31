package testsuite;

import org.openqa.selenium.By;
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

	}

	@Test(priority = 1)
	public void contractInformation() throws InterruptedException {

		contractValidation();

	}
	
	@Test(enabled=false)
	public void contractInformationSPP() throws InterruptedException {

		sppContractValidation();

	}
	
	@Test(enabled=false)
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

	}

}
