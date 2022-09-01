package testsuite;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageActions.ContractSearchPageAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

public class contractSearchRole_test extends ContractSearchPageAction{

	

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();

	@BeforeClass
	public void agentlogin() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
		
	}
	
	@Test(priority = 1)
	public void headerVerification_20969_20761_21279() throws InterruptedException {
		
//		verticalMenu.navigatetoLeftMenu("Contracts","Contract Search");
		login.login(prop.getProperty("agentusername"), prop.getProperty("agentpassword"));
		verticalMenu.navigatetoLeftMenu("Contracts","Contract Search");
		ArrayList list = new ArrayList<> ();
		list.addAll(Arrays.asList("","Select", "Status","Dealer Name", "Dealer Group", "Remit Date", "CC Reward ID", "Contract", "VIN", "Program", "Lienholder", "Last Name", "Sale Date", "Processed Date", "Retail Price", "AUL Cost", "Cert Form", "Remit Form","" ,"" ,"" ));
	    Assert.assertEquals(dropDownValue(), "Customize");
	    login.logout();
	}
	
	@Test(priority = 2)
	public void headerVerification_() throws InterruptedException {
		
//		verticalMenu.navigatetoLeftMenu("Contracts","Contract Search");
		login.login(prop.getProperty("subagentUsername"), prop.getProperty("subagentPassword"));
		verticalMenu.navigatetoLeftMenu("Contracts","Contract Search");
		ArrayList list = new ArrayList<> ();
		list.addAll(Arrays.asList("","Select", "Status","Dealer Name", "Dealer Group", "Remit Date", "CC Reward ID", "Contract", "VIN", "Program", "Lienholder", "Last Name", "Sale Date", "Processed Date", "Retail Price", "AUL Cost", "Cert Form", "Remit Form","" ,"" ,"" ));
	    Assert.assertEquals(dropDownValue(), "Customize");
	    login.logout();
	}
	
	/***************logout to the application
	 * @throws InterruptedException ********************/
	@AfterClass
	public void close() throws InterruptedException {
 
	        
	    }
		
	
		
}
