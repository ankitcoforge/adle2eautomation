package testsuite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.ContractSearchPageAction;
import pageActions.LateralMenuAction;
import pageActions.contractSearchAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;
@Listeners(utils.listnerlogs.class)

public class contractSearch_test extends ContractSearchPageAction{

		loginAction login = new loginAction();
		verticalMenuAction verticalMenu = new verticalMenuAction();
		utilityClass utils = new utilityClass();

		@BeforeClass
		public void login() throws InterruptedException {
			navigate();
			Assert.assertEquals(login.getTitle(), "AUL Corp.");
			login.login(prop.getProperty("username1"), prop.getProperty("password"));
			verticalMenu.navigatetoLeftMenu("Contracts","Contract Search");
		}
		

		
		@Test
        public void pageredirection_15087_15228_15229_20716() throws InterruptedException {
			
			
			filterStatus("Entered");
			for(int i =0; i<editReContractlink().size(); i++ ) {
				Assert.assertEquals(editReContractlink().get(i), "Edit");
			}
		    Assert.assertEquals(editContracturl(), "https://qa.adl.aulcorp.com/portal/contracts/edit-contract");
		    driver.navigate().back();
		}
		
		@Test
		public void headerVerification_20969() throws InterruptedException {
			
//			verticalMenu.navigatetoLeftMenu("Contracts","Contract Search");
			ArrayList list = new ArrayList<> ();
			list.addAll(Arrays.asList("","Select", "Status", "Remit Date", "CC Reward ID", "Contract", "VIN", "Program", "Lienholder", "Last Name", "Sale Date", "Processed Date", "Retail Price", "AUL Cost", "Cert Form", "Remit Form","" ,"" ,"" ));
		    Assert.assertEquals(tableHeader(),list);
	         
		}
		
		@Test
        public void reContractLink_20719() throws InterruptedException {
			
//			verticalMenu.navigatetoLeftMenu("Contracts","Contract Search");
			filterStatus("Entered");
			for(int i =0; i<reContractlink().size(); i++ ) {
				Assert.assertEquals(reContractlink().get(i), "Re-Contract");
			}
		    Assert.assertEquals(reContracturl(), "https://qa.adl.aulcorp.com/portal/rate/rate-contract");
		    driver.navigate().back();
		}

		@Test
		public void editReContractHeader_20723_20718() throws InterruptedException {
			
//			verticalMenu.navigatetoLeftMenu("Contracts","Contract Search");
		    Assert.assertFalse(tableHeader().equals("Re-Contract"));
		    Assert.assertFalse(tableHeader().equals("Edit"));
		      
		}
		
		@Test
		public void recordNumber_20731_20736() throws InterruptedException {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//Scroll down till the bottom of the page
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		    String count = utils.text("cssSelector", "p-paginator > div >span");
		    Assert.assertTrue(count.startsWith("Showing"));
		    Assert.assertTrue(count.endsWith("records"));
		    int length = driver.findElements(By.xpath(row)).size();
		    String a[] = count.split(" ");
		    int j = a.length;
		    int i = Integer.parseInt(a[j-2]);
            if(i<=25) {
            	
            	Assert.assertEquals(length, i);
            }
            else {
            	Assert.assertEquals(length,25);
            }
		      
		}		
		
		@Test
		public void defaultRecordNumber_20733_20732() throws InterruptedException {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//Scroll down till the bottom of the page
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		    String count = utils.text("cssSelector", "p-dropdown >div >div:nth-child(2) >span");
		    Assert.assertEquals(count, "25");
		    driver.findElement(By.cssSelector("[role='button']")).click();
		    ArrayList a = new ArrayList();
		    int length = driver.findElements(By.cssSelector("p-dropdownitem > li")).size();
		    for(int i =0; i< length; i++) {
		    	a.add(driver.findElements(By.cssSelector("p-dropdownitem > li")).get(i).getText());
		    }
		      ArrayList b = new ArrayList();
		      b.add("25");
		      b.add("50");
		      b.add("100");
		      Assert.assertEquals(a,b);
		    }		
		
		
		/***************logout to the application
		 * @throws InterruptedException ********************/
		@AfterClass
		public void close() throws InterruptedException {
	 
		        login.logout();
		    }
			
}
