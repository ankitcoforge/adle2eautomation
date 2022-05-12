package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.createContractAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;

public class impersonateContract extends createContractAction {

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	
	/*************login to the application
	 * @throws InterruptedException *********************/
	@BeforeClass
	public void login() throws InterruptedException {
		
		navigate();
		lo.login("coforgeadmin", "TAdmin54!");
		vo.impersonateUser();
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