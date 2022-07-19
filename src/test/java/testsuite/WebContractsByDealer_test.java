package testsuite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageActions.WebContractsByDealerAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

public class WebContractsByDealer_test extends WebContractsByDealerAction {
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	singleContractAction singleContract=new singleContractAction();

	@BeforeMethod
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}

	@Test(priority = 1)
	public void verifyTitlePage_26894() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Reports", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), "Web Contracts by Dealer");
	}

	@Test(priority = 2)
	public void verifyRoleId_26896() throws InterruptedException {
		String username = prop.getProperty("adminusername");
		login.login(username, prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Reports", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), "Web Contracts by Dealer");
		Assert.assertEquals(getAdminRoleId(), username);
	}

	@Test(priority = 3)
	public void verifyURL_26899() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Reports", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), "Web Contracts by Dealer");
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://qa.adl.aulcorp.com/portal/reports/web-contracts-by-dealer");
	}

	@Test(priority = 4)
	public void verifyURLinAUL_26900() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Reports", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), "Web Contracts by Dealer");
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://qa.adl.aulcorp.com/portal/reports/web-contracts-by-dealer");
		Assert.assertEquals(driver.getCurrentUrl().contains("aul"), true);
	}

	@Test(priority = 5)
    public void verifyNonAdminAccess_26904() throws InterruptedException {
	login.login(prop.getProperty("username"),prop.getProperty("password"));
	leftMenu("Reports");
	for (int i = 0; i < getReportsDropdownlist().size(); i++) {
			Assert.assertFalse(getReportsDropdownlist().get(i).getText().contains("Web Contracts by Dealer"));
	}
	}

	@Test(priority = 6)
	public void verifyRowsPerPage_27164() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Reports", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), "Web Contracts by Dealer");
		getElementInFirstGrid("Dealer ID").sendKeys(prop.getProperty("roleid"));
		getArrowForwardBtn().click();
		Thread.sleep(2000);
		Assert.assertTrue(getContractsGrid().isDisplayed());
		utils.scrollDown();
		Assert.assertTrue(getRowsPerPage().isDisplayed());
		getRowsPerPageDropdownbtn().click();
			String perPage25 = getRowsPerPageDropdownlist().get(0).getText();
			String perPage50 = getRowsPerPageDropdownlist().get(1).getText();
			String perPage100 = getRowsPerPageDropdownlist().get(2).getText();
			Assert.assertTrue(perPage25.equals("25"), "25 is displayed in dropdown");
			Assert.assertTrue(perPage50.equals("50"), "50 is displayed in dropdown");
			Assert.assertTrue(perPage100.equals("100"), "100 is displayed in dropdown");
		
	}

	@Test(priority = 7)
	public void verifyRowsPerPageSelected_27280() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Reports", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), "Web Contracts by Dealer");
		getElementInFirstGrid("Dealer ID").sendKeys(prop.getProperty("roleid"));
		getArrowForwardBtn().click();
		Thread.sleep(2000);
		Assert.assertTrue(getContractsGrid().isDisplayed());
		getRowsPerPageDropdownbtn().click();
		String NoOfRowsToSelect = getRowsPerPageDropdownlist().get(1).getText();
		getRowsPerPageDropdownlist().get(1).click();
		String NoOfRowsSelected = getRowsPerPageSelected().getText();
		Assert.assertEquals(NoOfRowsToSelect, NoOfRowsSelected);
	}

	@Test(priority = 8)
	public void verifyPageNumbers_27310() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Reports", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), "Web Contracts by Dealer");
		getElementInFirstGrid("Dealer ID").sendKeys(prop.getProperty("roleid"));
		getArrowForwardBtn().click();
		Thread.sleep(2000);
		utils.scrollDown();
		getRowsPerPageDropdownbtn().click();
		getRowsPerPageDropdownlist().get(0).click();
		getPageNo("2").click();
		Assert.assertTrue(getCurrentPageRecord() == 26, "Page 2 is displaying");
		getPageNo("5").click();
		Assert.assertTrue(getCurrentPageRecord() == 101, "Page 5 is displaying");
	}

	@Test(priority = 9)
	public void verifyTotalPageNumbersPerPage_27326() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Reports", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), "Web Contracts by Dealer");
		getElementInFirstGrid("Dealer ID").sendKeys(prop.getProperty("roleid"));
		getArrowForwardBtn().click();
		Thread.sleep(2000);
		utils.scrollDown();
		getRowsPerPageDropdownbtn().click();
		getRowsPerPageDropdownlist().get(0).click();
		Assert.assertTrue(getTotalPagesDisplayed() == 5, "five pages are displayed at a time");
	}

	@Test(priority = 10)
	public void verifyTxt_27327() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Reports", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), "Web Contracts by Dealer");
		Assert.assertTrue(getContractsGrid().isDisplayed());
		Assert.assertTrue(getPlsMakeaSearchTxt().isDisplayed());
	}

