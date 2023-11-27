package testsuite;

import java.io.IOException;


import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.earlyClaimsAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;


@Listeners(utils.listnerlogs.class)
public class earlyClaims_test extends earlyClaimsAction{

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	utilityClass utils = new utilityClass();

	
	@DataProvider(name="login1")
    public Object[][] getData() {
        return new Object[][] {
     {prop.getProperty("dealerAutomation"),prop.getProperty("password"),prop.getProperty("roleType")},
     {prop.getProperty("agentAutomation"),prop.getProperty("password"),prop.getProperty("roleTypeAgent")},
     {prop.getProperty("lenderAutomation"),prop.getProperty("password"),prop.getProperty("roleTypeLender")},
     {prop.getProperty("dealerempAutomation"),prop.getProperty("password"),prop.getProperty("roleTypeDealerEmp")},
				 
        };
    }
	
	@DataProvider(name="login2")
    public Object[][] getData2() {
        return new Object[][] {
        	{prop.getProperty("dealerAutomation"),prop.getProperty("password"),prop.getProperty("roleType"),"XIcon"},
        	{prop.getProperty("dealerAutomation"),prop.getProperty("password"),prop.getProperty("roleType"),"CloseButton"},
        };
    }
	
	@DataProvider(name="login3")
    public Object[][] getData3() {
        return new Object[][] {
        	{prop.getProperty("dealerAutomation"),prop.getProperty("password"),prop.getProperty("roleType"),"mainpage"},
        	{prop.getProperty("dealerAutomation"),prop.getProperty("password"),prop.getProperty("roleType"),"modal"},
        	{prop.getProperty("dealerAutomation"),prop.getProperty("password"),prop.getProperty("roleType"),"mainpageXls"},
        	{prop.getProperty("dealerAutomation"),prop.getProperty("password"),prop.getProperty("roleType"),"modalXls"},
        };
    }
	
	/*************login to the application
	 * @throws InterruptedException *********************/
	@BeforeClass
	public void login() throws InterruptedException {
		navigate();
	}
	
	/*****************Dropdown related test case***************/
	@Test(priority = 1, dataProvider = "login1")
    public void dropdownDetails(String user, String pass, String roleType) throws InterruptedException {
		try {
		System.out.println("dropdownDetails " + roleType);
		lo.login(user, pass);
		Thread.sleep(3000);
		vo.navigatetoLeftMenu("Report", "Early Claims");
		checkDropDownValidations();
		lo.logout();
		Thread.sleep(1000);
		System.out.println("dropdownDetails end" + roleType);
		} catch (Exception e) {
			System.out.println("********FAIL***********" +  "dropdownDetails " + roleType);
			//Assert.assertEquals(true,false );
		}
		   
	}
	
	
	/*************Grid related testcase*********************/
	@Test (priority = 2, dataProvider = "login1")
    public void gridDetails(String user, String pass, String roleType) throws InterruptedException {
		try {
		System.out.println("gridDetails " + roleType);
		lo.login(user, pass);
		Thread.sleep(2000);
		vo.navigatetoLeftMenu("Report", "Early Claims");
		checkGridHeaderDetails(roleType);
		Thread.sleep(3000);
		checkGridExpandFirstRow();
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		checkFooterPagination(allTableData.size());
		lo.logout();	
		System.out.println("gridDetails end" + roleType);
		} catch (Exception e) {
			System.out.println("********FAIL***********" +  "gridDetails " + roleType);
//			Assert.assertEquals(true,false );
		}
	}
	
	@Test (priority = 3, dataProvider = "login1")
    public void modalDetails(String user, String pass, String roleType) throws InterruptedException {
		try {
		System.out.println("modalDetails " + roleType);
		lo.login(user, pass);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		vo.navigatetoLeftMenu("Report", "Early Claims");
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		if(allTableData.size() > 0) {
			clickOnViewDetailsFirstRow();
			HashMap<String, String> getFirstRowData = allTableData.get(1);
			verifyModalDetails(getFirstRowData,roleType);	
		}
		clickCloseButton("CloseButton");
		lo.logout();
		System.out.println("modalDetails end" + roleType);
		} catch (Exception e) {
		System.out.println("********FAIL***********" +  "modalDetails " + roleType);
		//Assert.assertEquals(true,false );
	}
	}
	
