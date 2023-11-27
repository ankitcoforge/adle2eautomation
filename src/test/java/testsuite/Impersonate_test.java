package testsuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageActions.LateralMenuAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.messageSetupAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

/* Divyasree */
/* Total Tc's = 4 */

@Listeners(utils.listnerlogs.class)

public class Impersonate_test extends impersonateAction {

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();

	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction();
	contract_test contract=new contract_test();

	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}
	
	@Test(priority = 1)
	public void verifyContractCreationThroughDealer() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		Thread.sleep(4000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		contract.singleContract1();
	}
	
	@Test(priority = 2)
	public void verifyContractCreationThroughDealerEmp() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("DealerEmp", "28771");
		Thread.sleep(4000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		contract.singleContract1();
	}

	@Test(priority = 3)
	public void verifyContractCreationThroughLender() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Lender", "3641");
		Thread.sleep(4000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		contract.singleContractForLender("#1 Auto Liquidators LLC");
	}

	
//	@Test(priority = 4)
//	public void verifyContractCreationThroughLenderEmp() throws Exception {
//		login.login(prop.getProperty("lenderempAutomation"), prop.getProperty("password"));
//		Thread.sleep(3000);
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("LenderEmp", "3641");
//		Thread.sleep(4000);
//		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
//		Thread.sleep(2000);
//		contract.singleContractForLender("#1 Auto Liquidators LLC");
//	}
	
	@Test(priority = 5)
	public void verifyContractScreen_7635_7636_7637() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Assert.assertTrue(utils.getfield("h3", "To Generate a Quote Sign In as a Dealer").isDisplayed());
		Assert.assertTrue(utils.element("xpath", TypeOrSelectDealerNameTxt).isDisplayed());
		Assert.assertFalse(getBtnSignIn().isEnabled());
		driver.findElement(By.xpath(selectDealerTogenerateContract));
		WebElement ele =utils.element("xpath",selectDealerTogenerateContract);
		ele.click();
		List<WebElement> list = utils.getElementsList("cssselector",dealerOptionsWhileCreatigQuote);
		System.out.println("size is="+list.size());
		Assert.assertTrue(utils.element("xpath", TypeOrSelectDealerNameTxt).isDisplayed());
		String randomWord ="motor";
		ele.sendKeys(randomWord);
		Thread.sleep(2000);
		List<WebElement> filterdList = utils.getElementsList("cssselector",dealerOptionsWhileCreatigQuote);
		for(int i=0;i<filterdList.size();i++) {
			Assert.assertTrue(filterdList.get(i).getText().contains(randomWord));
		}
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Assert.assertFalse(utils.element("xpath", TypeOrSelectDealerNameTxt).isDisplayed());
		Assert.assertTrue(getBtnSignIn().isEnabled());
		//Deletion
		ele.clear();
		Assert.assertTrue(utils.element("xpath", TypeOrSelectDealerNameTxt).isDisplayed());
		Assert.assertFalse(getBtnSignIn().isEnabled());
		
//		ele.sendKeys(Keys.ARROW_DOWN);
//		ele.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		getBtnSignIn().click();
//		Thread.sleep(2000);
	}
//		contract.singleContractForLender("#1 Auto Liquidators LLC");
//		
//	}
	

	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		 try {
				login.logout();
				} catch (Exception e) {
					if(utils.getfield("mat-icon", "close").isDisplayed()) {
					utils.getfield("mat-icon", "close").click();
					}
					login.logout();
			}
	    }
	}

		


