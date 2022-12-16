package testsuite;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.messageSetupAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

public class ImpersonateNew_test extends impersonateAction{
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();

	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}
	
	@Test(priority = 1)
	public void verifyUsersWithDBForAgent_31615() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Agent", "110");
		Thread.sleep(2000);
		System.out.println(getRows().size());
		System.out.println(getDataFromDB().keySet().size());
		//Assert.assertTrue(getRows().size() == getDataFromDB().keySet().size());
	}
	
	@Test(priority = 2)
	public void verifyUsersWithDBForSubAgent_31616() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("SubAgent", "110");
		Thread.sleep(2000);
		System.out.println(getRows().size());
		System.out.println(getDataFromDB().keySet().size());
		Assert.assertTrue(getRows().size() == getDataFromDB().keySet().size());
	}
	
	@Test(priority = 3)
	public void verifyUsersWithDBForDealer_31617() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Dealer", "28771");
		Thread.sleep(2000);
		System.out.println(getRows().size());
		System.out.println(getDataFromDB().keySet().size());
		Assert.assertTrue(getRows().size() == getDataFromDB().keySet().size());
	}
	
	@Test(priority = 4)
	public void verifyUsersWithDBForDealerEmp_31618() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("DealerEmp", "28771");
		Thread.sleep(2000);
		System.out.println(getRows().size());
		System.out.println(getDataFromDB().keySet().size());
		Assert.assertTrue(getRows().size() == getDataFromDB().keySet().size());
	}
	
	@Test(priority = 5)
	public void verifyUsersWithDBForDealerGrp_31619() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("DealerGroup", "47421");
		Thread.sleep(2000);
		System.out.println(getRows().size());
		System.out.println(getDataFromDB().keySet().size());
		Assert.assertTrue(getRows().size() == getDataFromDB().keySet().size());
	}
	
	@Test(priority = 6)
	public void verifyUsersWithDBForDealerGrpEmp_31620() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("DealerGrpEmp", "47421");
		Thread.sleep(2000);
		System.out.println(getRows().size());
		System.out.println(getDataFromDB().keySet().size());
		Assert.assertTrue(getRows().size() == getDataFromDB().keySet().size());
	}
	
	@Test(priority = 7)
	public void verifyUsersWithDBForLender_31621() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Lender", "30");
		Thread.sleep(2000);
		System.out.println(getRows().size());
		System.out.println(getDataFromDB().keySet().size());
		Assert.assertTrue(getRows().size() == getDataFromDB().keySet().size());
	}
	
	@Test(priority = 8)
	public void verifyUsersWithDBForLenderEmp_31622() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("LenderEmp", "30");
		Thread.sleep(2000);
		System.out.println(getRows().size());
		System.out.println(getDataFromDB().keySet().size());
		Assert.assertTrue(getRows().size() == getDataFromDB().keySet().size());
	}
	
	@Test(priority = 9)
	public void verify() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Agent", "110");
		Assert.assertTrue(impersonate.getImpersonatedPageRoledID().equals("110"),"Impersonated Successfully");
		verticalMenu.navigatetoLeftMenu("E-Rate","Rate/Contract");
		getSelectDealerTogenerateContract();
		getBtnSignIn().click();
		Thread.sleep(2000);
		Assert.assertTrue(impersonate.getImpersonatedPageDealerRoledID().isDisplayed(),"Impersonated Successfully with dealer");
	}
	
	
	//impersonate action discussed with ankit
	@Test(priority = 10)
	public void verifyLockedFunctionality_31629() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Agent", "110");
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		 HashMap<Integer, HashMap<String, WebElement>> tableDataForEditDelLock = checkGridForEditDelLock();
		//System.out.println("status-----------"+allTableData.get(3).get("Registration Status"));
		for(int i=1;i<getRows().size();i++){
		if(allTableData.get(i).get("Registration Status").equals("Completed"))
		{
			tableDataForEditDelLock.get(i).get("Locked Out").click();
			Thread.sleep(2000);
			getBtnYes().click();
			Thread.sleep(2000);
			Assert.assertTrue(tableDataForEditDelLock.get(i).get("Impersonate").isEnabled());
			
			tableDataForEditDelLock.get(i).get("Locked Out").click();
			Thread.sleep(2000);
			Assert.assertFalse(tableDataForEditDelLock.get(i).get("Impersonate").isEnabled());
			break;
		}
		}
	}
	
	
	//bug to be raised
	@Test(priority = 11)
	public void verifyEditFunctionality_31630() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Agent", "110");
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		 HashMap<Integer, HashMap<String, WebElement>> tableDataForEditDelLock = checkGridForEditDelLock();
		 for(int i=1;i<getRows().size();i++){
		 if(allTableData.get(i).get("Registration Status").equals("Completed"))
			{
				tableDataForEditDelLock.get(i).get("Edit").click();
				Assert.assertTrue(getRoletype().isDisplayed());
				Assert.assertTrue(getUserName().isDisplayed());
				Assert.assertTrue(getAccountName().isDisplayed());
				getFirstname().clear();
				getFirstname().sendKeys("abc");
				getLastname().clear();
				getLastname().sendKeys("xyz");
				getEmail().clear();
				getEmail().sendKeys("Divyasree.T@coforge.com");
				getBtnUpdate().click();
				Thread.sleep(2000);
			}
		 }
	}
	
	//create a user to delete
	@Test(priority = 12)
	public void verifyDeleteFunctionality_31631() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Agent", "110");
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		 HashMap<Integer, HashMap<String, WebElement>> tableDataForEditDelLock = checkGridForEditDelLock();
		 for(int i=1;i<getRows().size();i++){
		 if(allTableData.get(i).get("Registration Status").equals("Completed"))
			{
				tableDataForEditDelLock.get(i).get("Delete").click();
				getBtnYes().click();
			}
		 }
	}
	
	@Test(priority = 13)
	public void verifyResendInvitationLink_31632() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Agent", "110");
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		 HashMap<Integer, HashMap<String, WebElement>> tableDataForEditDelLock = checkGridForEditDelLock();
		 for(int i=1;i<getRows().size();i++){
		 if(allTableData.get(i).get("Registration Status").equals("Pending"))
			{
				tableDataForEditDelLock.get(i).get("Resend Invitation").click();
				getBtnSubmit().click();
				Assert.assertTrue(getResendInvitationConfirmMsg().isDisplayed());
				break;
			}
		 }
	}
	
	@Test(priority = 14)
	public void verifyImpersonateFunctionality_31633() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Agent", "110");
		Assert.assertTrue(impersonate.getImpersonatedPageRoledID().equals("110"),"Impersonated Successfully");
	}
	
	
	 @AfterMethod(alwaysRun=true)
	    public void close() throws InterruptedException {
	        login.logout();
	    }


}
