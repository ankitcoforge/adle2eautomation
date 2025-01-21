package testsuite;
import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.WebContractsByDealerAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import pageActions.ContractSearchPageAction;
import utils.Database_Connectivity;
import utils.XmlDataReader;
import utils.utilityClass;

/* Divyasree */
/* Tc's active = 46 , invalid/commented due to bug = 3 */

@Listeners(utils.listnerlogs.class)
public class WebContractsByDealer_test extends WebContractsByDealerAction {
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	singleContractAction singleContract=new singleContractAction();
	ContractSearchPageAction contractSearchPage=new ContractSearchPageAction();
	Database_Connectivity dc = new Database_Connectivity();
	XmlDataReader utilsDataReader= new XmlDataReader("UtilsData");
	XmlDataReader webcontracts= new XmlDataReader("webcontractsData");

	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}
	
	@Test(priority = 1)
	public void verifyTitlePage_26894() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
	}

	@Test(priority = 2)
	public void verifyRoleId_26896() throws InterruptedException {
		String username = prop.getProperty("adminusername");
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
		Assert.assertTrue(getAdminRoleId().equalsIgnoreCase(username));
	}

	@Test(priority = 3)
	public void verifyURL_26899() throws InterruptedException {
		
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
		Assert.assertTrue(driver.getCurrentUrl().contains(
				webcontracts.getXMLData("webcontractsURL")));
	}

	@Test(priority = 4)
	public void verifyURLinAUL_26900() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
		Assert.assertTrue(driver.getCurrentUrl().contains(
				webcontracts.getXMLData("webcontractsURL")));
		//Assert.assertEquals(utilsDataReader.getXMLData("aul"), true);
	}

	@Test(priority = 5)
    public void verifyNonAdminAccess_26904() throws InterruptedException {
	login.login(prop.getProperty("lenderAutomation"),prop.getProperty("password"));
	leftMenu("Report");
	for (int i = 0; i < getReportsDropdownlist().size(); i++) {
			Assert.assertFalse(getReportsDropdownlist().get(i).getText().contains(webcontracts.getXMLData("webcontractsTitle")));
	}
	}

	@Test(priority = 6)
	public void verifyRowsPerPage_27164() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
//		getElementInFirstGrid("Dealer ID").sendKeys(prop.getProperty("roleid"));
//		getArrowForwardBtn().click();
//		Thread.sleep(20000);
//		Assert.assertTrue(getContractsGrid().isDisplayed());
//		Thread.sleep(2000);
//		utils.scrollDownUsingJSE();
		Assert.assertTrue(getRowsPerPage().isDisplayed());
//		utils.scrollDownUsingJSE();
		getRowsPerPageDropdownbtn().click();
		Thread.sleep(1000);
			String perPage25 = getRowsPerPageDropdownlist().get(0).getText();
			String perPage50 = getRowsPerPageDropdownlist().get(1).getText();
			String perPage100 = getRowsPerPageDropdownlist().get(2).getText();
			Assert.assertTrue(perPage25.equals(webcontracts.getXMLData("perPage25")), "25 is displayed in dropdown");
			Assert.assertTrue(perPage50.equals(webcontracts.getXMLData("perPage50")), "50 is displayed in dropdown");
			Assert.assertTrue(perPage100.equals(webcontracts.getXMLData("perPage100")), "100 is displayed in dropdown");
	}

	@Test(priority = 7)
	public void verifyRowsPerPageSelected_27280() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
//		getElementInFirstGrid("Dealer ID").sendKeys(prop.getProperty("roleid"));
//		getArrowForwardBtn().click();
//		Thread.sleep(2000);
//		Assert.assertTrue(getContractsGrid().isDisplayed());
//		utils.scrollDown();
		getRowsPerPage().isDisplayed();
		getRowsPerPageDropdownbtn().click();
		Thread.sleep(10000);
		String NoOfRowsToSelect = getRowsPerPageDropdownlist().get(1).getAttribute("value");
		getRowsPerPageDropdownlist().get(1).click();
		String NoOfRowsSelected = getRowsPerPageSelected().getAttribute("value");
		Assert.assertEquals(NoOfRowsToSelect, NoOfRowsSelected);
	}

