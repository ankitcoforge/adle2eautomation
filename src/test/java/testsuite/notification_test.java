package testsuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.loginAction;
import pageActions.notificationAction;
import pageActions.verticalMenuAction;
@Listeners(utils.listnerlogs.class)
public class notification_test extends notificationAction{

	loginAction lo = new loginAction();
	

	/*************
	 * login to the application
	 * 
	 * @throws InterruptedException
	 *********************/
	@BeforeClass
	public void login() throws InterruptedException {

		navigate();
		lo.login(prop.getProperty("username"),prop.getProperty("password"));
	}

	
	@Test (priority = 1)
    public void myAccountStatement_23074() {
		
		navigate();
		driver.findElements(By.xpath("//a[contains(text(),'Go to report')]")).get(0).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://qa.adl.aulcorp.com/portal/reports/account-statements");
	}
	
	@Test (priority = 2 )
    public void unpaidAging_23113() {
		
		navigate();
		driver.findElements(By.xpath("//a[contains(text(),'Go to report')]")).get(1).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://qa.adl.aulcorp.com/portal/reports/unpaid-aging");
	}
	
	@Test (priority = 3 )
    public void earlyClaims_23114() {
		
		navigate();
		driver.findElements(By.xpath("//a[contains(text(),'Go to report')]")).get(6).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://qa.adl.aulcorp.com/portal/reports/early-claims");
	}
	
	@Test (priority = 4 )
    public void actuarials() {
		
		navigate();
		driver.findElements(By.xpath("//a[contains(text(),'Go to report')]")).get(2).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://qa.adl.aulcorp.com/portal/reports/actuarials");
	}
	
	@Test (priority = 5 )
    public void contractSearch() {
		
		navigate();
		driver.findElements(By.xpath("//a[contains(text(),'Go to report')]")).get(3).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://qa.adl.aulcorp.com/portal/contracts/contract-search");
	}
	
	@Test (priority = 6 )
    public void cancellation() {
		
		navigate();
		driver.findElements(By.xpath("//a[contains(text(),'Go to report')]")).get(4).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://qa.adl.aulcorp.com/portal/reports/cancellations");
	}
	
	
	
}
