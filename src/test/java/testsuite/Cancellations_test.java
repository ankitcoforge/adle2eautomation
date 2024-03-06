package testsuite;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.CancellationsAction;
import pageActions.LateralMenuAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.CalenderUtils;
import utils.utilityClass;

public class Cancellations_test extends CancellationsAction {

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	impersonateAction impersonate = new impersonateAction();
	utilityClass utils = new utilityClass();
	cancellationQuotes_test quotePage = new cancellationQuotes_test();
	cancellationHistory_test historyPage = new cancellationHistory_test();

	@BeforeMethod(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}

	@Test(priority = 1)
	public void verifyCancellationQuote() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
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
		int newmileage = mileage++;
		quotePage.getCancelMileageInput().sendKeys(Integer.toString(newmileage));
		quotePage.getQuoteBtn().click();
		quotePage.waitForThePageToLoad();
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

	@Test(priority = 2,enabled = false)
	public void verifyCancellationSuccessStatus() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDB();
		HashMap<String, String> data = dbMap.get(2);
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
		int newmileage = mileage + 1;
		quotePage.getCancelMileageInput().sendKeys(Integer.toString(newmileage));
		quotePage.getQuoteBtn().click();
		quotePage.waitForThePageToLoad();
		quotePage.getCancelContractBtn().click();
		quotePage.getCheckBox().click();
		quotePage.getCompleteCancellationBtn().click();
		verticalMenu.navigatetoLeftMenu("Cancellation History");
		quotePage.waitForThePageToLoad();
		historyPage.getSearchBoxesInGrid().get("Contract").sendKeys(certNo);
		quotePage.waitForThePageToLoad();
		HashMap<Integer, HashMap<String, String>> tableMap = quotePage.tabledata();
		String certNoInHistoryPage = tableMap.get(1).get("Contract");
		String status = tableMap.get(1).get("Status");
		System.out.println(tableMap);
		Assert.assertEquals(certNo, certNoInHistoryPage);
		Assert.assertEquals(status, "Authorized");
	}

	@Test(priority = 3)
	public void verifyQuoteErrorMsg() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDBForMileageMoreThan3000();
		HashMap<String, String> data = dbMap.get(2);
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

	@Test(priority = 4, enabled = false)
	public void verifyCancellationFailureMsg() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDBForMileageMoreThan3000();
		HashMap<String, String> data = dbMap.get(2);
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
		quotePage.waitForThePageToLoad();
		quotePage.getBackBtn().click();
		utils.scrollUpUsingJSE();
		quotePage.getCancelBtn().click();
	}

	@Test(priority = 5)
	public void verifyQuoteGenerationMoreThanThreeTimes_() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		HashMap<Integer, HashMap<String, String>> dbMap = getDataFromDBForMileageMoreThan3000();
		HashMap<String, String> data = dbMap.get(3);
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