//	@Test(priority = 8)
//	public void verifyPageNumbers_27310() throws InterruptedException {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
//		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
////		getElementInFirstGrid("Dealer ID").sendKeys(prop.getProperty("roleid"));
////		getArrowForwardBtn().click();
////		Thread.sleep(2000);
////		utils.scrollDown();
//		getRowsPerPage().isDisplayed();
//		getRowsPerPageDropdownbtn().click();
//		getRowsPerPageDropdownlist().get(0).click();
//		getPageNo(webcontracts.getXMLData("pageNo2")).click();
//		Assert.assertTrue(getCurrentPageRecord().equals(webcontracts.getXMLData("pageRecord26")), "Page 2 is displaying");
//		getPageNo(webcontracts.getXMLData("pageNo5")).click();
//		Assert.assertTrue(getCurrentPageRecord().equals(webcontracts.getXMLData("pageRecord101")), "Page 5 is displaying");
//	}
//
//	@Test(priority = 9)
//	public void verifyTotalPageNumbersPerPage_27326() throws InterruptedException {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
//		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
////		getElementInFirstGrid("Dealer ID").sendKeys(prop.getProperty("roleid"));
////		getArrowForwardBtn().click();
////		Thread.sleep(10000);
////		utils.scrollDown();
//		getRowsPerPage().isDisplayed();
//		utils.scrollDownUsingJSE();
//		getRowsPerPageDropdownbtn().click();
//		getRowsPerPageDropdownlist().get(0).click();
//		Assert.assertTrue(getTotalPagesDisplayed().toString().equals(webcontracts.getXMLData("pageNo5")), "five pages are displayed at a time");
//	}

	@Test(priority = 10)
	public void verifyTxt_27327() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
		Assert.assertTrue(getContractsGrid().isDisplayed());
		Assert.assertTrue(getPlsMakeaSearchTxt().isDisplayed());
	}

	@Test(priority = 11)
	public void verifyUndoEditIcons_27329() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
		getElementInFirstGrid("Dealer ID").sendKeys(prop.getProperty("roleid"));
		getArrowForwardBtn().click();
		Thread.sleep(3000);
		Assert.assertTrue(getContractsGrid().isDisplayed());
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		Actions action = new Actions(driver);
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String status = allTableData.get(i).get("Status");
			  if(status.equals(webcontracts.getXMLData("statusEntered")))
			  {
		action.moveToElement(getEditRestorBtns(i)).perform();
		Assert.assertTrue(getEditStatusTxt().get(1).isDisplayed());
			  }
			  break;
		}
		getGridArrowBtn("Status").click();
		verifyRestoreMsgFromRestoreIcon();
	}
	
	@Test(priority = 12)
	public void verifySearchForContractNumAndContractHoldrLastName_27341() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"),prop.getProperty("password"));
		verticalMenu.navigatetoContract();
		String contractNumber = singleContract.singleContract();
		Thread.sleep(1000);
		utils.scrollDown();
		login.logout();
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
		Assert.assertTrue(getElementInFirstGrid("Contract Number").isDisplayed());
		getElementInFirstGrid("Contract Number").sendKeys(contractNumber);
		Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
		String contractHolderLastName = prop.getProperty("lastName");
		getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
		Assert.assertTrue(getArrowForwardBtn().isDisplayed());
		getArrowForwardBtn().click();
		Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		String ContractNumberInGrid = allTableData.get(1).get("Contract Number");
		Assert.assertTrue(ContractNumberInGrid.equals(contractNumber),"Contract Number Records are matching");
		String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
		Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
	}


	@Test(priority = 13)
	public void verifyNavigationUsingTabs_27340() throws InterruptedException {
//		login.login(prop.getProperty("dealerAutomation"),prop.getProperty("password"));
//		verticalMenu.navigatetoContract();
//		singleContract.singleContract();
//		login.logout();
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
		Assert.assertTrue(getElementInFirstGrid("Last 6 of VIN").isDisplayed());
		String enterVIN=webcontracts.getXMLData("vin3");
		getElementInFirstGrid("Last 6 of VIN").sendKeys(enterVIN);
		Thread.sleep(2000);
		getElementInFirstGrid("Last 6 of VIN").sendKeys(Keys.TAB);
		getElementInFirstGrid("Last 6 of VIN").sendKeys(Keys.TAB);
		getElementInFirstGrid("Last 6 of VIN").sendKeys(Keys.TAB);
		getElementInFirstGrid("Last 6 of VIN").sendKeys(Keys.TAB);
		getArrowForwardBtn().click();
//		Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
		Thread.sleep(20000);
		Assert.assertTrue(getContractsGrid().isDisplayed(),"Navigation Working Correctly");
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
        String VINnumFromGrid = allTableData.get(1).get("VIN");
		Assert.assertTrue(VINnumFromGrid.equals(enterVIN),"Records are matching");
	}
	
		
	@Test(priority = 14)
	public void verifySearchForContractNumber_27345() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"),prop.getProperty("password"));
		verticalMenu.navigatetoContract();
		String contractNumber = singleContract.singleContract();
		Thread.sleep(2000);
		utils.scrollDown();
		login.logout();
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
		Assert.assertTrue(getElementInFirstGrid("Contract Number").isDisplayed());
		getElementInFirstGrid("Contract Number").sendKeys(contractNumber);
		Assert.assertTrue(getArrowForwardBtn().isDisplayed());
		getArrowForwardBtn().click();
		Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		String ContractNumberInGrid = allTableData.get(1).get("Contract Number");
		Assert.assertTrue(ContractNumberInGrid.equals(contractNumber),"Contract Number Records are matching");
	}
	
	@Test(priority = 15)
	public void verifySearchForContractHolderLastName_27346() throws InterruptedException{
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
		Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
		String contractHolderLastName = prop.getProperty("lastName");
		getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
		Assert.assertTrue(getArrowForwardBtn().isDisplayed());
		getArrowForwardBtn().click();
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
		Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
	}
	
	@Test(priority = 16)
	public void verifyLastNameIvalidMsg_27363() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
        getElementInFirstGrid("Contract Holder Last Name").isDisplayed();
		getElementInFirstGrid("Contract Holder Last Name").sendKeys("a");
		getArrowForwardBtn().click();
		Assert.assertTrue(getInvalidLastNametxt().isDisplayed());
		String expectedRedColorInHexa = prop.getProperty("redColorInHexaForm");
		String txtColour = getInvalidLastNametxt().getCssValue("color");
		String ActualcolorInHexaformat = Color.fromString(txtColour).asHex();
		Assert.assertEquals(ActualcolorInHexaformat, expectedRedColorInHexa);
	}
	
	@Test(priority = 17)
	public void verifySearchCriteriaForVIN_27364() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
		String VIN=prop.getProperty("VIN");
		getElementInFirstGrid("Last 6 of VIN").sendKeys(VIN);
		Assert.assertTrue(getArrowForwardBtn().isDisplayed());
		getArrowForwardBtn().click();
		Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		String ContractHolderLastNameGrid = allTableData.get(1).get("VIN");
		Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(VIN),"VIN Records are matching");
	}
	
	@Test(priority = 18)
	public void verifyMaxLengthContractNumber_27368() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
	    String ContractNumWith16Characters=webcontracts.getXMLData("contractNumber");
	    getElementInFirstGrid("Contract Number").sendKeys(ContractNumWith16Characters);
		getElementInFirstGrid("Contract Number").sendKeys(webcontracts.getXMLData("code"));
		String MaxtLengthforContractNum = getElementInFirstGrid("Contract Number").getAttribute("maxlength");
		Assert.assertEquals(MaxtLengthforContractNum, webcontracts.getXMLData("maxlength"));
	}
	
	@Test(priority = 19)
	public void verifyMaxLengtLastName_27370() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
	    String LastNameWith64Characters=webcontracts.getXMLData("lastNemWith64Chars");
	    getElementInFirstGrid("Contract Holder Last Name").sendKeys(LastNameWith64Characters);
		getElementInFirstGrid("Contract Holder Last Name").sendKeys(webcontracts.getXMLData("code"));
		String MaxtLengthforContractNum = getElementInFirstGrid("Contract Holder Last Name").getAttribute("maxlength");
		Assert.assertEquals(MaxtLengthforContractNum, webcontracts.getXMLData("maxlength64"));
	}
	
	@Test(priority = 20)
	public void verifyMaxMinLengthForVIN_27374() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
	    String VINWith6Characters=webcontracts.getXMLData("vin");
	    System.out.println("VIN is-"+VINWith6Characters);
	    getElementInFirstGrid("Last 6 of VIN").sendKeys(VINWith6Characters);
	    getArrowForwardBtn().click();
	    Thread.sleep(10000);
	    getElementInFirstGrid("Last 6 of VIN").sendKeys(Keys.BACK_SPACE);
	    getArrowForwardBtn().click();
	    Thread.sleep(30000);
	    String expectedRedColorInHexa = prop.getProperty("redColorInHexaForm");
	    Assert.assertTrue(getInvalidVINtxt().isDisplayed());
	    String borderColorOfElement = getInvalidVINtxt().getCssValue("color");
		String ActualcolorInHexaformat = Color.fromString(borderColorOfElement).asHex();
		Assert.assertEquals(ActualcolorInHexaformat, expectedRedColorInHexa);
		getElementInFirstGrid("Last 6 of VIN").sendKeys(webcontracts.getXMLData("randomNO"));
		String MaxtLengthforContractNum = getElementInFirstGrid("Last 6 of VIN").getAttribute("maxlength");
	    Assert.assertEquals(MaxtLengthforContractNum, webcontracts.getXMLData("maxlengthVIN"));
	}
	
	//invalid testcase-manual teststep written wrong
