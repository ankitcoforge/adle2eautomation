package testsuite;

import java.sql.ResultSet;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.Database_Connectivity;
import utils.baseClass;

public class cancellationQuote extends baseClass{
	
	
	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	impersonateAction ia = new impersonateAction();
	Database_Connectivity dc = new Database_Connectivity();
	
	/*************login to the application
	 * @throws InterruptedException *********************/
	@BeforeClass()
	public void login() throws InterruptedException {
//		navigate();
//		lo.login(prop.getProperty("adminusername"),prop.getProperty("adminpassword"));
//		vo.navigatetoimpersonate();
//		ia.impersonateUser("Dealer","74741");
//		vo.navigatetoLeftMenu("Cancellations", "Cancellation Quote");
	}

	/********************quote creation test case
	 * @throws Exception ****************/
	@Test(priority = 1)
    public void createQuote1() throws Exception {
		
		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		
	   
	    
	    		
		dc.aulDBConnect();
        ResultSet rs =dc.stmt.executeQuery("SELECT top 1 td.CERT, ac.ROLE_IDENTIFIER , td.VIN , td.START_MILEAGE, td.END_MILEAGE, td.CUSTOMER_LAST, td.EXPIRATION_DATE FROM "
        		+ " [dbo].[ALLSALES_DETAILS] as td inner join [dbo].[account] as ac ON td.PRIMARY_ACCOUNT_ID = ac.ID "
        		+ "WHERE  td.[CONTRACT_STATUS_ID] = 5 AND td.ENTITY = 'WEB' AND ac. ROLE_TYPE_ID =1 AND ac.ACCOUNT_STATUS_ID= 1");

         //// save data in map
   			dbMap = dc.returnAllData(rs);
   			System.out.println(dbMap);
   			for(int i =1;i <= dbMap.size(); i++) {
//   			    System.out.println(dbMap.get(i));
   			 HashMap<String, String> data = dbMap.get(i);
  			System.out.println(data.get("ROLE_IDENTIFIER"));
   
   			}
//   		 HashMap<String, String> data = dbMap.get(3);
//   			System.out.println(data.get("ROLE_IDENTIFIER"));
   			
   			
		//// save data in map
//		dbMap = returnAllData(rs);
//		driver.findElement(By.cssSelector("input[placeholder ='Contract Number']")).sendKeys("AXTMS515103K20");
//		driver.findElement(By.cssSelector("button[type='submit']")).click();
//		System.out.println(driver.findElements(By.xpath("//a[contains(text(),\"Quote\")]")).size());
//		driver.findElement(By.cssSelector("td:nth-child(10) > adl-table-cells > div > a")).click();
//		driver.findElement(By.cssSelector(".cdk-overlay-pane")).isDisplayed();
//		driver.findElements(By.tagName("mat-radio-button")).get(6).click();
//		driver.findElement(By.cssSelector(".quote_mileage >adl-text-input >div > div:nth-child(2) > input")).sendKeys("5000");
//		driver.findElement(By.cssSelector("button.quote_btn_ok")).click();
//		System.out.println(driver.findElement(By.cssSelector(".overlay-form >button > span")).getText());
//		System.out.println(driver.findElement(By.cssSelector("div.results-container.ng-star-inserted > div.header > span")).getText());
//		driver.findElement(By.cssSelector("button[aria-label = 'Close']")).click();
		dc.closeConnection();
	}
	
	
	/***************logout to the application
	 * @throws InterruptedException ********************/
	@AfterClass
	public void close() throws InterruptedException {

//		lo.logout();
		
	}
}


