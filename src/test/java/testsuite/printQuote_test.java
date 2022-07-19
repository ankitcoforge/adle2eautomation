package testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.loginAction;
import pageActions.printQuoteAction;
import pageActions.verticalMenuAction;

public class printQuote_test extends printQuoteAction{
	
	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	
	/*************login to the application
	 * @throws InterruptedException *********************/
	@BeforeClass()
	public void login() throws InterruptedException {
		
		navigate();
		lo.login("dvidesdealer", "4558600");
		vo.navigatetoContract();
	}
	
	/********************quote creation test case****************/
	@Test(priority = 1)
    public void createQuote1() throws InterruptedException {
		
		printQuote();		
	    
	}
	
	/***************logout to the application
	 * @throws InterruptedException ********************/
	@AfterClass
	public void close() throws InterruptedException {

		lo.logout();
		
	}
}