//	@Test(priority = 21)
//	public void verifyMaxMinLengthForDealerID_27375() throws InterruptedException {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
//		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
//	    String DealerIDWith9Characters="123456789";
//	    getElementInFirstGrid("Dealer ID").sendKeys(DealerIDWith9Characters);
//	    getArrowForwardBtn().click();
//	    Thread.sleep(1000);
//	    getElementInFirstGrid("Dealer ID").sendKeys(Keys.BACK_SPACE);
//	    getArrowForwardBtn().click();
//	    
//	    String expectedRedColorInHexa = prop.getProperty("redColorInHexaForm");
//	    Assert.assertTrue(getInvalidVINtxt().isDisplayed());
//	    String borderColorOfElement = getInvalidVINtxt().getCssValue("color");
//		String ActualcolorInHexaformat = Color.fromString(borderColorOfElement).asHex();
//		Assert.assertEquals(ActualcolorInHexaformat, expectedRedColorInHexa);
//	    
//		getElementInFirstGrid("Dealer ID").sendKeys("123");
//		String MaxtLengthforContractNum = getElementInFirstGrid("Dealer ID").getAttribute("maxlength");
//	    Assert.assertEquals(MaxtLengthforContractNum, "16");
//	}

	@Test(priority = 21)
	public void verifyNoRecordsMsg_27375() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
	    String invalidContractNum=webcontracts.getXMLData("invalidContractNum");
	    getElementInFirstGrid("Contract Number").sendKeys(invalidContractNum);
	    getArrowForwardBtn().click();
	    Thread.sleep(1000);
	    Assert.assertTrue(getNoRecordstxt().isDisplayed());
	}

	@Test(priority = 22)
	public void verifyInvalidVIN_27381() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
		getElementInFirstGrid("Last 6 of VIN").sendKeys( webcontracts.getXMLData("randomNO"));
	    getArrowForwardBtn().click();
	    Thread.sleep(1000);
	    String expectedRedColorInHexa = prop.getProperty("redColorInHexaForm");
	    Assert.assertTrue(getInvalidVINtxt().isDisplayed());
	    String borderColorOfElement = getInvalidVINtxt().getCssValue("color");
		String ActualcolorInHexaformat = Color.fromString(borderColorOfElement).asHex();
		Assert.assertEquals(ActualcolorInHexaformat, expectedRedColorInHexa);
	}
	
	//hold
	@Test(priority = 23)
	public void verifyTypeOfFeildTableColoumns_27425() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
		getElementInFirstGrid("Dealer ID").sendKeys(prop.getProperty("roleid"));
		getArrowForwardBtn().click();
		Thread.sleep(2000);
		Assert.assertTrue(getContractsGrid().isDisplayed());
	}
	
		@Test(priority = 24)
		public void verifyDealerIDInputWithSearch_27522() throws Exception {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			String roleid = getWebContractsAllTableDataFromDB().get(1).get("DEALER_ID");
			String VIN = getWebContractsAllTableDataFromDB().get(1).get("VIN");
			String newVIN = VIN.substring(11);
		    getElementInFirstGrid("Dealer ID").sendKeys(roleid);
		    getElementInFirstGrid("Last 6 of VIN").sendKeys(newVIN);
		    getArrowForwardBtn().click();
		    Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
		    Thread.sleep(2000);
		    HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String VINinGrid = allTableData.get(1).get("VIN");
			Assert.assertTrue(VINinGrid.equals(newVIN),"Records are matching");
		}
		
		@Test(priority = 25)
		public void verifyInvalidVIN_27537() throws InterruptedException {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			String invalidVIN =  webcontracts.getXMLData("invalidVIN");
			getElementInFirstGrid("Last 6 of VIN").sendKeys(invalidVIN);
			getArrowForwardBtn().click();
		    Thread.sleep(1000);
		    Assert.assertTrue(getNoRecordstxt().isDisplayed());
		}
		
		@Test(priority = 26)
		public void verifyMsgWhenNoDataEntered_27540() throws InterruptedException {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			getArrowForwardBtn().click();
			Assert.assertTrue(getAtleastOneRecordtxt().isDisplayed());
			String expectedRedColorInHexa = prop.getProperty("redColorInHexaForm");
			String colorOfElement = getAtleastOneRecordtxt().getCssValue("color");
			String ActualcolorInHexaformat = Color.fromString(colorOfElement).asHex();
			Assert.assertEquals(ActualcolorInHexaformat, expectedRedColorInHexa);
		}
		
		@Test(priority = 27)
		public void verifyVINContractNumbSearch_27563() throws Exception {
			login.login(prop.getProperty("dealerAutomation"),prop.getProperty("password"));
			verticalMenu.navigatetoContract();
			String contractNumber = singleContract.singleContract();
			Thread.sleep(1000);
			login.logout();
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Number").isDisplayed());
			getElementInFirstGrid("Contract Number").sendKeys(contractNumber);
			Assert.assertTrue(getElementInFirstGrid("Last 6 of VIN").isDisplayed());
			String last6digitsOfVINEntered = webcontracts.getXMLData("vin3");
			getElementInFirstGrid("Last 6 of VIN").sendKeys(last6digitsOfVINEntered);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(2000);
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractNumberInGrid = allTableData.get(1).get("Contract Number");
			Assert.assertTrue(ContractNumberInGrid.equals(contractNumber),"Contract Number Records are matching");
			String VINinGrid = allTableData.get(1).get("VIN");
			Assert.assertTrue(VINinGrid.equalsIgnoreCase(last6digitsOfVINEntered),"VIN Records are matching");
		}
		

		@Test(priority = 28)
		public void verifyVINDealerIDSearch_27564() throws Exception {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			String roleid = getWebContractsAllTableDataFromDB().get(1).get("DEALER_ID");
			String VIN = getWebContractsAllTableDataFromDB().get(1).get("VIN");
			String newVIN = VIN.substring(11);
		    getElementInFirstGrid("Dealer ID").sendKeys(roleid);
		    getElementInFirstGrid("Last 6 of VIN").sendKeys(newVIN);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(2000);
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String VINinGrid = allTableData.get(1).get("VIN");
			Assert.assertTrue(VINinGrid.equalsIgnoreCase(newVIN),"Records are matching");
		}
		
		
		@Test(priority = 29)
		public void verifyConfirmationMsgWhenEnteredStatus_27566() throws Exception {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			String enteredStatus=webcontracts.getXMLData("statusEntered");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String contractHolderLastName = getDataFromDB(enteredStatus).get(1).get("LAST_NAME");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			//Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(10000);
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
			Assert.assertTrue(getContractsGrid().isDisplayed());
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String status = allTableData.get(i).get("Status");
				  if(status.equals(enteredStatus))
				  {
					  String contractNum= allTableData.get(i).get("Contract Number");
				      getEditRestorBtns(i).click();
					  Thread.sleep(2000);
					  Assert.assertEquals(getEditConfirmationMsg().getText(),"The contract " + contractNum + " is currently Entered. Do you want to change it to Quote?");
					  Assert.assertTrue(getConfirmationYesBtn().isDisplayed());
					  Assert.assertTrue(getConfirmationNoBtn().isDisplayed());
					  Assert.assertTrue(getIconClose().isDisplayed());
					  getIconClose().click();
					  break;
					}
			}
		}
		
		
		@Test(priority = 30)
		public void verifyNotificationMsg_27570() throws Exception {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String statusDeleted=  webcontracts.getXMLData("statusDeleted");
			String contractHolderLastName = getDataFromDB(statusDeleted).get(1).get("LAST_NAME");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(10000);
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
			Assert.assertTrue(getContractsGrid().isDisplayed());
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String status = allTableData.get(i).get("Status");
				  if(status.equals(statusDeleted))
				  {
					  String contractNum= allTableData.get(i).get("Contract Number");
					  System.out.println(allTableData.get(i).get("Contract Number"));
				      getEditRestorBtns(i).click();
					  Thread.sleep(2000);
					  Assert.assertEquals(getRestoreContractMsg().getText(),"Are you sure you want to restore contract " + contractNum + " ?" );
					  Assert.assertTrue(getConfirmationYesBtn().isDisplayed());
					  Assert.assertTrue(getConfirmationNoBtn().isDisplayed());
					  Assert.assertTrue(getIconClose().isDisplayed());
					  getIconClose().click();
					}
			}
			}
		
		@Test(priority = 31)
		public void verifyVINLastNameSearchCriteria_27581() throws Exception {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			
			Assert.assertTrue(getElementInFirstGrid("Last 6 of VIN").isDisplayed());
			String VIN = getWebContractsAllTableDataFromDB().get(1).get("VIN");
			String newVIN = VIN.substring(11);
			getElementInFirstGrid("Last 6 of VIN").sendKeys(newVIN);
			
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String contractHolderLastName = getWebContractsAllTableDataFromDB().get(1).get("LAST_NAME");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(2000);
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String VINinGrid = allTableData.get(1).get("VIN");
			Assert.assertTrue(VINinGrid.equals(newVIN),"VIN Records are matching");
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
		}
		
		@Test(priority = 32)
		public void verifyContractNumDealerIDSearch_27583() throws InterruptedException {
			login.login(prop.getProperty("dealerAutomation"),prop.getProperty("password"));
			verticalMenu.navigatetoContract();
			String contractNumber = singleContract.singleContract();
			Thread.sleep(2000);
			utils.scrollDown();
			login.logout();
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Number").isDisplayed());
			getElementInFirstGrid("Contract Number").sendKeys(contractNumber);
			Assert.assertTrue(getElementInFirstGrid("Dealer ID").isDisplayed());
			String dealerID=prop.getProperty("roleid");
			getElementInFirstGrid("Dealer ID").sendKeys(dealerID);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Thread.sleep(2000);
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String contractNumberInGrid = allTableData.get(1).get("Contract Number");
			Assert.assertTrue(contractNumberInGrid.equalsIgnoreCase(contractNumber),"Records are matching");
		}
		
		@Test(priority = 33)
		public void verifyDealerIdLastNameSearchCriteria_27584() throws InterruptedException {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			
			Assert.assertTrue(getElementInFirstGrid("Dealer ID").isDisplayed());
			String dealerID=prop.getProperty("roleid");
			getElementInFirstGrid("Dealer ID").sendKeys(dealerID);
			
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String contractHolderLastName = prop.getProperty("lastName");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(2000);
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Records are matching");
		}
		
		@Test(priority = 34)
		public void verifyContractNotRestoredAfterXIcon_27587() throws Exception {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String statusDeleted=  webcontracts.getXMLData("statusDeleted");
			String contractHolderLastName = getDataFromDB(statusDeleted).get(1).get("LAST_NAME");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Assert.assertTrue(getContractsGrid().isDisplayed());
		    Thread.sleep(5000);
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
			String contractNum1 = null;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String status = allTableData.get(i).get("Status");
				  if(status.equals(statusDeleted))
				  {
					  contractNum1 = allTableData.get(i).get("Contract Number");
					  getEditRestorBtns(i).click();
					  Thread.sleep(2000);
					  Assert.assertTrue(getRestoreContractMsg().isDisplayed());
					  getIconClose().click();
					  break;
					}
				
			}
			Assert.assertTrue(getContractsGrid().isDisplayed(),"Confirmation model closed and redirected to grid");
			HashMap<Integer, HashMap<String, String>> allTableData2 = checkGridBodyDetails();
			String contractNum2 = null;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				contractNum2 = allTableData2.get(i).get("Contract Number");
				if(contractNum2.equalsIgnoreCase(contractNum1))
				{
					Assert.assertEquals(allTableData2.get(i).get("Status"), statusDeleted,"Contract is not restored");
				}
			}
		}
		
		@Test(priority = 35)
		public void verifyContractNotRestoredAfterNoBtn_27588() throws Exception {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String statusDeleted=  webcontracts.getXMLData("statusDeleted");
			String contractHolderLastName = getDataFromDB(statusDeleted).get(1).get("LAST_NAME");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(5000);
			Assert.assertTrue(getContractsGrid().isDisplayed());
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
			String contractNum1 = null;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String status = allTableData.get(i).get("Status");
				  if(status.equals(statusDeleted))
				  {
					  contractNum1 = allTableData.get(i).get("Contract Number");
				      getEditRestorBtns(i).click();
					  Thread.sleep(2000);
					  Assert.assertTrue(getRestoreContractMsg().isDisplayed());
					  getConfirmationNoBtn().click();
					  break;
				  }
			}
			Assert.assertTrue(getContractsGrid().isDisplayed(),"Confirmation model closed and redirected to grid");
			HashMap<Integer, HashMap<String, String>> allTableData2 = checkGridBodyDetails();
			String contractNum2 = null;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				contractNum2 = allTableData2.get(i).get("Contract Number");
				if(contractNum2.equalsIgnoreCase(contractNum1))
				{
					Assert.assertEquals(allTableData2.get(i).get("Status"), statusDeleted,"record is not restored");
				}
			}
		}
		
		@Test(priority = 36)
		public void verifyContractNotRestoredAfterEscBtn_27589() throws Exception  {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String statusDeleted=  webcontracts.getXMLData("statusDeleted");
			String contractHolderLastName = getDataFromDB(statusDeleted).get(1).get("LAST_NAME");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(5000);
			Assert.assertTrue(getContractsGrid().isDisplayed());
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
			String contractNum1 = null;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String status = allTableData.get(i).get("Status");
				  if(status.equals(statusDeleted))
				  {
					  contractNum1 = allTableData.get(i).get("Contract Number");
				      getEditRestorBtns(i).click();
					  Thread.sleep(2000);
					  Assert.assertTrue(getRestoreContractMsg().isDisplayed());
					  Actions action = new Actions(driver);
					  action.sendKeys(Keys.ESCAPE).perform();
					  break;
				  }
			}
			Thread.sleep(2000);
			Assert.assertTrue(getContractsGrid().isDisplayed(),"Confirmation model closed and redirected to grid");
			HashMap<Integer, HashMap<String, String>> allTableData2 = checkGridBodyDetails();
			String contractNum2 = null;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				contractNum2 = allTableData2.get(i).get("Contract Number");
				if(contractNum2.equalsIgnoreCase(contractNum1))
				{
					Assert.assertEquals(allTableData2.get(i).get("Status"), statusDeleted,"Contract is not restored");
				}
			}
		}
		
		@Test(priority = 37)
		public void verifyRestoreIconEnabled_27591() throws Exception  {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String statusDeleted=  webcontracts.getXMLData("statusDeleted");
			String contractHolderLastName = getDataFromDB(statusDeleted).get(1).get("LAST_NAME");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(5000);
			Assert.assertTrue(getContractsGrid().isDisplayed());
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String status = allTableData.get(i).get("Status");
				  if(status.equals(statusDeleted))
				  {
					  Assert.assertTrue(getEditRestorBtns(i).isEnabled());
				  }
			}
			
		}
		
		@Test(priority = 38)
		public void verifyRestoreIconStatus_27592() throws Exception  {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String statusDeleted=  webcontracts.getXMLData("statusDeleted");
			String contractHolderLastName = getDataFromDB(statusDeleted).get(1).get("LAST_NAME");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(5000);
			Assert.assertTrue(getContractsGrid().isDisplayed());
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String status = allTableData.get(i).get("Status");
				  if(status.equals(statusDeleted))
				  {
					  getEditRestorBtns(i).isEnabled();
					  Assert.assertEquals(allTableData.get(i).get("Status"),statusDeleted);
				  }
			}
			
		}
		
