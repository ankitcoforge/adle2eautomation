package testsuite;

import java.sql.ResultSet;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageActions.WebContractsByDealerAction;
import pageActions.cancellationHistoryAction;
import pageActions.cancellationQuotesAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.Database_Connectivity;


public class cancellationHistory_test extends cancellationHistoryAction {

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	impersonateAction ia = new impersonateAction();
	Database_Connectivity dc = new Database_Connectivity();
	cancellationQuotesAction cq = new cancellationQuotesAction();
	WebContractsByDealerAction wa = new WebContractsByDealerAction();
	

	@Test
	public void cancellationHistory() throws Exception {

		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		HashMap<Integer, HashMap<String, String>> tableMap = new HashMap<Integer, HashMap<String, String>>();

		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery(
					"EXEC [adl].[SP_GET_CANCEL_QUOTE_HISTORY] @ROLE_IDENTIFIER ='22723', @ROLE_TYPE ='DEALER'");

			// save data in map
			dbMap = dc.returnAllData(rs);
			if (dbMap.size() > 0) {
				HashMap<String, String> a = dbMap.get(1);
				HashMap<String, String> b = dbMap.get(dbMap.size());
				System.out.println(a);
				navigate();
				lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
				vo.navigatetoimpersonate();
				ia.impersonateUser("Dealer", "22723");
				vo.navigatetoLeftMenu("Cancellations", "Cancellation History");
				if (dbMap.size() >= 25)
					Assert.assertEquals(cq.recordText(),
							"Showing 1 to" + dbMap.size() + "of" + dbMap.size() + " records");
				tableMap = cq.tabledata();
				HashMap<String, String> firstRow = tableMap.get(1);
				System.out.println(tableMap);
				Assert.assertEquals(b.get("CERT"), firstRow.get("Contract"));

			}

		} catch (Exception e) {
			throw e;
		} finally {
			// close connection
			dc.closeConnection();
			lo.logout();

		}
	}

	
	@Test
	public void cancellationHistoryHeader() throws Exception {

		
				navigate();
				lo.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
				vo.navigatetoimpersonate();
				ia.impersonateUser("Dealer", "22723");
				vo.navigatetoLeftMenu("Cancellations", "Cancellation History");
				Assert.assertEquals(driver.getCurrentUrl(),
						"https://qa.adl.aulcorp.com/portal/cancellations/cancellation-history");
				Assert.assertEquals(description(), 
						"The following report displays a history of the online cancellation quotes and forms that you have created for a contract.");
				Assert.assertEquals(header().get(0).getText(), "Contract Holder");
				Assert.assertEquals(header().get(1).getText(), "Status");
				Assert.assertEquals(header().get(2).getText(), "Contract");
				Assert.assertEquals(header().get(3).getText(), "Net Refund");
				Assert.assertEquals(header().get(4).getText(), "Refund %");
				Assert.assertEquals(header().get(5).getText(), "Quote Date");
				Assert.assertEquals(header().get(6).getText(), "Quote Mileage");
				Assert.assertEquals(header().get(7).getText(), "Initiated By");
				Assert.assertEquals(header().get(8).getText(), "Cancellation Reason");
				Assert.assertEquals(header().get(9).getText(), "Download Form");
				Assert.assertEquals(defaultPage(), "25");
				wa.getRowsPerPageDropdownbtn().click();
				Thread.sleep(2000);
					String perPage25 = wa.getRowsPerPageDropdownlist().get(0).getText();
					String perPage50 = wa.getRowsPerPageDropdownlist().get(1).getText();
					String perPage100 = wa.getRowsPerPageDropdownlist().get(2).getText();
					System.out.println(wa.getRowsPerPageDropdownlist().get(0).getText());
					Assert.assertTrue(perPage25.equals("25"), "25 is displayed in dropdown");
					Assert.assertTrue(perPage50.equals("50"), "50 is displayed in dropdown");
					Assert.assertTrue(perPage100.equals("100"), "100 is displayed in dropdown");
			
	}
	
	
}
