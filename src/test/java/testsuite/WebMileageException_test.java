package testsuite;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.EmployeePacksAction;
import pageActions.PricingPreferencesAction;
import pageActions.WebMileageExceptionAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import utils.CalenderUtils;
import utils.utilityClass;

/* 30505 Divyasree */
/* Total Tc's = 31 */

public class WebMileageException_test extends WebMileageExceptionAction{

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();

	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction();
	singleContractAction contract = new singleContractAction();
	EmployeePacksAction gridPacks = new EmployeePacksAction();
	PricingPreferencesAction preferences = new PricingPreferencesAction();
	CalenderUtils calenderUtils= new CalenderUtils();
	

	@BeforeMethod(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}

	@Test(priority = 1)
	public void verifyMileageExceptionPage_31267() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		enterRoleAndRoleID("Dealer","#1 Auto Liquidators LLC (85860)");
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			System.out.println("Exceptions are present");
		}
		else
		{
			System.out.println("No exceptions found");
		}
	}
	
	@Test(priority = 2)
	public void verifySearchBoxesInGrid_31268_31269_31270_31271_31272_31273_31379_31380_31274_31388() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		enterRoleAndRoleID("Dealer","#1 Auto Liquidators LLC (85860)");
		//System.out.println("row size---"+getRows().size());
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			preferences.getSelectAllCheckBox().click();
			gridPacks.getDeleteLink().click();
			gridPacks.getBtnYes().click();
			Thread.sleep(2000);
		}
		createNewException("UF3");

		HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
		
		
		String roleID = allTableDataTxt.get(1).get("Role ID");
		getSearchBoxesInGrid().get("Role ID").sendKeys(roleID);
		Thread.sleep(2000);
			String roleIDInGrid =  checkGridBodyDetailsTxt().get(1).get("Role ID");;
			Assert.assertTrue(roleIDInGrid.contains(roleID));
		getSearchBoxesInGrid().get("Role ID").clear();
		Thread.sleep(2000);
		
		String roleType = allTableDataTxt.get(1).get("Role Type");
		getSearchBoxesInGrid().get("Role Type").sendKeys(roleType);
		Thread.sleep(2000);
			String roleTypeInGrid =  checkGridBodyDetailsTxt().get(1).get("Role Type");;
			Assert.assertTrue(roleTypeInGrid.contains(roleType));
		getSearchBoxesInGrid().get("Role Type").clear();
		Thread.sleep(2000);
		
		String accountName = allTableDataTxt.get(1).get("Account Name");
		getSearchBoxesInGrid().get("Account Name").sendKeys(accountName);
		Thread.sleep(2000);
			String accountNameInGrid =  checkGridBodyDetailsTxt().get(1).get("Account Name");;
			Assert.assertTrue(accountNameInGrid.contains(accountName));
		getSearchBoxesInGrid().get("Account Name").clear();
		Thread.sleep(2000);
		
		String programCode = allTableDataTxt.get(1).get("Program Code");
		getSearchBoxesInGrid().get("Program Code").sendKeys(programCode);
		Thread.sleep(2000);
			String programCodeInGrid =  checkGridBodyDetailsTxt().get(1).get("Program Code");;
			Assert.assertTrue(programCodeInGrid.contains(programCode));
		getSearchBoxesInGrid().get("Program Code").clear();
		Thread.sleep(2000);
		
		String  mileageFrom= allTableDataTxt.get(1).get("Mileage From");
		NumberFormat formatMfrom = NumberFormat.getNumberInstance();
		Number numberFrom = formatMfrom.parse(mileageFrom);
		String mileageFromValue = numberFrom.toString();
		getSearchBoxesInGrid().get("Mileage From").sendKeys(mileageFromValue);
		Thread.sleep(2000);
			String mileageFromInGrid =  checkGridBodyDetailsTxt().get(1).get("Mileage From");
			NumberFormat formatMilFromGrid= NumberFormat.getNumberInstance();
			Number numberFromGrid = formatMilFromGrid.parse(mileageFromInGrid);
			String mileageFromValueGrid = numberFromGrid.toString();
			Assert.assertTrue(mileageFromValueGrid.contains(mileageFromValue));
		getSearchBoxesInGrid().get("Mileage From").clear();
		Thread.sleep(2000);
		
		String  mileageTo= allTableDataTxt.get(1).get("Mileage To");
		NumberFormat format = NumberFormat.getNumberInstance();
		Number number = format.parse(mileageTo);
		String mileageToValue = number.toString();
		getSearchBoxesInGrid().get("Mileage To").sendKeys(mileageToValue);
		Thread.sleep(2000);
			String mileageToInGrid =  checkGridBodyDetailsTxt().get(1).get("Mileage To");
			Number number2 = format.parse(mileageToInGrid);
			String mileageToInGridValue = number2.toString();
			Assert.assertTrue(mileageToInGridValue.contains(mileageToValue));
		getSearchBoxesInGrid().get("Mileage To").clear();
		Thread.sleep(2000);
		
		String ageFrom= allTableDataTxt.get(1).get("Age From");
		Thread.sleep(2000);
		System.out.println("age value is----"+ageFrom);
		getSearchBoxesInGrid().get("Age From").sendKeys(ageFrom);
		Thread.sleep(2000);
			String ageFromInGrid =  checkGridBodyDetailsTxt().get(1).get("Age From");;
			Assert.assertTrue(ageFromInGrid.contains(ageFrom));
		getSearchBoxesInGrid().get("Age From").clear();
		Thread.sleep(2000);
		
		String ageTo = allTableDataTxt.get(1).get("Age To");
		getSearchBoxesInGrid().get("Age To").sendKeys(ageTo);
		Thread.sleep(2000);
			String ageToInGrid =  checkGridBodyDetailsTxt().get(1).get("Age To");;
			Assert.assertTrue(ageToInGrid.contains(ageTo));
		getSearchBoxesInGrid().get("Age To").clear();
		Thread.sleep(2000);
		
		String modifiedBy= allTableDataTxt.get(1).get("Modified By");
		getSearchBoxesForModifiedBy().get("Modified By").sendKeys(modifiedBy);
		Thread.sleep(2000);
			String modifiedByInGrid =  checkGridBodyDetailsTxt().get(1).get("Modified By");;
			Assert.assertTrue(modifiedByInGrid.contains(modifiedBy));
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void verifyEditPage_31275_31395() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		enterRoleAndRoleID("Dealer","#1 Auto Liquidators LLC (85860)");
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			preferences.getSelectAllCheckBox().click();
			gridPacks.getDeleteLink().click();
			gridPacks.getBtnYes().click();
			Thread.sleep(2000);
		}
		createNewException("UF3");
		
		getEditBtn(1).click();
		Thread.sleep(2000);
		Assert.assertTrue(getRoleTypeInPopup().isDisplayed());
		Assert.assertTrue(getRoleIdInEditPopup().isDisplayed());
		Assert.assertTrue(getProgramcodeInPopup().isDisplayed());
		getMileageAndAgeFeilds().get(0).clear();
		getMileageAndAgeFeilds().get(0).sendKeys("100");
		getMileageAndAgeFeilds().get(1).clear();
		getMileageAndAgeFeilds().get(1).sendKeys("1000");
		getMileageAndAgeFeilds().get(2).clear();
		getMileageAndAgeFeilds().get(2).sendKeys("1");
		getMileageAndAgeFeilds().get(3).clear();
		getMileageAndAgeFeilds().get(3).sendKeys("12");
		Assert.assertTrue(getBtnSave().isEnabled());
		getBtnSave().click();
	}
	
	@Test(priority = 4)
	public void verifyDeleteFuctionality_31276_31277() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		enterRoleAndRoleID("Dealer","#1 Auto Liquidators LLC (85860)");
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			preferences.getSelectAllCheckBox().click();
			gridPacks.getDeleteLink().click();
			gridPacks.getBtnYes().click();
			gridPacks.getDeletedConfirmationMsg().isDisplayed();
			Thread.sleep(2000);
		}
		else {
		createNewException("UF3");
		gridPacks.getSelectCheckBoxes().get(0).click();
		gridPacks.getDeleteLink().click();
		gridPacks.getBtnYes().click();
		gridPacks.getDeletedConfirmationMsg().isDisplayed();
		Thread.sleep(3000);
		gridPacks.getSelectCheckBoxes().get(0).click();
		gridPacks.getSelectCheckBoxes().get(1).click();
		gridPacks.getDeleteLink().click();
		gridPacks.getBtnYes().click();
		gridPacks.getDeletedConfirmationMsg().isDisplayed();
		}
	}
	
	
	
	@Test(priority = 5)
	public void verifyCancelBtn_31384() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		enterRoleAndRoleID("Dealer","#1 Auto Liquidators LLC (85860)");
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			preferences.getSelectAllCheckBox().click();
			gridPacks.getDeleteLink().click();
			gridPacks.getBtnYes().click();
			Thread.sleep(2000);
		}
		createNewException("UF3");
		getEditBtn(1).click();
		Thread.sleep(2000);
		Assert.assertTrue(getRoleTypeInPopup().isDisplayed());
		Assert.assertTrue(getRoleIdInEditPopup().isDisplayed());
		Assert.assertTrue(getProgramcodeInPopup().isDisplayed());
		getMileageAndAgeFeilds().get(0).clear();
		getMileageAndAgeFeilds().get(0).sendKeys("100");
		getMileageAndAgeFeilds().get(1).clear();
		getMileageAndAgeFeilds().get(1).sendKeys("1000");
		getMileageAndAgeFeilds().get(2).clear();
		getMileageAndAgeFeilds().get(2).sendKeys("1");
		getMileageAndAgeFeilds().get(3).clear();
		getMileageAndAgeFeilds().get(3).sendKeys("12");
		getBtnCancel().click();
	}
	
	@Test(priority = 6)
	public void verifyPagination_31385() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		enterRoleAndRoleID("Dealer","#1 Auto Liquidators LLC (85860)");
		getRowsPerPageDropdownbtn().click();
		getRowsPerPageDropdownlist().get(0).click();
		Assert.assertTrue(getRowsPerPageSelected().getText().equals("25"), "25 is displayed in dropdown");
		Thread.sleep(2000);
		getRowsPerPageDropdownbtn().click();
		getRowsPerPageDropdownlist().get(1).click();
		Assert.assertTrue(getRowsPerPageSelected().getText().equals("50"), "25 is displayed in dropdown");
		Thread.sleep(2000);
		getRowsPerPageDropdownbtn().click();
		getRowsPerPageDropdownlist().get(2).click();
		Assert.assertTrue(getRowsPerPageSelected().getText().equals("100"), "25 is displayed in dropdown");
		
	}
	
	@Test(priority = 7)
	public void verifyNewExceptionCreation_31389_31394() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		enterRoleAndRoleID("Dealer","34159");
		Thread.sleep(3000);
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			preferences.getSelectAllCheckBox().click();
			gridPacks.getDeleteLink().click();
			gridPacks.getBtnYes().click();
			Thread.sleep(2000);
		}
		createNewException("Essentials");
	}
	
	@Test(priority = 8)
	public void verifyNewExceptionCancelBtn_31390() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		enterRoleAndRoleID("Dealer","#1 Auto Liquidators LLC (85860)");
		Thread.sleep(3000);
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			preferences.getSelectAllCheckBox().click();
			gridPacks.getDeleteLink().click();
			gridPacks.getBtnYes().click();
			Thread.sleep(2000);
		}
		
		getNewExceptionBtn().click();
		Thread.sleep(2000);
		getArrow().click();
		gridPacks.selectProgram();
		getMileageAndAgeFeilds().get(0).clear();
		getMileageAndAgeFeilds().get(0).sendKeys("100");
		getMileageAndAgeFeilds().get(1).clear();
		getMileageAndAgeFeilds().get(1).sendKeys("1000");
		getMileageAndAgeFeilds().get(2).clear();
		getMileageAndAgeFeilds().get(2).sendKeys("1");
		getMileageAndAgeFeilds().get(3).clear();
		getMileageAndAgeFeilds().get(3).sendKeys("12");
		getBtnCancel().click();
	}
	
	//bug
	@Test(priority = 9)
	public void verifyExceptionWithDealerEmplContract_31391() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		String dealerId = "34159";
		enterRoleAndRoleID("Dealer",dealerId);
		Thread.sleep(3000);
		Thread.sleep(2000);
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			preferences.getSelectAllCheckBox().click();
			gridPacks.getDeleteLink().click();
			gridPacks.getBtnYes().click();
			Thread.sleep(2000);
		}
		getNewExceptionBtn().click();
		selectProgramAndentertMileage("Essentials", "100", "1000");
		entertAge("0", "30");
		getBtnSave().click();
		Thread.sleep(2000);
		
		login.logout();
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("DealerEmp", dealerId);
		Thread.sleep(5000);

		verticalMenu.navigatetoContract();
		getProducts("5FNRL6H27NB019645","101");
		getPrograms("Essentials");
	}
	
	@Test(priority = 10)
	public void verifyExceptionWithLenderEmp_31392() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		String lenderId = "3641";
		enterRoleAndRoleID("Lender",lenderId);
		Thread.sleep(3000);
		Thread.sleep(2000);
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			preferences.getSelectAllCheckBox().click();
			gridPacks.getDeleteLink().click();
			gridPacks.getBtnYes().click();
			Thread.sleep(2000);
		}
		getNewExceptionBtn().click();
		selectProgramAndentertMileage("UF3", "100", "1000");
		entertAge("0", "10");
		getBtnSave().click();
		Thread.sleep(2000);
		
		login.logout();
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Thread.sleep(3000);
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("LenderEmp", lenderId);
		Thread.sleep(5000);

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		getProductsForLender("5FNRL6H27NB019645","101");
		getPrograms("UF3");
	}
	
	@Test(priority = 11)
	public void verifyExceptionReflectWithMileageForDealer_31589() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		String dealerId = "34159";
		enterRoleAndRoleID("Dealer",dealerId);
		Thread.sleep(3000);
		Thread.sleep(2000);
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			preferences.getSelectAllCheckBox().click();
			gridPacks.getDeleteLink().click();
			gridPacks.getBtnYes().click();
			Thread.sleep(2000);
		}
		getNewExceptionBtn().click();
		selectProgramAndentertMileage("Essentials", "100", "1000");
		getBtnSave().click();
		Thread.sleep(2000);
		
		Thread.sleep(3000);
		verticalMenu.navigatetoLeftMenu("Impersonate");
		impersonate.impersonateUser("Dealer", dealerId);
		Thread.sleep(5000);

		verticalMenu.navigatetoContract();
		getProducts("5FNRL6H27NB019645","101");
		getPrograms("Essentials");
	}

	
	@Test(priority = 12)
	public void verifyExceptionReflectWithAgeForDealer_31593_31594() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		String dealerId = "34159";
		enterRoleAndRoleID("Dealer",dealerId);
		Thread.sleep(3000);
		Thread.sleep(2000);
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			preferences.getSelectAllCheckBox().click();
			gridPacks.getDeleteLink().click();
			gridPacks.getBtnYes().click();
			Thread.sleep(2000);
		}
		getNewExceptionBtn().click();
		selectProgramAndentertMileage("Essentials", "0", "0");
		entertAge("0", "10");
		getBtnSave().click();
		Thread.sleep(10000);
		
		verticalMenu.navigatetoLeftMenu("Impersonate");
		impersonate.impersonateUser("Dealer", dealerId);
		Thread.sleep(5000);

		verticalMenu.navigatetoContract();
		getProducts("5FNRL6H27NB019645","0");
		getPrograms("Essentials");
	}

	@Test(priority = 13)
	public void verifyExceptionReflectWithMileageForLender_31595() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		String lenderId = "3641";
		enterRoleAndRoleID("Lender",lenderId);
		Thread.sleep(3000);
		Thread.sleep(2000);
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			preferences.getSelectAllCheckBox().click();
			gridPacks.getDeleteLink().click();
			gridPacks.getBtnYes().click();
			Thread.sleep(2000);
		}
		getNewExceptionBtn().click();
		selectProgramAndentertMileage("UF3", "500", "1000");
		entertAge("0", "10");
		getBtnSave().click();
		Thread.sleep(2000);
		
		Thread.sleep(3000);
		verticalMenu.navigatetoLeftMenu("Impersonate");
		impersonate.impersonateUser("Lender", lenderId);
		Thread.sleep(5000);

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		getProductsForLender("5GAKRDED0CJ396612","550");
		getPrograms("UF3");
	}

	
	@Test(priority = 14)
	public void verifyExceptionReflectWithAgeForLender_31597_31596() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		String lenderId = "3641";
		enterRoleAndRoleID("Lender",lenderId);
		Thread.sleep(3000);
		Thread.sleep(2000);
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			preferences.getSelectAllCheckBox().click();
			gridPacks.getDeleteLink().click();
			gridPacks.getBtnYes().click();
			Thread.sleep(2000);
		}
		getNewExceptionBtn().click();
		selectProgramAndentertMileage("UF3", "100", "1000");
		getBtnSave().click();
		Thread.sleep(2000);
		
		Thread.sleep(3000);
		verticalMenu.navigatetoLeftMenu("Impersonate");
		impersonate.impersonateUser("Lender", lenderId);
		Thread.sleep(5000);

		verticalMenu.navigatetoContract();
		contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
		getProductsForLender("5FNRL6H27NB019645","101");
		getPrograms("UF3");
	}
	
	@Test(priority = 15)
	public void verifyEffectiveDateFeild_31279() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		enterRoleAndRoleID("Dealer","34159");
		Thread.sleep(3000);
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			preferences.getSelectAllCheckBox().click();
			gridPacks.getDeleteLink().click();
			gridPacks.getBtnYes().click();
			Thread.sleep(2000);
		}
			//selectProgramNew("Essentials");;
			String selectedDate = createNewExceptionWithDate("Essentials",0);
		utils.clickfield("xpath", calenderUtils.calenderIcon);
		calenderUtils.selectDate(selectedDate,"MMM/dd/yyyy");
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
		String effectiveDateInGrid = allTableDataTxt.get(1).get("Prog Eff.Date");
		String formattedDateInGrid = calenderUtils.covertDateFromOneFormatToOther(effectiveDateInGrid,"MM/dd/yyyy","MMM/dd/yyyy");
		Assert.assertTrue(selectedDate.equalsIgnoreCase(formattedDateInGrid));
	}

	@Test(priority = 16)
	public void verifySortingAndUnsortingDate_31278_31280() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("Account Management", "Mileage & Age Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Mileage & Age Exceptions").isDisplayed());
		Thread.sleep(2000);
		enterRoleAndRoleID("Dealer","28771");
		if (!getNoRecordsInGrid().getText().contains("There are no records to display")) {
			preferences.getSelectAllCheckBox().click();
			gridPacks.getDeleteLink().click();
			gridPacks.getBtnYes().click();
			gridPacks.getDeletedConfirmationMsg().isDisplayed();
			Thread.sleep(2000);
		}
		createNewExceptionWithDate("RNL",0);
		createNewExceptionWithDate("UA3",3);
		getGridArrowBtn("Prog Eff.Date").click();
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
		ArrayList<String> dateList = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String date = allTableDataTxt.get(i).get("Prog Eff.Date");
			dateList.add(date);
		}
		ArrayList<String> dateListBeforeSort = dateList;
		System.out.println(dateListBeforeSort);
		Collections.sort(dateList);
		System.out.println(dateList);
		Assert.assertEquals(dateListBeforeSort,dateList);
		Thread.sleep(2000);
		
		getGridArrowBtn("Prog Eff.Date").click();
		HashMap<Integer, HashMap<String, String>> allTableDataTxtOnArrowClick2 = checkGridBodyDetailsTxt();
		ArrayList<String> dateListOnArrowClick2 = new ArrayList<String>();
		for (int i = 1; i <= getRowLoc().size(); i++) {
			String date = allTableDataTxtOnArrowClick2.get(i).get("Prog Eff.Date");
			dateListOnArrowClick2.add(date);
		}
		System.out.println(dateListOnArrowClick2);
		Collections.reverse(dateList);
		System.out.println(dateList);
		Assert.assertTrue(dateListOnArrowClick2.equals(dateList));
	}
	
	

	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		try {
		login.logout();
		}
		catch (Exception e) {
			
		}
	}

	
	
}