//BUG
//		@Test(priority = 39)
//		public void verifyContractRestoredAfterYesBtn_27594() throws Exception {
//			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
//			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
//			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
//			String contractHolderLastName = getDataFromDB("DELETED").get(1).get("LAST_NAME");
//			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
//			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
//			getArrowForwardBtn().click();
//			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
//			Thread.sleep(5000);
//			Assert.assertTrue(getContractsGrid().isDisplayed());
//			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
//			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
//			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
//			String contractNum1 = null;
//			for (int i = 1; i <= getRowLoc().size(); i++) {
//				String status = allTableData.get(i).get("Status");
//				  if(status.equals("DELETED"))
//				  {
//					  contractNum1 = allTableData.get(i).get("Contract Number");
//				      getEditRestorBtns(i).click();
//					  Thread.sleep(2000);
//					  Assert.assertTrue(getRestoreContractMsg().isDisplayed());
//					  getConfirmationYesBtn().click();
//					  Thread.sleep(3000);
//					  break;
//				  }
//			}
//			Assert.assertTrue(getContractsGrid().isDisplayed(),"Confirmation model closed and redirected to grid");
//			HashMap<Integer, HashMap<String, String>> allTableData2 = checkGridBodyDetails();
//			String contractNum2 = null;
//			for (int i = 1; i <= getRowLoc().size(); i++) {
//				contractNum2 = allTableData2.get(i).get("Contract Number");
//				if(contractNum2.equalsIgnoreCase(contractNum1))
//				{
//					Assert.assertEquals(allTableData2.get(i).get("Status"), "ENTERED","Contract is restored and Status is Entered");
//				}
//			}
//			
//		}
		
		//BUG
