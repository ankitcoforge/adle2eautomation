package testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.createContractAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;

public class validatePDF_test extends createContractAction{
	
	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	
	/*************login to the application
	 * @throws InterruptedException *********************/
	@BeforeClass
	public void login() throws InterruptedException {
		
		navigate();
		lo.login(prop.getProperty("username1"),prop.getProperty("password"));
		vo.navigatetoContract();
		
	}
	
	/*****************Contract creation test case***************/
	@Test(priority = 1, dataProvider ="test1")
    public void createContract1(String[] inputArray) throws InterruptedException {
		
		
	   validatePDFContract(inputArray);
		
		
	    
	}
	
	private void validatePDFContract(String[] inputArray) {
		// TODO Auto-generated method stub
		
	}

	/***************logout to the application
	 * @throws InterruptedException ********************/
	@AfterClass
	public void close() throws InterruptedException {
 
		lo.logout();
	}


}