package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageActions.bannnerAction;
import pageActions.loginAction;

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
		driver.switchTo().defaultContent();
		//Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		js.executeScript("arguments[0].click();", driver.findElements(By.cssSelector("adl-radio-button input[type=radio]")).get(1));
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		la.logout();
        Assert.assertEquals(driver.findElement(By.cssSelector("adl-banner > div[class=\"banner-container ng-star-inserted\"]")), true);
		
	}
	

}
