package pageActions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
					"SELECT tOP 5 td.AUTOMILES, td.expiration_mileage, td.customer_paid, td.cert as CERT, td.primary_account_id, wc.PREMIUM, td.CUSTOMER_LAST,td.VIN, td.AUTOMILES as Miles, ac. ROLE_TYPE_ID, ac.ROLE_IDENTIFIER as DEALER_ID \r\n"
					+ "\r\n"
					+ "from  [dbo].[ALLSALES_DETAILS] AS td \r\n"
					+ "\r\n"
					+ "Inner Join web_contracts as wc on wc.CERT = td.CERT\r\n"
					+ "\r\n"
					+ "INNER JOIN  [ocean].[PRICESHEET_PROPERTY] as ed on ed.program_code = td.PROGRAM_CODE \r\n"
					+ "\r\n"
					+ "INNER JOIN ACCOUNT as ac on ac.id = td.PRIMARY_ACCOUNT_ID AND  td.[CONTRACT_STATUS_ID] = 5 and wc.PREMIUM < 3000 AND TD.[EXPIRATION_DATE] > GETDATE() AND TD.CUSTOMER_PAID<3000 and ed.is_cancellable = 1  and ROLE_TYPE_ID = 1 ORDER BY UPDATE_DATE desc-- ORDER BY UPDATE_DATE\r\n");
			dbMap = dc.returnAllData(rs);
			return dbMap;
		} catch (Exception e) {
			throw e;
		} finally {
			dc.closeConnection();
		}
	}
	
	
	public HashMap<Integer, HashMap<String, String>> getDataFromDBForStatus1(String status) throws Exception {
		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		try {
			dc.aulDBConnect();
			ResultSet rs = dc.stmt.executeQuery(
					"SELECT DISTINCT [WC].[DEALER_ID] AS 'DEALER_ID'\r\n"
					+ "			   ,[CS].[NAME] AS 'STATUS'\r\n"
					+ "			   ,[CIB].[NAME]		   \r\n"
					+ "FROM [dbo].[ALLSALES_DETAILS] AS [A] WITH (NOLOCK)\r\n"
					+ "JOIN [dbo].[CANCELLATION_PARAMETERS] AS [CP] WITH (NOLOCK) ON [CP].[ALLSALES_DETAILS_ID] = [A].[ID]\r\n"
					+ "JOIN [dbo].[CANCELLATION_STATUS] AS [CS] WITH (NOLOCK) ON [CP].[STATUS_ID] = [CS].[ID]\r\n"
					+ "JOIN [dbo].[UW_CONTRACT_STATUS] AS [UCS] WITH (NOLOCK) ON [A].[CONTRACT_STATUS_ID] = [UCS].[ID]\r\n"
					+ "JOIN [dbo].[CANCELLATION_INITIATED_BY] AS [CIB] WITH (NOLOCK) ON [CP].[INITIATED_BY_ID] = [CIB].[ID]\r\n"
					+ "JOIN [dbo].[CANCELLATION_REASON_TYPE] AS [CRT] WITH (NOLOCK) ON [CP].[REASON_TYPE_ID] = [CRT].[ID]\r\n"
					+ "JOIN [dbo].[WEB_CONTRACTS] AS [WC] ON [WC].[CERT] = [A].[CERT]\r\n"
					+ "WHERE  [UCS].[NAME] IN ('Active', 'Cancelled')\r\n"
					+ "   AND [CIB].[NAME]='Dealer'\r\n"
					+ "   AND [CP].[RESULT_SUCCESS] = 1\r\n"
					+ "   AND [CS].[NAME] IN ('"+status+"')");
			dbMap = dc.returnAllData(rs);
			return dbMap;
		} catch (Exception e) {
			throw e;
		} finally {
			dc.closeConnection();
		}
	}
	
	
	public List<WebElement> getRows() {
		List<WebElement> allRows = utils.getElementsList("xpath", totalRows);
		return allRows;
	}
	
	public WebElement getDowloadLink(int i) throws InterruptedException {
	String dowload = "table>tbody>tr:nth-of-type("+ i +")>td:nth-of-type(10)>adl-table-cells>div>div:nth-of-type(1)>i";
		 WebElement downloadLink = utils.element("cssSelector", dowload);
		return downloadLink;
	}
	
	public HashMap<Integer, HashMap<String,String >> checkGridBodyDetailsTxt() {
		List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
		System.out.println("allHeaderNames: " + allHeaderNames);
		HashMap<Integer, HashMap<String, String>> allTableData = new HashMap<Integer, HashMap<String, String>>();
		// Get total rows count
		List<WebElement> allRows = utils.getElementsList("cssSelector", rowLoc);
		System.out.println("No of rows in grid: " + allRows.size());
		for (int i = 1; i <= allRows.size(); i++) {
			// Getting specific row with each iteration
			String specificRowLoc = "table>tbody>tr:nth-of-type(" + i + ")";
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			for (int j = 2; j <= 9; j++) {
				String specificRowColLoc = "td:nth-of-type(" + j + ")>adl-table-cells>div>span:nth-of-type(2)";
				 String cellValue = utils.text("cssSelector", specificRowLoc + ">" + specificRowColLoc);
				eachRowData.put(allHeaderNames.get(j-1), cellValue);
			}
			allTableData.put(i, eachRowData);
		}
		System.out.println("Complete Grid data: " + allTableData);
		utils.scrollUp();
	    return allTableData;
	}

	public void verifyContentInPDf(String url, String program) {
		//specify the url of the pdf file
		try {
			String pdfContent = readPdfContent(url);
				Assert.assertTrue(pdfContent.contains(program));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public void validateXlsx() throws InterruptedException {
		 HashSet<String> b = new HashSet<>();
			b = isFileDownloaded( System.getProperty("user.dir") + "\\PDF", ".pdf");
			utils.getfield("button", "Export xls").click();
			Thread.sleep(3000);
			HashSet<String> a1 = new HashSet<>();
			a1 = isFileDownloaded( System.getProperty("user.dir") + "\\PDF", ".pdf");
			a1.removeAll(b);
			String xlsxUrl = "file:///" +  System.getProperty("user.dir") + "\\PDF\\" + a1.toString().replaceAll("\\,|\\[|\\]|\\s", "");
			String xlsxUrl1 = xlsxUrl.replace("\\", "/");
			System.out.println("URL ISSS----"+xlsxUrl1);
			verifyContentInPDf(xlsxUrl1, "Upsell Program");
			Assert.assertTrue(xlsxUrl1.contains("xlsx"));
			b.addAll(a1);
		 }
	 
	 public void selectStatus(String status) throws InterruptedException {
		 Thread.sleep(2000);
		 utils.element("xpath", statusArrow).click();
		 String ele= "//li[@aria-label='"+status +"']/div/div";
		 utils.element("xpath", ele).click();
		 utils.element("xpath", statusArrow).click();
		 Thread.sleep(2000);
	 }
}
