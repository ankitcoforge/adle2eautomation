package testsuite;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

public class cancellationQuotes_test<WebElement> extends cancellationQuotesAction {

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
			Assert.assertEquals(emptyResult(), "Please make a search to display records");
			Assert.assertEquals(disclaimerMessage(), 
					"Disclaimer: This is a quote page ONLY. The actual refund will be based on time and mileage when an AUL Cancellation Form is received with signatures by AUL Corp. Quotes remain valid for 14 days.");
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
			ResultSet rs = dc.stmt.executeQuery("SELECT TOP 10 WC.CERT, WC.DEALER_ID, WC.VIN ,  td.expiration_mileage, td.customer_paid, TD.CUSTOMER_LAST, WC.YEAR, WC.MODEL , WC.MAKE\r\n" + 
					"					FROM [DBO].[WEB_CONTRACTS] AS WC INNER JOIN [dbo].[ALLSALES_DETAILS]  AS TD ON WC.CERT = TD.CERT \r\n" + 
					"					WHERE WC.STATUS = 'Processed' AND  td.[CONTRACT_STATUS_ID] = 5  AND TD.[EXPIRATION_DATE] > GETDATE() AND WC.PROGRAM_CODE <> 'OLW' AND WC.DEALER_ID <> '33925'\r\n" + 
					"					ORDER BY WC.DATE_CREATED DESC");

