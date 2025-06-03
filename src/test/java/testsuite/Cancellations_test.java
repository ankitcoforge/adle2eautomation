package testsuite;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.CancellationsAction;
import pageActions.LateralMenuAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.CalenderUtils;
import utils.utilityClass;

/* PBI 35680 and some scenarios suggested by ankit */
/*implemented by Divyasree*/
public class Cancellations_test extends CancellationsAction {

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	impersonateAction impersonate = new impersonateAction();
	utilityClass utils = new utilityClass();
	cancellationQuotes_test quotePage = new cancellationQuotes_test();
	cancellationHistory_test historyPage = new cancellationHistory_test();

	@BeforeClass(alwaysRun = true)
	public void login() throws InterruptedException {
//		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}

	@Test(priority = 1)
	public void verifyCancellationQuote() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDB();
		HashMap<String, String> data = dbMap.get(1);
		String roleId = data.get("DEALER_ID");
		System.out.println("Dealer Id to impersonate--" + roleId);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUserWith("Dealer", roleId, "Dealer");
		verticalMenu.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
		String certNo = data.get("CERT");
		System.out.println("cert no:" + certNo);
		quotePage.searchdata("Contract", certNo);
		quotePage.quoteLink().click();
		String miles = data.get("AUTOMILES");
		int mileage = Integer.parseInt(miles);
		int newmileage = mileage+2;
		quotePage.getCancelMileageInput().sendKeys(Integer.toString(newmileage));
		quotePage.getQuoteBtn().click();
		utils.wait(10000);
		utils.scrollUpUsingJSE();
		quotePage.getCloseBtn().click();
		verticalMenu.navigatetoLeftMenu("Cancellation History");
		quotePage.waitForThePageToLoad();
		historyPage.getSearchBoxesInGrid().get("Contract").sendKeys(certNo);
		HashMap<Integer, HashMap<String, String>> tableMap = quotePage.tabledata();
		String certNoInHistoryPage = tableMap.get(1).get("Contract");
		String status = tableMap.get(1).get("Status");
		System.out.println(tableMap);
		Assert.assertEquals(certNo, certNoInHistoryPage);
		Assert.assertEquals(status, "Quote");
	}

	
	@Test(priority = 2,enabled= true)
	public void verifyCancellationSuccessStatus() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDB();
		HashMap<String, String> data = dbMap.get(1);
		String roleId = data.get("DEALER_ID");
		System.out.println("Dealer Id to impersonate--" + roleId);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUserWith("Dealer", roleId, "Dealer");
		verticalMenu.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
		String certNo = data.get("CERT");
		System.out.println("cert no--"+certNo);
		quotePage.searchdata("Contract", certNo);
		Thread.sleep(5000);
		quotePage.quoteLink().click();
		Thread.sleep(5000);
		String miles = data.get("AUTOMILES");
		int mileage = Integer.parseInt(miles);
		int newmileage = mileage + 1;
		quotePage.getCancelMileageInput().sendKeys(Integer.toString(newmileage));
		quotePage.getQuoteBtn().click();
		quotePage.waitForThePageToLoad();
		quotePage.getCancelContractBtn().click();
		quotePage.getCheckBox().click();
		Assert.assertTrue(quotePage.getCheckBoxAgreeMsg().isDisplayed());
		Assert.assertTrue(quotePage.getCompleteCancellationBtn().isEnabled());
		quotePage.getCloseBtnDuringCancelContractPopup().click();
		quotePage.getCloseBtn().click();
//		quotePage.getCompleteCancellationBtn().click();
//		verticalMenu.navigatetoLeftMenu("Cancellation History");
//		quotePage.waitForThePageToLoad();
//		historyPage.getSearchBoxesInGrid().get("Contract").sendKeys(certNo);
//		quotePage.waitForThePageToLoad();
//		HashMap<Integer, HashMap<String, String>> tableMap = quotePage.tabledata();
//		String certNoInHistoryPage = tableMap.get(1).get("Contract");
//		String status = tableMap.get(1).get("Status");
//		System.out.println(tableMap);
//		Assert.assertEquals(certNo, certNoInHistoryPage);
//		Assert.assertEquals(status, "Authorized");
	}

	@Test(priority = 3)
	public void verifyQuoteErrorMsg() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDBForMileageMoreThan3000();
		HashMap<String, String> data = dbMap.get(1);
		String roleId = data.get("DEALER_ID");
		System.out.println("Dealer Id to impersonate--" + roleId);
		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", roleId);
		impersonate.impersonateAsGenericUserWith("Dealer", roleId, "Dealer");
		verticalMenu.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
		String certNo = data.get("CERT");
		quotePage.searchdata("Contract", certNo);
		quotePage.quoteLink().click();
		String miles = data.get("AUTOMILES");
		int mileage = Integer.parseInt(miles);
		int newmileage = mileage - 100;
		quotePage.getCancelMileageInput().sendKeys(Integer.toString(newmileage));
		quotePage.getQuoteBtn().click();
		quotePage.waitForThePageToLoad();
		System.out.println("error msg:" + quotePage.getQuoteErrorMsg().getText());
		Assert.assertTrue(quotePage.getQuoteErrorMsg().isDisplayed());
		quotePage.getCancelBtn().click();
	}

	//error msg as unable to cancel contract online
	@Test(priority = 4,enabled = false)
	public void verifyCancellationFailureMsg() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDBForMileageMoreThan3000();
		HashMap<String, String> data = dbMap.get(1);
		String roleId = data.get("DEALER_ID");
		System.out.println("Dealer Id to impersonate--" + roleId);
		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("Dealer", roleId);
		impersonate.impersonateAsGenericUserWith("Dealer", roleId, "Dealer");
		verticalMenu.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
		String certNo = data.get("CERT");
		System.out.println("cert no:" + certNo);
		quotePage.searchdata("Contract", certNo);
		quotePage.quoteLink().click();
		String miles = data.get("AUTOMILES");
		int mileage = Integer.parseInt(miles);
		int newmileage = mileage + 1;
		quotePage.getCancelMileageInput().sendKeys(Integer.toString(newmileage));
		quotePage.getQuoteBtn().click();
		quotePage.waitForThePageToLoad();
		quotePage.getCancelContractBtn().click();
		quotePage.getCheckBox().click();
		quotePage.getCompleteCancellationBtn().click();
		System.out.println(quotePage.errorElements().size());
		System.out.println("error msg:" + quotePage.getCancellationErrorMsg().getText());
		Assert.assertTrue(quotePage.getCancellationErrorMsg().isDisplayed());
		quotePage.getCloseBtnDuringCancelContractPopup().click();
		quotePage.getCloseBtn().click();
	}

	@Test(priority = 5)
	public void verifyQuoteGenerationMoreThanThreeTimes_() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDBForMileageMoreThan3000();
		HashMap<String, String> data = dbMap.get(1);
		String roleId = data.get("DEALER_ID");
		System.out.println("Dealer Id to impersonate--" + roleId);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUserWith("Dealer", roleId, "Dealer");
