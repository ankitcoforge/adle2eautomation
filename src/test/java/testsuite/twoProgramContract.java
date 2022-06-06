package testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.createContractAction;
import pageActions.loginAction;
import pageActions.twoProgramContractAction;
import pageActions.verticalMenuAction;

public class twoProgramContract extends twoProgramContractAction {

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	
	/*************login to the application
	 * @throws InterruptedException *********************/
	@BeforeClass
	public void login() throws InterruptedException {
		
		navigate();
		lo.login("dvidesdealer", "4558600");
		vo.navigatetoContract();
		
	}
	
	/*****************Contract creation test case***************/
	@Test(priority = 1, dataProvider ="test2")
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

