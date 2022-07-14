package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.createContractAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
@Listeners(utils.listnerlogs.class)
public class impersonateContract extends createContractAction {

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	impersonateAction ia = new impersonateAction();
	
	/*************login to the application
	 * @throws InterruptedException *********************/
	@BeforeClass
	public void login() throws InterruptedException {
		
		navigate();
		lo.login(prop.getProperty("adminusername"),prop.getProperty("adminpassword"));
		vo.navigatetoimpersonate();
		ia.impersonateUser("Dealer",prop.getProperty("roleid"));
		vo.navigatetoContract();
		
	}
	
	/*****************Contract creation test case***************/
	@Test(priority = 1, dataProvider ="test1")
    public void createContract1(String[] inputArray) throws InterruptedException {
		
		
		createContract(inputArray);
		
		
	    
	}
	
	/***************logout to the application
	 * @throws InterruptedException ********************/
	@AfterClass
	public void close() throws InterruptedException {
 
		lo.logout();
	}
}