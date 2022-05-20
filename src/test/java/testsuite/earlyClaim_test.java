package testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.baseClass;

public class earlyClaim_test extends baseClass{

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	
	
	/*************login to the application
	 * @throws InterruptedException *********************/
	@BeforeClass
	public void login() throws InterruptedException {
		
		navigate();
		lo.login(prop.getProperty("username"),prop.getProperty("password"));
		vo.navigatetoLeftMenu("Reports", "Early Claims");
		
	}
	
	/*****************Contract creation test case***************/
	@Test()
    public void earlyClaim() {
		
		System.out.println("Hello");
		
		
		
	    
	}
	
	/***************logout to the application
	 * @throws InterruptedException ********************/
	@AfterClass
	public void close() throws InterruptedException {
 
		lo.logout();
	}
}
