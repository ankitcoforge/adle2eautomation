package testsuite;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utils.CalenderUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.ActuarialReportAction;
import pageActions.LateralMenuAction;
import pageActions.WebMileageExceptionAction;
import pageActions.cobuyerContractAction;
import pageActions.createContractAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import utils.CalenderUtils;
import utils.utilityClass;

public class ActuarialReport_test extends ActuarialReportAction{

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	impersonateAction impersonate = new impersonateAction();
	utilityClass utils = new utilityClass();
	CalenderUtils calander = new CalenderUtils();
	Permissions_test Permissions=new Permissions_test();
	LateralMenuAction lateralMenu = new LateralMenuAction();

	@BeforeMethod(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}

	@Test(priority = 1)
	public void verifyPage_18441_18442_18444_18445_18450_18451_18454() throws InterruptedException, ParseException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28236");
//		impersonate.impersonateUser("Dealer", "28771");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Report", "Actuarials");
		Thread.sleep(3000);
		Assert.assertTrue(utils.getTitle("Actuarials").isDisplayed());
		Assert.assertTrue(utils.getfield("h5", "Dealer Name").isDisplayed());
		Assert.assertTrue(utils.getfield("h5", "Dealer ID").isDisplayed());
		Assert.assertTrue(utils.getfield("h5", "Timeframe").isDisplayed());
		Thread.sleep(3000);
		Assert.assertTrue(getFromAndToField().getText().contains("From"));
		Assert.assertTrue(getFromAndToField().getText().contains("To"));
		Assert.assertTrue(getFromAndToFieldPositionedAfterTimeFrame().isDisplayed());
//		Assert.assertTrue(getTimeframePlaceholder().isDisplayed());
		//18506
	}
	
	@Test(priority = 2)
	public void verifyActuarialsNotDisplayedWhenNotGivenPermission_18455() throws InterruptedException, ParseException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Issue New User Registration");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Issue New User Registration").isDisplayed());
		String dealerEmp = prop.getProperty("dealerempAutomation");
		utils.inputfield("cssselector", Permissions.txtFieldNewUserRegistration, dealerEmp);
		Thread.sleep(2000);
		utils.clickfield("xpath", Permissions.editBtn);
		Thread.sleep(1000);
		Assert.assertTrue(Permissions.getEditPermissions().isDisplayed());
		utils.clickfield("xpath", Permissions.permissionsDropdownInPopup);

		if (Permissions.getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("true")) {
			Permissions.getSelectAllCheckBoxInPopup().click();
		}
		Assert.assertFalse(Permissions.getCheckboxesPermissions().get(1).isSelected());
		utils.clickfield("xpath", Permissions.saveBtn);
		Thread.sleep(5000);
		login.logout();
		Thread.sleep(10000);
		login.login(dealerEmp, prop.getProperty("password"));
		Thread.sleep(3000);
		verticalMenu.navigatetoLeftMainMenu("Report");
		List<WebElement> subMenuItemsList = lateralMenu.getLaterMenuSubItems();
		Assert.assertEquals(subMenuItemsList.size(), 0,"Atuarials not present");
	}
	
	@Test(priority = 3)
	public void verifyRemitMonthAndRemitYear_18459_18512() throws InterruptedException, ParseException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Report", "Actuarials");
		Thread.sleep(3000);
		Assert.assertTrue(utils.getTitle("Actuarials").isDisplayed());
		Assert.assertTrue(utils.element("xpath", "remitMonthTxt").isDisplayed());
		Assert.assertTrue(utils.element("xpath", "remitMonthGraph").isDisplayed());
		Assert.assertTrue(utils.element("xpath", "remitYearInception").isDisplayed());
		Assert.assertTrue(utils.element("xpath", "remitYearInceptionGraph").isDisplayed());
		}
	
	
	@Test(priority = 4)
	public void verifyDealerPrograms_18472_18473_18474_18478_18499_18503() throws InterruptedException, ParseException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Report", "Actuarials");
		Thread.sleep(3000);
		Assert.assertTrue(utils.getTitle("Actuarials").isDisplayed());
		utils.scrollDown();
		Assert.assertTrue(utils.getfield("h5", "Dealer Programs").isDisplayed());
		Assert.assertTrue(utils.element("xpath", "dealerProgramGrid").isDisplayed());
		Assert.assertTrue(utils.getfield("p", "The following table is a summary of data").isDisplayed());
		Thread.sleep(2000);
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<getHeaders().size(); i++) {
			String header = getHeaders().get(i);
			list.add(header);
		}
		System.out.println("Headers list :"+list);
		Assert.assertTrue(list.contains("Category"));
		Assert.assertTrue(list.contains("Program Name"));
		Assert.assertTrue(list.contains("Contract Count"));
		Assert.assertTrue(list.contains("Claims Paid ITD"));
		Assert.assertTrue(list.contains("Claim Frequency"));
		Assert.assertTrue(list.contains("Claim Severity"));
		Assert.assertTrue(list.contains("Reserve % Earned"));
		Assert.assertTrue(list.contains("Net ELR%"));
		}
	
	@Test(priority = 5)
	public void verifyGridInAcuarials_18479() throws InterruptedException, ParseException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Report", "Actuarials");
		Thread.sleep(3000);
		Assert.assertTrue(utils.getTitle("Actuarials").isDisplayed());
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 1800)");
		Thread.sleep(3000);
		 HashMap<Integer, HashMap<String, WebElement>> allTableData = getElementsFromGridBody();
		 String txtInTheFirstRow1stColoumn = allTableData.get(1).get("Category").getText();
		 int size = getSingleCategoryNameForMultiplePrograms(txtInTheFirstRow1stColoumn).size();
		 for(int i=1;i<size;i++) {
			 if(allTableData.get(i).get("Category").getText().equals(txtInTheFirstRow1stColoumn));
			 Assert.assertTrue(allTableData.get(i).get("Program Name").isDisplayed());
		 }
		}
	
	@Test(priority = 6)
	public void verifyColoumNamesInPage_18493() throws InterruptedException, ParseException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Report", "Actuarials");
		Thread.sleep(3000);
		Assert.assertTrue(utils.getTitle("Actuarials").isDisplayed());
		Assert.assertTrue(getColumnNames("Expired").isDisplayed());
		Assert.assertTrue(getColumnNames("Inforce").isDisplayed());
		Assert.assertTrue(getColumnNames("Grand Total").isDisplayed());
	}
	
	@Test(priority = 7)
	public void verifyPercentileSymbolInGrid_18502() throws InterruptedException, ParseException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Report", "Actuarials");
		Thread.sleep(3000);
		Assert.assertTrue(utils.getTitle("Actuarials").isDisplayed());
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 1400)");
		Thread.sleep(3000);
		 HashMap<Integer, HashMap<String, WebElement>> allTableData = getElementsFromGridBody();
		 for(int i=1;i<getSize();i++) {
			 Assert.assertTrue(allTableData.get(i).get("Claim Frequency").getText().contains("%"));
			 Assert.assertTrue(allTableData.get(i).get("Reserve % Earned").getText().contains("%"));
			 Assert.assertTrue(allTableData.get(i).get("Net ELR%").getText().contains("%"));
		 }
		}
	
	@Test(priority = 8)
	public void verifySearchBar_18741_18742_18743_18744_18745() throws InterruptedException, ParseException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "28771");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Report", "Actuarials");
		Thread.sleep(3000);
		Assert.assertTrue(utils.getTitle("Actuarials").isDisplayed());
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 900)");
		Thread.sleep(3000);
		Assert.assertTrue(getSearchBarBelowTheDescriptionTxt().isDisplayed());
		Assert.assertEquals(getSearchPlaceholder().getAttribute("placeholder"),"Search");
		 HashMap<Integer, HashMap<String, WebElement>> allTableData = getElementsFromGridBody();
		String txtInTheFirstRow1stColoumn = allTableData.get(1).get("Category").getText();
		String number = allTableData.get(1).get("Contract Count").getText();
		getSearchPlaceholder().sendKeys(txtInTheFirstRow1stColoumn);
		Thread.sleep(2000);
		Assert.assertTrue(getSize()>=1);
		 Assert.assertTrue(allTableData.get(1).get("Category").getText().equals(txtInTheFirstRow1stColoumn));
		 getSearchPlaceholder().clear();
		 getSearchPlaceholder().sendKeys("$");
		 Thread.sleep(2000);
		 Assert.assertTrue(getNoRecords().isDisplayed());
		 getSearchPlaceholder().clear();
		 getSearchPlaceholder().sendKeys(number);
		 Thread.sleep(2000);
		 Assert.assertTrue(getSize()>=1);
		 HashMap<Integer, HashMap<String, WebElement>> allTableData2 = getElementsFromGridBody();
		 Assert.assertTrue(allTableData2.get(1).get("Contract Count").getText().equals(number));
	}

	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		try {
			login.logout();
		} catch (Exception e) {
			if (utils.getfield("mat-icon", "close").isDisplayed()) {
				utils.getfield("mat-icon", "close").click();
			}
			login.logout();
		}
	}
}
