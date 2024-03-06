package testsuite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.cancellationQuotesAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.Database_Connectivity;
import utils.baseClass;
@Listeners(utils.listnerlogs.class)
public class cancellationQuotes_test extends cancellationQuotesAction {

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	impersonateAction ia = new impersonateAction();
	Database_Connectivity dc = new Database_Connectivity();
	impersonateAction impersonate = new impersonateAction();

	@Test(priority = 1)
	public void cancellationsearchpage() throws Exception {

		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();

		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery("SELECT ROLE_IDENTIFIER FROM [dbo].[ACCOUNT] WHERE ID in "
					+ "(SELECT TOP 10 PRIMARY_ACCOUNT_ID FROM [dbo].[ALLSALES_DETAILS] WITH (NOLOCK) WHERE [CONTRACT_STATUS_ID] = 5 AND ENTITY = 'WEB' "
					+ "ORDER BY CREATE_DATE)");

			// save data in map
			dbMap = dc.returnAllData(rs);
			System.out.println("dbmap-------"+dbMap);
			navigate();
			lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			HashMap<String, String> data = dbMap.get(1);
			String roleId = data.get("ROLE_IDENTIFIER");
			//Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
			vo.navigatetoimpersonate();
			impersonate.impersonateUser("Dealer", roleId);
			vo.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
			Assert.assertEquals("Dealer: " + roleId, ia.roleImpersonate());
			Assert.assertEquals("https://qa.adl.aulcorp.com/portal/cancellations/cancel-quote", driver.getCurrentUrl());
			Assert.assertEquals(validationMessage(), "Please enter at least one search criteria");
			Assert.assertEquals(vo.getTitle(), "Cancellation Quote");
			Assert.assertEquals(getFrontText(),
					"Use the input fields to find a contract holder. You can search by any one, or all, criteria.");
			Assert.assertEquals(validationMessage("1"),
					"Invalid VIN. Please enter a search criteria of six characters");
			driver.navigate().refresh();
			Assert.assertEquals(validationMessageLastName("1"),
					"Invalid Last Name. Please enter a search criteria of two or more characters");
			Assert.assertEquals(nameMaxLength(), "64");
			Assert.assertEquals(vinMaxLength(), "6");
			Assert.assertEquals(contractMaxLength(), "16");

		} catch (Exception e) {
			throw e;
		} finally {
			//// close connection
			dc.closeConnection();
			lo.logout();

		}
	}

	@Test(priority = 2)
	public void cancellationSearchResult() throws Exception {

		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		HashMap<Integer, HashMap<String, String>> tableMap = new HashMap<Integer, HashMap<String, String>>();

		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery(
					"SELECT TOP 1 WC.CERT, WC.DEALER_ID, WC.LAST_NAME, WC.VIN , td.expiration_mileage, td.customer_paid , WC.Year,  WC.MAKE, WC.MODEL\r\n"
							+ "FROM [DBO].[WEB_CONTRACTS] AS WC INNER JOIN [dbo].[ALLSALES_DETAILS]  AS TD ON WC.CERT = TD.CERT \r\n"
							+ "WHERE WC.STATUS = 'Processed' AND  td.[CONTRACT_STATUS_ID] = 5  AND TD.[EXPIRATION_DATE] > GETDATE()\r\n"
							+ "ORDER BY WC.DATE_CREATED DESC");

			// save data in map
			dbMap = dc.returnAllData(rs);
			navigate();
			lo.login(prop.getProperty("adminusername"), prop.getProperty("password"));
			HashMap<String, String> data = dbMap.get(1);
			String roleId = data.get("DEALER_ID");
			vo.navigatetoimpersonate();
			impersonate.impersonateUser("Dealer", roleId);
			vo.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
			String contractno = data.get("CERT");
			searchdata("Contract", contractno);
			Assert.assertEquals(recordText(), "Showing 1 to 1 of 1 records");
			tableMap = tabledata();
			HashMap<String, String> firstRow = tableMap.get(1);
			Assert.assertEquals(firstRow.get("VIN"), data.get("VIN"));
			Assert.assertEquals(firstRow.get("Last"), data.get("LAST_NAME"));
			Assert.assertEquals(firstRow.get("Year"), data.get("Year"));
			Assert.assertEquals(firstRow.get("Make").toUpperCase(), data.get("MAKE"));
			Assert.assertEquals(firstRow.get("Model").toUpperCase(), data.get("MODEL"));
			Assert.assertEquals(quoteLink().getText(), "Quote");
			driver.navigate().refresh();
			String lname = data.get("LAST_NAME");
			searchdata("Last_Name", lname);
			tableMap = tabledata();
			HashMap<String, String> lfirstRow = tableMap.get(1);
			Assert.assertEquals(lfirstRow.get("Last"), data.get("LAST_NAME"));
			Assert.assertEquals(quoteLink().getText(), "Quote");
			driver.navigate().refresh();
			String vinnumber = data.get("VIN");
			searchdata("VIN", vinnumber);
			tableMap = tabledata();
			HashMap<String, String> vfirstRow = tableMap.get(1);
			Assert.assertEquals(firstRow.get("VIN"), data.get("VIN"));
			Assert.assertEquals(firstRow.get("Last"), data.get("LAST_NAME"));
			Assert.assertEquals(firstRow.get("Year"), data.get("Year"));
			Assert.assertEquals(firstRow.get("Make").toUpperCase(), data.get("MAKE"));
			Assert.assertEquals(firstRow.get("Model").toUpperCase(), data.get("MODEL"));
			Assert.assertEquals(quoteLink().getText(), "Quote");
			
			Assert.assertEquals(quoteLink().getText(), "Quote");
			

		} catch (Exception e) {
			throw e;
		} finally {
			//// close connection
			dc.closeConnection();
			lo.logout();

		}

	}
}