//		@Test(priority = 40)
//		public void verifyStatusFromDeletedToEntered_27599() throws Exception {
//			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
//			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
//			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
//			String contractHolderLastName = getDataFromDB("DELETED").get(1).get("LAST_NAME");
//			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
//			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
//			getArrowForwardBtn().click();
//			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
//			Thread.sleep(5000);
//			Assert.assertTrue(getContractsGrid().isDisplayed());
//			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
//			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
//			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
//			String contractNum1 = null;
//			for (int i = 1; i <= getRowLoc().size(); i++) {
//				String status = allTableData.get(i).get("Status");
//				  if(status.equals("DELETED"))
//				  {
//					  contractNum1 = allTableData.get(i).get("Contract Number");
//				      getEditRestorBtns(i).click();
//					  Thread.sleep(2000);
//					  Assert.assertTrue(getRestoreContractMsg().isDisplayed());
//					  getConfirmationYesBtn().click();
//					  Thread.sleep(3000);
//					  break;
//				  }
//			}
//			Assert.assertTrue(getContractsGrid().isDisplayed(),"Confirmation model closed and redirected to grid");
//			HashMap<Integer, HashMap<String, String>> allTableData2 = checkGridBodyDetails();
//			String contractNum2 = null;
//			for (int i = 1; i <= getRowLoc().size(); i++) {
//				contractNum2 = allTableData2.get(i).get("Contract Number");
//				if(contractNum2.equalsIgnoreCase(contractNum1))
//				{
//					Assert.assertEquals(allTableData2.get(i).get("Status"), "ENTERED","Contract is restored and Status is Entered");
//				}
//			}
//			
//		}
		
		@Test(priority = 41)
		public void verifyConfirmationMsgWhenQuoteStatus_27619() throws Exception {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String contractHolderLastName = getDataFromDB("QUOTE").get(1).get("LAST_NAME");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(10000);
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
			Assert.assertTrue(getContractsGrid().isDisplayed());
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String status = allTableData.get(i).get("Status");
				  if(status.equals("QUOTE"))
				  {
					 String contractNum= allTableData.get(i).get("Contract Number");
				      getEditRestorBtns(i).click();
					  Thread.sleep(2000);
					  Assert.assertEquals(getEditConfirmationMsg().getText(),"The contract " + contractNum + " is currently Quote. Do you want to change it to Entered?");
					  Assert.assertTrue(getConfirmationYesBtn().isDisplayed());
					  Assert.assertTrue(getConfirmationNoBtn().isDisplayed());
					  Assert.assertTrue(getIconClose().isDisplayed());
					  getIconClose().click();
					  break;
					}
			}
		}
		
		
		@Test(priority = 42)
		public void verifyConfirmationMsgWhenRemittedStatus_27620() throws Exception {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String contractHolderLastName = getDataFromDB("REMITTED").get(1).get("LAST_NAME");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(10000);
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
			Assert.assertTrue(getContractsGrid().isDisplayed());
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String status = allTableData.get(i).get("Status");
				  if(status.equals("REMITTED"))
				  {
					 String contractNum= allTableData.get(i).get("Contract Number");
				      getEditRestorBtns(i).click();
					  Thread.sleep(2000);
					  Assert.assertEquals(getEditConfirmationMsg().getText(),"The contract " + contractNum + " is currently Remitted. Do you want to change it to Entered?");
					  Assert.assertTrue(getConfirmationYesBtn().isDisplayed());
					  Assert.assertTrue(getConfirmationNoBtn().isDisplayed());
					  Assert.assertTrue(getIconClose().isDisplayed());
					  getIconClose().click();
					  break;
					}
			}
		}
		
		@Test(priority = 43)
		public void verifyStatusNotChangedAfterNoBtn_27718() throws Exception {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String statusDeleted=  webcontracts.getXMLData("statusDeleted");
			String contractHolderLastName = getDataFromDB(statusDeleted).get(1).get("LAST_NAME");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(5000);
			Assert.assertTrue(getContractsGrid().isDisplayed());
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
			String contractNum1 = null;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String status = allTableData.get(i).get("Status");
				  if(status.equals(statusDeleted))
				  {
					  contractNum1 = allTableData.get(i).get("Contract Number");
				      getEditRestorBtns(i).click();
					  Thread.sleep(2000);
					  Assert.assertTrue(getRestoreContractMsg().isDisplayed());
					  getConfirmationNoBtn().click();
					  break;
				  }
			}
			Assert.assertTrue(getContractsGrid().isDisplayed(),"Confirmation model closed and redirected to grid");
			HashMap<Integer, HashMap<String, String>> allTableData2 = checkGridBodyDetails();
			String contractNum2 = null;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				contractNum2 = allTableData2.get(i).get("Contract Number");
				if(contractNum2.equalsIgnoreCase(contractNum1))
				{
					Assert.assertEquals(allTableData2.get(i).get("Status"), statusDeleted,"record is same and Contract not changed its status");
				}
			}
		}
		
		@Test(priority = 44)
		public void verifyStatusNotChangedAfterEscBtn_27720() throws Exception  {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String statusDeleted=  webcontracts.getXMLData("statusDeleted");
			String contractHolderLastName = getDataFromDB(statusDeleted).get(1).get("LAST_NAME");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(5000);
			Assert.assertTrue(getContractsGrid().isDisplayed());
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
			String contractNum1 = null;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String status = allTableData.get(i).get("Status");
				  if(status.equals(statusDeleted))
				  {
					  contractNum1 = allTableData.get(i).get("Contract Number");
				      getEditRestorBtns(i).click();
					  Thread.sleep(2000);
					  Assert.assertTrue(getRestoreContractMsg().isDisplayed());
					  Actions action = new Actions(driver);
					  action.sendKeys(Keys.ESCAPE).perform();
					  break;
				  }
			}
			Thread.sleep(2000);
			Assert.assertTrue(getContractsGrid().isDisplayed(),"Confirmation model closed and redirected to grid");
			HashMap<Integer, HashMap<String, String>> allTableData2 = checkGridBodyDetails();
			String contractNum2 = null;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				contractNum2 = allTableData2.get(i).get("Contract Number");
				if(contractNum2.equalsIgnoreCase(contractNum1))
				{
					Assert.assertEquals(allTableData2.get(i).get("Status"), statusDeleted,"record is same and Contract not changed its status");
				}
			}
		}
		
		@Test(priority = 45)
		public void verifyStatusNotChangedAfterXIcon_27722() throws Exception  {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String statusDeleted=  webcontracts.getXMLData("statusDeleted");
			String contractHolderLastName = getDataFromDB(statusDeleted).get(1).get("LAST_NAME");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(5000);
			Assert.assertTrue(getContractsGrid().isDisplayed());
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
			String contractNum1 = null;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String status = allTableData.get(i).get("Status");
				  if(status.equals(statusDeleted))
				  {
					  contractNum1 = allTableData.get(i).get("Contract Number");
				      getEditRestorBtns(i).click();
					  Thread.sleep(2000);
					  Assert.assertTrue(getRestoreContractMsg().isDisplayed());
					  getIconClose().click();
					  break;
				  }
			}
			Thread.sleep(2000);
			Assert.assertTrue(getContractsGrid().isDisplayed(),"Confirmation model closed and redirected to grid");
			HashMap<Integer, HashMap<String, String>> allTableData2 = checkGridBodyDetails();
			String contractNum2 = null;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				contractNum2 = allTableData2.get(i).get("Contract Number");
				if(contractNum2.equalsIgnoreCase(contractNum1))
				{
					Assert.assertEquals(allTableData2.get(i).get("Status"), statusDeleted,"record is same and Contract not changed its status");
				}
			}
		}
		
		@Test(priority = 46)
		public void verifyChangeInStatusAfterYesBtn_27715() throws Exception {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
			String contractHolderLastName = getDataFromDB("ENTERED").get(1).get("LAST_NAME");
			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
			getArrowForwardBtn().click();
			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
			Thread.sleep(5000);
			Assert.assertTrue(getContractsGrid().isDisplayed());
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
			String contractNum1 = null;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String status = allTableData.get(i).get("Status");
				  if(status.equals("ENTERED"))
				  {
					  contractNum1 = allTableData.get(i).get("Contract Number");
				      getEditRestorBtns(i).click();
					  Thread.sleep(2000);
					  Assert.assertTrue(getEditConfirmationMsg().isDisplayed());
					  getConfirmationYesBtn().click();
					  Thread.sleep(3000);
					  break;
				  }
			}
			Assert.assertTrue(getContractsGrid().isDisplayed(),"Confirmation model closed and redirected to grid");
			HashMap<Integer, HashMap<String, String>> allTableDataAftrAction = checkGridBodyDetails();
			HashMap<Integer, HashMap<String, WebElement>> elementData = getElementsFromGridBody();
			String contractNum2 = null;
			for (int i = 1; i <= getRowLoc().size(); i++) {
				contractNum2 = allTableDataAftrAction.get(i).get("Contract Number");
				if(contractNum2.equalsIgnoreCase(contractNum1))
				{
					Assert.assertEquals(allTableDataAftrAction.get(i).get("Status"), "QUOTE","Contract has changed its status");
					String elementColor = elementData.get(i).get("Status").getCssValue("background-color");
					String ActualcolorInHexaformat = Color.fromString(elementColor).asHex();
					String expectedRedColorInHexa = prop.getProperty("yellowColorInHexaForm");
					Assert.assertEquals(ActualcolorInHexaformat, expectedRedColorInHexa);
				}
			}
			
		}
		
		//BUG