			// save data in map
			dbMap = dc.returnAllData(rs);
			System.out.println(dbMap);
			navigate();
			lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			HashMap<String, String> data = dbMap.get(1);
			String roleId = data.get("DEALER_ID");
			vo.navigatetoimpersonate();
			impersonate.impersonateUser("Dealer", roleId);
			vo.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
			String contractno = data.get("CERT");
			searchdata("Contract", contractno);
			Assert.assertEquals(recordText(), "Showing 0 to 1 of 1 records");
			tableMap = tabledata();
			HashMap<String, String> firstRow = tableMap.get(1);
			Assert.assertEquals(firstRow.get("VIN"), data.get("VIN"));
			Assert.assertEquals(firstRow.get("Last"), data.get("CUSTOMER_LAST"));
			Assert.assertEquals(firstRow.get("Year"), data.get("YEAR"));
			Assert.assertEquals(firstRow.get("Make"), data.get("MAKE"));
			Assert.assertEquals(firstRow.get("Model"), data.get("MODEL"));
			Assert.assertEquals(quoteLink().getText(), "Quote");
			driver.navigate().refresh();
			String lname = data.get("CUSTOMER_LAST");
			searchdata("CUSTOMER_LAST", lname);
			tableMap = tabledata();
			HashMap<String, String> lfirstRow = tableMap.get(1);
			Assert.assertEquals(lfirstRow.get("Last"), data.get("CUSTOMER_LAST"));
			Assert.assertEquals(quoteLink().getText(), "Quote");
			driver.navigate().refresh();
			String vinnumber = data.get("VIN");
			searchdata("VIN", vinnumber);
			tableMap = tabledata();
			HashMap<String, String> vfirstRow = tableMap.get(1);
			Assert.assertEquals(vfirstRow.get("VIN"), data.get("VIN"));
			Assert.assertEquals(vfirstRow.get("Last"), data.get("CUSTOMER_LAST"));
			Assert.assertEquals(vfirstRow.get("Year"), data.get("YEAR"));
			Assert.assertEquals(vfirstRow.get("Make"), data.get("MAKE"));
			Assert.assertEquals(vfirstRow.get("Model"), data.get("MODEL"));
			Assert.assertEquals(quoteLink().getText(), "Quote");
			
		} catch (Exception e) {
			throw e;
		} finally {
			//// close connection
			dc.closeConnection();
			lo.logout();

		}

	}


	@Test(priority = 3)
	public void cancellationModelBox() throws Exception {

		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		HashMap<Integer, HashMap<String, String>> tableMap = new HashMap<Integer, HashMap<String, String>>();

		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery("SELECT TOP 10 WC.CERT, WC.DEALER_ID, WC.VIN ,  td.expiration_mileage, td.customer_paid, TD.CUSTOMER_LAST, WC.YEAR, WC.MODEL , WC.MAKE\r\n" + 
					"					FROM [DBO].[WEB_CONTRACTS] AS WC INNER JOIN [dbo].[ALLSALES_DETAILS]  AS TD ON WC.CERT = TD.CERT \r\n" + 
					"					WHERE WC.STATUS = 'Processed' AND  td.[CONTRACT_STATUS_ID] = 5  AND TD.[EXPIRATION_DATE] > GETDATE() AND WC.PROGRAM_CODE <> 'OLW' AND WC.DEALER_ID <> '33925'\r\n" + 
					"					ORDER BY WC.DATE_CREATED DESC");

			// save data in map
			dbMap = dc.returnAllData(rs);
			navigate();
			lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			vo.navigatetoimpersonate();
			HashMap<String, String> data = dbMap.get(1);
			String roleId = data.get("DEALER_ID");
			ia.impersonateUser("Dealer", roleId);
			vo.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
			String contractno = data.get("CERT");
			searchdata("Contract", contractno);
			Assert.assertEquals(recordText(), "Showing 0 to 1 of 1 records");
			tableMap = tabledata();
			HashMap<String, String> firstRow = tableMap.get(1);
			Assert.assertEquals(quoteLink().getText(), "Quote");
			quoteLink().click();
			Assert.assertEquals(modelBoxOverlay().isDisplayed(), true);
			Assert.assertEquals(getContractNumber(), contractno);
			Assert.assertEquals(cancelLabelText(), "Cancel Date*");
			Assert.assertEquals(validateInitiatedByValue(), "Dealer");
			Assert.assertEquals(validateCancelReasonValue(), "Trade/Sale");
			Assert.assertEquals(validatefield(cancelMileage), "Cancel Mileage*");
			Assert.assertEquals(validatefield(quoteButton), "Quote");
			Assert.assertEquals(validatefield(cancelButton), "Cancel");
			Assert.assertEquals(validationMessage1(retailPrice), "Required");
			
		} catch (Exception e) {
			throw e;
		} finally {
			//// close connection
			dc.closeConnection();
			driver.findElement(By.cssSelector(close)).click();
			lo.logout();

		}

	}

	@Test(priority = 10)
	public void cancellationQuote() throws Exception {

		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		HashMap<Integer, HashMap<String, String>> tableMap = new HashMap<Integer, HashMap<String, String>>();

		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery(
					"SELECT TOP 10 WC.CERT, WC.DEALER_ID, WC.VIN ,  td.expiration_mileage, td.customer_paid, TD.CUSTOMER_LAST, WC.YEAR, WC.MODEL , WC.MAKE\r\n" + 
					"					FROM [DBO].[WEB_CONTRACTS] AS WC INNER JOIN [dbo].[ALLSALES_DETAILS]  AS TD ON WC.CERT = TD.CERT \r\n" + 
					"					WHERE WC.STATUS = 'Processed' AND  td.[CONTRACT_STATUS_ID] = 5  AND TD.[EXPIRATION_DATE] > GETDATE() AND WC.PROGRAM_CODE <> 'OLW' AND WC.DEALER_ID <> '33925'\r\n" + 
					"					ORDER BY WC.DATE_CREATED DESC");

			// save data in map
			dbMap = dc.returnAllData(rs);
		    System.out.println(dbMap);
			int j =1;
			int k =1; 
			do {
				navigate();
				lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
				vo.navigatetoimpersonate();
				HashMap<String, String> data = dbMap.get(k);
				System.out.println(data);
				String roleId = data.get("DEALER_ID");
				ia.impersonateUser("Dealer", roleId);
				vo.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
				String contractno = data.get("CERT");
				searchdata("Contract", contractno);
				Assert.assertEquals(recordText(), "Showing 0 to 1 of 1 records");
				tableMap = tabledata();
				HashMap<String, String> firstRow = tableMap.get(1);
				Assert.assertEquals(quoteLink().getText(), "Quote");
				quoteLink().click();
				fillCancelMileage(data.get("expiration_mileage"));
				List l = driver.findElements(By.cssSelector(".header .title"));
			    if(l.size() ==1)
			    {
			    	j++;
			    	Assert.assertEquals(validatefield(edit),"Edit");
			    	Assert.assertEquals(validatefield(quoteClose),"Close");
			    	Assert.assertEquals(printQuote(),"PRINT QUOTE");
			    	Assert.assertEquals(genarateQuote(),"GENERATE CANCEL FORM");
			    	//cancelQuote();
			    	Thread.sleep(4000);
			    	HashSet<String> b = new HashSet<>();
					b = isFileDownloaded( System.getProperty("user.dir") + "\\PDF", ".pdf");
					System.out.println(b);
			    	quotePDF();
					HashSet<String> a1 = new HashSet<>();
					a1 = isFileDownloaded(System.getProperty("user.dir") + "\\PDF", ".pdf");
					a1.removeAll(b);
					System.out.println(a1);
					String pdfUrl = "file:///" +  System.getProperty("user.dir") + "\\PDF\\" + a1.toString().replaceAll("\\,|\\[|\\]|\\s", "");
					String pdfUrl1 = pdfUrl.replace("\\", "/");
					System.out.println(pdfUrl1);
					verifyContentInPDf(pdfUrl1, data.get("CERT"));
					verifyContentInPDf(pdfUrl1, "Online Cancellation Quote");
					b.addAll(a1);
			    	
			    }
			    else {
			    	k++;
			    	driver.findElement(By.cssSelector(close)).click();
					lo.logout();
			    }
			} while(j==1);
			
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			//// close connection
			dc.closeConnection();


		}
	}
	
	@Test(priority = 4)
	public void lenderCancellationSearchPage() throws Exception {

		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();

		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery("SELECT DISTINCT TOP 5\r\n" + 
					"               [PA].[ROLE_IDENTIFIER],\r\n" + 
					"               [PA].[ID],\r\n" + 
					"               [PA].[NAME],\r\n" + 
					"               [AD].[ID] AS 'ALLSALES_DETAILS_ID',\r\n" + 
					"               [AVD].[AUTOYEAR],\r\n" + 
					"               [AVD].[AUTOMAKE],\r\n" + 
					"               [AVD].[AUTOMODEL],\r\n" + 
					"               [AD].[CERT],\r\n" + 
					"               [CS].[NAME] AS 'CONTRACT_STATUS',\r\n" + 
					"               [AD].[CUSTOMER_FIRST],\r\n" + 
					"               [AD].[CUSTOMER_LAST],\r\n" + 
					"               [AD].[CUSTOMER_PAID],\r\n" + 
					"               [WC].[DEALER_ID] AS 'DEALER_ROLE_IDENTIFIER',\r\n" + 
					"               [AD].[LENDER_COMPANY],\r\n" + 
					"               [AD].[PRICESHEET_ID],\r\n" + 
					"               [AD].[VIN],\r\n" + 
					"			   [AD].[EXPIRATION_MILEAGE]\r\n" + 
					"        FROM [dbo].[ALLSALES_DETAILS] AS [AD] WITH (NOLOCK)\r\n" + 
					"            JOIN [dbo].[WEB_CONTRACTS] AS [WC]\r\n" + 
					"                ON [WC].[CERT] = [AD].[CERT]\r\n" + 
					"            JOIN [dbo].[ALLSALES_VIN_DETAIL] AS [AVD] WITH (NOLOCK)\r\n" + 
					"                ON [AD].[VIN_DETAILS_ID] = [AVD].[ID]\r\n" + 
					"            JOIN [dbo].[UW_CONTRACT_STATUS] AS [CS] WITH (NOLOCK)\r\n" + 
					"                ON [AD].[CONTRACT_STATUS_ID] = [CS].[ID]\r\n" + 
					"            LEFT JOIN [adl].[CANCELLATIONS_EXCLUSION_LIST] AS [EX] WITH (NOLOCK)\r\n" + 
					"                ON (\r\n" + 
					"                       [EX].[ACCOUNT_ID] = [AD].[PRIMARY_ACCOUNT_ID]\r\n" + 
					"                       OR [EX].[ACCOUNT_ID] = [AD].[SECONDARY_ACCOUNT_ID]\r\n" + 
					"                   )\r\n" + 
					"            LEFT JOIN [dbo].[ACCOUNT] AS [PA] WITH (NOLOCK)\r\n" + 
					"                ON [PA].[ID] = [AD].[PRIMARY_ACCOUNT_ID]\r\n" + 
					"            LEFT JOIN [dbo].[ACCOUNT_ROLE_TYPE] AS [ARTP] WITH (NOLOCK)\r\n" + 
					"                ON [ARTP].[ID] = [PA].[ROLE_TYPE_ID]\r\n" + 
					"            --- Check if Cancellable\r\n" + 
					"            LEFT JOIN [ocean].[PRICESHEET_PROPERTY] AS [PP]\r\n" + 
					"                ON [PP].[PROGRAM_CODE] = [WC].[PROGRAM_CODE]\r\n" + 
					"        WHERE\r\n" + 
					"        ([AD].[PRIMARY_ACCOUNT_ID] IN (SELECT [A].[ID] FROM [dbo].[ACCOUNT] AS [A] WITH (NOLOCK)\r\n" + 
					"                                                JOIN [dbo].[ACCOUNT_ROLE_TYPE] AS [ART] WITH (NOLOCK) ON [A].[ROLE_TYPE_ID] = [ART].[ID]\r\n" + 
					"                                                WHERE [ART].[ROLE_NAME] = 'LENDER'))");

			// save data in map
			dbMap = dc.returnAllData(rs);
			System.out.println("dbmap-------"+dbMap);
			navigate();
			lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			vo.navigatetoimpersonate();
			HashMap<String, String> data = dbMap.get(1);
			String roleId = data.get("ROLE_IDENTIFIER");
			ia.impersonateUser("Lender", roleId);
			vo.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
			Assert.assertEquals("Lender: " + roleId, ia.roleImpersonate());
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
	
	@Test(priority = 5)
	public void lenderCancellationSearchResult() throws Exception {

		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		HashMap<Integer, HashMap<String, String>> tableMap = new HashMap<Integer, HashMap<String, String>>();

		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery(
					"SELECT DISTINCT TOP 10\r\n" + 
					"               [PA].[ROLE_IDENTIFIER],\r\n" + 
					"               [PA].[ID],\r\n" + 
					"               [PA].[NAME],\r\n" + 
					"               [AD].[ID] AS 'ALLSALES_DETAILS_ID',\r\n" + 
					"               [AVD].[AUTOYEAR],\r\n" + 
					"               [AVD].[AUTOMAKE],\r\n" + 
					"               [AVD].[AUTOMODEL],\r\n" + 
					"               [AD].[CERT],\r\n" + 
					"               [CS].[NAME] AS 'CONTRACT_STATUS',\r\n" + 
					"               [AD].[CUSTOMER_FIRST],\r\n" + 
					"               [AD].[Last_Name],\r\n" + 
					"               [AD].[CUSTOMER_PAID],\r\n" + 
					"               [WC].[DEALER_ID] AS 'DEALER_ROLE_IDENTIFIER',\r\n" + 
					"               [AD].[LENDER_COMPANY],\r\n" + 
					"               [AD].[PRICESHEET_ID],\r\n" + 
					"               [AD].[VIN]\r\n" + 
					"        FROM [dbo].[ALLSALES_DETAILS] AS [AD] WITH (NOLOCK)\r\n" + 
					"            JOIN [dbo].[WEB_CONTRACTS] AS [WC]\r\n" + 
					"                ON [WC].[CERT] = [AD].[CERT]\r\n" + 
					"            JOIN [dbo].[ALLSALES_VIN_DETAIL] AS [AVD] WITH (NOLOCK)\r\n" + 
					"                ON [AD].[VIN_DETAILS_ID] = [AVD].[ID]\r\n" + 
					"            JOIN [dbo].[UW_CONTRACT_STATUS] AS [CS] WITH (NOLOCK)\r\n" + 
					"                ON [AD].[CONTRACT_STATUS_ID] = [CS].[ID]\r\n" + 
					"            LEFT JOIN [adl].[CANCELLATIONS_EXCLUSION_LIST] AS [EX] WITH (NOLOCK)\r\n" + 
					"                ON (\r\n" + 
					"                       [EX].[ACCOUNT_ID] = [AD].[PRIMARY_ACCOUNT_ID]\r\n" + 
					"                       OR [EX].[ACCOUNT_ID] = [AD].[SECONDARY_ACCOUNT_ID]\r\n" + 
					"                   )\r\n" + 
					"            LEFT JOIN [dbo].[ACCOUNT] AS [PA] WITH (NOLOCK)\r\n" + 
					"                ON [PA].[ID] = [AD].[PRIMARY_ACCOUNT_ID]\r\n" + 
					"            LEFT JOIN [dbo].[ACCOUNT_ROLE_TYPE] AS [ARTP] WITH (NOLOCK)\r\n" + 
					"                ON [ARTP].[ID] = [PA].[ROLE_TYPE_ID]\r\n" + 
					"            --- Check if Cancellable\r\n" + 
					"            LEFT JOIN [ocean].[PRICESHEET_PROPERTY] AS [PP]\r\n" + 
					"                ON [PP].[PROGRAM_CODE] = [WC].[PROGRAM_CODE]\r\n" + 
					"        WHERE\r\n" + 
					"        (\r\n" + 
					"                  [AD].[PRIMARY_ACCOUNT_ID] IN (SELECT [A].[ID] FROM [dbo].[ACCOUNT] AS [A] WITH (NOLOCK)\r\n" + 
					"                                                JOIN [dbo].[ACCOUNT_ROLE_TYPE] AS [ART] WITH (NOLOCK) ON [A].[ROLE_TYPE_ID] = [ART].[ID]\r\n" + 
					"                                                WHERE [ART].[ROLE_NAME] = 'LENDER')\r\n" + 
					"                  \r\n" + 
					"              )");

			// save data in map
			dbMap = dc.returnAllData(rs);
			System.out.println(dbMap);
			navigate();
			lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			vo.navigatetoimpersonate();
			HashMap<String, String> data = dbMap.get(1);
			String roleId = data.get("ROLE_IDENTIFIER");
			ia.impersonateUser("Lender", roleId);
			vo.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
			String contractno = data.get("CERT");
			System.out.println(contractno);
			searchdata("Contract", contractno);
			Assert.assertEquals(recordText(), "Showing 0 to 1 of 1 records");
			tableMap = tabledata();
			HashMap<String, String> firstRow = tableMap.get(1);
			Assert.assertEquals(firstRow.get("VIN"), data.get("VIN"));
			Assert.assertEquals(firstRow.get("Last"), data.get("CUSTOMER_LAST"));
			Assert.assertEquals(firstRow.get("Year"), data.get("AUTOYEAR"));
			Assert.assertEquals(firstRow.get("Make"), data.get("AUTOMAKE"));
			Assert.assertEquals(firstRow.get("Model"), data.get("AUTOMODEL"));
			Assert.assertEquals(quoteLink().getText(), "Quote");
			driver.navigate().refresh();
			String lname = data.get("CUSTOMER_LAST");
			System.out.println(lname);
			searchdata("CUSTOMER_LAST", lname);
			tableMap = tabledata();
			HashMap<String, String> lfirstRow = tableMap.get(1);
			Assert.assertEquals(lfirstRow.get("Last"), data.get("CUSTOMER_LAST"));
			Assert.assertEquals(quoteLink().getText(), "Quote");
			driver.navigate().refresh();
			String vinnumber = data.get("VIN");
			System.out.println(vinnumber);
			searchdata("VIN", vinnumber);
			tableMap = tabledata();
			HashMap<String, String> vfirstRow = tableMap.get(1);
			Assert.assertEquals(vfirstRow.get("VIN"), data.get("VIN"));
			Assert.assertEquals(vfirstRow.get("Last"), data.get("CUSTOMER_LAST"));
			Assert.assertEquals(vfirstRow.get("Year"), data.get("AUTOYEAR"));
			Assert.assertEquals(vfirstRow.get("Make"), data.get("AUTOMAKE"));
			Assert.assertEquals(vfirstRow.get("Model"), data.get("AUTOMODEL"));
			Assert.assertEquals(quoteLink().getText(), "Quote");
			
		} catch (Exception e) {
			throw e;
		} finally {
			//// close connection
			dc.closeConnection();
			lo.logout();

		}

	}

	
	@Test(priority = 6)
	public void lenderCancellationModelBox() throws Exception {

		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		HashMap<Integer, HashMap<String, String>> tableMap = new HashMap<Integer, HashMap<String, String>>();

		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery(
					"	SELECT DISTINCT TOP 1\r\n" + 
					"               [PA].[ROLE_IDENTIFIER],\r\n" + 
					"               [PA].[ID],\r\n" + 
					"               [PA].[NAME],\r\n" + 
					"               [AD].[ID] AS 'ALLSALES_DETAILS_ID',\r\n" + 
					"               [AVD].[AUTOYEAR],\r\n" + 
					"               [AVD].[AUTOMAKE],\r\n" + 
					"               [AVD].[AUTOMODEL],\r\n" + 
					"               [AD].[CERT],\r\n" + 
					"               [CS].[NAME] AS 'CONTRACT_STATUS',\r\n" + 
					"               [AD].[CUSTOMER_FIRST],\r\n" + 
					"               [AD].[CUSTOMER_LAST],\r\n" + 
					"               [AD].[CUSTOMER_PAID],\r\n" + 
					"               [WC].[DEALER_ID] AS 'DEALER_ROLE_IDENTIFIER',\r\n" + 
					"               [AD].[LENDER_COMPANY],\r\n" + 
					"               [AD].[PRICESHEET_ID],\r\n" + 
					"               [AD].[VIN]\r\n" + 
					"        FROM [dbo].[ALLSALES_DETAILS] AS [AD] WITH (NOLOCK)\r\n" + 
					"            JOIN [dbo].[WEB_CONTRACTS] AS [WC]\r\n" + 
					"                ON [WC].[CERT] = [AD].[CERT]\r\n" + 
					"            JOIN [dbo].[ALLSALES_VIN_DETAIL] AS [AVD] WITH (NOLOCK)\r\n" + 
					"                ON [AD].[VIN_DETAILS_ID] = [AVD].[ID]\r\n" + 
					"            JOIN [dbo].[UW_CONTRACT_STATUS] AS [CS] WITH (NOLOCK)\r\n" + 
					"                ON [AD].[CONTRACT_STATUS_ID] = [CS].[ID]\r\n" + 
					"            LEFT JOIN [adl].[CANCELLATIONS_EXCLUSION_LIST] AS [EX] WITH (NOLOCK)\r\n" + 
					"                ON (\r\n" + 
					"                       [EX].[ACCOUNT_ID] = [AD].[PRIMARY_ACCOUNT_ID]\r\n" + 
					"                       OR [EX].[ACCOUNT_ID] = [AD].[SECONDARY_ACCOUNT_ID]\r\n" + 
					"                   )\r\n" + 
					"            LEFT JOIN [dbo].[ACCOUNT] AS [PA] WITH (NOLOCK)\r\n" + 
					"                ON [PA].[ID] = [AD].[PRIMARY_ACCOUNT_ID]\r\n" + 
					"            LEFT JOIN [dbo].[ACCOUNT_ROLE_TYPE] AS [ARTP] WITH (NOLOCK)\r\n" + 
					"                ON [ARTP].[ID] = [PA].[ROLE_TYPE_ID]\r\n" + 
					"            --- Check if Cancellable\r\n" + 
					"            LEFT JOIN [ocean].[PRICESHEET_PROPERTY] AS [PP]\r\n" + 
					"                ON [PP].[PROGRAM_CODE] = [WC].[PROGRAM_CODE]\r\n" + 
					"        WHERE\r\n" + 
					"        (\r\n" + 
					"                  [AD].[PRIMARY_ACCOUNT_ID] IN (SELECT [A].[ID] FROM [dbo].[ACCOUNT] AS [A] WITH (NOLOCK)\r\n" + 
					"                                                JOIN [dbo].[ACCOUNT_ROLE_TYPE] AS [ART] WITH (NOLOCK) ON [A].[ROLE_TYPE_ID] = [ART].[ID]\r\n" + 
					"                                                WHERE [ART].[ROLE_NAME] = 'LENDER')\r\n" + 
					"                  \r\n" + 
					"              )");

			// save data in map
			dbMap = dc.returnAllData(rs);
			navigate();
			lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			vo.navigatetoimpersonate();
			HashMap<String, String> data = dbMap.get(1);
			String roleId = data.get("ROLE_IDENTIFIER");
			ia.impersonateUser("Lender", roleId);
			vo.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
			String contractno = data.get("CERT");
			searchdata("Contract", contractno);
			Assert.assertEquals(recordText(), "Showing 0 to 1 of 1 records");
			tableMap = tabledata();
			HashMap<String, String> firstRow = tableMap.get(1);
			Assert.assertEquals(quoteLink().getText(), "Quote");
			quoteLink().click();
			Assert.assertEquals(modelBoxOverlay().isDisplayed(), true);
			Assert.assertEquals(getContractNumber(), contractno);
			Assert.assertEquals(cancelLabelText(), "Cancel Date*");
			Assert.assertEquals(validateInitiatedByValue(), "Dealer");
			Assert.assertEquals(validateCancelReasonValue(), "Trade/Sale");
			Assert.assertEquals(validatefield(cancelMileage), "Cancel Mileage*");
			Assert.assertEquals(validatefield(quoteButton), "Quote");
			Assert.assertEquals(validatefield(cancelButton), "Cancel");
			Assert.assertEquals(validationMessage1(retailPrice), "Required");
			
		} catch (Exception e) {
			throw e;
		} finally {
			//// close connection
			dc.closeConnection();
			driver.findElement(By.cssSelector(close)).click();
			lo.logout();

		}
	}
	
	@Test(priority = 8)
	public void lenderCancellationQuote() throws Exception {

		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		HashMap<Integer, HashMap<String, String>> tableMap = new HashMap<Integer, HashMap<String, String>>();

		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery("SELECT  TOP 20\r\n" + 
					"               [PA].[ROLE_IDENTIFIER],\r\n" + 
					"               [PA].[ID],\r\n" + 
					"               [PA].[NAME],\r\n" + 
					"               [AD].[ID] AS 'ALLSALES_DETAILS_ID',\r\n" + 
					"               [AVD].[AUTOYEAR],\r\n" + 
					"               [AVD].[AUTOMAKE],\r\n" + 
					"               [AVD].[AUTOMODEL],\r\n" + 
					"               [AD].[CERT],\r\n" + 
					"               [CS].[NAME] AS 'CONTRACT_STATUS',\r\n" + 
					"               [AD].[CUSTOMER_FIRST],\r\n" + 
					"               [AD].[CUSTOMER_LAST],\r\n" + 
					"               [AD].[CUSTOMER_PAID],\r\n" + 
					"               [WC].[DEALER_ID] AS 'DEALER_ROLE_IDENTIFIER',\r\n" + 
					"               [AD].[LENDER_COMPANY],\r\n" + 
					"               [AD].[PRICESHEET_ID],\r\n" + 
					"               [AD].[VIN],\r\n" + 
					"			   [AD].[EXPIRATION_MILEAGE]\r\n" + 
					"        FROM [dbo].[ALLSALES_DETAILS] AS [AD] WITH (NOLOCK)\r\n" + 
					"            JOIN [dbo].[WEB_CONTRACTS] AS [WC]\r\n" + 
					"                ON [WC].[CERT] = [AD].[CERT]\r\n" + 
					"            JOIN [dbo].[ALLSALES_VIN_DETAIL] AS [AVD] WITH (NOLOCK)\r\n" + 
					"                ON [AD].[VIN_DETAILS_ID] = [AVD].[ID]\r\n" + 
					"            JOIN [dbo].[UW_CONTRACT_STATUS] AS [CS] WITH (NOLOCK)\r\n" + 
					"                ON [AD].[CONTRACT_STATUS_ID] = [CS].[ID]\r\n" + 
					"            LEFT JOIN [adl].[CANCELLATIONS_EXCLUSION_LIST] AS [EX] WITH (NOLOCK)\r\n" + 
					"                ON (\r\n" + 
					"                       [EX].[ACCOUNT_ID] = [AD].[PRIMARY_ACCOUNT_ID]\r\n" + 
					"                       OR [EX].[ACCOUNT_ID] = [AD].[SECONDARY_ACCOUNT_ID]\r\n" + 
					"                   )\r\n" + 
					"            LEFT JOIN [dbo].[ACCOUNT] AS [PA] WITH (NOLOCK)\r\n" + 
					"                ON [PA].[ID] = [AD].[PRIMARY_ACCOUNT_ID]\r\n" + 
					"            LEFT JOIN [dbo].[ACCOUNT_ROLE_TYPE] AS [ARTP] WITH (NOLOCK)\r\n" + 
					"                ON [ARTP].[ID] = [PA].[ROLE_TYPE_ID]\r\n" + 
					"            --- Check if Cancellable\r\n" + 
					"            LEFT JOIN [ocean].[PRICESHEET_PROPERTY] AS [PP]\r\n" + 
					"                ON [PP].[PROGRAM_CODE] = [WC].[PROGRAM_CODE]\r\n" + 
					"        WHERE\r\n" + 
					"        ([AD].[PRIMARY_ACCOUNT_ID] IN (SELECT [A].[ID] FROM [dbo].[ACCOUNT] AS [A] WITH (NOLOCK)\r\n" + 
					"                                                JOIN [dbo].[ACCOUNT_ROLE_TYPE] AS [ART] WITH (NOLOCK) ON [A].[ROLE_TYPE_ID] = [ART].[ID]\r\n" + 
					"                                                WHERE [ART].[ROLE_NAME] = 'LENDER') AND AD.[EXPIRATION_DATE] > GETDATE())");

			// save data in map
			dbMap = dc.returnAllData(rs);
		    System.out.println(dbMap);
			int j =1;
			int k =1; 
			do {
				navigate();
				lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
				vo.navigatetoimpersonate();
				HashMap<String, String> data = dbMap.get(k);
				System.out.println(data);
				String roleId = data.get("ROLE_IDENTIFIER");
				ia.impersonateUser("Lender", roleId);
				vo.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
				String contractno = data.get("CERT");
				searchdata("Contract", contractno);
				Assert.assertEquals(recordText(), "Showing 0 to 1 of 1 records");
				tableMap = tabledata();
				HashMap<String, String> firstRow = tableMap.get(1);
				Assert.assertEquals(quoteLink().getText(), "Quote");
				quoteLink().click();
				fillCancelMileage(data.get("EXPIRATION_MILEAGE"));
				List l = driver.findElements(By.cssSelector(".header .title"));
			    if(l.size() ==1)
			    {
			    	j++;
			    	Assert.assertEquals(validatefield(edit),"Edit");
			    	Assert.assertEquals(validatefield(quoteClose),"Close");
			    	Assert.assertEquals(printQuote(),"PRINT QUOTE");
			    	Assert.assertEquals(genarateQuote(),"GENERATE CANCEL FORM");
			    	//cancelQuote();
			    	Thread.sleep(4000);
			    	HashSet<String> b = new HashSet<>();
					b = isFileDownloaded( System.getProperty("user.dir") + "\\PDF", ".pdf");
					System.out.println(b);
			    	quotePDF();
					HashSet<String> a1 = new HashSet<>();
					a1 = isFileDownloaded(System.getProperty("user.dir") + "\\PDF", ".pdf");
					a1.removeAll(b);
					System.out.println(a1);
					String pdfUrl = "file:///" +  System.getProperty("user.dir") + "\\PDF\\" + a1.toString().replaceAll("\\,|\\[|\\]|\\s", "");
					String pdfUrl1 = pdfUrl.replace("\\", "/");
					System.out.println(pdfUrl1);
					verifyContentInPDf(pdfUrl1, data.get("CERT"));
					verifyContentInPDf(pdfUrl1, "Online Cancellation Quote");
					b.addAll(a1);
			    	
			    }
			    else {
			    	k++;
			    	driver.findElement(By.cssSelector(close)).click();
					lo.logout();
			    }
			} while(j==1);
			
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			//// close connection
			dc.closeConnection();


		}
	}
	
	@Test(priority = 9)
	public void dealerGroupCancellationSearchResult() throws Exception {

		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		HashMap<Integer, HashMap<String, String>> tableMap = new HashMap<Integer, HashMap<String, String>>();

		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery("SELECT TOP 10 WC.CERT, WC.DEALER_ID, WC.VIN ,  td.expiration_mileage, td.customer_paid, TD.CUSTOMER_LAST, WC.YEAR, WC.MODEL , WC.MAKE\r\n" + 
					"					FROM [DBO].[WEB_CONTRACTS] AS WC INNER JOIN [dbo].[ALLSALES_DETAILS]  AS TD ON WC.CERT = TD.CERT \r\n" + 
					"					WHERE WC.STATUS = 'Processed' AND  td.[CONTRACT_STATUS_ID] = 5  AND TD.[EXPIRATION_DATE] > GETDATE() AND WC.PROGRAM_CODE <> 'OLW' AND WC.DEALER_ID = '22723'\r\n" + 
					"					ORDER BY WC.DATE_CREATED DESC");

			// save data in map
			dbMap = dc.returnAllData(rs);
			System.out.println(dbMap);
			navigate();
			lo.login(prop.getProperty("dealerempusername1"), prop.getProperty("password"));
			HashMap<String, String> data = dbMap.get(1);
			vo.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
			Assert.assertEquals(emptyResult(), "Please make a search to display records");
			String contractno = data.get("CERT");
			searchdata("Contract", contractno);
			Assert.assertEquals(recordText(), "Showing 0 to 1 of 1 records");
			Assert.assertEquals(getFrontText(),
					"Use the input fields to find a contract holder. You can search by any one, or all, criteria.");
			Assert.assertEquals(disclaimerMessage(), 
					"Disclaimer: This is a quote page ONLY. The actual refund will be based on time and mileage when an AUL Cancellation Form is received with signatures by AUL Corp. Quotes remain valid for 14 days.");
			tableMap = tabledata();
			HashMap<String, String> firstRow = tableMap.get(1);
			Assert.assertEquals(firstRow.get("VIN"), data.get("VIN"));
			Assert.assertEquals(firstRow.get("Last"), data.get("CUSTOMER_LAST"));
			Assert.assertEquals(firstRow.get("Year"), data.get("YEAR"));
			Assert.assertEquals(firstRow.get("Make"), data.get("MAKE"));
			Assert.assertEquals(firstRow.get("Model"), data.get("MODEL"));
			//Assert.assertEquals(quoteLink().getText(), "Quote");
			driver.navigate().refresh();
			String lname = data.get("CUSTOMER_LAST");
			searchdata("CUSTOMER_LAST", lname);
			tableMap = tabledata();
			HashMap<String, String> lfirstRow = tableMap.get(1);
			Assert.assertEquals(lfirstRow.get("Last"), data.get("CUSTOMER_LAST"));
			//Assert.assertEquals(quoteLink().getText(), "Quote");
			driver.navigate().refresh();
			String vinnumber = data.get("VIN");
			searchdata("VIN", vinnumber);
			tableMap = tabledata();
			HashMap<String, String> vfirstRow = tableMap.get(1);
			Assert.assertEquals(firstRow.get("VIN"), data.get("VIN"));
			Assert.assertEquals(firstRow.get("Last"), data.get("CUSTOMER_LAST"));
			Assert.assertEquals(firstRow.get("Year"), data.get("Year"));
			Assert.assertEquals(firstRow.get("Make"), data.get("MAKE"));
			Assert.assertEquals(firstRow.get("Model"), data.get("MODEL"));
			//Assert.assertEquals(quoteLink().getText(), "Quote");
			
		} catch (Exception e) {
			throw e;
		} finally {
			//// close connection
			dc.closeConnection();
			lo.logout();

		}

	}

}