//		impersonate.impersonateUser("Dealer", roleId);
		verticalMenu.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
		String certNo = data.get("CERT");
		quotePage.searchdata("Contract", certNo);
		quotePage.quoteLink().click();
		String miles = data.get("AUTOMILES");
		int mileage = Integer.parseInt(miles);
		for (int i = 1; i < 4; i++) {
			quotePage.getCancelMileageInput().sendKeys(Integer.toString(mileage + i));
			quotePage.getQuoteBtn().click();
			quotePage.waitForThePageToLoad();
			quotePage.getEditBtn().click();
			quotePage.getCancelMileageInput().clear();
		}
		quotePage.getCancelMileageInput().sendKeys(Integer.toString(mileage + 4));
		quotePage.getQuoteBtn().click();
		quotePage.waitForThePageToLoad();
		Assert.assertTrue(quotePage.getCancelContractBtn().isEnabled());
	}

	
	@Test(priority = 6)
	public void verifyCancellationHistotyPageGrid_36125_36127_36129() throws Exception {
		
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Cancellations", "Cancellation History");
		
		
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDB();
//		HashMap<String, String> data = dbMap.get(1);
//		String roleId = data.get("DEALER_ID");
//		System.out.println("Dealer Id to impersonate--" + roleId);
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateAsGenericUserWith("Dealer", roleId, "Dealer");
//		verticalMenu.navigatetoLeftMenu("Cancellations", "Cancellation History");
        HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
		String contractNo = allTableDataTxt.get(1).get("Contract");
		utils.element("xpath", searchBox).sendKeys(contractNo);
		Thread.sleep(2000);
		Assert.assertTrue(getRows().size() == 1);
		List<WebElement> headers = utils.getElementsList("cssselector", headersTxt);
		Assert.assertTrue(headers.get(0).getText().equals("Contract Holder"));
		Assert.assertTrue(headers.get(1).getText().equals("Status"));
		Assert.assertTrue(headers.get(2).getText().equals("Contract"));
		Assert.assertTrue(headers.get(3).getText().equals("Refund"));
		Assert.assertTrue(headers.get(4).getText().equals("Refund %"));
		Assert.assertTrue(headers.get(5).getText().equals("Quote Date"));
		Assert.assertTrue(headers.get(6).getText().equals("Quote Mileage"));
		Assert.assertTrue(headers.get(7).getText().equals("Initiated By"));
		Assert.assertTrue(headers.get(8).getText().equals("Cancellation Reason"));
		Assert.assertTrue(headers.get(9).getText().equals("Download Form"));
		utils.element("xpath", clearFiltersLink).click();
		Assert.assertTrue(getRows().size() > 1);
	}
	
	@Test(priority = 7)
	public void verifydownloadFunctionality_36128_36130_36131_() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Cancellations", "Cancellation History");
		getDowloadLink(1).click();
		String pdfURL = prop.getProperty("downloadLinkCancellations");
		verifyContentInPDf(pdfURL, "aul");
		utils.element("xpath", exportPDF).click();
		Assert.assertTrue(utils.element("xpath", pdfXlsDownloadConfirmation).isDisplayed());
		verifyContentInPDf(pdfURL, "aul");
		Thread.sleep(10000);
		utils.element("xpath", exportXLS).click();
		Assert.assertTrue(utils.element("xpath", pdfXlsDownloadConfirmation).isDisplayed());
	}
		
		
	@Test(priority = 8)
	public void verifyCancellationStatusQuote_36214() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDB();
		HashMap<String, String> data = dbMap.get(1);
		String roleId = data.get("DEALER_ID");
		System.out.println("Dealer Id to impersonate--" + roleId);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUserWith("Dealer", roleId, "Dealer");
		verticalMenu.navigatetoLeftMenu("Cancellations", "Cancellation History");
		selectStatus("Quote");
		 HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
		 String status = allTableDataTxt.get(1).get("Status");
		 Assert.assertTrue(status.equals("Quote"));
		 getDowloadLink(1).click();
			String pdfURL = prop.getProperty("downloadLinkCancellations");
			verifyContentInPDf(pdfURL, "aul");
	}
	
	@Test(priority = 9)
	public void verifyCancellationStatusOnHold_36215() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDBForStatus1("OnHold");
		HashMap<String, String> data = dbMap.get(1);
		String roleId = data.get("DEALER_ID");
		System.out.println("Dealer Id to impersonate--" + roleId);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUserWith("Dealer", roleId, "Dealer");
		verticalMenu.navigatetoLeftMenu("Cancellations", "Cancellation History");
		selectStatus("OnHold");
		 HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
		 String status = allTableDataTxt.get(1).get("Status");
		 Assert.assertTrue(status.equals("OnHold"));
		 getDowloadLink(1).click();
			String pdfURL = prop.getProperty("downloadLinkCancellations");
			verifyContentInPDf(pdfURL, "aul");
	}
	
	@Test(priority = 10)
	public void verifyCancellationStatusAuthorized_36216() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDBForStatus1("Authorized");
		HashMap<String, String> data = dbMap.get(1);
		String roleId = data.get("DEALER_ID");
		System.out.println("Dealer Id to impersonate--" + roleId);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUserWith("Dealer", roleId, "Dealer");
		verticalMenu.navigatetoLeftMenu("Cancellations", "Cancellation History");
		selectStatus("Authorized");
		 HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
		 String status = allTableDataTxt.get(1).get("Status");
		 Assert.assertTrue(status.equals("Authorized"));
		 getDowloadLink(1).click();
			String pdfURL = prop.getProperty("downloadLinkCancellations");
			verifyContentInPDf(pdfURL, "aul");
	}
	
	@Test(priority = 12)
	public void verifyCancellationStatusDenied_36217() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDBForStatus1("Denied");
		HashMap<String, String> data = dbMap.get(1);
		String roleId = data.get("DEALER_ID");
		System.out.println("Dealer Id to impersonate--" + roleId);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUserWith("Dealer", roleId, "Dealer");
		verticalMenu.navigatetoLeftMenu("Cancellations", "Cancellation History");
		selectStatus("Denied");
		 HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
		 String status = allTableDataTxt.get(1).get("Status");
		 Assert.assertTrue(status.equals("Denied"));
		 getDowloadLink(1).click();
			String pdfURL = prop.getProperty("downloadLinkCancellations");
			verifyContentInPDf(pdfURL, "aul");
	}
	
	
	@Test(priority = 13)
	public void verifyCancellationStatusProcessed_36218() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDBForStatus1("Processed");
		HashMap<String, String> data = dbMap.get(1);
		String roleId = data.get("DEALER_ID");
		System.out.println("Dealer Id to impersonate--" + roleId);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUserWith("Dealer", roleId, "Dealer");
		verticalMenu.navigatetoLeftMenu("Cancellations", "Cancellation History");
		selectStatus("Processed");
		 HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
		 String status = allTableDataTxt.get(1).get("Status");
		 Assert.assertTrue(status.equals("Processed"));
		 getDowloadLink(1).click();
			String pdfURL = prop.getProperty("downloadLinkCancellations");
			verifyContentInPDf(pdfURL, "aul");
	}
	
	
	@Test(priority = 14,enabled = false)
	public void verifyCancellationStatusReinstated_36219() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDBForStatus1("Reinstated");
		HashMap<String, String> data = dbMap.get(1);
		String roleId = data.get("DEALER_ID");
		System.out.println("Dealer Id to impersonate--" + roleId);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateAsGenericUserWith("Dealer", roleId, "Dealer");
		verticalMenu.navigatetoLeftMenu("Cancellations", "Cancellation History");
		selectStatus("Reinstated");
		 HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
		 String status = allTableDataTxt.get(1).get("Status");
		 Assert.assertTrue(status.equals("Reinstated"));
		 getDowloadLink(1).click();
			String pdfURL = prop.getProperty("downloadLinkCancellations");
			verifyContentInPDf(pdfURL, "aul");
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		try {
			login.logout();
		} catch (Exception e) {
			if (utils.getfield("mat-icon", "close").isDisplayed()) {
				utils.getfield("mat-icon", "close").click();
			}
			login.logout();
		}
	}

}