//	//date validation
//	@Test(enabled=false)
//    public void verifyTitlePage_27315() throws InterruptedException {
//	login.login(prop.getProperty("adminusername"),prop.getProperty("adminpassword"));
//	verticalMenu.navigatetoLeftMenu("Reports","Web Contracts by Dealer");
//	Assert.assertEquals(getTitle(),"Web Contracts by Dealer");
//	getElementInFirstGrid("Dealer ID").sendKeys(prop.getProperty("roleid"));
//	getArrowForwardBtn().click();
//	Thread.sleep(2000);
//	Assert.assertTrue(getContractsGrid().isDisplayed());
//	HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
//	ArrayList<String> listofValues = new ArrayList<>();
//	if(allTableData.size() > 0) {
//		for (int i = 1; i <= allTableData.size(); i++) {
//			HashMap<String, String> getRowData = allTableData.get(i);
//			String value = getRowData.get("Last Name");
//			listofValues.add(value);	
//		}
//		Collections.sort(listofValues);
//		for(int i=0;i <= listofValues.size();i++) {
//			System.out.println(listofValues.get(i));
//		}
//		
//	}	
//	}

	@Test(priority = 11)
	public void verifyUndoEditIcons_27329() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Reports", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), "Web Contracts by Dealer");
		getElementInFirstGrid("Dealer ID").sendKeys(prop.getProperty("roleid"));
		getArrowForwardBtn().click();
		Thread.sleep(2000);
		Assert.assertTrue(getContractsGrid().isDisplayed());
		Actions action = new Actions(driver);
		action.moveToElement(getEditBtns().get(1)).perform();
		Assert.assertTrue(getEditStatusMsg().get(1).isDisplayed());
		getGridArrowBtn("Status");
		verifyRestoreMsgFromRestoreIcon();
	}

	@Test(priority = 12)
	public void verifyNavigationUsingTabs_27340() throws InterruptedException {
		navigate();
		login.login(prop.getProperty("username1"),prop.getProperty("password"));
		verticalMenu.navigatetoContract();
		singleContract.singleContract();
		login.logout();
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Reports", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), "Web Contracts by Dealer");
		Assert.assertTrue(getElementInFirstGrid("Last 6 of VIN").isDisplayed());
		String enterVIN=prop.getProperty("VIN");
		getElementInFirstGrid("Last 6 of VIN").sendKeys(enterVIN);
		getElementInFirstGrid("Last 6 of VIN").sendKeys(Keys.TAB);
		getElementInFirstGrid("Last 6 of VIN").sendKeys(Keys.TAB);
		getElementInFirstGrid("Last 6 of VIN").sendKeys(Keys.TAB);
		getElementInFirstGrid("Last 6 of VIN").sendKeys(Keys.TAB);
		getArrowForwardBtn().click();
		Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
		Assert.assertTrue(getContractsGrid().isDisplayed(),"Navigation Working Correctly");
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
        String VINnumFromGrid = allTableData.get(1).get("VIN");
		Assert.assertTrue(VINnumFromGrid.equals(enterVIN),"Records are matching");
	}
	
	//ContractNumber Hardcoded
	@Test(priority = 13)
	public void verifySearchForContractNumAndContractHoldrLastName_27341() throws InterruptedException {
		navigate();
		login.login(prop.getProperty("username1"),prop.getProperty("password"));
		verticalMenu.navigatetoContract();
		singleContract.singleContract();
		login.logout();
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Reports", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), "Web Contracts by Dealer");
		
		Assert.assertTrue(getElementInFirstGrid("Contract Number").isDisplayed());
		String contractNumber="OCWNA004619G22";
		getElementInFirstGrid("Contract Number").sendKeys(contractNumber);
		
		Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
		String contractHolderLastName = prop.getProperty("lastName");
		getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
		
		Assert.assertTrue(getArrowForwardBtn().isDisplayed());
		getArrowForwardBtn().click();
		Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		
		String ContractNumberInGrid = allTableData.get(1).get("Contract Number");
		Assert.assertTrue(ContractNumberInGrid.equals(contractNumber),"Contract Number Records are matching");
        
		String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
		Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
	}


	@AfterMethod
	public void close() throws InterruptedException {
		login.logout();
	}
}
