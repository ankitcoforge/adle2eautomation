package testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.baseClass;

public class myaccountstatement_test extends baseClass{
	
	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	
	@BeforeClass
	public void login() throws InterruptedException {
		
		navigate();
		lo.login("dvidesdealer", "4558600");
		vo.navigatetoLeftMenu("Reports", " My Account Statements ");
		
	}
	
	
	@Test
       public void test() throws InterruptedException {
		
		System.out.println("Hello");
		
	    
	}
	
	/***************logout to the application
	 * @throws InterruptedException ********************/
	@AfterClass
	public void close() throws InterruptedException {
 
	        
	        lo.logout();
	    }
		
	}
	