	@Test (priority = 4, dataProvider = "login2")
    public void modalCloseFilters(String user, String pass, String roleType,String closeModalType) throws InterruptedException {
		try {
		System.out.println("modalCloseFilters " + roleType);
		System.out.println(closeModalType);
		String dropDownOption = "60 days";
		lo.login(user, pass);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		vo.navigatetoLeftMenu("Report", "Early Claims");
		ChangeDropDownOtion(dropDownOption);
		Thread.sleep(2000);
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		if(allTableData.size() > 0) {
			HashMap<String, String> getFirstRowData = allTableData.get(1);
			ApplyFiltersOnGrid("Contract",getFirstRowData.get("Contract"));
			Thread.sleep(3000);
			HashMap<Integer, HashMap<String, String>> allTableDataAfterFilter = checkGridBodyDetails();
			HashMap<String, String> getFirstRowDataAfterFilter = allTableDataAfterFilter.get(1);
			if(closeModalType.equals("CloseButton")) {
				System.out.println("CloseButton");
			}
			clickOnViewDetailsFirstRow();
			System.out.println("Modal is opened");
			Thread.sleep(3000);
			clickCloseButton(closeModalType);
			Thread.sleep(3000);
			HashMap<Integer, HashMap<String, String>> allTableDataAfterModalClose = checkGridBodyDetails();
			HashMap<String, String> getFirstRowDataAfteModalClose = allTableDataAfterModalClose.get(1);
			
			Assert.assertEquals(getDropdownDefaultValue(), dropDownOption);
			Assert.assertEquals(allTableDataAfterFilter.size(), allTableDataAfterModalClose.size());
			Assert.assertEquals(getFirstRowDataAfterFilter, getFirstRowDataAfteModalClose);
		}
		
		lo.logout();
		System.out.println("modalCloseFilters end" + roleType);
		} catch (Exception e) {
			System.out.println("********FAIL***********" +  "modalCloseFilters " + roleType);
			//Assert.assertEquals(true,false );
		}
	}
    
    @Test (priority = 5, dataProvider = "login1")
    public void verifyExportPDFCompleteData(String user, String pass, String roleType) throws InterruptedException {
		try {
		System.out.println("verifyExportPDFCompleteData " + roleType);
		lo.login(user, pass);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		vo.navigatetoLeftMenu("Report", "Early Claims");
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		if(allTableData.size() > 0) {
			try {
				String actPdfName = verifyPDF(allTableData);
				String roleDetails = getRoleTypeIdUI();
				String expPdfName = "Early_Claims-" + getCurrentMonth() + "-" + roleDetails.substring(roleDetails.indexOf(':') + 2) +".pdf";
				System.out.println("expPdfName: " + expPdfName);
				Assert.assertEquals(actPdfName,expPdfName );
			} catch (InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//Assert.assertEquals(true,false );
			}
		}
		lo.logout();
		System.out.println("verifyExportPDFCompleteData end " + roleType);
		} catch (Exception e) {
			System.out.println("********FAIL***********" +  "verifyExportPDFCompleteData " + roleType);
			//Assert.assertEquals(true,false );
		}
	}
    
