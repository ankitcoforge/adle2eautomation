package testsuite;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.createQuoteAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;


public class quote_test extends createQuoteAction{

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	
	/*************login to the application
	 * @throws InterruptedException *********************/
	@BeforeMethod()
	public void login() throws InterruptedException {
		
		navigate();
		lo.login("Dealer7032823", "4558600");
		vo.navigatetoContract();
	}
	
	/********************quote creation test case****************/
	@Test(priority = 1, dataProvider ="test1")
    public void createQuote1(String [] inputArray) throws InterruptedException {
		
		
		String text = createQuote(inputArray);
		Assert.assertEquals(text, "Your Quote has been successfully saved!");
	    
	}
	
	/***************logout to the application
	 * @throws InterruptedException ********************/
	@AfterClass
	public void close() throws InterruptedException {

		lo.logout();
		driver.close();
		driver = null;
	}
}