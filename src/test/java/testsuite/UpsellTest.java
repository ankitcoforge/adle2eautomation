package testsuite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.EmployeePacksAction;
import pageActions.LateralMenuAction;
import pageActions.UpsellAction;
import pageActions.createContractAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.CalenderUtils;
import utils.utilityClass;

/* PBI NO - 30926 -Divyasree */
/* Total Tc's = 8 */
public class UpsellTest extends UpsellAction {
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();

	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction();
	LateralMenuAction lateralMenu = new LateralMenuAction();
	EmployeePacksAction EmplPacks = new EmployeePacksAction();
	createContractAction co = new createContractAction();
	CalenderUtils calenderUtils= new CalenderUtils();

	@BeforeClass(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}

	@Test(priority = 1)
	public void verifyCreationOfNewProgramInUpsell_32263() throws Exception {
		String admin = prop.getProperty("adminusername");
		login.login(admin, prop.getProperty("password"));
		Thread.sleep(3000);
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Account Management", "Upsell Exceptions");
		Thread.sleep(5000);
		Assert.assertTrue(utils.getTitle("Upsell Exceptions").isDisplayed());
		utils.getfield("span", "New program").click();
		Thread.sleep(3000);
		String program = "ACW";
		String upsellProgram = "ALP";
		utils.clickfield("xpath", programArrow);
		EmplPacks.selectProgramNew(program);
		Thread.sleep(2000);
		utils.clickfield("xpath", upsellProgramArrow);
		EmplPacks.selectProgramNew(upsellProgram);
		utils.getfield("span", " Save ").click();
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Upsell Exceptions").isDisplayed());
		getSearchBoxesInGrid().get("Program").sendKeys(program);
		getSearchBoxesInGrid().get("Upsell Program").sendKeys(upsellProgram);
		Thread.sleep(2000);
		getElementsFromGridBody().get(1).get("Program").getText().contains(program);
		getElementsFromGridBody().get(1).get("Upsell Program").getText().contains(upsellProgram);
	}

	@Test(priority = 2)
	public void verifyEditProgramInUpsell_32264() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Account Management", "Upsell Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Upsell Exceptions").isDisplayed());
		getEditBtn(1).click();
		Thread.sleep(3000);
		Assert.assertTrue(utils.getTitle("Edit").isDisplayed());
		utils.clickfield("xpath", calenderInPopup);
		String futureDate = calenderUtils.getCurrentDate(2,"MMM/dd/yyyy");
		calenderUtils.selectDate(futureDate,"MMM/dd/yyyy");
		utils.getfield("span", " Save ").click();
		Thread.sleep(3000);
		Assert.assertTrue(utils.getTitle("Upsell Exceptions").isDisplayed());
	}

	@Test(priority = 3)
	public void verifyDeleteProgramUpsell_32265() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Account Management", "Upsell Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Upsell Exceptions").isDisplayed());
		utils.getElementsList("cssselector", selectCheckBox).get(0).click();
		Assert.assertTrue(utils.getElementsList("cssselector", selectCheckBoxAttribute).get(0)
				.getAttribute("aria-checked").equals("true"));
		EmplPacks.getDeleteLink().click();
		EmplPacks.getBtnYes().click();
		Thread.sleep(5000);
	}

	@Test(priority = 4)
	public void verifyMultipleCheckBoxSelection_32362() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Account Management", "Upsell Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Upsell Exceptions").isDisplayed());
		utils.getElementsList("cssselector", selectCheckBox).get(0).click();
		utils.getElementsList("cssselector", selectCheckBox).get(1).click();
		utils.getElementsList("cssselector", selectCheckBox).get(2).click();
		Assert.assertTrue(utils.getElementsList("cssselector", selectCheckBoxAttribute).get(0)
				.getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(utils.getElementsList("cssselector", selectCheckBoxAttribute).get(1)
				.getAttribute("aria-checked").equals("true"));
		Assert.assertTrue(utils.getElementsList("cssselector", selectCheckBoxAttribute).get(2)
				.getAttribute("aria-checked").equals("true"));
	}

	
	@Test(priority = 5)
	public void verifyExportPDF_32363_32364() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Account Management", "Upsell Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Upsell Exceptions").isDisplayed());
		validatePDF();
		validateXlsx();
	}
	
	@Test(priority = 6)
	public void verifyUpsellProgramWithContractCreation_32211_32212_32213() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		Thread.sleep(3000);
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("Account Management", "Upsell Exceptions");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Upsell Exceptions").isDisplayed());
		Thread.sleep(3000);
		String program = "RR2";
		String upsellProgram = "RPG";
		getSearchBoxesInGrid().get("Program").sendKeys(program);
		getSearchBoxesInGrid().get("Upsell Program").sendKeys(upsellProgram);
		Thread.sleep(2000);
		HashMap<String, WebElement> gridRow = getElementsFromGridBody().get(1);
		if(!gridRow.get("Program").getText().contains(program) &&
				gridRow.get("Upsell Program").getText().contains(upsellProgram)) {
			createProgram(program,upsellProgram);
		}
		verticalMenu.navigatetoLeftMenu("Impersonate");
		impersonate.impersonateUser("Dealer", "78788");
		createContract();
		co.programSelect(upsellProgram);
		Thread.sleep(1000);
		Assert.assertTrue(getWarningLabel().isDisplayed());
		co.programSelect(program);
		Thread.sleep(2000);
		Assert.assertTrue(getProgramTable().isDisplayed(),"Only Program table displayed");
		getProgramTable().click();
		Assert.assertTrue(getProgramTableNew().isDisplayed());
		Assert.assertTrue(getUpsellProgramTable().isDisplayed(),"Upsell Program table displayed along with the related program table");
		//unselecting the primary program below
		co.programSelect(program);
		Thread.sleep(1000);
		Assert.assertTrue(getWarningLabel().isDisplayed());
	}
	

	
	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		 try {
				login.logout();
				} catch (Exception e) {
					if(utils.getfield("mat-icon", "close").isDisplayed()) {
					utils.getfield("mat-icon", "close").click();
					}
					login.logout();
			}
	    }

}