//		@Test(priority = 47)
//		public void verifyRestoreIconWhenChangedToEntered_27822() throws Exception {
//			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
//			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
//			Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
//			String contractHolderLastName = getDataFromDB("DELETED").get(1).get("LAST_NAME");
//			getElementInFirstGrid("Contract Holder Last Name").sendKeys(contractHolderLastName);
//			Assert.assertTrue(getArrowForwardBtn().isDisplayed());
//			getArrowForwardBtn().click();
//			Assert.assertTrue(getSpinner().isDisplayed(),"Spinner is displayed");
//			Thread.sleep(7000);
//			Assert.assertTrue(getContractsGrid().isDisplayed());
//			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
//			String ContractHolderLastNameGrid = allTableData.get(1).get("Last Name");
//			Assert.assertTrue(ContractHolderLastNameGrid.equalsIgnoreCase(contractHolderLastName),"Contract Holder Last Name Records are matching");
//			String contractNum1 = null;
//			for (int i = 1; i <= getRowLoc().size(); i++) {
//				String status = allTableData.get(i).get("Status");
//				  if(status.equals("DELETED"))
//				  {
//					  contractNum1 = allTableData.get(i).get("Contract Number");
//					  System.out.println("Restore Icon text is :"+getEditRestoreElementsVisibility(i).get(0).getAttribute("mattooltip"));
//					  Assert.assertEquals(getEditRestoreElementsVisibility(i).get(0).getAttribute("mattooltip"),"Restore Contract");
//					  getEditRestorBtns(i).click();
//					  Thread.sleep(3000);
//					  Assert.assertTrue(getRestoreContractMsg().isDisplayed());
//					  getConfirmationYesBtn().click();
//					  Thread.sleep(3000);
//					  break;
//				  }
//			}
//			Assert.assertTrue(getContractsGrid().isDisplayed(),"Confirmation model closed and redirected to grid");
//			HashMap<Integer, HashMap<String, String>> allTableData2 = checkGridBodyDetails();
//			String contractNum2 = null;
//			for (int i = 1; i <= getRowLoc().size(); i++) {
//				contractNum2 = allTableData2.get(i).get("Contract Number");
//				if(contractNum2.equalsIgnoreCase(contractNum1))
//				{
//					System.out.println("Status--"+allTableData2.get(i).get("Status"));
//					Assert.assertEquals(allTableData2.get(i).get("Status"), "ENTERED","Contract is restored and Status is Entered");
//					System.out.println("Restore Icon text after clicking on Yes btn changed to:"+getEditRestoreElementsVisibility(i).get(1).getAttribute("mattooltip"));
//					Assert.assertEquals(getEditRestoreElementsVisibility(i).get(1).getAttribute("mattooltip"), "Edit Status");
//					break;
//				}
//			}
//		}
//		
		@Test(priority = 48)
		public void verifySortingColoumns_27338() throws Exception {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
			Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
			String dealer = getDealerFromDB().get(1).get("DEALER_ID");
			getElementInFirstGrid("Dealer ID").sendKeys(dealer);
			getArrowForwardBtn().click();
			Thread.sleep(3000);
			getContractsGrid().isDisplayed();
			
			getGridArrowBtn("Last Name").click();
			HashMap<Integer, HashMap<String, String>> allTableDataForLastName = checkGridBodyDetails();
			ArrayList<String> obtainedListLastName = new ArrayList<String>();
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String lastName = allTableDataForLastName.get(i).get("Last Name");
				obtainedListLastName.add(lastName);
			}
			ArrayList<String> LastNameListBeforeSort = obtainedListLastName;
			System.out.println(LastNameListBeforeSort);
			Collections.sort(obtainedListLastName);
			System.out.println(obtainedListLastName);
			Assert.assertEquals(LastNameListBeforeSort,obtainedListLastName);
			
			getGridArrowBtn("Last Name").click();
			HashMap<Integer, HashMap<String, String>> allTableDataForLastNameOnArrowClick2 = checkGridBodyDetails();
			ArrayList<String> obtainedListLastNameOnArrowClick2 = new ArrayList<String>();
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String lastName = allTableDataForLastNameOnArrowClick2.get(i).get("Last Name");
				obtainedListLastNameOnArrowClick2.add(lastName);
			}
			System.out.println(obtainedListLastNameOnArrowClick2);
			Collections.reverse(obtainedListLastName);
			System.out.println(obtainedListLastName);
			Assert.assertTrue(obtainedListLastNameOnArrowClick2.equals(obtainedListLastName));
			
			
			getGridArrowBtn("VIN").click();
			HashMap<Integer, HashMap<String, String>> allTableDataForVIN = checkGridBodyDetails();;
			ArrayList<String> obtainedListVIN = new ArrayList<String>();
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String VIN = allTableDataForVIN.get(i).get("VIN");
				obtainedListVIN.add(VIN);
			}
			ArrayList<String> VINListBeforeSort = obtainedListVIN;
			System.out.println(VINListBeforeSort);
			Collections.sort(obtainedListVIN);
			System.out.println(obtainedListVIN);
			Assert.assertEquals(VINListBeforeSort,obtainedListVIN);
			
			
			getGridArrowBtn("VIN").click();
			HashMap<Integer, HashMap<String, String>> allTableDataForVINOnArrowClick2 = checkGridBodyDetails();
			ArrayList<String> obtainedListVINOnArrowClick2 = new ArrayList<String>();
			for (int i = 1; i <= getRowLoc().size(); i++) {
				String VIN = allTableDataForVINOnArrowClick2.get(i).get("VIN");
				obtainedListVINOnArrowClick2.add(VIN);
			}
			System.out.println(obtainedListVINOnArrowClick2);
			Collections.reverse(obtainedListVIN);
			System.out.println(obtainedListVIN);
			Assert.assertEquals(obtainedListVINOnArrowClick2,obtainedListVIN);
		}
		
		@Test(priority = 49)
		public void verifyColorLabels_27328() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoLeftMenu("Report", "Web Contracts by Dealer");
		Assert.assertEquals(getTitle(), webcontracts.getXMLData("webcontractsTitle"));
		Assert.assertTrue(getElementInFirstGrid("Contract Holder Last Name").isDisplayed());
		String statusDeleted=  webcontracts.getXMLData("statusDeleted");
		String statusEntered=  webcontracts.getXMLData("statusEntered");
		String statusQuote=  webcontracts.getXMLData("statusQuote");
		String statusRemitted=  webcontracts.getXMLData("statusremitted");
		String statusProcessed=  webcontracts.getXMLData("statusProcessed");
		String lastNameForDeleted = getDataFromDB(statusDeleted).get(1).get("LAST_NAME");
		getElementInFirstGrid("Contract Holder Last Name").sendKeys(lastNameForDeleted);
		getArrowForwardBtn().click();
		Thread.sleep(5000);
		Assert.assertTrue(getContractsGrid().isDisplayed());
		 HashMap<Integer, HashMap<String, WebElement>> gridDataForDeletedStatus = getElementsFromGridBody();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String status = gridDataForDeletedStatus.get(i).get("Status").getText();
			  if(status.equals(statusDeleted))
			  {
					String elementColor = gridDataForDeletedStatus.get(i).get("Status").getCssValue("background-color");
					String ActualcolorInHexaformat = Color.fromString(elementColor).asHex();
					String expectedRedColorInHexa = prop.getProperty("pinkAndRedShadeInHexaform");
					Assert.assertEquals(ActualcolorInHexaformat, expectedRedColorInHexa);
					Assert.assertTrue(getEditRestoreElementsVisibility(i).get(0).isDisplayed());
					break;
			  }
		}
		
		getElementInFirstGrid("Contract Holder Last Name").clear();
		String lastNameForEntered = getDataFromDB(statusEntered).get(1).get("LAST_NAME");
		getElementInFirstGrid("Contract Holder Last Name").sendKeys(lastNameForEntered);
		getArrowForwardBtn().click();
		Thread.sleep(5000);
		 HashMap<Integer, HashMap<String, WebElement>> gridDataForEnteredStatus = getElementsFromGridBody();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String status = gridDataForEnteredStatus.get(i).get("Status").getText();
			  if(status.equals(statusEntered))
			  {
					String elementColor = gridDataForEnteredStatus.get(i).get("Status").getCssValue("background-color");
					String ActualcolorInHexaformat = Color.fromString(elementColor).asHex();
					String expectedRedColorInHexa = prop.getProperty("yellowColorInHexaForm");
					Assert.assertEquals(ActualcolorInHexaformat, expectedRedColorInHexa);
					Assert.assertTrue(getEditRestoreElementsVisibility(i).get(1).isDisplayed());
					break;
			  }
		}
		
		getElementInFirstGrid("Contract Holder Last Name").clear();
		String lastNameForQuote = getDataFromDB(statusQuote).get(1).get("LAST_NAME");
		getElementInFirstGrid("Contract Holder Last Name").sendKeys(lastNameForQuote);
		getArrowForwardBtn().click();
		Thread.sleep(5000);
		 HashMap<Integer, HashMap<String, WebElement>> gridDataForQuoteStatus = getElementsFromGridBody();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String status = gridDataForQuoteStatus.get(i).get("Status").getText();
			  if(status.equals(statusQuote))
			  {
					String elementColor = gridDataForQuoteStatus.get(i).get("Status").getCssValue("background-color");
					String ActualcolorInHexaformat = Color.fromString(elementColor).asHex();
					String expectedRedColorInHexa = prop.getProperty("yellowColorInHexaForm");
					Assert.assertEquals(ActualcolorInHexaformat, expectedRedColorInHexa);
					Assert.assertTrue(getEditRestoreElementsVisibility(i).get(1).isDisplayed());
					break;
			  }
		}
		
		getElementInFirstGrid("Contract Holder Last Name").clear();
		String lastNameForRemitted = getDataFromDB(statusRemitted).get(1).get("LAST_NAME");
		getElementInFirstGrid("Contract Holder Last Name").sendKeys(lastNameForRemitted);
		getArrowForwardBtn().click();
		Thread.sleep(5000);
		 HashMap<Integer, HashMap<String, WebElement>> gridDataForRemittedStatus = getElementsFromGridBody();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String status = gridDataForRemittedStatus.get(i).get("Status").getText();
			  if(status.equals(statusRemitted))
			  {
					String elementColor = gridDataForRemittedStatus.get(i).get("Status").getCssValue("background-color");
					String ActualcolorInHexaformat = Color.fromString(elementColor).asHex();
					String expectedRedColorInHexa = prop.getProperty("yellowColorInHexaForm");
					Assert.assertEquals(ActualcolorInHexaformat, expectedRedColorInHexa);
					Assert.assertTrue(getEditRestoreElementsVisibility(i).get(1).isDisplayed());
					break;
			  }
		}
		
		getElementInFirstGrid("Contract Holder Last Name").clear();
		String lastNameForProcessed = getDataFromDB(statusProcessed).get(1).get("LAST_NAME");
		getElementInFirstGrid("Contract Holder Last Name").sendKeys(lastNameForProcessed);
		getArrowForwardBtn().click();
		Thread.sleep(5000);
		 HashMap<Integer, HashMap<String, WebElement>> gridDataForProcessedStatus = getElementsFromGridBody();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String status = gridDataForProcessedStatus.get(i).get("Status").getText();
			  if(status.equals(statusProcessed))
			  {
					String elementColor = gridDataForProcessedStatus.get(i).get("Status").getCssValue("background-color");
					String ActualcolorInHexaformat = Color.fromString(elementColor).asHex();
					String expectedRedColorInHexa = prop.getProperty("lightBlueColorInHexaForm");
					Assert.assertEquals(ActualcolorInHexaformat, expectedRedColorInHexa);
					Assert.assertFalse(getEditRestoreElementsVisibility(i).get(0).isDisplayed());
					break;
			  }
		}
		}
		
		@AfterMethod(alwaysRun = true)
		public void close() throws InterruptedException {
			try {
			login.logout();
			}
			catch (Exception e){
				
			}
		}
}
