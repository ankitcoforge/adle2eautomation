package pageActions;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.CancellationsPO;
import utils.Database_Connectivity;
import utils.utilityClass;

public class CancellationsAction extends CancellationsPO {

	Database_Connectivity dc = new Database_Connectivity();
	utilityClass utils = new utilityClass();

//	public HashMap<Integer, HashMap<String, String>> getDataFromDB() throws Exception  {
//		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
//		try {
//			dc.aulDBConnect();
//			ResultSet rs = dc.stmt.executeQuery(
//					"SELECT TOP 5 WC.CERT, WC.DEALER_ID, WC.LAST_NAME,td.AUTOMILES, WC.VIN , td.expiration_mileage, td.customer_paid , WC.Year,  WC.MAKE, WC.MODEL\r\n"
//							+ "FROM [DBO].[WEB_CONTRACTS] AS WC INNER JOIN [dbo].[ALLSALES_DETAILS]  AS TD ON WC.CERT = TD.CERT \r\n"
//							+ "WHERE WC.STATUS = 'Processed' AND  td.[CONTRACT_STATUS_ID] = 5  AND TD.[EXPIRATION_DATE] > GETDATE() \r\n"
//							+" AND TD.CUSTOMER_PAID<3000  \r\n"
//							+ "ORDER BY WC.DATE_CREATED DESC");
//			dbMap = dc.returnAllData(rs);
//			return dbMap;
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			dc.closeConnection();
//		}
//		
//	}

	public HashMap<Integer, HashMap<String, String>> getDataFromDBForMileageMoreThan3000() throws Exception {
		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery(
					"SELECT TOP 5 WC.CERT, WC.DEALER_ID, WC.LAST_NAME,td.AUTOMILES, WC.VIN , td.expiration_mileage, td.customer_paid , WC.Year,  WC.MAKE, WC.MODEL\r\n"
							+ "FROM [DBO].[WEB_CONTRACTS] AS WC INNER JOIN [dbo].[ALLSALES_DETAILS]  AS TD ON WC.CERT = TD.CERT \r\n"
							+ "WHERE WC.STATUS = 'Processed' AND  td.[CONTRACT_STATUS_ID] = 5  AND TD.[EXPIRATION_DATE] > GETDATE() \r\n"
							+ " AND TD.CUSTOMER_PAID>3500  \r\n" + "ORDER BY WC.DATE_CREATED DESC");
			dbMap = dc.returnAllData(rs);
			return dbMap;
		} catch (Exception e) {
			throw e;
		} finally {
			dc.closeConnection();
		}
	}

	public HashMap<Integer, HashMap<String, String>> getDataFromDB() throws Exception {
		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery(
					"SELECT tOP 5 td.AUTOMILES, td.expiration_mileage, td.customer_paid, td.cert as CERT, td.primary_account_id, td.CUSTOMER_LAST, td.VIN, ac. ROLE_TYPE_ID, ac.ROLE_IDENTIFIER as DEALER_ID\r\n"
							+ "	from  [dbo].[ALLSALES_DETAILS] AS td INNER JOIN  [ocean].[PRICESHEET_PROPERTY] as ed on ed.program_code = td.PROGRAM_CODE\r\n"
							+ "	INNER JOIN ACCOUNT as ac on ac.id = td.PRIMARY_ACCOUNT_ID\r\n"
							+ "	AND  td.[CONTRACT_STATUS_ID] = 5  AND TD.[EXPIRATION_DATE] > GETDATE() AND TD.CUSTOMER_PAID<3000  \r\n"
							+ "	and ed.is_cancellable = 1  ORDER BY UPDATE_DATE");
			dbMap = dc.returnAllData(rs);
			return dbMap;
		} catch (Exception e) {
			throw e;
		} finally {
			dc.closeConnection();
		}
	}

}
