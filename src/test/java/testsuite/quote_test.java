package testsuite;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.createQuoteAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
@Listeners(utils.listnerlogs.class)

public class quote_test extends createQuoteAction{

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
	
	/********************quote creation test case****************/
	@Test(priority = 2, dataProvider ="test1")
    public void createQuote1(String [] inputArray) throws InterruptedException {
		
		
		createQuote(inputArray);
		
	    
	}
	
	/***************logout to the application
	 * @throws InterruptedException ********************/
	@AfterClass
	public void close() throws InterruptedException {

		lo.logout();
		
	}
}