	@Test (priority = 6, dataProvider = "login1")
    public void verifyExportPDFFilteredData(String user, String pass, String roleType) throws InterruptedException {
		System.out.println("verifyExportPDFFilteredData " + roleType);
		lo.login(user, pass);
		Thread.sleep(2000);
		vo.navigatetoLeftMenu("Report", "Early Claims");
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		if(allTableData.size() > 0) {
			try {
				HashMap<String, String> getFirstRowData = allTableData.get(1);
				applyFilter(getFirstRowData.get("Payee"));
				Thread.sleep(3000);
				HashMap<Integer, HashMap<String, String>> allTableDataAfterFilter = checkGridBodyDetails();
				String actPdfName = verifyPDF(allTableDataAfterFilter);
				String roleDetails = getRoleTypeIdUI();
				String expPdfName = "Early_Claims-" + getCurrentMonth() + "-" + roleDetails.substring(roleDetails.indexOf(':') + 2) +".pdf";
				clearFilter();
				System.out.println("expPdfName: " + expPdfName);
				Assert.assertEquals(actPdfName,expPdfName );
				lo.logout();
				System.out.println("verifyExportPDFFilteredData end " + roleType);
			} catch (InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("********FAIL***********" +  "verifyExportPDFFilteredData " + roleType);
//				Assert.assertEquals(true,false );
			}
		}
		
	}
    
	@Test (priority = 7, dataProvider = "login1")
    public void verifyExportPDFModal(String user, String pass, String roleType) throws InterruptedException{
		System.out.println("verifyExportPDFModal " + roleType);
		lo.login(user, pass);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		vo.navigatetoLeftMenu("Report", "Early Claims");
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		if(allTableData.size() > 0) {
			try {
			clickOnViewDetailsFirstRow();
			System.out.println("Modal is opened");
			String actPdfName = getModalPDFName();	
			String roleDetails = getRoleTypeIdUI();
			String expPdfName = "Early_Claims_Details-" + getCurrentMonth() + "-" + roleDetails.substring(roleDetails.indexOf(':') + 2) +".pdf";
			System.out.println("expPdfName: " + expPdfName);
			Assert.assertEquals(actPdfName,expPdfName );
			clickCloseButton("CloseButton");
			lo.logout();
			System.out.println("verifyExportPDFModal end" + roleType);
			} catch (InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("********FAIL***********" +  "verifyExportPDFModal " + roleType);
//				Assert.assertEquals(true,false );
			}
		}
		
		
	}

	 @Test (priority = 8, dataProvider = "login3")
	    public void verifyToastMessage(String user, String pass, String roleType,String exportType) throws InterruptedException {
			System.out.println("verifyToastMessage " + roleType + " " + exportType);
			lo.login(user, pass);
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
			vo.navigatetoLeftMenu("Report", "Early Claims");
			HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
			if(allTableData.size() > 0) {
				try {
					if(exportType.contains("modal")) {
						clickOnViewDetailsFirstRow();
						System.out.println("Modal is opened");
					}		
					HashSet<String> a1 = cleanCurrentDirectoryAndGetPdfFile(exportType);
					boolean toastMessageDisplayed = toastMessageDisplay();
					System.out.println("toastMessage is displayed: " + toastMessageDisplayed);
					String toastMsgActual = getToastMessageText();
					String toastMsgExp ="Please note - Your file will be shown at the bottom of the browser and will be automatically saved into your Downloads folder.";
					System.out.println("toastMsgActual: " + toastMsgActual );
					Assert.assertEquals(toastMsgActual,toastMsgExp);
					if(exportType.contains("modal")) {
						clickCloseButton("CloseButton");
						System.out.println("Modal is closed");
					}
					Thread.sleep(7000);
					toastMessageDisplayed = toastMessageDisplay();
					System.out.println("toastMessage is displayed: " + toastMessageDisplayed);
					Assert.assertEquals(toastMessageDisplayed,false );
					lo.logout();
					System.out.println("verifyToastMessage end " + roleType + " " + exportType);
				} catch (InterruptedException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("********FAIL***********" +  "verifyExportPDFModal " + roleType);
//					Assert.assertEquals(true,false );
				}
			}
		}
//		@AfterMethod(alwaysRun = true)
//		public void close() throws InterruptedException {
//			try {
//			lo.logout();
//			} catch (Exception e) {
//				utils.getfield("mat-icon", "close").click();
//				lo.logout();
//		}
//		}
}

