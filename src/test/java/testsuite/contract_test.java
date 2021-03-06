package testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
	
	/*************login to the application
	 * @throws InterruptedException *********************/
	@BeforeClass
	public void login() throws InterruptedException {
		
		navigate();
		lo.login("dvidesdealer", "4558600");
		vo.navigatetoContract();
		
	}
	
	@Test(priority = 1)
	 public void singleContract1() throws InterruptedException {
			
			sa.singleContract();
			    
		}
		
	
	@Test(priority = 2)
	 public void leaseContract1() throws InterruptedException {
			
			la.leaseContract();
			    
		}
	
	/*****************Contract creation test case***************/
	@Test(priority = 3, dataProvider ="test1")
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


