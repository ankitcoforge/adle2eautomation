package testsuite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageActions.earlyClaimsAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;

public class earlyClaims_test extends earlyClaimsAction{

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	
	@DataProvider(name="login1")
    public Object[][] getData() {
        return new Object[][] {
     {prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("roleType")},
     {prop.getProperty("agentusername"),prop.getProperty("agentpassword"),prop.getProperty("roleTypeAgent")},
     {prop.getProperty("lenderusername"),prop.getProperty("lenderpassword"),prop.getProperty("roleTypeLender")},
     {prop.getProperty("dealerempusername"),prop.getProperty("dealeremppassword"),prop.getProperty("roleTypeDealerEmp")},
				 
        };
    }
	
	@DataProvider(name="login2")
    public Object[][] getData2() {
        return new Object[][] {
        	{prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("roleType"),"XIcon"},
        	{prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("roleType"),"CloseButton"},
        };
    }
	
	/*************login to the application
	 * @throws InterruptedException *********************/
	@BeforeClass
	public void login() throws InterruptedException {
		navigate();
	}
	
	/*****************Dropdown related test case***************/
	//@Test(priority = 1, dataProvider = "login1")
    public void dropdownDetails(String user, String pass, String roleType) throws InterruptedException {
		System.out.println("dropdownDetails " + roleType);
		lo.login(user, pass);
		Thread.sleep(3000);
		vo.navigatetoLeftMenu("Reports", "Early Claims");
		checkDropDownValidations();
		lo.logout();
		Thread.sleep(1000);
		System.out.println("dropdownDetails end" + roleType);
		   
	}
	
	
	/*************Grid related testcase*********************/
	//@Test (priority = 2, dataProvider = "login1")
    public void gridDetails(String user, String pass, String roleType) throws InterruptedException {
		System.out.println("gridDetails " + roleType);
		lo.login(user, pass);
		Thread.sleep(2000);
		vo.navigatetoLeftMenu("Reports", "Early Claims");
		checkGridHeaderDetails(roleType);
		Thread.sleep(3000);
		checkGridExpandFirstRow();
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		checkFooterPagination(allTableData.size());
		lo.logout();	
		System.out.println("gridDetails end" + roleType);
	}
	
	//@Test (priority = 3, dataProvider = "login1")
    public void modalDetails(String user, String pass, String roleType) throws InterruptedException {
		System.out.println("modalDetails " + roleType);
		lo.login(user, pass);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		vo.navigatetoLeftMenu("Reports", "Early Claims");
		HashMap<Integer, HashMap<String, String>> allTableData = checkGridBodyDetails();
		if(allTableData.size() > 0) {
			clickOnViewDetailsFirstRow();
			HashMap<String, String> getFirstRowData = allTableData.get(1);
			verifyModalDetails(getFirstRowData,roleType);	
		}
		clickCloseButton("CloseButton");
		lo.logout();
		System.out.println("modalDetails end" + roleType);
	}
	
	//@Test (priority = 4, dataProvider = "login2")
    public void modalCloseFilters(String user, String pass, String roleType,String closeModalType) throws InterruptedException {
		System.out.println("modalCloseFilters " + roleType);
		System.out.println(closeModalType);
		String dropDownOption = "60 days";
		lo.login(user, pass);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		vo.navigatetoLeftMenu("Reports", "Early Claims");
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
	}
    
   @Test (priority = 5, dataProvider = "login1")
    public void verifyExportPDFCompleteData(String user, String pass, String roleType) throws InterruptedException {
		System.out.println("verifyExportPDFCompleteData " + roleType);
		lo.login(user, pass);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		vo.navigatetoLeftMenu("Reports", "Early Claims");
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
				Assert.assertEquals(true,false );
			}
		}
		lo.logout();
		System.out.println("verifyExportPDFCompleteData end " + roleType);
	}
    
  @Test (priority = 6, dataProvider = "login1")
    public void verifyExportPDFFilteredData(String user, String pass, String roleType) throws InterruptedException {
		System.out.println("verifyExportPDFFilteredData " + roleType);
		lo.login(user, pass);
		Thread.sleep(2000);
		vo.navigatetoLeftMenu("Reports", "Early Claims");
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
			} catch (InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.assertEquals(true,false );
			}
		}
		lo.logout();
		System.out.println("verifyExportPDFFilteredData end " + roleType);
	}
    
	@Test (priority = 7, dataProvider = "login1")
    public void verifyExportPDFModal(String user, String pass, String roleType) throws InterruptedException{
		System.out.println("verifyExportPDFModal " + roleType);
		lo.login(user, pass);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		vo.navigatetoLeftMenu("Reports", "Early Claims");
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
			} catch (InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.assertEquals(true,false );
			}
		}
		
		lo.logout();
		System.out.println("verifyExportPDFModal end" + roleType);
	}

}
