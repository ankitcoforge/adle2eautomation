package testsuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageActions.bannnerAction;
import pageActions.loginAction;
import utils.baseClass;

public class loginBanner_test extends bannnerAction {

	
	loginAction la = new loginAction();
	
	/*************login to the application
	 * @throws InterruptedException *********************/
	@BeforeClass
	public void login() throws InterruptedException {
		
		navigate();
		
	}
	
	/*************login to the application*********************/
	@Test
    public void loggedBanner() throws InterruptedException {
		
		la.login("coforgeadmin", "TAdmin54!");
		driver.get("https://qa.adl.aulcorp.com/portal/message-setup");
		driver.findElement(By.cssSelector("div >h3")).isDisplayed();
		Thread.sleep(5000);
		Assert.assertEquals(disabledBanner(), "Disabled");
		la.logout();
		
	}
	

}
